<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
 <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/rightmain.css">
    
  	<style>
  	 .form-control{
  	   width: 45%;
  	 }
  	 img{
  	 float:right;
  	 }
  	</style>
  </head>
<body>
	<div class="iframecontent">
		<div class="pos">
			<i class="icoh"></i> <span>修改密码</span>
		</div>
		<form id="fresetPsw">
			<!-- 让表单在一行中显示form-horizontal -->
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">旧密码<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
				    <input  name="u_id" id="u_id" value="${loginInfo.u_id}" hidden/>
				     <input type="password"  id="psw" value="${loginInfo.u_password}" hidden/>
					<input type="password" name="u_password" id="u_password"
						required="required" class="form-control" >
					<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">新密码<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="password" name="u_spassword" id="u_spassword"
						required="required" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">重复密码<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="password" name="u_rpassword" id="u_rpassword"
						required="required" onchange="checkPsw()" class="form-control" >
				</div>
			</div>
			
			
			<div class="form-group" id="resetPsw">
				<div class="col-lg-4 col-lg-offset-1">
					<input type="button" id ="r1" onclick="resetPsw()" value="保&nbsp&nbsp存" class="btn btn-info " />
				</div>
			</div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user.js"></script>
</body>
</html>