<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
	<c:forEach items="${parents }" var="p">
		<li>${p.categoryName }</li>
		<c:forEach items="${children }" var="c">
			<c:if test="${c.parentId==p.categoryId }">
				<li style="margin-left:30px"><a href="#">${c.categoryName }</a></li>
			</c:if>
		</c:forEach>
	</c:forEach>
</ul>