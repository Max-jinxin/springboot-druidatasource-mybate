var loginFlag=false;
$.post(SERVICE.getSession,function(data){
		if(data!=null&&data!=""){
			loginFlag=true;
			location=VIEW.index;
		}
			
	});
