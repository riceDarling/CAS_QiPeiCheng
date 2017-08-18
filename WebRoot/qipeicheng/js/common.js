
popupdata = {
	"addvehicle": "popupAddvehicle.html",
	"editvehicle":"popupEditvehicle.html",
	"addvehicletype":"popupAddvehicletype.html",
	"editvehicletype":"popupEditvehicletype.html",
}

$(document).ready(function() {
	$("#leftunfoldingArrow").hide();
	$("#leftfoldingArrow").show();
	$(".JCZ_leftFoldingArrow_xk").parent("dt").siblings("dd").show();
});
$(document).on("click", ".JCZ_leftFoldingArrow_xk", function() {
	if($(this).children("#leftunfoldingArrow").is(":hidden")) {
		$(this).children("#leftunfoldingArrow").show().siblings("#leftfoldingArrow").hide().parent().parent("dt").siblings("dd").stop().fadeOut(100);
	} else {
		$(this).children("#leftunfoldingArrow").hide().siblings("#leftfoldingArrow").show().parent().parent("dt").siblings("dd").stop().fadeIn(100);
	}
});
$(document).on("click", ".JCZ_left_xk .JCZ_content_xk dd", function() {
	$(this).siblings("dd").removeClass("on_xk");
	$(this).addClass("on_xk");
});
$(document).on("click", ".JCZ_pagenum_xk a.button[id_xk='number']:not('.on_xk')", function() {
	$(this).siblings("a.button[id_xk='number']").removeClass("on_xk");
	$(this).addClass("on_xk");
});

$(document).on("click", "[clickToPopup]", function() {
	if($(this).attr("id_xk") != null && $(this).attr("id_xk") != "" && $(this).attr("id_xk") != undefined) {
		$.get(popupdata[$(this).attr("id_xk")]).success(function(data) {
			if(data != null && data != "" && data != undefined) {
				var html_xk = "";
				html_xk += '<div class="popupwindow">';
				html_xk += data;
				html_xk += '</div>';
				$("body").append(html_xk);
			}
		});
	}
});
$(document).on("click", "input[id_xk='removepopupwindow']", function() {
	$(this).parents(".popupwindow").remove();
})
$(document).on("click", "input[id_xk='submitpopupwindow']", function() {
	alert("提交成功");
	$(this).parents(".popupwindow").remove();
})
$(document).on("click",".JCZ_left_xk .JCZ_content_xk>dl>dd",function(){
	location.href=$(this).attr("id_xk")+".html";
});
$(document).on("click",".JCZ_left_xk .JCZ_content_xk>dl>dt>.JCZ_leftTitle_xk",function(){
	location.href="index.html";
});