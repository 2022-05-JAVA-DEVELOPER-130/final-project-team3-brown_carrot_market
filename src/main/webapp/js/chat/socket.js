//var loginId=null;

function connectServer(loginId){
	console.log("connectWS 실행 : "+loginId)
	var url="ws://localhost:80/brown_carrot_market/serverSocket?"+loginId;
	var ws=new WebSocket(url);
	socket=ws;
	
	ws.onopen = function() {
			console.log(loginId+'서버 연결 성공');
		
	    };
	    
	ws.onerror=function(evt){
		console.log('에러');
	}
	
	ws.onmessage=function(result){
		alert("메세지 전송:"+result);
		console.log('메세지 전송');
	}
	
	
	
	ws.onclose=function(evt){
		console.log('소켓 닫기');
		
	}
}