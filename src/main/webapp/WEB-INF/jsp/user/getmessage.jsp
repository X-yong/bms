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
			<i class="icoh"></i> <span>我的信息</span>
		</div>
		<div class="operate">
			<div class="pull-left">		
				<input type="button" value="标记已读" onclick="flag()" class="btn  btn-success">
				<input type="button" value="回复" onclick="showDiv()" class="btn  btn-info">
			</div>
		    <input type="text" id="mess" value="${mess}" hidden>
			<!-- operate标题结束 -->
			<div class="list">
				<div class="tablewrap">
				<div style="height:480px">
					<form id="f1" method="post" action="<%=request.getContextPath()%>/updateFlagController/updateFlag.do">
					<input type="text" id="currPage" name="currPage" value="1" hidden/> 
					<table class="table" width="100%" id="datalist">
						<thead>
							<tr>
								<th><input type="checkbox" name="" id="all"></th>
								<th>发送人</th>
								<th>内容</th>
							    <th>时间</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${s_message}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='gray'" onmouseout="style.backgroundColor=''">
								<td ><input type="checkbox" value="${resultList.id}" name="checks" onclick="linkAge(${resultList.id})" id="${resultList.id}">
								     <input type="checkbox" value="${resultList.su_id}" name="ru_id" id="${resultList.id}1" hidden>
								</td>
								<td>${resultList.su_id}</td>
								<td>${resultList.s_content}</td>
								<td>${resultList.s_time}</td> 
							</tr>
						 </c:forEach> 
						</tbody>
					</table>
					<div class="form-group" id="m1" hidden>
					<div class="col-lg-4">
			           <textarea cols="100" rows="2" name="s_content" id="s_content"></textarea>
			           <input type="button" value="提交" onclick="returnMessage()">
                       <input type="button" value="取消" onclick="closeDiv()">
			        </div>
					</div>
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
							<a href="javascript:;" onclick="messagePaging(1)">首页</a>
							<a href="javascript:;" onclick="messagePaging(${currPage-1})">上一页</a>
							<a href="javascript:;" onclick="messagePaging(${currPage+1})">下一页</a>
							<a href="javascript:;"onclick="messagePaging(${allPage})">	尾页</a>
						</c:when>
						<c:when test="${currPage==1}">
							<a href="javascript:;">首页 </a>
							<a href="javascript:;">上一页</a>
							<a href="javascript:;" onclick="messagePaging(${currPage+1})">下一页</a>
							<a href="javascript:;" onclick="messagePaging(${allPage})">	尾页</a>
						</c:when>
						<c:when test="${currPage==allPage && allPage !=1}">
							<a href="javascript:;" onclick="messagePaging(1)">首页</a>
							<a href="javascript:;" onclick="messagePaging(${currPage-1})">上一页</a>
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
      <script src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
      <script src="${pageContext.request.contextPath}/js/user.js"></script>
      <script type="text/javascript">
      
      //复选框全部选中
      $(function(){
        $("#all").click(function(){
          if($(this).prop('checked')){
            $('#datalist :checkbox').prop('checked',true)
          }else{
            $('#datalist :checkbox').prop('checked',false)
          }
        })
        
        var s1 = $("#sta").val();
        $("#state").val(s1);
        
        
      })
      </script>
  </body>
</html>