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
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/css/rightmain.css">
<link href="<%=request.getContextPath()%>/css/div.css" rel="stylesheet">
</head>
<body>
	<div class="iframecontent">
		<div class="pos">
			<i class="icoh"></i><span>图书编辑</span>
		</div>
		<div class="container intro">
			<form accept-charset="utf-8">
			<%-- 	<input type="text" id="bname" value="${b_name}" hidden />  --%>
				<%-- <input type="text" id="contentext" value="${content}" hidden /> --%>
				<textarea id="contentext" hidden>${content}</textarea>
				<div class="row fill"></div>
				<div class="row">
					<script id="editor" type="text/plain" style="width:100%px;height:500px;"></script>
				</div>
			</form>
			<!-- 弹出框 -->
				<div id="fullbg"></div>
				<div id="dialog">
					<p class="">
						<font style="font-size: large; color: black;">保存</font>
					</p>
					<div>
						<div class="form-group">
							<div class="col-lg-4">
							<font style="font-size:medium; color: black;"> 图书名称：</font> 
							<input type="text" class="form-control" id="b_name" name="b_name" />
							</div>
						</div>
						<input type="button" value="保存" onclick="saveBook()" class="btn btn-success"> 
						<input type="button" value="取消" onclick="closeBg()" class="btn btn-danger">
					</div>
				</div>
			<!-- 弹出框结束 -->
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/public/js/jquery-3.1.1.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/lib/utf8-php/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/lib/utf8-php/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/lib/utf8-php/lang/zh-cn/zh-cn.js"></script>
	<script src="${pageContext.request.contextPath}/js/div.js"></script>
	<!--添加按钮-->
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/lib/utf8-php/addCustomizeButton.js"></script>
	<script	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/book.js"></script>
	<script type="text/javascript">
          var ue = UE.getEditor('editor');
          //获得编辑器的带格式的纯文本内容
          function getPlainTxt() {
        	  var arr = [];
              arr.push(UE.getEditor('editor').getPlainTxt());
              var a = arr.join('\n');
              if(a == "" || a== null || a=='\n') {
            	alert("内容为空");  
            	return;
              }
              $("#contentext").val(a); 
              showBg();              
              // saveBook(a);
          }
          //设置编辑器的内容
          function setContent(isAppendTo) {
     
              var arr = [];
              var text = $("#contentext").val();
              UE.getEditor('editor').setContent(text, isAppendTo); 
          }
           ue.ready(function() {
        	 // ue.focus();
        	  var text = $("#contentext").val();
        	  if (text != null && text != "" && text != undefined) {
        		  setContent(text);
			   }
        	   
          })
      
      </script>
</body>
</html>