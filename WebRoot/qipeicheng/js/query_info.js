	$.ajax({
	    type: "post",
	    url: getUrl + "customer/getCustomerByName",
	    xhrFields: {
			withCredentials: true
		},
	    async: true,
	    dataType: "json",
	    timeout: 10000,
	    data: {
	        "customerName":$("#qu-c").val()
	    },
	    success: function (data) {
	        console.log(data)
	        if (null != data.obj && "" != data.obj) {
	        for (var index in data.obj) {
	            var content = "<tr>"
	            content += "<td>" + data.obj[index].customerName + "</td>"
	            content += "<td>" + data.obj[index].customerAddress + "</td>"
	            content += "<td>" + data.obj[index].customerPhone + "</td>"
	            content += "<td>" + data.obj[index].customerContacts + "</td>"
	            content += "<td>" + data.obj[index].bankCard + "</td>"
	            content += "<td>" + data.obj[index].regionName + "</td>"
	            content += "</tr>"
	            $("#secondPageTbody").append(content)
	        }
	        }
	    }
	})
	
