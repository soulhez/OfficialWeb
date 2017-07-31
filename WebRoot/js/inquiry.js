function select(address){
	var datas=null;
	$.ajax({
		url:address,
		type:"post",
		cache:false,
		dataType:"json",
		data:{"method":"searchArticleTB","id":"","start":0,"end":5},
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
	var bean=select("IDServlet");
	alert(bean);
	alert("1");
	alert("2");
});