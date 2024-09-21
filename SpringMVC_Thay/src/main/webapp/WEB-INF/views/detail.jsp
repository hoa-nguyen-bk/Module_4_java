<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>${product.title }</h1>
<figure style="width: 250px">
	<img alt="${product.title }" src="img/${product.imageUrl }"
		style="width: 180px; height: 200px; object-fit: contain" />
</figure>

<p>ISBN: ${product.isbn }</p>
<p>Page: ${product.pages}</p>
<p>Price: ${product.price}</p>
<form method="POST">
	<input type="number" name="soLuong"  />
	<input type="submit" name="btnSubmit" value="Add to cart" /> 
</form> 
<%--
--%>