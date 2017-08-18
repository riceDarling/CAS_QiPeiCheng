
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
        inf: "shipper"
    },
    success: function (data) {
        $("#runnum").val(data.t.runnum)
        $("#shipper").val(data.t.shipper)
        $("#shipperAddress").val(data.t.shipperAddress)
        $("#shipperContacts").val(data.t.shipperPhone)
        $("#shipperPhone").val(data.t.shipperContacts)
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
            shipper: $("#shipper").val(),
            address: $("#shipperAddress").val(),
            phone: $("#shipperPhone").val(),
            contacts: $("#shipperContacts").val()
        },
        success: function (data) {
        	 $("#update-close").click()
            $("#cancel").click()
            $("#query").click()
        }
    })

})