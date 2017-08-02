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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
  </head>

  <body>
	<div class="iframecontent">
		<div class="pos">
			<i class="icoh"></i> <span>电子书下载</span>
		</div> 
		<div class="operate">
			<div class="pull-left">
			<form id="f1" method="post" action="${pageContext.request.contextPath}/eBookDownloadController/eBookDownload.do">
				  <table>
				  <thead>
					 <tr></tr>
				  </thead>
				    <tbody>
				      <tr>
				      <td>
				      	<div class="form-group">
				          <div class="col-lg-4">
					         <img src="${pageContext.request.contextPath}/${result.b_imgurl}" alt="正在加载"
					           width="155px" height="200px"/>
				           </div>
			            </div>
				      </td>
				       <td>
						 <label style="font-size: 50px;">${result.b_name}</label><br>
								作者： ${result.b_author}<br>
							  <p>简介：${result.b_remark}</p>
								 ${result.typename}&nbsp|
	                             ${result.b_state==0?'连载中':'已完结'} &nbsp|
	                                                                                      最近更新： ${result.b_enterTime}&nbsp|
 	                                                                                      图书价格：${result.b_price}元<br>
						 <div class="form-group" id="downLoad">
				           <div class="col-lg-4 col-lg-offset-2">
				                <input type="text" id="mess" value="${mess}"  hidden>
				                <input type="text" id="filePath" name="filePath" value="${result.b_url}" hidden>
				                <input type="text" id="b_id" name="bid" value="${result.b_id}" hidden>
								<input type="submit" style="width: 150px" value="下&nbsp&nbsp载"
								      class="btn btn-success btn-primary" "/>	
								 <input type="button"  style="width: 150px" value="返&nbsp&nbsp回"
								      class="btn btn-danger btn-primary" onclick="returnEbookList()" />	
								 <input type="button" id ="d3"  style="width: 150px" value="评&nbsp&nbsp价"
								      class="btn btn-info btn-primary"  onclick="showComment()"/>		
						   </div>
					    </div>
					  </td>
				      </tr>
				    </tbody>
				  </table>
			</form>	
			</div>
			<!-- operate标题结束 -->
			<div class="list">
				<div class="tablewrap">
					<form id="fList">
					<table class="table" width="100%" id="datalist">
						<thead>
							<tr></tr>
						</thead>
						<tbody>
						  <c:forEach items="${comment}" var="resultList" varStatus="status">
							<tr>
							<td style="width: 60px"><img class="img-circle" style="width: 50px; height:50px" 
							          src="<%=request.getContextPath()%>/upload/img/us.jpg"/></td>
							<td>用户： ${resultList.u_id}评<br>
							 评价：   ${resultList.c_comment}<br>
							<%--  回复：   ${resultList.c_reply}<br> --%>
							    ${resultList.c_replytime}
							</td>										
							</tr>
						 </c:forEach>  
						</tbody>
					</table>
					</form>
				</div>
			</div>
			<!-- 评论 -->
			<div class="form-group" id="cd1" style="display: none">
			   <div class="col-lg-4">
				 <form id="c1" > 
				  		<input type="text" id="bid" name="bid" value="${result.b_id}" hidden>
					   <textarea cols="100"  id="comment" name="comment" rows="3"></textarea>
					   <input type="button"  class="btn btn-success btn-sm" onclick="addComment()" value="发表">
					   <input type="button"  class="btn btn-danger btn-sm" onclick="closeComment()" value="取消">
				 </form>
			   </div>
			</div>
			
		</div>
	</div>	
	  <script src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
      <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/book.js"></script> 
      <script type="text/javascript">
     
      $(function(){
    	  var aa = $("#btype").val();
    	  if(aa != null && aa != "" && aa != undefined) {
    		  $("#state").val(aa);
    	  }
       
      })
      </script>
  </body>
</html>