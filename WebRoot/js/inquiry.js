//关于文章的ajax
function ArticleTB(address,method,start,end){
	var datas=null;
		$.ajax({
			url:address,
			type:"post",
			cache:false,
			async:false,
			dataType:"json",
			data:{"method":method,"start":start,"end":end},
			error:function(e){
				alert(sadfas);
			alert(e.status);
			},
			success:function(data){
				datas=data;
			}
		})
	return datas;
}
//关于导航的ajax
function Nvntitle(address,method,id){
	var datas=null;
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:[{"method":method,"id":id}],
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			datas=data;
		}
	})
		return datas;
}
//关于类型
function ArticleTyp(address,method,id){
	var datas=null;
	 $.ajax({
		 url:address,
		 type:"post",
		 cache:false,
		 async:false,
		 dataType:"json",
		 data:{"method":method,"id":id,},
		 error:function(e){
			 alert(e.status);
		 },
		 success:function(data){
			datas=data;
		 }
	 });
	 return datas;
}
//关于素材参数说明:地址，提交方式，素材类型
function Materrial(address,method,start,end,mType){
	alert(start);
	alert(end);
	var datas=null;
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
			datas=data;
		}
	})
	return datas;
}
$(function(){
	//查询所有文章信息
	 var bean=ArticleTB("IDServlet","searchArticleTB",0,8);
	 for(var i in bean){
		$("#bt").append('<tr id="hq"><td>'+bean[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+bean[i].aArticleTitle+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+bean[i].aArticleTypetbName+'/>'+'</td>'+'<td style="display: none;">'+'<input type="text" class="form-control" value='+bean[i].aArticleTypetbID+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+bean[i].aNewDate+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
	 	}
	$("li").click(function(){
	})
	//查询所有导航信息
	var dhbean=Nvntitle("NvntitleTBServlet",null);
	for(var i in dhbean){
		 $("#dhs").append('<tr><td>'+dhbean[i].nId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+dhbean[i].nContent+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
		}
	//显示所有类型信息
	 var lxbean=ArticleTyp("IDServlet","searchArticleTypeTB");
	 for(var i in lxbean){
		 $("#lxs").append('<tr><td>'+lxbean[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+lxbean[i].aNvntitleTBName+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+lxbean[i].aName+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
	 	}
	//显示所有素材信息
	 var scbean=Materrial("MaterrialTBServlet",null,"0","8");
     for(var i in scbean){
    	 $("#scs").append('<tr><td>'+'<input type="text" class="form-control" value='+scbean[i].mId+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+scbean[i].mType+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+scbean[i].mName+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
     }
     $("#bt,#dhs,#lxs,#scs").children("tr").children("td").children("input").attr("disabled","disabled");
     $("#test").attr("disabled","disabled");
    $("button[name=update]").toggle(function(){
        	 $(this).parent().siblings().children("input").removeAttr("disabled");
        	 $(this).text("保存");
        	 $("#test").removeAttr("disabled");
    },function(){
    		$(this).text("修改");
    });
});