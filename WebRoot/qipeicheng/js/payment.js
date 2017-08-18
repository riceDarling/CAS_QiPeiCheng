$.ajax({
	type: "post",
    url: getUrl + "region/getAllRegion",
    xhrFields: {
		withCredentials: true
	},
    async: true,
    dataType: "json",
    timeout: 10000,
    success: function (data) {
    	console.log(data)
    	for(var i in data.obj){
    		var options = "<option>"+data.obj[i].regionName+"</option>"
    		$("#consignment").append(options)
    		$("#destination").append(options)
    	}
    }
})

$.ajax({
    type: "post",
    url: getUrl + "region/getAllRegion",
    async: true,
    dataType: "json",
    timeout: 10000,

    success:function(data){
        console.log(data)
    }
})