$(document).on("click", "*[clickToPopup]", function() {
	var thisparm = $(this).attr("parm");
	var thiswindow = $(this).attr("clickToPopup");
	if(thiswindow != undefined && thiswindow != null && thiswindow != "") {
		$.get($(this).attr("clickToPopup") + ".html").success(function(a) {
			var html = "";
			html += '<div class="popupwindow"';
			html += ' thiswindow="' + thiswindow + '"';
			if(thisparm != undefined && thisparm != null && thisparm != "") {
				html += ' parm="' + thisparm + '"';
			}
			html += '>';
			html += "<div class='popupbody'>";
			html += "<div>";
			html += a;
			html += "</div>";
			html += "</div>";
			html += "<div class='bgcover'></div>";
			html += "</div>";
			$("body").append(html);
		});
	}
});
$(document).on("click", "*[clickToClose]", function() {
	var close_f = $(this).attr("clickToClose");
	if(close_f != "" && close_f != null && close_f != undefined) {
		try {
			eval(close_f);
		} catch(e) {
			//TODO handle the exception
		};
	}
	$(this).parents(".popupwindow").remove();
});

//listline类选中状态增加颜色变化
$(document).on("click", "*[selectList] [listline],*[selectList]>tbody>tr", function() {
	$(this).siblings("*[selectList] [listline],*[selectList]>tbody>tr").removeClass("on_xk");
	$(this).addClass("on_xk");
});
$(document).on("click", "*[clickToDelete]", function() {

	if($(this).parents(".popupwindow").find("*[selectList] .on_xk[listline],*[selectList]>tbody>tr.on_xk").length) {
		var startTime = Date.now();
		if(confirm("确认删除选中条目？")) {
			var deleteLineID = $(this).parents(".popupwindow").find("*[selectList] .on_xk[listline],*[selectList]>tbody>tr.on_xk").attr("lineID");
		}
		var endTime = Date.now();
		if(endTime - startTime < 10) {
			popupDisableConfirm();
		}
	}
});

function disableConfirm() {
	var ifConfirm = true;

	function notConfirmAgain() {
		if(ifConfirm) {
			window.open("disableComfirm.html");
		}
		ifConfirm = false;
	};
	return notConfirmAgain;
}
var popupDisableConfirm = disableConfirm();

