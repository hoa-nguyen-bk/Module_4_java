package controllers;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import businessLogic.AuthorBL;
import javaBeans.Author;

@RestController
public class AuthorRestController {
	@GetMapping("/authors_rest")
	public List<Author> authorRest(){
		return AuthorBL.getAuthors();
	}
	@GetMapping("/authors_rest2")
	public Map<String, List<Author>> authorRest2(){
		Map<String, List<Author>> m = new Hashtable<>();
		m.put("authors", AuthorBL.getAuthors());
		return m;
	}
	@GetMapping("/authors_rest/{id}")
	public Author detailAuthorRest(@PathVariable (name = "id") int id){
		Author at = AuthorBL.getAuthor(id);
		return at;
	}
	@PostMapping("/add-author")
	public int addAuthorRest(@RequestBody Author at){
		return AuthorBL.add(at);
	}
}
