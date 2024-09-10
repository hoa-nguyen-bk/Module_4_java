package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loai-sua")
public class AnhXaChung {
	@RequestMapping("/them")
	public String them(Model model) {
		model.addAttribute("tb", "Thêm loại sữa");		// request.setAttribute("tb","Thêm loại sữa")
		return "anh-xa-chung";							// request.getRequestDispatcher("WEB-INF/views/anh-xa-chung.jsp").forward(request,response);
	}

	@RequestMapping("/tim")
	public String tim(Model model) {
		model.addAttribute("tb", "Tìm loại sữa");
		return "anh-xa-chung";
	}

	@RequestMapping("/xoa")
	public String xoa(Model model) {
		model.addAttribute("tb", "Xóa loại sữa");
		return "anh-xa-chung";
	}
}
