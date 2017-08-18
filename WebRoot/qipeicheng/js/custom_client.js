$("#refresh").bind("click", function() {
	$.ajax({
		type : "post",
		url : getUrl + "customer/getCustomerByCommon",
		xhrFields : {
			withCredentials : true
		},
		async : true,
		dataType : "json",
		timeout : 10000,
		success : function(data) {
			console.log(data)
			$("tbody").html("")
			if (null != data.obj && "" != data.obj) {
				for (var i = 0; i < data.obj.length; i++) {

					var content = "<tr id_xk='" + data.obj[i].id + "'>"
					content += "<td>" + (i + 1) + "</td>"
					content += "<td>" + data.obj[i].customerName + "</td>"
					content += "<td>" + data.obj[i].customerAddress + "</td>"
					content += "<td>" + data.obj[i].customerPhone + "</td>"
					content += "<td>" + data.obj[i].code + "</td>"
					content += "<td>" + data.obj[i].customerContacts + "</td>"
					content += "<td>" + data.obj[i].regionName + "</td>"
					content += "<td>" + data.obj[i].bankCard + "</td>"

					content += "</tr>"
					$("tbody").append(content)
					// $("#business").val(data.obj[i].business)
					// $("#zipCode").val(data.obj[i].zipCode)
					// $("#bankCard").val(data.obj[i].bankCard)
				}

			}
		}
	});
})

$("#refresh").click()