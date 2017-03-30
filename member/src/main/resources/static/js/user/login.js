
function valid(val){
		var reg=/^[a-z0-9_A-Z]{2,16}$/;
		var regMail=/^\S+@\S+\.\S+$/;
		var flag=false;
		flag=regMail.test(val);
		if(!flag){
			flag=reg.test(val);
		}
		return flag;
	}
$(function(){
	$(".enviar").click(function(){
		var name=$("input[name=username]").val();
		var password=$("input[name=password]").val();
		var f1=valid(name);
		var f2=valid(password);
		if(f1&&f2){
			$.post("user/login",{"username":name,"password":password},function(data){
				if(data.status==200){
					if(data.msg=='success'){
					   window.location="index.html"
					}
					if(data.msg=='failure'){
						$(".login").css("height","320px");
						$(".login form .error").html("<div class='info'>用户名或密码错误！</div>");
					}
				}else{
					$(".login").css("height","320px");
					$(".login form .error").html("<div class='info'>服务器异常！</div>");
				}
			},"json");
			//登录验证
		}else{
			//无操作
			alert("用户名不符合规范");
		}
	});
});