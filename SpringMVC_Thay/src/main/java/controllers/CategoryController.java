package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogic.CategoryBL;
import javaBeans.Category;

@Controller
public class CategoryController {
	@RequestMapping(path="add-category")
	public String addCategory(Model model) {
		Category c = new Category();
		List<Category> parents = CategoryBL.getParents();
		model.addAttribute("c",c);
		model.addAttribute("parents",parents);
		return "add-category";
	}
}
