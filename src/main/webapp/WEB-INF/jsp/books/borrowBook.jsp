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
			<i class="icoh"></i> <span>借书管理</span>
		</div> 
		<div class="operate">
			<div class="pull-left">
			<form id="f1"  method="post" action="${pageContext.request.contextPath}/qryBookBorrowController/qryBookBorrow.do?b_kind=1">
				  <input type="text"  id="mess" value="${mess}" hidden/>
			    编号：<input type ="text" id="bu1" class="textController" name="b_id"  value="${echo.b_id}" />
			    名称：<input type ="text" id="bn1" class="textController" name="b_name" value="${echo.b_name}" />
				  <input type="button" onclick="searchBook()" value="查询" style="width: 100px" class="btn btn-info">
				  <input type=button   onclick="resetValue()" value="重置" style="width: 100px" class="btn btn-danger">
			</form>	
			</div>
			
			<!-- operate标题结束 -->
			<div class="list" >
				<div class="tablewrap">
					<form id="fList" action="" method="post">
					<table class="table" id="borrow" width="100%" id="datalist">
						<thead>
							<tr>
								<th><input type="checkbox" name="" id="all"></th>
								<th>编号</th>
								<th>名称</th>
								<th>类型</th>
								<th>作者</th>
								<th>出版社</th>
								<th>价格</th>
								<th>ISBN</th>
								<th>版次</th>
								<th>库存</th>
								<th>入库时间</th>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr>
								<td ><input type="checkbox" id="checks" onclick="linkage()" value="${resultList.b_id}" name="checks">
							    <td>${resultList.b_id}</td>
								<td>${resultList.b_name}</td> 
								<td>${resultList.typename}</td>
								<td>${resultList.b_author}</td>
								<td>${resultList.b_press}</td>
								<td>${resultList.b_price}</td>
								<td>${resultList.b_isbn}</td>
								<td>${resultList.b_revision}</td>
								<td>${resultList.b_stock}</td>
								<td>${resultList.b_enterTime}</td>
								<td>${resultList.b_remark}</td>
							</tr>
						 </c:forEach> 
						</tbody>
					</table>
					</form>
				</div>
			</div>
			<!--借书还书  -->
			<div>
			  <div class="form-group">
				 <label for="username" class="col-lg-2 control-label">借阅者ID：</label>
				 <div class="col-lg-4">
					<input type="number" name="u_id" id="u_id"  required="required" style="width: 320px"
						class="textController" />
						借阅天数：<input type="number"  class="textController" name="b_time" id="b_time"  required="required" style="width: 50px" />
					<input type="button" id ="b1" style="width: 150px" onclick="borrowBook()" value="借&nbsp&nbsp书" class="btn btn-info " />
				</div>
			  </div>		  
			</div>
			<!--结束  -->
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