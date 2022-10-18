/**
 * 
 */
 var p_no=null;
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

function productUpdateAction(){
	if (document.product_modify_form.p_title.value == "") {
      alert("제목을 입력하십시요.");
      document.product_modify_form.p_title.focus();
      return false;
   }
   if (document.product_modify_form.p_price.value == "") {
      alert("가격을 입력하십시요.");
      document.product_modify_form.p_price.focus();
      return false;
   }

   if (document.product_modify_form.p_desc.value == "") {
      alert("내용을 입력하십시요.");
      document.product_modify_form.p_desc.focus();
      return false;
   }
 
   
   const formData1 = new FormData($('#main_contact_form')[0]);
   /*
   formData1.append('files',$('#files')[0]); //이게 맞나?
   formData1.append('files',$('#files')[1]); 
   formData1.append('files',$('#files')[2]); 
   formData1.append('files',$('#files')[3]); 
   */
      
   $.ajax({
      url:'product_modify_action_json',
      type:'POST',
      processData:false,   //파일전송시 반드시 false
      contentType:false,
      data:formData1,
      success:function(jsonResult){
      console.log(jsonResult);
      window.location.href="product_list";
   
   /*
   document.product_modify_form.action = "product_modify_action";
   document.product_modify_form.method='POST';
   document.product_modify_form.submit();
	*/
  		}
   	});
   }
/**********페이징************/
function changeProductList(pageno){
	$.ajax({
		url:"product_list_rest",
		method:"post",
		data:{
			"pageno":pageno,
		},
		dataType:"json",
		success:function(resultObj){
			console.log(resultObj);
			
			let data = resultObj.data;
				let htmlBuffer = ``;
                        	
				data.itemList.forEach(function(product, i){
				
				  htmlBuffer += `<div class="col-12">
                                <div class="single-product-area mb-30">
                                    `;
	               if(product.productImagesList[0].pi_name!=null && product.productImagesList[0].pi_name!="" ){
						htmlBuffer += `
						 <div class="product_image">
                                        <!-- Product Image -->
                                        <img class="normal_img" style="width:300px; height:300px;" src="img/product_img/${product.productImagesList[0].pi_name}" alt="">
                                        <img class="hover_img" style="width:300px; height:300px;" src="img/product_img/${product.productImagesList[0].pi_name}" alt="">

                                        <!-- Product Badge -->
<!--                                         <div class="product_badge">
                                            <span>New</span>
                                        </div> -->

                                        <!-- Wishlist -->
                                        <div class="product_wishlist">
                                            <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                        </div>

                                        <!-- Compare -->
                                        <div class="product_compare">
                                            <a href="compare.html"><i class="icofont-exchange"></i></a>
                                        </div>
                                    </div>`					}
                                    else{
	                               htmlBuffer += ` <div class="product_image">
                                        <!-- Product Image -->
                                        <img class="normal_img" style="width:300px; height:300px;" src="img/chat-img/logo_carrot.png" alt="">
                                        <img class="hover_img" style="width:300px; height:300px;" src="img/chat-img/logo_carrot.png" alt="">

                                        <!-- Product Badge -->
<!--                                         <div class="product_badge">
                                            <span>New</span>
                                        </div> -->

                                        <!-- Wishlist -->
                                        <div class="product_wishlist">
                                            <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                        </div>

                                        <!-- Compare -->
                                        <div class="product_compare">
                                            <a href="compare.html"><i class="icofont-exchange"></i></a>
                                        </div>
                                    </div>`
	
									}
	               
					htmlBuffer += `
	                        <div class="product_description">
                                        
                                        <div class="product_add_to_cart">
                                            <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                        </div>

                                      
                                        <div class="product_quick_view">
                                            <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                        </div> 

                                       <p class="brand_name">Top</p>
                                       <a href="product_detail?p_no=${product.p_no}" p_no="${product.p_no}">${product.p_title}</a>
										<h6 class="product-price">가격: ${product.p_price}</h6>
                                        <p class="product-short-desc">${product.p_desc}</p>
                                    </div>
                                </div>
                            </div>        
                        
                        `;
                     
				});
				$(".shop_list_product_area" ).html(htmlBuffer);
				
				let paginationBuffer = ``;
				if(data.pageMaker.prevPage > 0){
					paginationBuffer += `<li class="page-item">
		                                    <button class="page-link" onclick="changeProductList(${data.pageMaker.prevPage})"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
		                               	 </li>`;
				}
				for(let no = data.pageMaker.blockBegin; no <= data.pageMaker.blockEnd; no++){
					if(data.pageMaker.curPage == no){
						paginationBuffer += `<li class="page-item active"><button class="page-link" href="#">${no}</button></li>`;
					}
					if(data.pageMaker.curPage != no){
						paginationBuffer += `<li class="page-item"><button class="page-link" onclick="changeProductList(${no});">${no}</button></li>`;
					}
				}
				if(data.pageMaker.curPage < data.pageMaker.totPage){
					paginationBuffer += `<li class="page-item">
					                        <button class="page-link" onclick="changeProductList(${data.pageMaker.nextPage});"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
				                    	 </li>`;
				}
				$(".pagination.pagination-sm.justify-content-center").html(paginationBuffer);	
		}
		
	});
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
	
	
	/******************팝업*********************/

$('#btn_popup').click(function(){
	console.log("클릭");
	p_no=document.statePopup.p_no.value;
	console.log(p_no);
	window.open("change_product_state?p_no="+document.statePopup.p_no.value+"&user_id="+document.statePopup.user_id.value,"판매상태변경","width = 470, height = 600, top = 100, left = 200, location = no,  resizable=no");

});	


	
	
	
	});
	
