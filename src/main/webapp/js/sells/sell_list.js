/**
 * 
 */
 function sellStatus(p_sell){
	$.ajax({
		url:"sell_list_rest",
		method:"post",
		data:{
			"p_sell":p_sell
		},
		dataType:"json",
		success:function(resultObj){
			console.log(resultObj.data);
			
				/*
				let data = resultObj.data;
				let htmlBuffer = ``;
				data.itemList.forEach(function(product, i){
					htmlBuffer += ``;
										                                
																		  
							
			});
			
			$(".sell_list_start").html(htmlBuffer);
			*/
			
		}
	});
}