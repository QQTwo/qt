layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	//加载页面数据
	var linksData = '';
	//加载广告分类
	$.ajax({
		url : "/wdg/adv/types",
		type : "get",
		dataType : "json",
		success:function(data){
			$("#types_select").html("");
			$("#types_select").append("<option value='0'>请选择</option>");
			$.each(data,function(i,e){
				$("#types_select").append("<option value="+e.atid+">"+e.atname+"</option>");
			});
			form.render();
		}
	});
	var obj = {};

//	$("#submit_btn").on("click",function(){
//		
//	})
	//监听提交
	form.on('submit(formDemo)', function(data) {
		obj["atitle"] = $("[name=title]").val();
		obj["aorder"] = $("[name=aorder]").val();
		obj["aimgpath"] = $("#hide_img").val();
		obj["atid"]= $("#types_select").val();
		obj["apcUrl"] = $("[name=apcUrl]").val();
		obj["aappUrl"] = $("[name=aappUrl]").val();
		obj["desc"] = $("[name=desc]").val();
		if(obj["atitle"] =="" || obj["aorder"]=="" || obj["aimgpath"]=="" || obj["atid"]=="" || obj["desc"]==""){
			layer.msg(JSON.stringify(data.field));
			return false;
		}
		$.ajax({
			type : "POST",
			url : "/wdg/adv",
			async : true,
			dataType : "text", //json text 服务器返回的数据类型
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(flag) {
				if(flag=='true'){
					layer.alert("添加成功");
				}
			}
		});
	});
})
	
	//选择预览图片
	$("#imgFile").on("change", function(e) {
		var fr = new FileReader();//读取文件
		var file = this.files[0];//选择第一个文件
		var _temp = file.name.match(/\.jpg|\.png|\.gif|\.bmp/i);
		if (!_temp) {
			this.value = "";
			alert("目前只支持jpg,png,bmp,gif格式图片文件");
			return false;
		} else if (file.size > (1024 * 1024 * 5)) {
			this.value = "";
			alert("目前只支持小于5M大小图片文件");
			return false;
		}
		fr.readAsDataURL(file);//读取文件
		//操作文件事件
		fr.onload = function() {
			var base64Data = this.result;//获得base编码字符串格式
			imgname = file.name;//设置文件名
			//imgObj1.data = base64Data.substring(base64Data
			//		.indexOf(';base64,') + 8);//设置base64数据字符串
			$("#hide_img").val(base64Data);
			$("#upload_img").attr("src", base64Data);//显示图片
			$("#upload_div").show();
			//console.debug(imgObj1);
			//					tmpe=base64Data;
			//					console.debug(tmpe);
		};
	});