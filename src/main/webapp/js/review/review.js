$(document).ready(function(){
	
	/* review_write_form 보여주기****/
	$('.badge-carrot').on('click',function(e){
		console.log(e.target.id);
		$("#container_contents").html(ReviewHtmlContents.review_write_form(e.target.id));
		$(".breadcrumb").prev('h5').text('후기작성');
		$(".breadcrumb li:last-child").removeClass('active');
		$(".breadcrumb li:last-child").html('<a href="orders_list">구매내역</a>');
		$(".breadcrumb").append('<li class="breadcrumb-item active">후기작성</li>');
		e.preventDefault();
	});
	
	$(".stars *").on('click',function(e){
		if($("input[type=radio][name='star']").is(':checked')){
			//console.log('click');
			var answer = $(this).attr("id");
			var anText = $("label[for='"+answer+"']").text(); 
			console.log(anText);
			
		}
	});
		
});

function setPoint(id){
	console.log(id);
	var val = $("label[for='"+id+"']").text();
	console.log(val);
	$('#review_point').val(val);
}

function check_isExisted_review(orders_no){
	$.ajax({
		url : 'isExisted_review_check_json',
		method : 'POST',
		dataType : 'json',
		data : {
			"orders_no": orders_no
		},
		success : function(jsonResult) {
			console.log("result: "+jsonResult.data);
			if(jsonResult.data==0){
				$('#'+orders_no).text('작성하기');
				$('#'+orders_no).addClass('badge-carrot');
				
			}else if (jsonResult.data==1) {
				$('#'+orders_no).text('보러가기');
				$('#'+orders_no).addClass('badge-secondary');
			}
		}
	});
}

 	function showImage() { 
		$('#image-show:last-child').css("visibility","visible");
		$('#image-upload').css("visibility","hidden");
		$('#fileName').text("");
		console.log('showImage() function 실행!!');
	}
	
	//이미지가 업로드 되면
	/*
	$(document).on('change','#chooseF',function(e){

		console.log($('input[type=file]')[0].files[0]);	//파일정보
		console.log($('input[type=file]')[0].files[0].name);	//파일이름

		loadFile($('input[type=file]')[0]);	//첫번째 파일 로드
		
		e.preventDefault();
	});
	*/
	//화면에 load하기 위해 img태그 만들어서 삽입
	function loadFile(input) {
		var file = input.files[0];
		
	    var name = input.files[0].name;

	    var newImage = document.createElement("img");
	    newImage.setAttribute("class", 'img');

	    newImage.src = URL.createObjectURL(file);   

	    newImage.style.width = "70%";
	    newImage.style.height = "70%";
	    //newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지 숨기기
	    newImage.style.objectFit = "contain";

	    var container = document.getElementById('image-show');
	    container.appendChild(newImage);
	}

