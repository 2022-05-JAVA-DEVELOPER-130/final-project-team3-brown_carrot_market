var p_address="역삼역";
var searchKeyword=null;
var mapContainer=null;
var map=null;
var markerImage=null;
var marker=null;

$(document).ready(function(){
	
	 
		 mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.56598, 126.98086), // 지도의 중심좌표
		        level: 2, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		map = new kakao.maps.Map(mapContainer, mapOption); 
		
		
	

$('#btnsearchChatAppSpot').click(function(e){
	    
		/*e.preventDefault();
		e.stopPropagation();*/
		
		searchKeyword=$('#searchChatAppSpot').val();
		console.log("장소검색>>>"+searchKeyword);
		searchLoc(searchKeyword);
});


		
	/*	//키워드 검색
		// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

// 키워드로 장소를 검색합니다
ps.keywordSearch(p_address, placesSearchCB); 

$('#btnsearchChatAppSpot').click(function(e){
	e.preventDefault();
	var searchKeyword=$('#searchChatAppSpot').val();
	//ps.kewordSearch(searchKeyword,placesSearchCB);
})

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
                        bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}
		*/
		
		// 마커 이미지의 주소
		var markerImageUrl = "img/chat-img/logo_carrot.png",
		    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };

		// 마커 이미지를 생성한다
		markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

	/*	// 지도에 마커를 생성하고 표시한다
		marker = new kakao.maps.Marker({
		    position: map.getCenter() , // 마커의 좌표
		    draggable : false, // 마커를 드래그 가능하도록 설정한다
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
		});
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


	// 지도에 마커를 표시합니다
	marker.setMap(map);

	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    console.log(message);
	
	    
	});*/

	

	});
	
	
/*	function searchLoc(searchKey){
		// 주소로 좌표를 검색합니다
			// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
geocoder.addressSearch(searchKey, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image : markerImage,
            draggable : false
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: `<div style="width:150px;text-align:center;padding:6px 0;">${searchKey}</div>`
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
		
	}*/
	
	


