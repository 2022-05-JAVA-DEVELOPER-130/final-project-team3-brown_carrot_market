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
		toastShow(message ,msg.user_id);
		}
		
		
		
	}
	
	
	
	ws.onclose=function(evt){
		console.log('소켓 닫기');
		
	}
}

function toastShow(title, content){
    		console.log("");
    		console.log("[toastShow] : [start]"); 
    		console.log("");

    		// [토스트 옵션 지정 실시]
    		toastr.options.escapeHtml = true; // [escapeHtml 허용여부]
    		toastr.options.closeButton = true; // [closeButton을 생성여부]
    		toastr.options.progressBar = true; // [프로그래스바 표시 여부]
    		toastr.options.newestOnTop = true; // [창의 위치, true이면 가장 위 포지션, false면 가장 아래 포지션]
    		//toastr.options.rtl = true; // [글자를 오른쪽 정렬 여부]    		
    		//toastr.options.closeDuration = 300; // [메시지 창의 애니메이션 효과 시간]    		
    		//toastr.options.onShown = function() { console.log("show"); } // [추가될 때 이벤트]
    		//toastr.options.onHidden = function() { console.log("hide"); } // [사라질 때 이벤트]
    		//toastr.options.onclick = function() { console.log("click"); } // [클릭될 때 이벤트]
    		//toastr.options.onCloseClick = function() { console.log("close"); } // [닫기 버튼이 눌릴 때 이벤트]
    		toastr.options.preventDuplicates = false; // [메시지 중복 허용 여부, 두개 이상 메시지가 생성될 때 이 전꺼는 사라짐]
    		toastr.options.timeOut = 10; // [메시지가 표시되는 시간]
    		//toastr.options.extendedTimeOut = 60; // [메시지 위로 커서를 올렸을 때 표시되는 시간]
    		//toastr.remove(); // [fadeout 효과없이 바로 메시지 창을 제거]
    		toastr.clear(); // [fadeout 효과로 메시지창을 닫기]



    		// [토스트 위치 지정 실시]
    		//toastr.options.positionClass = "toast-bottom-full-width"; // [위치 및 크기 설정 : 바닥 >> 꽉차게 설정]
    		//toastr.options.positionClass = "toast-bottom-right"; // [위치 및 크기 설정 : 바닥 >> 오른쪽]
    		//toastr.options.positionClass = "toast-bottom-left"; // [위치 및 크기 설정 : 바닥 >> 왼쪽]
    		//toastr.options.positionClass = "toast-bottom-center"; // [위치 및 크기 설정 : 바닥 >> 중앙]

    		//toastr.options.positionClass = "toast-top-full-width"; // [위치 및 크기 설정 : 위쪽 >> 꽉차게 설정]
    		toastr.options.positionClass = "toast-top-right"; // [위치 및 크기 설정 : 위쪽 >> 오른쪽]
    		//toastr.options.positionClass = "toast-top-left"; // [위치 및 크기 설정 : 위쪽 >> 왼쪽]
    		//toastr.options.positionClass = "toast-top-center"; // [위치 및 크기 설정 : 위쪽 >> 중앙]



    		// [토스트 위치 지정 실시 : 커스텀]
    		toastr.options.positionClass = "toast-bottom-full-width"; // [위치 및 크기 설정 : css 커스텀 설정 : 위쪽 표시 >> top 5% 조정]
    		/*
    		[css 코드]
    		.toast-bottom-full-width {
    			top:5%;
    		}					
    		*/



    		// [토스트 위치 지정 실시 : 커스텀]
    		//toastr.options.positionClass = "toast-bottom-full-width"; // [위치 및 크기 설정 : css 커스텀 설정 : 아래 표시 >> top 93% 조정]
    		/*
    		[css 코드]
    		.toast-bottom-full-width {
    			top:88%;
    		}					
    		*/



    		// [토스트 위치 지정 실시 : 커스텀]
    		//toastr.options.positionClass = "toast-bottom-center"; // [위치 및 크기 설정 : css 커스텀 설정 : 중앙 표시 >> top 45% 조정]
    		/*
    		[css 코드]
    		.toast-bottom-center {
    			top:45%;
    		}					
    		*/



    		// [토스트 애니메이션 지정 실시]
    		/*toastr.options.showEasing = 'swing';
    		toastr.options.hideEasing = 'linear';
    		toastr.options.closeEasing = 'linear';
    		toastr.options.showMethod = 'slideDown'; // [fadeIn, slideDown]
    		toastr.options.hideMethod = 'slideUp'; // [fadeOut, slideUp]
    		toastr.options.closeMethod = 'slideUp'; // [fadeOut, slideUp]*/



    		// [토스트 활성 실시]
    		//toastr.info(title, content, {timeOut: 5000}); // [일반]
    		toastr.success(title, content, {timeOut: 5000}); // [성공]
    		//toastr.warning(title, content, {timeOut: 5000}); // [경고]
    		//toastr.error(title, content, {timeOut: 5000}); // [에러]



    		// [토스트 커스텀 스타일 지정 실시]
    		/*
    		[css 코드 : 투명도 설정]
    		.toast {
				opacity: 1 !important;
			}
    		*/


    		/*
    		[css 코드 : 커스텀 폰트 사이즈 변경]
    		.toast-title {			
				font-size: 100%;
			}

			.toast-message {			
				font-size: 100%;
			}    		
    		*/
    	};



