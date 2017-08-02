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
			<i class="icoh"></i> <span>修改信息</span>
		</div>
		<form id="fupdate" method="post" action="/bms/updateUserController/updateUser.do" >
			<!-- 让表单在一行中显示form-horizontal -->
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">用户ID<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="number" name="u_id" id="u_id" required="required"
						class="form-control" value="${result.u_id}" readonly="readonly">
					<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">户名<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="u_name" id="u_name" required="required"
						class="form-control" value="${result.u_name}">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">密码<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="password" name="u_password" id="u_password"
						required="required" class="form-control" value="${result.u_password}">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">电话<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input	pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$"
						type="tel" name="u_phone" id="u_phone" required="required"
						class="form-control" title="(11位手机号或固话)" value="${result.u_phone}">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">email<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="email" name="u_email" id="u_email" required="required"
						class="form-control" value="${result.u_email}">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">角色<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="u_role" id="u_role" readonly="readonly"
						class="form-control" value="${u_role}">
					<input type="text" value="${auth_id}" id="auth_id" name="auth_id" hidden>
			   </div>
			</div>
			<div class="form-group">
			              <label for="username" class="col-lg-2 control-label">状态<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			              <input id="stateSelect" value="${result.u_state}"  style="display: none"/>
			                <select class="form-control" id="u_state" name ="u_state" >
                               <option value="0">冻结</option>			                
                               <option value="1">正常</option>			                
			                </select>
			              </div>              
		    </div>
		    <div class="form-group">
				<label for="username" class="col-lg-2 control-label">信用值<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="u_credit" id="u_credit" required="required"
						class="form-control" value="${result.u_credit}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">余额<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="u_balance" id="u_balance" required="required"
						class="form-control" value="${result.u_balance}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')">
				</div>
			</div>
			<!-- <div class="form-group">
	              <label for="username" class="col-lg-2 control-label">照片</font></label>
	              <div class="col-lg-4">
                      <input type="file"  style="height: 40px" class="form-control" accept=".jpg,.png,.jpeg,.bmp" name="file"/>
	              </div>              
			 </div> -->
			<div class="form-group" id="update">
				<div class="col-lg-4 col-lg-offset-2">
					<input type="submit" value="保&nbsp&nbsp存" class="btn btn-info" />
					<input type="button" onclick="returnView()" value="返&nbsp&nbsp回" class="btn btn-danger" />
				</div>
			</div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user.js"></script>
</body>
</html>