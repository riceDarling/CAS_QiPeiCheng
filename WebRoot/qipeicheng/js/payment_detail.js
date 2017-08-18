$.ajax({
    type: "post",
    url: getUrl + "finance/payforColPaymentDetail",
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
            content += "<td>" + (parseInt(index) + 1) + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].paid + "</td>"
            content += "<td>" + data.obj[index].consignment + "-------->" + data.obj[index].destination+ "</td>"
            content += "</tr>"
            $("tbody").append(content)
        }
        }
    }
})

$("#query_btn").click(function () {
    
    $.ajax({
        type: "post",
        url: getUrl + "finance/payforColPaymentDetailByRunnum",
        async: true,
        dataType: "json",
        timeout: 10000,
        data: {
            'runnum': $("#runnum").val()
        },
        success: function (data) {
            $("tbody").html("")
            console.log(data)
            if (null != data.obj && "" != data.obj) {
            for (var index in data.obj) {
                var content = "<tr>"
                content += "<td>" + (parseInt(index) + 1) + "</td>"
                content += "<td>" + data.obj[index].date + "</td>"
                content += "<td>" + data.obj[index].runnum + "</td>"
                content += "<td>" + data.obj[index].shipper + "</td>"
                content += "<td>" + data.obj[index].receiver + "</td>"
                content += "<td>" + data.obj[index].collectionPayment + "</td>"
                content += "<td>" + data.obj[index].counterFee + "</td>"
                content += "<td>" + data.obj[index].paid + "</td>"
                content += "<td>" + data.obj[index].consignment + "-------->" + data.obj[index].destination + "</td>"
                content += "</tr>"
                $("tbody").append(content)
            }
            }
        }
    })
})