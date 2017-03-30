$(function(){
	
	/**
	 * 退出按钮事件
	 */
	$("#logout").click(function(){
		$.ajax({
			   type: "POST",
			   url: SERVICE.logout,
			   dataType:"json",
			   success: function(data){
			     if(data.status=="200"){
			     	location=VIEW.login;
			     }
			   }
			});
	});
	
	/**
	 * 点击事件，页面切换事件
	 */
	$(".topage").click(function(){
		var name=$(this).attr("name");
		$(".mainCont").load(VIEW[name]);
	});
	
	
});