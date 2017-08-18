$("#add_btn").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + "admin/addAdmin",
        dataType: "json",
        data: {
            adminName:$("#adminName").val(),
            adminPwd: $("#adminPwd").val(),
            power:$("#power option:selected").text(),
        },
        xhrFields: {
            withCredentials: true
        },
        async: true,
        timeout: 5000,
        success: function (data) {
            console.log(data)
            if (data.msg == "成功") {
                alert("添加成功！")
            } else {
                alert("添加失败！")
            }
            $("#refresh").click();
        }
    })
})