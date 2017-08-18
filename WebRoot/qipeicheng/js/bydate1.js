$.ajax({
    type: "post",
    url: getUrl + "finance/payforColByDate",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        startDate : $("#startDate").val(),
        endDate : $("#endDate").val(),
        consignment: $("#consignment option:selected").text(),
        destination: $("#destination option:selected").text()
    },
    success: function (data) {
        if (null != data.obj && "" != data.obj) {
        	var totalsum=0;var paymentsum=0;
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].paid + "</td>"
            totalsum += data.obj[index].collectionPayment
			paymentsum += data.obj[index].paid
            content += "</tr>"
            $("tbody").append(content)
        }
        $("#totalsum").val(totalsum);
		$("#paymentsum").val(paymentsum);
		//大于一万固定三十，小于一万千分之三
		if (totalsum >= 10000) {
			document.getElementById("counterFeesum").value = "30";
		} else {
			document.getElementById("counterFeesum").value = (parseInt(totalsum) * 0.003).toFixed(2)
		}
	//	document.getElementById("residu").value = (total - $("#poindage").val()).toFixed(2);
		
        }
    }
})