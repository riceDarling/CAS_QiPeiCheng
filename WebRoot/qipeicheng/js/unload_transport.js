// (function(){}(
// 	var thisparm =$("[thiswindow='unload_transport']").attr("parm");
// 	var thisdata ={};
	
// 	$.ajax({
// 	type: "post",
// 	url: getUrl + "waybill/prepareloading",
// 	async: true,
// 	dataType: "json",
// 	timeout: 10000,
// 	data:"",
// 	success: function(data) {
// 		var html = "";
// 		for(one in data.obj) {
// 			html += "<option value=\"" + data.obj[one].id + "\">" + data.obj[one].regionName + "</option>";
// 		}
// 		var getRegion = document.getElementById("getRegion");
// 		getRegion.innerHTML = html;
// 	}
// });
// ));

$.ajax({
    type: "post",
    url: getUrl + "finance/loadingReportUnbound",
    async: true,
    dataType: "json",
    timeout: 10000,
    data: {
        // startDate : "",
        // endDate : ""
		// consignment :"",
		// destination  :""
    },
    success: function (data) {
        console.log(data)
        if (null != data.obj && "" != data.obj) {
        for (var index in data.obj) {
            var content = "<tr>"
            content += "<td>" + data.obj[index].counterFee + "</td>"
            content += "<td>" + data.obj[index].date + "</td>"
            content += "<td>" + data.obj[index].receiver + "</td>"
            content += "<td>" + data.obj[index].receiverPay + "</td>"
            content += "<td>" + data.obj[index].runnum + "</td>"
            content += "<td>" + data.obj[index].shipper + "</td>"
            content += "<td>" + data.obj[index].shipperPay + "</td>"
            content += "<td>" + data.obj[index].total + "</td>"
            content += "</tr>"
        }
        }
    }
})


