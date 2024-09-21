<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="display: flex;flex-flow:row wrap">
	<c:forEach items="${products }" var="p">
		<figure style="width:250px;">
			<img alt="a" src="img/${p.imageUrl }" style="width:180px;height:200px;object-fit:contain" />
			<figcaption>${p.title }</figcaption>
		</figure>
	</c:forEach>
</div>
<p>
	<c:forEach var="i" begin="1" end="${tongSoTrang }" step="1">
		<a href="index.html?trang=${i }">${i}</a>
	</c:forEach>
</p>
