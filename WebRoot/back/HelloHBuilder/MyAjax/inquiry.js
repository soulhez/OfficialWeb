function select(address){
	var datas=null;
	$.ajax({
		url:address,
		type:"post",
		dataType:"json",
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
	var bean=select("");
});