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
        url: getUrl + "customer/addCustomer",
        data: {
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


$.ajax({
    type: "post",
    url: getUrl + "region/getAllRegion",
    async: true,
    dataType: "json",
    timeout: 10000,
    success: function (data) {
        console.log(data)
        var option = ""; 
       for (var i in data.obj) {
            option += "<option value='" + data.obj[i].id+"'>" + data.obj[i].regionName+"</option>"
       }
        $("#region-a").html(option)
    }
});

