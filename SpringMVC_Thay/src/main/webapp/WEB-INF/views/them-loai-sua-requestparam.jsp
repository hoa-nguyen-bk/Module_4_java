<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm</title>
</head>
<body>
<h1>Thêm loại sữa request param</h1>
<%-- Đây ko còn gọi servlet mà đây là ánh xạ, ánh xạ xử lý để tìm ra cái controller, từ cái ánh xạ xử lý này ta tìm được phương thức --%>
<%-- bên này ko thêm xuyệt /them-loai-sua , vì nó trả về thư mục của server, chứ ko trả về thư mục của thêm website, quy định của html --%>
<form action="them-loai-sua-requestparam" method="post">
	<p><label>Mã loại: </label> <input type="text" name="maLoai" /></p>
	<p><label>Tên loại: </label> <input type="text" name="tenLoai" /></p>
	<button type="submit">Thêm</button>
</form>
</body>
</html>