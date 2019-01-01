<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.model.User" %>
<%@ page import="com.model.Food" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>以食为天</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Font.css"> --%>
<link href="${pageContext.request.contextPath}/CSS/main.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<audio id="bgMusic" src="${pageContext.request.contextPath}/RES/music01.mp3" autoplay preload loop="loop"></audio>
	<div id="map"></div>
	<div id="user">
		<c:choose>
			<c:when test="${user!=null}">
				<div class="Uname">${user.name}</div>
				<div class="Uarea">${user.area}</div>
				<c:choose>
		   			<c:when test="${user.sex}">  
						<div class="Usex">男</div>
					</c:when>
					<c:otherwise><div class="Usex">女</div></c:otherwise>
				</c:choose>
				<div id="exit" style="cursor:pointer;">退出</div>
			</c:when>
			<c:otherwise>
				<div style="width:400px;">你还没有登陆哦！！！</div>
				<div id="login" style="width:150px;cursor:pointer;">点此登陆</div>
				<div id="regiest" style="width:400px;cursor:pointer;">还没有账号，点我注册</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="showKit" class="showKit">☞</div>
	<div id="kitchen">
		<div id="showKit_back" class="showKit">☚</div>
		<div id="kitFun">
			<img id="kit_img">
			<div id="hearth">灶台</div>
			<div id="kit_make">
				<div id="cook">烹饪</div>
				<div id="recook">加工</div>
			</div>
			<div id="locker">储物柜</div>
			<div id="clean">清洗餐具</div>
			<div id="kit_menu">
				<div id="close_cook">X</div>
				<img src="${pageContext.request.contextPath}/RES/menu.png">
				<form id="cook_" action="cook" enctype="multipart/form-data" method="post" target="hidden_frame"
					onsubmit="return validate();">
					<input id="cook_img" name="img" type="file"  onchange="javascript:setImagePreview();">
					<div id="subimg" OnClick='javascript:$("#cook_img").click();'>上传图片</div>
					<img id="preview" OnClick='javascript:$("#cook_img").click();' >
					<input id="cook_name" class="cook_in" name="name" type="text" placeholder="请输入菜名">
					<br />
					<textarea id="cook_intro" class="cook_in" name="intro" type="text" placeholder="介绍一下这道菜吧！"></textarea>
					<input name="area" style="display:none;" value="${user.area}">
					<input name="publisher" style="display:none;" value="${user.name}">
					<button id="start_cook" type="submit">开始烹饪</button>
				</form>
				<iframe name="hidden_frame" id="hidden_frame" style='display: none'></iframe>
				<form id="list">
					<ul>
					</ul>
					<div id="toclean" style="display:none;">确定清洗</div>
					<div id="torecook" style="display:none;">确定加工</div>
					<div id="kit_next">下一页</div>
					<div id="kit_last">上一页</div>
					<input type="text" class="toPn" id="kitPn" >
				</form>
			</div>
		</div>
	</div>
	<!-- 遮罩层 -->
	<div id="mask"></div>
	<!-- 登录表单 -->
	<form class="login-form" id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
		<div class="error" id="msg"></div>
		<div class="close" id="close-login">X</div>
		<h3 style="margin:0;">登录</h3>
		<input  style="margin-top:15px;" type="text" name="username" placeholder="用户名" id="username" />
		<input  style="margin-top:15px;" type="password" name="password" placeholder="密码" id="password" />
		<button  style="margin-top:20px;margin-left:0;" type="submit" class="login-btn" id="login">登录</button>
	</form>
</body>
<script type="text/javascript">
	$('#map').load("${pageContext.request.contextPath}/JSP/canvas/china-map/index.jsp");
	
	$('#login').click(function(){
		$('#mask').css('display', 'block');
		$('#loginForm').css('display', 'block');
	})
	//关闭窗口
	$('#close-login').click(function(){
		$('#mask').css('display', 'none');
		$('#loginForm').css('display', 'none');
	})
	$('#exit').click(function(){
		window.location.href="${pageContext.request.contextPath}/JSP/main.jsp"
	})
	
	$(document).ready(function () {
		if($('#exit').css("display") != "none" &&
				$('#exit').css("display") != undefined){
			$('#showKit').css("display","block")
		}
		else{
			$('#showKit').css("display","none")
		}
		setTimeout(function () {
			$('#showKit').animate({marginLeft:"85%"},800)
			$('#showKit').animate({marginLeft:"90%"},300)
			$('#showKit').animate({marginLeft:"85%"},800)
			$('#showKit').animate({marginLeft:"90%"},300)
		}, 1000)
	})
	
	$('#hearth').click(function(){
		$('#kit_make div').slideToggle(500)
	})
</script>
</html>