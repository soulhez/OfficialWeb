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
	/*阿根智能一键加载*/
	loadAll();
	/***************************方法*************************************/
	/*加载导航方法*/
	function loadAll(){
		var Nvntitle='<div class="navbar-header">';
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
					Nvntitle+='<li class="navli">';
					Nvntitle+='<input type="hidden" value="'+data[i]["nId"]+'"/>';
					Nvntitle+='<a href="#" name="navbar'+i+'">'+'&nbsp&nbsp'+data[i]["nContent"]+'&nbsp&nbsp'+'</a>';
					Nvntitle+='</li>';
				}
				Nvntitle+='<li class="navli" style="position:relative;top:8px;left:40px;">';
				Nvntitle+='<div class="input-group">';
				Nvntitle+='<input type="text" class="form-control" placeholder="搜索" id="search">';
				Nvntitle+='<span class="input-group-addon" id="searchImg">';
				Nvntitle+='<span class="glyphicon glyphicon-search">';
				Nvntitle+='</span>';
				Nvntitle+='</span>';
				Nvntitle+='</div>';
				Nvntitle+='</li>';
				Nvntitle+='</ul>';
				Nvntitle+='</div>';
				$("#Nvntitle").html(Nvntitle);
				/*加载导航隐藏内容*/
				loadarticleTypeAndarticle();
			}
		});
	}
	/*加载导航隐藏内容方法*/
	function loadarticleTypeAndarticle(){
		var articleTypeAndarticle='';
		/*******************为第一个时的风格*********************/
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
				articleTypeAndarticle+='<div name="hiddennav">';
				articleTypeAndarticle+='<hr/>';
				articleTypeAndarticle+='<div class="col-md-4">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li><span><img src="img/navleft1.jpg"/></span></li><br/>';
				articleTypeAndarticle+='<li><span>刘天文：打造智慧城市需要以人为本贯穿始终</span></li>';
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
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
				articleTypeAndarticle+='</div>';
			}
		});
		/***********************************为第二个风格***************************/
		/*获取类型*/
		var typeNameList2=new Array();
		var typeIdList2=new Array();
		$.ajax({
			url:"IDServlet",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"method":"searchArticleTypeTB",
				"id":"2"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div name="hiddennav">';
				articleTypeAndarticle+='<hr/>';
				for(var i=0;i<data.length;i++){
					typeIdList2[i]=data[i]['aId'];
					typeNameList2[i]=data[i]['aName'];
				}
			}
		});
		/*左边*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"method":"searchArticleTB",
				"id":typeIdList2[0],
				"start":"0",
				"end":"27"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div class="col-md-6">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li class="title">';
				articleTypeAndarticle+='<span>'+typeNameList2[0]+'</span>';
				articleTypeAndarticle+='<input type="hidden" value="'+typeIdList2[0]["aId"]+'"/>';
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='<li><hr/></li>';
				articleTypeAndarticle+='<li>';
				for(var j=0;j<data.length;j++){
					if(j%9==0){
						articleTypeAndarticle+='<div class="col-md-4">';
						articleTypeAndarticle+='<ul class="list-unstyled">';
					}
					var aArticleTitle=data[j]['aArticleTitle'];
					if(aArticleTitle.length>9){
						aArticleTitle=aArticleTitle.substr(0,8);
						aArticleTitle+="...";
					}
					articleTypeAndarticle+='<li>';
					articleTypeAndarticle+='<span>'+aArticleTitle+'</span>';
					articleTypeAndarticle+='<input type="hidden" value="'+data[j]["aId"]+'"/>';;
					articleTypeAndarticle+='</li>';
					articleTypeAndarticle+='<li><hr/></li>';
					if(j!=0&&j%8==0||j==data.length-1){
						articleTypeAndarticle+='</ul>';
						articleTypeAndarticle+='</div>';
					}
				}
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
			}
		});
		/*右边*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"method":"searchArticleTB",
				"id":typeIdList2[1],
				"start":"0",
				"end":"18"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div class="col-md-6">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li class="title">';
				articleTypeAndarticle+='<span>'+typeNameList2[1]+'</span>';
				articleTypeAndarticle+='<input type="hidden" value="'+typeIdList2[1]+'"/>';
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='<li><hr/></li>';
				articleTypeAndarticle+='<li>';
				for(var j=0;j<data.length;j++){
					if(j%9==0){
						articleTypeAndarticle+='<div class="col-md-4">';
						articleTypeAndarticle+='<ul class="list-unstyled">';
					}
					var aArticleTitle=data[j]['aArticleTitle'];
					if(aArticleTitle.length>9){
						aArticleTitle=aArticleTitle.substr(0,8);
						aArticleTitle+="...";
					}
					articleTypeAndarticle+='<li>';
					articleTypeAndarticle+='<span>'+aArticleTitle+'</span>';
					articleTypeAndarticle+='<input type="hidden" value="'+data[j]["aId"]+'"/>';;
					articleTypeAndarticle+='</li>';
					articleTypeAndarticle+='<li><hr/></li>';
					if(j!=0&&j%8==0||j==data.length-1){
						articleTypeAndarticle+='</ul>';
						articleTypeAndarticle+='</div>';
					}
				}
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
				articleTypeAndarticle+='</div>';
			}
		});
		/************************************为第三个风格*************************/
		var typeIdList3=new Array();
		var typeNameList3=new Array();
		/*获取类型*/
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
				articleTypeAndarticle+='<div name="hiddennav">';
				articleTypeAndarticle+='<hr/>';
				for(var i=0;i<data.length;i++){
					typeIdList3[i]=data[i]['aId'];
					typeNameList3[i]=data[i]['aName'];
				}
				articleTypeAndarticle+='<div class="col-md-3">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li><span><img src="img/navleft2.jpg"/></span></li><br/>';
				articleTypeAndarticle+='<li><span>软通动力服务能源行业</span></li>';
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
			}
		});
		/*第一个*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			async:false,
			dataType:"json",
			data:{
				"method":"searchArticleTB",
				"id":typeIdList3[0],
				"start":"0",
				"end":"5"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div class="col-md-2">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li class="title">';
				articleTypeAndarticle+='<span>'+typeNameList3[0]+'</span>';
				articleTypeAndarticle+='<input type="hidden" value="'+typeIdList3[0]+'"/>';;
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='<li><hr/></li>';
				for(var i=0;i<data.length;i++){
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
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
			}
		});
		/*第二个*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			async:false,
			dataType:"json",
			data:{
				"method":"searchArticleTB",
				"id":typeIdList3[1],
				"start":"0",
				"end":"5"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div class="col-md-2">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li class="title">';
				articleTypeAndarticle+='<span>'+typeNameList3[1]+'</span>';
				articleTypeAndarticle+='<input type="hidden" value="'+typeIdList3[1]+'"/>';;
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='<li><hr/></li>';
				for(var i=0;i<data.length;i++){
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
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
			}
		});
		/*第三个*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			async:false,
			dataType:"json",
			data:{
				"method":"searchArticleTB",
				"id":typeIdList3[2],
				"start":"0",
				"end":"5"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div class="col-md-2">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li class="title">';
				articleTypeAndarticle+='<span>'+typeNameList3[2]+'</span>';
				articleTypeAndarticle+='<input type="hidden" value="'+typeIdList3[2]+'"/>';;
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='<li><hr/></li>';
				for(var i=0;i<data.length;i++){
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
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
			}
		});
		/*第四个*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			async:false,
			dataType:"json",
			data:{
				"method":"searchArticleTB",
				"id":typeIdList3[3],
				"start":"0",
				"end":"5"
			},
			cache:false,
			success:function(data){
				articleTypeAndarticle+='<div class="col-md-2">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li class="title">';
				articleTypeAndarticle+='<span>'+typeNameList3[3]+'</span>';
				articleTypeAndarticle+='<input type="hidden" value="'+typeIdList3[3]+'"/>';;
				articleTypeAndarticle+='</li>';
				articleTypeAndarticle+='<li><hr/></li>';
				for(var i=0;i<data.length;i++){
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
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
				articleTypeAndarticle+='</div>';
			}
		});
		/*******************为第四个时的风格*********************/
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
				articleTypeAndarticle+='<div name="hiddennav">';
				articleTypeAndarticle+='<hr/>';
				articleTypeAndarticle+='<div class="col-md-4">';
				articleTypeAndarticle+='<ul class="list-unstyled">';
				articleTypeAndarticle+='<li><span><img src="img/navleft1.jpg"/></span></li><br/>';
				articleTypeAndarticle+='<li><span>刘天文：打造智慧城市需要以人为本贯穿始终</span></li>';
				articleTypeAndarticle+='</ul>';
				articleTypeAndarticle+='</div>';
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
				articleTypeAndarticle+='</div>';
				$("#articleTypeAndarticle").html(articleTypeAndarticle);
				/*加载轮播方法*/
				loadlb();
			}
		});
	}
	/*加载轮播方法*/
	function loadlb(){
		var imageList=new Array();
		var textList=new Array();
		var numsList=0;
		/*图片*/
		$.ajax({
			url:"IDServlet",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"mType":"轮播图"
			},
			cache:false,
			success:function(data){
				/*图片数量*/
				numsList=data.length;
				for(var i=0;i<data.length;i++){
					imageList[i]=data[i]['mName'];
				}
				/*文字*/
				$.ajax({
					url:"IDServlet",
					type:"POST",
					dataType:"json",
					async:false,
					data:{
						"mType":"轮播图文字"
					},
					cache:false,
					success:function(data){
						for(var i=0;i<data.length;i++){
							textList[i]=data[i]['mName'];
						}
						/*替换节点*/
						var box='<ul class="imglist">';
						for(var i=0;i<imageList.length;i++){
							box+='<li style="background-image: url(img/'+imageList[i]+');">';
							box+='<img src="img/'+imageList[i]+'"/ class="con">';
							box+='<img src="img/'+textList[i]+'"/ class="txt">';
							box+='</li>';
						}
						box+='</ul>';
						box+='<ul class="numlist">';
						for(var i=0;i<numsList;i++){
							box+='<li></li>';
						}
						box+='</ul>';
						$("#box").html(box);
					}
				});
			}
		});
		loadFoot();
	}
	/*加载页脚方法*/
	function loadFoot(){
		
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
	$("[name='hiddennav'] span").live("click",function(){
		$("[name='hiddennav']").hide();
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
		},1000);
	});
	//搜索
	$("#searchImg").live("click",function(){
		var title=$.trim($("#search").val());
		$("#body").html("<div class='container'><img src='img/loading.gif' width='60%' height='600px' style='position: relative; left:200px;'></div>");
		setTimeout(function(){
			var div='<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">';
			div+="<img src='img/newsTop.jpg' width='100%'>";
			div+="<div class='container'><hr/><div>";
			div+="</div>";
			$.ajax({
				url:"ArticleTBServlet",
				type:"POST",
				async:false,
				dataType:"json",
				cache:false,
				data:{
					"title":title
				},
				beforeSend:function(){
					$("#body").html("<div class='container'><img src='img/loading.gif' width='60%' height='600px' style='position: relative; left:200px;'></div>");
				},
				success:function(data){
					var pageCount=10;
					var pages=data.length%10==0?data.length/10:data.length/10+1;
					var newsId=new Array();
					var newsName=new Array();
					div+="<div class='container'>";
					for(var i=0;i<data.length;i++){
						newsId[i]=data[i]['aId'];
						newsName[i]=data[i]['aArticleTitle'];
					}
					
					div+='<nav aria-label="Page navigation">';
					div+='<ul class="pagination">';
					div+='<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
					for(var i=1;i<=pages;i++){
						div+=i<=10?'<li><a href="#">'+i+'</a></li>':'<li class="hidden"><a href="#">'+i+'</a></li>';
					}
					div+='<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
					div+='</ul>';
					div+='</nav>';
					
					div+="<span class='text-center'>"+data[i]['aArticleTitle']+"</span><br/><br/>";
					div+="<span><hr/></span>";
					
					
					div+="</div>";
					$("#body").html(div);
				}
			});
		},1000);
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