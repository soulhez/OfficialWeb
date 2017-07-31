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
			alert(e.status);
			},
			success:function(data){
				datas=data;
			}
		})
	return datas;
}
//关于导航的ajax
function Nvntitle(address){
	var datas=null;
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		data:{"method":null},
		error:function(e){
		alert(e.status);
		},
		success:function(data){
			alert(data);
			datas=data;
		}
	})
		return datas;
}
//关于类型
function ArticleTyp(address,method){
	var datas=null;
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
			datas=data;
		 }
	 });
	 return datas;
}
//关于素材参数说明:地址，提交方式，素材类型
function Materrial(address,method,mType){
	var datas=null;
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		async:false,
		dataType:"json",
		data:{"method":method,"mType":mType},
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
		$("#bt").append('<tr><td>'+bean[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+bean[i].aArticleTitle+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+bean[i].aArticleTypetbName+' disabled="disabled" />'+'</td>'+'<td style="display: none;">'+'<input type="text" class="form-control" value='+bean[i].aArticleTypetbID+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+bean[i].aNewDate+' disabled="disabled" />'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
	}
	/* $("li").click(function(){
		 alert($(this).val());
	 })*/
	 //查询所有导航信息
	 var dhbean=Nvntitle("NvntitleTBServlet");
	//for(var i in dhbean){
	//	 $("#dh").append('<tr><td>'+'<input type="text" class="form-control" value='+dhbean[i].nId+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+dhbean[i].nContent+' disabled="disabled" />'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
	//}
	//显示所有类型信息
	// var lxbean=ArticleTyp("IDServlet",null);
	// for(var i in lxbean){
		// $("#lx").append('<tr><td>'+'<input type="text" class="form-control" value='+lxbean[i].aId+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+lxbean[i].aName+' disabled="disabled" />'+'</td>'+'<td>'++'</td>'+'</tr>');
	//}
	//显示所有素材信息
    // var scbean=Materrial("MaterrialTBServlet","searchArticleTypeTB",null);
     //for(var i in scbean){
    	// $("#sc").append('<tr><td>'+'<input type="text" class="form-control" value='+scbean[i].mId+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+scbean[i].mName+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+scbean[i].mType+' disabled="disabled" />'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
     //}
});