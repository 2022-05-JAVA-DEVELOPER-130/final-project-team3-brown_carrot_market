var num = null;
var loginName=null;
var loginId=getLoginId();
var yourId=null;
var mImage=null;
var socket=null;



var c_room_no=null;
var contextPath=getContextPath();

var last_seen_time=null;

var c_app_lat=null;
var c_app_lng=null;

var promiseData=null;

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
function getLoginId(){
		$.ajax({
		url:"get_id",
		method:"POST",
		
		dataType:'JSON',
		success:function(jsonResult){
			loginId=jsonResult.mId
			mImage=jsonResult.userImg;
			console.log("로그인 아이디 얻기:"+loginId);
			console.log("프로필 이미지 얻기:"+mImage);
		},
		error:function(xhr){
			console.log("error");
		}
		
	});
	return loginId;
}

//채팅 페이지 열릴 때 

$(document).ready(function(){
		
		
	
		// 채팅방 접근 방식 확인
	 var  path=document.getElementById("path").value;
	 var newChatRoomNo=document.getElementById("newChatRoomNo").value;
	 var myId=document.getElementById("loginId").value;
	 console.log(newChatRoomNo)
	 console.log(path);
	 console.log(myId);
	

	
	 


	 
	console.log("document ready");
	
	console.log("document ready end : "+loginId);
	//connectWS();
	
	message_send_function();
	
	
	 // 채팅방 접근 방식 확인 -- 너무 야매....
	 var  path=document.getElementById("path").value;
	 var newChatRoomNo=document.getElementById("newChatRoomNo").value;
	 var myId=document.getElementById("loginId").value;
	 console.log(newChatRoomNo)
	 console.log(path);
	 console.log(myId);
	 if(path==2){
			$('#chatHead').hide();
			$('#plist').hide();
			$('#chat_history').hide();			
	 if(socket!=null){
	socket.close();
	}

	

		

		
		var chat_detail={
			"c_room_no":newChatRoomNo,
			"loginId":myId
		}
$.ajax({
		
		
		url:"chat_detail_rest",
		method:"POST",
		//data:{"c_room_no":num},
		data: JSON.stringify(chat_detail),
		async: true,
        contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
        dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)    			
    			    			
	
		
		success:function(jsonResult){
			connectWS();
			var chatContentArray=jsonResult.data;
			yourId=jsonResult.yourId;
			yourImg = jsonResult.yourImg;
			c_room_no=jsonResult.c_room_no;
			console.log("채팅방의 상대방 ID:"+yourId);
			console.log(chatContentArray);
			
			$('#chat_history').html("");
			$('#chatHead').html("");
			/***********숨기기**********/
			console.log("숨기기");

			console.log(loginId);

			$('#chatHead').append(chat_head(yourId,yourImg,c_room_no));
			
			
			
			
			for(const item of chatContentArray){
		
				

				if(item.user_id!=loginId){
					if(item.user_id=="admin"){
						
					$('#chat_history').append(message_admin(item));
				}
					else if(item.user_id=="adminP"){
						$('#chat_history').append( `<li class="clearfix">

                           <div class="message admin-message" margin:auto>${item.c_content}
                           <br>약속 장소 : <a href="javascript:void(popupMap(${promiseData.c_app_lat},${promiseData.c_app_lng}))" style="font-size:6px;",id="chat_spot_map">${promiseData.c_app_spot}</a></div>
                        </li>`);
						
					}else{
					console.log("상대가 보낸 메세지");
			$('#chat_history').append(message_other(item));
			}
				}else if(item.user_id==loginId){
					console.log("내가 보낸 메세지");
			$('#chat_history').append(message_you(item));
				}
			};
			$('#chat_history').show();
			$('#chatHead').show();
			
		}
		
	});
	
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------	
	
	
    
	});
	
	
	
	$(window).on("load",function(){
		//connectWS();
	})
	


	
	
		
