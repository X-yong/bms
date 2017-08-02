//判断用户权限，显示相应菜单

$(function() {

	var power = $("#p1").val();
	if (power != null && power != "") {
		if (power.indexOf('1') != -1) {
			$("#m1").show();
			$("#m2").show();
			$("#m3").show();

		}
		if (power.indexOf('2') != -1) {
			//作者权限
			$("#m5").show();

		}
		if (power.indexOf('3') != -1) {
			//读者权限
			$("#m4").show();

		}
		$("#m6").show();
	} else {

	}
})
/**
 * 查询用户信息
 * @returns
 */
function search() {
	$("#f1").submit();
}
function searchAll(a) {
	window.location.href = "/bms/powerChangeController/powerChange.do?u_role="+ a;
}

function returnView() {
	window.location.href = "/bms/view/userPowerInfo.do";
}
