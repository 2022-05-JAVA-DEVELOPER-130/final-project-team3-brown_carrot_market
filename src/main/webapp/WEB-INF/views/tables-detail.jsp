<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- include_common_top -->
    
    <!-- include_common_top -->
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="forEunbi/common/board.css">

</head>

<body>
    <!-- Preloader -->
    <!-- 
    <div id="preloader">
        <div class="spinner-grow" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
 -->
    <!-- Header Area -->
  	<jsp:include page="common/include_common_header.jsp"/>
    <!-- Header Area End -->
    
    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>Board</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active">Board</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->

    <div class="shortcodes_area section_padding_100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="shortcodes_title mb-30">
                        <h4>공지사항 상세보기</h4>
                    </div>
                    <div class="shortcodes_content">
                        <div class="table-responsive">
                            <table class="table mb-0 table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col" class="board_title">${notice.notice_title}</th>
                                        <th scope="col" class="board_date">${notice.notice_date}</th>
                                        <th scope="col" class="board_writer">${notice.notice_count}</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td id="qna_content_td" colspan="3">${notice.notice_content}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    	<div id="qna_btn_container">
                    	<c:if test="${qna.m_id eq sM_id}">
							<input class="qna_btn update_form" type="button" pageno="${pageno}" q_no="${qna.q_no}" value="수정" />
							<input class="qna_btn delete" type="button" pageno="${pageno}" q_no="${qna.q_no}" value="삭제" />
                    	</c:if>
							<input class="qna_btn reply" type="button" pageno="${pageno}" q_no="${qna.q_no}" value="답글" />
							<input class="qna_btn list" type="button" pageno="${pageno}" value="목록" />
                    	</div>
                </div>
            </div>
            
         </div>
    </div>     
                      
    <!-- Footer Area -->
    
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="js/notice/board.js"></script>
	<script type="text/javascript">
		
	</script>

</body>

</html>