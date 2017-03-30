var loginFlag=false;
$.post(SERVICE.getSession,function(data){
		if(data!=null&&data!=""){
			loginFlag=true;
			email=data.email;
			emailObj=$("#email");
			if(email!=null){
				emailObj.html(email);
			}
		}else{
			loginFlag=false;
			location=VIEW.login;
		}
	});
