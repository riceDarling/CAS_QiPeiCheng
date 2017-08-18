 $("#runnum").focus(); 
function time() {
	var time = new Date();
	var y = time.getFullYear();
	var m = time.getMonth() + 1;
	if(m < 10)
		m = '0' + m
	var d = time.getDate();
	if(d < 10)
		d = '0' + d
	var h = time.getHours();
	if(h < 10)
		h = '0' + h
	var mi = time.getMinutes();
	if(mi < 10)
		mi = '0' + mi
	var s = time.getSeconds();
	if(s < 10)
		s = '0' + s
	return y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
}

document.getElementById("time").value = time();
var id = "";
var modernCollection = "";
var shippernum=$("#shipper").val();
/*$(document).keyup(function(e) {
	var currKey = 0,
		e = e || event;
	currKey = e.keyCode || e.which || e.charCode;
	var keyName = String.fromCharCode(currKey);
	if(currKey == 48 && currKey == 54) {
		if(!$("#runnum").val()) {
			return
		}
		var samerunnum = true;
		$("td[runnum]").each(function() {
			if($("#runnum").val() == $(this).text()) {
				samerunnum = false;
				var audio = new Audio("img/test.mp3");
				audio.play();
			}
		})
		if((samerunnum)&&($("#runnum").val().length==10)) {
			$.ajax({
				type: "post",
				url: getUrl + "finance/getForColInfosByRunnum",
				async: true,
				dataType: "json",
				timeout: 10000,
				data: {
					'runnum': $("#runnum").val()
				},
				success: function(data) {
					if(null != data.obj && "" != data.obj) {
						if(shippernum!=null&&shippernum!=""){
							if(data.obj[0].shipper==shippernum){
								$("#shipper").val(data.obj[0].shipper)
								$("#receiverAddress").val(data.obj[0].receiverAddress)
								$("#receiverContacts").val(data.obj[0].receiverContacts)
								$("#receiverPhone").val(data.obj[0].receiverPhone)
								$("#receiver").val(data.obj[0].receiver)
								$("#shipperAddress").val(data.obj[0].shipperAddress)
								$("#shipperContacts").val(data.obj[0].shipperContacts)
								$("#shipperPhone").val(data.obj[0].shipperPhone)
								$("#remarks").val(data.obj[0].remarks)
								var content = "<tr dataline thisid=\""+data.obj[0].id+"\">";
								content += "<td cm_listnum>" + ($("[cm_listnum]").length + 1) + "</td>"
								content += "<td runnum>" + data.obj[0].runnum + "</td>"
								content += "<td>" + data.obj[0].consignment + "</td>"
								content += "<td>" + data.obj[0].receiver + "</td>"
								content += "<td>" + data.obj[0].date + "</td>"
								content += "<td sumofcp>" + data.obj[0].collectionPayment + "</td>"
								content += "<td>" + data.obj[0].counterFee + "</td>"
								content += "<td>" + data.obj[0].receiverTotal + "</td>"
								content += "</tr>"
								$("tbody").append(content);
								var total = [];
								$("td[sumofcp]").each(function() {
									total.push($(this).text() * 1);
								})
								total = sumAll(total);
								$("#total").val(total)
								//大于一万固定三十，小于一万千分之三
								if(total >= 10000) {
									document.getElementById("poindage").value = "30";
								} else {
									document.getElementById("poindage").value = (parseInt(total) * 0.003).toFixed(2)
								}
								document.getElementById("residu").value = (total - $("#poindage").val()).toFixed(2);
							}
							else{
								var audio = new Audio("img/test.mp3");
								audio.play();
							}
							
						}else{
						$("#shipper").val(data.obj[0].shipper)
						$("#receiverAddress").val(data.obj[0].receiverAddress)
						$("#receiverContacts").val(data.obj[0].receiverContacts)
						$("#receiverPhone").val(data.obj[0].receiverPhone)
						$("#receiver").val(data.obj[0].receiver)
						$("#shipperAddress").val(data.obj[0].shipperAddress)
						$("#shipperContacts").val(data.obj[0].shipperContacts)
						$("#shipperPhone").val(data.obj[0].shipperPhone)
						$("#remarks").val(data.obj[0].remarks)
						var content = "<tr dataline thisid=\""+data.obj[0].id+"\">";
						content += "<td cm_listnum>" + ($("[cm_listnum]").length + 1) + "</td>"
						content += "<td runnum>" + data.obj[0].runnum + "</td>"
						content += "<td>" + data.obj[0].consignment + "</td>"
						content += "<td>" + data.obj[0].receiver + "</td>"
						content += "<td>" + data.obj[0].date + "</td>"
						content += "<td sumofcp>" + data.obj[0].collectionPayment + "</td>"
						content += "<td>" + data.obj[0].counterFee + "</td>"
						content += "<td>" + data.obj[0].receiverTotal + "</td>"
						content += "</tr>"
						$("tbody").append(content);
						var total = [];
						$("td[sumofcp]").each(function() {
							total.push($(this).text() * 1);
						})
						total = sumAll(total);
						$("#total").val(total)
						//大于一万固定三十，小于一万千分之三
						if(total >= 10000) {
							document.getElementById("poindage").value = "30";
						} else {
							document.getElementById("poindage").value = (parseInt(total) * 0.003).toFixed(2)
						}
						document.getElementById("residu").value = (total - $("#poindage").val()).toFixed(2);
						shippernum=data.obj[0].shipper;
					}}
					$("#runnum").val("");
				}

			})
		}
	}
});
*/
$("#runnum").change(function() {
	$("#alerta,#alertb,#alertc").hide();
	var samerunnum = true;
	$("td[runnum]").each(function() {
		if($("#runnum").val() == $(this).text()) {
			samerunnum = false;
			/*var audio = new Audio("img/test.mp3");
			audio.play();*/
			soundplay();
			$("#alertc").show();
		}
	})
	if(samerunnum) {
		$.ajax({
			type: "post",
			url: getUrl + "finance/getForColInfosByRunnum",
			async: false,
			dataType: "json",
			timeout: 10000,
			data: {
				'runnum': $("#runnum").val()
			},
			success: function(data) {
			
			if(null != data.obj && "" != data.obj&&[] != data.obj) {
						if(shippernum!=null&&shippernum!=""){
							if(data.obj[0].shipper==shippernum){
								$("#shipper").val(data.obj[0].shipper)
								$("#receiverAddress").val(data.obj[0].receiverAddress)
								$("#receiverContacts").val(data.obj[0].receiverContacts)
								$("#receiverPhone").val(data.obj[0].receiverPhone)
								$("#receiver").val(data.obj[0].receiver)
								$("#shipperAddress").val(data.obj[0].shipperAddress)
								$("#shipperContacts").val(data.obj[0].shipperContacts)
								$("#shipperPhone").val(data.obj[0].shipperPhone)
								$("#remarks").val(data.obj[0].remarks)
								var content = "<tr dataline thisid=\""+data.obj[0].id+"\">";
								content += "<td cm_listnum>" + ($("[cm_listnum]").length + 1)+"<img src='img/delicon.png' style='float:right;' delthisline>" + "</td>"
								content += "<td runnum>" + data.obj[0].runnum + "</td>"
								content += "<td>" + data.obj[0].consignment + "</td>"
								content += "<td>" + data.obj[0].receiver + "</td>"
								content += "<td>" + data.obj[0].date + "</td>"
								content += "<td sumofcp>" + data.obj[0].collectionPayment + "</td>"
								content += "<td>" + data.obj[0].counterFee + "</td>"
								content += "<td>" + data.obj[0].receiverTotal + "</td>"
								content += "</tr>"
								$("tbody").append(content);
								var total = [];
								$("td[sumofcp]").each(function() {
									total.push($(this).text() * 1);
								})
								total = sumAll(total);
								$("#total").val(total)
								//大于一万固定三十，小于一万千分之三
								if(total >= 10000) {
									document.getElementById("poindage").value = "30";
								} else {
									document.getElementById("poindage").value = (parseInt(total) * 0.003).toFixed(2)
								}
								document.getElementById("residu").value = (total - $("#poindage").val()).toFixed(2);
							}
							else{
								/*var audio = new Audio("img/test.mp3");
								audio.play();*/
								soundplay();
								$("#alertb").show();
							}
							
						}else{
						$("#shipper").val(data.obj[0].shipper)
						$("#receiverAddress").val(data.obj[0].receiverAddress)
						$("#receiverContacts").val(data.obj[0].receiverContacts)
						$("#receiverPhone").val(data.obj[0].receiverPhone)
						$("#receiver").val(data.obj[0].receiver)
						$("#shipperAddress").val(data.obj[0].shipperAddress)
						$("#shipperContacts").val(data.obj[0].shipperContacts)
						$("#shipperPhone").val(data.obj[0].shipperPhone)
						$("#remarks").val(data.obj[0].remarks)
						var content = "<tr dataline thisid=\""+data.obj[0].id+"\">";
						content += "<td cm_listnum>" + ($("[cm_listnum]").length + 1) +"<img src='img/delicon.png' style='float:right;' delthisline>" + "</td>"
						content += "<td runnum>" + data.obj[0].runnum + "</td>"
						content += "<td>" + data.obj[0].consignment + "</td>"
						content += "<td>" + data.obj[0].receiver + "</td>"
						content += "<td>" + data.obj[0].date + "</td>"
						content += "<td sumofcp>" + data.obj[0].collectionPayment + "</td>"
						content += "<td>" + data.obj[0].counterFee + "</td>"
						content += "<td>" + data.obj[0].receiverTotal + "</td>"
						content += "</tr>"
						$("tbody").append(content);
						var total = [];
						$("td[sumofcp]").each(function() {
							total.push($(this).text() * 1);
						})
						total = sumAll(total);
						$("#total").val(total)
						//大于一万固定三十，小于一万千分之三
						if(total >= 10000) {
							document.getElementById("poindage").value = "30";
						} else {
							document.getElementById("poindage").value = (parseInt(total) * 0.003).toFixed(2)
						}
						document.getElementById("residu").value = (total - $("#poindage").val()).toFixed(2);
						shippernum=data.obj[0].shipper;
					}
				}else{
					/*var audio = new Audio("img/test.mp3");
					audio.play();*/
					soundplay();
					$("#alerta").show();
				}
			}

		})
	}
	$("#runnum").val("");
})
$(document).on("click", "[delthisline]", function() {
	if(confirm("删除该条？")) {
		$(this).parents("[dataline]").nextAll("[dataline]").each(function() {
			$(this).children("[cm_listnum]").children("span").text($(this).children("[cm_listnum]").children("span").text() * 1 - 1);
		});
		$(this).parents("[dataline]").remove();
	}
})
$("#wait_pay_btn").click(function() {
	var subdatagrp =[];
	$("[dataline]").each(function(){
		subdatagrp.push($(this).attr("thisid")*1);
	})
	$.ajax({
		type: "post",
		url: getUrl + "waybill/payment",
		async: true,
		dataType: "json",
		timeout: 10000,
		data: {
			'id': subdatagrp
		},
		success: function(data) {
			/*if(data.msg == "成功") {
				alert("付代收款成功!")
			} else if(data.msg == "失败") {
				alert("付代收款失败!")
			}*/

			$("tbody").html("")
			ids = ""
			$("#receiver").val("")
			$("#receiverAddress").val("")
			$("#shipper").val("")
			$("#shipperAddress").val("")

			$("#shipperPhone").val("")
			$("#receiverPhone").val("")
			$("#shipperContacts").val("")
			$("#receiverContacts").val("")
			$("#remarks").val("")
			$("#runnum").val("")
			$("#total").val("")
			$("#poindage").val("")
			$("#residu").val("")

		}
	})
})