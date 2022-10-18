function changeQnaList(pageno,t_ctgr_no){
	
	$.ajax({
		url: "townBoard_list_rest",
		method: "post",
		data: {
			"pageno" :pageno,
			"t_ctgr_no":t_ctgr_no
				},
		dataType: "json",
		success:function(resultObj){
			console.log(resultObj);
			if(resultObj.errorCode > 0){
				let data = resultObj.data;
				let htmlBuffer = ``;
				data.itemList.forEach(function(townBoard, i){
				
				   htmlBuffer += `<div class="blog_post_thumb">`;
	               if(townBoard.townImageList.length != 0 ){
						htmlBuffer += `
                            <a href="townboard_view?t_no=${townBoard.t_no}&pageno=${pageno}" t_no="${townBoard.t_no}"><img src="img/townBoard-img/${townBoard.townImageList[0].t_img_name}" alt="blog-post-thumb"></a>`;
					}
	               
					htmlBuffer += `
	                              
                            
                        </div>
                        <div class="blog_post_content">
                        
                        <div class="post-date">
                                <a href="#">${townBoard.townCategory.t_ctgr_name}</a>
                                <span>조회수 : ${townBoard.t_count}</span>
                            </div>
                            <a href="townboard_view?t_no=${townBoard.t_no}&pageno=${pageno}" t_no="${townBoard.t_no}" pageno="${pageno}" class="blog_title">${townBoard.t_title}</a>
                            <p>${townBoard.t_content}</p>
                            <a href="single-blog.html">Continue Reading <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                        </div>
                        `;
                     
				});
				$("#townBoard_list_tbody_all" ).html(htmlBuffer);
				
				let paginationBuffer = ``;
				if(data.pageMaker.prevPage > 0){
					paginationBuffer += `<li class="page-item">
		                                    <button class="page-link" onclick="changeQnaList(${data.pageMaker.prevPage});"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
		                               	 </li>`;
				}
				for(let no = data.pageMaker.blockBegin; no <= data.pageMaker.blockEnd; no++){
					if(data.pageMaker.curPage == no){
						paginationBuffer += `<li class="page-item active"><button class="page-link" href="#">${no}</button></li>`;
					}
					if(data.pageMaker.curPage != no){
						paginationBuffer += `<li class="page-item"><button class="page-link" onclick="changeQnaList(${no});">${no}</button></li>`;
					}
				}
				if(data.pageMaker.curPage < data.pageMaker.totPage){
					paginationBuffer += `<li class="page-item">
					                        <button class="page-link" onclick="changeQnaList(${data.pageMaker.nextPage});"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
				                    	 </li>`;
				}
				$(".pagination.pagination-sm.justify-content-center").html(paginationBuffer);
			}else{
				Toast.fire({ icon: 'error', title: resultObj.errorMsg });
			}
		}
	});
}


/*
게시글 삭제 
*/
$(".townBoard_i.delete").on("click", function(){
	let pageno = $(this).attr("pageno");
	let t_no = $(this).attr("t_no");
	ToastConfirm.fire({ icon: 'question', 
						title: "게시글을 삭제하시겠습니까?\n 삭제 후 복구가 불가능합니다"}).then((result) => {
						if(result.isConfirmed){
							$.ajax({
								url: "townBoard_delete_rest",
								method: "post",
								data: {"t_no":t_no},
								dataType: "json",
								success:function(resultObj){
									if(resultObj.errorCode > 0){
										Toast.fire({ icon: 'success', title: resultObj.errorMsg }).then((result) => {
												location.href = "townBoard_list?pageno=" + pageno;
											});
									}else{
										Toast.fire({ icon: 'error', title: resultObj.errorMsg });
									}
								}
							});
						}
	});
});






/*
게시글 목록 이동
*/

$(".townBoard_btn.list").on("click", function(){
	let pageno = $(this).attr("pageno");
	location.href = `townBoard_list?pageno=${pageno}`;
});



/*
게시글 수정 폼 
*/
$(".townBoard_btn.update_form").on("click", function(){
	let t_no = $(this).attr("t_no");
	let pageno = $(this).attr("pageno");
	console.log(t_no);
	console.log(pageno);
	location.href = `townboard_update_form?t_no=${t_no}&pageno=${pageno}`;
});

/* 
게시글 수정 
*/ 
$(".townBoard_btn.update").on("click", function(){ 
	if($("#t_title_txt").val() == "" || CKEDITOR.instances.townBoard_content_area.getData() == ""){
		Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
		return;
	}
		ToastConfirm.fire({ icon: 'question', 
							title: "게시글을 수정하시겠습니까?"}).then((result) => {
							if(result.isConfirmed){
								let t_no = $(this).attr("t_no"); 
								let pageno = $(this).attr("pageno");
								$("#townBoard_update_form").attr("action", "townboard_update_action"); 
								$("#townBoard_update_form").submit(); 
							}
					});
});

