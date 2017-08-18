$.ajax({
    type: "post",
    url: getUrl + "finance/payforColByShipperInfos",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
        consignment: $("#consignment option:selected").text(),
        destination: $("#destination option:selected").text()
    },
    success: function (data) {
        if (null != data.obj && "" != data.obj) {
        	var numsum3 = 0;var numsum4 = 0;
        	var totalsum3 = 0;
			var paymentsum3 = 0;
			var totalsum4 = 0;
			var paymentsum4 = 0;
        for (var index in data.obj) {
            var content = "<tr id_byshipper2>"
            content += "<td><input type='checkbox' class='choose'/>" + data.obj[index].destination + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].collectionPayment + "</td>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].paid + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "</tr>"
            numsum3 += data.obj[index].total;
            totalsum3 += data.obj[index].collectionPayment;
			paymentsum3 += data.obj[index].paid;
            $("#secondPageTbody").append(content)
            $("[id_byshipper2] input.choose").click(function(){
            	//$(this).find("input.choose").attr("checked", true);
					$("#numsum4").val($("[id_byshipper2] .choose:checked").length); 
					var valB=0;
					
					$("[id_byshipper2] .choose:checked").parents("[id_byshipper2]").each(function(){
						valB+=$(this).children("td").eq(4).text()*1;
					})
					$("#totalsum4").val(valB);
					if (valB >= 10000) {
						document.getElementById("counterFeesum4").value = "30";
					} else {
						document.getElementById("counterFeesum4").value = (parseInt(valB) * 0.003).toFixed(2)
					}
					$("#paymentsum4").val(valB-$("#counterFeesum4").val());
				})
        }
        $("#numsum3").val(numsum3);
    	$("#totalsum3").val(totalsum3);
		//大于一万固定三十，小于一万千分之三
		if (totalsum3 >= 10000) {
			document.getElementById("counterFeesum3").value = "30";
		} else {
			document.getElementById("counterFeesum3").value = (parseInt(totalsum3) * 0.003).toFixed(2)
		}
		$("#paymentsum3").val(totalsum3-$("#counterFeesum3").val());
        }
    }
})

