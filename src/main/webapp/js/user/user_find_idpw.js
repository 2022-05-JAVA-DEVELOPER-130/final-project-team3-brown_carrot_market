$(document).ready(function(){
	
	/* validator객체변수선언 */
	var validator = null;
	
	/*validator객체 디폴트속성 설정*/
	$.validator.setDefaults({
		rules : {
			user_id : {
				required : true
			},
			user_name : {
				required : true
			},
			user_email : {
				required : true,
				email : true
			}
		},
		messages : {
			user_id : {
				required : '아이디를 입력하세요'
			},
			user_name : {
				required : '이름을 입력하세요'
			},
			user_email : {
				required : '이메일을 입력하세요',
				email : '이메일형식이 잘못되었습니다.'
			},
		},
		errorClass : 'error',
		validClass : 'valid'
	});
	
	validator = $('#find_id_form').validate();
	
	//아이디 찾기 action
	$('#btn_find_id_action').on('click',function(e){
		console.log("click: "+e.target.id);
		
		if (validator.form()) {
			$("#btn_find_id_action").attr("data-target","#findIdModalCenter");
			$.ajax({
					url : 'user_find_id_action_json',
					method : 'POST',
					dataType : 'json',
					data : $('#find_id_form').serialize(),
					success : function(jsonResult) {
							console.log(jsonResult);
							if(jsonResult.code==2){
								$("#find_id_h6").text("고객님의 정보와 일치하는 아이디입니다");
								$("#find_id_modal_body").text(jsonResult.data);
								$(".find_pw").show();
							}else if(jsonResult.code==1){
								$("#find_id_h6").text("고객님의 정보와 일치하는 아이디가 없습니다.");
								$(".find_pw").hide();
							}
					}
				});
		}
		e.preventDefault();
	});
	
	//비밀번호 찾기 action
	$('#btn_find_pw_action').on('click',function(e){
		console.log("click: "+e.target.id);

		if (validator.form()) {
			
			$.ajax({
					url : 'user_find_pw_action_json',
					method : 'POST',
					dataType : 'json',
					data : $('#find_pw_form').serialize(),
					success : function(jsonResult) {
							console.log(jsonResult);
							if(jsonResult.code==2){
									//일치하는 회원이 존재하면 비밀번호변경&메일발송
									$("#btn_find_pw_action").attr("data-target","#findPwModalCenter");
									$.ajax({
											url : 'springMail/findPw',
											method : 'POST',
											dataType : 'json',
											data : $('#find_pw_form').serialize(),
											complete : function(jsonResult) {
													console.log(jsonResult.code);
													if(jsonResult.code==1){//성공
														$("#find_pw_h6").text("고객님의 이메일로 임시비밀번호를 발급해드렸습니다. 이메일을 확인해주세요.");
														//$("#find_pw_modal_body").text(jsonResult.data);
														$(".go_login").show();
													}else {
														alert('메일전송 error');
													}
											}
									});
							}else if(jsonResult.code==1){
								$("#find_id_h6").text("입력하신 정보와 일치하는 회원이 없습니다.\n 다시 확인부탁드립니다.");
								$(".go_login").hide();
							}
					}
				});
		}
		e.preventDefault();
	});
	
	
});

//[radio버튼 토글]아이디-비밀번호찾기
function find_form_check(num) {
			
	$("input[name=radio_taag]").attr("checked",false);
	
	if (num == '1') {	//아이디 찾기
		$('#find_id').show();
		$('#find_pw').hide();
		$('#radio_find_id').attr('checked',true);
	} else {	//비밀번호 찾기
		$('#find_id').hide();
		$('#find_pw').show();
		$('#radio_find_pw').attr('checked',true);
	}
}

