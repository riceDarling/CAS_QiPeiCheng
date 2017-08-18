$.ajax({
    type: "post",
    url: getUrl + "finance/receivingReportSumByShipper",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
        consignment: $("#consignment option:selected").text(),
        destination: $("#destination option:selected").text()
    },
    success: function (data) {
    	  if (null != data.obj && "" != data.obj) {
        for (var index in data.obj) {
            data.obj[index].waybillId
            var content = "<tr>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].number + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].freight + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].receiverArrears + "</td>"
            content += "<td>" + data.obj[index].returnGoods + "</td>"
            content += "<td>" + data.obj[index].returnGoods + "</td>"
            content += "</tr>"
            $("tbody").append(content)
        }
    	  }
    }
})









$("input[type='radio']").change(function(){
	var data = {};
	if($(this).attr("id") == "rankbyShipper"){
		data.shipper = "shipper"
	}else if($(this).attr("id") == "rankbyTotal"){
		data.total = "total"
	}else if($(this).attr("id") == "rankbyFreight"){
		data.freight = "freight"
	}else if($(this).attr("id") == "rankbyModernCollection"){
		data.modernCollection = "modernCollection"
	}
	
	data.startDate = $("#startDate").val()
	data.endDate = $("#endDate").val()
	data.consignment = $("#consignment option:selected").text()
	data.destination = $("#destination option:selected").text()
	console.log(data)
	$.ajax({
	    type: "post",
	    url: getUrl + "finance/receivingReportSumByShipper",
	    async: true,
	    dataType: "json",
	    timeout: 10000,
	    data: data,
	    success: function (data) {
	        console.log(data)
	        $("tbody").html("")
	        for (var index in data.obj) {
	            data.obj[index].waybillId
	            var content = "<tr>"
	            content += "<td>" + data.obj[index].shipper + "</td>"
	            content += "<td>" + data.obj[index].number + "</td>"
	            content += "<td>" + data.obj[index].total + "</td>"
	            content += "<td>" + data.obj[index].shipperPay + "</td>"
	            content += "<td>" + data.obj[index].receiverPay + "</td>"
	            content += "<td>" + data.obj[index].freight + "</td>"
	            content += "<td>" + data.obj[index].collectionPayment + "</td>"
	            content += "<td>" + data.obj[index].receiverArrears + "</td>"
	            content += "<td>" + data.obj[index].returnGoods + "</td>"
	            content += "<td>" + data.obj[index].returnGoods + "</td>"
	            content += "</tr>"
	            $("tbody").append(content)
	        }

	    }
	})

	
})
$("#rankbyShipper").click();