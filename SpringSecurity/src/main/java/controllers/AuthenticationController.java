package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {
	@RequestMapping(path = "/auth/register.html")
	public String authRegister() {
		return "/auth/Register";
	}
}
