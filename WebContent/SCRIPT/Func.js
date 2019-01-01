/**
 * 特产显示
 */
var menu = $('#menu')
var specialty = $('#specialty')
var regiest = $('#reg')
var user = $('#user')
var kitchen = $('#kitchen')
var last = $('#last')
var next = $('#next')
var num = 0;
var totalNum = 0;
var res
var node = window.location.pathname.split('/').length
var _2url = "get"
var _2url2 = "regiest"
var _2url3 = "RES/"
	if(node == 3){
		_2url = "get"
		_2url2 = "regiest"
		_2url3 = "RES/"
	}
	else if(node == 4){
		_2url = "../get"
		_2url2 = "../regiest"
		_2url3 = "../RES/"
	}
$('.menu-close').click(function(){
	menu.css("display","none")
	regiest.css("display","none")
	user.css("display","block")
	specialty.css("display","block")
	showKit()
})
$('path').click(function(test){
	var that = this
	var i, temp = 0;
	$('path').each(function(){
		temp++
		if(this === that)
			i = temp;
	})
	temp = 0;
	$('tspan').each(function(){
		temp++
		var that = this
		if(temp === i){
			var $area = $(this).context.innerHTML
			num = 0
			$.ajax({
				url: _2url,
				type:"GET",
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				data:{"area":$area},
				async:false,
				success:function(response){
					res = response
					loader();
				}
			})
		}
	})
})

last.click(function(){
	if(num != 0){
		num--
		loader()
	}
})
next.click(function(){
	if(num < totalNum-1){
		num++;
		loader()
	}
})
function loader(){
	menu.css("display","block")
	specialty.css("display","block")
	user.css("display","none")
	regiest.css("display","none")
	kitchen.css("display","none")
	$('#showKit').css("display","none")
	totalNum = res.length
	var data = res[num]
	if(data == undefined){
		$('.food-intro').text("啊哦，此地还有没人发布哦！")
		$('.food-name').text("")
		$('.food-peo').text("")
	}
	else{
		$('#toPn').val(num+1)
		$('.food-name').text(data.name)
		$('.food-intro').text(data.intro)
		$('.food-peo').text(data.publisher)
		if(data.img != undefined)
			$('.food-img').attr("src",_2url3+data.img)
		else
			$('.food-img').attr("src",'')
	}
}

$('#toPn').blur(function(){
	if($('#toPn').val() <= totalNum
			&& $('#toPn').val() >= 0){
		num = $('#toPn').val()-1
		loader()
	}
})
/*
*	注册事件处理
*/
	
$('#Rpass_').blur(function() {
	if($('#Rpass_').val() == $('#Rpass').val() && $('#Rpass').val() != "")
		$('#passEr').css("display","none")
	else
		$('#passEr').css("display","block")
});
$('#regiest').click(function(){
	menu.css("display","block")
	specialty.css("display","none")
	user.css("display","none")
	regiest.css("display","block")
	kitchen.css("display","none")
})
$('#submit').click(function(){
	if($('#Rname').val() == "" ||
			$("#Rid").val() == "" ||
			$('#Rarea').val() == "" ||
			$('#Rpass').val() == ""){
		alert("请填写完整哦！")
		return
	}
	var param = decodeURIComponent($('#regiestF').serialize());
	$.ajax({
		url: _2url2,
		type:"GET",
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data:param,
		async:false,
		success:function(response){
			if(response.responseText == 'N'){
				$('#idEr').css("display","block")
			}
			else{
				$('#idEr').css("display","none")
			}
			if(response.id != null && response.id != "" && response.id != undefined){
				alert("注册成功！！！现在开始吧")
				menu.css("display","none")
				regiest.css("display","none")
				user.css("display","block")
				specialty.css("display","none")
				showKit()
			}
		},
		error:function(response){
			if(response.responseText == 'N'){
				$('#idEr').css("display","block")
			}
			else{
				$('#idEr').css("display","none")
			}
			if(response.id != null && response.id != "" && response.id != undefined){
				alert("注册成功！！！现在开始吧")
				menu.css("display","none")
				regiest.css("display","none")
				user.css("display","block")
				specialty.css("display","none")
				showKit()
			}
	}
	})
})
/*
*	我的餐厅
*/
var show = $('#showKit')
var back = $('#showKit_back')
function showKit(){
	if($('#exit').css("display") != "none" &&
			$('#exit').css("display") != undefined){
		$('#showKit').css("display","block")
		show.css("display","block")
		show.animate({marginLeft:"85%"},800)
		show.animate({marginLeft:"90%"},300)
		show.animate({marginLeft:"85%"},800)
		show.animate({marginLeft:"90%"},300)
	}
	else{
		$('#showKit').css("display","none")
		show.css("display","none")
	}
}
show.click(function(){
	$('#map').animate({marginLeft:"-1800px"}, 500)
	$('#kit_img').attr("src","RES/restaurant.png")
	back.css("display", "block")
	kitchen.css("display", "block")
	show.css("display", "none")
	$('#kitFun').css("display", "block")
	back.animate({marginLeft:"0"}, 800)
	back.animate({marginLeft:"5%"}, 300)
	back.animate({marginLeft:"0"}, 800)
	back.animate({marginLeft:"5%"}, 300)
})
back.click(function(){
	back.css("display", "none")
	$('#map').animate({margin:"0"}, 500)
	show.css("display", "block")
	$('#kitFun').css("display", "none")
	show.animate({marginLeft:"85%"},800)
	show.animate({marginLeft:"90%"},300)
	show.animate({marginLeft:"85%"},800)
	show.animate({marginLeft:"90%"},300)
})
var kmenu = $('#kit_menu')

