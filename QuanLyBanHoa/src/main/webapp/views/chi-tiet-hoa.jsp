<%@page import="businessLogics.HoaBL"%>
<%@page import="javaBeans.Hoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
// 	int maHoa = Integer.parseInt(request.getParameter("maHoa"));
// 	Hoa hoa = HoaBL.DocTheoMaHoa(maHoa);
// 	pageContext.setAttribute("hoa", hoa);
%>
<div class="container-fluid">
	<div class="row" style="background-color:#59961F;">
		<div class="col-sm-3">
			<jsp:include page="thuc-don.jsp?kieu=thuc-don-dung" />
		</div>
		<div class="col-sm-9" style="background-color:#FFF;">
			<div style="max-width:70%;margin:20px auto;border:1px solid gray;height:auto;padding:20px;">
				<p style="display:inline-block;padding:5px 20px"><img src="images/${hoa.hinh}" /></p>
				<div style="display:inline-block">
					<p><b>${hoa.tenHoa}</b></p>
					<fmt:setLocale value="vi-VN" />
					<fmt:formatNumber value="${hoa.donGia}" type="number" var="donGia"/>
					<p><i>Giá bán:</i> ${donGia} đ</p>
					<p>Thành phần chính:<br>${hoa.moTa}</p>
				</div>
			</div>		
		</div>
	</div>
</div>