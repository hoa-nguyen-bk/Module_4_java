package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendEmailController {
	@Autowired
	private JavaMailSender mailSender;
	
//	@RequestMapping("sendmail")
//	public String
}
