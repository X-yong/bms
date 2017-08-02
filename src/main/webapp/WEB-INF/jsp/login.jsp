<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/b_login.css">

	<title>login</title>
	</head>
	<body>
	  <div class="login">
		<div class="loginmain">
			<h2>登录管理系统</h2>
			<input type="text"  id="mess" value="${mess}" hidden/>
				<form id="flogin" class="form-horizontal">
			           <!-- 让表单在一行中显示form-horizontal -->
			          <div class="form-group">
			              <label for="username" class="col-lg-1 control-label">账号</label>
			              <div class="col-lg-4">
			                <input type="text" name="u_id" id="u_id" value="${loginInfo.u_id}" class="form-control" placeholder="请输入账号">
			              </div>              
			          </div>
					  <div class="form-group"></div>
	
			          <div class="form-group">
			              <label for="password" class="col-lg-1 control-label">密码</label>
			              <div class="col-lg-4">
			                <input type="password" name="u_password" id="u_password" value="${loginInfo.u_password}"  class="form-control" placeholder="请输入密码">
			              </div>              
			          </div>
			          <div class="form-group"></div>
			          <div class="form-group">
			                <label for="username" class="col-lg-1 control-label">验证码</label>
			                  <div  class="col-lg-4">  
			                       <input type="text" id="code_input" class="form-control" style="width: 180px;display : inline" onkeydown="KeyDown()" placeholder="请输入验证码">
			                       <div id="v_container" style="width: 130px;height: 40px; float: right"></div>
			                  </div>
			          </div> 
			          <div class="form-group"  style="height: 10px" >
			             <div  class="col-lg-4 col-lg-offset-1">  
			                <span class="text"></span> 
			             </div>
			          </div>
			          
			          <div class="form-group">
			            <div class="col-lg-4 col-lg-offset-1">
			                <input type="button" name="loginButton" id="u1" value="登&nbsp;&nbsp;&nbsp;&nbsp;录" style="width:180px;height:40px" class="btn btn-info btn-lg">
			                <a href="${pageContext.request.contextPath}/view/register.do" style="color:white;">&nbsp;点我注册 》》</a> 
			            </div>
			          </div>
			          <div class="form-group">
			             <div class="col-lg-11 col-lg-offset-1">              
			                <a href="${pageContext.request.contextPath}/view/getBackPsw.do" 
			                  style="color:white;">登录遇到问题？》》</a> 
			            </div>
			          </div> 
			           
			    </form>
			    
		</div>
		<!-- <div class="rightpic">
			<div id="container">
				<img src="picture/1.jpg" alt="" width="500px" height="330px">
			</div>
		</div> -->
	</div>
	<script src="<%=request.getContextPath()%>/public/js/jquery-3.1.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/public/js/delaunay.js"></script>
	<script src="<%=request.getContextPath()%>/public/js/TweenMax.js"></script>
	<script src="<%=request.getContextPath()%>/js/effect.js"></script>
	<script src="<%=request.getContextPath()%>/js/b_login.js"></script>	
	<script src="<%=request.getContextPath()%>/js/gVerify.js"></script>
	<script type="text/javascript">
	   var verifyCode = new GVerify("v_container");
	</script>
</body>
</html>