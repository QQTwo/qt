function serviceCollection(sid){
	jQuery.getJSON("/c/gsq/user/queryAUser",function(data){
		if(data!=null){
			jQuery.getJSON("api/serviceCollection",{"sid":sid},function(result){
				location.reload();
			});
		}else{
			location.href="/fw-loginHint.html";
		}
	});
}
function postCollection(pid){
	jQuery.getJSON("/c/gsq/user/queryAUser",function(data){
		if(data!=null){
			jQuery.getJSON("api/postCollection",{"pid":pid},function(result){
				location.reload();
			});
		}else{
			location.href="/fw-loginHint.html";
		}
	});
}