/*
새글 등록 폼 
*/
$(".townBoard_btn.write_form").on("click", function(){
	let pageno = $(this).attr("pageno");
	location.href = "townboard_write_form?pageno=" + pageno;
});




/*
게시글 등록
*/
/*
$(".townBoard_btn.new_write").on("click", function(e){
	e.preventDefault();
	e.stopPropagation();
	var form=$("#townBoard_write_form");
	let pageno = form.find($('input[name="page_no"]')).val();
	let t_no = form.find($('input[name="t_no"]')).val();

	if($("#t_title_txt").val() == "" || CKEDITOR.instances.townBoard_content_area.getData() == ""){
		Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
		return;
	}
	else{
		ToastConfirm.fire({ icon: 'question', 
							title: "게시글을 작성하시겠습니까?"}).then((result) => {
								if(result.isConfirmed){
								/*	
							$.ajax({
								url: "townReply_wirte_rest",
								method: "post",
								data: form.serialize(),
								dataType: "json",
								success:function(resultObj){
									console.log('성공');
									if(resultObj.errorCode > 0){
										Toast.fire({ icon: 'success', title: resultObj.errorMsg }).then((result) => {
											console.log('페이지이동');
												location.href = "townboard_view?t_no="+t_no+"&pageno=" + pageno;
											});
									}else{
										Toast.fire({ icon: 'error', title: resultObj.errorMsg });
									}
								}
							});////아작스 끝////
							
							   //사진 리스트 업로드
  							 // const formData1 = new FormData($('#main_contact_form_townBoard')[0]);
  							 const formData1 = new FormData($('#main_contact_form_townBoard')[0]);
							  $.ajax({
								      url:'townboard_write_action_json',
								      type:'POST',
								      processData:false,   //파일전송시 반드시 false
								      contentType:false,
								      data:formData1,
								      success:function(jsonResult){
								      console.log(jsonResult);
								      window.location.href="townboard_list";
       
      }
   });
							
						}
							
					});				
	
/////여기 자리
/*	$(".townReply_write_form").attr("action", "townReply_wirte_rest");
	$(".townReply_write_form").submit();	
}	
	
});
*/
//게시글 등록
function townBoardCreate() {
   if (document.townBoard_write_form.t_title.value == "") {
      alert("제목을 입력하십시요.");
      document.townBoard_write_form.t_title.focus();
      return false;
   }
   /*
   if (document.townBoard_write_form.t_content.value == "") {
      alert("내용을 입력하십시요.");
      document.townBoard_write_form.t_content.focus();
      return false;
   }
   */
   //사진 리스트 업로드
   const formData1 = new FormData($('#main_contact_form_townBoard')[0]);
   /*
   formData1.append('files',$('#files')[0]); //이게 맞나?
   formData1.append('files',$('#files')[1]); 
   formData1.append('files',$('#files')[2]); 
   formData1.append('files',$('#files')[3]); 
   */
   
   console.log(formData1);
   
   $.ajax({
      url:'townboard_write_action_json',
      type:'POST',
      processData:false,   //파일전송시 반드시 false
      contentType:false,
      data:formData1,
      success:function(jsonResult){
      console.log(jsonResult);
      window.location.href="townBoard_list";
       /*사진이름받기
       $.ajax({
              url : 'product_write_action_json',
              method : 'POST',
              data: {
                  "p_title":$("input[name='p_title']").val(),
                  "p_price":$("input[name='p_price']").val(),
                  "p_ctgr_no":$("input[name='p_ctgr_no']").val(),
                  "p_desc":$("input[name='p_desc']").val(),
                  "pi_name": jsonResult.newFileName 
                     },
                     dataType : 'json',
                     success : function(jsonResult) {
                        console.log(jsonResult.msg);
         }
        });
        */
      }
   });
   }




/*
답글 등록
*/
$(".qna_btn.reply_write").on("click", function(){
	if($("#q_title_txt").val() == "" || CKEDITOR.instances.q_content_area.getData() == ""){
		Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
		return;
	}
	$("#qna_reply_write_form").attr("action", "qna_reply_write");
	$("#qna_reply_write_form").submit();
});



