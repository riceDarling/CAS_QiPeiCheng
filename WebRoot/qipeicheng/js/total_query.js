$.ajax({
	type: "post",
	url: getUrl + "region/getRegionByadminId",
	xhrFields: {
		withCredentials: true
	},
	async: true,
	dataType: "json",
	timeout: 10000,
	success: function(data) {
		console.log(data)
		var content = "";
		content += "<option></option>"
		for(var index in data.obj) {
			content += "<option>" + data.obj[index].regionName + "</option>"
		}
		$("#region").html(content)
	}
})
$(function(){
	$.ajax({
		type: "post",
		url: getUrl + "region/getAllRegion",
		  xhrFields: {
				withCredentials: true
			},
		async: true,
		dataType: "json",
		timeout: 10000,
		success: function(data) {
			console.log(data)
			var content = "";
			content += "<option ></option>"
			for(var index in data.obj) {
				content += "<option>" + data.obj[index].regionName + "</option>"
			}
			$("[getRegion]").html(content);
		}
	})
}) 
$("#query").click(function() {
	$.ajax({
		type : "post",
		url : getUrl + "finance/synthesizeReportPickup",
		async : true,
		dataType : "json",
		timeout : 10000,
		data : {
			startDate : $("#startDate").val(),
			endDate : $("#endDate").val(),
			consignment:$("#consignmentPlaceId").val(),
			destination:$("#destinationId").val()
		},
		success : function(data) {
			console.log(data)
			if (null != data.obj && "" != data.obj) {
				for ( var index in data.obj) {
					var content = ""
					content += "<td>" + data.obj[index].number + "</td>"
					content += "<td>" + data.obj[index].total + "</td>"
					content += "<td>" + data.obj[index].freight + "</td>"
					content += "<td>" + data.obj[index].fee + "</td>"
					content += "<td>" + data.obj[index].serviceCharge + "</td>"
					content += "<td>" + data.obj[index].premium + "</td>"
					content += "<td>" + data.obj[index].shipperPay + "</td>"
					content += "<td>" + data.obj[index].deliveryCharges + "</td>"
					content += "<td>" + data.obj[index].receiverTotal + "</td>"
					content += "<td>" + data.obj[index].paid + "</td>"
					content += "<td>" + data.obj[index].receiverArrears + "</td>"
					content += "<td>" + data.obj[index].receiverPay + "</td>"
					content += "<td>" + data.obj[index].collectionPayment + "</td>"
					content += "<td>" + data.obj[index].modernCollection + "</td>"
					content += "<td>" + data.obj[index].returnMoney + "</td>"
					content += '<td class="tq_no_top"><input type="button" value="明细" clicktopopup="synthesizeReportPickup_take_query_detail"></td>';
					$("tbody").find("tr").eq(0).find("th").siblings().remove();
					$("tbody").find("tr").eq(0).find("th").after(content);
				}
			}else{
				$("tbody").find("tr").eq(0).find("th").siblings("td:not('.tq_no_top')").empty();
			}
		}
	})

	$.ajax({
		type : "post",
		url : getUrl + "finance/synReportLoading",
		async : true,
		dataType : "json",
		timeout : 10000,
		data : {
			startDate : $("#startDate").val(),
			endDate : $("#endDate").val(),
			consignment:$("#consignmentPlaceId").val(),
			destination:$("#destinationId").val()
		},
		success : function(data) {
			if (null != data.obj && "" != data.obj) {
				for ( var index in data.obj) {
					var content = ""
					content += "<td>" + data.obj[index].number + "</td>"
					content += "<td>" + data.obj[index].total + "</td>"
					content += "<td>" + data.obj[index].freight + "</td>"
					content += "<td>" + data.obj[index].fee + "</td>"
					content += "<td>" + data.obj[index].serviceCharge + "</td>"
					content += "<td>" + data.obj[index].premium + "</td>"
					content += "<td>" + data.obj[index].shipperPay + "</td>"
					content += "<td>" + data.obj[index].deliveryCharges + "</td>"
					content += "<td>" + data.obj[index].receiverTotal + "</td>"
					content += "<td>" + data.obj[index].paid + "</td>"
					content += "<td>" + data.obj[index].receiverArrears + "</td>"
					content += "<td>" + data.obj[index].receiverPay + "</td>"
					content += "<td>" + data.obj[index].collectionPayment + "</td>"
					content += "<td>" + data.obj[index].counterFee + "</td>"
					content += "<td>" + data.obj[index].returnMoney + "</td>"
					content += '<td class="tq_no_top"><input type="button" value="明细" clicktopopup="synReportLoading_take_query_detail"></td>';
					$("tbody").find("tr").eq(1).find("th").siblings().remove();
					$("tbody").find("tr").eq(1).find("th").after(content);
				}
			}else{
				$("tbody").find("tr").eq(1).find("th").siblings("td:not('.tq_no_top')").empty();
			}
		}
	})

	$.ajax({
		type : "post",
		url : getUrl + "finance/synReportUpload",
		async : true,
		dataType : "json",
		timeout : 10000,
		data : {
			startDate : $("#startDate").val(),
			endDate : $("#endDate").val(),
			consignment:$("#consignmentPlaceId").val(),
			destination:$("#destinationId").val()
		},
		success : function(data) {
			if (null != data.obj && "" != data.obj) {
				for ( var index in data.obj) {
					var content = ""
					content += "<td>" + data.obj[index].number + "</td>"
					content += "<td>" + data.obj[index].total + "</td>"
					content += "<td>" + data.obj[index].freight + "</td>"
					content += "<td>" + data.obj[index].fee + "</td>"
					content += "<td>" + data.obj[index].serviceCharge + "</td>"
					content += "<td>" + data.obj[index].premium + "</td>"
					content += "<td>" + data.obj[index].shipperPay + "</td>"
					content += "<td>" + data.obj[index].deliveryCharges + "</td>"
					content += "<td>" + data.obj[index].receiverTotal + "</td>"
					content += "<td>" + data.obj[index].paid + "</td>"
					content += "<td>" + data.obj[index].receiverArrears + "</td>"
					content += "<td>" + data.obj[index].receiverPay + "</td>"
					content += "<td>" + data.obj[index].collectionPayment + "</td>"
					content += "<td>" + data.obj[index].counterFee + "</td>"
					content += "<td>" + data.obj[index].returnMoney + "</td>"
					content += '<td class="tq_no_top"><input type="button" value="明细" clicktopopup="synReportUpload_take_query_detail"></td>';
					$("tbody").find("tr").eq(2).find("th").siblings().remove();
					$("tbody").find("tr").eq(2).find("th").after(content);

				}
			}else{
				$("tbody").find("tr").eq(2).find("th").siblings("td:not('.tq_no_top')").empty();
			}
		}
	})

	$.ajax({
		type : "post",
		url : getUrl + "finance/synReportTake",
		async : true,
		dataType : "json",
		timeout : 10000,
		data : {
			startDate : $("#startDate").val(),
			endDate : $("#endDate").val(),
			consignment:$("#consignmentPlaceId").val(),
			destination:$("#destinationId").val()
		},
		success : function(data) {
			if (null != data.obj && "" != data.obj) {
				for ( var index in data.obj) {
					var content = ""
					content += "<td>" + data.obj[index].number + "</td>"
					content += "<td>" + data.obj[index].total + "</td>"
					content += "<td>" + data.obj[index].freight + "</td>"
					content += "<td>" + data.obj[index].fee + "</td>"
					content += "<td>" + data.obj[index].serviceCharge + "</td>"
					content += "<td>" + data.obj[index].premium + "</td>"
					content += "<td>" + data.obj[index].shipperPay + "</td>"
					content += "<td>" + data.obj[index].deliveryCharges + "</td>"
					content += "<td>" + data.obj[index].receiverTotal + "</td>"
					content += "<td>" + data.obj[index].paid + "</td>"
					content += "<td>" + data.obj[index].receiverArrears + "</td>"
					content += "<td>" + data.obj[index].receiverPay + "</td>"
					content += "<td>" + data.obj[index].collectionPayment + "</td>"
					content += "<td>" + data.obj[index].counterFee + "</td>"
					content += "<td>" + data.obj[index].returnMoney + "</td>"
					content += '<td class="tq_no_top"><input type="button" value="明细" clicktopopup="synReportTake_take_query_detail"></td>';
					$("tbody").find("tr").eq(3).find("th").siblings().remove();
					$("tbody").find("tr").eq(3).find("th").after(content);
				}
			}else{
				$("tbody").find("tr").eq(3).find("th").siblings("td:not('.tq_no_top')").empty();
			}
		}
	})

	$.ajax({
		type : "post",
		url : getUrl + "finance/synReportPayforCol",
		async : true,
		dataType : "json",
		timeout : 10000,
		data : {
			startDate : $("#startDate").val(),
			endDate : $("#endDate").val(),
			consignment:$("#consignmentPlaceId").val(),
			destination:$("#destinationId").val()
		},
		success : function(data) {
			if (null != data.obj && "" != data.obj) {
				for ( var index in data.obj) {
					var content = ""
					content += "<td>" + data.obj[index].number + "</td>"
					content += "<td>" + data.obj[index].total + "</td>"
					content += "<td>" + data.obj[index].freight + "</td>"
					content += "<td>" + data.obj[index].fee + "</td>"
					content += "<td>" + data.obj[index].serviceCharge + "</td>"
					content += "<td>" + data.obj[index].premium + "</td>"
					content += "<td>" + data.obj[index].shipperPay + "</td>"
					content += "<td>" + data.obj[index].deliveryCharges + "</td>"
					content += "<td>" + data.obj[index].receiverTotal + "</td>"
					content += "<td>" + data.obj[index].paid + "</td>"
					content += "<td>" + data.obj[index].receiverArrears + "</td>"
					content += "<td>" + data.obj[index].receiverPay + "</td>"
					content += "<td>" + data.obj[index].collectionPayment + "</td>"
					content += "<td>" + data.obj[index].counterFee + "</td>"
					content += "<td>" + data.obj[index].returnMoney + "</td>"
					content += '<td class="tq_no_top"><input type="button" value="明细" clicktopopup="synReportPayforCol_take_query_detail"></td>';
					$("tbody").find("tr").eq(4).find("th").siblings().remove();
					$("tbody").find("tr").eq(4).find("th").after(content);
				}
			}else{
				$("tbody").find("tr").eq(4).find("th").siblings("td:not('.tq_no_top')").empty();
			}
		}
	})

})
