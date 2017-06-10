package lab.io.rush.moana.controller;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lab.io.rush.moana.entity.Customer;
import lab.io.rush.moana.entity.Email;
import lab.io.rush.moana.service.CustomerService;
import lab.io.rush.moana.service.MailService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	public static final String FROMADDRESS = "xcwzy@qq.com";

	public static final int TIMELIMIT = 1000 * 60 * 60 * 24; 

	public static final String URL = "http://localhost:8080/moana/customer/activate.do";

	public static final String SUBJECT = "Movie邮箱激活";
	@Autowired
	CustomerService customerService;
	@Autowired
	MailService mailService;

	@RequestMapping("/showUser.do")
	public String toIndex(HttpServletRequest request, Model model) {
		boolean result = customerService.deleteCustomer("1");
		System.out.println(result);
		return "showUser";
	}
	/**
	 * ???
	 * @param request
	 * @param model
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, Model model) throws MessagingException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Customer customer = customerService.getCustomer(id);
		String pwd = DigestUtils.md5Hex(password);
		if(customer==null){
			return "login_fail";
		}else{
			if(customer.getStatus()==0){
				return "login_confirm";
			}else if(!pwd.equals(customer.getPassword())){
				//????????????
				return "login_fail";
			}
			request.getSession().setAttribute("nickname", customer.getNickname());
			request.getSession().setAttribute("id", customer.getCustomer_id());
			return "index";
		}
		
	}
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	@RequestMapping("/register.do")
	public String register(HttpServletRequest request, Model model) throws MessagingException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		Customer customer = customerService.getCustomer(id);
		if(customer==null){
			customer = new Customer();
			customer.setCustomer_id(id);
			customer.setPassword(DigestUtils.md5Hex(password));
			customer.setStatus(1);
			customer.setNickname(nickname);
			Customer temp = sendActivateMail(customer);
			customerService.saveCustomer(temp);
		}else{
			return "register_fail";
		}
		model.addAttribute("nickname", nickname);
		model.addAttribute("email", id);
		return "confirm";
	}
	/**
	 * @param customer
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	public Customer sendActivateMail(Customer customer) throws MessagingException, IOException {
		String toAddress = customer.getCustomer_id();
		Long curTime =  System.currentTimeMillis();
		Long activateTime = curTime + TIMELIMIT;
		String token = toAddress + curTime;
		customer.setToken(DigestUtils.md5Hex(token));
		customer.setCreateDate(new Date());
		token = customer.getToken();
		customer.setActivateTime(activateTime);
		String content = "Movie激活<br><a href='" + URL + "?email=" + toAddress + "&token=" + token
				+ "'a> "+ URL + "?email=" + toAddress + "&token=" + token +"</a><br>点击网址激活";
		Email email = new Email();
		email.setFromAddress(FROMADDRESS);
		email.setToAddress(toAddress);
		email.setSubject(SUBJECT);
		email.setContent(content);
		mailService.sendMail(email);
		return customer;
	}
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	@RequestMapping("/activate.do")
	public String activate(HttpServletRequest request, Model model) throws MessagingException, IOException {
		String email = request.getParameter("email");
		String token = request.getParameter("token");
		Long time = System.currentTimeMillis();
		Customer customer = customerService.getCustomer(email);
		if(customer!=null){
			if(customer.getStatus()==0&&customer.getActivateTime()!=1){
				if(customer.getActivateTime()<time){
					customer.setActivateTime(Long.parseLong("-1"));
					customer = sendActivateMail(customer);
					customerService.updateCustomer(customer);;
				}else if(customer.getActivateTime()>time){
					customer.setActivateTime(Long.parseLong("1"));
					System.out.println("test1");
					if(customer.getToken().equals(token)){
						customer.setStatus(1);
						customer.setCreateDate(new Date());
						customer.setToken(token.replace("1", "c"));
						customerService.updateCustomer(customer);
					}else{
					}
				}
			}else if(customer.getStatus()==1){
			}
		}else if(customer==null){
		}
		
		return "login";
	}
	@RequestMapping("/redirect.do")
	public String redirect(@RequestParam("pagename") String pagename) {
		return pagename;
	}
}
