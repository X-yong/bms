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
  	<script>
  	  function checkNull() {
  		  var text = $("#t1").val();
  		  if (text == "") {
			alert("内容不能为空");
			return false;
		}
  	  }
  	</script>
  </head>
<body>
	<div class="iframecontent">
		<div class="pos">
			<i class="icoh"></i> <span>留言</span>
		</div>
		<input type="text" id="mess" value="${mess}" hidden>
		<form method="post" action="<%=request.getContextPath()%>/leaveMessageController/leaveMessage.do" onsubmit="return checkNull()"> 
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">内容</label>
				<div class="col-lg-4">
				<img src="${pageContext.request.contextPath}/picture/1.jpg" alt="正在加载"
					width="500px" height="330px">
					<textarea cols="80" rows="5" id="t1" placeholder="请输入您的留言" name="s_content"></textarea>
				</div>
				
			</div>
		
			<div class="form-group" >
				<div class="col-lg-4 col-lg-offset-1">
					<input type="submit"  value="保&nbsp&nbsp存" style="width: 200px" class="btn btn-info  " />
				</div>
			</div>
		</form>
	</div>
	<script	src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user.js"></script>
</body>
</html>