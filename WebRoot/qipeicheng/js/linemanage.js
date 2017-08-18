$("#delete").bind("click", function () {
    if (confirm("确认删除这条记录?")) {
        $.ajax({
            type: "post",
            url: getUrl + "region/delRegionById",
            data: {
                "id": $(".on_xk").attr("id_xk")
            },
            xhrFields: {
                withCredentials: true
            },
            async: true,
            dataType: "json",
            timeout: 10000,
            success: function (data) {
                $("#refresh").click()

            }
        });
    }

})

$("#refresh").bind("click", function () {
    $.ajax({
        type: "post",
        url: getUrl + "region/getAllRegion",
        xhrFields: {
            withCredentials: true
        },
        async: true,
        dataType: "json",
        timeout: 10000,
        success: function (data) {
            console.log(data)
            $("tbody").html("")
if (null != data.obj && "" != data.obj) {
            for (var i = 0; i < data.obj.length; i++) {

                var content = "<tr style='text-align:center' id_xk='" + data.obj[i].id + "'>"
                content += "<td style='width:12%'>" + (i + 1) + "</td>"
                content += "<td> " + data.obj[i].regionName + " </td>"
                content += "<td>" + data.obj[i].adminName + "</td>"
                content += "</tr>"
                $("tbody").append(content)
            }
}

        }
    });
})

$("#refresh").click()
