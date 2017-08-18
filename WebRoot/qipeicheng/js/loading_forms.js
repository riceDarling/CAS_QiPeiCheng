
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
    	if (null != data.obj && "" != data.obj) {
    	for(var i in data.obj){
    		var options = "<option>"+data.obj[i].regionName+"</option>"
    		$("#shipperAddress").append(options)
    		$("#getRegion").append(options)
    	}}
    }
})