//채팅방 내용 불러오기		
$(document).on('click','[id^=btnCall]',function(e){
	if(socket!=null){
	socket.close();
	}

	num = this.id.substr(7);
		c_room_no=num;
	
			$.ajax({
		url:'promise_check',
		method:"POST",
		data:'c_room_no='+c_room_no,
		dataType:'JSON',
		success:function(jsonResult){
			//console.log("약속장소:"+spot)
			promiseData= jsonResult.data;
			c_app_lat=promiseData.c_app_lat;
			c_app_lng=promiseData.c_app_lng;
			
			
			
		}
	});
	
		
	e.stopPropagation();
	e.preventDefault();
		
		var chat_detail={
			"c_room_no":num,
			"loginId":loginId
		}
$.ajax({
		
		
		url:"chat_detail_rest",
		method:"POST",
		//data:{"c_room_no":num},
		data: JSON.stringify(chat_detail),
		async: true,
        contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
        dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)    			
    			    			
	
		
		success:function(jsonResult){
			connectWS();
			var chatContentArray=jsonResult.data;
			yourId=jsonResult.yourId;
			yourImg = jsonResult.yourImg;
			c_room_no=jsonResult.c_room_no;
			console.log("채팅방의 상대방 ID:"+yourId);
			console.log(chatContentArray);
			//$('#content').html('채팅 불러오기 성공');
			/***********숨기기**********/
			console.log("숨기기");
			$('#plist').hide();
			// 채팅방 확장 
			$(function(){
				$("#chat").css({
				"margin-left": "0px",
 			   	"border-left": "none"
					
					
				});
				
			});
			
			$('#chat_history').html("");
			$('#chatHead').html("");
			//loginId=$('#loginId').val();
			console.log(loginId);
			/*
			for(const item of chatContentArray){
				
				if(item.user_id!=loginId){
					var youId = item.user_id;
					break;
			
				}else{
				
					var youId = "error";
			
				}
			};*/
			$('#chatHead').append(chat_head(yourId,yourImg,c_room_no));
			
			
			
			
			for(const item of chatContentArray){
		
				
			/*if(item.user_id=="admin"){
					$('#chat_history').append(message_admin(item));
				}
				*/
				if(item.user_id!=loginId){
					if(item.user_id=="admin"){
					$('#chat_history').append(message_admin(item));
				}
					else if(item.user_id=="adminP"){
						$('#chat_history').append( `<li class="clearfix">

                           <div class="message admin-message" margin:auto>${item.c_content}
                           <br>현재 약속 장소 : <a href="javascript:void(popupMap(${promiseData.c_app_lat},${promiseData.c_app_lng}))" style="font-size:6px;",id="chat_spot_map">${promiseData.c_app_spot}</a></div>
                        </li>`);
						
					}else{
					console.log("상대가 보낸 메세지");
			$('#chat_history').append(message_other(item));
			}
				}else if(item.user_id==loginId){
					console.log("내가 보낸 메세지");
			$('#chat_history').append(message_you(item));
				}
			};
			
			//$('.chat-history').scrollTop($('.chat-history').prop('scrollHeight'));
			$('#chat-history').scrollTop($('#chat-history')[0].scrollHeight);
			
		}
	});
	
	
	});
	
	
	//날짜 변환 
	function date_string(dateString){
		var dateConv = Date.parse(dateString);
	 var date = dayjs(Number(dateConv));
	  var nowDate1 = date.format("YYYY-MM-DD HH:mm:ss");
	  const nowDate=new Date(nowDate1);
	  
	  var year=nowDate.getFullYear();
	  var month=nowDate.getMonth();
	  var day=nowDate.getDate();
	  var hour=nowDate.getHours();
	  
	  var ampm="AM";
	  
	  if(hour>12){
		hour-=12;
		ampm="PM";
	}
	  var mm=nowDate.getMinutes();
	  var dayformat = "";
	  var dayString="";
	var today=new Date();
	
	if(year==today.getFullYear() && month==today.getMonth() && day==today.getDate()){
		dayString="오늘";
	}else if(year==today.getFullYear()){
		dayString=month+"월"+day+"일";
		
	}else{
		dayString=year+"년"+month+"월"+day+"일";
	}
	
	//$('#chat_history').append(`<h3>${dayString}</h3><br>`);
	
dayformat=hour+":"+mm+" "+ampm+","+" "+dayString;
	
	return dayformat;
		
	}

function message_other(chat_content){
	var chat_read="";
	if(chat_content.c_read==0){
		chat_read="전송됨";
	}else if(chat_content.c_read==1){
		chat_read="읽음";
	}
	
	var chat_c=chat_content.c_content;
	if(chat_c.startsWith("@@image!#")){
		chat_img=chat_c.substr(9);
		chat_c=`<div><img src='img/chat_data/${chat_img}'
											alt="" style="width:300px; height:200px;" id="chat_img_sizeUp"+${chat_img} imgSrc='img/chat_data/${chat_img}' ><input type="hidden" value=${chat_img}></div>` ;
	}
	

	return `<li class="clearfix" >
									<div class="message-data">
										<span class="message-data-time">${date_string(chat_content.send_time)}</span>
									</div>
									<div class="message my-message">${chat_c}</div>
									<div class="chat_read_check" id=${chat_content.c_content_no}>${chat_read}</div>
								</li>`
}




