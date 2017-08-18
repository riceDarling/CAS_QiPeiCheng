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
        var option = "";
        for (var i in data.obj) {
            option += "<option value='" + data.obj[i].id + "'>" + data.obj[i].regionName + "</option>"
        }
        $("#region-a").html(option)
    }
});

var clientId = $(".on_xk").attr("id_xk")



$.ajax({
    type: "post",
    url: getUrl + "customer/getCustomerById",
    data: {
        "id": clientId
    },
    dataType: "json",
    timeout: 10000,
    xhrFields: {
		withCredentials: true
	},
    async: true,
    success: function (data) {

        $("#customerName-a").val(data.t.customerName)
        $("#address-a").val(data.t.customerAddress)
        $("#phone-a").val(data.t.customerPhone)
        $("#region-a").find("option").each(function (index) {
            if ($("#region-a").find("option").eq(index).text() == data.t.regionName) {
                $("#region-a").find("option").eq(index).attr("selected", true);
            }

        })
        $("#region-a").find("option").text()
         $("#zipCode-a").val(data.t.code)
        $("#contacts-a").val(data.t.customerContacts)
        $("#bankCard-a").val(data.t.bankCard)



        $(".add_button_confirm").bind("click", function () {

            var region = $("#region-a option:selected").val()
            var business = $("#business-a").val()
            var zipCode = $("#zipCode-a").val()
            var customerName = $("#customerName-a").val()
            var address = $("#address-a").val()
            var phone = $("#phone-a").val()
            var contacts = $("#contacts-a").val()
            var bankCard = $("#bankCard-a").val()

            $.ajax({
                type: "post",
                url: getUrl + "customer/upCustomer",
                data: {
                    "id": clientId,
                    "regionId": region,
                    "customerName": customerName,
                    "customerAddress": address,
                    "customerPhone": phone,
                    "code":zipCode,
                    "bankCard": bankCard,
                    "customerContacts": contacts
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


        })
    }
})