 var chatAppdate=null; 
 var chatApptime=null; 
 var chatAppLat=null; 
 var chatAppLng=null; 
  var detailAddr=null;
  var chatAppspot=null;
  var marker_org=null;
  
  $(document).ready(function(){
	
	
	$('#datePicker').datepicker({
	format:"yyyy-mm-dd",
	language:"kr",
	todayHighlight:true
	
});

$('#datePicker').on('change',function(){
	chatAppdate=$('#datePicker').val();
})



$('#chatAppTime').on('change',function(){
	chatApptime=$('#chatAppTime').val();
})


/***약속 장소 ******/

$('#btnChatAppSpot').click(function(e){
	    if($('#searchChatAppSpot').val()==""){
		alert("장소를 입력해주세요");
		return false;
	}
		e.preventDefault();
		e.stopPropagation();
		
		// 장소 검색 객체를 생성합니다
		
		searchKeyword=$('#searchChatAppSpot').val();
		console.log("장소검색>>>"+searchKeyword);
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

			// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 
// 키워드로 장소를 검색합니다
ps.keywordSearch(searchKeyword, placesSearchCB); 

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();
        for (var i=0; i<1; i++) {
                        bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
		displayMarker(data[0]);
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    	var markerImageUrl = "img/chat-img/logo_carrot.png",
		    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };

		// 마커 이미지를 생성한다
		markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
		
    marker_org = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x),
        image:markerImage
    }),infowindow = new kakao.maps.InfoWindow({zindex:1});
    
    chatAppLng=place.x;
    chatAppLat=place.y;
    
    
     infowindow.setContent('<div style="padding:5px;font-size:6px;color:orange;font-weight:bold;">' + place.place_name + '<br> ('+place.road_address_name+')</div>');
        infowindow.open(map, marker_org);
        
      chatAppspot=place.place_name+"("+place.road_address_name+")";

   
}


/*************************지도 클릭 이벤트 처리******************************/

var geocoder = new kakao.maps.services.Geocoder();


// 마커 이미지의 주소
		var markerImageUrl = "img/chat-img/logo_carrot.png",
		    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };

		// 마커 이미지를 생성한다
		markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
		marker = new kakao.maps.Marker({
		    position: map.getCenter() , // 마커의 좌표
		    draggable : false, // 마커를 드래그 가능하도록 설정한다
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
		}), // 클릭한 위치를 표시할 마커입니다
    infowindow = new kakao.maps.InfoWindow({zindex:2});

		marker.setMap(map);
		
			// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	     marker_org.setVisible(false);
	
	    
	     searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
			
			
			if(!!result[0].road_address){
			var buildingName=!!result[0].road_address.building_name?"("+result[0].road_address.building_name+")":"";
			
            detailAddr = !!result[0].road_address ? '<div style="padding:5px;color:orange; font-size:6pt; font-weight:bold;">' + result[0].road_address.address_name+" "+buildingName +'</div>' : '';
           	chatAppspot=result[0].road_address.address_name+" "+buildingName;
            }else{
				detailAddr = '<div style="padding:5px;color:orange; font-size:6pt; font-weight:bold; ">' + result[0].address.address_name + '</div>';
				chatAppspot=result[0].address.address_name;
			}
	
            var content = '<div class="bAddr">' +
                            
                            detailAddr + 
                        '</div>';

            // 마커를 클릭한 위치에 표시합니다 
            marker.setPosition(mouseEvent.latLng);
            marker.setMap(map);

            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
            infowindow.setContent(content);
            infowindow.open(map, marker);
            
            
            
            chatAppLat=mouseEvent.latLng.getLat();
            chatAppLng=mouseEvent.latLng.getLng();
            
             var message = '클릭한 위치의 위도는 ' + chatAppLat + ' 이고, ';
	    message += '경도는 ' + chatAppLng + ' 입니다';
	    
	    console.log(message);
        }   
    });
	
	    
	});
	
	function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}
	
});


/*******************약속 DB/socket 전송********************** */
$('#chatAppFinalSubmit').click(function(e){
	e.preventDefault();
	e.stopPropagation();
	
	  var f= $('#chatAppDateTimeSpot');
    //document.domain = "127.0.0.1"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
  /*  opener.name = "parentPage"; //유니크한 이름이어야 합니다.
    f.target = opener.name;*/
//window.opener.document.getElementById("chat_content_msg").value="약속이 잡혔어요!";



var jsonData={
	code:null,
	url:null,
	msg:null,
	your_id:null, // 상대 아이디 
	data:null //chat_contents 
	
};

jsonData.mId=window.opener.loginId;
jsonData.your_id=window.opener.yourId;
jsonData.msg="약속 전송";
jsonData.code="3";
jsonData.data=[{
			c_content_no:"",
			c_content:window.opener.loginId+" 님이 약속을 잡았어요!",
			c_appdate:chatAppdate,
			c_apptime:chatApptime,
			c_appspot:chatAppspot,
			send_time:"",
			c_read:"0",
			user_id:window.opener.loginId,
			c_room_no:window.opener.c_room_no
		}]
		console.log(jsonData);
		
		window.opener.socket.send(JSON.stringify(jsonData));

  

//  f.submit();
    self.close();

	//디비 전송 - 성공시 함수실행...? 
})

})

 
 /**********지도 script**************/
 
 




  