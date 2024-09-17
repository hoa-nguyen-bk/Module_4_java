<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 style="color: red; text-align: center;">Meo meo</h1>
<form action="sendmail.html" method="post" class="form">
	<p>
		<label>Email</label> <input type="email" name="email" />
		<%-- đặt tên giống trong javabean --%>
	</p>
	<p>
		<label>Subject</label> <input type="text" name="subject" />
	</p>
	<p>
		<label>Content</label>
		<textarea name="content"> </textarea>
	</p>
	<p>
		<input type="submit" name="btnSubmit" value="Send mail" />
	</p>
</form>
<c:if test="${not empty msg }">
	<div class="error"> ${msg} </div>
</c:if>