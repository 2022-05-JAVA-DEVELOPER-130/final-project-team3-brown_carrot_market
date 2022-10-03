var num = null;


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
		

