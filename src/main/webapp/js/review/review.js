$(document).ready(function(){

	/* review_write_form 보여주기****/
	$('.btn_review_write').on('click',function(e){
		console.log("orders_no: "+e.target.id);
		console.log("seller_id: "+$("#"+e.target.id).attr("seller_id"));
		$("#container_contents").html(ReviewHtmlContents.review_write_form(e.target.id,$("#"+e.target.id).attr("seller_id")));
		$(".breadcrumb").prev('h5').text('후기작성');
		$(".breadcrumb li:last-child").removeClass('active');
		$(".breadcrumb li:last-child").html('<a href="orders_list">구매내역</a>');
		$(".breadcrumb").append('<li class="breadcrumb-item active">후기작성</li>');
		e.preventDefault();
	});
	
	/* review_view_form 보여주기****/
	$('.btn_review_view').on('click',function(e){
		console.log("review_no: "+$(e.target).attr('review_no'));
		$.ajax({
			url : 'review_view_json',
			method : 'POST',
			data : {
				"review_no": $(e.target).attr('review_no')
			},
			success : function(jsonResult) {
				$("#container_contents").html(ReviewHtmlContents.review_view(jsonResult.data));
			}
		});
		
		$(".breadcrumb").prev('h5').text('후기작성');
		$(".breadcrumb li:last-child").removeClass('active');
		$(".breadcrumb li:last-child").html('<a href="orders_list">구매내역</a>');
		$(".breadcrumb").append('<li class="breadcrumb-item active">후기작성</li>');
		e.preventDefault();
	});
	
	/*
	$(".stars >*").on('click',function(e){
		if($("input[type=radio][name='star']").is(':checked')){
			//console.log('click');
			var answer = $(this).attr("id");
			var anText = $("label[for='"+answer+"']").text(); 
			console.log(anText);
			
		}
	});
	*/
	$(document).on('click', '#btnSubmit', function(e) {
    		console.log('click - #btnSubmit');
    		
    		var formData = new FormData();
    		
    		$.each(uploadFiles, function(i, file) {
    			if(file.upload != 'disable')  //삭제하지 않은 이미지만 업로드 항목으로 추가     
    			formData.append('files', file); 
    		});
    		
			var review = {
				"review_point":$('#review_point').val(),
				"review_desc":$('#review_desc').val(),
				"review_image":$('#review_image').val()
			}
			
    		if(formData.get("files")!=null){
	    		$.ajax({	// review_image 업로드
	    			url : 'review/upload',
	    			type : 'POST',
	    			processData : false, //파일전송시 반드시 false
	    			contentType : false,
	    			data : formData,
	    			success : function(jsonResult) {
		console.log(jsonResult.newFileNames);
	    				$.ajax({	// review INSERT
							url : 'review_write_action',
							method : 'POST',
							data: {
								"orders_no": orders_no,
								"review":JSON.stringify(review),
								"images": JSON.stringify(jsonResult.newFileNames),
								"your_id": your_id
								},
							success : function(jsonResult) {
								 console.log(jsonResult.msg);
								 location.href='orders_list';
						    },error:  function(jsonResult) {
			    				console.log('error!!: review_write_action');
							}
						});
	    			},
	    			error : function() {
	    				console.log('error!!');
	    			}
	    		});
    		}else{	//이미지가 업로드되지 않은 경우
				$.ajax({	// review INSERT
					url : 'review_write_action',
					method : 'POST',
					data: {
						"orders_no": orders_no,
						"review":JSON.stringify(review),
						"images": null,
						"your_id": your_id
						},
					success : function(jsonResult) {
						 console.log(jsonResult.msg);
						 location.href='orders_list';
				    },error:  function(jsonResult) {
	    				console.log('error!!: review_write_action');
					}
				});
			}
    		e.preventDefault();
    	});
    		  
    	$("#thumbnails").on("click", ".close", function(e) {
    		var $target = $(e.target); 
    		var idx = $target.attr('data-idx');
    		uploadFiles[idx].upload = 'disable';  //삭제된 항목은 업로드하지 않기 위해 플래그 생성
    		$target.parent().remove();  //프리뷰 삭제
    	});
    	/* (END)이미지 upload *********************************************/
	
    			
});//(END)ready

function setPoint(id){
	var val = $("label[for='"+id+"']").text();
	console.log("별점: "+val);
	$('#review_point').val(val);
}
//작성된 review존재여부 체크하여, 버튼생성
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
			//console.log("review_no: "+jsonResult.data.review_no);
			if(jsonResult.data!=null){
				$('#'+orders_no).text('보러가기');
				$('#'+orders_no).addClass('badge-secondary');
				$('#'+orders_no).addClass('btn_review_view');
				$('#'+orders_no).attr('review_no',jsonResult.data.review_no);
				//$('#'+orders_no).attr('review',JSON.stringfy(jsonResult.data));
			}else {
				$('#'+orders_no).text('작성하기');
				$('#'+orders_no).addClass('badge-carrot');
				$('#'+orders_no).addClass('btn_review_write');
			}
		}
	});
}
