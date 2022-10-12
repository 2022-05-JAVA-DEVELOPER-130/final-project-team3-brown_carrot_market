<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>










<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약속 잡기</title>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
	
	
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.kr.min.js"></script>

<!-- 지도scipt -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a7c7231db91ae56cfc5e3c6ea06f73c6&libraries=services,clusterer,drawing"></script>

<!-- 내 js -->
<script src="js/chat/chat_appointment.js"></script>



</head>
<body>
   <form id="chatAppDateTimeSpot">
	<div>
		<label>약속 날짜</label> <input type="text" id="datePicker">
	</div>
	
	<br>
	
	<div>
	<label>약속 시간</label> 
	<form>
  <p><input type="time" id="chatAppTime"></p>
</form>
	</div>
	
	<br>
	
	<div>
	<label>약속 장소</label> 
	<input type="text" id="searchChatAppSpot" placeholder="장소를 입력하세요" >
	<button type="button" id="btnChatAppSpot">장소 찾기</button>
	</div>
	<div id="map" style="width:300px;height:300px;"></div>
	
	
	<input type="hidden" id="chatApp_lat" value=""/>
	<input type="hidden" id="chatApp_lng" value=""/>
	</form>
	<button type="button" id="chatAppFinalSubmit">약속 잡기!</button>
</body>
</html>