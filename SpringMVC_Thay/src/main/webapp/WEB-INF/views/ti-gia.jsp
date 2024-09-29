<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<thead>
		<tr>
			<th>Mã NT</th>
			<th>Cờ</th>
			<th>Mua tiền mặt</th>
			<th>Bán tiền mặt</th>
			<th>Mua chuyển khoản</th>
			<th>Bán chuyển khoản</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${tiGias != null }">
			<c:forEach items="${tiGias }" var="tg">
				<tr>
					<td>${tg.maNgoaiTe }</td>
					<td><img src="${tg.co }" height="30" width="50" /></td>
					<td>${tg.muaTienMat }</td>
					<td>${tg.banTM }</td>
					<td>${tg.muaChuyenKhoang }</td>
					<td>${tg.banCK }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>

</table>