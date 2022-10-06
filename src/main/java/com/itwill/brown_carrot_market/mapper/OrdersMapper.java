package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Orders;

@Mapper
public interface OrdersMapper {
	
	int insertOrders(Orders orders);
	
	Orders selectByNo(int orders_no);
	
	int deleteOrders(int orders_no);

	List<Orders> selectAllById(String user_id); 

}
