 $("#runnum").focus();    
function time() {
        var time = new Date();
        var y = time.getFullYear();
        var m = time.getMonth() + 1;
        if (m < 10)
            m = '0' + m
        var d = time.getDate();
        if (d < 10)
            d = '0' + d
        var h = time.getHours();
        if (h < 10)
            h = '0' + h
        var mi = time.getMinutes();
        if (mi < 10)
            mi = '0' + mi
        var s = time.getSeconds();
        if (s < 10)
            s = '0' + s
        return y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
    }

    document.getElementById("time").value = time();
    
    $("#toTwo").click(function(){
        document.cookie = "runnum="+$("#runnum").val()
    })