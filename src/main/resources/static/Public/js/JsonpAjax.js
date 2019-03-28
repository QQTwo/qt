$(function(){
	 
//当键盘键被松开时发送Ajax获取数据
		$('#text').keyup(function(){
			
			var keywords = $(this).val();
			if (keywords=='') { $('#word1').hide(); return };
			$.ajax({
				url: '/cn/c/selectAllServices?service=' + keywords,
				dataType: 'json',
				type:"get",
				//jsonp: 'cb', //回调函数的参数名(键值)key
				// jsonpCallback: 'fun', //回调函数名(值) value
				beforeSend:function(){
					$('#word1').append('<div>正在加载。。。</div>');
				},
				success:function(data){
					//alert(JSON.stringify(data));
					$('#word1').empty().show();
					if (data=='')
					{
						$('#word1').append('<div class="error">未找到匹配内容！ "' + keywords + '"</div>');
					}
					$.each(data, function(index,temp){
						$('#word1').append('<div class="click_work">'+ temp.serviceTitle +'</div>');
						$('#word1').append('<div class="click_work">'+ temp.serviceFuTitle +'</div>');
						$('#word1').append('<div class="click_work">'+ temp.stName +'</div>');
					})
				},
				error:function(){
					$('#word1').empty().show();
					$('#word1').append('<div class="click_work">Fail "' + keywords + '"</div>');
				}
			})
		})
		//点击搜索数据复制给搜索框
		$(document).on('click','.click_work',function(){
			var word = $(this).text();
			$('#text').val(word);
			$('#word1').hide();
			/*$('#texe').trigger('click');触发搜索事件*/
		})

		
		//获得焦点
		$( '#text' ).focus( function(){
			
			if($(this).val()==""){
				$.ajax({
					url: '/cn/c/selectAllServices?service=文',
					dataType: 'json',
					type:"get",
					/*jsonp: 'cb', //回调函数的参数名(键值)key
*/					// jsonpCallback: 'fun', //回调函数名(值) value
					beforeSend:function(){
						$('#word1').append('<div>正在加载。。。</div>');
					},
					success:function(data){
						$('#word1').empty().show();
						if (data.s=='')
						{
							$('#word1').append('<div class="error">未找到匹配内容！  "' + keywords + '"</div>');
						}
						$.each(data, function(index,temp){
							$('#word1').append('<div class="click_work"><span style="color:red;font-weight: bold;">HOT</span>'+  temp.serviceTitle  +'</div>');
						})
					},
					error:function(){
						$('#word1').empty().show();
						$('#word1').append('<div class="click_work">Fail "' + keywords + '"</div>');
					}
				})

			}
			} );
	})