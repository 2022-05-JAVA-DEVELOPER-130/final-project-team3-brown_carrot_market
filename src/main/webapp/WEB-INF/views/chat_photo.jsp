<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채팅 사진 전송</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script src="js/chat/chat_photo.js"></script>

</head>
<body>
<h3>채팅 이미지 전송</h3>
<form action="upload" method="post"
		enctype="multipart/form-data" id="chat_image_form">
		사진: <input type="file" name="files" id="img_choose"><br> 
	
		<br> <input type="submit" value="전송하기" id="btnchatImgSubmit"><br>
	</form>
	
</body>
</html>