function message_you(chat_content){
	var chat_read="";
	if(chat_content.c_read==0){
		chat_read="전송됨";
	}else if(chat_content.c_read==1){
		chat_read="읽음";
	}
	
	var chat_c=chat_content.c_content;
	if(chat_c.startsWith("@@image!#")){
		chat_img=chat_c.substr(9);
		chat_c=`<div><img src='img/chat_data/${chat_img}'
											alt="" style="width:300px; height:200px;" id="chat_img_sizeUp"+${chat_img} imgSrc='img/chat_data/${chat_img}' ><input type="hidden" value=${chat_img}></div>` ;
	}
	return `<li class="clearfix" >
									<div class="message-data text-right">
										<span class="message-data-time">${date_string(chat_content.send_time)}</span>  <img src='img/user_profile/${mImage}'
											alt="">
									</div>
									<div class="message other-message float-right">${chat_c}</div>
									<div class="chat_read_check" id=${chat_content.c_content_no}>${chat_read}</div>
								</li>`
}
/***************** 공지 *************** */
function message_admin(chat_content){
	return `<li class="clearfix">

									<div class="message admin-message" margin:auto>${chat_content.c_content}</div>
								</li>`
}


//약속 잡기 html

function message_admin_promise_history(chat_content){
	$.ajax({
		url:'promise_check',
		method:"POST",
		data:'c_room_no='+c_room_no,
		dataType:'JSON',
		success:function(jsonResult){
			$('#chat_history').append( `<li class="clearfix">

									<div class="message admin-message" margin:auto>${chat_content.c_content}
									<br>현재 약속 장소 : <a href="javascript:void(popupMap(${jsonResult.data.c_app_lat},${jsonResult.data.c_app_lng}))" style="font-size:6px;",id="chat_spot_map",c_app_lat="${jsonResult.data.c_app_lat}",c_app_lng="${jsonResult.data.c_app_lng}">${jsonResult.data.c_app_spot}</a></div>
								</li>`);
			
			
		}
	});
	
}

function message_admin_promise(chat_content){
	
	return `<li class="clearfix">

									<div class="message admin-message" margin:auto>${chat_content.c_content}<br>현재 약속 장소 :
									<a href="javascript:void(popupMap(${chat_content.c_app_lat},${chat_content.c_app_lng}))" style="font-size:6px;" class="chat_spot_map" >${chat_content.c_appspot}</a></div>
								</li>`
}


function chat_head(id,img,room_no){
	return 	`<div class="row">
								<div class="col-lg-6">
									<a href="javascript:void(0);" data-toggle="modal"
										data-target="#view_info"> <img
										src="img/user_profile/${img}"
										alt="avatar">
									</a>
									<div class="chat-about">
										<h6 class="m-b-0">${id}</h6>
										
										<small>Last seen: 2 hours ago</small>
									</div>
								</div>
								<div class="col-lg-6 hidden-sm text-right">
									
									<a  href="javascript:void(0);" class="btn btn-outline-info" ><i
										class="fa fa-handshake-o" id="btnChatAppointment"></i></a> 
										
										
									<a href="javascript:void(0);" class="btn btn-outline-primary" id="btnChatImage">
									<i class="fa fa-image"></i></a>
									
									<a href="javascript:void(0);" class="btn btn-outline-dark"
									id="deleteRoom">
									<i class="fa fa-sign-out"></i></a> 
								
									<a href="javascript:void(0);" class="btn btn-outline-danger"
									id="outRoom">
									<i class="fa fa-close" ></i></a>
									
								</div>
							</div>`
	
	
}


//메세지 전송 

function message_send_function(){
		$('#chat_content_msg').focus();
		
		
	$('#btnChatSend').click(function(e){
		e.preventDefault();
		e.stopPropagation();
		if($('#chat_content_msg').val()==""){
			alert('내용을 입력하세요');
			$('#chat_content_msg').focus();
			return false;
		}
		console.log("send 버튼 클릭");
		timestamp = new Date().getTime();
		
	
		
		//제이슨데이터 만들기 
		// 임시 데이터 test
		
		jsonData.mId=loginId;
		
		
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
		
		
		
		
		
			
		message_sendDB(jsonData);
		console.log("DB 전송")		
		return false;
	
	
	});
	return false;
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
    				jsonData.data[0].c_content_no=response.c_content_no
    				console.log(JSON.stringify(jsonData));    	
    				
    				socket.send(JSON.stringify(jsonData));		
    					console.log("socket 전송")	;	
    					//console.log("성공적인 socket 전송 여부: "+sendResult);
    			$('#chat_content_msg').val("");
    			},
    			error:function(xhr){
						console.log("error");
				}
    			
    			});
    			
			}





