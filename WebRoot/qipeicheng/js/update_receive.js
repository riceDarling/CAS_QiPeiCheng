
$.ajax({
    type: "post",
    url: getUrl + "waybill/selectById",
    xhrFields: {
		withCredentials: true
	},
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        id: $(".on_xk input[type='hidden']").val(),
        inf:"receiver"
    },
    success: function (data) {
        $("#runnum").val(data.t.runnum)
        $("#receiver").val(data.t.receiver)
        $("#receiverAddress").val(data.t.receiverAddress)
        $("#receiverPhone").val(data.t.receiverPhone)
        $("#receiverContacts").val(data.t.receiverContacts)
        
    }
})


$("#update_button").click(function () {
    $.ajax({
        type: "post",
        url: getUrl + "waybill/updateParticipant",
        xhrFields: {
			withCredentials: true
		},
        async: true,
        dataType: "json",
        timeout: 10000,
        data: {
            id: $(".on_xk input[type='hidden']").val(),
            receiver: $("#receiver").val(),
            address: $("#receiverAddress").val(),
            phone: $("#receiverPhone").val(),
            contacts: $("#receiverContacts").val()
        },
        success: function (data) {
        	 $("#update-close").click()
            $("#cancel").click()
             $("#query").click()
        }
    })

})
