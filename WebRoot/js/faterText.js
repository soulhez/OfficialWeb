	//加载编辑器  
	$(function() {  
	    $('div[name=summernote]').summernote({  
	        height: 230,                  
	        minHeight: 230,             
	        maxHeight: 230,        
	        focus: true,   
	        lang:'zh-CN',   
	        // 重写图片上传  
	    onImageUpload: function(files, editor, $editable) {  
	        sendFile(files[0],editor,$editable);  
	    }  
	  });  
	});  
	//图片上传  
	function sendFile(file, editor, $editable){  
	    var filename = false;  
	    try{  
	    filename = file['name'];  
	    } catch(e){  
	        filename = false;  
	    }  
	    if(!filename){  
	        $(".note-alarm").remove();  
	    }  
	    //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误  
	    data = new FormData();  
	    data.append("file", file);  
	    data.append("key",filename); //唯一性参数  
	 } 
