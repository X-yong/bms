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
			<i class="icoh"></i> <span>授权</span>
		</div>
		<form id="fupdate" method="post" action="/bms/grantPowerController/grantPower.do">
			<!-- 让表单在一行中显示form-horizontal -->
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">用户ID</label>
				<div class="col-lg-4">
					<input type="number" name="u_id" class="form-control" value="${userVo.u_id}" readonly="readonly" >
					<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">户名&nbsp*&nbsp</label>
				<div class="col-lg-4">
					<input type="text" name="u_name" id="u_name" class="form-control" 
					        readonly="readonly" value="${userVo.u_name}" >
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">当前权限</label>
				<div class="col-lg-4">
					<input type="text" name="u_name" id="u_name" class="form-control" 
					        readonly="readonly" value="${u_role}" >
				</div>
			</div>
			<h3>请选择：</h3>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">管理员</label>
				<input type="checkbox" name="u_role" value="1" >
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">作 &nbsp&nbsp&nbsp者</label>
				<input type="checkbox" name="u_role" value="2" >
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">读 &nbsp&nbsp&nbsp者</label>
				<input type="checkbox" name="u_role" value="3" >
			</div>
			
			<div class="form-group" id="grantPower">
			  <div class="col-lg-4 col-lg-offset-2">
				<input type="submit"   value="保&nbsp&nbsp存" class="btn btn-info" />
				<input type="button" id ="r1" onclick="returnView()" value="返&nbsp&nbsp回" class="btn btn-danger" />
			 </div>
		   </div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/empower.js"></script>
</body>
</html>