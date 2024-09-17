<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Minh họa tải NHIỀU tập tin lên Web Server</h1>
<%--chỗ này upload multiple thì phải cùng tên với jsp --%>
<form action="upload-multiple-file" method="post" enctype="multipart/form-data">
	<p>
		<label>Tập tin: </label> <input multiple="multiple" type="file" name="files">
	</p>
	<p>
		<input type="submit" name="btnUpload" value="Upload" />
	</p>
</form>
<c:if test="${not empty dsTapTin }">
	<p>
		<c:forEach items="${dsTapTin }" var="tt">
			<img src="img/${tt }" width="100px" height="100px"/>
		</c:forEach>
	</p>
</c:if>