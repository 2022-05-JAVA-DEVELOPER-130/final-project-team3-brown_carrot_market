$(document).ready(function(){
	
	/* user_view *********************************/
	$(document).on('click', '#user_account_details, #a_account_details',function(e){
		console.log("click!! >> "+e.target);
		    $.ajax({
				url:'user_view_json',
				method:'POST',
				dataType:'json',
				success:function(jsonResult){
				    $('#my-account-content').html(UserHtmlContents.user_view_content(jsonResult.data[0]));
				}
			});
	    e.preventDefault();
	});
	
	/* Send_Mail ********************************/
			$(document).on('click', '#btn_invi', function(e) {
				console.log($("#invi_email").val());
				$.ajax({
					url : 'springMail',
					method : 'POST',
					data:{
						"invi_email":$("#invi_email").val()
					},
					beforeSend:function(e){
						//수정필요
						$('.form-group').append("<div class='progress'><div class='progress-bar progress-bar-striped progress-bar-animated' role='progressbar' aria-valuenow='75' aria-valuemin='0' aria-valuemax='100' style='width: 75%'></div></div>");
					},
					success : function(e) {
						console.log("success");
						$('.progress').remove();
						alert($("#invi_email").val()+" 님에게 초대장이 전송되었습니다.");
						$("#invi_email").val("");
					}
				});
	
				e.preventDefault();
			});
			/*******************************************/
	
});