$('#close_cook').click(function(){
	kmenu.css('display','none')
	$('#cook_').css('display','none')
	$('#list').css('display','none')
	$('#torecook').css('display','none')
	$('#toclean').css('display','none')
})
$('#cook').click(function(){
	kmenu.css('display','block')
	$('#cook_').css('display','block')
	$('#start_cook').text('开始烹饪')
	$('#cook_').attr('action', 'cook')
	$('#cook_name').removeAttr('disabled')
})
$('#recook').click(function(){
	kmenu.css('display','block')
	$('#list').css('display','block')
	$('#torecook').css('display','block')
	$('#toclean').css('display','none')
	$('#kit_last').css('margin-top','-2%')
	$('#kit_next').css('margin-top','-2%')
	getMyFood()
})
$('#locker').click(function(){
	kmenu.css('display','block')
	$('#list').css('display','block')
	$('#kit_last').css('margin-top','3%')
	$('#kit_next').css('margin-top','3%')
	getMyFood()
})
$('#clean').click(function(){
	kmenu.css('display','block')
	$('#list').css('display','block')
	$('#torecook').css('display','none')
	$('#toclean').css('display','block')
	$('#kit_last').css('margin-top','-2%')
	$('#kit_next').css('margin-top','-2%')
	getMyFood()
})
function setImagePreview(avalue) {
	var docObj=document.getElementById("cook_img");
	var imgObjPreview=document.getElementById("preview");
	
	//文件类型检测
	var allowtype = [ "jpg", "gif","png","Jpeg"]
	var filepath = $("#cook_img")[0].value
	var thisfiletype=filepath.substring(filepath.lastIndexOf(".")+1,filepath.length).toLowerCase();  
    if ($.inArray(thisfiletype,allowtype) == -1){ 
    	alert("请选择‘jpg’, ‘gif’,‘png’,‘Jpeg’类型图片")
        return   
    }
    
    //回显图片
	if(docObj.files &&docObj.files[0])
	{
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		$('#subimg').css('display',"none")
	}
	else
	{
		//IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		var localImagId = document.getElementById("preview");
		//图片异常的捕捉，防止用户修改后缀来伪造图片
		try{
			localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		}
		catch(e)
		{
			alert("您上传的图片格式不正确，请重新选择!");
			return false;
		}
		imgObjPreview.style.display = 'block';
		document.selection.empty();
		$('#subimg').css('display',"none")
	}
	return true;
}
function validate(){
	if($('#cook_name').val() == "" ||
			$('#cook_cook_intro').val() == ""){
		alert("请先填写完整哦")
		return false
	}
	return true
}
$('#hidden_frame').load(function(){
    var text=$(this).contents().find("body").text();
    $('#kit_menu').css('display','none');
    $('#cook_').css('display','none');
    alert(text)
})
var list_num
var curNum
var list_obj
function getMyFood(){
	$.ajax({
		url: 'getMyFood',
		type:"GET",
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data:{"publisher":$('.Uname').text()},
		async:false,
		success:function(response){
			list_num = response.length
			list_obj = response
			curNum = 0
			setList()
		}
	})
}
$('#kit_next').click(function(){
	setList()
})
$('#kit_last').click(function(){
	curNum -= 10
	setList()
})
function setList(){
	if(curNum == list_num)
		return
	else if(curNum < 0)
			curNum = 0
	var list = '';
	for(; curNum < list_num; ++curNum){
		list = list + '<li>' + list_obj[curNum].name + '</div><input name="choice" type="checkbox" value="' + list_obj[curNum].name + '"></li>'
	}
	$('#list ul').html(list)
}

$('#kitPn').blur(function(){
	if(($('#kitPn').val()-1) * 10 <= list_num
			&& ($('#kitPn').val()-1) * 10 >= 0){
		curNum = ($('#kitPn').val()-1) * 10
		console.log(curNum)
		setList()
	}
})
$('#toclean').click(function(){
	var che = "";
	for(var i = 0; i < $("input[type='checkbox']:checked").length; ++i){
		che += $("input[type='checkbox']:checked")[i].defaultValue+"/"
	}
	$.ajax({
		url: 'clean',
		type:"GET",
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data:{"str":che},
		async:false,
		success:function(response){
			if(response.responseText == 'Y'){
				alert("ヾﾉ≧∀≦)o清洗干净啦！")
				$('#kit_menu').css('display','none');
			}
			else if(response.responseText == 'N')
				alert("Σ⊙▃⊙川天啦噜，没洗干净！！！")
		},
		error:function(response){
			if(response.responseText == 'Y'){
				alert("ヾﾉ≧∀≦)o清洗干净啦！")
				$('#kit_menu').css('display','none');
			}
			else if(response.responseText == 'N')
				alert("Σ⊙▃⊙川天啦噜，没洗干净！！！")
		}
	})
})
$('#torecook').click(function(){
	if($("input[type='checkbox']:checked")[0].defaultValue != undefined ||
			$("input[type='checkbox']:checked")[0].defaultValue != null){
		for(var i = 0; i < list_obj.length; ++i){
			if(list_obj[i].name == $("input[type='checkbox']:checked")[0].defaultValue){
				kmenu.css('display','block')
				$('#cook_').css('display','block')
				$('#list').css('display','none')
				$('#torecook').css('display','none')
				$('#toclean').css('display','none')
				$('#cook_img').css('display','none')
				$('#subimg').css('display','none')
				$('#preview').css('display','block')
				
				$('#preview').attr('src','RES/'+list_obj[i].img)
				$('#cook_name').val(list_obj[i].name)
				$('#cook_intro').val(list_obj[i].intro)
				$('#start_cook').text('开始加工')
				$('#cook_name').attr('disabled','disabled')
				$('#cook_').attr('action', 'recook')
			}
				
		}
	}
})