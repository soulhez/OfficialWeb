$(function(){
	//蓝色按钮下标
	var $btn =$("button[name=wenz]:hidden").index();
	//白色按钮下标
	var $bbtn=$("label[class=bal]:hidden").index();
	if($btn==-1){
		$("#btgroup").hide();
		$("#dhgroup").hide();
		$("#scgroup").hide();
		$("#lxgroup").hide();
		$("#xggroup").hide();
		$("#lxUpdates").hide();
		$("#addgroup").hide();
		$("#materialUpdate").hide();
		$("#zy").show();
		$("label[for=two]").addClass("fuck");
	}
	$("#two").click(function(){
		$("label[for=one]").removeClass("fuck");
		$("label[for=two]").addClass("fuck");
	});
	$("button[name=wenz]").click(function(){
		$(this).hide();
		$(this).next().show();
		//$(this).parent("div").siblings("div").children("label").hide();
		//$(this).parent("div").siblings("div").children("button").show();
		//alert($(this).parent().parent().siblings().children().children("label").hide());
		$(this).parent().parent().siblings().children().children("label").hide()
		$(this).parent().parent().siblings().children().children("button").show();
		$("#zy").hide();
		$("label[for=two]").removeClass("fuck");
		$("label[for=one]").addClass("fuck");
	});
	$("label[class=bal]").click(function(){
		$(this).hide();
		$(this).prev().show();
		$(this).parent().parent().siblings().children().children("label").hide()
		$(this).parent().parent().siblings().children().children("button").show();
		//$(this).parent("div").siblings("div").children("label").hide();
		//$(this).parent("div").siblings("div").children("button").show();
		$("label[for=one]").removeClass("fuck");
		$("label[for=two]").addClass("fuck");
		$("#btgroup").hide();
		$("#dhgroup").hide();
		$("#scgroup").hide();
		$("#lxgroup").hide();
		$("#xggroup").hide();
		$("#addgroup").hide();
		$("#lxUpdates").hide();
		$("#materialUpdate").hide();
		$("#zy").show();
	});
	$("#wz").click(function(){
		$("#btgroup").show();
		$("#dhgroup").hide();
		$("#scgroup").hide();
		$("#lxgroup").hide();
		$("#xggroup").hide();
		$("#addgroup").hide();
		$("#materialUpdate").hide();
		$("#lxUpdates").hide();
	});
	$("#sc").click(function(){
		$("#scgroup").show();
		$("#lxgroup").hide();
		$("#btgroup").hide();
		$("#dhgroup").hide();
		$("#xggroup").hide();
		$("#addgroup").hide();
		$("#materialUpdate").hide();
		$("#lxUpdates").hide();
	});
	$("#lx").click(function(){
		$("#lxgroup").show();
		$("#scgroup").hide();
		$("#btgroup").hide();
		$("#dhgroup").hide();
		$("#xggroup").hide();
		$("#addgroup").hide();
		$("#materialUpdate").hide();
		$("#lxUpdates").hide();
	});
	$("#dh").click(function(){
		$("#dhgroup").show();
		$("#lxgroup").hide();
		$("#scgroup").hide();
		$("#btgroup").hide();
		$("#xggroup").hide();
		$("#addgroup").hide();
		$("#lxUpdates").hide();
		$("#materialUpdate").hide();
	});
	$("#two").click(function(){
		$("#btgroup").hide();
		$("#dhgroup").hide();
		$("#scgroup").hide();
		$("#lxgroup").hide();
		$("#xggroup").hide();
		$("#addgroup").hide();
		$("#lxUpdates").hide();
		$("#materialUpdate").hide();
		$("#zy").show();
		$("button[name=wenz]").show();
		$("label[class=bal]").hide();
	});
	var dt=new Date();
	var dae=dt.getDate();
	var mothe=dt.getMonth();
	var year=dt.getFullYear();
	var hh=dt.getHours();
	if(hh<=12){
		$("#time").text("早上好!");
	}else if(hh>12&&hh<=18){
		$("#time").text("下午好!");
	}else if(hh>18&&hh<=24){
		$("#time").text("晚上好!");
	}
});
