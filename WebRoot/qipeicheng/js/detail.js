$.ajax({
    type: "post",
    url: getUrl + "finance/oweForColSchedule",
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
            content += "<td>" + data.obj[index].destination + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].returnMoney + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].receiverTotal + "</td>"
            content += "</tr>"
            $("tbody").append(content)
        }
        }
    }
})

$("#query").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + "finance/oweForColScheduleByRunnum",
        async: true,
        dataType: "json",
        timeout: 10000,
        data: {
           "runnum":$("#runnum").val()
        },
        success: function (data) {
            console.log(data)
            $("tbody").html("");
            for (var index in data.obj) {
                var content = "<tr>"
                content += "<td>" + data.obj[index].destination + "</td>"
                content += "<td>" + data.obj[index].date + "</td>"
                content += "<td>" + data.obj[index].shipper + "</td>"
                content += "<td>" + data.obj[index].receiver + "</td>"
                content += "<td>" + data.obj[index].runnum + "</td>"
                content += "<td>" + data.obj[index].collectionPayment + "</td>"
                content += "<td>" + data.obj[index].returnMoney + "</td>"
                content += "<td>" + data.obj[index].counterFee + "</td>"
                content += "<td>" + data.obj[index].receiverTotal + "</td>"
                content += "</tr>"
                $("tbody").append(content)
            }

        }
    })
})