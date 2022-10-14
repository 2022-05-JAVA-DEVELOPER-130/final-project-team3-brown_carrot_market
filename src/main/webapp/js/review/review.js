$(document).ready(function(){

	/* review_write_form 보여주기****/
	$('.btn_review_write').on('click',function(e){
		console.log("orders_no: "+e.target.id);
		$("#container_contents").html(ReviewHtmlContents.review_write_form(e.target.id));
		$(".breadcrumb").prev('h5').text('후기작성');
		$(".breadcrumb li:last-child").removeClass('active');
		$(".breadcrumb li:last-child").html('<a href="orders_list">구매내역</a>');
		$(".breadcrumb").append('<li class="breadcrumb-item active">후기작성</li>');
		e.preventDefault();
	});
	
	/* review_view_form 보여주기****/
	$('.btn_review_view').on('click',function(e){
		console.log("review_no: "+$(e.target).attr('review'));
		$("#container_contents").html(ReviewHtmlContents.review_view($(e.target).attr('review')));
		/*
		$(".breadcrumb").prev('h5').text('후기작성');
		$(".breadcrumb li:last-child").removeClass('active');
		$(".breadcrumb li:last-child").html('<a href="orders_list">구매내역</a>');
		$(".breadcrumb").append('<li class="breadcrumb-item active">후기작성</li>');
		*/
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
				$('#'+orders_no).attr('review',jsonResult.data);
			}else {
				$('#'+orders_no).text('작성하기');
				$('#'+orders_no).addClass('badge-carrot');
				$('#'+orders_no).addClass('btn_review_write');
			}
		}
	});
}
