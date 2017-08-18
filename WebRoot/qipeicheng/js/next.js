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

$.ajax({
	type: "post",
	url: getUrl + "waybill/prepareLoadingByRunnum",
	  xhrFields: {
			withCredentials: true
		},
	async: true,
	dataType: "json",
	timeout: 10000,
	data:{
		runnum:getCookie("runnum")
	},
	success: function (data) {
		console.log(data)
		if (null != data.obj && "" != data.obj) {
		for (var index in data.obj) {
			var content = "<tr>"
			content += "<td><input checked type='checkbox' class='choose' chooseId='"+data.obj[index].id+"'/></td>"
			content += "<td>" + (parseInt(index) + 1) + "</td>"
			content += "<td>" + data.obj[index].date + "</td>"
			content += "<td>" + data.obj[index].runnum + "</td>"
			content += "<td>" + data.obj[index].shipper + "</td>"
			content += "<td>" + data.obj[index].receiver + "</td>"
			content += "<td>" + data.obj[index].total + "</td>"
			content += "<td>" + data.obj[index].freight + "</td>"
			content += "<td>" + data.obj[index].premium + "</td>"
			content += "<td>" + data.obj[index].fee + "</td>"
			content += "<td>" + data.obj[index].serviceCharge + "</td>"
			content += "<td>" + data.obj[index].shipperPay + "</td>"
			content += "<td>" + data.obj[index].collectionPayment + "</td>"
			content += "<td>" + data.obj[index].counterFee + "</td>"
			content += "<td>" + data.obj[index].deliveryCharges + "</td>"
			content += "<td>" + data.obj[index].receiverPay + "</td>"
			content += "<td>" + data.obj[index].destination + "</td>"
			content += "</tr>"
			$("tbody").append(content)
			delCookie("runnum")
		}
		}
		$(".choose").change(function () {
			var chooseAllflag = true
			var cancelChooseAll = false;
			$(".choose").each(function (index, el) {
				if (!$(this).is(":checked")) {
					chooseAllflag = false
					cancelChooseAll = true
				} 
			})
			if (chooseAllflag) {
				$("#chooseAll").prop("checked", true)
			}
			if (cancelChooseAll) {
				$("#chooseAll").prop("checked", false)
			}
		})

	}
}) 

$("#chooseAll").change(function () {
	if ($(this).is(":checked")) {
		$(".choose").each(function (index, el) {
			$(this).prop("checked", "true")
		})
	} else {
		$(".choose").each(function (index, el) {
			$(this).prop("checked", false)
		})
		$(this).prop("checked", false)
	}
})

$("#next").click(function () {
	var chooseId="";
	$(".choose").each(function () {
		if ($(this).is(":checked")) {
		chooseId += "id="+$(this).attr("chooseId")+"&" 
			
		}
	})
	var d = chooseId.substring(0, chooseId.lastIndexOf("&"))
	document.cookie="uploadCheckData="+d
	
})

