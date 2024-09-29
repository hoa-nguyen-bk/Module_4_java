package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogic.TiGiaBL;
import javaBeans.TiGia;

@Controller
public class TiGiaController {
	@RequestMapping(path="/ti-gia")
	public String tiGia(Model model) {
		List<TiGia> dstg = TiGiaBL.docTatCa();
		model.addAttribute("tiGias",dstg);
		return "ti-gia";
	}
}
