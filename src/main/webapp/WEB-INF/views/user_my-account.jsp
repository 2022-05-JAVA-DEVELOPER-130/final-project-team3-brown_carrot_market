<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a7c7231db91ae56cfc5e3c6ea06f73c6&libraries=services"></script>
<script type="text/javascript">
		$(function() {
			/* login_check ***********************/
			$.ajax({
				url:'user_session_check_json',
				method:'POST',
				dataType:'json',
				success:function(jsonResult){
				    if(jsonResult.code==1){
				    	$(".account-area").html(UserHtmlContents.user_thumbnail());
				    }else if (jsonResult.code==2) {
				    	$(".account-area").html(UserHtmlContents.user_thumbnail_login(jsonResult.data[0]));
					}
				}
			});
			/*************************************/
			
			
			/****************user_view******************/
			$(document).on('click', '#user_account_details, #a_account_details',function(e){
				console.log("click!! >> "+e.target);
				    $.ajax({
						url:'user_view_json',
						method:'POST',
						dataType:'json',
						success:function(jsonResult){
						    $('#my-account-content').html(UserHtmlContents.user_view_content(jsonResult.data[0]));
						}
					});
			    e.preventDefault();
			});
			
			/****************user_modify_action******************/
			$(document).on('click',	'#btn_user_modify_action',function(e) {
				console.log("click!! >> "+e.target);
				//if(validator.form()){
			    var param = $('#user_modify_form').serialize();
			    console.log(param);
			    $.ajax({
					url : 'user_modify_action_json',
					method : 'POST',
					dataType : 'json',
					data : param,
					success : function(jsonResult) {
					    if (jsonResult.code == 1) {
						 	$('#my-account-content').html(UserHtmlContents.user_view_content(jsonResult.data[0]));
					    } else if (jsonResult.code == 2) {
							
					    }
					    console.log(jsonResult);
					}
			    });
				//}
				e.preventDefault();
			});
			/****************user_view_addresses******************/
			$(document).on('click',	'#user_view_addresses',function(e) {
				console.log("click!! >> #user_view_addresses");
				
			    $.ajax({
					url : 'user_view_json',
					method : 'POST',
					dataType : 'json',
					success : function(jsonResult) {
							//주소의 갯수를 확인해보자
						    console.log(jsonResult.data[0].addressList.length);
						
							var addressCount=jsonResult.data[0].addressList.length;
							
							if(addressCount==0){
								$('#my-account-content').html(UserHtmlContents.user_view_addresses_zero(jsonResult.data[0].addressList));
							}else if (addressCount==1) {
								$('#my-account-content').html(UserHtmlContents.user_view_addresses_one(jsonResult.data[0].addressList));
							}else if (addressCount==2) {
								$('#my-account-content').html(UserHtmlContents.user_view_addresses(jsonResult.data[0].addressList));
							}
					    }
				});
				
				e.preventDefault();
			});
			/****************user_update_addresses******************/
			//(Step_1) update
			$(document).on('click',	'#btn_address_first,#btn_address_second',function(e) {
				console.log("click!! >> #btn_address...");
			    $.ajax({
					url : 'user_update_adresse_json',
					method : 'POST',
					dataType : 'json',
					success : function(jsonResult) {
							$("input[name=address_name]").attr("disabled",false);
						    console.log(jsonResult);
						    //
						    e.target.id+="_selected";
						    console.log(e.target.id);
						    console.log($(e.target).id);
					    }
				});
				
				e.preventDefault();
			});
			
			//(Step_2) insert
			$(document).on('click',	'#btn_address_first_selected, #btn_address_second_selected,#btn_address_new1,#btn_address_new2',function(e) {
				console.log("click!! >> #btn_address..._selected");
				/**********************************************************/
				console.log('click!! - #address_name');
			    	// 주소-좌표 변환 객체를 생성합니다
			    	var geocoder = new kakao.maps.services.Geocoder();
					// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
					if (navigator.geolocation) {
					    // ***GeoLocation을 이용해서 접속 위치를 얻어옵니다
					    navigator.geolocation.getCurrentPosition(function(position) {
					        var lat = position.coords.latitude, // 위도
					            lon = position.coords.longitude; // 경도
					        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
					            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
					            console.log("locPosition: "+locPosition.getLat(),locPosition.getLng());
					            console.log(message);
								/*좌표->주소 변환*********************************************************/
								 searchDetailAddrFromCoords(locPosition, function(result, status) {
								 if (status === kakao.maps.services.Status.OK) {
								    	//console.log('도로명주소 : ' + result[0].road_address.address_name);
								    	//console.log('지번 주소 : ' + result[0].address.address_name);
								            var detailAddr = !!result[0].road_address ? result[0].road_address.address_name  : '';
								           		 detailAddr += result[0].address.address_name;
								            
								           		//주소를 동까지만 자릅니다.
								           		subStr = detailAddr.lastIndexOf(" ");
								           		detailAddr=detailAddr.substring(0,subStr);
							           		/*(수정 필요)*****************************************/
											$("input[name=address_name]").val(detailAddr);
							           		/******************************************/
								        }
								 });
								/**********************************************************/
					      });
					} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
					    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
					        message = 'geolocation을 사용할수 없어요..'
							$("input[name=address_name]").val(message);
					}
					/*좌표->주소 변환*********************************************************/
					function searchAddrFromCoords(coords, callback) {
					    // 좌표로 행정동 주소 정보를 요청합니다
					    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
					}
					function searchDetailAddrFromCoords(coords, callback) {
					    // 좌표로 법정동 상세 주소 정보를 요청합니다
					    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
					}
			/**********************************************************/
			});
			
			
		});//END
