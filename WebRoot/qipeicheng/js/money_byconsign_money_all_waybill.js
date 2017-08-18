

var url = "finance/receivingReportSumByShipperInfos"

$.ajax({
    type: "post",
    url: getUrl + url,
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
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + (parseInt(index) + 1) + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].shipper  + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].freight + "</td>"
            content += "<td>" + data.obj[index].premium + "</td>"
            content += "<td>" + data.obj[index].fee + "</td>"
            content += "<td>" + data.obj[index].serviceCharge + "</td>"
            content += "<td>" + data.obj[index].deliveryCharges + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].receiverArrears + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].returnMoney + "</td>"
            content += "<td>" + data.obj[index].consignment + "</td>"
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "</tr>"
            $("#c").append(content)
        }

    }
})

