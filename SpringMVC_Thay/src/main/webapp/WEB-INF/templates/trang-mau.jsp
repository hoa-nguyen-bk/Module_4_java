<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="tieuDe"></tiles:insertAttribute></title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

header, footer {
	height: 100px;
	background-color: lightblue;
	width: 100%;
}

main {
	width: 100%;
	display: flex;
}

nav {
	width: 20%;
	background-color: khaki;
	height-min: 400px;
}

article {
	width: 80%;
	background-color: lightyellow;
}
</style>
</head>
<body>
	<header>
		<tiles:insertAttribute name="dauTrang" />
	</header>

	<main>
		<nav>
			<tiles:insertAttribute name="thucDon" />
		</nav>
		<article>
			<tiles:insertAttribute name="noiDung" />
		</article>
	</main>

	<footer>
		<tiles:insertAttribute name="cuoiTrang" />
	</footer>

</body>
</html>