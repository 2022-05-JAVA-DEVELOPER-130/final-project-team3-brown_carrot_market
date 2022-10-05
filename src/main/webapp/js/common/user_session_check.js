$(document).ready(function(){
	
	session_check();
});

function session_check(){
	/* login_check ***********************/
	$.ajax({
		url:'user_session_check_json',
		method:'POST',
		dataType:'json',
		success:function(jsonResult){
		    if(jsonResult.code==1){ //세션에 로그인 유저 존재XX
		    	$(".account-area").html(UserHtmlContents.user_thumbnail());
		    }else if (jsonResult.code==2) {//세션에 로그인 유저 존재
		    	$(".account-area").html(UserHtmlContents.user_thumbnail_login(jsonResult.data[0]));
			}
		}
	});
	
}
addJavascript('/js/user/UserHtmlContents.js');