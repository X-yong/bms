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
			<i class="icoh"></i> <span>电子书列表</span>
		</div> 
		<div class="operate">
			<div class="pull-left">
			<form id="f1"  method="post" action="${pageContext.request.contextPath}/qryLoadEBookController/qryLoadEBook.do?b_kind=0">
				  <input type="text"  id="mess" value="${mess}" hidden/>
				  <input type="text"  id="btype" value="${echo.b_type}" hidden/>
				  <input type="text"  id="currPage" name="currPage" value="1" hidden/>
			    名称：<input type = "text" name="b_name" class="textController" value="${echo.b_name}" />
			    类型：<select id="state" name="b_type" class="textController" style="width: 80px;background-color: black;">
			       <option value="">请选择</option> 
			       <c:forEach items="${bookType}"  var="bookTypeList" varStatus="status">
					   <option value="${bookTypeList.typeid}">${bookTypeList.typename}</option>
					</c:forEach>
				 </select>
				<input type="submit" value="查询"  class="btn  btn-info">
			</form>	
			</div>
			<!-- operate标题结束 -->
			<div class="list">
				<div class="tablewrap">
				<div style="height:480px">
					<form id="fList">
					<table class="table" width="100%" id="datalist">
						<thead>
							<tr></tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr>
								 <td ><input type="checkbox" id='${resultList.b_id}' value="${resultList.b_id}" name="checks"></td>
								 <td><a href="${pageContext.request.contextPath}/view/eBookDownload.do?bid=${resultList.b_id}"> 
								     <img src="${pageContext.request.contextPath}/${resultList.b_imgurl}" alt="正在加载"
					                  width="80px" height="110px"/></a>
					             </td>
							    <td>
								 <label style="font-size: large;">${resultList.b_name}</label><br>
										 ${resultList.b_author}&nbsp|
										 ${resultList.typename}&nbsp|
			                             ${resultList.b_state==0?'连载中':'已完结'} &nbsp|
			                                                                                      最近更新： ${resultList.b_enterTime}&nbsp|
		 	                                                                                      图书价格：${resultList.b_price}元<br>
				 	             <p>图书简介：${resultList.b_remark}</p>
								</td>
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