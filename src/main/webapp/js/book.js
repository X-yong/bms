$(function(){
  
	//填充下拉列表
 	var a = $("#t1").val();
 	$("#type").val(a);
 	var message = $("#mess").val();
		if (message != undefined && message != null && message != "") {
			alert(message);
		} 
  
})


function searchAll(a) {
	window.location.href ="/bms/qryBookController/qryBookInfo.do?b_kind="+a;
}
function searchAllAppointment() {
	window.location.href ="/bms/qryAppointmentController/qryAppointment.do";
}
function addBookInfo() {
	window.location.href ="/bms/view/addBook.do";
}
function returnView() {
	window.location.href ="/bms/view/bookInfo.do";
}
function returnBookInfoView() {
	window.location.href ="/bms/view/bookInfo.do";
}

/**
 * 删除图书
 * @returns
 */
function deleteBook() {
	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择至少一条记录");
		return;
	}
	var a = window.confirm("您确认要删除吗?");
	if (a) {
		$.ajax({
			 url:'/bms/deleteBookController/deleteBook.do',
			 data:$("#fList").serialize(),
			 type:"post",
			 success:function(result){
			 	if(result == "success"){
			 	 //  alert("删除成功");
			 	   window.location.href ="/bms/qryBookController/qryBookInfo.do?b_kind=1";
			 	 } else {
			 		 
			 		 alert(result);
			 	 }
			  },
			  error: function(result) {
				    alert("发生系统错误！");
			  } 
		})
	}
	
}

function importBook () {
	
	$("#d1").show()
}
function searchBook() {
	
	var b_id = $("#bu1").val();
	var b_name = $("#bn1").val();
	if (b_id =="" && b_name =="") {
		alert("请输入图书id或者图书名称");
		return;
	}
	$("#f1").submit();
}

function searchReturnBook() {
	var u_id = $("#uid1").val();
	if (u_id == null || u_id == "") {
		alert("请输入用户ID");
		return;
	}
	$("#f1").submit();
	
}
function resetValue() {
   $("#bu1").val("");
   $("#bn1").val("");
}
/**
 * 借书
 * @returns
 */
function borrowBook() {
	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择至少一条记录");
		return;
	}
	var b_time = $("#b_time").val();
    if(b_time ==null || b_time =="") {
    	alert("请输入借书天数");
    	return;
    }
	var u_id = $("#u_id").val(); 
	$("#fList").attr("action", "/bms/borrowBookController/borrowBook.do?u_id="+u_id+"&b_time="+b_time);
	$("#fList").submit();
}
function returnBook() {

	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择至少一条记录");
		return;
	}
	$("#fList").submit();
}
function resetUid() {
	 $("#uid1").val("");
}
function linkAge(a) {
	if($('#'+a+"").is(':checked')) {		
		$("#"+a+"1").attr('checked',true);
	} else {
		$("#"+a+"1").attr('checked',false);
	}
}
function searchAllBorrowBook() {
	window.location.href ="/bms/qryBorrowAndReturnBookController/qryBorrowAndReturnBook.do";
}
/**
 * 预约借阅
 * @returns
 */
function borrowAppointment() {
	$("#fList").attr("action", "/bms/borrowAppointmentController/borrowAppointment.do");
	$("#fList").submit();
}

function deleteMyBook() {
	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择至少一条记录");
		return;
	}
	var a = window.confirm("您确认要删除吗?");
	if (a) {
		$.ajax({
			 url:'/bms/deleteBookController/deleteBook.do',
			 data:$("#fList").serialize(),
			 type:"post",
			 success:function(result){
			 	if(result == "success"){
			 	 //  alert("删除成功");
			 	   window.location.href ="/bms/qryMyUploadBookController/qryMyUploadBook.do?b_kind=0";
			 	 }
			  },
			  error: function(result) {
				    alert("发生系统错误！");
			  } 
		})
	}
}
/**
 * 保存图书
 * @returns
 */
function saveBook(a) {
	
	var bname = $("#b_name").val()
	var text = $("#contentext").val();
	$.ajax({
		 url:'/bms/saveBookController/saveBook.do',
		 data:{'content':text,'b_name':bname },
		 type:"post",
		 success:function(result){
		 	if(result == "success"){
		 	 alert("保存成功");
		 	closeBg();
		 	}
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
	})
}
/**********************分页*****************************/
function userInfoPaging(page) {
    $("#currPage").val(page);
	$("#f1").submit();
	
}
function returnEbookList() {
	 window.location.href ="/bms/view/eBookList.do"
}
/**
 * 评价图书
 * @returns
 */
function addComment() {
	var bid = $("#bid").val();
	$.ajax({
		 url:'/bms/addCommentController/addComment.do',
		 data:$("#c1").serialize(),
		 type:"post",
		 success:function(result) {
		 	if(result == "success"){
		 	   alert("评论成功");
		 	   window.location.href ="/bms/view/eBookDownload.do?bid="+bid;
		 	 }
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
	})
}
function closeComment(){
	$("#comment").val("");
	$("#cd1").css('display','none');
}
function showComment(){
	$("#cd1").css('display','block');
}
function endAppoint(){
	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择至少一条记录");
		return;
	}
	var a = window.confirm("您确认要结束吗?");
	if (a) {
		$("#fList").submit();
	}
	
}

