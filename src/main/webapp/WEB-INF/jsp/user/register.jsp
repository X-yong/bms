<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/b_login.css">

	<title>注册</title>
	</head>
	<body>
	  <div class="register">
		<div class="loginmain">
		
		 <br><h3 style="display : inline">用户注册</h3><h5 style="display : inline">&nbsp&nbsp&nbsp&nbsp我有账户，</h5><h4 style="display : inline"><a href="/bms/view/login.do">登录</a></h4><h3></h3>
				<input type="text"  id="mess" value="${mess}" hidden/>
				<form id="fregister" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/addUserController/addUser.do" enctype="multipart/form-data" >
			           <!-- 让表单在一行中显示form-horizontal -->
			          <div class="form-group">
			              <label for="username" class="col-lg-2 control-label" >用户ID<font style="color: red"> &nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input type="number" name="u_id" id="u_id" value="${echo.u_id}" required="required" class="form-control" >
			              </div> 
			              <div class="col-lg-4 col-lg-offset-0">
			                <input type="button" value="查看重复" onclick="checkRepeat()" class="btn btn-info">
			              </div>        
			          </div>
			           <div class="form-group">
			              <label for="username" class="col-lg-2 control-label">户名<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input type="text" name="u_name" id="u_name"  value="${echo.u_name}" required="required" class="form-control" >
			              </div>              
			          </div>
			           <div class="form-group">
			              <label for="password" class="col-lg-2 control-label">密码<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input type="password" name="u_password" id="u_rpassword" required="required" class="form-control" >
			              </div>              
			          </div>
			          <div class="form-group">
			              <label for="password" class="col-lg-2 control-label">确认密码<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input type="password" name="u_rpassword" id="u_spassword" onchange="checkPsw()" required="required" class="form-control" >
			              </div>              
			          </div>
			          <div class="form-group">
			              <label for="username" class="col-lg-2 control-label">电话<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" 
			                        type="tel" name="u_phone" id="u_phone"  value="${echo.u_phone}" required="required" class="form-control" title="(11位手机号或固话)">
			              </div>              
			          </div>
			           <div class="form-group">
			              <label for="username" class="col-lg-2 control-label">身份证号<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input pattern="(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/)" type="tel" name="u_idCard" id="u_idCard" 
			                    required="required" class="form-control"  value="${echo.u_idCard}" title="(有效的身份证号)">
			              </div>              
			          </div>
			          <div class="form-group">
			              <label for="username" class="col-lg-2 control-label">email<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <input type="email" name="u_email" id="u_email"  value="${echo.u_email}" required="required" class="form-control">
			              </div>              
			          </div>
			          <div class="form-group">
			              <label for="username" class="col-lg-2 control-label">身份<font style="color: red">&nbsp*&nbsp</font></label>
			              <div class="col-lg-4">
			                <select class="form-control" name ="u_role">
                               <option value="3">读者</option>			                
                               <option value="2">作者</option>			                
                               <option value="23">以上两者</option>			                
			                </select>
			              </div>              
			          </div>
			          <div class="form-group">
			              <label for="username" class="col-lg-2 control-label">照片&nbsp&nbsp&nbsp</font></label>
			              <div class="col-lg-4">
                             <input type="file"  style="height: 40px" class="form-control" accept=".jpg,.png,.jpeg,.bmp" name="file"/>
			              </div>              
			          </div>
			          <div class="form-group" id="register"  hidden>
			              <div class="col-lg-4 col-lg-offset-2">
			                <input type="submit" value="注&nbsp&nbsp&nbsp册" class="btn btn-danger btn-block" />
			              </div>
		             </div>
			    </form>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/public/js/jquery-3.1.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/public/js/delaunay.js"></script>
	<script src="<%=request.getContextPath()%>/public/js/TweenMax.js"></script>
	<script src="<%=request.getContextPath()%>/js/common.js"></script>
	<script src="<%=request.getContextPath()%>/js/user.js"></script>
	
</body>
</html>