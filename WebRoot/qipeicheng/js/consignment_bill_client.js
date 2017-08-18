$("[subid='shipper']").focus(function() {
	$(".datalist").off("change");
	var inputtimeout;
	$(this).bind("input propertychange", function() {
		clearTimeout(inputtimeout);
		if($(this).val() != "" && $(this).val() != null && $(this).val() != undefined) {
			var thisxx = $(this);
			inputtimeout = setTimeout(function() {
				var url = "customer/getCustomerByNameRegion"

				$.ajax({
					type: "post",
					url: getUrl + url,
					  xhrFields: {
							withCredentials: true
						},
					async: false,
					data: {
						"regionName": $("#getRegion").val(),
						"customerName": $(thisxx).val()
					},
					cache:false, 
					dataType: "json",
					timeout: 10000,
					success: function(data) {
						console.log(data);
						var html = "";
						for(var i in data.obj) {
							if(i < 10) {
								html += "<option value=\"" + i + "\">";
								html += data.obj[i].customerName;
								html += "</option>";
							}
						};

						$(".datalist").off("change").html(html).css({
							"left": ($(thisxx).offset().left - $(window).scrollLeft()) + "px",
							"top": ($(thisxx).offset().top - $(window).scrollTop() + $(thisxx).outerHeight()) + "px",
							"visibility": "visible"
						}).on("change", function() {
							console.log($(thisxx).attr("subid"))
								$("[subid='shipper']").val(data.obj[$(this).val()].customerName);
								$("[subid='shipperAddress']").val(data.obj[$(this).val()].customerAddress);
								$("[subid='shipperPhone']").val(data.obj[$(this).val()].customerPhone);
								$("[subid='shipperContacts']").val(data.obj[$(this).val()].customerContacts);
								$(this).off("change");
							

						})

					}
				});
			}, 500)
		} else {
			$(".datalist").css("visibility", "hidden").empty().off("change");
		}
	});
});
$("[subid='receiver']").focus(function() {
	$(".datalist").off("change");
	var inputtimeout;
	$(this).bind("input propertychange", function() {
		clearTimeout(inputtimeout);
		if($(this).val() != "" && $(this).val() != null && $(this).val() != undefined) {
			var thisxx = $(this);
			inputtimeout = setTimeout(function() {
				var url = "customer/getCustomerByNamePhone"

				$.ajax({
					type: "post",
					url: getUrl + url,
					  xhrFields: {
							withCredentials: true
						},
					async: false,
					data: {
						"regionName": $("#getRegion2").val(),
						"customerName": $(thisxx).val()
					},
					cache:false, 
					dataType: "json",
					timeout: 10000,
					success: function(data) {
						console.log(data);
						var html = "";
						for(var i in data.obj) {
							if(i < 10) {
								html += "<option value=\"" + i + "\">";
								html += data.obj[i].customerName;
								html += "</option>";
							}
						};

						$(".datalist").off("change").html(html).css({
							"left": ($(thisxx).offset().left - $(window).scrollLeft()) + "px",
							"top": ($(thisxx).offset().top - $(window).scrollTop() + $(thisxx).outerHeight()) + "px",
							"visibility": "visible"
						}).on("change", function() {
							console.log($(thisxx).attr("subid"))
							
								$("[subid='receiver']").val(data.obj[$(this).val()].customerName);
								$("[subid='receiverAddress']").val(data.obj[$(this).val()].customerAddress);
								$("[subid='receiverPhone']").val(data.obj[$(this).val()].customerPhone);
								$("[subid='receiverContacts']").val(data.obj[$(this).val()].customerContacts);
								$(this).off("change");
						})

					}
				});
			}, 500)
		} else {
			$(".datalist").css("visibility", "hidden").empty().off("change");
		}
	});
});
/*$.ajax({
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
		for(var index in data.obj) {
			content += "<option>" + data.obj[index].regionName + "</option>"
		}
		$("#getRegion").html(content);
	}
})*/
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
			var content2 = "";
			for(var index in data.obj) {
				content2 += "<option>" + data.obj[index].regionName + "</option>"
			}
			$("#getRegion2").html(content2);
		}
	})
function getRunnum(){
	$.ajax({
		type: "post",
		url: getUrl + "waybill/getRunnum",
		async: true,
		dataType: "json",
		timeout: 10000,
		success: function(data) {
			$("#runnum").val(data.t);
		}
	})
}
$.ajax({
	type: "post",
	url: getUrl + "waybill/getRunnum",
	async: true,
	dataType: "json",
	timeout: 10000,
	success: function(data) {
		$("#runnum").val(data.t);
	}
})
function  printbill(){
	Cef.SetPrinter('1');
	   $("#time").html(time());  $("#firstone").html("汽配城");$("#firsttwo").html($("#getRegion").val());
       $("#secondone").html($("#shipper").val());$("#secondtwo").html($("#receiver").val());$("#secondthree").html($("#runnum").val());
       $("#thirdone").html($("#phoneOne").val());$("#thirdtwo").html($("#phoneTwo").val());
       $("#fourthone").html($("#all_number").val());$("#fourthtwo").html($("#freight").val());$("#fourththree").html($("#replace_cost").val());$("#fourthfour").html($("#total").val());
		LODOP.PRINT_INIT("");
		LODOP.ADD_PRINT_HTM(70,20,"100%","100%",$("#PFP").html());
		//LODOP.PREVIEW();	
		LODOP.PRINT();	
   }
    function  printArea(){
       Cef.SetPrinter('2');
	   $("#start").html("汽配城→"+$("#getRegion").val());
       $("#receive").html($("#receiver").val());
       $("#run").html("*"+$("#runnum").val()+"*");
       $("#js").html($("#all_number").val());
       if($("#weight").val()==0){
       	$("#jsweight").html(" ");
       }
       else{$("#jsweight").html($("#weight").val());}
       if($("#volume").val()==0){
       	$("#jsvolume").html(" ");
       }
       else{$("#jsvolume").html($("#volume").val());}
       $("#bcTarget").empty().barcode($("#runnum").val(), "code39",{barWidth:1, barHeight:35,showHRI:false});
		LODOP.PRINT_INIT("");
		LODOP.ADD_PRINT_HTM(15,5,"100%","100%",$("#PF").html());
		//LODOP.PREVIEW();	
		LODOP.PRINT();	
   }
    
    $("#runnum").change(function(){
    	$(".redalert,.bluealert").hide();
    	$.ajax({
    		type: "post",
    		url: getUrl + "waybill/checkRunnum",
    		async: true,
    		data:{
    			"runnum":$("#runnum").val(),
    		},
    		dataType: "json",
    		timeout: 10000,
    		success: function(data) {
    			if(data.t>0){
    				$(".redalert").show();
    				$("#runnum").val("");
    			}else{
    				$(".bluealert").show();
    			}
    		}
    	})
    })