package interceptors;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import businessLogic.CategoryBL;
import javaBeans.Category;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException  {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);// lấy sau dấu / đến hết
		session.setAttribute("path", path);
		//lấy phương thúc xóa hết
//		session.invalidate()
		//xóa theo từng thuộc tính
//		session.removeAttribute( )
		if (userName == null) {
			response.sendRedirect("login"); // đường dẫn trên địa chỉ, khi đưa đường dẫn trên địa chỉ, nó phải tìm ra phương thức xử lý cho địa chỉ này, chính là trong controller, chính là phương thức để xử lý
			return false;
		} else {
			List<Category> parents = CategoryBL.getParents();
			request.setAttribute("parents", parents);
			return true;
		}
	}
}
