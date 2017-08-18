function followQuert() {
	// 获取运单跟踪信息
	$.ajax({
		type : "post",
		url : getUrl + "waybill/logisticsQueryClient",
		xhrFields : {
			withCredentials : true
		},
		async : true,
		dataType : "json",
		timeout : 10000,
		data : {
			runnum : $("#runnum").val()
		},
		success : function(data) {
			if (null != data.t.waybill && "" != data.t.waybill) {
				var waybill = data.t.waybill

				$("#shipperAddress").val(waybill[0].consignment);
				$("#shipper").val(waybill[0].shipper);
				$("#shipperPay").val(waybill[0].shipperPay);
				$("#shipperPhone").val(waybill[0].shipperContacts);

				$("#receivingAddress").val(waybill[0].destination);
				$("#receiving").val(waybill[0].receiver);
				$("#receivingPhone").val(waybill[0].receiverContacts);
				$("#agencyFund").val(waybill[0].collectionPayment);
				$("#receivingPay").val(waybill[0].receiverPay);
				$("#remarks").val(waybill[0].remarks);
				var Operator = waybill[0].adminName;
				var logistics = data.t.logistics

				var content = "";
				for ( var index in logistics) {
					content += "<tr>"
					content += "<td>" + logistics[index].runnum + "</td>"
					content += "<td>" + logistics[index].date + "</td>"
					content += "<td>" + logistics[index].information + "</td>"
					content += "<td>" + Operator + "</td>"
					content += "</tr>"
				}
				$("#followTable").html(content);
			}
			else{
				alert("运单号错误或该运单号不存在！");
			}
		}
	});
};
