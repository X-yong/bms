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
			<i class="icoh"></i> <span>作者信息</span>
		</div>
		<div class="operate">
			<div class="pull-left">
			<form id="f1"  method="post" action="${pageContext.request.contextPath}/qryUserController/qryUserInfo.do?u_role=2">
			  <input type="text" id="currPage" name="currPage" value="1" hidden/> 
			    编号：<input type = "text" name="u_id" class="textController" value="${echo.u_id}" />
			    名称：<input type = "text" name="u_name" class="textController" value="${echo.u_name}" />
			      <input type="text" id="sta" value="${echo.u_state}" hidden>
			    状态：<select id="state" name="u_state" class="textController" style="width: 80px;background-color: black;">
			        <option value="">全部</option>
					<option value="0">冻结</option>
					<option value="1">正常</option>
				 </select>
			    注册时间：<input  type="text" id="startDate" name="startDate" value="${echo.u_startDate}"  class="textController" style="width: 120px" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}'})"/>
			        - <input  type="text" id="endDate"  name="endDate" value="${echo.u_endDate}"  class="textController" style="width: 120px" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}'})"/>   
				<input type="button" value="查询" onclick="search()" class="btn  btn-info">
				<input type="button" value="查询所有" onclick="searchAll(2)"  class="btn btn-info">
				<input type="button" value="删除" onclick="deleteUser()" class="btn btn-danger">
			</form>	
			</div>
			<!-- operate标题结束 -->
			<div class="list">
				<div class="tablewrap">
				<div style="height:480px">
					<form id="fList">
					<table class="table" width="100%" id="datalist">
						<thead>
							<tr>
								<th><input type="checkbox" name="" id="all"></th>
								<th>编号</th>
								<th>名称</th>
								<th>密码</th>
								<th>电话</th>
								<th>邮箱</th>
								<th>状态</th>
								<th>余额</th>
								<th>信用值</th>
								<th>操作时间</th>
								<th>注册时间</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='gray'" onmouseout="style.backgroundColor=''">
								<td ><input type="checkbox" value="${resultList.u_id}" name="checks"></td>
							    <td><a href="${pageContext.request.contextPath}/view/updateInfo.do?u_id=${resultList.u_id}">${resultList.u_id}</a></td>
								<td>${resultList.u_name}</td> 
								<td>*******</td>
								<td>${resultList.u_phone}</td>
								<td>${resultList.u_email}</td>
								<td>${resultList.u_state == 0?'冻结':'正常'}</td>
								<td>${resultList.u_balance}</td>
								<td>${resultList.u_credit}</td>
								<td>${resultList.u_operateTime}</td>
								<td>${resultList.u_createTime}</td> 
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