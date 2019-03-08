var sjzxHref="/c/gsq/user/getUserBySjzx";
var grzxHref="/c/gsq/center/home";
var zhszHref="/c/gsq/user/queryGrzxInfo";
var xxHref="/xx-xtxx.html";
$.getJSON("/c/gsq/user/queryAUser",function(data){
	$("#li1 a").attr("href",sjzxHref);
	$("#li2 a").attr("href",grzxHref);
	$("#li3 a").attr("href",zhszHref);
	$("#li4 a").attr("href",xxHref);
	if(data.auditstatus!=2){
		$("#li1").remove();
	}
})

