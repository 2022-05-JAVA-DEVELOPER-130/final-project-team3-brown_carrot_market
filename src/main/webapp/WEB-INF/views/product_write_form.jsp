<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Bigshop | Responsive E-commerce Template</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">
	
	<!-- javaScript -->
    <script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/user_session_check.js"></script>
	<script type="text/javascript" src="js/product/product.js"></script>
	
	
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
    
    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>Contact</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="main">흙당근마켓</a></li>
                        <li class="breadcrumb-item"><a href="product_list">동네물건</a></li>
                        <li class="breadcrumb-item active">내 물건 팔기</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->

    <!-- Message Now Area -->
                <div class="col-12">
                    <div class="contact_from mb-50">
                        <form name="product_write_form" action="product_write_action" 
                        	method="post" enctype="multipart/form-data" id="main_contact_form">
                            <div class="contact_input_area">
                                <div id="success_fail_info"></div>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="p_title" id="p_title" placeholder= 제목 required>
                                        </div>
                                    </div>
                                    <!--  
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="l_name" id="l-name" placeholder="Last Name" required>
                                        </div>
                                    </div>
                                    -->
                                    
                                    <div class="col-md-6 mb-3">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="p_price" id="p_price" placeholder="가격" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6 mb-3">
                                        <div class="form-group">
                                            <select id="p_ctgr_no" name="p_ctgr_no" class="custom-select form-control w-100">
                                                <option selected disabled="disabled">카테고리</option>
                                                <option value="1">-가전제품</option>
                                                <option value="2">-가구</option>
                                                <option value="3">-의류</option>
                                                <option value="4">-생활용품</option>
                                                <option value="5">-취미/게임/음반/도서</option>
                                                <option value="6">-기타</option>
                                            </select>
                                        </div>
                                    </div>
                                    사진1: <input type="file" name="files"><br> 
									사진2: <input type="file" name="files"><br> 
									사진3: <input type="file" name="files"><br> 
									사진4: <input type="file" name="files"><br> 
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <textarea name="p_desc" class="form-control" id="p_desc" cols="30" rows="10" placeholder="물건 설명" required></textarea>
                                        	</div>
                                        </div>
                                    </div>
                                    <div class="col-12 text-center">
                                        <input type="button" id="btn_product_write_action" class="btn btn-primary w-40" value="물건 올리기" onclick="productCreate()">&nbsp; 
                                        <input type="button" class="btn btn-primary w-40" value="동네물건목록" onclick="productList()">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                
    <!-- Message Now Area -->

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

</body>

</html>