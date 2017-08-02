$(function(){
	//设置用户状态
	var val = $("#stateSelect").val() 
	$("#u_state").val(val);
	
	/**
	 * 防重复提交按钮
	 */
     $("#u1").click(function(){
    	 this.disabled=true; 
         setTimeout(function (){ 
        	 $("#u1").disabled=false; 
         },3000);
    	 
     })
     var message = $("#mess").val();
		if (message != undefined && message != null && message != "") {
			alert(message);
		} 
})

/**
 * 校验两次密码是否一致
 * @returns
 */
function checkPsw() {
	
	var firstPsw = $("#u_rpassword").val();
	var secondPsw = $("#u_spassword").val();
	debugger;
	if (firstPsw != secondPsw) {
		$("#u_spassword").val("")
		alert("两次密码不一样，请确认！");
	}
	
}
function cancel() {
	window.location.href ="/bms/view/login.do";
}

/**
 * 查询用户信息
 * @returns
 */
function search() {
	$("#f1").submit();
	/*$.ajax({
		 url:'/bms/qryUserController/qryUserInfo.do',
		 data:$("#f1").serialize(),
		 type:"post",
		 success:function(result){
		 	if(result == "fail"){
		 	  alert("查询失败！");
		 	 }
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		} 
	})
*/}
function searchAll(a) {
	window.location.href ="/bms/qryUserController/qryUserInfo.do?u_role="+a;
}
/**
 * 检测重复账号
 * @returns
 */
function checkRepeat() {
	var u_id = $("#u_id").val();
	if (u_id =="") {
		alert("请输入Id");
		return
	}
	$.ajax({
		 url:'/bms/qryUserController/qryRepeat.do?root=1',
		 data:{u_id:u_id},
		 type:"post",
		 success:function(result){
		 	if(result == "yes"){
		 	    alert("该账号可以使用！");
		 	    $("#register").show();
		 	 } else {
		 		alert("账号重复！！");
		 	 }
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
    })
}
/**
 * 修改信息
 * @returns
 */
/*function updateInfo() {
	
	$.ajax({
		 url:'/bms/updateUserController/updateUser.do',
		 data:$("#fupdate").serialize(),
		 type:"post",
		 success:function(result){
		 	if(result != "fail"){
		 	   window.location.href ="/bms/qryUserController/qryUserInfo.do";
		 	 }
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
	})
}*/
//返回读者查询界面
function returnView() {
	var a = $("#auth_id").val()
	window.location.href ="/bms/qryUserController/qryUserInfo.do?u_role="+a;
}

function addUserInfo() {
	window.location.href ="/bms/view/addUserInfo.do";
	
}
/**
 * 删除信息
 * @returns
 */
function deleteUser() {
	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择至少一条记录");
		return;
	}
	var a = window.confirm("您确认要删除吗?");
	if (a) {
		$.ajax({
			 url:'/bms/deleteUserController/deleteUser.do',
			 data:$("#fList").serialize(),
			 type:"post",
			 success:function(result){
			 	if(result == "success"){
			 	   alert("删除成功");
			 	   window.location.href ="/bms/qryUserController/qryUserInfo.do?u_role=3";
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


/**
 * 修改信息
 * @returns
 */
function resetPsw() {
   var u_password = $("#u_password").val();
   if (u_password == "") {
	 alert("请输入原始密码");
	 return
   }
	$.ajax({
		 url:'/bms/updatePswController/resetPsw.do',
		 data:$("#fresetPsw").serialize(),
		 type:"post",
		 success:function(result){
		 	if(result == "success"){
		 		alert("修改成功，请用新密码登录");
		 		window.parent.location.href ="/bms/view/login.do";
		 	 } else if (result == "noAccordant") {
		 		alert("原始密码错误，请重新输入") 
		 	 } else {
		 		 alert("修改失败");
		 	 }
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
	})
}
/**
 * 找回密码
 * @returns
 */
function getBackPsw() {

	$.ajax({
		 url:'/bms/updatePswController/resetPsw.do',
		 data:$("#getBankPsw").serialize(),
		 type:"post",
		 success:function(result){
		 	if(result == "success"){
		 		alert("密码重置成功，请用新密码登录");
		 		window.parent.location.href ="/bms/view/login.do";
		 	 } else if (result == "fail") {
		 		 alert("修改失败");
		 	 }
		  },
		  error: function(result) {
			    alert("发生系统错误！");
		  } 
	})
}
function flag() {
	$("#f1").submit();
}
function returnMessage() {
	var choose = $("input[type='checkbox']").is(':checked');
	if (!choose) {
		alert("请选择接收方ID");
		return;
	}
	$("#f1").attr("action","/bms/saveMessageController/saveMessage.do")
	$("#f1").submit();
}
function showDiv() {
	$("#m1").show()
}
function closeDiv() {
	$("#m1").hide()
}
function linkAge(a) {
	if($('#'+a+"").is(':checked')) {		
		$("#"+a+"1").attr('checked',true);
	} else {
		$("#"+a+"1").attr('checked',false);
	}
}
/**********************分页*****************************/
function userInfoPaging(page) {
    $("#currPage").val(page);
	$("#f1").submit();
	
}
function messagePaging(page) {
    $("#currPage").val(page);
    $("#f1").attr("action","/bms/qryMessageController/qryMessage.do")
	$("#f1").submit();
	
}

