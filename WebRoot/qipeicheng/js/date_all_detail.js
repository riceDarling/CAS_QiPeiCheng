$.ajax({
    type: "post",
    url: getUrl + "finance/receivingReportSumByDateDirectionInfos",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        // startDate : "",
        // endDate : ""
    },
    success: function (data) {
        console.log(data)
        if (null != data.obj && "" != data.obj) {
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + data.obj[index].consignment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].deliveryCharges + "</td>"
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "<td>" + data.obj[index].fee + "</td>"
            content += "<td>" + data.obj[index].freight + "</td>"
            content += "<td>" + data.obj[index].id + "</td>"
            content += "<td>" + data.obj[index].premium + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].serviceCharge + "</td>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "</tr>"
        }
        }
    }
})