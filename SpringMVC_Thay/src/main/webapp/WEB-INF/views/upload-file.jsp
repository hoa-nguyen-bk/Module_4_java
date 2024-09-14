<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Minh họa tải tập tin lên Web Server</h1>
<form action="upload-file" method="post" enctype="multipart/form-data">
	<p>
		<label>Tập tin: </label> <input type="file" name="file">
	</p>
	<p>
		<input type="submit" name="btnUpload" value="Upload" />
	</p>
</form>
<c:if test="${not empty tapTin }">
	<p><img src="img/${tapTin }" width="100px" height="100px"/></p>
 </c:if>