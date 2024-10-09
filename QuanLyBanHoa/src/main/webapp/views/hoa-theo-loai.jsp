<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid">
	<div class="row" style="background-color: #e6ffff;">
		<div class="col-sm-2">
			<h4 style="color: brown;">Danh sách loại</h4>
			<ul>
				<c:forEach items="${dsLoaiHoas }" var="i">
					<li><a href="trang-chu.jsp?maLoai=${i.maLoai}">Loại hoa
							${i.tenLoai}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-sm-10" style="background-color: #FFF;">
			<c:forEach items="${dsHoa }" var="hoa">
				<figure>
					<img src="images/${hoa.hinh}" />
					<figcaption>
						<p>
							<b><a href="#">${hoa.tenHoa}</b><a
								href="ThemGioHangServlet?maHoa=${hoa.maHoa}"><img
								src="images/gio_hang.jpg" style="width: 20px; height: 20px;"></a>
						</p>
						<fmt:setLocale value="vi-VN" />
						<fmt:formatNumber value="1000" type="number" var="donGia"></fmt:formatNumber>
						<p>
							<i>Giá bán:</i> ${donGia} đ
						</p>
					</figcaption>
				</figure>
			</c:forEach>
		</div>
	</div>
</div>

