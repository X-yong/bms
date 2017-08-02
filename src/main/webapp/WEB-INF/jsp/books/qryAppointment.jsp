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
  	<script src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
  </head>

  <body>
	<div class="iframecontent">
		<div class="pos">
			<i class="icoh"></i> <span>预约查询</span>
		</div> 
		<div class="operate">
			<div class="pull-left">
			<form id="f1" method="post" action="${pageContext.request.contextPath}/qryAppointmentController/qryAppointment.do">
				    <input type="text"  id="mess" value="${mess}" hidden/>
				    <input type="text"  id="currPage" name="currPage" value="1" hidden/>
			    用户编号：<input type ="text" id="uid" class="textController" name="u_id" value="${echo.u_id}" />
			     图书编号：<input type ="text" id="bid" class="textController" name="b_id" value="${echo.b_id}" />
				  <input type="submit"  value="查询" style="width: 100px" class="btn btn-info">
				  <input type="button" onclick="searchAllAppointment()" value="查询所有" style="width: 100px" class="btn btn-info">
			      <input type="button"  value="预约结束" style="width: 100px" onclick="endAppoint()" class="btn btn-danger">
			</form>	
			</div>
			<!-- operate标题结束 -->
			<div class="list" >
				<div class="tablewrap">
				<div style="height:480px">
					<form id="fList" action="${pageContext.request.contextPath}/endAppointController/endAppoint.do" method="post">
					<table class="table" id="borrow" width="100%" id="datalist">
						<thead>
							<tr>
							    <th><input type="checkbox" name="" id="all"></th>
								<th>用户编号</th>
								<th>图书编号</th>
								<th>图书名称</th>
							    <th>预约时间</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='gray'" onmouseout="style.backgroundColor=''">
							    <td><input type="checkbox" name="checks" id="${resultList.id}" onclick="linkAge(${resultList.id})" value="${resultList.id}" >
							    <input type="checkbox" name="bid" id="${resultList.id}1" value="${resultList.b_id}" hidden></td>
							    <td>${resultList.u_id}</td>
								<td>${resultList.b_id}</td> 
								<td>${resultList.b_name}</td>
								<td>${resultList.br_time}</td>
							</tr>
						 </c:forEach> 
						</tbody>
					</table>
					</form>
					</div>
					<!--分页-->
					<div id="pages" style="margin-left: 40%; margin-bottom: 10px">
					<%--若当前页为第一页只能进行下一页操作 ，当前页码大于1可以进行上一页操作 --%>
					<c:choose>
						<c:when test="${currPage==allPage && allPage ==1}">
							<a href="javascript:;">首页 </a>
							<a href="javascript:;">上一页</a>
							<a href="javascript:;">下一页</a>
							<a href="javascript:;">尾页</a>
						</c:when>
						<c:when test="${currPage >1 && currPage < allPage}">
							<a href="javascript:;" onclick="userInfoPaging(1)">首页</a>
							<a href="javascript:;" onclick="userInfoPaging(${currPage-1})">上一页</a>
							<a href="javascript:;" onclick="userInfoPaging(${currPage+1})">下一页</a>
							<a href="javascript:;"onclick="userInfoPaging(${allPage})">	尾页</a>
						</c:when>
						<c:when test="${currPage==1}">
							<a href="javascript:;">首页 </a>
							<a href="javascript:;">上一页</a>
							<a href="javascript:;" onclick="userInfoPaging(${currPage+1})">下一页</a>
							<a href="javascript:;" onclick="userInfoPaging(${allPage})">	尾页</a>
						</c:when>
						<c:when test="${currPage==allPage && allPage !=1}">
							<a href="javascript:;" onclick="userInfoPaging(1)">首页</a>
							<a href="javascript:;" onclick="userInfoPaging(${currPage-1})">上一页</a>
							<a href="javascript:;">下一页</a>
							<a href="javascript:;"> 尾页</a>
						</c:when>
					</c:choose>
					第${currPage}页/共${allPage}页
					</div>
				</div>
			</div>
		</div>
	</div>
	
      <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/book.js"></script>
      <script type="text/javascript">
      function  resetValue() {
    	  $("#uid").val("");
    	  $("#bid").val("");
    	  $("#bname").val("");
    	  $("#bo_state").val("");
      }
      
      //复选框全部选中
      $(function(){
       
        var a = $("#bostate").val()
        if (a != null && a != "" ) {
           $("#bo_state").val(a);
		}
        
        
      })
      </script>
  </body>
</html>