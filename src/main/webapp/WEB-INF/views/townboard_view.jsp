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
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.all.min.js"></script>
	
	<!-- javaScript -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/user/UserHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/CommonHtmlContents.js"></script>
	<script type="text/javascript" src="js/common/user_session_check.js"></script>
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
                    <div class="blog-details-area mb-50">                        
                        <!-- Image -->
                        <img class="mb-30" src="img/bg-img/blog-3.jpg" alt="blog-img">
                        
                        <!-- Blog Title -->
                        <h3 class="mb-30">Top 10 Handbags in 2019</h3>
                        
                        <!-- Bar Area -->
                        <div class="status-bar mb-15">
                            <a href="#"><i class="icofont-user-male"></i> Jannatun</a>
                            <a href="#"><i class="icofont-ui-clock"></i> 16 Sep, 19</a>
                            <a href="#"><i class="icofont-tags"></i> Handbags</a>
                            <a href="#"><i class="icofont-speech-comments"></i> 3 Comments</a>
                        </div>

                        <!-- Single Blog Details Area -->
                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae to vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt.ut labore et dolore magnam aliquam quaerat voluptatem.</p>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam qui, molestiae est, rerum molestias esse sunt eos odio provident quos nihil repellat iusto alias repellendus. Sapiente animi voluptatum laudantium molestiae vel voluptates atque nisi, possimus tempora dicta illum consectetur. Sint dolore voluptate, doloribus facere ea ratione dolorem, iusto reprehenderit repellendus ut labore! Corporis voluptatum perspiciatis neque, ipsa sapiente quibusdam culpa veniam nesciunt, dolore eos, ad omnis repellendus quia.</p>

                        <div class="row">
                            <div class="col-12 col-lg-7">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. In architecto rem omnis quia ipsa. Nulla sapiente aut illum error modi, repellendus temporibus non ipsum alias recusandae ex hic veritatis cum.</p>
                            </div>
                            <div class="col-12 col-lg-5">
                                <img class="mb-3" src="img/bg-img/blog-1.jpg" alt="">
                            </div>
                        </div>

                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae to vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.</p>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates officiis consectetur incidunt eveniet mollitia itaque tempore eius asperiores. Iste praesentium libero unde maiores, aspernatur numquam deserunt quisquam doloremque reprehenderit, hic ducimus fugit. Distinctio maxime harum ipsam sunt, voluptatem quod ut?</p>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias corporis itaque qui expedita eligendi error asperiores tempore voluptates officia. Cum inventore laborum ipsum eum harum? Obcaecati tenetur facere sint officiis voluptate quam quidem magnam quibusdam praesentium asperiores accusantium et sed reprehenderit animi, tempora unde necessitatibus ad ut accusamus repudiandae inventore hic, velit distinctio. Voluptatem, quo, nesciunt. Ipsam ducimus illo et nihil unde, non numquam tenetur est dicta eveniet iusto cum recusandae voluptatem hic tempora ad laborum quasi qui.</p>

                        <img class="mb-3" src="img/bg-img/blog-5.jpg" alt="">

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est veritatis, aspernatur amet modi et, atque, molestiae impedit facilis non aliquid adipisci perferendis eius quas saepe. Optio sapiente temporibus rerum, est quasi similique voluptatibus officia laudantium ducimus alias, deleniti repellat nesciunt repudiandae autem.</p>
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
                                            <h5 class="comment-author"><a href="#">Lim Jannat</a></h5>
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

                
            </div>
        </div>
    </section>
    <!-- Single Blog Post Area -->

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
    <script src="js/townBoard/townBoard.js"></script>

</body>

</html>