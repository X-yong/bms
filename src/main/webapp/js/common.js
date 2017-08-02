/**
 * 检查时间
 * @returns
 */
function checkTime() {
   var startDate = $("#startDate").val();
   var endDate = $("#endDate").val();
   alert(startDate);
   alert(endDate);
   if (startDate > endDate) {
	alert("结束日期不能小于开始日期！");
  }
}
/**
 * 校验两次密码是否一致
 * @returns
 */
function checkPsw() {
	var firstPsw = $("#u_password").val();
	var secondPsw = $("#u_rpassword").val();
	if (firstPsw != secondPsw) {
		$("#u_rpassword").val("")
		alert("两次密码不一样，请确认！");
	}
	
}
function showMessage() {
	$("#main").attr("src", "/bms/qryMessageController/qryMessage.do");
}
function myrefresh() {
	$.ajax({
		 url:'/bms/refreshController/refresh.do',
		 type:"post",
		 success:function(result) {
			 if (result != "") {
				 $("#me1").text("消息("+result+")");
			}
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
	})
}