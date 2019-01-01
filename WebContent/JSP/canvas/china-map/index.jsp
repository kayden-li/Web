<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/mask.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/menu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/regiest.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/JSP/canvas/city/cityselect.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JSP/canvas/china-map/js/lib/raphael-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JSP/canvas/china-map/js/res/chinaMapConfig.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JSP/canvas/china-map/js/map-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JSP/canvas/city/cityselect.js"></script>

<script type="text/javascript">
	$(function(){
		$('#ChinaMap').SVGMap({
			mapWidth: 800,
			mapHeight: 600
		})
	})
</script>
</head>
<body>
<div class="wrap" style="margin-top: 50px;margin-left:200px;">
<div style="text-align:center;clear:both;">
</div>

<div class="itemCon" style="float: left">
	<div id="ChinaMap" style="margin: 50px;"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/SCRIPT/Func.js"></script>
<div id="menu" style="display:none;">
	<div id="specialty">
		<img class="menu" src="${pageContext.request.contextPath}/RES/menu.png">
		<img class="food-img">
		<p class="food-name"></p>
		<p class="food-peo"></p>
		<p class="food-intro" style="overflow-y: scroll;">啊哦，此地还有没人发布食物哦！</p>
		<p class="menu-close">X</p>
		<div class="change" id="last">上一个</div><div class="change" id="next">下一个</div>
		<input type="text" class="toPn" id="toPn" >
	</div>
	<div id="reg">
		<form id="regiestF">
			<p class="menu-close">X</p>
			<input id="Rname" type="text" name="name" placeholder="请输入姓名">
			<input id="Rid" type="text" name="id" placeholder="请输入账号(登陆账号)">
			<p id="idEr" class="error" style="font-size:18px;">该id已被使用，请更换</p>
			<input id="Rarea" type="text" name="area" style="ime-mode:disabled" placeholder="请输入地区(点击以选择)">
			<label><input type="radio" name="sex" value="1" checked="checked">男</label>
			<label><input type="radio" name="sex" value="0">女</label>
			<input id="Rpass" type="password" name="password" placeholder="请输入密码">
			<input id="Rpass_" type="password" placeholder="请再次输入密码">
			<p id="passEr" class="error" style="font-size:18px;">两次密码不同</p>
			<input id="Rnum" type="text" name="num" placeholder="请输入手机号">
			<button id="submit" type="button">点击注册</button>
		</form>
	</div>
</div>
<script type="text/javascript">
var test=new Vcity.CitySelector({input:'Rarea'});
</script>
</body>
</html>