/*
댓글등록
*/
$("#townMainReplyBtn").on("click", function(e){
	e.preventDefault();
	e.stopPropagation();
	var form=$(".townReply_Main_write_form");
	let pageno = form.find($('input[name="page_no"]')).val();
	let t_no = form.find($('input[name="t_no"]')).val();

	if($(".t_reply_title").val() == "" || $(".t_reply_content").val() == ""){
		Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
		return;
	}
	else{
		ToastConfirm.fire({ icon: 'question', 
							title: "댓글을 작성하시겠습니까?"}).then((result) => {
								if(result.isConfirmed){
									
							$.ajax({
								url: "townReply_wirte_rest",
								method: "post",
								data: form.serialize(),
								dataType: "json",
								success:function(resultObj){
									console.log('성공');
									if(resultObj.errorCode > 0){
										Toast.fire({ icon: 'success', title: resultObj.errorMsg }).then((result) => {
											console.log('페이지이동');
												location.href = "townboard_view?t_no="+t_no+"&pageno=" + pageno;
											});
									}else{
										Toast.fire({ icon: 'error', title: resultObj.errorMsg });
									}
								}
							});
						}
							
					});				
}	
	
});


/*
대댓글등록
*/
$(".btn.btn-primary.rereply").on("click", function(e){
	e.preventDefault();
	e.stopPropagation();
	index=$(e.target).attr("index");
	var form=$(".townReReply_write_form_"+index);
	let pageno = form.find($('input[name="page_no"]')).val();
	let t_no = form.find($('input[name="t_no"]')).val();
	let groupno = form.find($('input[name="groupno"]')).val();
	alert(groupno);
	if($(".t_reply_title").val() == "" || $(".t_reply_content").val() == ""){
		Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
		return;
	}
	else{
		ToastConfirm.fire({ icon: 'question', 
							title: "댓글을 작성하시겠습니까?"}).then((result) => {
								if(result.isConfirmed){
									
							$.ajax({
								url: "townReReply_wirte_rest",
								method: "post",
								data: form.serialize(),
								dataType: "json",
								success:function(resultObj){
									console.log();
									if(resultObj.errorCode > 0){
										Toast.fire({ icon: 'success', title: resultObj.errorMsg }).then((result) => {
											console.log('페이지이동');
												location.href = "townboard_view?t_no="+t_no+"&pageno=" + pageno;
											});
									}else{
										Toast.fire({ icon: 'error', title: resultObj.errorMsg });
									}
								}
							});
						}
							
					});				
}	
	
});


/*
댓글 삭제 
*/
$(".townReply.delete").on("click", function(){
	let pageno = $(this).attr("pageno");
	let t_reply_no = $(this).attr("t_reply_no");
	let t_no = $(this).attr("t_no");
	ToastConfirm.fire({ icon: 'question', 
						title: "댓글을 삭제하시겠습니까?\n 삭제 후 복구가 불가능합니다"}).then((result) => {
						if(result.isConfirmed){
							$.ajax({
								url: "townReply_delete_rest",
								method: "post",
								data: {"t_reply_no":t_reply_no
										},
								dataType: "json",
								success:function(resultObj){
									if(resultObj.errorCode > 0){
										Toast.fire({ icon: 'success', title: resultObj.errorMsg }).then((result) => {
												location.href = "townboard_view?t_no="+t_no+"&pageno=" + pageno;
											});
									}else{
										Toast.fire({ icon: 'error', title: resultObj.errorMsg });
									}
								}
							});
						}
	});
});





/*
댓글 토글2
*/
$(document).ready(function() {
  $(".content").hide();
  $(".heading").click(function()
  {
    $(this).next(".content").slideToggle(500);
  });
});




/*
ckeditor
*/

$(() => {
	if($("#notice_content_area").length != 0){
		 CKEDITOR.replace('notice_content_area', {
						height: 500                                                  
                 	});
	}
});
$(() => {
	if($("#townBoard_content_area").length != 0){
		 CKEDITOR.replace('townBoard_content_area', {
						height: 500                                                  
                 	});
	}
});


/*
alert 세팅
*/
const Toast =  Swal.mixin({ 
	toast: true, 
	position: 'center', 
	showConfirmButton: true, 
	confirmButtonColor: '#3085d6',
	width: '400px'
 });

const ToastConfirm =  Swal.mixin({ 
	toast: true, 
	position: 'center', 
	showConfirmButton: true, 
	confirmButtonColor: '#3085d6',
	showDenyButton: true,
	denyButtonText: 'Cancle',
	width: '400px'
 });

$(function(){
	$("#townBoardSearch").keypress(function(e) {
  if (e.keyCode === 13) {
	location.href="townBoardSearch_list?search_keyword="+$("#townBoardSearch").val();
    e.preventDefault();
  
  }
});
	
})


