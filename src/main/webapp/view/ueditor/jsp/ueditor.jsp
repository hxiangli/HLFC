<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html >
<%@include file="../../../common/jsp/common.jsp"%>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>ueditor demo</title>
</head>

<body>
    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain">

	
    </script>
    	<button id="getContent" onclick="setContent()">设置内容</button>
    	<div id="content">
	    </div
    <!-- 配置文件 -->
    
	 <!-- 编辑器源码文件 -->
	 
    <script type="text/javascript" src="<%=webAppPath %>/libs/ueditor/ueditor.config.js"></script>
    
    <script type="text/javascript" src="<%=webAppPath %>/libs/ueditor/ueditor.all.js"></script>
    
	 <script type="text/javascript" src="<%=webAppPath %>/libs/ueditor/ueditor.parse.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container');
        
		//实例化的时候可以传入配置参数
//         var ue = UE.getEditor('container', {
// 					    toolbars: [
// 					        ['fullscreen', 'source', 'undo', 'redo', 'bold']
// 					    ],
// 					    autoHeightEnabled: true,
// 					    autoFloatEnabled: true
// 					});
        //获取配置
//         var lang = ue.getOpt('lang'); //默认返回：zh-cn

		//对编辑器的操作最好在编辑器ready之后再做
         ue.ready(function() {
            //设置编辑器的内容
            ue.setContent('hello444444444444444444444444444444444444444455555555555555555555555555555555555555566666666666666666666666666666');
            //获取html内容，返回: <p>hello</p>
            var html = ue.getContent();
            //获取纯文本内容，返回: hello
            var txt = ue.getContentTxt();
          
        });
		
		
         function setContent(){
        	 
        	 var html =  ue.getContent();
        	 $("#content").append(html);
        	 
        	//解析展示的内容
        	 uParse("#content", {
            	    rootPath: '../'
             })
         }
		
    </script>
</body>

</html>