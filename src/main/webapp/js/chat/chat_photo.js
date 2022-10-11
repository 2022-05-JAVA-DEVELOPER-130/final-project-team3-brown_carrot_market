$(document).on('clcik','#btnchatImgSubmit',function(e){
	console.log("이미지 첨부 버튼 클릭");
	const formData =new FormData($('#chat_image_form')[0]);
	$.ajax({
		url:"chat_upload",
		type:"POST",
		processData:false,	//파일전송시 반드시 false
		contentType:false,
		data:formData,
		success:function(jsonResult){
			console.log("채팅 이미지 업로드 결과:"+jsonResult);
		}
	});
	
	//DB 저장 
	//소켓 전송 
	e.preventDefault();
	//self.close();
})

//이미지가 업로드 되면
			/*$(document).on('change','#chooseF',function(e){
				//console.log($('input[type=file]')[0].files[0]);	//파일정보
				loadFile($('input[type=file]')[0]);	//첫번째 파일 로드
				 $('.remove_profile').attr('type','hidden');
				e.preventDefault();
			});
			
			//화면에 load하기 위해 blob 만들어서 삽입
			function loadFile(input) {
				var file = input.files[0];
			    document.getElementById('user_profile').src=URL.createObjectURL(file);
			}*/