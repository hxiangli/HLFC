<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

// 应用的主路径
String webAppPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() + "/";
%>

<script type="text/javascript">
	var WEB_APP_PATH = "<%= webAppPath%>";
</script>

<script src="<%=webAppPath %>/common/js/jquery-1.8.2.min.js"></script>