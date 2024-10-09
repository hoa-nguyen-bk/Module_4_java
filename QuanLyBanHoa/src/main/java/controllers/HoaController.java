package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.HoaBL;
import businessLogics.LoaiHoaBL;
import javaBeans.Hoa;
import javaBeans.LoaiHoa;

@Controller
public class HoaController {
	@RequestMapping(path= {"/", "/trang-chu.jsp"})
	public String trangChu(Model model) {
		List<Hoa> dsHoa = HoaBL.getHoas();
		dsHoa.forEach(h->System.out.println(h.getTenHoa()));
		model.addAttribute("dsHoa",dsHoa);
		List<LoaiHoa> dsLoaiHoas = LoaiHoaBL.getLoaiHoas();
		dsLoaiHoas.forEach(h->System.out.println(h.getTenLoai()));
		model.addAttribute("dsLoaiHoas",dsLoaiHoas);
		return "redirect:/trang-chu.jsp";
	}
	@RequestMapping("/hoa-theo-loai")
	public String hoaTheoLoai(Model model, @RequestParam(name = "maLoai",required = false) String maLoai) {
		List<Hoa> dsHoa = HoaBL.getHoas();
		dsHoa.forEach(h->System.out.println(h.getTenHoa()));
		model.addAttribute("dsHoa",dsHoa);
		List<LoaiHoa> dsLoaiHoas = LoaiHoaBL.getLoaiHoas();
		dsLoaiHoas.forEach(h->System.out.println(h.getTenLoai()));
		model.addAttribute("dsLoaiHoas",dsLoaiHoas);
		return "hoa-theo-loai";
	}
	@RequestMapping("/them-hoa-moi")
	public String themHoaMoi(Model model) {
		return "them-hoa";
	}
	@RequestMapping(path="/them-hoa-moi",method = RequestMethod.POST)
	public String themHoaMoi(HttpServletRequest request) {
		return "redirect:/trang-them-hoa-moi.jsp";
	}
}