function connectWS(){
	console.log("connectWS 실행 : "+loginId)
	var url="ws://localhost:80/brown_carrot_market/replyEcho?"+loginId+"&"+c_room_no;
	var ws=new WebSocket(url);
	socket=ws;
	
	ws.onopen = function() {
			console.log(loginId+'서버 연결 성공');
			jsonData.mId=loginId;
		
		
		/*****상대방 아이디 / 채팅방 데이터 받아와야 함  */
		jsonData.your_id=yourId;
		jsonData.msg="채팅방 입장(socket.send)";
		jsonData.code="2";
		jsonData.data=[{
			c_content_no:"",
			c_content:"",
			send_time:"",
			c_read:"0",
			user_id:loginId,
			c_room_no:c_room_no
		}]
			socket.send(JSON.stringify(jsonData));
			console.log()
		
	    };
	ws.onerror=function(evt){
		console.log('에러');
	}
	
	ws.onmessage=function(result){
		result.stopPropagation();
		//console.log(result.data);
		//var onMsg=JSON.parse(result.data);
		console.log('메세지 얻기');
		//console.log(onMsg.data[0]);
		var onmsg=JSON.parse(result.data);
		console.log(onmsg.code);
		
	
		//메세지 전송한 경우
		if(onmsg.code=="1"){
		if(onmsg.user_id!=loginId){
			//상대가 메세지 보낸 경우
			console.log("상대가 보낸 경우"+onmsg.user_id)
            $('#chat_history').append(message_other(onmsg));
		}else if(onmsg.user_id==loginId){
			console.log("내가 보낸 경우"+onmsg.user_id)
			//내가 보낸 경우
			$('#chat_history').append(message_you(onmsg));
		}
		/*****************메시지 보내는 순간 리스트 새로고침***********************/
			
			console.log("채팅방 새로고침");
			$('#chatRoomList').html("");
			var reload_id={
		
		"loginId":loginId
	}
			$.ajax({
		
		
		url:"chat_room_reload_rest",
		method:"POST",
		data: JSON.stringify(reload_id),
		async: true,
        contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
        dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)  
				
    			    			
	
		
		success:function(jsonResult){
			var chatList=jsonResult.data;
		
			console.log("불러오기");
			console.log(chatList);
			$('#chatRoomList').html("");
			for(const item of chatList){
				
			$('#chatRoomList').append(chatRoomListNew(item));
				
				
			}

		}
		
	});
	/****************************************************************************/
		
		
		
		
		
		
		
		
		} //입장한 경우
		else if(onmsg.code=="2"){
			console.log(">>>>>>>>입장한 경우");
			var chat_detail={
			"c_room_no":c_room_no,
			"loginId":loginId
		}
		
			$.ajax({
		
		
		url:"chat_detail_rest",
		method:"POST",
		data: JSON.stringify(chat_detail),
		async: true,
        contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
        dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)    			
    			    			
	
		
		success:function(jsonResult){
			var chatContentArray=jsonResult.data;
			yourId=jsonResult.yourId;
			yourImg = jsonResult.yourImg;
			console.log("채팅방의 상대방 ID:"+yourId);
			//$('#chat_history').html("");
			//$('#chatHead').html("");
			//$('#chatHead').append(chat_head(yourId,yourImg));
			
			
			
			for(const item of chatContentArray){
				var chat_read="";
				if(item.c_read==0){
		         chat_read="전송됨";
	            }else if(item.c_read==1){
		         chat_read="읽음";
	            }
	            console.log(item.c_content_no);
				$(`#${item.c_content_no}`).text(chat_read);
				
		
			};
		}
		});
		return false;
		
		
	}else if(onmsg.code=="3"){
		console.log("약속 잡기");
		$('#chat_history').append(message_admin_promise(onmsg));
	}
	}
	
	
	
	ws.onclose=function(evt){
		console.log('소켓 닫기');
		
	}
}



/*****************삭제....*************** */

