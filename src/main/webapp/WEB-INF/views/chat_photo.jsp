<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채팅 사진 전송</title>
</head>
<body>
<h3>채팅 이미지 전송</h3>
<form action="upload" method="post"
		enctype="multipart/form-data">
		사진1: <input type="file" name="files"><br> 
		사진2: <input type="file" name="files"><br> 
		
		설명:
		<textarea name="description" cols="50" rows="3"></textarea>
		<br> <input type="submit" value="전송하기"><br>
	</form>
	
</body>
</html>