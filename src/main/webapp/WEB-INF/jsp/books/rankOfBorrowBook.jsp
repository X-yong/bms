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
  	<link href="<%=request.getContextPath()%>/css/div.css" rel="stylesheet">
  </head>

  <body>
	<div class="iframecontent">
		<div class="pos">
			<i class="icoh"></i> <span>借阅排行</span>
		</div> 
		<div class="operate">	
			<!-- operate标题结束 -->
			<div class="list">
				<div class="tablewrap">
					<form id="fList">
					<table class="table" width="100%" id="datalist">
						<thead>
							<tr>
								
								<th>编号</th>
								<th>名称</th>
								<th>类型</th>
								<th>作者</th>
								<th>出版社</th>
								<th>价格</th>
								<th>ISBN</th>
								<th>版次</th>
								<th>库存</th>
								<th>借阅次数</th>
								<th>入库时间</th>
								
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='gray'" onmouseout="style.backgroundColor=''">
							
							    <td>${resultList.B_ID}</td>
								<td>${resultList.B_NAME}</td> 
								<td>${resultList.typename}</td>
								<td>${resultList.B_AUTHOR}</td>
								<td>${resultList.B_PRESS}</td>
								<td>${resultList.B_PRICE} 元</td>
								<td>${resultList.B_ISBN}</td>
								<td>${resultList.B_REVISION}</td>
								<td>${resultList.B_STOCK} 本</td>
								<td>${resultList.B_ACCOUNT} 次</td>
								<td>${resultList.B_ENTERTIME}</td>
							
							</tr>
						 </c:forEach> 
						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
	
	</div>
	  <script src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
      <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/book.js"></script>
      <script type="text/javascript">
      
      //复选框全部选中
      $(function(){
       
      })
      </script>
  </body>
</html>