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
    <title>자주 하는 질문</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">
    
    <!-- javaScript -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/user_session_check.js"></script>
	
    
    <!-- toast -->
 <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>  
	

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

    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>자주 하는 질문</h5>
                    <ol class="breadcrumb">
                        <!-- <li class="breadcrumb-item"><a href="index.html">Home</a></li> -->
                        <li class="breadcrumb-item active">사용자들이 자주 묻는 질문을 확인해보세요.</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->

    <!-- Shortcodes Area -->
    <div class="shortcodes_area section_padding_100">
        <div class="container">
            <!-- Shortcodes Content -->
            <div class="row">
                <div class="col-12">
                    <!-- Shortcodes Title -->
                    <div class="shortcodes_title mb-30">
                        <h5>구매/판매</h5>
                    </div>

                    <!-- +++++++++++++++++++++++
                    Bigshop Accordian With Icon
                    +++++++++++++++++++++++ -->
                    <div class="shortcodes_content mb-100">
                        <div class="accordion bigshop-accordian-with-icon" id="bigshopAccordianIcon">
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian1">
                                    <button class="btn" type="button" data-toggle="collapse" data-target="#bswicollapseOne" aria-expanded="true" aria-controls="bswicollapseOne">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 당근마켓에서 믿고 거래하세요 <i class="fa fa-handshake-o"></i>
                                    </button>
                                </div>

                                <div id="bswicollapseOne" class="collapse show" aria-labelledby="bigshopWithIconAccordian1" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-home"></i> 동네인증한 사용자만 거래해요</div> <br> 우리 동네에서 거래하려면 동네 인증이 필요해요. 동네인증은 해당 동네에 있어야만 할 수 있어요.<br> GPS로 우리 동네를 인증한 당신 근처의 이웃들과 거래하세요.</p>
                                        <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-commenting-o"></i> 1:1 당근채팅으로 대화해요</div> <br> 흙당근마켓 내의 채팅을 통해 거래하는 게 가장 안전해요. 당근채팅에서는 메세지 전송뿐만 아니라 사진도 주고 받고, 약속을 잡을 수도 있어요.</p>
                                   		 <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-map-pin"></i> 당신 근처에서 만나요</div> <br> 중고거래 사기의 대부분은 택배거래에서 발생한다는 사실, 알고 계셨나요? 근처 이웃들과 사고 파는 흙당근마켓에서는 직거래를 권장하고 있어요. 직거래할 때는 누구나 찾기 쉽고 안전한 공공장소가 좋아요. 이웃과 따뜻하게 거래하세요.</p>
                                        <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-thermometer"></i> 매너온도를 확인하세요</div> <br> 거래하기 전 매너온도를 확인하세요. 온도는 36.5도에서 시작해서 99도까지 올라갈 수 있어요. 신뢰할 수 있는 이웃은 매너온도도 높답니다.</p>
                                   
                                   
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian2">
                                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#bswicollapseTwo" aria-expanded="false" aria-controls="bswicollapseTwo">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 어떻게 판매하나요? (판매 방법)
                                    </button>
                                </div>
                                <div id="bswicollapseTwo" class="collapse" aria-labelledby="bigshopWithIconAccordian2" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian3">
                                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#bswicollapseThree" aria-expanded="false" aria-controls="bswicollapseThree">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 어떻게 구매하나요? (구매 방법)
                                    </button>
                                </div>
                                <div id="bswicollapseThree" class="collapse" aria-labelledby="bigshopWithIconAccordian3" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">흙당근마켓에서 사고 싶은 물건을 발견했나요? 구매하는 방법은 간단해요!<br><br> 게시글 하단 [채팅으로 거래하기] 버튼을 눌러보세요. 판매자와 채팅을 할 수 있어요. 구매 전에 궁금한 것이 있다면 직접 물어볼 수도 있어요.
                                        <br>거래 방법은 크게 두 가지가 있어요. <br><br> 첫 번째, 직거래 <br> 직거래할 경우 거래 약속 시간과 장소를 정해야 해요. 채팅방에서 [약속하기] 기능을 통해 시간과 장소를 정해보세요! 약속 시간 1시간 전에 판매자와 사용자에게 알림을 보내주고 있어요.
                                        <br> 직접 만나 물건을 확인한 뒤 거래가 성사되면 현금을 전달하거나, 계좌이체 해주시면 돼요.<br> 채팅방의 [당근페이]를 이용하면 상대방에게 보다 편리하게 송금할 수 있어요.
                                        <br><br>두 번째, 택배 거래 <br> 택배 거래할 경우 보통 입금이 먼저 진행돼요. 입금이 확인되면 판매자가 택배를 보낼 거예요. <br> 다만 택배 거래의 경우 중고거래 특성상 사기 피해가 발생할 수 있으니 유의해주세요. </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- +++++++++++++++++++++++
                    Bigshop Accordian With Icon
                    +++++++++++++++++++++++ -->
                    
                      <!-- Shortcodes Area -->
    <div class="shortcodes_area section_padding_100">
        <div class="container">
            <!-- Shortcodes Content -->
            <div class="row">
                <div class="col-12">
                    <!-- Shortcodes Title -->
                    <div class="shortcodes_title mb-30">
                        <h5>동네생활</h5>
                    </div>

                    <!-- +++++++++++++++++++++++
                    Bigshop Accordian With Icon
                    +++++++++++++++++++++++ -->
                    <div class="shortcodes_content mb-100">
                        <div class="accordion bigshop-accordian-with-icon" id="bigshopAccordianIcon">
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian1">
                                    <button class="btn" type="button" data-toggle="collapse" data-target="#bswicollapseOne" aria-expanded="true" aria-controls="bswicollapseOne">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 당근마켓에서 믿고 거래하세요 <i class="fa fa-handshake-o"></i>
                                    </button>
                                </div>

                                <div id="bswicollapseOne" class="collapse show" aria-labelledby="bigshopWithIconAccordian1" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-home"></i> 동네인증한 사용자만 거래해요</div> <br> 우리 동네에서 거래하려면 동네 인증이 필요해요. 동네인증은 해당 동네에 있어야만 할 수 있어요.<br> GPS로 우리 동네를 인증한 당신 근처의 이웃들과 거래하세요.</p>
                                        <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-commenting-o"></i> 1:1 당근채팅으로 대화해요</div> <br> 흙당근마켓 내의 채팅을 통해 거래하는 게 가장 안전해요. 당근채팅에서는 메세지 전송뿐만 아니라 사진도 주고 받고, 약속을 잡을 수도 있어요.</p>
                                   		 <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-map-pin"></i> 당신 근처에서 만나요</div> <br> 중고거래 사기의 대부분은 택배거래에서 발생한다는 사실, 알고 계셨나요? 근처 이웃들과 사고 파는 흙당근마켓에서는 직거래를 권장하고 있어요. 직거래할 때는 누구나 찾기 쉽고 안전한 공공장소가 좋아요. 이웃과 따뜻하게 거래하세요.</p>
                                        <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-thermometer"></i> 매너온도를 확인하세요</div> <br> 거래하기 전 매너온도를 확인하세요. 온도는 36.5도에서 시작해서 99도까지 올라갈 수 있어요. 신뢰할 수 있는 이웃은 매너온도도 높답니다.</p>
                                   
                                   
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian2">
                                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#bswicollapseTwo" aria-expanded="false" aria-controls="bswicollapseTwo">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 어떻게 판매하나요? (판매 방법)
                                    </button>
                                </div>
                                <div id="bswicollapseTwo" class="collapse" aria-labelledby="bigshopWithIconAccordian2" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian3">
                                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#bswicollapseThree" aria-expanded="false" aria-controls="bswicollapseThree">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 어떻게 구매하나요? (구매 방법)
                                    </button>
                                </div>
                                <div id="bswicollapseThree" class="collapse" aria-labelledby="bigshopWithIconAccordian3" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0"> </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- +++++++++++++++++++++++
                    Bigshop Accordian With Icon
                    +++++++++++++++++++++++ -->
                    
                      <!-- Shortcodes Area -->
    <div class="shortcodes_area section_padding_100">
        <div class="container">
            <!-- Shortcodes Content -->
            <div class="row">
                <div class="col-12">
                    <!-- Shortcodes Title -->
                    <div class="shortcodes_title mb-30">
                        <h5>당근페이</h5>
                    </div>

                    <!-- +++++++++++++++++++++++
                    Bigshop Accordian With Icon
                    +++++++++++++++++++++++ -->
                    <div class="shortcodes_content mb-100">
                        <div class="accordion bigshop-accordian-with-icon" id="bigshopAccordianIcon">
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian1">
                                    <button class="btn" type="button" data-toggle="collapse" data-target="#bswicollapseOne" aria-expanded="true" aria-controls="bswicollapseOne">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 당근마켓에서 믿고 거래하세요 <i class="fa fa-handshake-o"></i>
                                    </button>
                                </div>

                                <div id="bswicollapseOne" class="collapse show" aria-labelledby="bigshopWithIconAccordian1" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-home"></i> 동네인증한 사용자만 거래해요</div> <br> 우리 동네에서 거래하려면 동네 인증이 필요해요. 동네인증은 해당 동네에 있어야만 할 수 있어요.<br> GPS로 우리 동네를 인증한 당신 근처의 이웃들과 거래하세요.</p>
                                        <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-commenting-o"></i> 1:1 당근채팅으로 대화해요</div> <br> 흙당근마켓 내의 채팅을 통해 거래하는 게 가장 안전해요. 당근채팅에서는 메세지 전송뿐만 아니라 사진도 주고 받고, 약속을 잡을 수도 있어요.</p>
                                   		 <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-map-pin"></i> 당신 근처에서 만나요</div> <br> 중고거래 사기의 대부분은 택배거래에서 발생한다는 사실, 알고 계셨나요? 근처 이웃들과 사고 파는 흙당근마켓에서는 직거래를 권장하고 있어요. 직거래할 때는 누구나 찾기 쉽고 안전한 공공장소가 좋아요. 이웃과 따뜻하게 거래하세요.</p>
                                        <br>
                                        <p class="mb-0">   <div style="font-weight:900;"><i class="fa fa-thermometer"></i> 매너온도를 확인하세요</div> <br> 거래하기 전 매너온도를 확인하세요. 온도는 36.5도에서 시작해서 99도까지 올라갈 수 있어요. 신뢰할 수 있는 이웃은 매너온도도 높답니다.</p>
                                   
                                   
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian2">
                                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#bswicollapseTwo" aria-expanded="false" aria-controls="bswicollapseTwo">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 어떻게 판매하나요? (판매 방법)
                                    </button>
                                </div>
                                <div id="bswicollapseTwo" class="collapse" aria-labelledby="bigshopWithIconAccordian2" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="bigshopWithIconAccordian3">
                                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#bswicollapseThree" aria-expanded="false" aria-controls="bswicollapseThree">
                                        <i class="icofont-rounded-up"></i><i class="icofont-rounded-down"></i> 어떻게 구매하나요? (구매 방법)
                                    </button>
                                </div>
                                <div id="bswicollapseThree" class="collapse" aria-labelledby="bigshopWithIconAccordian3" data-parent="#bigshopAccordianIcon">
                                    <div class="card-body">
                                        <p class="mb-0">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- +++++++++++++++++++++++
                    Bigshop Accordian With Icon
                    +++++++++++++++++++++++ -->

                </div>
            </div>
        </div>
    </div>
    <!-- Shortcodes Area End -->

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
                            <li><a href="#"><i class="icofont-rounded-right"></i> Your Account</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Free Shipping Policy</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Your Cart</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Return Policy</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Free Coupon</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Delivary Info</a></li>
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
                            <li><a href="#"><i class="icofont-rounded-right"></i> Product Support</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Terms &amp; Conditions</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Help</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Payment Method</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Affiliate Program</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Privacy Policy</a></li>
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
                            <li><a href="#"><i class="icofont-rounded-right"></i> Payment Method</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Help</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Product Support</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Terms &amp; Conditions</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Privacy Policy</a></li>
                            <li><a href="#"><i class="icofont-rounded-right"></i> Affiliate Program</a></li>
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
                                <input type="email" name="mail" class="form-control mail" placeholder="Your E-mail Addrees">
                                <button type="submit" class="submit"><i class="icofont-long-arrow-right"></i></button>
                            </form>
                        </div>
                    </div>
                    <div class="single_footer_area mb-100">
                        <div class="footer_heading mb-4">
                            <h6>Download our Mobile Apps</h6>
                        </div>
                        <div class="apps_download">
                            <a href="#"><img src="img/core-img/play-store.png" alt="Play Store"></a>
                            <a href="#"><img src="img/core-img/app-store.png" alt="Apple Store"></a>
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
                            <p>Made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="#">Designing World</a></p>
                        </div>
                    </div>
                    <!-- Payment Method -->
                    <div class="col-12 col-md-6">
                        <div class="payment_method">
                            <img src="img/payment-method/paypal.png" alt="">
                            <img src="img/payment-method/maestro.png" alt="">
                            <img src="img/payment-method/western-union.png" alt="">
                            <img src="img/payment-method/discover.png" alt="">
                            <img src="img/payment-method/american-express.png" alt="">
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