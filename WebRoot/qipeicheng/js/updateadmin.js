var power = $(".on_xk").find("td").eq(2).text()
var adminName = $(".on_xk").find("td").eq(1).text()
$("#power option").each(function () {
    if ($(this).text() == power) {
        $(this).attr("selected", true)
    }
})

$("#adminName").val(adminName)

$("#update_btn").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + "admin/upAdminInfo",
        dataType: "json",
        xhrFields: {
            withCredentials: true
        },
        data: {
            id: $(".on_xk").attr("id_xk"),
            adminName: $("#adminName").val(),
            adminPwd:$("#adminPwd").val(),
            power:$("#power option:selected").text()
        },
        async: true,
        timeout: 5000,
        success: function (data) {
            console.log(data)
            if (data.msg == "成功") {
                alert("更新成功！")
                $("#refresh").click()
            } else {
                alert("更新失败！")
            }

        }
    })
    
})