
$.ajax({
    type: "post",
    url: getUrl + "finance/payforColByShipperDirectionInfos",
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
         	var totalsum2=0;var paymentsum2=0;
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].paid + "</td>"
            content += "</tr>"
            $("#secondPageTbody").append(content)
            totalsum2 += data.obj[index].collectionPayment
			paymentsum2 += data.obj[index].paid
        }
        $("#totalsum2").val(totalsum2);
		$("#paymentsum2").val(paymentsum2);
		//大于一万固定三十，小于一万千分之三
		if (totalsum2 >= 10000) {
			document.getElementById("counterFeesum2").value = "30";
		} else {
			document.getElementById("counterFeesum2").value = (parseInt(totalsum2) * 0.003).toFixed(2)
		}
        }
    }
})