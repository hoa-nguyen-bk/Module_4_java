<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<table border="1">
		<caption>Danh sách loại sữa</caption>
		<thead>
			<tr>
				<th>Mã loại</th>
				<th>Tên loại</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dsls }" var="ls">
				<tr>
					<%--phải đặt tên đúng như tên trong javabean, nó là biến, có phân biệt hoa thường nên cần gõ đúng từng kí tự --%>
					<td>${ls.maLoai }</td>
					<td>${ls.tenLoai }</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${not empty thuocTinhThem }">
		<h1>${thuocTinhThem }</h1>
	</c:if>