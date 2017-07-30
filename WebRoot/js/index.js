$(function(){
	/***************************初始化*************************************/
	var navindex=0;//导航下标
	var lbindex=0;//轮播图下标
	var dwindex=0;//定位下标
	var timer=window.setInterval(step,4000);//图片轮播定时器
	var imgli=$(".imglist li");//图片下面的li
	var numli=$(".numlist li");//数字下面的li
	imgli.eq(0).show();//显示第一张图片
	change();
	/***************************方法*************************************/
	//下一张轮播图
	function step(){
		lbindex=++lbindex%numli.length;
	    change();
	}
	//轮播图改变方法
	function change(){
	    numli.eq(lbindex).addClass("active").siblings().removeClass("active");
	    imgli.eq(lbindex).show().siblings().hide();
	    imgli.eq(lbindex).find(".txt").stop().animate({left:0},700,function(){
	        imgli.eq(lbindex).find(".con").show().stop().animate({left:0},700)
	    });
	    imgli.eq(lbindex).siblings().find(".txt").css("left","-760px");
	    imgli.eq(lbindex).siblings().find(".con").css({left:"-20px",display:"none"});
	}
	/***************************事件*************************************/
	$("[name*='navbar']").live("mouseover",function(){
		navindex=$(this).attr("name").substring(6,7);
		$("[name='hiddennav']").eq(navindex).slideDown();
	});
	$("[name*='navbar']").live("mouseout",function(){
		$("[name='hiddennav']").slideUp();
	});
	$("[name='hiddennav']").live("mouseover",function(){
		$("[name='hiddennav']").eq(navindex).stop();
	});
	$("[name='hiddennav']").live("mouseout",function(){
		$("[name='hiddennav']").eq(navindex).slideUp();
	});
	$("[name='hiddennav'] a").hover(function(){
		$(this).css("text-decoration","none");
	},function(){
		$(this).css("text-decoration","none");
	});
	$("footer a").hover(function(){
		$(this).css({"color":"white","text-decoration":"none"});
	},function(){
		$(this).css({"color":"#ADADAD","text-decoration":"none"});
	});
	//轮播图鼠标悬浮离开事件
	$("#box").hover(function(){
		window.clearInterval(timer);
	},function(){
		timer=window.setInterval(step,4000);
	});
	//数字点击方法
	numli.click(function(){
	    lbindex=numli.index(this);
	    change()
	});
	//视频播放
	$("#dongcha img").click(function(){
		$(this).parent().append('<video src="video/dongcha.mp4" autoplay="autoplay" width="1278" height="441"></video>');
		$("#dongcha img").hide();
	});
	//地图
	$("[id*=dw] img").hover(function(){
		dwindex=$(this).parent().attr("id").substring(2,3);
		$("#dwimg"+dwindex).fadeIn();
	},function(){
		$("#dwimg"+dwindex).fadeOut();
	});
});