/************************************关于文章的AJAX*************************************************/
function ArticleTB(address,method,start,end,id,title){
		$.ajax({
			url:address,
			type:"post",
			cache:false,
			async:false,
			dataType:"json",
			data:{"method":method,"start":start,"end":end,"id":id,"title":title},
			error:function(e){
			alert(e.status);
			},
			success:function(data){
				 for(var i in data){
						$("#bt").append('<tr id="hq"><td>'+data[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aArticleTitle+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aArticleTypetbName+'>'+'</td>'+'<td style="display: none;">'+'<input type="text" class="form-control" value='+data[i].aArticleTypetbID+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aNewDate+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
				 }
			}
		})
}
/******************************************文章删除的AJAX*******************************************/
function ArticleTBDelete(address,method,id){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"html",
		data:{"method":method,"id":id},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			alert(data);
		}
	})
}
/******************************************文章修改的AJAX*******************************************/
function ArticleTBUpdate(address,method,aId,aArticleTitle,aContent,aNewDate,aArticleTypetbID){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"html",
		data:{"method":method,"aId":aId,"aArticleTitle":aArticleTitle,"aContent":aContent,"aNewDate":aNewDate,"aArticleTypetbID":aArticleTypetbID},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			alert(data);
		}
	})
}
/******************************************文章添加的AJAX*******************************************/
function ArticleTBAdd(address,method,aArticleTitle,aContent,aNewDate,aArticleTypetbID){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"html",
		data:{"method":method,"aArticleTitle":aArticleTitle,"aContent":aContent,"aNewDate":aNewDate,"aArticleTypetbID":aArticleTypetbID},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			alert(data);
		}
	})
}
/****************************************关于导航的AJAX*********************************************/
function Nvntitle(Type,address,method,content,id){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:Type,
		data:{"method":method,"id":id,"newContent":content},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			if(data==="修改成功"){
				alert(data);
			}else{
				for(var i in data){
					 $("#dhs").append('<tr><td>'+data[i].nId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].nContent+'>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="dhupdate">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;display: none;" name="dhsave">保存</button></td></tr>');
				}
				for(var j in data){
					$("#lxgroup select[name=updateLx]").append('<option value="'+data[j].nId+'">'+data[j].nContent+'</option>');
				}
				var size=$("#lxUpdates select[name=updateLx]").children().length;
				if(size==1){
					for(var m in data){
						$("#lxUpdates select[name=updateLx]").append('<option value="'+data[m].nId+'">'+data[m].nContent+'</option>');
					}
				}
			}
		}
	})
}
/*****************************************关于登录的查询*********************************************/
function checkLogin(address,method,admin){
		var datas=null;
		$.ajax({
			url:address,
			dataType:"html",
			async:false,
			cache:false,
			data:{"method":method,"admin":admin},
			error:function(e){
				alert(e);
			},
			success:function(data){
				datas=data;
			}
		});
		return datas;
}
/*****************************************关于类型的查询*********************************************/
function ArticleTyp(address,method,name,id){
	 $.ajax({
		 url:address,
		 type:"post",
		 cache:false,
		 async:false,
		 dataType:"json",
		 data:{"method":method,"id":id,"name":name},
		 error:function(e){
			 alert(e.status);
		 },
		 success:function(data){
			 for(var i in data){
				 $("#lxs").append('<tr><td>'+data[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aName+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aNvntitleTBName+'>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button></td></tr>');
			 }
			 for(var j in data){
				 $("#btgroup select[name=updateLx]").append('<option value="'+data[j].aId+'">'+data[j].aName+'</option>');
			 }
			 var size=$("#xggroup select[name=updateLx]").children().length;
			if(size==1){
				 for(var m in data){
					 $("#xggroup select[name=updateLx]").append('<option value="'+data[m].aId+'">'+data[m].aName+'</option>');
				 }
			}
			var sizes=$("#addgroup select[name=addLx]").children().length;
			if(sizes==1){
				 for(var m in data){
					 $("#addgroup select[name=addLx]").append('<option value="'+data[m].aId+'">'+data[m].aName+'</option>');
				 }
			}
		 }
	 });
}
/*************************************标题类型的分页管理**********************************************/
function titlePage(){
	$.ajax({
		 url:address,
		 type:"post",
		 cache:false,
		 async:false,
		 dataType:"json",
		 data:{"method":method,"id":id,"name":name},
		 error:function(e){
			 alert(e.status);
		 },
		 success:function(data){
			 var size=0;
			 for(var i in data){
				 size++;
			 }
			 var lengths=0;
			 if(size%8==0){
				 lengths=size/8;
			 }else if(size%8!=0){
				 lengths=(Math.floor(size/8))+1;
			 }
			 var lengths=$("#scgroup li").length;
				for(var j=0;j<lengths;j++){
					if($("#scgroup li").eq(j).children().text()==anniu){
							$("#scgroup li:gt("+j+")").addClass("disabled");
						}
					}
		 }
	 });
}
/*******************************关于素材参数说明:地址，提交方式，素材类型***********************************/
function Materrial(address,method,start,end,mType,name){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method,"mType":mType,"start":start,"end":end,"name":name},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			for(var i in data){
				$("#scs").append('<tr><td>'+data[i].mId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].mType+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].mName+'>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button></td></tr>');
			}
		}
	})
}
/***********************************文章修改按钮提交修改***********************************************/
function articleUpdate(){
	$("#xggroup button[type=button]").click(function(){
		var articleId=$("#xggroup input[name=updateId]").val();
		var articleTitle=$("#xggroup input[name=updateName]").val();
		var articleTypeId=$("#xggroup select[name=updateLx]").val();
		var articleData=$("#xggroup input[name=updateTime]").val();
		var articleContent=$("#xggroup div[name=summernote]").summernote('code');
			if(checkArticleUpdates()==true){
				if(confirm("确认修改吗?")){
					ArticleTBUpdate("ArticleTBServlet","update",articleId,articleTitle,articleContent,articleData,articleTypeId);
					$("#xggroup").hide();
					$("#bt").empty();
					ArticleTB("IDServlet","searchArticleTB","0","8");
					$("#btgroup").show();
					TiTleUpdateClick();
					demoDelete();
					disables();
				}
			}else{
				alert("请完善文章信息，并检查格式是否正确!");
			}
	});
	
}
/***********************************获取总素材页面长度************************************************/
function getMaterrialLength(address,method){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			var size=0;
			for(var i in data){
		    	 size++;
			}
			if(size%8==0){
				anniu=size/8;
			}else if(size%8!=0){
				anniu=Math.floor(size/8)+1;
			}
			var lengths=$("#scgroup li").length;
			for(var j=0;j<lengths;j++){
				if($("#scgroup li").eq(j).children().text()==anniu){
					$("#scgroup li:gt("+j+")").addClass("disabled");
				}
			}
		}
	})
}
/**********************************将表格禁用方法****************************************************/
function disables(){
	 $("#bt,#dhs,#lxs,#scs").children("tr").children("td").children("input").attr("disabled","disabled");
}
/**********************************读取文章内文本内容*************************************************/
function readText(address){
	var datas=null;
	$.ajax({
		url:address,
		async:false,
		cache:false,
		dataType:"text",
		error:function(e){
		if(e.status!=404){
			alert(e.status);
		}
		},
		success:function(data){
			datas=data;
		}
	});
	return datas;
}
/*************************************根据文章Id查询文章*********************************************/
function selectId(address,method,id){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method,"id":id},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			$("input[name=updateName]").val(data.aArticleTitle);
			$("input[name=updateTime]").val(data.aNewDate);
			$("input[name=updateId]").val(data.aId);
			var TypeName= data.aArticleTypetbName;
			var size=$("select[name=updateLx]").children().length;
			for(var i=0;i<size;i++){
				if(TypeName===$("#xggroup select[name=updateLx").children().eq(i).text()){
					$("#xggroup select[name=updateLx]").children().eq(i).attr("selected",true);
				}
			}
			var textbean=readText("news/"+data.aArticleTitle+".txt")
			$('#xggroup div[name=summernote]').summernote('code',textbean);
		}
	})
}
/**********************************文章页面删除点击事件***********************************************/
function demoDelete(){
	$("#btgroup button[name=delete]").click(function(){
		if(confirm("确认删除吗?")){
			var id=$(this).parent().siblings().html();
			ArticleTBDelete("ArticleTBServlet","delete",id);
			$("#bt").empty();
			ArticleTB("IDServlet","searchArticleTB","0","8");
			disables();
			demoDelete();
		}
	});
}
/**********************************导航修改点击事件的效果*********************************************/
function dhUpdadte(){
	$("#dhgroup button[name=dhupdate]").click(function(){
			$(this).hide();
			$(this).next().show();
			$(this).parent().siblings().children("input").removeAttr("disabled");
	});
	$("#dhgroup button[name=dhsave]").click(function(){
			//获取Id
			var dhId=$(this).parent().prev().prev().text();
			var dhName=$(this).parent().prev().children().val();
			if(confirm("确定修改吗?")){
				Nvntitle("html","NvntitleTBServlet","update",dhName,dhId);
				return;
			}
			$("#dhs").empty();
			Nvntitle("json","NvntitleTBServlet",null);
			$(this).hide();
			$(this).prev().show();
			disables();
			dhUpdadte();
	});
};
/***********************************修改标题类型后的AJAX*********************************************/
function updateType(address,method,aId,aName,aNvntitleTBid){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"html",
		data:{"method":method,"aId":aId,"aName":aName,"aNvntitleTBid":aNvntitleTBid},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			alert(data);
		}
	})
}
/**********************************标题页面模糊查询点击查询事件*****************************************/
function sbClick(){
	 $("#btgroup button[name=repeatedly]").click(function(){
	    	 /***标题的内容**/
		 	 titleText=$("#btText").val();
		 	 /***导航的Id**/
	    	 navigationType=$("#btgroup select[name=updateLx]").val();
	    	 $("#bt").empty();
	    	 ArticleTB("IDServlet","searchArticleTB",0,8,navigationType,titleText);
	    	 TiTleUpdateClick();
	    	 disables();
	    	 if(YouClickOnMe>0){
	    		 $("#btgroup #qk").empty();
	    		 $("#btgroup #qk").append('<li name="up"><a href="#"><span aria-hidden="true">&laquo;</span></a></li><li value="0"><a href="#">1</a></li><li value="1"><a href="#">2</a></li><li value="2"><a href="#">3</a></li><li value="3"><a href="#">4</a></li><li value="4"><a href="#">5</a></li><li name="down"><a href="#"><span aria-hidden="true">&raquo;</span></a></li>') 
	    	 }
	    	 demoDelete();
	    	 $("#btgroup li").removeClass("disabled");
	    	 getArticleTBLength("IDServlet","searchArticleTB",navigationType,titleText);
	     });
}
/*****************************************文章标题修改点击*******************************************/
function TiTleUpdateClick(){
	 $("#btgroup button[name=update]").click(function(){
	     	$("#btgroup").hide();
	     	var id=$(this).parent().siblings().html();
	     	selectId("IDServlet","searchArticleTBByID",id);
	     	$("#xggroup").show();
	      });
};
/******************************通过标题id获取标题信息进行修改AJAX***************************************/
function checklx(address,method,id){
	$.ajax({
		type:"post",
		url:address,
		dataType:"json",
		async:false,
		cache:false,
		data:{"method":method,"id":id},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			$("#lxUpdates input[name=updateName]").val(data.aName);
			$("#lxUpdates input[name=updateId]").val(data.aId);
			var size=$("#lxUpdates select[name=updateLx]").children().length;
			var TypeName=data.aNvntitleTBName;
			for(var i=0;i<size;i++){
				if(TypeName===$("#lxUpdates select[name=updateLx]").children().eq(i).text()){
					$("#lxUpdates select[name=updateLx").children().eq(i).attr("selected",true);
					return;
				}
			}
		}
	});
}
/**********************************导航页面模糊查询点击事件********************************************/
function dhClick(){
	$("#dhgroup button[name=repeatedly]").click(function(){
		var dhName=$("#dhText").val();
		$("#dhs").empty();
		Nvntitle("json","NvntitleTBServlet","selectNvntitle",dhName);
		disables();
		dhUpdadte();
	});
}
/************************************为素材添加去重下拉列表********************************************/
function addMaterial(address,method){
	$.ajax({
		type:"post",
		url:address,
		dataType:"json",
		async:false,
		cache:false,
		data:{"method":method},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			for(var i in data){
		    	 $("#scgroup select[name=updateLx]").append('<option value="'+data[i]+'">'+data[i]+'</option>');
		     }
		}
	});
}
/************************************类型页面的模糊查询点击事件*****************************************/
function lxClick(){
	$("#lxgroup button[name=repeatedly]").click(function(){
		var lxName=$("input[name=lxText]").val();
		var lxType=$("#lxgroup select[name=updateLx]").val();
		$("#lxs").empty();
		ArticleTyp("IDServlet","searchArticleTypeTB",lxName,lxType);
		disables();
		lxUpdate();
	});
}
/************************************素材页面的模糊查询点击事件*****************************************/
function scClick(){
	$("#scgroup button[name=repeatedly]").click(function(){
		var scName=$("input[name=scText]").val();
		var scType=$("#scgroup ")
		
	});
}
/**********************************类型页面的修改按钮点击事件*******************************************/
function lxUpdate(){
	$("#lxs  button[name=update]").click(function(){
	    var lxId=$(this).parent().prev().prev().prev().text();
	    checklx("IDServlet","searchArticleTypeTBByTypeid",lxId);
		$("#lxUpdates").show();
		$("#lxgroup").hide();
	});
}
/************************************类型修改表单提交事件*********************************************/
function lxUpdateLoad(){
	$("#lxUpdates button[type=button]").click(function(){
		var lxId=$("#lxUpdates input[name=updateId]").val();
		var lxName=$("#lxUpdates input[name=updateName]").val();
		var dhId=$("#lxUpdates select[name=updateLx]").val();
		if(confirm("确定修改吗？")){
			updateType("ArticleTypeTBServlet","update",lxId,lxName,dhId);
			$("#lxUpdates").hide();
			$("#lxs").empty();
			ArticleTyp("IDServlet","searchArticleTypeTB");
			$("#lxgroup").show();
			disables();
			lxUpdate();
		}
	});
}
/************************************素材模糊查询点击事件*********************************************/
function MaterialAll(){
	$("#scgroup button[name=repeatedly]").click(function(){
		var scName=$("#scgroup input[name=scText]").val();
		var scType=$("#scgroup select[name=updateLx]").val();
		$("#scs").empty();
		Materrial("MaterrialTBServlet",null,0,8,scType,scName);
		disables();
	});
}
/*******************************素材修改按钮点击跳转修改页面事件*****************************************/
function materialUpdate(){
	$("#scs button[name=update]").click(function(){
		var Id=$(this).parent().prev().prev().prev().text();
		
		$("#scgroup").hide();
		$("#materialUpdate").show();
		
	});
}
/*******************************登录页面按钮点击事件**************************************************/
function login(address){
	var admin=$("input[name=loginName]").val();
	var passWord=$("input[name=loginPassword]").val();
	$.ajax({
		url:address,
		type:"post",
		async:false,
		cache:false,
		dataType:"html",
		data:{"aEmail":admin,"aPwd":passWord},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			alert(data);
			if(data=="登录成功！"){
				location.replace("newsPages.html");
			}
		}
	});
}
/*******************************文章添加按钮点击事件**************************************************/
function articleAdd(){
	$("#btgroup button[name=repeatedlyAdd]").click(function(){
		$("#btgroup").hide();
		$("#addgroup").show();
	});
}
/*******************************文章添加按钮提交点击事件***********************************************/
function articleAddSubmit(){
	$("#addgroup button[type=button]").click(function(){
		var articleTitle=$("#addgroup input[name=addName]").val();
		var articleTypeId=$("#addgroup select[name=addLx]").val();
		var articleData=$("#addgroup input[name=addTime]").val();
		var articleContent=$("#addgroup div[name=summernote]").summernote('code');
		if(checkArticle()){
			if(confirm("确认添加吗?")){
					ArticleTBAdd("ArticleTBServlet",null,articleTitle,articleContent,articleData,articleTypeId);
					$("#addgroup").hide();
					$("#bt").empty();
					ArticleTB("IDServlet","searchArticleTB","0","8");
					$("#btgroup").show();
					demoDelete();
					TiTleUpdateClick();
					disables();
			}
		}else{
			alert("请完善信息！并检查格式！");
		}
	});
}
/*******************************文章添加按钮提交验证数据事件********************************************/
function checkArticle(){
	var articleTitle=$("#addgroup input[name=addName]").val();
	var articleTypeId=$("#addgroup select[name=addLx]").val();
	var articleData=$("#addgroup input[name=addTime]").val();
	var pttr=/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
	if(articleTitle==""){
		//alert($("button[name=xuanze]").text());
		//$("button[name=xuanze]").attr({"data-toggle":"popover","data-trigger":"focus","data-placement":"right","data-content":"用户名不能为空!"});
		//$("button[name=xuanze]").attr({"disabled":"disabled"});
		return false;
	}else if(articleTypeId==""){
		//$("button[name=xuanze]").attr({"data-toggle":"popover","data-trigger":"focus","data-placement":"left","data-content":"请至少选择标题类型!"});
		return false;
	}else if(articleData==""||!pttr.test(articleData)){
		//$("button[name=xuanze]").attr({"data-toggle":"popover","data-trigger":"focus","data-placement":"left","data-content":"日期不能为空请!并且请填写正确的日期格式YYYY-MM-DD"});
		return false;
	}
	return true;
}
/*******************************文章修改按钮提交验证数据事件********************************************/
function checkArticleUpdates(){
	var pttsr=/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
	if($("#xggroup input[name=updateName]").val()==""||$("#xggroup select[name=updateLx]").val()==""||$("#xggroup input[name=updateTime]").val()==""){
		return false;
	}else if(!pttsr.test($("#xggroup input[name=updateTime]").val())){
		return false;
	}
	return true;
}
/********************************************按钮下一页的点击事件*************************************/
function buttonDown(){
	YouClickOnMe=0;
	$("#btgroup li[name=down]").click(function(){
		var upLength=$(this).prev().val();
		var upText=$(this).prev().children().text();
		$(this).parent().children().empty();
		$("#btgroup ul").append('<li name="up"><a href="#"><span aria-hidden="true">&laquo;</span></a></li><li value="'+(parseInt(upLength)+parseInt(1))+'"><a href="#">'+(parseInt(upText)+parseInt(1))+'</a></li><li value="'+(parseInt(upLength)+parseInt(2))+'"><a href="#">'+(parseInt(upText)+parseInt(2))+'</a></li><li value="'+(parseInt(upLength)+parseInt(3))+'"><a href="#">'+(parseInt(upText)+parseInt(3))+'</a></li><li value="'+(parseInt(upLength)+parseInt(4))+'"><a href="#">'+(parseInt(upText)+parseInt(4))+'</a></li><li value="'+(parseInt(upLength)+parseInt(5))+'"><a href="#">'+(parseInt(upText)+parseInt(5))+'</a></li><li name="down"><a href="#"><span aria-hidden="true">&raquo;</span></a></li>');
		getArticleTBLength("IDServlet","searchArticleTB",navigationType,titleText);
		var start=$(this).next().next().val();
		$(this).next().next().addClass("active");
		$("#btgroup #bt").empty();
		ArticleTB("IDServlet","searchArticleTB",(start*8)+"","8",navigationType,titleText);
		disables();
		articlePageNumber();
		buttonUp();
		TiTleUpdateClick();
		demoDelete();
		YouClickOnMe=YouClickOnMe+1;
	});
}
/*******************************************按钮上一页点击事件***************************************/
function buttonUp(){
	$("#btgroup li[name=up]").click(function(){
		var downLengt=$(this).next().val();
		var downText=$(this).next().children().text();
		$(this).parent().children().empty();
		$("#btgroup ul").append('<li name="up" class="disabled"><a href="#"><span aria-hidden="true">&laquo;</span></a></li><li value="'+(parseInt(downLengt)-parseInt(5))+'"><a href="#">'+(parseInt(downText)-parseInt(5))+'</a></li><li value="'+(parseInt(downLengt)-parseInt(4))+'"><a href="#">'+(parseInt(downText)-parseInt(4))+'</a></li><li value="'+(parseInt(downLengt)-parseInt(3))+'"><a href="#">'+(parseInt(downText)-parseInt(3))+'</a></li><li value="'+(parseInt(downLengt)-parseInt(2))+'"><a href="#">'+(parseInt(downText)-parseInt(2))+'</a></li><li class="active" value="'+(parseInt(downLengt)-parseInt(1))+'"><a href="#">'+(parseInt(downText)-parseInt(1))+'</a></li><li name="down"><a href="#"><span aria-hidden="true">&raquo;</span></a></li>');
		getArticleTBLength("IDServlet","searchArticleTB",navigationType,titleText);
		var start=$(this).prev().prev().val();
		$("#btgroup #bt").empty();
		ArticleTB("IDServlet","searchArticleTB",(start*8)+"","8",navigationType,titleText);
		disables();
		articlePageNumber();
		buttonDown();
		TiTleUpdateClick();
		demoDelete();
	});
}
/**********************************************素材表格按钮页码点击事件********************************/
function materialPageNumber(){
	$("#scgroup ul li").click(function(){
		var start=$(this).val();
		var end=$(this).children().text();
		$("#scgroup #scs").empty();
		Materrial("MaterrialTBServlet",null,(start*8)+"","8");
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
		 disables();
		 lxUpdate();
	});
}
/**********************************************文章表格按钮页码点击事件********************************/
function articlePageNumber(){
	$("#btgroup ul li").click(function(){
		var start=$(this).val();
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
		$("#btgroup #bt").empty();
		ArticleTB("IDServlet","searchArticleTB",(start*8)+"","8",navigationType,titleText);
		disables();
		TiTleUpdateClick();
		demoDelete();
	});
}
/**********************************************获取所有文章的数量************************************/
function getArticleTBLength(address,method,id,title){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method,"id":id,"title":title},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			 var size=0;
			 for(var i in data){
					size++;
			 }
			if(size%8==0){
					anniu=size/8;
			}else if(size%8!=0){
					anniu=Math.floor(size/8)+1;
			}
			var lengths=$("#btgroup li").length;
			for(var j=0;j<lengths;j++){
				if($("#btgroup li").eq(j).children().text()==anniu){
						$("#btgroup li:gt("+j+")").hide();
					}
				}
		}
	})
}
/**********************************************账户的修改************************************/
function updateAdmin(){
	if(confirm("确定修改吗?")){
		var admin=$("#admingroup input[name=UpdateAdminName]").val();
		var adminPassword=$("#admingroup input[name=UpdatepawwWord]").val();
		$.ajax({
			url:address,
			type:"post",
			cache:false,
			async:false,
			dataType:"html",
			data:{"method":"AdminServlet","aUserName":admin,"aPwd":adminPassword},
			error:function(e){
			alert(e.status);
			},
			success:function(data){
				alert(data);
			}
		});
	}
}
/**********************************************获取管理员的信息************************************/
function checkAdminAll(){
	$.ajax({
		url:"IDServlet",
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":null},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			$("#showName").text(data.aUserName);
			$("#showAdminTwo").text(data.aUserName);
			$("#showAdminThree").text(data.aUserName);
		}
	});
}
/****************************************管理员账户修改的按钮点击**************************************/
function AdminsClick(){
	$("#admingroup button[type=button]").click(function(){
		if(adminCheckd()){
			updateAdmin();
		}else{
			alert("请检查用户信息不为空!或者用户格式正确！");
		}
	});
}
/*******************************管理员验证事件******************************************************/
function adminCheckd(){
	if($("#admingroup input[name=UpdateAdminName]").val()==""||$("#admingroup input[name=UpdatepawwWord]").val()==""||$("#admingroup input[name=UpdatepawwWordTwo]").val()==""){
		return false;
	}else if($("#admingroup input[name=UpdatepawwWord]").val()!=$("#admingroup input[name=UpdatepawwWordTwo]").val()){
		return false;
	}
	return true;
}
$(function(){
	titleText="";
	navigationType="";
	//查询所有文章信息
	ArticleTB("IDServlet","searchArticleTB","0","8");
	//查询所有导航信息
	Nvntitle("json","NvntitleTBServlet",null);
	//显示所有类型信息
	ArticleTyp("IDServlet","searchArticleTypeTB");
	//显示所有素材信息
	Materrial("MaterrialTBServlet",null,"0","8");
	//加载素材长度
	getMaterrialLength("MaterrialTBServlet",null);
	disables();
    //修改按钮点击事件
    //文章标题查询表单提交点击事件
    sbClick();
    getArticleTBLength("IDServlet","searchArticleTB");
    TiTleUpdateClick();
    dhClick();
    lxClick();
    lxUpdate();
    dhUpdadte();
    demoDelete();
    addMaterial("MaterrialTBServlet","type");
    MaterialAll();
    lxUpdateLoad();
    materialUpdate();
    articleUpdate();
    articleAdd();
    articleAddSubmit();
    materialPageNumber();
    articlePageNumber();
    buttonUp();
    buttonDown();
    $("#Logins").keydown(function(event){
    	if(event.keyCode==13){
    		login("LoginServlet");
    	}
    });
    $("#login").click(function(){
    	login("LoginServlet");
    });
	$('[data-toggle="popover"]').popover()
	$("#admingroup input[type=button]").click(function(){
		if(confirm("确认修改吗?")){
			updateAdmin();
		}
	});
	checkAdminAll();
	AdminsClick();
});