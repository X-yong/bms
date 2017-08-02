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
			<i class="icoh"></i> <span>图书续借</span>
		</div>
		<form id="fupdate" method="post" action="/bms/reletBookController/reletBook.do">
			<!-- 让表单在一行中显示form-horizontal -->
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">用户Id</label>
				<div class="col-lg-4">
				    <input type="text" id="mess" value="${mess}" hidden/>
					<input type="text" name="id" id="id" value="${result.ID}" hidden/>
					<input type="text" value="${result.U_ID}" class="form-control"  required="required" readonly="readonly"/>
					<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">图书Id</label>
				<div class="col-lg-4">
					<input type="text"  required="required" readonly="readonly"
						class="form-control" value="${result.B_ID}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">应还日期</label>
				<div class="col-lg-4">
					<input type="text" readonly="readonly" name ="sh_time" class="form-control" value="${result.SH_TIME}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">续租天数<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input  type="number" id="b_relet" name="b_relet" class="form-control"  
					    value="${result.b_relet}" required="required"/>
				</div>
			</div>
			
		
			<div class="form-group" id="update">
				<div class="col-lg-4 col-lg-offset-2">
					<input type="submit" id ="u1"  value="保&nbsp&nbsp存" class="btn btn-info" />
					<input type="button" onclick="returnView()" value="返&nbsp&nbsp回" class="btn btn-danger" />
				</div>
			</div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/book.js"></script>
</body>
</html>