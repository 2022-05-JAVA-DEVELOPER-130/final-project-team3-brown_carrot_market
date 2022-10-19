<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Brwon Carrot Market</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">
	<!-- javaScript -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/common/user_session_check.js"></script>
	<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
	<script type="text/javascript" src="js/product/product.js"></script>
	
	<!-- toast -->
	<link href="[//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css](https://cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css)" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="[https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css](https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css)"/>
	<script type="text/javascript" src="[https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js](https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js)"></script>
	
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="spinner-grow" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>

    <!-- Header Area -->
   		<!-- include_common_bottom.jsp start-->
		<jsp:include page="common/include_common_header.jsp"/>
		<!-- include_common_bottom.jsp end-->
    <!-- Header Area End -->
    
    <!-- Quick View Modal Area -->
   
    <!-- Quick View Modal Area -->

    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>Product Details</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">Product Details</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->

    <!-- Single Product Details Area -->
    <section class="single_product_details_area section_padding_100">
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-6">
                    <div class="single_product_thumb">
                        <div id="product_details_slider" class="carousel slide" data-ride="carousel">

                            <!-- Carousel Inner -->
                           
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                
	                                <c:set var = "image_name" value = "${product.productImagesList[0].pi_name}"/>
	                                <c:choose>
										<c:when test="${fn:startsWith(image_name, 'http')}">
		                                    <a class="gallery_img" href="${product.productImagesList[0].pi_name}" title="First Slide">
		                                        <img class="d-block w-100" src="${product.productImagesList[0].pi_name}" alt="First slide">
		                                    </a>
	                                       </c:when>
										<c:otherwise>
		                                    <a class="gallery_img" href="img/product_img/${product.productImagesList[0].pi_name}" title="First Slide">
		                                        <img class="d-block w-100" src="img/product_img/${product.productImagesList[0].pi_name}" alt="First slide">
		                                    </a>
										</c:otherwise>
									</c:choose>	
                                
                                    <!-- Product Badge -->
                                    <div class="product_badge">
                                        <span class="badge-new">New</span>
                                    </div>
                                </div>
                              
                             
                                <div class="carousel-item">
                                    <a class="gallery_img" href="img/product-img/pd-big-thumb-2.png" title="Second Slide">
                                        <img class="d-block w-100" src="img/product-img/pd-big-thumb-2.png" alt="Second slide">
                                    </a>
                                    <!-- Product Badge -->
                                    <div class="product_badge">
                                        <span class="badge-new">Sale</span>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <a class="gallery_img" href="img/product-img/pd-big-thumb-3.png" title="Third Slide">
                                        <img class="d-block w-100" src="img/product-img/pd-big-thumb-3.png" alt="Third slide">
                                    </a>
                                    <!-- Product Badge -->
                                    <div class="product_badge">
                                        <span class="badge-new">-20%</span>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <a class="gallery_img" href="img/product-img/pd-big-thumb-4.png" title="Fourth Slide">
                                        <img class="d-block w-100" src="img/product-img/pd-big-thumb-4.png" alt="Fourth slide">
                                    </a>
                                    <!-- Product Badge -->
                                    <div class="product_badge">
                                        <span class="badge-new">Hot</span>
                                    </div>
                                </div>
                            </div>
						
                            <!-- Carosel Indicators -->
                            <ol class="carousel-indicators">
                       
                                <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(img/product_img/${product.productImagesList[i].pi_name});">
                                </li>
                               
                                <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(img/product_img/${product.productImagesList[i+1].pi_name});">
                                </li>
                                <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(img/product-img/pd-big-thumb-3.png);">
                                </li>
                                <li data-target="#product_details_slider" data-slide-to="3" style="background-image: url(img/product-img/pd-big-thumb-4.png);">
                                </li>
                              
                            </ol>
                        </div>
                    </div>
                </div>

                <!-- Single Product Description -->
                <div class="col-12 col-lg-6">
                    <div class="single_product_desc">
                        <h4 class="title mb-2">판매자 : ${product.userInfo.user_id}</h4>
                       <!-- 신선도 해결
                        <div class="form-group">
                                    <span>신선도</span>
                                    <div class="stars">
                                        <input type="radio" name="star" class="star-${product.userInfo.user_freshness}" id="star-${product.userInfo.user_freshness}" checked>
                                        <label class="star-${product.userInfo.user_freshness}" for="star-${product.userInfo.user_freshness}">${product.userInfo.user_freshness}</label>
                                        <span style="width:${star}%"></span>
                                    </div>
                                </div>
                             -->     
                        <hr>
                        <h3 class="title mb-2">${product.p_title}</h3>
                        <p>${product.productCategory.p_ctgr_name}</p>
                        <!--  
                        <div class="single_product_ratings mb-2">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <span class="text-muted">(8 Reviews)</span>
                        </div>
                        -->
                        <h4 class="price mb-4">가격 : ${product.p_price} 원 </h4>
                        
                        <!-- Overview -->
                        <div class="short_overview mb-4">
                            <h5>설명</h5>
                            <h6>${product.p_desc}</h6>
                        </div>
                         <div class="short_overview mb-4">
                         	<p>관심  ${product.p_wish} 조회수  ${product.p_count}</p>
                         </div>

                        <!-- Color Option -->
                       

                        <!-- Size Option -->
                       

                        <!-- Add to Cart Form -->
                        <form class="cart clearfix my-5 d-flex flex-wrap align-items-center" method="post" name="chatStart">
                            <!--  
                            <div class="quantity">
                                <input type="number" class="qty-text form-control" id="qty2" step="1" min="1" max="12" name="quantity" value="1">
                            </div>
                            -->
                            
                            <input type="hidden" name="loginId" id="loginId" value="${sUser.user_id}" />
                            <input type="hidden" name="p_userId" id="p_userId" value="${product.userInfo.user_id}" />
                            <input type="hidden" name="p_no" id="p_no" value="${product.p_no}" />
                            <input type="hidden" name="p_title" value="${product.p_title}" />
                            <input type="hidden" name="p_desc" value="${product.p_desc}" />
                            <input type="hidden" name="p_price" value="${product.p_price}" />
                            <input type="hidden" name="p_ctgr_no" value="${product.productCategory.p_ctgr_no}" />
                            <input type="hidden" name="user_id" value="${product.userInfo.user_id}" />
                            <button type="button" name="btnCreate" class="btn btn-primary mt-1 mt-md-0 ml-1 ml-md-3" id="btnCreate">채팅하기</button>
                        </form>
                        
                        <h5>
                        	<c:if test="${product.p_sell eq 1}">
		                                        		<c:out value="판매중"></c:out>
		                                        	</c:if>
		                                        	<c:if test="${product.p_sell eq 2}">
		                                        		<c:out value="예약중"></c:out>
		                                        	</c:if>
		                                        	<c:if test="${product.p_sell eq 3}">
		                                        		<c:out value="판매완료"></c:out>
		                                        	</c:if>
                        </h5>
                        
                        <!--  
						<form class="cart clearfix my-5 d-flex flex-wrap align-items-center" method="post" name="product_modify_sell_action">
						<div class="form-group">
                 			 <input type="hidden" name="p_no" id="p_no" value="${product.p_no}" />
                             <select id="p_sell" name="p_sell" class="custom-select form-control w-100" style="width:50%!important;">
                             <option selected disabled="disabled">임시</option>
                             <option value="1">-판매중</option>
                             <option value="2">-예약중</option>
                             <option value="3">-판매완료</option>
                             </select>
                             
                             <button type="button" id="btn_product_modify_sell_action" class="btn btn-primary mt-1 mt-md-0 ml-1 ml-md-3" onclick="productSell()" style="position: relative; top:-40px; left:140px;">판매상태수정</button>
                      	</div>
						</form>
						-->
                        <!-- Others Info -->
                        <div class="others_info_area mb-3 d-flex flex-wrap">
                            <a class="add_to_wishlist" href="wishlist.html"><i class="fa fa-heart" aria-hidden="true"></i> 찜하기</a>
                           <!--  
                            <a class="" href="product_modify_form?p_no=${product.p_no}" p_no="${product.p_no}" id="product_modify_form"><i class="fa fa-th" aria-hidden="true"></i> 수정하기</a>
                            <a class="share_with_friend" href="product_delete_action"><i class="fa fa-share" aria-hidden="true"></i> 삭제하기</a>
                        	-->
                        </div>

                        <!-- Size Guide -->
                      

        <div class="container">
            <div class="row">
                <div class="col-12">
                <!--  
                    <div class="product_details_tab section_padding_100_0 clearfix">
                    -->
                        <!-- Tabs 
                        <ul class="nav nav-tabs" role="tablist" id="product-details-tab">
                            <li class="nav-item">
                                <a href="#description" class="nav-link active" data-toggle="tab" role="tab">Description</a>
                            </li>
                            <li class="nav-item">
                                <a href="#reviews" class="nav-link" data-toggle="tab" role="tab">Reviews <span class="text-muted">(3)</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="#addi-info" class="nav-link" data-toggle="tab" role="tab">Additional Information</a>
                            </li>
                            <li class="nav-item">
                                <a href="#refund" class="nav-link" data-toggle="tab" role="tab">Return &amp; Cancellation</a>
                            </li>
                        </ul>
                        -->
                        <!-- Tab Content 
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade show active" id="description">
                                <div class="description_area">
                                    <h5>Description</h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur nulla similique deserunt nemo ea eum expedita, et repellat repudiandae unde quia molestias deleniti incidunt, ad cupiditate. Corporis ipsam minus officiis neque magni harum accusantium nobis labore veritatis, consectetur ab rerum.</p>

                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ex cum dolore, adipisci vitae quidem. Quaerat tenetur explicabo tempore beatae dolor. Quo ipsa labore, itaque ea ratione. Ratione labore quae corporis.</p>

                                    <div class="embed-responsive embed-responsive-16by9 mb-3">
                                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/tjvOOKx7Ytw?ecver=1" allowfullscreen></iframe>
                                    </div>

                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic facere quos repudiandae ratione maiores accusantium suscipit, quod fugiat. Fugit quod laborum quidem, quos adipisci harum aspernatur, repudiandae, beatae expedita rerum ipsam dicta molestias et quis sapiente maiores amet laudantium minus nostrum. Nobis amet veritatis autem illo neque voluptas culpa vero iusto distinctio perspiciatis.</p>

                                    <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima animi ab, quis atque, sed nulla veniam quisquam amet perspiciatis, aliquam dolore tempora, consequuntur beatae quae dolor rem repellendus! Vitae architecto sequi quo eaque iusto impedit suscipit non maxime sint totam, nesciunt necessitatibus iste nulla ab, veritatis assumenda.</p>
                                </div>
                            </div>

                            <div role="tabpanel" class="tab-pane fade" id="reviews">
                                <div class="reviews_area">
                                    <ul>
                                        <li>
                                            <div class="single_user_review mb-15">
                                                <div class="review-rating">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <span>for Quality</span>
                                                </div>
                                                <div class="review-details">
                                                    <p>by <a href="#">Designing World</a> on <span>12 Sep 2019</span></p>
                                                </div>
                                            </div>
                                            <div class="single_user_review mb-15">
                                                <div class="review-rating">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <span>for Design</span>
                                                </div>
                                                <div class="review-details">
                                                    <p>by <a href="#">Designing World</a> on <span>12 Sep 2019</span></p>
                                                </div>
                                            </div>
                                            <div class="single_user_review">
                                                <div class="review-rating">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <span>for Value</span>
                                                </div>
                                                <div class="review-details">
                                                    <p>by <a href="#">Designing World</a> on <span>12 Sep 2019</span></p>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                                <div class="submit_a_review_area mt-50">
                                    <h4>Submit A Review</h4>
                                    <form action="#" method="post">
                                        <div class="form-group">
                                            <span>Your Ratings</span>
                                            <div class="stars">
                                                <input type="radio" name="star" class="star-1" id="star-1">
                                                <label class="star-1" for="star-1">1</label>
                                                <input type="radio" name="star" class="star-2" id="star-2">
                                                <label class="star-2" for="star-2">2</label>
                                                <input type="radio" name="star" class="star-3" id="star-3">
                                                <label class="star-3" for="star-3">3</label>
                                                <input type="radio" name="star" class="star-4" id="star-4">
                                                <label class="star-4" for="star-4">4</label>
                                                <input type="radio" name="star" class="star-5" id="star-5">
                                                <label class="star-5" for="star-5">5</label>
                                                <span></span>
                                            </div>
                                        </div>
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
                                        <div class="form-group">
                                            <label for="comments">Comments</label>
                                            <textarea class="form-control" id="comments" rows="5" data-max-length="150"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit Review</button>
                                    </form>
                                </div>
                            </div>

                            <div role="tabpanel" class="tab-pane fade" id="addi-info">
                                <div class="additional_info_area">
                                    <h5>Additional Info</h5>
                                    <p>What should I do if I receive a damaged parcel?
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit impedit similique qui, itaque delectus labore.</span></p>
                                    <p>I have received my order but the wrong item was delivered to me.
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis quam voluptatum beatae harum tempore, ab?</span></p>
                                    <p>Product Receipt and Acceptance Confirmation Process
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum ducimus, temporibus soluta impedit minus rerum?</span></p>
                                    <p class="mb-0">How do I cancel my order?
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum eius eum, minima!</span></p>
                                </div>
                            </div>

                            <div role="tabpanel" class="tab-pane fade" id="refund">
                                <div class="refund_area">
                                    <h6>Return Policy</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa quidem, eos eius laboriosam voluptates totam mollitia repellat rem voluptate obcaecati quas fuga similique impedit cupiditate vitae repudiandae. Rem, tenetur placeat!</p>

                                    <h6>Return Criteria</h6>
                                    <ul class="mb-30 ml-30">
                                        <li><i class="icofont-check"></i> Package broken</li>
                                        <li><i class="icofont-check"></i> Physical damage in the product</li>
                                        <li><i class="icofont-check"></i> Software/hardware problem</li>
                                        <li><i class="icofont-check"></i> Accessories missing or damaged etc.</li>
                                    </ul>

                                    <h6>Q. What should I do if I receive a damaged parcel?</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit impedit similique qui, itaque delectus labore.</p>

                                    <h6>Q. I have received my order but the wrong item was delivered to me.</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis quam voluptatum beatae harum tempore, ab?</p>

                                    <h6>Q. Product Receipt and Acceptance Confirmation Process</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum ducimus, temporibus soluta impedit minus rerum?</p>

                                    <h6>Q. How do I cancel my order?</h6>
                                    <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum eius eum, minima!</p>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
                            -->
    </section>
    <!-- Single Product Details Area End -->

    <!-- Related Products Area -->
    <section class="you_may_like_area section_padding_0_100 clearfix">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section_heading new_arrivals">
                        <h5>You May Also Like</h5>
                    </div>
                </div>
            </div>
            <div class="row">
            
                <div class="col-12">
                    <div class="you_make_like_slider owl-carousel">
                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-1-back.png" alt="">
                                <img class="hover_img" src="img/product-img/new-1.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Top</p>
                                <a href="#">Boutique Silk Dress</a>
                                <h6 class="product-price">$48.99</h6>
                            </div>
                        </div>
                        

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-6.png" alt="">
                                <img class="hover_img" src="img/product-img/new-6-back.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Lim</p>
                                <a href="#">Gracia Plaid Dress</a>
                                <h6 class="product-price">$17.63</h6>
                            </div>
                        </div>

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-2.png" alt="">
                                <img class="hover_img" src="img/product-img/new-2-back.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Sarah</p>
                                <a href="#">Flower Textured Dress</a>
                                <h6 class="product-price">$24 <span>$49</span></h6>
                            </div>
                        </div>

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-4.png" alt="">
                                <img class="hover_img" src="img/product-img/new-4-back.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Lim</p>
                                <a href="#">Gracia Plaid Dress</a>
                                <h6 class="product-price">$78.24</h6>
                            </div>
                        </div>

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-1-back.png" alt="">
                                <img class="hover_img" src="img/product-img/new-1.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Top</p>
                                <a href="#">Boutique Silk Dress</a>
                                <h6 class="product-price">$48.99</h6>
                            </div>
                        </div>

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-6.png" alt="">
                                <img class="hover_img" src="img/product-img/new-6-back.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Lim</p>
                                <a href="#">Gracia Plaid Dress</a>
                                <h6 class="product-price">$17.63</h6>
                            </div>
                        </div>

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-2.png" alt="">
                                <img class="hover_img" src="img/product-img/new-2-back.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Sarah</p>
                                <a href="#">Flower Textured Dress</a>
                                <h6 class="product-price">$24 <span>$49</span></h6>
                            </div>
                        </div>

                        <!-- Single Product -->
                        <div class="single-product-area">
                            <div class="product_image">
                                <!-- Product Image -->
                                <img class="normal_img" src="img/product-img/new-4.png" alt="">
                                <img class="hover_img" src="img/product-img/new-4-back.png" alt="">

                                <!-- Product Badge -->
                                <div class="product_badge">
                                    <span>New</span>
                                </div>

                                <!-- Wishlist -->
                                <div class="product_wishlist">
                                    <a href="wishlist.html"><i class="icofont-heart"></i></a>
                                </div>

                                <!-- Compare -->
                                <div class="product_compare">
                                    <a href="compare.html"><i class="icofont-exchange"></i></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product_description">
                                <!-- Add to cart -->
                                <div class="product_add_to_cart">
                                    <a href="#"><i class="icofont-shopping-cart"></i> Add to Cart</a>
                                </div>

                                <!-- Quick View -->
                                <div class="product_quick_view">
                                    <a href="#" data-toggle="modal" data-target="#quickview"><i class="icofont-eye-alt"></i> Quick View</a>
                                </div>

                                <p class="brand_name">Lim</p>
                                <a href="#">Gracia Plaid Dress</a>
                                <h6 class="product-price">$78.24</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Related Products Area -->

    <!-- Footer Area -->
		<!-- include_common_bottom.jsp start-->
		<jsp:include page="common/include_common_footer.jsp"/>
		<!-- include_common_bottom.jsp end-->
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/default/classy-nav.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/default/scrollup.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jarallax.min.js"></script>
    <script src="js/jarallax-video.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/default/active.js"></script>
	
<style type="text/css">
#toast-container > .toast {
background-image: none !important;
}

#toast-container > .toast:before {
position: relative;
font-family: FontAwesome;
font-size: 24px;
line-height: 18px;
float: left;
color: #FFF;
padding-right: 0.5em;
margin: auto 0.5em auto -1.5em;
}
#toast-container > .toast-warning:before {
content: "\f27a";

}
#toast-container > .toast-success:before {
content: "\f2b5";
}
	
</body>

</html>