$(document).on('click','#deleteRoom',function(e){
	console.log(c_room_no);

	var chat_room={
		"c_room_no":c_room_no,
		"loginId":loginId
	}
$.ajax({
		
		
		url:"chat_delete_rest",
		method:"POST",
		data: JSON.stringify(chat_room),
		async: true,
        contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
        dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)  
				
    			    			
	
		
		success:function(jsonResult){
			var chatList=jsonResult.data;
		//	var chatContentArray=jsonResult.data;
		//	yourId=jsonResult.yourId;
		//	yourImg = jsonResult.yourImg;
		//	c_room_no=jsonResult.c_room_no;
		//	console.log("채팅방의 상대방 ID:"+yourId);
		//	console.log(chatContentArray[0]);
		//	//$('#content').html('채팅 불러오기 성공');
		//	$('#chat_history').html("");
		//	$('#chatHead').html("");
			//loginId=$('#loginId').val();
			console.log("불러오기");
			console.log(chatList);
			$('#chatRoomList').html("");
			$('#chat_history').html("");
								// 채팅방 확장 
			$(function(){
				$("#chat").css({
				"margin-left": "280px",
 			   	"border-left": "1px solid #eaeaea"
					
					
				});
				
			});
			$('#chat_history').append(chatRoomOut());
			
			for(const item of chatList){
				
			$('#chatRoomList').append(chatRoomListNew(item));
			$('#plist').show();	
				
			}

		}
		
	});
	
	});
	/************************************ 채팅방 닫기 ******************************/
$(document).on('click','#outRoom',function(e){
			socket.close();
			$('#chat_history').html("");
							// 채팅방 확장 
			$(function(){
				$("#chat").css({
				"margin-left": "280px",
 			   	"border-left": "1px solid #eaeaea"
					
					
				});
				
			});
			$('#chat_history').append(chatRoomOut());
			$('#plist').show();
			

	
	});
	/********************************************************************** */
function chatRoomOut(){
	return `<li class="clearfix">
									<div class="message-data"><img
											src="img/chat-img/logo_carrot.png"
											alt>
										<span class="message-data-adminGongji">당근 좋아하는 토끼</span>
									</div>
									<div class="message my-message">채팅방을 클릭해주세요</div>
								</li>`
}
function chatRoomListNew(list){
	var list_content=list.c_content;
	if(list.c_content.startsWith("@@image!#")){
		list_content="사진 전송";
	}
	return `        <li class="clearfix">
                        <img src='img/user_profile/${list.you_image}' alt="avatar">
                       
                        <div class="about">
							<input name="chatRoomNo" type="hidden" value=${list.c_room_no}/>
					<!--	<button type="button" class="btn btn-default" id="btnCall${list.c_room_no}" value=${list.c_room_no}>${list.c_room_no}</button>-->
                            <div class="name" id="btnCall${list.c_room_no}" value=${list.c_room_no}>${list.you_id}</div> 
                            <div class="content"> <i class="fa fa-circle offline"></i>${list_content}</div>                                            
                        </div>
                 </li>`
}




/****************약속 잡기************************/

 $(document).on('click','#btnChatAppointment',function(e){
	$.ajax({
		url:'promise_check',
		method:"POST",
		data:'c_room_no='+c_room_no,
		dataType:'json',
		success:function(jsonResult){
			if(jsonResult.code=="2"){
				alert("약속을 잡으시겠습니까?");
				popupNew();
				
			}else if(jsonResult.code=="1"){
				alert("기존 약속이 있습니다. 수정하시겠습니까?");
				popupChange();
			}
			
		}
	})
	
	
	
}) //약속잡기 버튼 클릭 

$(document).on('click','#btnChatImage',function(e){
	popupImage();
})

$(document).on('click',"img[id^='chat_img_sizeUp']",function(e){
	var src=$(e.target).attr('imgSrc');
	console.log("이미지소스:"+src);
	popupImageSizeUp(src);
})


  function popupImageSizeUp(src){
	var url = "chat_image_sizeUp?src="+src;
            var name = "이미지 확대";
            var option = "width = 600, height = 600, top = 100, left = 200, location = no,  resizable=yes"
            window.open(url, name, option);
}

  function popupImage(){
	 var url = "chat_photo";
            var name = "이미지 전송";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no,  resizable=no"
            window.open(url, name, option);
}
  
  function popupNew(){
            var url = "chat_appointment";
            var name = "약속 잡기";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no,  resizable=no"
            window.open(url, name, option);
        }
        
  function popupChange(){
            var url = "chat_appointment_change";
            var name = "약속 수정";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no,  resizable=no"
            window.open(url, name, option);
        }
        
   function popupMap(c_app_lat,c_app_lng){
            var url = "chat_appointment_map?c_app_lat="+c_app_lat+"&c_app_lng="+c_app_lng;
            var name = "약속 장소 지도로 보기";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no,  resizable=no"
            window.open(url, name, option);
        }
       
		

