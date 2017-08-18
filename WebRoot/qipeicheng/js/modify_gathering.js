var id = ""
var collectionPayment = ""


$("thead tr").find("td").each(function (index, el) {
    if ($(this).text() == "代收款") {
        collectionPayment = $(".on_xk").find("td").eq(index).text()

        id = $(".on_xk input[type='hidden']").val()
        $("#collectionPayment").val(collectionPayment)
        
        
    }
})




$("#confirm-update").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + "waybill/updateCollectionPayment",
        xhrFields: {
			withCredentials: true
		},
        async: true,
        dataType: "json",
        timeout: 10000,
        data: {
            id: id,
            collectionPayment: $("#collectionPayment").val()
        },
        success: function (data) {
            
            $("thead tr").find("td").each(function (index, el) {
                if ($(this).text() == "原代收款") {
                    console.log($("#collectionPayment").val())
                    $(".on_xk").find("td").eq(index).text($("#collectionPayment").val())
                }
            })
            $("#update-close").click();
            $("#cancel").click();
            $("#query").click();
        }
    })
})

