$("#query").bind("click", function () {
	var startDate = $("#startDate").val()
	var endDate = $("#endDate").val()
	var status = $("#status option:selected").val()
	var consignmentPlaceId = $("#consignmentPlaceId option:selected").text()
	var network = $("#network option:selected").text()
	var consignmentName = $("#consignmentName").val()
	var destination = $("#destinationId option:selected").text()
	var allconsignment = $("#allconsignment").val()
	var receivingName = $("#receivingName").val()

	$.ajax({
		type: "post",
		url: getUrl + "waybill/selectWaybill",
		  xhrFields: {
				withCredentials: true
			},
		async: true,
		dataType: "json",
		timeout: 10000,
		data: {
			"startDate": startDate,
			"endDate": endDate,
			"status": status,
			"consignment": consignmentPlaceId,
			"network": network,
			"destination": destination
		},
		success: function (data) {
			$("tbody").html("")
			if (null != data.obj && "" != data.obj) {
			var obj = data.obj
			var numbersum=0;var totalsum=0;var total=0;var receivetotal=0;
			for (var index in obj) {
				var content = "<tr value=\""+obj[index].id+"\">"
				content += "<input  type='hidden' name='"+obj[index].status+"' value='"+obj[index].id+"' id=\""+obj[index].id+"\"/>"
				content += "<td>" + obj[index].consignment  + "</td>"
				content += "<td>" + obj[index].destination  + "</td>"
				content += "<td>" + obj[index].network  + "</td>"
				content += "<td runnum>" + obj[index].runnum  + "</td>"
				content += "<td>" + obj[index].date   + "</td>"
				content += "<td>" + obj[index].shipper + "</td>"
				content += "<td>" + obj[index].receiver  + "</td>"
				content += "<td>" + obj[index].number  + "</td>"
				content += "<td>" + obj[index].total + "</td>"
				content += "<td>" + obj[index].weight + "</td>"
				content += "<td>" + obj[index].shipperPay + "</td>"
				content += "<td>" + obj[index].freight + "</td>"
				content += "<td>" + obj[index].fee + "</td>"
				content += "<td>" + obj[index].serviceCharge + "</td>"
				content += "<td>" + obj[index].premium + "</td>"
				content += "<td>" + obj[index].receiverPay + "</td>"
				content += "<td>" + obj[index].collectionPayment  + "</td>"
				content += "<td>" + obj[index].returnMoney   + "</td>"
				switch (obj[index].status) {
					case '1':
						content += "<td></td>"
						content += "<td></td>"
						content += "<td></td>"
						content += "<td></td>"
						break;
					case '2':
						content += "<td>√</td>"
						content += "<td></td>"
						content += "<td></td>"
						content += "<td></td>"
						break;
					case '3':
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td></td>"
						content += "<td></td>"
						break;
					case '4':
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td></td>"
						break;
					case '6':
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td>√</td>"
						break;
					default:
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td>√</td>"
						content += "<td>√</td>"
						break;
				}

				content += "<td>" + obj[index].receiverArrears  + "</td>"
				content += "<td>" + obj[index].receiverTotal    + "</td>"
				content += "<td>" + obj[index].paid   + "</td>"
				content += "</tr>"
				$("tbody").append(content);
				numbersum += obj[index].number
				totalsum += obj[index].total
				total += obj[index].collectionPayment
				receivetotal+=obj[index].receiverTotal	
				textfilter();
				
			}
			$("#numbersum").val(numbersum);
			$("#totalsum").val(totalsum);
			$("#total").val(total);
			$("#receivetotal").val(receivetotal);
			}
		}
	});
})

$("#delete").click(function () {
	if($("#moveTable>tbody>tr.on_xk:not(':hidden')").length){
		if (confirm("确认要删除这条记录？")) {
			console.log($(".on_xk input[type='hidden']").val())
			$.ajax({
				type: "post",
				url: getUrl + "waybill/deleteWaybill",
				  xhrFields: {
						withCredentials: true
					},
				async: true,
				dataType: "json",
				timeout: 10000,
				data: {
					id:$(".on_xk input[type='hidden']").val()
				},
				success: function (data) {
					$("#query").click()
				}
			})

		}
	}
})
$("#fallback").click(function () {
	if($("#moveTable>tbody>tr.on_xk:not(':hidden')").length){
		if($(".on_xk input[type='hidden']").attr('name')==1){
			alert("该运单已经是最初状态！");
		}else{
		if (confirm("确认要回退到上一步？")) {
			$.ajax({
				type: "post",
				url: getUrl + "waybill/fallbackWaybill",
				  xhrFields: {
						withCredentials: true
					},
				async: true,
				dataType: "json",
				timeout: 10000,
				data: {
					id:$(".on_xk input[type='hidden']").val()
				},
				success: function (data) {
					$("#query").click();
					alert(data.msg);
				}
			})
		}
		}
	}
})

$("#consignmentName,#receivingName").focus(function () {
	var inputtimeout;
	$(this).bind("input propertychange", function () {
		clearTimeout(inputtimeout);
		if ($(this).val() != "" && $(this).val() != null && $(this).val() != undefined) {
			var thisxx = $(this);
			inputtimeout = setTimeout(function () {
				var thisdata = {};
				if ($("#allconsignment").is(':not(":checked")')){
				
			}
				thisdata.customerName = $(thisxx).val();
				$.ajax({
					type: "post",
					url: getUrl + "customer/getCustomerByName",
					  xhrFields: {
							withCredentials: true
						},
					async: true,
					data: thisdata,
					dataType: "json",
					timeout: 10000,
					success: function (data) {
						console.log(data);
						var html = "";
						for (var i in data.obj) {
							if (i < 10) {
								html += "<option value=\"" + i + "\">";
								html += data.obj[i].customerName;
								html += "</option>";
							}
						};

						$(".datalist").off("change").html(html).css({
							"left": ($(thisxx).offset().left - $(window).scrollLeft()) + "px",
							"top": ($(thisxx).offset().top - $(window).scrollTop() + $(thisxx).outerHeight()) + "px",
							"visibility": "visible"
						}).on("change", function () {
								$(thisxx).val(data.obj[$(this).val()].customerName);
						})
					}
				});
			}, 500)
		} else {
			$(".datalist").css("visibility", "hidden").empty();
		}
	});
});
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
			content += "<option></option>"
			for(var index in data.obj) {
				content += "<option>" + data.obj[index].regionName + "</option>"
			}
			$("[getRegion]").html(content);
		}
	})
})
$(document).on("input","#filter",function(){
	textfilter();
})
function textfilter(){
	var filtertext=$("#filter").val();
	$("#moveTable>tbody>tr").each(function(){
		if($(this).children("[runnum]").is(":contains(\""+filtertext+"\")")){
			$(this).show();
		}else{
			$(this).hide();
		}
	})
}
