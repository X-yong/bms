<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index.css">

<title>图书管理系统</title>
</head>
<body>
	
	<div class="head">
		<div class="headlogo pull-left">
			<h1><a href="javascript:;">菜单管理</a></h1>
		</div> 
		<ul class="headnav pull-left">
			<!-- <li class="menu_0 current_menu" id="m1">
				<a href="javascript:;" >权限管理</a>
			</li> -->
			<li class="menu_0 " id="m1" hidden>
				<a href="javascript:;" >权限管理</a>
			</li>
			<li class="menu_1" id="m2" hidden>
				<a href="javascript:;" >图书管理</a>
			</li>
			<li class="menu_2" id="m3" hidden>
				<a href="javascript:;">用户管理</a>
			</li>
			<li class="menu_3" id="m4" hidden>
				<a href="javascript:;">与我相关</a>
			</li>
			<li class="menu_1 u" id="m5" hidden>
				<a href="javascript:;">我的图书</a>
			</li>
			<li class="menu_1 " id="m6" hidden>
				<a href="javascript:;">其他</a>
			</li>
		</ul>
		<ul class="headlink pull-right">
			<li ><input id = "p1" value="${auth}" style="display: none"/></li>
			<li ><img class="img-circle" style="width: 30px;height: 30px" src="<%=request.getContextPath()%>/${loginInfo.u_photo}"  alt="正在加载" /></li>
			<li class="link_0"><a href="javascript:;"onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">您好，${loginInfo.u_name}</a><div></div></li>
			<li class="link_1"><a href="javascript:;"><span class="ton">隐藏菜单</span></a></li>
	 	    <li class="link_2"><a href="<%=request.getContextPath()%>/view/mainView.do">首页</a></li> 
			<li class="link_3"><a href="javascript:;" id="me1" onclick="showMessage()">消息(0)</a></li> 
			<li class="link_4"><a href="<%=request.getContextPath()%>/view/exit.do">退出</a></li>
		</ul>
	</div>
	<!-- 头部页面结束 -->
	<div class="leftmenu">
		<div class="leftmenu_0 hidden">
			<dl>
				<dt>授权管理</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/view/userPowerInfo.do">权限变更</a></li>
					</ul>
				</dd>
			</dl>

		</div>
		<!-- leftmenu_0结束 -->
		<div class="leftmenu_0 hidden">
			<dl>
				<dt>图书管理</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/view/bookInfo.do">图书信息</a></li>
						<li><a href="javascript:;" _link="/bms/view/borrowBook.do">借书管理</a></li>
						<li><a href="javascript:;" _link="/bms/view/returnBook.do">还书管理</a></li>
						<li><a href="javascript:;" _link="/bms/view/qryBorrowBook.do">借阅查询</a></li>
						<li><a href="javascript:;" _link="/bms/view/qryAppointment.do">预约查询</a></li>
					</ul>
				</dd>
			</dl>
			<dl>
				<dt>电子书管理</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/view/eBook.do">图书信息</a></li>
					</ul>
				</dd>
			</dl>
			<dl>
				<dt>统计管理</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/rankOfBorrowBookController/rankOfBorrowBook.do?b_kind=1">纸书借阅排行</a></li>
						<li><a href="javascript:;" _link="/bms/rankOfBorrowEBookController/rankOfBorrowEBook.do?b_kind=0">电子书下载排行</a></li>
					</ul>
				</dd>
			</dl>
			
		</div>
		<!-- leftmenu_1结束 模块管理 -->
		<div class="leftmenu_0 hidden">
			<dl>
				<dt>读者管理</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/view/userInfo.do">信息维护</a></li>
						
					</ul>
				</dd>
			</dl>
			<dl>
				<dt>作者管理</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/view/authorInfo.do">信息维护</a></li>
					</ul>
				</dd>
			</dl>
		</div>
		
		<div class="leftmenu_0 hidden">
			<dl>
				<dt>我的图书</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/view/searchBook.do">图书搜索</a></li>
						<li><a href="javascript:;" _link="/bms/view/eBookList.do">电子书下载</a></li>
						<li><a href="javascript:;" _link="/bms/view/myBookStack.do">我的书架</a></li>
					</ul>
				</dd>
			</dl>
			<dl>
			    <dt>统计信息</dt>
				<dd>
					<ul class="clearfix">
					
						<li><a href="javascript:;" _link="/bms/rankOfBorrowBookController/rankOfBorrowBook.do?b_kind=1">借阅排行</a></li>
						<li><a href="javascript:;" _link="/bms/rankOfBorrowEBookController/rankOfBorrowEBook.do?b_kind=0">电子书下载排行</a></li>
					</ul>
				</dd>
			</dl>
		</div>
		<div class="leftmenu_0 hidden">
			<dl>
				<dt>我的图书</dt>
				<dd>
					<ul class="clearfix">
					    <li><a href="javascript:;" _link="/bms/view/writeBook.do">我要写书</a></li>
						<li><a href="javascript:;" _link="/bms/view/uploadBook.do">图书上传</a></li>
						<li><a href="javascript:;" _link="/bms/view/myBook.do">我的上传</a></li>

					</ul>
				</dd>
			</dl>
			<dl>
				<dt>统计信息</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;" _link="/bms/rankOfBorrowEBookController/rankOfBorrowEBook.do?b_kind=0">电子书下载排行</a></li>

					</ul>
				</dd>
			</dl>
		</div>
	    <div class="leftmenu_0 hidden ">
			<dl>
				<dt>其他</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;"_link="/bms/view/persionInfo.do">个人信息</a></li>
						<li><a href="javascript:;"_link="/bms/view/resetPsw.do">密码修改</a></li>
						 <li><a href="javascript:;"_link="/bms/view/leaveMessage.do">留言板</a></li>
						<!--<li><a href="javascript:;">关于</a></li> -->
						

					</ul>
				</dd>
				<dt>友情链接</dt>
				<dd>
					<ul class="clearfix">
						<li><a href="javascript:;"_link="http://www.nlc.cn/">国家图书馆</a></li>
						<li><a href="javascript:;"_link="http://www.qnwz.cn/index.html">青年文摘</a></li>
						<li><a href="javascript:;"_link="http://yuedu.163.com/index">网易云阅读</a></li>
						<li><a href="javascript:;"_link="http://read.szrmf.com/">素心书斋</a></li>
						<li><a href="javascript:;"_link="http://www.zongheng.com/">纵横中文网</a></li>
					</ul>
				</dd>
			</dl>
		</div>
	 
	  </div>
	<!-- 左边导航结束 -->
	<div class="rightmain" id="rightmain">
		<div class="rightcontent">
			 <iframe src="<%=request.getContextPath()%>/index.jsp" id="main" name="main" frameborder="0" scrolling="yes"></iframe> 
		</div>
	</div>

	  <script src="<%=request.getContextPath()%>/public/js/jquery-3.1.1.js"></script>
      <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	  <script src="<%=request.getContextPath()%>/public/js/banner.js"></script>
	  <script src="<%=request.getContextPath()%>/js/empower.js"></script>
	  <script src="<%=request.getContextPath()%>/js/common.js"></script>
	  <script type="text/javascript"> 

	  function showDetail(flag, a) {
          var detailDiv = a.parentNode.getElementsByTagName("div")[0];
          if (flag) {
              detailDiv.style.display = "block";
          }
          else
             detailDiv.style.display = "none";
      }
 
	    //导航经过改变宽度和颜色
		$(".headnav li").click(function(){
			var index = $(this).index();
			//alert(index);
			$(this).addClass("current_menu").siblings().removeClass('current_menu');
			//头部导航和左边导航对应
			$(".leftmenu").find(".leftmenu_0").eq(index).removeClass("hidden").siblings().addClass('hidden');

		});
		//头部导航和左边导航对应
		// bannerplay($(".leftmenu"),$(".leftmenu_0"),$(".headnav li"),4,false,2);
        
		//左边导航点击上拉
		$(".leftmenu dl dt").click(function(){
			 if(false == $(this).siblings("dd").is(":visible")){//如果不可见点击后变蓝色
			 	$(this).css('background-position','right -30px');
			}else{
				$(this).css('background-position','right 0px');//可见点击后变红色
			}

			$(this).siblings('dd').slideToggle('fast').siblings('dt');//.end()

		});
		//点击隐藏菜单
		var i=1;
		
		//替换文字并显示隐藏左侧导航
		function replace(){
			var i=1;
			var x=$(".link_1");
			var y=$(".ton");
			y.click(function(){
				i++;
				if(i%2==0){
					//alert(i)
					 y.text("显示菜单");
					 $('#rightmain').addClass('rightmain1').removeClass('rightmain'); 
				}else{
					y.text("隐藏菜单");
					$('#rightmain').addClass('rightmain').removeClass('rightmain1'); 
				}
				
			})
			var j = 1;
			x.click(function(){
			j++;
			//alert(j);
			
			j%2==0 ? $(".leftmenu").css('display','none') : $(".leftmenu").css('display','block');
		})
	}
		replace();

		//左侧导航切换出右侧页面ifream
		$(".leftmenu dl dd ul li a").click(function(){
			var _link = $(this).attr('_link');
			//alert(_link)
		$("#main").attr('src',_link);
		$(this).addClass('current-menuleft').parent().siblings().children().removeClass('current-menuleft');
		$(this).parents('dl').siblings().find('dd ul li a').removeClass('current-menuleft');

		});
		
		setInterval(myrefresh,5000); //自动调用查询消息数量
	</script>
</body>
</html>