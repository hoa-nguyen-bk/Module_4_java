package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "home"; // --> viewResolver: prefix + suffix --> "/WEB-INF/views/" + "home" + ".jsp" --> WEB-INF/views/home.jsp
		// request.getRequestDispatcher("views/gio-hang.jsp").include(request,response)
	}
}
