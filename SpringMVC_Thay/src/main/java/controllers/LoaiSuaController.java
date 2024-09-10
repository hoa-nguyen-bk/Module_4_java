package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogic.LoaiSuaBL;
import javaBeans.LoaiSua;

@Controller
public class LoaiSuaController {
	@RequestMapping(path = "/them-loai-sua", method = RequestMethod.GET)
	public String themLoaiSua() {
		// nó trả về bộ giải quyết view, chỗ này chỉ trả về tên view thui nhen, chú ý kỹ
		// kẻo rối
		return "them-loai-sua"; // --> viewResolver : prefix + view name + suffix --> "/WEB-INF/views/" +
								// "them-loai-sua" + ".jsp" --> /WEB-INF/views/them-loai-sua.jsp
	}

	@RequestMapping(path = "/them-loai-sua", method = RequestMethod.POST)
	public String themLoaiSua(HttpServletRequest request) {
		String ml, tl;
		ml = request.getParameter("maLoai");
		tl = request.getParameter("tenLoai");
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(ml);
		ls.setTenLoai(tl);
		LoaiSuaBL.them(ls);
		return "them-loai-sua";
	}

	//sửa lại theo tham số yếu cầu
	@RequestMapping(path = "/them-loai-sua-requestparam", method = RequestMethod.GET)
	public String themLoaiSuaRequestParam() {
		// nó trả về bộ giải quyết view, chỗ này chỉ trả về tên view thui nhen, chú ý kỹ
		// kẻo rối
		return "them-loai-sua-requestparam"; // --> viewResolver : prefix + view name + suffix --> "/WEB-INF/views/" +
								// "them-loai-sua" + ".jsp" --> /WEB-INF/views/them-loai-sua.jsp
	}

	@RequestMapping(path = "/them-loai-sua-requestparam", method = RequestMethod.POST)
	public String themLoaiSuaRequestParam(@RequestParam(name="maLoai") String ml, @RequestParam(name="tenLoai") String tl) {
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(ml);
		ls.setTenLoai(tl);
		LoaiSuaBL.them(ls);
		return "them-loai-sua-requestparam";
	}

	
	// chỗ này tức là nếu tham số có maLoai = thì lấy cái mã loại đó, ntn /loai-sua?maLoai=SB 
	@RequestMapping(path = "/loai-sua")
	public String loaiSua(Model model,
			@RequestParam(name = "maLoai", defaultValue = "", required = false) String maLoai) {
		List<LoaiSua> dsls;
		if (maLoai.isEmpty()) {
			//còn ko lấy ?maLoai thì lấy hết
			dsls = LoaiSuaBL.docTatCa();
		} else {
			LoaiSua ls = LoaiSuaBL.docTheoMaLoai(maLoai);
			dsls = new ArrayList<LoaiSua>();
			dsls.add(ls);
		}
		model.addAttribute("dsls", dsls);
		return "loai-sua";
	}

	// này là để xem duy nhất chỉ mỗi 1 sữa thôi, thì nhập cái mã sữa lên theo dạng
	// requestMapping ở dưới đó
	// cái khó của dạng này là link có nhìu // thì khó xài
	@RequestMapping(path = "/loai-sua/{ml}")
	public String loaiSua(@PathVariable(name = "ml") String ml, Model model) {
		LoaiSua ls = LoaiSuaBL.docTheoMaLoai2(ml);
		List<LoaiSua> dsls = new ArrayList<LoaiSua>();
		dsls.add(ls);
		model.addAttribute("dsls", dsls);
		return "loai-sua";
	}
}
