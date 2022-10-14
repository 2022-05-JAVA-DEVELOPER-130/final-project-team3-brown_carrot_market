function ReviewHtmlContents(){
}

ReviewHtmlContents.review_write_form=function(orders_no) {
	
	$(function() {
    	var $drop = $("#drop");
		 $drop.on('click',function(e){
			console.log(this);
			e.preventDefault(); 
		});
		
		/* 이미지 upload *********************************************/
    	var uploadFiles = [];

    	$drop.on("dragenter", function(e) { //드래그 요소가 들어왔을떄 
    		console.log('dragenter 실행!');
    		$(this).addClass('drag-over');
    		//$(e.target).addClass('drag-over');
    	}).on("dragleave", function(e) {  //드래그 요소가 나갔을때  
    		console.log('drag-over 실행!');
    		$(this).removeClass('drag-over');
    		//$(e.target).removeClass('drag-over');
    	}).on("dragover", function(e) { 
    		e.stopPropagation(); 
    		e.preventDefault();
    	}).on('drop', function(e) {  //드래그한 항목을 떨어뜨렸을때
    		console.log('drop 실행!');
    		e.preventDefault(); 
    		$(this).removeClass('drag-over'); 
    		//$(e.target).removeClass('drag-over'); 
    		var files = e.originalEvent.dataTransfer.files;  //드래그&드랍 항목 
    		for(var i = 0; i < files.length; i++) {
    			var file = files[i];   
    			var size = uploadFiles.push(file);  //업로드 목록에 추가 
    			preview(file, size - 1);  //미리보기 만들기 
    			} 
    		});
    	function preview(file, idx) { 
			var reader = new FileReader();
			reader.onload = (function(f, idx) { 
				return	function(e) { 
					var div = "<div class='thumb'><div class='close' data-idx=" + idx + ">X</div><img src=" + e.target.result + " title=" + escape(f.name) + "/></div>";  
					$("#thumbnails").append(div);  
					}; 
				})(file, idx); 
			reader.readAsDataURL(file);
		}
    		
    	$(document).on('click', '#btnSubmit', function(e) {
    		console.log('click - #btnSubmit');
    		
    		var formData = new FormData();
    		
    		$.each(uploadFiles, function(i, file) {
    			if(file.upload != 'disable')  //삭제하지 않은 이미지만 업로드 항목으로 추가     
    			formData.append('files', file); 
    		});
    		
    		$.ajax({
    			url : 'review/upload',
    			type : 'POST',
    			processData : false, //파일전송시 반드시 false
    			contentType : false,
    			data : formData,
    			success : function(jsonResult) {
					console.log(jsonResult.newFileNames);
    				console.log('성공!!');
    				
    				var review = {
						"review_point":$('#review_point').val(),
						"review_desc":$('#review_desc').val(),
						"review_image":$('#review_image').val()
					}
    				$.ajax({
						url : 'review_write_action',
						method : 'POST',
						data: {
							"orders_no": orders_no,
							"review":JSON.stringify(review),
							"images": JSON.stringify(jsonResult.newFileNames)
							},
						success : function(jsonResult) {
							 console.log(jsonResult.msg);
							 //수정필요
							 //$("#user_my_account").get(0).click();
					    },error:  function(jsonResult) {
		    				console.log('error!!: review_write_action');
						}
					});
    			},
    			error : function() {
    				console.log('error!!');
    			}
    		});
    		e.preventDefault();

    	});
    		  
    	$("#thumbnails").on("click", ".close", function(e) {
    		var $target = $(e.target); 
    		var idx = $target.attr('data-idx');
    		uploadFiles[idx].upload = 'disable';  //삭제된 항목은 업로드하지 않기 위해 플래그 생성
    		$target.parent().remove();  //프리뷰 삭제
    	});
    	/* (END)이미지 upload *********************************************/
		
	});//END
	
	return `<div class="submit_a_review_area col-12" style="border: 1px solid #d6e6fb; padding:30px;">
                        <h4>Submit A Review</h4>
                        <!-- [Start]review_write_form -->
                        <!-- <form id="review_write_form" name="review_write_form" action="#" method="post"> -->
                        <form id="review_write_form" name="review_write_form" action="review_write_action" method="post">
                            <!--<input type="hidden" class="" name="orders.orders_no" value="">-->
                                <div class="form-group">
                                    <span>Your Ratings</span>
                                    <input type="hidden" id="review_point" name="review_point" class="" value="">
                                    <input type="hidden" id="review_image" name="review_image" class="" value="test">
                                    <div class="stars">
                                        <input type="radio" name="star" class="star-0_5" id="star-0_5" onclick='setPoint(this.id);'>
                                        <label class="star-0_5" for="star-0_5">0.5</label>
                                        <input type="radio" name="star" class="star-1" id="star-1" onclick='setPoint(this.id);'>
                                        <label class="star-1" for="star-1">1</label>
                                        <input type="radio" name="star" class="star-1_5" id="star-1_5" onclick='setPoint(this.id);'>
                                        <label class="star-1_5" for="star-1_5">1.5</label>
                                        <input type="radio" name="star" class="star-2" id="star-2" onclick='setPoint(this.id);'>
                                        <label class="star-2" for="star-2">2</label>
                                        <input type="radio" name="star" class="star-2_5" id="star-2_5" onclick='setPoint(this.id);'>
                                        <label class="star-2_5" for="star-2_5">2.5</label>
                                        <input type="radio" name="star" class="star-3" id="star-3" onclick='setPoint(this.id);'>
                                        <label class="star-3" for="star-3">3</label>
                                        <input type="radio" name="star" class="star-3_5" id="star-3_5" onclick='setPoint(this.id);'>
                                        <label class="star-3_5" for="star-3_5">3.5</label>
                                        <input type="radio" name="star" class="star-4" id="star-4" onclick='setPoint(this.id);'>
                                        <label class="star-4" for="star-4">4</label>
                                        <input type="radio" name="star" class="star-4_5" id="star-4_5" onclick='setPoint(this.id);'>
                                        <label class="star-4_5" for="star-4_5">4.5</label>
                                        <input type="radio" name="star" class="star-5" id="star-5" onclick='setPoint(this.id);'>
                                        <label class="star-5" for="star-5">5</label>
                                        <span></span>
                                    </div>
                                </div>
                                
                                <!--
                                <div class="form-group">
                                    <label for="name">Nickname</label>
                                    <input type="email" class="form-control" id="name" placeholder="Nazrul">
                                </div>
                                <div class="form-group">
                                    <label for="options">Reason for your rating</label>
                                    <select class="form-control small right py-0 w-100" id="options">
                                        <option>Quality</option>
                                        <option>Value</option>
                                        <option>Design</option>
                                        <option>Price</option>
                                        <option>Others</option>
                                    </select>
                                </div>
                                -->
                                <div class="form-group">
                                    <label for="comments">Comments</label>
                                    <textarea class="form-control" id="review_desc" name="review_desc" rows="5" data-max-length="150"></textarea>
                                </div>
                                
                                <!-- 이미지 업로드 -->
								<div id="drop" class="form-group"
									style="border: 1px solid black; width: 400px; height: 300px; padding: 3px">
									여기로 drag & drop
									<div id="thumbnails"></div>
								</div>
                                <input type="button" id="btnSubmit" class="btn btn-primary" value="Submit Review" />
                                
                                <!--<button type="submit" id="btn_review_write_form" class="btn btn-primary">Submit Review</button>-->
                            </form>
                        <!-- [END]review_write_form -->
                	</div>`;
}

ReviewHtmlContents.review_write_form2=function(orders_no) {

}