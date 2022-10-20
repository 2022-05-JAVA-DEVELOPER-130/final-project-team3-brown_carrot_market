<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Brown Carrot Market</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Style CSS -->
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/user.css">
<!-- toast -->
 <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>
   

<!-- javaScript -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script type="text/javascript" src="js/common/user_session_check.js"></script>
<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
<script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
<!-- jQuery -->
<%-- <script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script> --%>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<style>
#checkout_steps_area
color = orange;
</style>
</head>
<script>
</script>
<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="spinner-grow" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>

	<!-- Header Area -->
	<jsp:include page="common/include_common_header.jsp" />
	<!-- Header Area End -->

	<!-- Breadcumb Area -->
	<div class="breadcumb_area">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<h5>흙당근페이</h5>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item active">페이 출금</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcumb Area -->
	<div class="col-12">
		<div class="checkout_steps_area">
			<a href="/brown_carrot_market/payment_deposit"><i class="icofont-check-circled"></i> 페이 충전</a> 
			<a href="/brown_carrot_market/point_list"><i class="icofont-check-circled"></i> 페이 내역</a> 
			<a class="active" href="/brown_carrot_market/payment_withdraw"><i class="icofont-check-circled"></i> 페이 출금</a>
		</div>
	</div>
	<div>
		<select id="point_select2" name="point_select2">
			<option value="1">10000</option>
			<option value="2">50000</option>
			<option value="3">100000</option>
			<option value="4">직접입력</option>
		</select>
		<input type="text" id="point_select2_input" name="point_select2_input"/>
		<br>
		<br>
		<br>
		<br>
		<br>
		<input type="text" id="account_input" name="account_input"/>
	</div>

		<div class="col-12">
		<div class="checkout_pagination mt-50">
			<button class="btn btn-primary" onclick="withdrawPay()">출금하기</button>
		</div>
	</div>
	<script>
		$(function point_select2(){
		$("#point_select2_input").hide();
		$("#point_select2").change(function() {
				if($("#point_select2").val() == "4") {
					$("#point_select2_input").show();
				}else {
					$("#point_select2_input").hide();
				}
			}) 
		});
		$("#point_select2_input").change(function() {
			$("#point_select2 option:selected").text($("#point_select2_input").val());			
		});
		
		function withdrawPay(){
					let amount = $("#point_select2 option:selected").text();
					//let account = $("#point_select2_input").text();
				if ((${sUser.user_point}-#{amount})>=0) {
					// 성공 시 로직,
					let data = {
						"amount" : amount,
						"account" : account
					};
					
					var url = "/brown_carrot_market/payment_withdraw_complete?amount="+amount+"&account="+account;
					var name = "당근 페이 포인트 출금";
					var option = "width = 470, height = 650, top = 100, left = 200, location = yes,  resizable=no";
					window.open(url, name, option);
					
				} else if((${sUser.user_point}-$(amount)<0){
					// 결제 실패 시 로직,
					var url = "/brown_carrot_market/payment_withdraw_fail";
					var name = "당근 페이 포인트 출금";
					var option = "width = 470, height = 650, left = 500, location = yes,  resizable=no";
					window.open(url, name, option);
				}
			};		
	</script>

	<!-- Checkout Area End -->

	<!-- Footer Area -->
	<jsp:include page="common/include_common_footer.jsp" />
	<!-- Footer Area -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<%-- <script src="js/jquery.min.js"></script> --%>
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
	
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>  

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