function clickToSubmit(thiswindow, subAPI) {
	var subData = {};
	var nes=true; 
	var nesname="";
	$(".popupwindow[thiswindow=\"" + thiswindow + "\"]").find("[subID]:not(':disabled')").each(function() {
		
		var subID = $(this).attr("subID");
		switch($(this).attr("subtype")) {
			case "text":
				var thisID = $(this).text();
				break;
			case "changeText":
				var thisID = $(this).children("option:selected").text();
				break;
			case "check":
				if($(this).is(":checked")) {
					var thisID = $(this).val();
				}
				break;
			default:
				var thisID = $(this).val();
				break;
		}
		if($(this).is("[nes]")&&(thisID == "" || thisID == null || thisID == undefined)){
			nes*=false;
			if(nesname==""||nesname==null||nesname==undefined){
				nesname=$(this).attr("nes");
			}
		}
		if(thisID != "" && thisID != null && thisID != undefined) {
			subData[subID] = thisID;
		}
	});
	var thisdata;
	if(nes){
		$.ajax({
			type: "post",
			url: getUrl + subAPI,
			  xhrFields: {
					withCredentials: true
				},
			async: false,
			dataType: "json",
			timeout: 10000,
			data: subData,
			success: function(data) {
				/*if(data.msg != "" && data.msg != null && data.msg != undefined) {
					alert(data.msg);
				}*/
				console.log(data);
				switch(subAPI) {
					case "waybill/selectWaybillByDate":
						var html = "";
						for(x in data) {
							html += "<tr>";
							//托运地
							html += "<td title=\"" + data[x]['shipperAddress'] + "\">" + data[x]['shipperAddress'] + "</td>";
							//目的地
							html += "<td title=\"" + data[x]['destination'] + "\">" + data[x]['destination'] + "</td>";
							//协作方
							html += "<td title=\"" + data[x]['network'] + "\">" + data[x]['network'] + "</td>";
							//运单号
							html += "<td title=\"" + data[x]['runnum'] + "\">" + data[x]['runnum'] + "</td>";
							//日期
							html += "<td title=\"" + data[x]['createTime'] + "\">" + data[x]['createTime'] + "</td>";
							//托运方
							html += "<td title=\"" + data[x]['shipper'] + "\">" + data[x]['shipper'] + "</td>";
							//收件方
							html += "<td title=\"" + data[x]['receiving'] + "\">" + data[x]['receiving'] + "</td>";
							//件数
							html += "<td title=\"" + data[x]['total'] + "\">" + data[x]['total'] + "</td>";
							//重量
							html += "<td title=\"" + data[x]['weight'] + "\">" + data[x]['weight'] + "</td>";
							//托方付费
							if(typeof(data[x]['shipperPay']) != "undefined") {
								html += "<td title=\"" + data[x]['shipperPay'] + "\">" + data[x]['shipperPay'] + "</td>";
							} else {
								html += "<td></td>";
							}
							//运费+工本+服务+保障
							html += "<td title=\"" + data[x]['fpsf'] + "\">" + data[x]['fpsf'] + "</td>";
							//接收方付费
							if(typeof(data[x]['receivingPay']) != "undefined") {
								html += "<td title=\"" + data[x]['receivingPay'] + "\">" + data[x]['receivingPay'] + "</td>";
							} else {
								html += "<td></td>";
							}
							//原代收款
							html += "<td></td>";
							//代收款
							html += "<td title=\"" + data[x]['agencyFund'] + "\">" + data[x]['agencyFund'] + "</td>";
							//退货款
							html += "<td></td>";
							//实际代收款
							html += "<td></td>";
							//装车
							html += "<td></td>";
							//卸车
							html += "<td></td>";
							//取货
							html += "<td></td>";
							//收方未付
							html += "<td></td>";
							//接收方付
							html += "<td></td>";
							//付代收款
							html += "<td></td>";

							html += "</tr>";
						}
						$(".dq_two tbody").html(html);
						break;
					case "waybill/insertWaybill":
						$("[thiswindow='consignment_bill'],[thiswindow='consignment_bill_client']").remove();
						
						break;
					default:
						break;
				}
				if(data.obj != null && data.obj != undefined && data.obj != "") {
					thisdata = data.obj;
				} else {
					thisdata = data.t;
				}
			}
		});
		return thisdata;
	}else{
		if(nesname!=""&&nesname!=null&&nesname!=undefined){
			alert(nesname+"不能为空!");
		}else{
			alert("必填项不能为空！");
		}
		
	}
	
};

$(document).on("click", "*[clickToSubmit]", function() {
	var subAPI = $(this).attr("clickToSubmit");
	subAPI = subAPI.split("?");
	var thiswindow = $(this).parents(".popupwindow").attr("thiswindow");
	for(one in subAPI) {
		if(one == 0) {
			clickToSubmit(thiswindow, subAPI[one]);
		} else {
			switch(subAPI[one]) {
				case "close":
					$(this).parents(".popupwindow").remove();
					break;
				case "clean":
					$(this).parents(".popupwindow").find("[subID]").val("");
				default:
					break;
			}
		}
	}
});
$(document).on("click", "*[clickToForbidden]", function() {
	if($(this).is(":checked")) {
		$("[subID=\"" + $(this).attr("clickToForbidden") + "\"]").prop("disabled", true);
		$("[subID=\"" + $(this).attr("clickToForbidden") + "\"]").val("")
	} else {
		$("[subID=\"" + $(this).attr("clickToForbidden") + "\"]").prop("disabled", false);
	}

});

$(document).on("click", "*[clickToAllow]", function() {
	if(!$(this).is(":checked")) {
		$("[subID=\"" + $(this).attr("clickToAllow") + "\"]").prop("disabled", true);
		$("[subID=\"" + $(this).attr("clickToAllow") + "\"]").val("")
	} else {
		$("[subID=\"" + $(this).attr("clickToAllow") + "\"]").prop("disabled", false);
	}

});

$(document).click(function() {
	$(".datalist").css("visibility", "hidden").empty();
});