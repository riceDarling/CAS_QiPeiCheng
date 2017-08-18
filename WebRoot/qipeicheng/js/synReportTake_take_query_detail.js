$.ajax({
    type: "post",
    url: getUrl + "finance/synReportTakeInfos",
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
        console.log(data)
        if (null != data.obj && "" != data.obj) {
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + data.obj[index].consignment + "</td>"
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "<td>" + data.obj[index].network + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "<td>" + data.obj[index].weight + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].cost + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].modernCollection + "</td>"
            content += "<td>" + data.obj[index].returnMoney + "</td>"
            content += "<td>" + data.obj[index].paid + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "</tr>"
            $("#secondPageTbody").append(content)
        }
        }
    }
}) 