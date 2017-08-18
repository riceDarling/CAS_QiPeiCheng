$.ajax({
	type : "post",
	url : getUrl + "finance/payforColByShipper",
	async : true,
	dataType : "json",
	timeout : 10000,
	data : {
		startDate : $("#startDate").val(),
		endDate : $("#endDate").val(),
		consignment : $("#consignment option:selected").text(),
		destination : $("#destination option:selected").text()
	},
	success : function(data) {
		if (null != data.obj && "" != data.obj) {
			var numsum = 0;
			var totalsum = 0;
			var paymentsum = 0;
			var numsum2 = 0;
			var totalsum2 = 0;
			var paymentsum2 = 0;
			for ( var index in data.obj) {
				var content = "<tr id_byshipper1>"
				content += "<td><input type='checkbox' class='choose'/>"+ data.obj[index].shipper + "</td>"
				content += "<td>" + data.obj[index].total + "</td>"
				content += "<td>" + data.obj[index].collectionPayment + "</td>"
				content += "<td>" + data.obj[index].counterFee + "</td>"
				content += "<td>" + data.obj[index].paid + "</td>"

				if (null != data.obj[index].customerContacts && "" != data.obj[index].customerContacts) {
					content += "<td>" + data.obj[index].customerContacts + "</td>"
				} else {
					content += "<td>" + " " + "</td>"
				}
				if (null != data.obj[index].bankCard && "" != data.obj[index].bankCard) {
					content += "<td>" + data.obj[index].bankCard + "</td>"
				} else {
					content += "<td>" + " " + "</td>"
				}
				content += "</tr>"
				numsum += data.obj[index].total;
				totalsum += data.obj[index].collectionPayment;
				$("tbody").append(content);
				$("[id_byshipper1] input.choose").click(function(){
					//$(this).find("input.choose").attr("checked", true);
					//$("#numsum2").val($("[id_byshipper1] .choose:checked").length); 
					var valA=0;var valnum=0;
					$("[id_byshipper1] .choose:checked").parents("[id_byshipper1]").each(function(){
						valA+=$(this).children("td").eq(2).text()*1;
						valnum+=$(this).children("td").eq(1).text()*1;
					})
					$("#totalsum2").val(valA);$("#numsum2").val(valnum);
					if (valA >= 10000) {
						document.getElementById("counterFeesum2").value = "30";
					} else {
						document.getElementById("counterFeesum2").value = (parseInt(valA) * 0.003).toFixed(2)
					}
					$("#paymentsum2").val(valA-$("#counterFeesum2").val());
				})
			
			}
			$("#numsum").val(numsum);
			$("#totalsum").val(totalsum);
			//大于一万固定三十，小于一万千分之三
			if (totalsum >= 10000) {
				document.getElementById("counterFeesum").value = "30";
			} else {
				document.getElementById("counterFeesum").value = (parseInt(totalsum) * 0.003).toFixed(2)
			}
			$("#paymentsum").val(totalsum-$("#counterFeesum").val());
		}
	}
})