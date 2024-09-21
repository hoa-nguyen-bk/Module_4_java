package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogic.ProductBL;
import javaBeans.Product;


@Controller
public class ProductController {
	@RequestMapping(path = "/detail.html")
	public String getProductId( @RequestParam(name = "productId", defaultValue = "1", required = false) int productId, Model model) {
		Product product = ProductBL.getProduct(productId);
		model.addAttribute("product", product);
		return "detail.html";
	}
}
