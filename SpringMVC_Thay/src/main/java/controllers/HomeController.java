package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(path = {"/","/home","/home.htm"})
	public String home() {
		return "home";			//--> viewResolver :  prefix + view name + suffix --> "/WEB-INF/views/" + "home" + ".jsp" --> /WEB-INF/views/home.jsp
	}
}
