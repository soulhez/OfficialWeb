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
function Nvntitle(address,method,coutent,newContent){
	var datas=null;
	$.ajax({
		url:address,
		dataType:"POST",
		cache:false,
		async:false,
		data:{"method":null,"content":coutent,"newContent":newContent},
		error:function(e){
			alert(e.status);
		},
		success:function(data){
			datas=data;
		}
	});
	return datas;
}
//关于类型
function ArticleTyp(address){
	var datas=null;
	 $.ajax({
		 url:address,
		 dataType:"POST",
		 cache:false,
		 async:false,
		 data:{},
		 error:function(e){
			 alert(e.status);
		 },
		 success:function(data){
			datas=data;
		 }
	 });
	 return datas;
}
//关于素材
function Materrial(address){
	var datas=null;
	$.ajax({
		url:address,
		dataType:"POST",
		cache:false,
		async:false,
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
	 $("li").click(function(){
		 alert($(this).val());
	 })
	 //查询所有导航信息
	 var dhbean=Nvntitle(NvntitleTBServlet,null);
	 for(var i in dhbean){
		 $("#dh").append('<tr><td>'+'<input type="text" class="form-control" value='+dhbean[i].nId+' disabled="disabled" />'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+dhbean[i].nContent+' disabled="disabled" />'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
	 }
	 //显示所有类型信息
	 var lxbean=
});