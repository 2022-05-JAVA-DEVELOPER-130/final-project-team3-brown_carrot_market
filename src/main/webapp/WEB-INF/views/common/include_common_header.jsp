<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<header class="header_area">
 <!-- Top Header Area -->
        <div class="top-header-area">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-6">
                        <div class="welcome-note">
                            <span class="popover--text" data-toggle="popover" data-content="동네 주민들과 가깝고 따뜻한 거래를 지금 경험해보세요."><i class="icofont-info-square"></i></span>
                            <span class="text">동네 주민들과 가깝고 따뜻한 거래를 지금 경험해보세요.</span>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="language-currency-dropdown d-flex align-items-center justify-content-end">
                            <!-- Language Dropdown -->
                            <div class="language-dropdown">
                                <div class="dropdown">
                                    <a class="btn btn-sm dropdown-toggle" href="#" role="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Korean
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                        <a class="dropdown-item" href="#">English</a>
                                    </div>
                                </div>
                            </div>

                            <!-- Currency Dropdown -->
                            <div class="currency-dropdown">
                                <div class="dropdown">
                                    <a class="btn btn-sm dropdown-toggle" href="#" role="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        ₩ KRW
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
                                        <a class="dropdown-item" href="#">$ USD</a>
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
                        <a href="main" class="nav-brand"><img src="img/core-img/logo.png" alt="logo"></a>

                        <!-- Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">
                            <!-- Close -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav -->
                            <div class="classynav">
                                <ul>
                                    <!-- <li><a href="#">Home</a></li> -->
                                    <li><a href="shop-list-left-sidebar.html">중고거래</a>
                                        <ul class="dropdown">
                                            <li><a href="shop-list-left-sidebar.html">product_list</a></li>
                                            <li><a href="product-details.html"></a>product-details</li>
                                        </ul>
                                    </li>
                                    <li><a href="#">동네생활</a>
                                        <div class="megamenu">
                                            <ul class="single-mega cn-col-4">
                                                <li><a href="single-blog.html">- 동네소식</a></li>
                                                <li><a href="single-blog.html">- 같이해요</a></li>
                                                <li><a href="single-blog.html">- 동네질문</a></li>
                                                <li><a href="single-blog.html">- 동네맛집</a></li>
                                                <li><a href="single-blog.html">- 취미생활</a></li>
                                                <li><a href="single-blog.html">- 일상</a></li>
                                            </ul>
                                            <ul class="single-mega cn-col-4">
                                                <li><a href="#">- 분실/실종센터</a></li>
                                                <li><a href="#">- 동네사건사고</a></li>
                                                <li><a href="#">- 해주세요</a></li>
                                                <li><a href="#">- 동네사진전</a></li>
                                                <li><a href="#"></a></li>
                                                <li><a href="contact.html">Contact</a></li>
                                            </ul>
                                            <div class="single-mega cn-col-2">
                                                <div class="megamenu-slides owl-carousel">
                                                    <a href="shop-grid-left-sidebar.html">
                                                        <img src="img/bg-img/mega-slide-2.jpg" alt="">
                                                    </a>
                                                    <a href="shop-list-left-sidebar.html">
                                                        <img src="img/bg-img/mega-slide-1.jpg" alt="">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="#">흙당근페이</a>
                                        <ul class="dropdown">
                                            <li><a href="checkout-4.html">충전하기</a></li>
                                            <li><a href="#">송금하기</a></li>
                                            <li><a href="product-details.html">페이내역</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">자주하는질문</a></li>
                                    <li><a href="contact.html">공지사항</a></li>
                                </ul>
                            </div>
                        </div>

                        <!-- Hero Meta -->
                        <div class="hero_meta_area ml-auto d-flex align-items-center justify-content-end">
                            <!-- Search -->
                            <div class="search-area">
                                <div class="search-btn"><i class="icofont-search"></i></div>
                                <!-- Form -->
                                <div class="search-form">
                                    <input type="search" class="form-control" placeholder="Search">
                                    <input type="submit" class="d-none" value="Send">
                                </div>
                            </div>

                            <!-- Wishlist -->
                            <div class="wishlist-area">
                                <a href="wishlist.html" class="wishlist-btn"><i class="icofont-heart"></i></a>
                            </div>
                            
                            <!-- transaction list -->
                            <div class="transaction-list wishlist-area">
                                <a href="wishlist.html" class="wishlist-btn"><i class="icofont-bag"></i></a>
                            </div>

                            <!-- Cart -->
                            <div class="cart-area">
                                <div class="cart--btn"><i class="icofont-chat"></i> <span class="cart_quantity">2</span></div>

                                <!-- Cart Dropdown Content -->
                                <div class="cart-dropdown-content">
                                    <ul class="cart-list">
                                        <li>
                                            <div class="cart-item-desc">
                                                <a href="#" class="image">
                                                    <img src="img/product-img/top-1.png" class="cart-thumb" alt="">
                                                </a>
                                                <div>
                                                    <a href="#">Kid's Fashion</a>
                                                    <p>1 x - <span class="price">$32.99</span></p>
                                                </div>
                                            </div>
                                            <span class="dropdown-product-remove"><i class="icofont-bin"></i></span>
                                        </li>
                                        <li>
                                            <div class="cart-item-desc">
                                                <a href="#" class="image">
                                                    <img src="img/product-img/best-4.png" class="cart-thumb" alt="">
                                                </a>
                                                <div>
                                                    <a href="#">Headphone</a>
                                                    <p>2x - <span class="price">$49.99</span></p>
                                                </div>
                                            </div>
                                            <span class="dropdown-product-remove"><i class="icofont-bin"></i></span>
                                        </li>
                                    </ul>
                                    <div class="cart-pricing my-4">
                                        <ul>
                                            <li>
                                                <span>Sub Total:</span>
                                                <span>$822.96</span>
                                            </li>
                                            <li>
                                                <span>Shipping:</span>
                                                <span>$30.00</span>
                                            </li>
                                            <li>
                                                <span>Total:</span>
                                                <span>$856.63</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="cart-box">
                                        <a href="checkout-1.html" class="btn btn-primary d-block">Checkout</a>
                                    </div>
                                </div>
                            </div>
<!-- [nav] Account Start!!!!! **************************************** -->
                            <!-- Account -->
                            <div class="account-area">
                                <div class="user-thumbnail">
                                    <img src="img/user_profile/admin.png" alt="img/bg-img/user.jpg">
                                </div>
                                <ul class="user-meta-dropdown">
                                    <li class="user-title"><span>Hello,</span> Lim Sarah</li>
                                    <li><a href="my-account.html">My Account</a></li>
                                    <li><a href="chat_room">Chatting</a></li>
                                    <li><a href="login.html"><i class="icofont-logout"></i> 로그아웃</a></li>
                                </ul>
                            </div>
<!-- [nav] Account END!!!!! **************************************** -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
</header>