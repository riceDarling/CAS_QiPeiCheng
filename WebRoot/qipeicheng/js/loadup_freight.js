$.ajax({
    type: "post",
    url: getUrl + "finance/loadingReportShipper",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
        consignment: $("#shipperAddress option:selected").val(),
        destination: $("#getRegion option:selected").val()
    },
    success: function (data) {
        console.log(data)
        if (null != data.obj && "" != data.obj) {
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + (parseInt(index) + 1) + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].freight + "</td>"
            content += "<td>" + data.obj[index].premium + "</td>"
            content += "<td>" + data.obj[index].fee + "</td>"
            content += "<td>" + data.obj[index].serviceCharge + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].deliveryCharges + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "</tr>"
            $("tbody").append(content)
        }
        }
    }
})