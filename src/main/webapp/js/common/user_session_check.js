/*function addJavascript(jsname) {

	var th = document.getElementsByTagName('head')[0];

	var s = document.createElement('script');

	s.setAttribute('type','text/javascript');

	s.setAttribute('src',jsname);

	th.appendChild(s);

}
addJavascript('/js/user/UserHtmlContents.js');
addJavascript('/js/chat/socket.js');*/


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
		    	$("#account-area").html(CommonHtmlContents.user_thumbnail());
		    	$("#chat-area a").attr("href", "user_login");
		    	$(".cart_quantity").remove();
		    	$("#brown_carrot_pay a").attr("href", "user_login");
		    	$("#transaction-dropdown a").attr("href", "user_login");
		    	
		    }else if (jsonResult.code==2) {//세션에 로그인 유저 존재
		    	$("#account-area").html(CommonHtmlContents.user_thumbnail_login(jsonResult.data[0]));
				connectServer(jsonResult.data[0].user_id);
			}
		}
	});
	
}

function connectServer(loginId){
	console.log("connectWS 실행 : "+loginId)
	var url="ws://localhost:80/brown_carrot_market/replyEcho?"+loginId;
	var ws=new WebSocket(url);
	socket=ws;
	
	ws.onopen = function() {
			console.log(loginId+'서버 연결 성공');
		
	    };
	    
	ws.onerror=function(evt){
		console.log('에러');
	}
	
	ws.onmessage=function(result){
		console.log('메세지 전송');
		//alert(result.data);
		
		var msg=JSON.parse(result.data);
		console.log(msg);
		var id=msg.toastId;
		var message=msg.c_content;
		
		if(message.startsWith("@@image!#")){
			message="사진 전송";
		}
		
		if(id==loginId){
	    //  new Toast('warning', 'toast-top-right', msg.user_id+":"+message);
	      toastr['warning'](msg.user_id+" : "+message);
		//toastShow(message ,msg.user_id);
		
		}
		
		
		
	}
	
	
	
	ws.onclose=function(evt){
		console.log('소켓 닫기');
		
	}
}





/*알림창 설정*/
$(function() {
function Toast(type, css, msg) {
        this.type = type;
        this.css = css;
        this.msg = msg;
    }
    
     toastr.options.extendedTimeOut = 0; //1000;
    toastr.options.timeOut = 1000;
    toastr.options.fadeOut = 250;
    toastr.options.fadeIn = 250;
    toastr.options.preventDuplicates = false;
    toastr.options.closeButton = true;
    toastr.options.positionClass = "toast-top-right";
    toastr.options.onclick = function() { 
	console.log("click");
	location.href="chat_room";
	
	 }

})

    




