$.ajax({
    type: "post",
    url: getUrl + "admin/getAllAdminInfo",
    dataType: "json",
    xhrFields: {
        withCredentials: true
    },
    async: true,
    timeout: 5000,
    success: function (data) {
        console.log(data)
        if (data.obj != null) {
            var option = ""
            for (var i in data.obj) {
                option += "<option value="+data.obj[i].id+">"+data.obj[i].adminName+"</option>"
            }
            $("#region-a").html(option)
        }

    }
})

$("#confirm_add").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + "region/addRegion",
        dataType: "json",
        data: {
            regionName: $("#customerName-a").val(),
            adminId: $("#region-a option:selected").val()
        },
        xhrFields: {
            withCredentials: true
        },
        async: true,
        timeout: 5000,
        success: function (data) {
            console.log(data)
            if (data.msg == "成功") {
                $("#refresh").click()
                alert("增加成功")
            }
        }
    })
})