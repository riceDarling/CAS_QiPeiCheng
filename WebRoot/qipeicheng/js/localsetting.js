getUrl = "http://127.0.0.1:8080/QiPeiCheng/";
$(document).on("click", "[clickToTest]", function() {
	$.ajax({
		type: "post",
		url: getUrl + "waybill/selectWaybillByDate",
		  xhrFields: {
				withCredentials: true
			},
		async: true,
		dataType: "json",
		timeout:10000,
		data: {
			"destinationId":"3"
		},
		success: function(data) {
			console.log(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			console.log(XMLHttpRequest);
			console.log(XMLHttpRequest.status);
			console.log(XMLHttpRequest.readyState);
			console.log(textStatus);
		}
	})
});