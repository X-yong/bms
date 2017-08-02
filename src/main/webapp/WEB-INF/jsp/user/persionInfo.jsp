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
			<i class="icoh"></i> <span>个人信息</span>
		</div>
		<form id="fupdate" method="post" action="/bms/updatePersionController/updatePersion.do" enctype="multipart/form-data">
			<!-- 让表单在一行中显示form-horizontal -->
			<input type="text" id="mess" hidden value="${mess}">
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">用户ID<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="number" name="u_id" class="form-control" value="${loginInfo.u_id}" readonly="readonly" >
					<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">户名<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="u_name" id="u_name" class="form-control" 
					         value="${loginInfo.u_name}" >
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">密码<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="password" class="form-control" value="${loginInfo.u_password}" 
					readonly="readonly" >
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">电话<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input	type="tel" name="u_phone" id="u_phone" 
						class="form-control" value="${loginInfo.u_phone}" >
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">email<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="email" name="u_email" id="u_email" 
						class="form-control" value="${loginInfo.u_email}" >
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">角色<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text"  readonly="readonly"
						class="form-control" value="${sessionScope.u_role}">
					
			   </div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">余额<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="number" class="form-control" value="${loginInfo.u_balance}"
					 readonly="readonly" >
				</div>
			</div>
			<div class="form-group">
	              <label for="username" class="col-lg-2 control-label">状态<font style="color: red">&nbsp*&nbsp</font></label>
	              <div class="col-lg-4">
	              <input id="stateSelect" value="${loginInfo.u_state}"  style="display: none"/>
	                <select class="form-control" id="u_state" disabled="disabled" >
                         <option value="0">冻结</option>			                
                         <option value="1">正常</option>			                
	                </select>
	              </div>              
		    </div>
		    <div class="form-group">
				<label for="username" class="col-lg-2 control-label">信用值<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="number"  id="u_credit" readonly="readonly"
						class="form-control" value="${loginInfo.u_credit}">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">注册时间<font
					style="color: red"> &nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text"  id="u_createTime" readonly="readonly"
						class="form-control" value="${loginInfo.u_createTime}">
				</div>
			</div>
			<div class="form-group">
	              <label for="username" class="col-lg-2 control-label">照片</font></label>
	              <div class="col-lg-4">
                      <input type="file"  style="height: 40px" class="form-control" accept=".jpg,.png,.jpeg,.bmp" name="file"/>
	              </div>              
			 </div>
			<div class="form-group" id="update">
			  <div class="col-lg-4 col-lg-offset-2">
				<input type="submit" id ="p1"  value="保&nbsp&nbsp存" class="btn btn-info" />
			 </div>
		   </div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user.js"></script>
</body>
</html>