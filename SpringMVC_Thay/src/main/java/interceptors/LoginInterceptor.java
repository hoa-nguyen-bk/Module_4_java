package interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException  {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			response.sendRedirect("login"); // đường dẫn trên địa chỉ, khi đưa đường dẫn trên địa chỉ, nó phải tìm ra phương thức xử lý cho địa chỉ này, chính là trong controller, chính là phương thức để xử lý
			return false;
		} else {
			return true;
		}
	}
}