</script>

</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="spinner-grow" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>

	<!-- Header Area -->
	<header class="header_area">
		<!-- Top Header Area -->
		<div class="top-header-area">
			<div class="container h-100">
				<div class="row h-100 align-items-center">
					<div class="col-6">
						<div class="welcome-note">
							<span class="popover--text" data-toggle="popover"
								data-content="Welcome to Bigshop ecommerce template."><i
								class="icofont-info-square"></i></span> <span class="text">Welcome
								to Bigshop ecommerce template.</span>
						</div>
					</div>
					<div class="col-6">
						<div
							class="language-currency-dropdown d-flex align-items-center justify-content-end">
							<!-- Language Dropdown -->
							<div class="language-dropdown">
								<div class="dropdown">
									<a class="btn btn-sm dropdown-toggle" href="#" role="button"
										id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> English </a>
									<div class="dropdown-menu dropdown-menu-right"
										aria-labelledby="dropdownMenu1">
										<a class="dropdown-item" href="#">Bangla</a> <a
											class="dropdown-item" href="#">Arabic</a>
									</div>
								</div>
							</div>

							<!-- Currency Dropdown -->
							<div class="currency-dropdown">
								<div class="dropdown">
									<a class="btn btn-sm dropdown-toggle" href="#" role="button"
										id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> $ USD </a>
									<div class="dropdown-menu dropdown-menu-right"
										aria-labelledby="dropdownMenu2">
										<a class="dropdown-item" href="#">à§³ BDT</a> <a
											class="dropdown-item" href="#">â¬ Euro</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Menu -->
		<div class="bigshop-main-menu">
			<div class="container">
				<div class="classy-nav-container breakpoint-off">
					<nav class="classy-navbar" id="bigshopNav">

						<!-- Nav Brand -->
						<a href="index.html" class="nav-brand"><img
							src="img/core-img/logo.png" alt="logo"></a>

						<!-- Toggler -->
						<div class="classy-navbar-toggler">
							<span class="navbarToggler"><span></span><span></span><span></span></span>
						</div>

						<!-- Menu -->
						<div class="classy-menu">
							<!-- Close -->
							<div class="classycloseIcon">
								<div class="cross-wrap">
									<span class="top"></span><span class="bottom"></span>
								</div>
							</div>

							<!-- Nav -->
							<div class="classynav">
								<ul>
									<li><a href="#">Home</a>
										<ul class="dropdown">
											<li><a href="index-1.html">Home - 1</a></li>
											<li><a href="index-2.html">Home - 2</a></li>
											<li><a href="index-3.html">Home - 3</a></li>
										</ul></li>
									<li><a href="#">Shop</a>
										<ul class="dropdown">
											<li><a href="#">Shop Grid</a>
												<ul class="dropdown">
													<li><a href="shop-grid-left-sidebar.html">Shop
															Grid Left Sidebar</a></li>
													<li><a href="shop-grid-right-sidebar.html">Shop
															Grid Right Sidebar</a></li>
													<li><a href="shop-grid-top-sidebar.html">Shop Grid
															Top Sidebar</a></li>
													<li><a href="shop-grid-no-sidebar.html">Shop Grid
															No Sidebar</a></li>
												</ul></li>
											<li><a href="#">Shop List</a>
												<ul class="dropdown">
													<li><a href="shop-list-left-sidebar.html">Shop
															List Left Sidebar</a></li>
													<li><a href="shop-list-right-sidebar.html">Shop
															List Right Sidebar</a></li>
													<li><a href="shop-list-top-sidebar.html">Shop List
															Top Sidebar</a></li>
													<li><a href="shop-list-no-sidebar.html">Shop List
															No Sidebar</a></li>
												</ul></li>
											<li><a href="product-details.html">Single Product</a></li>
											<li><a href="cart.html">Cart</a></li>
											<li><a href="#">Checkout</a>
												<ul class="dropdown">
													<li><a href="checkout-1.html">Login</a></li>
													<li><a href="checkout-2.html">Billing</a></li>
													<li><a href="checkout-3.html">Shipping Method</a></li>
													<li><a href="checkout-4.html">Payment Method</a></li>
													<li><a href="checkout-5.html">Review</a></li>
													<li><a href="checkout-complate.html">Complate</a></li>
												</ul></li>
											<li><a href="#">Account Page</a>
												<ul class="dropdown">
													<li><a href="user_my_account">- Dashboard</a></li>
													<li><a href="order-list.html">- Orders</a></li>
													<li><a href="downloads.html">- Downloads</a></li>
													<li><a href="addresses.html">- Addresses</a></li>
													<li><a href="account-details.html">- Account
															Details</a></li>
												</ul></li>
											<li><a href="wishlist.html">Wishlist</a></li>
											<li><a href="compare.html">Compare</a></li>
										</ul></li>
									<li><a href="#">Pages</a>
										<div class="megamenu">
											<ul class="single-mega cn-col-4">
												<li><a href="about-us.html">- About Us</a></li>
												<li><a href="faq.html">- FAQ</a></li>
												<li><a href="contact.html">- Contact</a></li>
												<li><a href="login.html">- Login &amp; Register</a></li>
												<li><a href="404.html">- 404</a></li>
												<li><a href="500.html">- 500</a></li>
											</ul>
											<ul class="single-mega cn-col-4">
												<li><a href="my-account.html">- Dashboard</a></li>
												<li><a href="order-list.html">- Orders</a></li>
												<li><a href="downloads.html">- Downloads</a></li>
												<li><a href="addresses.html">- Addresses</a></li>
												<li><a href="account-details.html">- Account
														Details</a></li>
												<li><a href="coming-soon.html">- Coming Soon</a></li>
											</ul>
											<div class="single-mega cn-col-2">
												<div class="megamenu-slides owl-carousel">
													<a href="shop-grid-left-sidebar.html"> <img
														src="img/bg-img/mega-slide-2.jpg" alt="">
													</a> <a href="shop-list-left-sidebar.html"> <img
														src="img/bg-img/mega-slide-1.jpg" alt="">
													</a>
												</div>
											</div>
										</div></li>
									<li><a href="#">Blog</a>
										<ul class="dropdown">
											<li><a href="blog-with-left-sidebar.html">Blog Left
													Sidebar</a></li>
											<li><a href="blog-with-right-sidebar.html">Blog
													Right Sidebar</a></li>
											<li><a href="blog-with-no-sidebar.html">Blog No
													Sidebar</a></li>
											<li><a href="single-blog.html">Single Blog</a></li>
										</ul></li>
									<li><a href="#">Elements</a>
										<div class="megamenu">
											<ul class="single-mega cn-col-4">
												<li><a href="accordian.html">- Accordions</a></li>
												<li><a href="alerts.html">- Alerts</a></li>
												<li><a href="badges.html">- Badges</a></li>
												<li><a href="blockquotes.html">- Blockquotes</a></li>
											</ul>
											<ul class="single-mega cn-col-4">
												<li><a href="breadcrumb.html">- Breadcrumbs</a></li>
												<li><a href="buttons.html">- Buttons</a></li>
												<li><a href="forms.html">- Forms</a></li>
												<li><a href="gallery.html">- Gallery</a></li>
											</ul>
											<ul class="single-mega cn-col-4">
												<li><a href="heading.html">- Headings</a></li>
												<li><a href="icon-fontawesome.html">- Icon
														FontAwesome</a></li>
												<li><a href="icon-icofont.html">- Icon Ico Font</a></li>
												<li><a href="labels.html">- Labels</a></li>
											</ul>
											<ul class="single-mega cn-col-4">
												<li><a href="modals.html">- Modals</a></li>
												<li><a href="pagination.html">- Pagination</a></li>
												<li><a href="progress-bars.html">- Progress Bars</a></li>
												<li><a href="tables.html">- Tables</a></li>
											</ul>
										</div></li>
									<li><a href="contact.html">Contact</a></li>
								</ul>
							</div>
						</div>

						<!-- Hero Meta -->
						<div
							class="hero_meta_area ml-auto d-flex align-items-center justify-content-end">
							<!-- Search -->
							<div class="search-area">
								<div class="search-btn">
									<i class="icofont-search"></i>
								</div>
								<!-- Form -->
								<div class="search-form">
									<input type="search" class="form-control" placeholder="Search">
									<input type="submit" class="d-none" value="Send">
								</div>
							</div>

							<!-- Wishlist -->
							<div class="wishlist-area">
								<a href="wishlist.html" class="wishlist-btn"><i
									class="icofont-heart"></i></a>
							</div>

							<!-- Cart -->
							<div class="cart-area">
								<div class="cart--btn">
									<i class="icofont-cart"></i> <span class="cart_quantity">2</span>
								</div>

								<!-- Cart Dropdown Content -->
								<div class="cart-dropdown-content">
									<ul class="cart-list">
										<li>
											<div class="cart-item-desc">
												<a href="#" class="image"> <img
													src="img/product-img/top-1.png" class="cart-thumb" alt="">
												</a>
												<div>
													<a href="#">Kid's Fashion</a>
													<p>
														1 x - <span class="price">$32.99</span>
													</p>
												</div>
											</div> <span class="dropdown-product-remove"><i
												class="icofont-bin"></i></span>
										</li>
										<li>
											<div class="cart-item-desc">
												<a href="#" class="image"> <img
													src="img/product-img/best-4.png" class="cart-thumb" alt="">
												</a>
												<div>
													<a href="#">Headphone</a>
													<p>
														2x - <span class="price">$49.99</span>
													</p>
												</div>
											</div> <span class="dropdown-product-remove"><i
												class="icofont-bin"></i></span>
										</li>
									</ul>
									<div class="cart-pricing my-4">
										<ul>
											<li><span>Sub Total:</span> <span>$822.96</span></li>
											<li><span>Shipping:</span> <span>$30.00</span></li>
											<li><span>Total:</span> <span>$856.63</span></li>
										</ul>
									</div>
									<div class="cart-box">
										<a href="checkout-1.html" class="btn btn-primary d-block">Checkout</a>
									</div>
								</div>
							</div>

							<!-- Account -->
							<div class="account-area">
								<div class="user-thumbnail">
									<img src="img/bg-img/user.jpg" alt="">
								</div>
								<ul class="user-meta-dropdown">
									<li class="user-title"><span>Hello,</span> Lim Sarah</li>
									<li><a href="my-account.html">My Account</a></li>
									<li><a href="order-list.html">Orders List</a></li>
									<li><a href="wishlist.html">Wishlist</a></li>
									<li><a href="login.html"><i class="icofont-logout"></i>
											Logout</a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- Header Area End -->

	<!-- Breadcumb Area -->
	<div class="breadcumb_area">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<h5>My Account</h5>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item active">My Account</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcumb Area -->

	<!-- My Account Area -->
	<section class="my-account-area section_padding_100_50">
		<div id="container" class="container">
			<div class="row">
				<div class="col-12 col-lg-3">
					<div class="my-account-navigation mb-50">
						<ul>
							<!-- (수정필요)활성화에 따라서, active를 넣는 작업 해야함! -->
							<li class="active"><a href="user_my_account">Dashboard</a></li>
							<li><a href="order-list.html">Orders</a></li>
							<li><a href="downloads.html">Downloads</a></li>
							<li><a href="" id="user_view_addresses">Addresses</a></li>
							<li class="active"><a href="#" id="user_account_details">Account Details</a></li>
							<li><a href="user_logout_action">Logout</a></li>
						</ul>
					</div>
				</div>
				<div class="col-12 col-lg-9">
					<div id="my-account-content" class="my-account-content mb-50">
					<!-- START!! ************************************************ -->
						<p>
							Hello <strong>${loginUser.user_id}</strong> (not <strong>${loginUser.user_id}</strong>?
							<a href="user_logout_action">Log out</a>)
						</p>
						<p>
							From your account dashboard you can view your recent orders,
							manage your shipping and billing addresses, and <a href="account-details.html" id="a_account_details">edit your password and account
								details</a>.
						</p>
					<!-- END!! ************************************************** -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- My Account Area -->

	<!-- Footer Area -->
	<footer class="footer_area section_padding_100_0">
		<div class="container">
			<div class="row">
				<!-- Single Footer Area -->
				<div class="col-12 col-sm-6 col-md-5 col-lg-4 col-xl-3">
					<div class="single_footer_area mb-100">
						<div class="footer_heading mb-4">
							<h6>Contact Us</h6>
						</div>
						<ul class="footer_content">
							<li><span>Address:</span> Lords, London, UK - 1259</li>
							<li><span>Phone:</span> 002 63695 24624</li>
							<li><span>FAX:</span> 002 78965 369552</li>
							<li><span>Email:</span> support@example.com</li>
						</ul>
						<div class="footer_social_area mt-15">
							<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a>
						</div>
					</div>
				</div>

				<!-- Single Footer Area -->
				<div class="col-12 col-sm-6 col-md col-lg-4 col-xl-2">
					<div class="single_footer_area mb-100">
						<div class="footer_heading mb-4">
							<h6>Information</h6>
						</div>
						<ul class="footer_widget_menu">
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Your Account</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Free Shipping Policy</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Your Cart</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Return Policy</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Free Coupon</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Delivary Info</a></li>
						</ul>
					</div>
				</div>

				<!-- Single Footer Area -->
				<div class="col-12 col-sm-6 col-md col-lg-4 col-xl-2">
					<div class="single_footer_area mb-100">
						<div class="footer_heading mb-4">
							<h6>Account</h6>
						</div>
						<ul class="footer_widget_menu">
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Product Support</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Terms &amp; Conditions</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Help</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Payment Method</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Affiliate Program</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Privacy Policy</a></li>
						</ul>
					</div>
				</div>

				<!-- Single Footer Area -->
				<div class="col-12 col-sm-6 col-md-5 col-lg-4 col-xl-2">
					<div class="single_footer_area mb-100">
						<div class="footer_heading mb-4">
							<h6>Support</h6>
						</div>
						<ul class="footer_widget_menu">
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Payment Method</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Help</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Product Support</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Terms &amp; Conditions</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Privacy Policy</a></li>
							<li><a href="#"><i class="icofont-rounded-right"></i>
									Affiliate Program</a></li>
						</ul>
					</div>
				</div>

				<!-- Single Footer Area -->
				<div class="col-12 col-md-7 col-lg-8 col-xl-3">
					<div class="single_footer_area mb-50">
						<div class="footer_heading mb-4">
							<h6>Join our mailing list</h6>
						</div>
						<div class="subscribtion_form">
							<form action="#" method="post">
								<input type="email" name="mail" class="form-control mail"
									placeholder="Your E-mail Addrees">
								<button type="submit" class="submit">
									<i class="icofont-long-arrow-right"></i>
								</button>
							</form>
						</div>
					</div>
					<div class="single_footer_area mb-100">
						<div class="footer_heading mb-4">
							<h6>Download our Mobile Apps</h6>
						</div>
						<div class="apps_download">
							<a href="#"><img src="img/core-img/play-store.png"
								alt="Play Store"></a> <a href="#"><img
								src="img/core-img/app-store.png" alt="Apple Store"></a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer Bottom -->
		<div class="footer_bottom_area">
			<div class="container">
				<div class="row align-items-center">
					<!-- Copywrite -->
					<div class="col-12 col-md-6">
						<div class="copywrite_text">
							<p>
								Made with <i class="fa fa-heart" aria-hidden="true"></i> by <a
									href="#">Designing World</a>
							</p>
						</div>
					</div>
					<!-- Payment Method -->
					<div class="col-12 col-md-6">
						<div class="payment_method">
							<img src="img/payment-method/paypal.png" alt=""> <img
								src="img/payment-method/maestro.png" alt=""> <img
								src="img/payment-method/western-union.png" alt=""> <img
								src="img/payment-method/discover.png" alt=""> <img
								src="img/payment-method/american-express.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
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
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/default/active.js"></script>

</body>

</html>