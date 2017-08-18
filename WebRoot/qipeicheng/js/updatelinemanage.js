
var regionName = $(".on_xk").find("td").eq(1).text()
var adminName = $(".on_xk").find("td").eq(2).text()

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
                if (adminName == data.obj[i].adminName) {
                    option += "<option value='" + data.obj[i].id + "' selected>" + data.obj[i].adminName + "</option>"
                } else {
                    option += "<option value='" + data.obj[i].id + "'>" + data.obj[i].adminName + "</option>"
                }
            }
            $("#region-a").html(option)
        }

    }
})

$("#customerName-a").val(regionName)

$("#update_btn").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + " region/upRegionInfo",
        dataType: "json",
        data: {
            id: $(".on_xk").attr("id_xk"),
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
            if (data.msg) {
                alert("更新成功！")
                $("#refresh").click()
            } else {
                alert("更新失败！")
            }

        }
    })
    
})

