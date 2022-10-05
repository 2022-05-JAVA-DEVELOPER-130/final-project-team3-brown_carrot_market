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
<title>Brwon Carrot Market</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Style CSS -->
<link rel="stylesheet" href="style.css">


<!-- <link rel="stylesheet" href="css/user_btn.css"> -->

<!-- javaScript -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a7c7231db91ae56cfc5e3c6ea06f73c6&libraries=services"></script>
<script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
<script type="text/javascript" src="js/common/user_session_check.js"></script>
<script type="text/javascript">
		$(function() {
			
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
							var addressCount=jsonResult.data[0].addressList.length;
							
							if(addressCount==0){
								$('#my-account-content').html(UserHtmlContents.user_view_addresses_zero(jsonResult.data[0].addressList));
							}else if (addressCount==1) {
								$('#my-account-content').html(UserHtmlContents.user_view_addresses_one(jsonResult.data[0].addressList));
							}else if (addressCount==2) {
								$('#my-account-content').html(UserHtmlContents.user_view_addresses(jsonResult.data[0].addressList));
								if(jsonResult.data[0].addressList[0].address_range > 0){
									$('#btn_address_first').parent($("address")).addClass("selected_Address");
									$('#btn_address_first').css("background","#0f99f3");
									$('#btn_address_first').css("color","#fff");
									$(".selected_Address > input[name=address_range]").attr("disabled",false);
									
								}else{
									$('#btn_address_second').parent($("address")).addClass("selected_Address");
									$('#btn_address_second').css("background","#0f99f3");
									$('#btn_address_second').css("color","#fff");
									$(".selected_Address > input[name=address_range]").attr("disabled",false);
									
									/*
									$('#btn_address_second').addClass("selected_sAddress");
									$(e.target).addClass("selected_sAddress");
									$(".selected_sAddress").css("background","#0f99f3");
									$(".selected_sAddress").css("color","#fff");
									$(".selected_sAddress").parent($("address")).children("input[name=address_range]").attr("disabled",false);
									*/
								}
							}
					    }
				});
				e.preventDefault();
			});
			
		 /****************remove_address******************/
			$(document).on('click',	'#btn_remove_first,#btn_remove_second',function(e) {
			//$(document).on('click',	'.remove',function(e) {
				console.log('click!!'+$(e.target).parent($("address")).children("input[name=address_name]").val());
				$.ajax({
					url : 'user_remove_address_json',
					method : 'POST',
					data: $(e.target).parent($("address")).children().serialize(),
					dataType : 'json',
					success : function(jsonResult) {
						    console.log(jsonResult);
						    $( "#user_view_addresses" ).trigger( "click" );
					    }
				});
				e.preventDefault();
			});
			
		 /****************change_selected_address[type='radio']******************/
			$(document).on('click', "#btn_address_first,#btn_address_second",function(e) {
				console.log('click!!'+e.target.id);
				console.log($(e.target).parent($("address")).hasClass('selected_Address'));
				
				//if(!$(e.target).parent($("address")).hasClass('selected_Address')){
					//선택 해제
					$(".selected_Address>input[name=address_name]").css("background","");
					$(".selected_Address>input[name=address_name]").css("color","");
					$(".selected_Address>input[name=address_range]").attr("disabled",true);
					$(".selected_Address>input[name=address_range]").val(0);
					$(".selected_Address>.range_val").text(0);
					//$(".selected_Address>input[name=address_range]").trigger( "change" );
					//$(".selected_sAddress").parent($("address")).children("input[name=address_range]").trigger( "change" );
					
					$.ajax({
						url : 'user_update_address_range_json',
						method : 'POST',
						data: $(".change_Address > *").serialize(),
						dataType : 'json',
						success : function(jsonResult) {
							    console.log(jsonResult);
							    //$('.change_Address').removeClass("change_Address");
							    //$( "#user_view_addresses" ).trigger( "click" );
								$(".selected_Address").removeClass("selected_Address");
								
								//선택
								$(e.target).parent($("address")).addClass("selected_Address");
								$(".selected_Address>input[name=address_name]").css("background","#0f99f3");
								$(".selected_Address>input[name=address_name]").css("color","#fff");
								$(".selected_Address>input[name=address_range]").attr("disabled",false);
								//$(".selected_Address>input[name=address_range]").val(3);
								//$(".selected_Address>.range_val").text(3);
						    }
					});
				//}
				e.preventDefault();
			});
		 
			 /****************update_address_range******************/
			$(document).on('change', "[type='range']",function(e) {
				
				var selectedAddress = $(e.target).parent($("address"));
				selectedAddress.addClass("change_Address");
				
				$.ajax({
					url : 'user_update_address_range_json',
					method : 'POST',
					data: $(".change_Address > *").serialize(),
					dataType : 'json',
					success : function(jsonResult) {
						    console.log(jsonResult);
						    $('.change_Address').removeClass("change_Address");
						    $( "#user_view_addresses" ).trigger( "click" );
					    }
				});
				e.preventDefault();
			});
			 /****************user_insert_addresses******************/
			//(Step_1) Getting a address
			$(document).on('click',	'#btn_address_new1,#btn_address_new2',function(e) {
				var selectedAddress = $(e.target).parent($("address"));
				selectedAddress.addClass("selected_address");
				$(e.target).addClass("selected");
		    /**********************************************************/
		    	// 주소-좌표 변환 객체를 생성합니다
		    	var geocoder = new kakao.maps.services.Geocoder();
				// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
				if (navigator.geolocation) {
				    // ***GeoLocation을 이용해서 접속 위치를 얻어옵니다
				    navigator.geolocation.getCurrentPosition(function(position) {
				        var lat = position.coords.latitude, // 위도
				            lon = position.coords.longitude; // 경도
				        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
				            message = '여기에 계신가요?!'; // 인포윈도우에 표시될 내용입니다
				            console.log("locPosition: "+locPosition.getLat(),locPosition.getLng());
				            console.log(message);
							/*좌표->주소 변환*********************************************************/
							 searchDetailAddrFromCoords(locPosition, function(result, status) {
							 if (status === kakao.maps.services.Status.OK) {
							    	//console.log('도로명주소 : ' + result[0].road_address.address_name);
							    	//console.log('지번 주소 : ' + result[0].address.address_name);
							            //var detailAddr = !!result[0].road_address ? result[0].road_address.address_name  : '';
							            var detailAddr = result[0].address.address_name;
							           		//주소를 동까지만 자릅니다.
							           		subStr = detailAddr.lastIndexOf(" ");
							           		detailAddr=detailAddr.substring(0,subStr);
											$(".selected_address > input[name=address_name] ").val(detailAddr);
											$(".selected_address > input[name=address_lat] ").val(lat);
											$(".selected_address > input[name=address_lng] ").val(lon);
											confirm("[ "+detailAddr+"] "+message);
											$.ajax({
												url : 'user_insert_address_json',
												method : 'POST',
												data: $(".selected_address > *").serialize(),
												dataType : 'json',
												success : function(jsonResult) {
													    console.log(jsonResult);
													    if(jsonResult.code==0) alert("동일한 주소는 1개만 등록가능합니다.");
													    $( "#user_view_addresses" ).trigger( "click" );
												    }
											});
							        }
							 });
							/**********************************************************/
				      });
				} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
				    //var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
				        message = 'geolocation을 사용할수 없어요..'
			        	$("._selected").val(message);
				}
			/**********************************************************/
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
				e.preventDefault();
			});
			
			//(Step_2) update & insert
			/*
			$(document).on('click',	'.selected',function(e) {
				
				console.log($(".selected_address > *").serialize());
				
				if($(e.target).hasClass('update')){
				    $.ajax({
						url : 'user_update_address_json',
						method : 'POST',
						data: $(".selected_address > *").serialize(),
						dataType : 'json',
						success : function(jsonResult) {
							    console.log(jsonResult);
							    if(jsonResult.code==0) alert("동일한 주소는 1개만 등록가능합니다.");
							    $( "#user_view_addresses" ).trigger( "click" );
							    /*
								$(".selected_address > input[name=address_name]").attr("disabled",true);
								$(".selected_address").removeClass("selected_address");
								$(e.target).removeClass("selected");
								$(e.target).html("주소 수정");
						    }
					});
				}else if ($(e.target).hasClass('insert')) {
					console.log($("._selected").find("input[name=address_name]"));
				    $.ajax({
						url : 'user_insert_address_json',
						method : 'POST',
						data: $(".selected_address > *").serialize(),
						dataType : 'json',
						success : function(jsonResult) {
							    console.log(jsonResult);
							    if(jsonResult.code==0) alert("동일한 주소는 1개만 등록가능합니다.");
							    $( "#user_view_addresses" ).trigger( "click" );
						    }
					});
				}
			});
		*/
			/* Send_Mail********************************/
			$(document).on('click', '#btn_invi', function(e) {
				console.log($("#invi_email").val());
				$.ajax({
					url : 'springMail',
					method : 'POST',
					data:{
						"invi_email":$("#invi_email").val()
					},
					beforeSend:function(e){
						//수정필요
						$('.form-group').append("<div class='progress'><div class='progress-bar progress-bar-striped progress-bar-animated' role='progressbar' aria-valuenow='75' aria-valuemin='0' aria-valuemax='100' style='width: 75%'></div></div>");
					},
					success : function(e) {
						console.log("success");
						$('.progress').remove();
						alert($("#invi_email").val()+" 님에게 초대장이 전송되었습니다.");
						$("#invi_email").val("");
					}
				});
	
				e.preventDefault();
			});
			/*******************************************/
			
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
   		<!-- include_common_bottom.jsp start-->
		<jsp:include page="common/include_common_header.jsp"/>
		<!-- include_common_bottom.jsp end-->
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
							<li class="active"><a href="user_my_account">마이페이지</a></li>
							<li><a href="order-list.html">Orders</a></li>
							<li><a href="" id="user_view_addresses">내 동네설정</a></li>
							<li class="active"><a href="#" id="user_account_details">Account Details</a></li>
							<li><a href="user_logout_action">Logout</a></li>
						</ul>
					</div>
				</div>
				<div class="col-12 col-lg-9">
		<!-- START!! ************************************************ -->
					<div id="my-account-content" class="my-account-content mb-50" style="margin-bottom: 20px">
						<div class="shortcodes_content mb-100" style="margin-bottom: 0px">
						<p>
							<strong>${sUser.user_id}</strong>님, 안녕하세요? (<strong>${sUser.user_id}</strong>님이 아니신가요?
							<a href="user_logout_action">Log out</a>)
						</p>
						<p>
							From your account dashboard you can view your recent orders,
							manage your shipping and billing addresses, and <a href="account-details.html" id="a_account_details">edit your password and account
								details</a>.
						</p>
						</div>
	                    <div class="shortcodes_content mb-100" style="margin-bottom: 20px">
	                        <form class="invi_form">
	                            <div class="form-group">
	                                <label for="invi_email">흙당근마켓에 친구를 초대해보세요!</label>
	                                <input type="email" class="form-control" id="invi_email" name="invi_email" aria-describedby="emailHelp" placeholder="Enter email">
	                                <small id="emailHelp" class="form-text text-muted">초대받은 친구가 회원가입시, 500point를 드립니다!.</small>
	                            </div>
	                        </form>
	                        <button type="submit" class="btn btn-primary" id="btn_invi">Submit</button>
						</div>
                    </div>
		<!-- END!! ************************************************** -->
				</div>
			</div>
		</div>
	</section>
	<!-- My Account Area -->

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
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/default/active.js"></script>

</body>

</html>