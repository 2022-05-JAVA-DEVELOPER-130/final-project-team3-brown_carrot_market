var num = null;
var loginId=null;
var loginName=null;
var yourId=null;
var mImage=null;

var c_room_no=null;
var contextPath=getContextPath();

var jsonData={
	code:null,
	url:null,
	msg:null,
	your_id:null, // 상대 아이디 
	data:null //chat_contents 
	
};


//경로 얻기 
function getContextPath(){
   var lastIndexCount = location.href.lastIndexOf('/');
   var ctx = location.href.substr(0,lastIndexCount).replace('http', 'ws');
   return ctx;
}

//채팅 페이지 열릴 때 

$(document).ready(function(){
	});
		
		
$(document).on('click','[id^=btnCall]',function(e){
		num = this.id;
		console.log(num);
$.ajax({
		
		
		
		url:"chat_detail_rest",
		method:"POST",
		data:{"c_room_no":num},
//		data:{"c_room_no":num},
//		data:{c_room_no:$("#btnCall").val()},
	
		
		success:function(jsonResult){
			var chatContentArray=jsonResult.data;
			console.log(chatContentArray[0]);
			//$('#content').html('채팅 불러오기 성공');
			$('#chat_history').html("");
			$('#chatHead').html("");
			var loginId=$('#loginId').val();
			console.log(loginId);
			for(const item of chatContentArray){
				
				if(item.user_id!=loginId){
					var siva = item.user_id;
					break;
			
				}else{
				
					var siva = "CCAARROOTT1";
			
				}
			};
			$('#chatHead').append(chat_head(siva));
			
			
			
			
			for(const item of chatContentArray){
				
				if(item.user_id!=loginId){
					console.log("내가 보낸 메세지");
			$('#chat_history').append(message_other(item));
				}else{
					console.log("상대가 보낸 메세지");
			$('#chat_history').append(message_you(item));
				}
			};
			
			$('.chat-history').scrollTop($('.chat-history').prop('scrollHeight'));
		}
		
	});
	});

function message_other(chat_content){
	return `<li class="clearfix">
									<div class="message-data">
										<span class="message-data-time">${chat_content.send_time}</span>
									</div>
									<div class="message my-message">${chat_content.c_content}</div>
								</li>`
}

function message_you(chat_content){
	return `<li class="clearfix">
									<div class="message-data text-right">
										<span class="message-data-time">${chat_content.send_time}</span> <img
											src="https://bootdey.com/img/Content/avatar/avatar7.png"
											alt="avatar">
									</div>
									<div class="message other-message float-right">${chat_content.c_content}</div>
								</li>`
}
function chat_head(id){
	return 	`<div class="row">
								<div class="col-lg-6">
									<a href="javascript:void(0);" data-toggle="modal"
										data-target="#view_info"> <img
										src="https://bootdey.com/img/Content/avatar/avatar2.png"
										alt="avatar">
									</a>
									<div class="chat-about">
										<h6 class="m-b-0">${id}</h6>
										
										<small>Last seen: 2 hours ago</small>
									</div>
								</div>
								<div class="col-lg-6 hidden-sm text-right">
									<a href="javascript:void(0);" class="btn btn-outline-secondary"><i
										class="fa fa-camera"></i></a> <a href="javascript:void(0);"
										class="btn btn-outline-primary"><i class="fa fa-image"></i></a>
									<a href="javascript:void(0);" class="btn btn-outline-info"><i
										class="fa fa-cogs"></i></a> <a href="javascript:void(0);"
										class="btn btn-outline-warning"><i class="fa fa-question"></i></a>
								</div>
							</div>`
	
	
}


//메세지 전송 

function message_send_function(){
	$('#btnChatSend').click(function(e){
		console.log("send 버튼 클릭");
		timestamp = new Date().getTime();
		e.preventDefault();
		//제이슨데이터 만들기 
		// 임시 데이터 test
		
		jsonData.mId=loginId;
		
		yourId="carrot3";
		c_room_no="3";
		/*****상대방 아이디 / 채팅방 데이터 받아와야 함  */
		jsonData.your_id=yourId;
		jsonData.msg="메세지 전송(socket.send)";
		jsonData.code="1";
		jsonData.data=[{
			c_content_no:"",
			c_content:$('#chat_content_msg').val(),
			send_time:"",
			c_read:"0",
			user_id:loginId,
			c_room_no:c_room_no
		}]
		

			
		
		console.log("json데이터만들기 끝")
		
		
		
		$('#chat_content_msg').val("");
	
		
			
		message_sendDB(jsonData);
		console.log("DB 전송")		
		
	
	
	});
}

function message_sendDB(jsonData){
				$.ajax({
				url:'chat_message_rest',
    			data: JSON.stringify(jsonData.data[0]), //전송 데이터
    			
    			type: "POST", //전송 타입
    			async: true, //비동기 여부
    			//timeout: 5000, //타임 아웃 설정
    				
    			contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
    			dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)    			
    			    			
    			// [응답 확인 부분 - json 데이터를 받습니다] -보낸 클라이언트가 자기한테 받는 거 (?)
    			success: function(response) {
    				console.log("성공");
    				console.log(" 내가 보낸 것 [requestPostBodyJson] : [response] : " + JSON.stringify(response));    				
    				console.log("");
    				jsonData.data[0].send_time=response.send_time;
    				console.log(JSON.stringify(jsonData));    	
    				
    				socket.send(JSON.stringify(jsonData));		
    					console.log("socket 전송")	;	
    			},
    			error:function(xhr){
						console.log("error");
				}
    			
    			});
			}





function connectWS(){
	
	var url="ws://localhost:80/spring_web_application_boot_template/replyEcho?"+loginId;
	var ws=new WebSocket(url);
	socket=ws;
	
	ws.onopen = function(evt) {
			console.log(loginId+'서버 연결 성공');
		
	    };
	ws.onerror=function(evt){
		console.log('에러');
	}
	
	ws.onmessage=function(result){
		//var onMsg=JSON.parse(evt);
		console.log(result.data);
		var onMsg=JSON.parse(result.data);
		console.log('메세지 얻기');
		console.log(onMsg.data[0]);
		
		if(onMsg.data[0].user_id!=loginId){
			//상대가 메세지 보낸 경우
            $('#chat_history').append(message_other(onMsg.data[0]));
		}else if(onMsg.data[0].user_id==loginId){
			//내가 보낸 경우
			console.log(loginId);
			$('#chat_history').append(message_you(onMsg.data[0]));
		}
	}
	
	ws.onclose=function(evt){
		console.log('소켓 닫기');
	}
}
		

