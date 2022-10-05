package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Transfer;

@Mapper
public interface TransferMapper {
	
	int insertTransfer_Deposit(int p_no);
	
	int insertTransfer_Withdraw(int p_no);
	
	int insertTransfer_Deposit_Cancle(int p_no);
	
	int insertTransfer_Withdraw_Cancle(int p_no);
	
	List<Transfer> selectById(String user_id);
}
