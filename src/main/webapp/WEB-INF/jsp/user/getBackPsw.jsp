<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/b_login.css">

<title>找回密码</title>
</head>
<body>
	<div class="register">
		<div class="loginmain">
			<br><h3 style="display: inline">密码重置</h3>
			<form id="getBankPsw" class="form-horizontal">
				<!-- 让表单在一行中显示form-horizontal -->
				<div class="form-group">
					<label for="username" class="col-lg-2 control-label">用户ID<font
						style="color: red"> &nbsp*&nbsp</font></label>
					<div class="col-lg-4">
						<input type="number" name="u_id" id="u_id" required="required"
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="username" class="col-lg-2 control-label">用户身份证<font
						style="color: red"> &nbsp*&nbsp</font></label>
					<div class="col-lg-4">
						<input type="number" name="u_idCard" id="u_idCard"
							required="required" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-lg-2 control-label">新密码<font
						style="color: red">&nbsp*&nbsp</font></label>
					<div class="col-lg-4">
						<input type="password" name="u_rpassword" id="u_rpassword"
							required="required" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-lg-2 control-label">确认密码<font
						style="color: red">&nbsp*&nbsp</font></label>
					<div class="col-lg-4">
						<input type="password" name="u_password" id="u_spassword"
							required="required" onchange="checkPsw()" class="form-control">
					</div>
				</div>
				<div class="form-group" id="register" >
					<div class="col-lg-4 col-lg-offset-2">
						<input type="button"  onclick="getBackPsw()" value="提&nbsp&nbsp&nbsp交"	class="btn btn-danger btn-block" />
						<input type="button"  onclick="cancel()" value="取&nbsp&nbsp消" class="btn btn-block btn-info " />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/public/js/jquery-3.1.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/public/js/delaunay.js"></script>
	<script src="<%=request.getContextPath()%>/public/js/TweenMax.js"></script>
	<script src="<%=request.getContextPath()%>/js/common.js"></script>
	<script src="<%=request.getContextPath()%>/js/user.js"></script>

</body>
</html>