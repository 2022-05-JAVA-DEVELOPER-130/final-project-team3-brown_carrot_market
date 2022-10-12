<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Brown Carrot Market</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/user.css">

    <!-- javaScript -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/common/user_session_check.js"></script>
	<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
	<script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="spinner-grow" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>

    <!-- Header Area -->
		<jsp:include page="common/include_common_header.jsp"/>
    <!-- Header Area End -->
    
    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>후기작성</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item">구매내역</li>
                        <li class="breadcrumb-item active">후기작성</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->
    <!-- Cart Area -->
	    <div class="cart_area section_padding_100_70 clearfix">
	        <div class="container">
	            <div class="row justify-content-between">
                	<div class="submit_a_review_area col-12" style="border: 1px solid #d6e6fb; padding:30px;">
                            <h4>Submit A Review</h4>
                            <!-- [Start]review_write_form -->
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
                            <!-- [END]review_write_form -->
                	</div>
	            </div>
	        </div>
	    </div>
    <!-- Cart Area End -->

    <!-- Footer Area -->
   	<jsp:include page="common/include_common_footer.jsp"/>
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
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/default/active.js"></script>

</body>

</html>