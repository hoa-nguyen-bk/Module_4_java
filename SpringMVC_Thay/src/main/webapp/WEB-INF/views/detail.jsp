<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>${product.title }</h1>
<hr>
<div style="display: flex; flex-flow: row; margin-top:20px">
	<figure style="width: 250px">
		<img alt="${product.title }" src="img/${product.imageUrl }"
			style="width: 180px; height: 200px; object-fit: contain" />
	</figure>
	<div>

		<p>ISBN: ${product.isbn }</p>
		<p>Page: ${product.pages}</p>
		<p>Price: ${product.price}</p>
		<form method="POST">
			<input type="number" name="soLuong" value="1" /> <input type="submit"
				name="btnSubmit" value="Add to cart" />
		</form>
	</div>
</div>
<%--
--%>