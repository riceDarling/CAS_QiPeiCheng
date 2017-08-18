$.ajax({
    type: "post",
    url: getUrl + "finance/payforColByShipperDirection",
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
        var numsum=0;	var totalsum=0;var paymentsum=0;
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].paid + "</td>"
            content += "<td>" + data.obj[index].consignment + "</td>"
            content += "</tr>"
            $("tbody").append(content)
            numsum+=data.obj[index].total;
            totalsum += data.obj[index].collectionPayment
            counterFeesum += data.obj[index].counterFee
			paymentsum += data.obj[index].paid
        }
        $("#numsum").val(numsum);
        $("#totalsum").val(totalsum);
		$("#paymentsum").val(paymentsum);
		//大于一万固定三十，小于一万千分之三
		if (totalsum >= 10000) {
			document.getElementById("counterFeesum").value = "30";
		} else {
			document.getElementById("counterFeesum").value = (parseInt(totalsum) * 0.003).toFixed(2)
		}
        }
    }
})