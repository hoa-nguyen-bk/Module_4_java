package controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import businessLogic.AuthorBL;
import javaBeans.Author;

@RestController
public class AuthorRestController {
	@GetMapping("/authors_rest")
	public List<Author> authorRest(){
		return AuthorBL.getAuthors();
	}
}
