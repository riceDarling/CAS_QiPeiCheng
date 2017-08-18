$.ajax({
    type: "post",
    url: getUrl + "finance/forCollectionSumByDestination",
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
            data.obj[index].waybillId
            var content = "<tr>"
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "</tr>"
            $("#tbody").append(content)
        }
        }
    }
})