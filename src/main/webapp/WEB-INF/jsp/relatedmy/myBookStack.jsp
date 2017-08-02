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
			<i class="icoh"></i> <span>我的书架</span>
		</div> 
		<div class="operate">
			<div class="list">
				<div class="tablewrap">
				<div style="height:480px">
					<form id="fList">
					<input type="text"  id="mess"value="${mess}" hidden>
					<table class="table" width="100%" id="datalist">
						<thead>
							<tr>
								<th>图书编号</th>
								<th>图书名称</th>
								<th>图书类型</th>
								<th>图书作者</th>
								<th>出版社</th>
								<th>图书价格</th>
								<th>ISBN</th>
								<th>图书版次</th>
								<th>借书时间</th>
								<th>还书时间</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${result}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='#000000'" onmouseout="style.backgroundColor=''">
							    <td>${resultList.B_ID}</td>
								<td>${resultList.B_NAME}</td> 
								<td>${resultList.typename}</td>
								<td>${resultList.B_AUTHOR}</td>
								<td>${resultList.B_PRESS}</td>
								<td>${resultList.B_PRICE} 元</td>
								<td>${resultList.B_ISBN}</td>
								<td>${resultList.B_REVISION}</td>
								<td>${resultList.BR_TIME}</td>
								<td>${resultList.SH_TIME}</td>
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
							<c:when test="${currPage >1 && currPage < allPage}">
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=1">首页</a>
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=${currPage-1}">上一页</a>
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=${currPage+1}">下一页</a>
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=${allPage}">	尾页</a>
							</c:when>
							<c:when test="${currPage==1}">
								<a href="#">首页 </a>
								<a href="#">上一页</a>
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=${currPage+1}">下一页</a>
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=${allPage}">	尾页</a>
							</c:when>
							<c:when test="${currPage==allPage}">
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=1">首页</a>
								<a href="${pageContext.request.contextPath}/admin/page.do?currPage=${currPage-1}">上一页</a>
								<a href="#">下一页</a>
								<a href="#"> 尾页</a>
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
     
      </script>
  </body>
</html>