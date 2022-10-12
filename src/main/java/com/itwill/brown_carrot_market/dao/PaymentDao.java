package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Payment;

public interface PaymentDao {
	
	int insertPayment(Payment payment) throws Exception;
	
	List<Payment> selectPaymentById(String user_id);
}
