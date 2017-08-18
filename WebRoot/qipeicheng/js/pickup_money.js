if (!$("#runnum").val()) {
    alert("请输入运单号！")
    $("#p_close").click()
} else {
    var id = ""
    var money = ""
    var arrears = ""
    $.ajax({
        type: "post",
        url: getUrl + "waybill/selectByRunnumStatus",
        xhrFields: {
            withCredentials: true
        },
        async: true,
        timeout: 10000,
        dataType: "json",
        data: {
            "runnum": $("#runnum").val()
        },
        success: function (data) {
            console.log(data)
            if (data.t != null) {
                $("#receivera").val(data.t.receiver)
                $("#receiverTotal").val(data.t.receiverTotal)
                $("#mon").val(data.t.receiverTotal)
                $("#receiverArrears").val(data.t.receiverArrears)
                $("#deliver option").eq(0).text(data.t.shipperContacts)
                id = data.t.id
                money = data.t.receiverTotal
                arrears = data.t.receiverArrears
            }
        }
    })

    $("#pay_btn").click(function () {
        $.ajax({
            type: "post",
            url: getUrl + "waybill/pickup",
            xhrFields: {
                withCredentials: true
            },
            async: true,
            timeout: 10000,
            dataType: "json",
            data: {
                id: id,
                money: money,
                arrears: arrears
              /*  counterFee: $("#poindage").val(),
                modernCollection: $("#residu").val()*/
            },
            success: function (data) {
                console.log(data)
               // if (data.msg == "成功") {
                 //   alert("取货成功！")
                    $("tbody").html("")
                    $("#receiver").val("")
                    $("#receiverAddress").val("")
                    $("#shipper").val("")
                    $("#shipperAddress").val("")

                    $("#shipperPhone").val("")
                    $("#receiverPhone").val("")
                    $("#shipperContacts").val("")
                    $("#receiverContacts").val("")
                    $("#remarks").val("")
                    $("#runnum").val("")


                /*} else {
                    alert("取货失败！")
                }*/
            }
        })
    })
}


