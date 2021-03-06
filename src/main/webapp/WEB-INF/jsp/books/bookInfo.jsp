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
			<i class="icoh"></i> <span>图书信息</span>
		</div> 
		<div class="operate">
			<div class="pull-left">
			<form id="f1"  method="post" action="${pageContext.request.contextPath}/qryBookController/qryBookInfo.do?b_kind=1">
				  <input type="text"  id="mess" value="${mess}" hidden/>
				  <input type="text"  id="currPage" name="currPage" value="1" hidden/>
			    编号：<input type = "text" name="b_id" class="textController" style="width: 120px" value="${echo.b_id}" />
			    名称：<input type = "text" name="b_name" class="textController" value="${echo.b_name}" />
			    类型：<select id="state" name="b_type" class="textController" style="width: 80px;background-color: black;">
			       <option value="">请选择</option> 
			       <c:forEach items="${bookType}"  var="bookTypeList" varStatus="status">
					   <option value="${bookTypeList.typeid}">${bookTypeList.typename}</option>
					</c:forEach>
				 </select>
			    录入时间：<input  type="text" id="startDate" name="startDate" class="textController" style="width: 120px" value="${echo.b_startDate}"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}'})"/>
			        - <input  type="text" id="endDate"  name="endDate"  class="textController" style="width: 120px" value="${echo.b_endDate}"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}'})"/>   
				<input type="submit" value="查询"  class="btn  btn-info">
				<input type="button" value="查询所有" onclick="searchAll(1)"  class="btn btn-info">
			    <input type="button" value="新增" onclick="addBookInfo()" id="addBook" class="btn btn-success"> 
			    <a href="javascript:showBg();" class="btn btn-primary btn-large">导入</a>
				<input type="button" value="删除" onclick="deleteBook()" class="btn btn-danger">
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
							<tr onmouseover="style.backgroundColor='gray'" onmouseout="style.backgroundColor=''">
								<td ><input type="checkbox" value="${resultList.b_id}" name="checks"></td>
							    <td><a href="${pageContext.request.contextPath}/view/updateBookInfo.do?b_id=${resultList.b_id}">${resultList.b_id}</a></td>
								<td>${resultList.b_name}</td> 
								<td>${resultList.typename}</td>
								<td>${resultList.b_author}</td>
								<td>${resultList.b_press}</td>
								<td>${resultList.b_price} 元</td>
								<td>${resultList.b_isbn}</td>
								<td>${resultList.b_revision}</td>
								<td>${resultList.b_stock} 本</td>
								<td>${resultList.b_enterTime}</td>
								<td>${resultList.b_remark}</td>
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
	<!-- 弹出框 -->
	 <form  method="post" action="${pageContext.request.contextPath}/importBookController/importBook.do" enctype="multipart/form-data">
	 <div id="fullbg"></div>  
         <div id="dialog">  
             <p class=""  >
                 <font style="font-size: large; color: black;">图书导入</font></p>
                 <div>
                     <div class="form-group">
			              <div class="col-lg-4">
                             <input type="file" style="height: 45px" class="form-control" accept=".xls,.xlsx"  name="file"/>
			              </div>              
			         </div>
			         <a href="${pageContext.request.contextPath}/templeDoloadController/templeDoload.do?filename=bookImportTemplate">图书导入模板下载</a>
                     <input type="submit" value="导入" onclick="importBook()" id="importBook" class="btn btn-success">
                     <input type="button" value="取消" onclick="closeBg()"  class="btn btn-danger"> 
				 
			     </div>  
         </div>
         </form>	
      <!-- 弹出框结束 --> 
	  <script src="${pageContext.request.contextPath}/public/js/jquery-3.1.1.js"></script>
      <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
      <script src="${pageContext.request.contextPath}/js/book.js"></script>
      <script src="${pageContext.request.contextPath}/js/div.js"></script>
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