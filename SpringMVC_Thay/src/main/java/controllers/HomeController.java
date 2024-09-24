package controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@ModelAttribute
	public void fontChu(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(path = { "/", "/home", "/home.htm" })
	public String home() {
//		return "home";			//--> viewResolver :  prefix + view name + suffix --> "/WEB-INF/views/" + "home" + ".jsp" --> /WEB-INF/views/home.jsp
		return "nha"; // phải tách ra trả về trang nhà, trả về cái tên định nghĩa trong tiles, ví dụ ở
						// đây là trang nha
	}

	@RequestMapping(path = "/setCookie")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		// mình mún lấy cookie nào thì lấy tên giá trị, xong gấn cái cần trả lời
		Cookie cook1 = new Cookie("tenDV", "Trung_tam_tin_hoc");
		cook1.setMaxAge(3600 * 24 * 30);// tính bằng giây
		response.addCookie(cook1);
		return "đã thiết lập cookie";
	}

	// lấy cookie
	@RequestMapping(path = "/getCookie")
	@ResponseBody
	public String getCookie(HttpServletRequest request) {
		// mình mún lấy cookie nào thì lấy tên giá trị, xong gấn cái cần trả lời
		Cookie[] mangCookie = request.getCookies();// khi tự động mở server nó tự động gửi lên, gửi lên cũng ko báo, gửi
													// xún cũng ko báo, nhưng mà nó chắc chắn nằm trong đối tượng
													// request này
		String s = "";
		for (Cookie ck : mangCookie) {
			if (ck.getName().equals("tenDV"))
				s += ck.getName() + " - " + ck.getValue() + "\n";
		}
		return s;
	}

	// lấy cookie theo tên cookie only
	@RequestMapping(path = "/getCookieValue")
	@ResponseBody
	public String getCookie(@CookieValue(name = "tenDV") String tenDV) {
		// mình mún lấy cookie nào thì lấy tên giá trị, xong gấn cái cần trả lời
		return tenDV;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String dangNhap() { // tên phương thức
		return "trangDangNhap";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String dangNhap(HttpServletRequest request, HttpServletResponse response) { // tên phương thức
		// nếu đăng nhập đúng tên t3h và 123, thì trả về trang loại sữa, ko thì về lại
		// trang đăng nhập
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// kiểm tra coi có đúng tài khoản mật khẩu ko
		if (userName.equals("t3h") && password.equals("123")) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName); // đưa username lên localhost hay cookie
			// nếu người ta đăng nhập, mình bỏ qua bộ giải quyết view và trả về đường dẫn đó
			String path = (String) session.getAttribute("path");
			return "redirect:/" + path;
//			return "redirect:/loai-sua";
		}
		return "trangDangNhap";
	}

}
