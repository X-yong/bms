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
			<i class="icoh"></i> <span>新增图书</span>
		</div>
		<form id="fupdate" method="post" action="/bms/addBookController/addBook.do">
			<!-- 让表单在一行中显示form-horizontal -->
			<div class="form-group">
				
				<div class="col-lg-4">
					<input type="text" name="b_id" id="b_id" value="${echo.b_id}" hidden />
					<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">名称<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_name" id="b_name" required="required"
						class="form-control" value="${echo.b_name}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">作者<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_author" id="b_author" required="required"
						class="form-control" value="${echo.b_author}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">出版社<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_press" id="b_press" required="required"
						class="form-control" value="${echo.b_press}"/>
				</div>
			</div>
				<div class="form-group">
				<label for="username" class="col-lg-2 control-label">类型<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<select id="state" name="b_type" class="form-control" required="required">
				       <option value="">请选择</option> 
				      <c:forEach items="${bookType}"  var="bookTypeList" varStatus="status">
					     <option value="${bookTypeList.typeid}">${bookTypeList.typename}</option>
					  </c:forEach>
				    </select>
				</div>
			</div>
		    <div class="form-group">
				<label for="username" class="col-lg-2 control-label">价格<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_price" id="b_price" required="required"
						class="form-control" value="${echo.b_price}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" />
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">ISBN<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_isbn" id="b_isbn" required="required"
						class="form-control" value="${echo.b_isbn}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">版次<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_revision" id="b_revision" required="required"
						class="form-control" value="${echo.b_revision}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">库存<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="number" name="b_stock" id="b_stock" required="required"
						class="form-control" value="${echo.b_stock}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">备注<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_remark" id="b_remark" 
						class="form-control" value="${echo.b_remark}"/>
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