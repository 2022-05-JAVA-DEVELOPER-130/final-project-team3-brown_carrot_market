/**
 * 
 */
 function productCreateForm() {
	
	window.location.href='product_write_form';
}

function productList() {
	window.location.href='product_list';
}
function productCreate() {
	if (document.product_write_form.p_title.value == "") {
		alert("제목을 입력하십시요.");
		document.product_write_form.p_title.focus();
		return false;
	}
	if (document.product_write_form.p_price.value == "") {
		alert("가격을 입력하십시요.");
		document.product_write_form.p_price.focus();
		return false;
	}

	if (document.product_write_form.p_desc.value == "") {
		alert("내용을 입력하십시요.");
		document.product_write_form.p_desc.focus();
		return false;
	}
	

	document.product_write_form.action = "product_write_action";
	document.product_write_form.method='POST';
	document.product_write_form.submit();
}

function productSell(){
	document.product_modify_sell_action.action = " product_modify_sell_action"
	document.product_modify_sell_action.method='POST';
	document.product_modify_sell_action.submit();
}

/********************채팅하기!!**************************/
$(document).ready(function(){
	$('#btnCreate').click(function(){
		console.log('채팅방 생성 버튼 클릭');
		document.chatStart.action="create_room";
		document.chatStart.method='POST';
		document.chatStart.submit();
		
	});
	});
	
