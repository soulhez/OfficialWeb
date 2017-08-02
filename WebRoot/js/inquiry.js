//关于文章的ajax
function ArticleTB(address,method,start,end){
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
				 for(var i in data){
						$("#bt").append('<tr id="hq"><td>'+data[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aArticleTitle+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aArticleTypetbName+'/>'+'</td>'+'<td style="display: none;">'+'<input type="text" class="form-control" value='+data[i].aArticleTypetbID+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aNewDate+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
				 }
			}
		})
}
//关于导航的ajax
function Nvntitle(address,method,id){
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
			for(var i in data){
				 $("#dhs").append('<tr><td>'+data[i].nId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].nContent+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;">删除</button></td></tr>');
			}
		}
	})
}
//关于类型
function ArticleTyp(address,method,id){
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
			 for(var i in data){
				 $("#lxs").append('<tr><td>'+data[i].aId+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aName+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].aNvntitleTBName+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
			 }
			 for(var j in data){
				 $("#updatelLx").append('<option value="'+data[j].aId+'">'+data[j].aName+'</option>');
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
		    	 $("#scs").append('<tr><td>'+'<input type="text" class="form-control" value='+data[i].mId+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].mType+'/>'+'</td>'+'<td>'+'<input type="text" class="form-control" value='+data[i].mName+'/>'+'</td>'+'<td align="center"><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="add">添加</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="update">修改</button><button type="button" class="btn btn-default" style="width: 45px;height: 30px;padding-left: 7px;" name="delete">删除</button></td></tr>');
		     }
		}
	})
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
			if(){
				
			}
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
    $("#bt,#dhs,#lxs,#scs").children("tr").children("td").children("input").attr("disabled","disabled");
    //$("#test").attr("disabled","disabled");
	//("button[name=update]").mouseover(function(){
	//		danji();
	//});
   
     $("button[name=update]").click(function(){
    	$("#btgroup").hide();
    	var id=$(this).parent().siblings().html();
    	 selectId("IDServlet","searchArticleTBByID",id);
    	$("#xggroup").show();
     });
});