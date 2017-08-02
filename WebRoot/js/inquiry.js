//关于文章的ajax
function ArticleTB(address,method,start,end,id,title){
		$.ajax({
			url:address,
			type:"post",
			cache:false,
			async:false,
			dataType:"json",
			data:{"method":method,"start":start,"end":end,"id":id,"title":title},
			error:function(e){
				alert(sadfas);
			alert(e.status);
			},
			success:function(data){
				 for(var i in data){
						$("#bt").append('<tr id="hq"><td>'+data[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aArticleTitle+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aArticleTypetbName+'>'+'</td>'+'<td style="display: none;">'+'<input type="text" class="form-control" value='+data[i].aArticleTypetbID+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aNewDate+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
				 }
			}
		})
}
//关于导航的ajax
function Nvntitle(address,method,content,id){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method,"id":id,"content":content},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			for(var i in data){
				 $("#dhs").append('<tr><td>'+data[i].nId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].nContent+'>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
			}
			for(var j in data){
				$("#lxgroup select[name=updateLx]").append('<option value="'+data[j].nId+'">'+data[j].nContent+'</option>');
			}
		}
	})
}
//关于类型
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
				 $("#lxs").append('<tr><td>'+data[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aName+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aNvntitleTBName+'>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
			 }
			 for(var j in data){
				 $("#btgroup select[name=updateLx").append('<option value="'+data[j].aId+'">'+data[j].aName+'</option>');
			 }
		 }
	 });
}
//关于素材参数说明:地址，提交方式，素材类型
function Materrial(address,method,start,end,mType){
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method,"mType":mType,"start":start,"end":end},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			for(var i in data){
		    	 $("#scs").append('<tr><td>'+'<input type="text" class="form-control" value='+data[i].mId+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].mType+'>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].mName+'>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
		     }
		}
	})
}
//将表格禁用方法
function disables(){
	 $("#bt,#dhs,#lxs,#scs").children("tr").children("td").children("input").attr("disabled","disabled");
}
//读取文本内容
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
//根据文章Id查询文章
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
			var TypeName= data.aArticleTypetbName
			var size=$("select[name=updateLx]").children().length;
			for(var i=0;i<size;i++){
				if(TypeName===$("#xggroup select[name=updateLx").children().eq(i).text()){
					$("#xggroup select[name=updateLx").children().eq(i).attr("selected",true);
				}
			}
			var textbean=readText("news/"+data.aArticleTitle+".txt")
			$("textarea[name=updateText]").val(textbean);
		}
	})
}
/*function danji(){
	$("button[name=update]").toggle(function(){
		 $(this).parent().siblings().children("input").removeAttr("disabled");
    	 $(this).text("保存");
    	 $("#test").removeAttr("disabled");
	},function(){
		$(this).text("修改");
	});
};*/
function sbClick(){
	 $("#btgroup button[name=repeatedly]").click(function(){
	    	var btText=$("#btText").val();
	    	var btType=$("#btgroup select[name=updateLx]").val();
	    	$("#bt").empty();
	    	 ArticleTB("IDServlet","searchArticleTB",0,8,btType,btText);
	    	 disables();
	     });
}
function cgClick(){
	 $("#btgroup button[name=update]").click(function(){
	     	$("#btgroup").hide();
	     	var id=$(this).parent().siblings().html();
	     	selectId("IDServlet","searchArticleTBByID",id);
	     	$("#xggroup").show();
	      });
};
//导航标题模糊查询
function dhClick(){
	$("#dhgroup button[name=repeatedly]").click(function(){
		var dhName=$("#dhText").val();
		$("#dhs").empty();
		Nvntitle("NvntitleTBServlet","selectNvntitle",dhName);
		disables();
	});
}
//修改方法
function xg(){
	
}
//类型模糊查询方法
function lxClick(){
	$("#lxgroup button[name=repeatedly]").click(function(){
		var lxName=$("input[name=lxText]").val();
		var lxType=$("#lxgroup select[name=updateLx]").val();
		$("#lxs").empty();
		ArticleTyp("IDServlet","searchArticleTypeTB",lxName,lxType);
		disables();
	});
}
//素材模糊查询方法
function scClick(){
	$("#scgroup button[name=repeatedly]").click(function(){
		var scName=$("input[name=scText]").val();
		var scType=$("#scgroup ")
	});
}
$(function(){
	 //查询所有文章信息
	 ArticleTB("IDServlet","searchArticleTB","0","8");
	 $("li").click(function(){
	 })
	//查询所有导航信息
	Nvntitle("NvntitleTBServlet",null);
	//显示所有类型信息
	ArticleTyp("IDServlet","searchArticleTypeTB");
	//显示所有素材信息
	Materrial("MaterrialTBServlet",null,"0","8");
	disables();
    //$("#test").attr("disabled","disabled");
	//("button[name=update]").mouseover(function(){
	//		danji();
	//});
    //修改按钮点击事件
     //文章标题查询表单提交点击事件
    sbClick();
    cgClick();
    dhClick();
    lxClick();
     /*$("button[name=update]").live("click",function(){
    	 alert(1);
    	$("#btgroup").hide();
      	var id=$(this).parent().siblings().html();
      	selectId("IDServlet","searchArticleTBByID",id);
      	$("#xggroup").show();
     });*/
     /*$("button[name=update]").live("click",function(){
    	 alert(1);
    	$("#btgroup").hide();
      	var id=$(this).parent().siblings().html();
      	selectId("IDServlet","searchArticleTBByID",id);
      	$("#xggroup").show();
     })*/
     /*$("button[name=update]").click(function(){
    	 alert(1);
     });*/
     //修改表单submit点击事件
     $("#xgform").submit(function(){
     });
     //导航表单submit提交事件
     $("#dhgroup").children().children().submit(function(){
     });
     //类型表单submit提交事件
     $("#lxgroup").children().children().submit(function(){
     });
     //素材表单submit提交事件
     $("#scgroup").children().children().submit(function(){
     });
});