<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>以食为天</title>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="${pageContext.request.contextPath}/CSS/mask.css" rel="stylesheet">
</head>
<body id="page">
	<!-- 加载真实主页，防止js文件暴露 -->
	<!-- <script type="text/javascript">$('#page').load('${pageContext.request.contextPath}/JSP/canvas/Font/index2.jsp')</script> -->
	<iframe sandbox="allow-same-origin"></iframe>
	<div id="t"></div>
	<input type="text" id="text" value="" />
	<input type="button" id="s" value="write" onclick="test()" />
	
</body>
<script type="text/javascript">
function test(){
	var str = document.getElementById("text").value;
	document.getElementById("t").innerHTML = "<a href='"+str+"'>testLink</a>"
}

$("iframe").contents().find("body").html("${test}")
</script>
</html>