package com.itwill.brown_carrot_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.OrdersDao;
import com.itwill.brown_carrot_market.dao.TransferDao;
import com.itwill.brown_carrot_market.dto.Transfer;

@Service
public class TransferServiceImpl implements TransferService{
	@Autowired
	@Qualifier("transferDaoImpl")
	private TransferDao transferDao;

	public TransferServiceImpl() {
		System.out.println("#### TransferServiceImpl() : 디폴트생성자 호출  ");
	}

	@Override
	public int insertTransfer_Deposit(int p_no) throws Exception {
		return transferDao.insertTransfer_Deposit(p_no);
	}

	@Override
	public int insertTransfer_Withdraw(int p_no) throws Exception {
		return transferDao.insertTransfer_Withdraw(p_no);
	}

	@Override
	public int insertTransfer_Withdraw_Cancle(int p_no) throws Exception {
		return transferDao.insertTransfer_Withdraw_Cancle(p_no);
	}

	@Override
	public int insertTransfer_Deposit_Cancle(int p_no) throws Exception {
		return transferDao.insertTransfer_Deposit_Cancle(p_no);
	}

	@Override
	public List<Transfer> selectById(String user_id) throws Exception {
		return transferDao.selectById(user_id);
	}
	
	
}


/*
@Service
public class TransferServiceImpl implements TransferService{
	@Autowired
	@Qualifier("transferDaoImpl")
	private TransferDao transferDao;
	
	public TransferServiceImpl() {
		System.out.println("#### TransferServiceImpl() : 디폴트생성자 호출  ");
	}
	
	@Override
	public int insertTransfer_Deposit(int p_no) throws Exception {
		return transferDao.insertTransfer_Deposit(p_no);
	}
	
	@Override
	public int insertTransfer_Withdraw(int p_no) throws Exception {
		return transferDao.insertTransfer_Withdraw(p_no);
	}
	
	@Override
	public int insertTransfer_Withdraw_Cancle(int p_no) throws Exception {
		return transferDao.insertTransfer_Withdraw_Cancle(p_no);
	}
	
	@Override
	public int insertTransfer_Deposit_Cancle(int p_no) throws Exception {
		return transferDao.insertTransfer_Deposit_Cancle(p_no);
	}
	
	@Override
	public List<Transfer> selectById(String user_id) throws Exception {
		return transferDao.selectById(user_id);
	}
	
	
}
*/