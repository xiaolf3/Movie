package lab.io.rush.moana.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lab.io.rush.moana.entity.Email;
import lab.io.rush.moana.entity.Movie;
import lab.io.rush.moana.entity.Order;
import lab.io.rush.moana.entity.Screen;
import lab.io.rush.moana.service.MailService;
import lab.io.rush.moana.service.MovieService;
import lab.io.rush.moana.service.OrderService;
import lab.io.rush.moana.service.ScreenService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	MovieService movieService;

	@Autowired
	ScreenService screenService;
	@Autowired
	MailService mailService;

	public static final String FROMADDRESS = "xcwzy@qq.com";

	@RequestMapping("/showMovie.do")
	public String toIndex(HttpServletRequest request, Model model) {
		return "showUser";
	}

	@RequestMapping("/order.do")
	public String order(@RequestParam("customer_id") String customer_id, @RequestParam("movie_id") Integer movie_id,
			@RequestParam("screen_id") Integer screen_id, @RequestParam("unit") Integer unit, Model model) throws MessagingException, IOException {
		Screen screen = screenService.getScreen(screen_id);
		List<Order> temp = orderService.getOrdersByMovieAndCustomer(customer_id, movie_id);
		if (temp.size() == 2) {
			return "order_fail";
		} else if (temp.size() == 1) {
			float total = screen.getPrice() * unit;
			String seat_number = "";
			if (unit == 1) {
				seat_number = seat_number + screen.getSeat();
				screen.setSeat(screen.getSeat() - 1);
				screenService.updateScreen(screen);
				Order order = new Order();
				order.setMovie_id(movie_id);
				order.setScreen_id(screen_id);
				order.setCustomer_id(customer_id);
				order.setTotal(total);
				order.setUnits(unit);
				order.setSeat_number(seat_number);
				orderService.saveOrder(order);
				Order o = orderService.getOrder(order.getOrder_id());
				Movie movie = movieService.getMovie(o.getMovie_id());
				Email email = new Email();
				email.setFromAddress(FROMADDRESS);
				email.setToAddress(customer_id);
				email.setSubject("¶©Æ±³É¹¦");
				String email_content = "¹§Ï²Äú£¬¶©Æ±³É¹¦<br>" + movie.getTitle() + "<br>" + screen.getHall() + "ºÅÌü<br>"
						+ seat_number + "ºÅ×ù<br>";
				email.setContent(email_content);
				mailService.sendMail(email);
				model.addAttribute("order", o);
				model.addAttribute("movie", movie);
				model.addAttribute("screen", screen);
				return "order";
			} else {
				return "order_fail";
			}
		} else {
			float total = screen.getPrice() * unit;
			String seat_number = "";
			if (unit == 1) {
				seat_number = seat_number + screen.getSeat();
				screen.setSeat(screen.getSeat() - 1);
				screenService.updateScreen(screen);
			} else {
				int t = screen.getSeat();
				System.out.println("--------------------------"+t);
				seat_number = seat_number + t + " , " + (t - 1);
				System.out.println("--------------------------"+seat_number);
				screen.setSeat(screen.getSeat() - 2);
				screenService.updateScreen(screen);
			}
			Order order = new Order();
			order.setMovie_id(movie_id);
			order.setScreen_id(screen_id);
			order.setCustomer_id(customer_id);
			order.setTotal(total);
			order.setUnits(unit);
			order.setSeat_number(seat_number);
			orderService.saveOrder(order);
			Order o = orderService.getOrder(order.getOrder_id());
			Movie movie = movieService.getMovie(o.getMovie_id());

			Email email = new Email();
			email.setFromAddress(FROMADDRESS);
			email.setToAddress(customer_id);
			email.setSubject("¶©Æ±³É¹¦");
			String email_content = "¹§Ï²Äú£¬¶©Æ±³É¹¦<br>" + movie.getTitle() + "<br>" + screen.getHall() + "ºÅÌü<br>"
					+ seat_number + "ºÅ×ù<br>";
			email.setContent(email_content);
			mailService.sendMail(email);
			model.addAttribute("order", o);
			model.addAttribute("movie", movie);
			model.addAttribute("screen", screen);
			return "order";
		}

	}

	@RequestMapping("/redirect.do")
	public String redirect(@RequestParam("pagename") String pagename) {
		return pagename;
	}

}
