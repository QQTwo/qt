$(".top_right").html("");
$.getJSON("/c/gsq/user/queryAUser",function(data){
	if(data==null){
		$(".top_right").append($('<a href="/gsq-login.html">登录</a><span class="ht_line"></span><a href="/gsq-zuce.html">注册</a>'));
	}else{
		$(".top_right").append($('<a href="/c/gsq/center/home">'+data.username+'</a> <span class="ht_line"></span><a href="/c/gsq/user/close">退出</a><span class="ht_line"></span><a href="/xx-xtxx.html"><img src="/Public/images/e_i.png" alt=""></a>'));
	}
})

