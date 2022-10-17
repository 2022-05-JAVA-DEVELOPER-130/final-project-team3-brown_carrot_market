/**
 * 
 */
 function productCreateForm() {
   
   window.location.href='product_write_form';
}

function productList() {
   window.location.href='product_list';
}
function productCreate() {
   if (document.product_write_form.p_title.value == "") {
      alert("제목을 입력하십시요.");
      document.product_write_form.p_title.focus();
      return false;
   }
   if (document.product_write_form.p_price.value == "") {
      alert("가격을 입력하십시요.");
      document.product_write_form.p_price.focus();
      return false;
   }

   if (document.product_write_form.p_desc.value == "") {
      alert("내용을 입력하십시요.");
      document.product_write_form.p_desc.focus();
      return false;
   }
   
   //사진 리스트 업로드
   const formData1 = new FormData($('#main_contact_form')[0]);
   /*
   formData1.append('files',$('#files')[0]); //이게 맞나?
   formData1.append('files',$('#files')[1]); 
   formData1.append('files',$('#files')[2]); 
   formData1.append('files',$('#files')[3]); 
   */
   $.ajax({
      url:'product_write_action_json',
      type:'POST',
      processData:false,   //파일전송시 반드시 false
      contentType:false,
      data:formData1,
      success:function(jsonResult){
      console.log(jsonResult);
      window.location.href="product_list";
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
   const formData2 = new FormData();
   formData2.append('p_title',$("p_title"));
   formData2.append('p_price',$("p_price"));
   formData2.append('p_desc',$("p_desc"));
   formData2.append('p_ctgr_no',$("p_ctgr_no"));
   */
   
   /*
   document.product_write_form.action = "product_write_action_json";
   document.product_write_form.method='POST';
   document.product_write_form.submit();
}
   */

function productSell(){
	
	if(document.chatStart.p_userId.value==document.chatStart.loginId.value){ 
	document.product_modify_sell_action.action = "product_modify_sell_action"
	document.product_modify_sell_action.method='POST';
	document.product_modify_sell_action.submit();}
	else{
		alert("본인 상품만 상태수정 가능합니다.");
		
	}
}

/********************채팅하기!!**************************/
$(document).ready(function(){
	$('#btnCreate').click(function(){
		if(document.chatStart.p_userId.value==document.chatStart.loginId.value){
			alert("본인 상품과는 채팅할 수 없습니다.");
			
			
			
		}else{
		console.log('채팅방 생성 버튼 클릭');
		document.chatStart.action="create_room";
		document.chatStart.method='POST';
		document.chatStart.submit();
		}
	});
	});