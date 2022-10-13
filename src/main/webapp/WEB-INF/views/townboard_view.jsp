<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
    <link rel="stylesheet" href="css/townBoard.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.min.css">
	<!-- toast -->
 	<link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>

	
	
	
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="spinner-grow" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>

    <!-- Header Area -->
   		<!-- include_common_header.jsp start-->
			<jsp:include page="common/include_common_header.jsp"/>
		<!-- include_common_header.jsp end-->
    <!-- Header Area End -->
    
    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>게시글 상세보기</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active">Blog Details</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->

    <!-- Single Blog Post Area -->
    <section class="singl-blog-post-area section_padding_100_50">
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-4">
                    <div class="blog_sidebar">
                    
                     <!-- Catagory -->
                    
                        <div class="widget-area catagory_section mb-30">
                        <div id = "category_list">
                            <h6>Catagory</h6>
                            <ul>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no1" value=1>
	                              <a href="#" onclick="changeQnaList(1,1)">동네생활 <span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no2" value=2>
	                              <a href="#" onclick="changeQnaList(1,2)">같이해요<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no3" value=3>
	                              <a href="#" onclick="changeQnaList(1,3)">동네질문<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no4" value=4>
	                              <a href="#" onclick="changeQnaList(1,4)">동네맛집<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no5" value=5>
	                              <a href="#" onclick="changeQnaList(1,5)">취미생활<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no6" value=6>
	                              <a href="#" onclick="changeQnaList(1,6)">일상<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no7" value=7>
	                              <a href="#" onclick="changeQnaList(1,7)">분실/실종센터<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no8" value=8>
	                              <a href="#" onclick="changeQnaList(1,8)">동네사건사고<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no9" value=9>
	                              <a href="#" onclick="changeQnaList(1,9)">해주세요<span class="text-muted">(21)</span></a>
                              </li>
                              <li>
	                              <input type="hidden" class="townBoardCtgrNo" name="t_ctgr_no10" value=10>
	                              <a href="#" onclick="changeQnaList(1,10)"s>동네사진전<span class="text-muted">(21)</span></a>
                              </li>
                                
                               
                            </ul>
                        </div>
                    </div>
                    
                        

                        <!-- Latest Post -->
                        <div class="widget-area latest_post mb-30">
                            <h6>인기글</h6>

                            <!-- Recent Post1 -->
                            
                           	<c:forEach var="townBoard" items="${townBoardList.itemList}" begin="0" end="2">
	                            <div class="single_latest_post">
	                            
	                                <div class="post-thumbnail">
	                                <c:if test="${townBoard.townImageList.size() != 0}">
	                                    <img src="img/townBoard-img/${townBoard.townImageList[0].t_img_name}" alt="blog-post-thumb">
	                                	</c:if>
	                                </div>
	                                <div class="post-content">
	                                    <a href="#">${townBoard.t_title }</a>
	                                    <p>${townBoard.t_count }</p>
	                                </div>
	                            </div>
                            </c:forEach>
                             

                            <!-- Recent Post2 -->
                            <!-- 
                            <div class="single_latest_post">
                                <div class="post-thumbnail">
                                    <img src="img/bg-img/lp-2.jpg" alt="">
                                </div>
                                <div class="post-content">
                                    <a href="#">7 Quick Ways to Make a Great Event Successful</a>
                                    <p>5 min ago</p>
                                </div>
                            </div>
							 -->
                        
                        
                    </div>
                    
                    <!-- Search Post -->
                        <div class="widget-area search_post mb-30">
                            <h6>Search Post</h6>
                            <form action="#" method="get">
                                <input type="search" class="form-control" placeholder="Enter Keyword...">
                                <button type="submit" class="btn d-none">Submit</button>
                            </form>
                        </div>
                    
                    
                    
                </div>
                </div>
                
                
                <div class="col-12 col-lg-8">
                
                
                
                    <!-- Blog Details Area -->
                    <div id = "townBoard_list_tbody_all">
                    <div class="blog-details-area mb-50" id="townBoard_list_tbody">                        
                        <!-- Image -->
                        <img class="mb-30" src="img/townBoard-img/${townBoard.townImageList[0].t_img_name}" alt="blog-img">
                        <img class="mb-30" src="img/townBoard-img/${townImage.t_img_name}" alt="blog-img">
                        
                        <!-- Blog Title -->
                        <h3 class="mb-30">${townBoard.t_title}</h3>
                        
                        <!-- Bar Area -->
                        <div class="status-bar mb-15">
                            <a href="#"><i class="icofont-user-male"></i> ${townBoard.userInfo.user_id }</a>
                            <a href="#"><i class="icofont-ui-clock"></i> ${townBoard.t_date }</a>
                            <a href="#"><i class="icofont-speech-comments"></i> 3 Comments</a>
                           <input class="townBoard_i delete" type="button" pageno="${pageno}" t_no=${townBoard.t_no} value="삭제하기" />
                           
                        </div>

                        <!-- Single Blog Details Area -->
                        <p class = "">${townBoard.t_content}</p>
                    </div>

                    <div class="comments-area">
                        <div class="comment_area mb-50 clearfix">
                            <h5 class="mb-4">3 Comments</h5>
                            
                            <ol>
                                <!-- Single Comment Area -->
                                <li class="single_comment_area">
                                    <div class="comment-wrapper clearfix">
                                        <div class="comment-meta">
                                            <div class="comment-author-img">
                                                <img class="img-circle" src="img/partner-img/tes-1.png" alt="">
                                            </div>
                                        </div>
                                        <div class="comment-content">
                                            <h5 class="comment-author"><a href="#">${'새주' }</a></h5>
                                            <p>This post is very helpful. I like your fashion tips. Keep up awesome job!</p>
                                            <a href="#" class="reply">Reply</a>
                                        </div>
                                    </div>
                                    <ul class="children">
                                        <li class="single_comment_area">
                                            <div class="comment-wrapper clearfix">
                                                <div class="comment-meta">
                                                    <div class="comment-author-img">
                                                        <img class="img-circle" src="img/partner-img/tes-2.png" alt="">
                                                    </div>
                                                </div>
                                                <div class="comment-content">
                                                    <h5 class="comment-author"><a href="#">Nazrul Islam</a></h5>
                                                    <p>Thanks for your valuable feedback @Lim Jannat. Stay with us.</p>
                                                    <a href="#" class="reply">Reply</a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </li>

                                <li class="single_comment_area">
                                    <div class="comment-wrapper d-flex clearfix">
                                        <div class="comment-meta">
                                            <div class="comment-author-img">
                                                <img class="img-circle" src="img/partner-img/tes-3.png" alt="">
                                            </div>
                                        </div>
                                        <div class="comment-content">
                                            <h5 class="comment-author"><a href="#">Naznin Ritu</a></h5>
                                            <p>Great post about treanding fashion 2019. Thank you.</p>
                                            <a href="#" class="reply">Reply</a>
                                        </div>
                                    </div>
                                    <ul class="children">
                                        <li class="single_comment_area">
                                            <div class="comment-wrapper clearfix">
                                                <div class="comment-meta">
                                                    <div class="comment-author-img">
                                                        <img class="img-circle" src="img/partner-img/tes-2.png" alt="">
                                                    </div>
                                                </div>
                                                <div class="comment-content">
                                                    <h5 class="comment-author"><a href="#">Nazrul Islam</a></h5>
                                                    <p>Thanks for your valuable feedback @Naznin Ritu, Stay with us.</p>
                                                    <a href="#" class="reply">Reply</a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ol>
                        </div>

                        <div class="contact_from mb-50">
                            <h5 class="mb-4">Leave a Comment</h5>

                            <form action="#" method="post">
                                <div class="row">
                                    <div class="col-12 col-lg-6">
                                        <div class="form-group mb-30">
                                            <input type="text" class="form-control" name="author" value="" placeholder="Name" tabindex="1">
                                        </div>
                                    </div>
                                    <div class="col-12 col-lg-6">
                                        <div class="form-group mb-30">
                                            <input type="text" class="form-control" name="email" value="" placeholder="Email" tabindex="2">
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-group mb-30">
                                            <input type="text" class="form-control" name="url" value="" placeholder="Website (Optional)" tabindex="3">
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-group mb-30">
                                            <textarea class="form-control" name="comment" cols="30" rows="7" placeholder="Comment" tabindex="4"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <button class="btn btn-primary" type="submit">Submit Comment</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                ////댓글까지 끝
				</div>
                
            </div> ///내용끝
        </div>
    </section>
    <!-- Single Blog Post Area -->

    <!-- Footer Area -->
    	<!-- include_common_bottom.jsp start-->
			<jsp:include page="common/include_common_footer.jsp"/>
		<!-- include_common_bottom.jsp end-->
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    
	
	<!-- javaScript -->
	<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->
	
	
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
    
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.all.min.js"></script>
    
    <script src="js/townBoard/townBoard.js"></script>
    <script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/user_session_check.js"></script>

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


</body>

</html>