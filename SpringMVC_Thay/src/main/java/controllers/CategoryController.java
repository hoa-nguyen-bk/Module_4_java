package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogic.CategoryBL;
import businessLogic.ProductBL;
import javaBeans.Category;
import javaBeans.Product;

@Controller
public class CategoryController {
	@RequestMapping(path = "add-category")
	public String addCategory(Model model) {
		Category c = new Category();
		List<Category> parents = CategoryBL.getParents();
		model.addAttribute("c", c);
		model.addAttribute("parents", parents);
		return "add-category";
	}

	@RequestMapping(path = "/index.html")
	public String index(Model model, @RequestParam(name = "trang", defaultValue = "1", required = false) String page,
			@RequestParam(name = "categoryId", defaultValue = "0", required = false) int categoryId) {
		// @RequestParam: Đây là annotation dùng để chỉ định rằng một tham số của HTTP
		// request sẽ được ánh xạ vào biến của phương thức trong controller. Trong
		// trường hợp này, tham số từ URL có tên là "trang" sẽ được ánh xạ vào biến t.
		// trang ở đây mặc định là 1
		int trang = Integer.parseInt(page);
		List<Category> parents = CategoryBL.getParents();
		List<Category> children = CategoryBL.getChildrens();
//		List<Product> products = ProductBL.getAll();
		List<Product> products;
		if (categoryId == 0) {
			products = ProductBL.productTheoTrangSo(trang);
		} else {
			products = ProductBL.productTheoCategoryId(categoryId);
		}
		model.addAttribute("parents", parents);
		model.addAttribute("children", children);
		model.addAttribute("products", products);
		model.addAttribute("tongSoTrang", ProductBL.tongSoTrang());
		return "index.html";
	}
}
