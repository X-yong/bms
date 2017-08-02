//alert($)
$(document).ready(function() {//页面加载完成再加载脚本
	$('input[name="loginButton"]').click(function(event) {
		 this.disabled=true; 
        setTimeout(function (){ 
            $("#u1").prop("disabled",false);
         },3000);
         login();
	});
});

function KeyDown()
{
  if (event.keyCode == 13) {
   login();
  }
}


/**
 * 登录
 * @returns
 */
function login() {
	var $loginId = $("#u_id");
	var $password = $('input[name="u_password"]'); 
	var role = $("#role").val(); 
	var $text = $(".text");
	var _name = $.trim($loginId.val());//去掉字符串多余空格
	var _password = $.trim($password.val());
	var res = verifyCode.validate(document.getElementById("code_input").value);
	
	if(_name=='') {
		$text.text('请输入账号');
		$loginId.focus();
		return;
	} else if(_password=='') {
		$text.text('请输入密码');
		$loginId.focus();
		return;
	} 
	if(!res) {
		alert("验证码错误");
		return;
	} else {
	  $.ajax({
			url :"/bms/userLoginController/checkLogin.do",
			data : $("#flogin").serialize(),
			type : "post",
			success : function(result) {
				if (result =="fail") {
					$text.text("用户名或密码错误!!");
			   } else if (result = "success") {
			   	   //$text.text("登陆成功，请稍后...");
			   	   window.location.href=　"/bms/view/mainView.do";　
			   }
			},
			error : function(result) {
			    alert("系统暂时无法登录，请检查您的网络配置是否正确！！");
			}
	  
		}) 		
	}
	
	
}