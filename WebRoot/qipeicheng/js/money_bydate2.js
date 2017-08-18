
$.ajax({
    type: "post",
    url: getUrl + "finance/receivingReportSumByDate",
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
            var content = "<tr>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].number + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].freight + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].returnMoney + "</td>"
            content += "<td>" + data.obj[index].returnGoods + "</td>"
            content += "<td>" + data.obj[index].returnGoods + "</td>"
            content += "</tr>"
            $("tbody").append(content)
        }
    	 }
    }
})