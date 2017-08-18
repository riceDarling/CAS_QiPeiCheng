/*$.ajax({
	type : "post",
	url : getUrl + "/admin/getAllAdminInfo",
	dataType : "json",
	timeout : 10000,
	async : true,
	success : function(data) {
		console.log(data)
		var options = ""
		for ( var index in data.obj) {
			options += "<option value='" + data.obj[index].id + "'>" + data.obj[index].adminName + "</option>"
		}
		$("select[name='username']").html(options);
	}
})*/

$("#login-button").bind("click", function() {
	// console.info("点击了登录");
	//var userName = $(".username").find("option:selected").text();
	var userName =$("#username").val();
	// console.info(userName)
	var userPass = $("#password").val();
	// console.info(userPass);
	if ((userName == "" || userName == null) && userPass == "" || userPass == null) {
		alert("用户名和密码不能为空!");
		return false;
	} else if (userName == "" || userName == null) {
		alert("用户名不能为空!");
		return false;
	} else if (userPass == "" || userPass == null) {
		alert("密码不能为空!");
		return false;
	} else {
		$.ajax({
			type : "post",
			url : getUrl + "admin/login",
			dataType : "json",
			data : {
				"adminName" : userName,
				"adminPwd" : userPass
			},
			xhrFields: {
				withCredentials: true
			},
			async: true,
			timeout: 5000,
			success : function(data) {
				console.log(data)
				if (data.success == true) {
					document.cookie = "name=" + data.t.adminName
					if (data.t.power == "超级管理员") {
						window.location.href = "admin_index.html"
					} else if (data.t.power == "会计") {
						window.location.href = "finance_index.html"
					} else if (data.t.power == "业务员") {
						window.location.href = "client_index.html"
					}
				} else if (data.msg = "用户名或密码不匹配!") {
					alert("用户名或密码错误！")
				}

			}
		})
	}
})

function time() {
	var time = new Date();
	var y = time.getFullYear();
	var m = time.getMonth() + 1;
	if (m < 10)
		m = '0' + m
	var d = time.getDate();
	if (d < 10)
		d = '0' + d
	var h = time.getHours();
	if (h < 10)
		h = '0' + h
	var mi = time.getMinutes();
	if (mi < 10)
		mi = '0' + mi
	var s = time.getSeconds();
	if (s < 10)
		s = '0' + s
	return y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
}

document.getElementById("time").value = time();
