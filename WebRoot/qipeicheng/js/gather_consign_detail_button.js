
$.ajax({
    type: "post",
    url: getUrl + "finance/forCollectionSumByShipperInfos",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
    },
    success: function (data) {
        console.log(data)
        if (null != data.obj && "" != data.obj) {
        for (var index in data.obj) { 
            var content = "<tr>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "</tr>"
            $("#secondPageTbody").append(content)
        }
        }
    }
})