
$.ajax({
	type: "post",
	url: getUrl + "/waybill/prepareLoading",
	  xhrFields: {
			withCredentials: true
		},
	async: true,
	dataType: "json",
	timeout: 10000,

	success: function (data) {
		console.log(data)
		if (null != data.obj && "" != data.obj) {
		for (var index in data.obj) {
			var content = "<tr>"
			content += "<td class='uq_checkbox'><input type='checkbox' class='choose' chooseId='"+data.obj[index].id+"'/></td>"
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

