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
			<i class="icoh"></i> <span>还书管理</span>
		</div> 
		<div class="operate">
			<div class="pull-left">
			<form id="f1" method="post" action="${pageContext.request.contextPath}/qryUserBorrowBookController/qryUserBorrowBook.do?bo_state=1">
				  <input type="text"  id="mess" value="${mess}" hidden/>
			    用户编号：<input type ="text" id="uid1" class="textController" name="u_id" value="${echo.u_id}" />
				  <input type="button" onclick="searchReturnBook()" value="查询" style="width: 100px" class="btn btn-info">
				  <input type="button" style="width: 100px" onclick="returnBook()" value="还&nbsp&nbsp书" class="btn btn-success " />
				  <input type=button   onclick="resetUid()" value="重置" style="width: 100px" class="btn btn-danger">
			</form>	
			</div>
			
			<!-- operate标题结束 -->
			<div class="list" >
				<div class="tablewrap">
					<form id="fList" action="${pageContext.request.contextPath}/returnUserBorrowBookController/returnUserBorrowBook.do" method="post">
					<table class="table" id="borrow" width="100%" id="datalist">
						<thead>
							<tr>
								<th><input type="checkbox" name="" id="all"></th>
								<th>用户编号</th>
								<th>图书编号</th>
								<th>借书时间</th>
								<th>应还书时间</th>
								<th>实还书时间</th>
								<th>借书状态</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='gray'" onmouseout="style.backgroundColor=''">
								<td ><input type="checkbox" id='${resultList.ID}' onclick="linkAge('${resultList.ID}')" value="${resultList.ID}" name="checks">
								<input type="checkbox" id="${resultList.ID}1"  value="${resultList.B_ID}" name="bids" hidden></td>
							    <td>${resultList.U_ID}</td>
								<td>${resultList.B_ID}</td> 
								<td>${resultList.BR_TIME}</td>
								<td>${resultList.SH_TIME}</td>
								<td>${resultList.RE_TIME}</td>
								<td>${resultList.BO_STATE==0?'借阅中':'已逾期'}</td>
							</tr>
						 </c:forEach> 
						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	
      <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/book.js"></script>
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
      })
      </script>
  </body>
</html>