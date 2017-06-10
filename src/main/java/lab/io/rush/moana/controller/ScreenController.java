package lab.io.rush.moana.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lab.io.rush.moana.entity.Movie;
import lab.io.rush.moana.entity.Order;
import lab.io.rush.moana.entity.Screen;
import lab.io.rush.moana.service.MovieService;
import lab.io.rush.moana.service.OrderService;
import lab.io.rush.moana.service.ScreenService;

@Controller  
@RequestMapping("/screen")  
public class ScreenController {
	@Autowired
    ScreenService screenService;
	@Autowired
    MovieService movieService;
	@Autowired
    OrderService orderService;
    @RequestMapping("/showScreen.do")  
    public String toIndex(HttpServletRequest request,Model model){ 
    	
    	Order order = orderService.getOrder(1);
    	System.out.println(order);
    	return "showUser";
    }  
    /**
     * @param movie_id
     * @param model
     * @return
     */
    @RequestMapping("/getAllScreens.do")  
    public String getAllScreens(@RequestParam("movie_id") Integer movie_id,Model model){ 
    	List<Screen> screens = screenService.getAllScreens(movie_id);
    	Movie movie = null;
    	movie = movieService.getMovie(movie_id);
    	List<Screen> screens_result = new ArrayList<>();
    	Long current = System.currentTimeMillis();
    	for(int i=0;i<screens.size();i++){
    		Long date = screens.get(i).getDate().getTime();
    		if(date>=current){
    			screens_result.add(screens.get(i));
    		}
    	}
    	model.addAttribute("movie",movie);
    	model.addAttribute("screens", screens_result);
    	return "screen";
    }  
    @RequestMapping("/redirect.do")
	public String redirect(@RequestParam("pagename") String pagename) {
		return pagename;
	}
}
