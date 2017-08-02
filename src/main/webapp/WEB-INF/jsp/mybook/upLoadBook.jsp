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
			<i class="icoh"></i> <span>图书上传</span>
		</div>
		<form id="fupdate" method="post" action="/bms/uploadBookController/uploadBook.do" enctype="multipart/form-data">
			<!-- 让表单在一行中显示form-horizontal -->
			<div class="form-group">
				<div class="col-lg-4">
					<input type="text"  id="mess" value="${mess}" hidden/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">书名<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<input type="text" name="b_name" id="b_name" required="required"
						class="form-control" value="${result.b_name}"/>
				    <img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">作者<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
				<input type="text" name="b_authorid" value="${loginInfo.u_id}" hidden/>
					<input type="text" name="b_author" id="b_author" required="required"
						class="form-control" value="${result.b_author}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">类型<font
					style="color: red">&nbsp*&nbsp</font></label>
					<input typ="text" id="t1" value="${result.b_type}" hidden>
				<div class="col-lg-4">
					<select id="type" name="b_type"  class="form-control" required="required">
				       <option value="">请选择</option> 
				      <c:forEach items="${bookType}"  var="bookTypeList" varStatus="status">
					     <option value="${bookTypeList.typeid}">${bookTypeList.typename}</option>
					  </c:forEach>
				    </select>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">图书状态<font
					style="color: red">&nbsp*&nbsp</font></label>
				<div class="col-lg-4">
					<select id="type" name="b_state"  class="form-control" required="required">
				       <option value="0">连载</option> 
				       <option value="1">已完结</option>  
				    </select>
				</div>
			</div>
		    <div class="form-group">
				<label for="username" class="col-lg-2 control-label">价格</label>
				<div class="col-lg-4">
					<input type="number" name="b_price" id="b_price" 
						class="form-control" value="${result.b_price}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" />
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">简介</label>
				<div class="col-lg-4">
					<input type="text" name="b_remark" id="b_remark" 
						class="form-control" value="${result.b_remark}"/>
				</div>
			</div>
			<div class="form-group">
	              <label for="username" class="col-lg-2 control-label">图书封面&nbsp&nbsp</font></label>
	              <div class="col-lg-4">
	                  <input type="file" style="height: 40px" class="form-control" 
	                  accept=".jpg,.png,.jpeg,.bmp" name="file" required="required"/>
	              </div>              
			</div>
            <div class="form-group">
              <label for="username" class="col-lg-2 control-label">文件上传&nbsp</font></label>
                <div class="col-lg-4">
                     <input type="file" style="height: 40px" class="form-control" 
                      accept=".txt,.doc" name="file" required="required"/>
                </div>              
            </div>
			<div class="form-group" id="update">
				<div class="col-lg-4 col-lg-offset-2">
					<input type="submit" value="保&nbsp&nbsp存" style="width: 300px"  class="btn btn-info"/>
				</div>
			</div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/book.js"></script>
</body>
</html>