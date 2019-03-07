/**
 * 登录请求
 * @author hxl
 */
var login = (function($){
	
	
	//请求地址
	var actionUrl = WEB_APP_PATH+"/spring";
	
	// 私有方法
	var privateMethods = {
			
			//初始化数据
			loadData:function(){
				
				
			},
			
			//初始化事件
			initEvent:function(){
				
				//登录事件
				$("#add").on("click",function(){
					 $.ajax({
				          url : actionUrl+"/save.do",
				          type : "POST",
				          contentType: "application/json;charset=utf-8",
				          
				          data : JSON.stringify({'name':$("#name").val(),'password':$("#password").val()}),
				          dataType : "json",
				          success : function(result) {
				            if(result.success){
				            	alert(result.content);
				            }else{
				            	alert(result.message);
				            }
				          },
				          error:function(msg){
				           
				          }
				        })
				})
			}
	};
	
	return {
		
		/**
		 * 初始化
		 */
		init : function(){
			privateMethods.initEvent();
			
		}
	};
})(jQuery);