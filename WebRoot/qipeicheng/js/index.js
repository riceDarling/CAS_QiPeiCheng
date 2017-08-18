function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}
var name = getCookie("name")

$.ajax({
    type: "post",
    url: getUrl + "admin/getPower",
    dataType: "json",
    data: {
        "adminName": name
    },
    xhrFields: {
        withCredentials: true
    },
    async: true,
    timeout: 5000,
    success: function (data) {
        if (data.t != null) {
            var url = window.location.href
            url = url.substring(url.lastIndexOf("/")+1, url.length)
            if (data.t.power == "超级管理员") {
                
            } else if (data.t.power == "会计") {
                if (url != "finance_index.html") {
                    window.location.href = "finance_index.html"
                }
            } else if (data.t.power == "业务员") {
                if (url != "client_index.html") {
                    window.location.href = "client_index.html"
                }
            }
        }

    }
})


$("#username").text(name)

if (name == null || name == "") {
    window.location.href = "/QiPeiCheng/qipeicheng/login.html"
}
function sumAll(){
	var sumnum=0;
	if(arguments[0] instanceof Array){
		for(var one in arguments[0]){
			sumnum+=arguments[0][one]*1;
		}
	}else{
		for(var one in arguments){
			sumnum+=arguments[one]*1;
		}
	};
	return sumnum;
}
function soundplay() {
	var ua = navigator.userAgent.toLowerCase();
	if(ua.match(/msie ([\d.]+)/)) {
		jQuery('#alert_sound').html('<object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95"><param name="AutoStart" value="1" /><param name="Src" value="img/test.mp3" /></object>');
	} else if(ua.match(/firefox\/([\d.]+)/)) {
		jQuery('#alert_sound').html('<embed src="img/test.mp3" type="audio/mp3" hidden="true" loop="false" mastersound></embed>');
	} else if(ua.match(/chrome\/([\d.]+)/)) {
		jQuery('#alert_sound').html('<audio src="img/test.mp3" type="audio/mp3" autoplay=”autoplay” hidden="true"></audio>');
	} else if(ua.match(/opera.([\d.]+)/)) {
		jQuery('#alert_sound').html('<embed src="img/test.mp3" hidden="true" loop="false"><noembed><bgsounds src="img/test.mp3"></noembed>');
	} else if(ua.match(/verzsion\/([\d.]+).*safari/)) {
		jQuery('#alert_sound').html('<audio src="img/test.mp3" type="audio/mp3" autoplay=”autoplay” hidden="true"></audio>');
	} else {
		jQuery('#alert_sound').html('<embed src="img/test.mp3" type="audio/mp3" hidden="true" loop="false" mastersound></embed>');
	}
}

