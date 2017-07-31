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
	/*加载导航*/
	var Nvntitle='<div class="container-fluid" id="Nvntitle">';
	Nvntitle+='<div class="navbar-header">';
	Nvntitle+='<a href="#"><img src="img/logo.png"/></a>';
	Nvntitle+='</div>';
	Nvntitle+='<div class="collapse navbar-collapse">';
	Nvntitle+='<ul class="nav navbar-nav" style="font-size: 20px; padding-top: 10px;">';
	$.ajax({
		url:"NvntitleTBServlet",
		type:"POST",
		dataType:"json",
		cache:false,
		success:function(data){
			var nvntitleIdList=new Array();
			var nvntitleNameList=new Array();
			for(var i=0;i<data.length;i++){
				Nvntitle+='<li class="navli'+i+'">';
				Nvntitle+='<input type="hidden" value="'+data[i]["nId"]+'"/>';
				Nvntitle+='<a href="#" name="navbar'+i+'">'+data[i]["nContent"]+'</a>';
				Nvntitle+='</li>';
			}
			Nvntitle+='</ul>';
			Nvntitle+='</div></div>';
			$("#Nvntitle").html(Nvntitle);
			/*加载导航隐藏内容*/
			loadarticleTypeAndarticle();
		}
	});
	/*加载轮播*/
	/*加载页脚*/
	/***************************方法*************************************/
	/*加载导航隐藏内容*/
	function loadarticleTypeAndarticle(){
		var articleTypeAndarticle='';
		/*******************为第一个时的风格*********************/
		articleTypeAndarticle+='<div name="hiddennav">';
		articleTypeAndarticle+='<hr/>';
		articleTypeAndarticle+='<div class="col-md-4">';
		articleTypeAndarticle+='<ul class="list-unstyled">';
		articleTypeAndarticle+='<li><span><img src="img/navleft1.jpg"/></span></li><br/>';
		articleTypeAndarticle+='<li><span>刘天文：打造智慧城市需要以人为本贯穿始终</span></li>';
		articleTypeAndarticle+='</ul>';
		articleTypeAndarticle+='</div>';
		$.ajax({
			url:"IDServlet",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"method":"searchArticleTB",
				"id":1,
				"start":"0",
				"end":"10"
			},
			cache:false,
			success:function(data){
				for(var i=0;i<data.length;i++){
					if(i%5==0){
						articleTypeAndarticle+='<div class="col-md-4">';
						articleTypeAndarticle+='<ul class="list-unstyled">';
					}
					articleTypeAndarticle+='<li>';
					var aArticleTitle=data[i]['aArticleTitle'];
					if(aArticleTitle.length>19){
						aArticleTitle=aArticleTitle.substring(0,19);
						aArticleTitle+="...";
					}
					articleTypeAndarticle+='<span>'+aArticleTitle+'</span>';
					articleTypeAndarticle+='<input type="hidden" value="'+data[i]['aId']+'"/>';
					articleTypeAndarticle+='</li>';
					articleTypeAndarticle+='<li><hr/></li>';
					if(i!=0&&i%4==0||i==data.length-1){
						articleTypeAndarticle+='</ul>';
						articleTypeAndarticle+='</div>';
					}
				}
			}
		});
		articleTypeAndarticle+='</div>';
		/***********************************为第二个风格***************************/
		articleTypeAndarticle+='<div name="hiddennav">';
		articleTypeAndarticle+='<hr/>';
		/*加载左半边*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"method":"searchArticleTypeTB",
				"id":2
			},
			cache:false,
			success:function(data){
				for(var i=0;i<data.length;i++){
					articleTypeAndarticle+='<div class="col-md-6">';
					articleTypeAndarticle+='<ul class="list-unstyled">';
					articleTypeAndarticle+='<li class="title">';
					articleTypeAndarticle+='<span>'+data[i]['aName']+'</span>';
					articleTypeAndarticle+='<input type="hidden" value="'+data[i]["aId"]+'"/>';
					articleTypeAndarticle+='</li>';
					articleTypeAndarticle+='<li><hr/></li>';
					articleTypeAndarticle+='<li>';
					$.ajax({
						url:"IDServlet",
						type:"POST",
						dataType:"json",
						async:false,
						data:{
							"method":"searchArticleTB",
							"id":data[i]['aId'],
							"start":"0",
							"end":"27"
						},
						cache:false,
						success:function(data){
							for(var j=0;j<data.length;j++){
								if(j%9==0){
									articleTypeAndarticle+=count==0?'<div class="col-md-4">':'<div class="col-md-6">';
									articleTypeAndarticle+='<ul class="list-unstyled">';
								}
								var aArticleTitle=data[i]['aArticleTitle'];
								if(aArticleTitle.length>9){
									aArticleTitle=aArticleTitle.substr(0,8);
									aArticleTitle+="...";
								}
								articleTypeAndarticle+='<li>';
								articleTypeAndarticle+='<span>'+aArticleTitle+'</span>';
								articleTypeAndarticle+='<input type="hidden" value="'+data[i]["aId"]+'"/>';;
								articleTypeAndarticle+='</li>';
								articleTypeAndarticle+='<li><hr/></li>';
								if(j!=0&&j%8==0||j==data.length+1){
									articleTypeAndarticle+='</ul>';
									articleTypeAndarticle+='</div>';
								}
							}
							articleTypeAndarticle+='</li>';
							articleTypeAndarticle+='</ul>';
							articleTypeAndarticle+='</div>';
						}
					});
				}
			}
		});
		/*加载右半边*/
		
		/************************************为第三个风格*************************/
		articleTypeAndarticle+='<div class="col-md-3">';
		articleTypeAndarticle+='<ul class="list-unstyled">';
		articleTypeAndarticle+='<li><span><img src="img/navleft2.jpg"/></span></li><br/>';
		articleTypeAndarticle+='<li><span>软通动力服务能源行业</span></li>';
		articleTypeAndarticle+='</ul>';
		articleTypeAndarticle+='</div>';
		$.ajax({
			url:"IDServlet",
			type:"POST",
			async:false,
			dataType:"json",
			data:{
				"method":"searchArticleTypeTB",
				"id":3
			},
			cache:false,
			success:function(data){
				for(var i=0;i<data.length;i++){
					articleTypeAndarticle+='<div class="col-md-2">';
					articleTypeAndarticle+='<ul class="list-unstyled">';
					articleTypeAndarticle+='<li class="title">';
					articleTypeAndarticle+='<span>'+data[i]['aName']+'</span>';
					articleTypeAndarticle+='<input type="hidden" value="'+data[i]["aId"]+'"/>';;
					articleTypeAndarticle+='</li>';
					articleTypeAndarticle+='<li><hr/></li>';
					$.ajax({
						url:"IDServlet",
						type:"POST",
						dataType:"json",
						data:{
							"method":"searchArticleTB",
							"id":data[i]["aId"],
							"start":"0",
							"end":"5"
						},
						cache:false,
						success:function(data){
							if(aArticleTitle.length>8){
								var aArticleTitle=data[i]['aArticleTitle'];
								if(aArticleTitle.length>7){
									aArticleTitle=aArticleTitle.substr(0,7);
									aArticleTitle+="...";
								}
								articleTypeAndarticle+='<li>';
								articleTypeAndarticle+='<span>'+aArticleTitle+'</span>';
								articleTypeAndarticle+='<input type="hidden" value="'+data[i]["aId"]+'"/>';
								articleTypeAndarticle+='</li>';
								articleTypeAndarticle+='<li><hr/></li>';
							}
						}
					});
					articleTypeAndarticle+='</ul>';
					articleTypeAndarticle+='</div>';
				}
			}
		});
		//alert(articleTypeAndarticle);
		$("#articleTypeAndarticle").html(articleTypeAndarticle);
	}
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
	$("[name='hiddennav'] a").live("mouseover",function(){
		$(this).css("text-decoration","none");
	});
	$("[name='hiddennav'] a").live("mouseout",function(){
		$(this).css("text-decoration","none");
	});
	$("[name='hiddennav'] span").live("click",function(){
		var id=$(this).next("input").val();
		$("#body").html("<div class='container'><img src='img/loading.gif' width='60%' height='600px' style='position: relative; left:200px;'></div>");
		setTimeout(function(){
			var div='<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">';
			div+="<img src='img/newsTop.jpg' width='100%'>";
			div+="<div class='container'><hr/><div>";
			div+="</div>";
			$.ajax({
				url:"IDServlet",
				type:"POST",
				async:false,
				dataType:"json",
				cache:false,
				data:{
					"method":"searchArticleTBByID",
					"id":id
				},
				beforeSend:function(){
					$("#body").html("<div class='container'><img src='img/loading.gif' width='60%' height='600px' style='position: relative; left:200px;'></div>");
				},
				success:function(data){
					div+="<div class='container'>";
					div+="<h1 class='text-center'>"+data['aArticleTitle']+"</h1><br/><br/>";
					div+=data['aContent'];
					div+="</div>";
					$("#body").html(div);
				}
			});
		},2000);
	});
	$("footer a").live("mouseover",function(){
		$(this).css({"color":"white","text-decoration":"none"});
	});
	$("footer a").live("mouseout",function(){
		$(this).css({"color":"#ADADAD","text-decoration":"none"});
	});
	//轮播图鼠标悬浮离开事件
	$("#box").live("mouseover",function(){
		window.clearInterval(timer);
	});
	$("#box").live("mouseout",function(){
		timer=window.setInterval(step,4000);
	});
	//数字点击方法
	numli.click(function(){
	    lbindex=numli.index(this);
	    change()
	});
	//视频播放
	$("#dongcha img").live("click",function(){
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