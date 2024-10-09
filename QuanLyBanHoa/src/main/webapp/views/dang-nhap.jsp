<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<form class="form-horizontal" action="DangNhapServlet" method="post">
	<div class="form-group">
		<label class="control-label col-sm-6" style="font-weight:normal;">Tên đăng nhập</label>
		<div class="col-sm-6">
			<input class="form-control" type="text" name="txtTenDN"	value="" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" style="font-weight:normal;">Mật khẩu</label>
		<div class="col-sm-6">
			<input class="form-control" type="password"	name="txtMatKhau" value="" />
		</div>
	</div>
	<input class="btn center-block" type="submit" name="btnDangNhap" value="Đăng nhập" />
</form>
