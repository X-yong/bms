<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/bms/css/rightmain.css">

	<title>index</title>
	</head>
	<body>
    <div class="container">
      <div class="row">
        <div >
            <dl>
               <dt><label style="color: orange;">最新天气</label></dt>
                 <iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=2&color=%23FFC000&num=5" width="650" height="70" 
                      frameborder="0" marginwidth="0" marginheight="0" scrolling="no" alt="正在加载，请稍后"></iframe>
            </dl>        
        </div>
       <%--   <div >
            <dl>
               <dt><label style="color: orange;">系统信息</label></dt>
                <div>
                 <table class="table" width="100%" id="datalist" style="color: orange;">
						<thead>
							<tr>
								<th>用户编号</th>
								<th>用户名称</th>
								<th>图书编号</th>
								<th>图书名称</th>
								<th>借书时间</th>
								<th>应还时间</th>
							</tr>
						</thead>
						<tbody>
						
						  <c:forEach items="${borrowState}"  var="resultList" varStatus="status">
							<tr onmouseover="style.backgroundColor='#000000'" onmouseout="style.backgroundColor=''">
							    <td>${resultList.u_id}</td>
							    <td>${resultList.u_name}</td> 
								<td>${resultList.bid}</td> 
								<td>${resultList.b_name}</td> 
								<td>${resultList.br_time}</td>
								<td>${resultList.sh_time}</td>
								<td>将逾期</td>
							</tr>
						 </c:forEach> 
						</tbody>
					</table>
                
                
                </div>
            </dl>        
         </div> --%>
      <!--   <div class="col-lg-3 col-md-4 col-sm-6 illu">
                <dl>
                    <dt>系统信息</dt>
                    <dd>
                        <ul>
                            <li>程序版本：V1.0 [20150610]</li>
                            <li>操作系统：WINNT</li> 
                            <li>服务器软件：Apache/2.4.10 (Win32) OpenSSL/0.9.8zb mod_fcgid/2.3.9</li>
                            <li>MySQL 版本：5.5.40</li>
                            <li>上传文件：2M</li>
                        </ul>
                    </dd>
                </dl>
        </div> -->
       
      </div>
      <!-- 第一行结束 -->

    </div>
    <!-- 整个容器结束 -->
    <script src="/bms/public/js/jquery-3.1.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/bms/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
      //alert($)
    </script>
  </body>
</html>