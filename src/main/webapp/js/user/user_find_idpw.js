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
			$("#btn_find_id_action").attr("data-target","#exampleModalCenter");
			$.ajax({
					url : 'user_find_id_action_json',
					method : 'POST',
					dataType : 'json',
					data : $('#find_id_form').serialize(),
					success : function(jsonResult) {
							console.log(jsonResult);
							if(jsonResult.code==2){
								$("#find_h6").text("고객님의 정보와 일치하는 아이디입니다");
								$("#find_modal_body").text(jsonResult.data);
								$(".find_pw").show();
							}else if(jsonResult.code==1){
								$("#find_h6").text("고객님의 정보와 일치하는 아이디가 없습니다.");
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

	//user_find_pw_action_json
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

