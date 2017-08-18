// $("#loaded").click(function () {

//     var data = "id=11"
//     console.log(data)
//     $.ajax({
//         type: "post",
//         url: getUrl + "waybill/loaded",
//         async: true,
//         dataType: "json",
//         timeout: 10000,
//         data: data,
//         success: function (data) {
        
//             console.log(data)
           

//         }
//     }) 
    
// })


 

(function() {
	var data = getCookie("uploadCheckData")
	console.log("data=" + data)
	$.ajax({
		type : "post",
		url : getUrl + "waybill/uploadCheck",
		xhrFields : {
			withCredentials : true
		},
		dataType : "json",
		timeout : 10000,
		data : data,
		success : function(data) {
			console.log(data)
			var content = "";
		 if(null != data.obj && "" != data.obj){
			var parm="";
			for ( var i in data.obj) {
				content += "<tr>"
				content += "<td>" + (parseInt(i) + 1) + "</td>"
				content += "<td>" + data.obj[i].date + "</td>"
				content += "<td>" + data.obj[i].runnum + "</td>"
				content += "<td>" + data.obj[i].shipper + "</td>"
				content += "<td>" + data.obj[i].receiver + "</td>"
				content += "<td>" + data.obj[i].total + "</td>"
				content += "<td>" + data.obj[i].freight + "</td>"
				content += "<td>" + data.obj[i].premium + "</td>"
				content += "<td>" + data.obj[i].fee + "</td>"
				content += "<td>" + data.obj[i].serviceCharge + "</td>"
				content += "<td>" + data.obj[i].shipperPay + "</td>"
				content += "<td>" + data.obj[i].collectionPayment + "</td>"
				content += "<td>" + data.obj[i].counterFee + "</td>"
				content += "<td>" + data.obj[i].receiverPay + "</td>"
				content += "<td>" + data.obj[i].destination + "</td>"
				content += "</tr>"
				parm+=data.obj[i].id;
				if(i < data.obj.length-1){
					parm+=" ";
				}
				// }
			}
			$("#verificationUpload").attr("parm",parm);
			$("#secondPageTbody").html(content)
		}
		},
		error : function(data) {
			console.log(data)
		}
	})

})()


function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}
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

$("[time]").val(time());
