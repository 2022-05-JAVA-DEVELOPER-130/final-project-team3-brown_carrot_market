package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Transfer;

public interface TransferService {
	
	boolean transfer_transaction(int p_no) throws Exception;
	
	boolean transfer_cancel_transaction(int p_no) throws Exception;

	
	/*
	 * int insertTransfer_Deposit(int p_no) throws Exception;
	 * 
	 * int insertTransfer_Withdraw(int p_no) throws Exception;
	 */
	/*
	 * int insertTransfer_Deposit_Cancle(int p_no) throws Exception;
	 * 
	 * int insertTransfer_Withdraw_Cancle(int p_no) throws Exception;
	 */
	List<Transfer> selectById(String user_id) throws Exception;

	List<Transfer> selectByP_Id(String user_id) throws Exception;
}
