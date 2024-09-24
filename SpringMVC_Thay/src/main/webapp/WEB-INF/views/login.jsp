<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Login</h1>
<form action="login" method="post">
	<p>
		<label>User name: </label><input type="text" name="userName"
			placeholder="Nhập userName">
	</p>
	<p>
		<label>Password: </label><input type="password" name="password" />
	</p>
	<button type="submit">Login</button>
</form>