package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Transfer;

public interface TransferDao {
	int insertTransfer_Deposit(int p_no) throws Exception;
	
	int insertTransfer_Withdraw(int p_no) throws Exception;
	
	int insertTransfer_Deposit_Cancle(int p_no) throws Exception;
	
	int insertTransfer_Withdraw_Cancle(int p_no) throws Exception;
	
	List<Transfer> selectById(String user_id) throws Exception;

}
