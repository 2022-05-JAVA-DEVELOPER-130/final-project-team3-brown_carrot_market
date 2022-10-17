var keyword;


$(document).ready(function(){
	keyword=$('#search_keywordhidden').val();
	console.log("검색키워드:"+keyword);
})


function changeSearchList(pageno,keyword){
	$.ajax({
		url:"searchList_rest",
		method:"post",
		data:{
			"pageno":pageno,
			"keyword":keyword
		},
		dataType:"json",
		success:function(resultObj){
			let data = resultObj.data;
				let htmlBuffer = ` <div class="row">
                        	<form>
                        	<input type="hidden" value=${keyword}>
                        	</form>`;
				data.itemList.forEach(function(product, i){
				
				   htmlBuffer += `<div class="col-12">
                                <div class="single-product-area mb-30">
                                    `;
	               if(product.productImagesList.length != 0 ){
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
                                <!--         Add to cart
                                        <div class="product_add_to_cart">
                                            <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                        </div>

                                        Quick View
                                        <div class="product_quick_view">
                                            <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                        </div> -->

<!--                                         <p class="brand_name">Top</p>
 -->                                         <a href="product_detail?p_no=${product.p_no}" p_no="${product.p_no}">${product.p_title}</a>
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
		                                    <button class="page-link" onclick="changeSearchList(${data.pageMaker.prevPage},'${keyword}')"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
		                               	 </li>`;
				}
				for(let no = data.pageMaker.blockBegin; no <= data.pageMaker.blockEnd; no++){
					if(data.pageMaker.curPage == no){
						paginationBuffer += `<li class="page-item active"><button class="page-link" href="#">${no}</button></li>`;
					}
					if(data.pageMaker.curPage != no){
						paginationBuffer += `<li class="page-item"><button class="page-link" onclick="changeSearchList(${no},'${keyword}');">${no}</button></li>`;
					}
				}
				if(data.pageMaker.curPage < data.pageMaker.totPage){
					paginationBuffer += `<li class="page-item">
					                        <button class="page-link" onclick="changeSearchList(${data.pageMaker.nextPage},'${keyword}');"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
				                    	 </li>`;
				}
				$(".pagination.pagination-sm.justify-content-center").html(paginationBuffer);	
		}
		
	});
}