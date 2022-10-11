package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.dto.Transfer;
import com.itwill.brown_carrot_market.mapper.TransferMapper;

@Repository(value = "transferDaoImpl")
public class TransferDaoImpl implements TransferDao{
	@Autowired(required = true)
	private TransferMapper transferMapper;
	public TransferDaoImpl() {
		System.out.println("#### TransferDaoImplMyBatisMapperInterface() : 디폴트생성자 호출  ");

	}

	public TransferMapper getTransferMapper() {
		return transferMapper;
	}

	public void setTransferMapper(TransferMapper transferMapper) {
		this.transferMapper = transferMapper;
	}

	@Override
	public int insertTransfer_Deposit(int p_no) throws Exception {
		Transfer transfer = new Transfer();
		Product product = new Product();
		product.setP_no(p_no);
		transfer.setProduct(product);
		System.out.println("#### TransferDaoImpl : insertTransfer_Deposit(Transfer transfer) 호출  ");
		transferMapper.insertTransfer_Deposit(transfer);
		return transfer.getTransfer_no();
	}

	@Override
	public int insertTransfer_Withdraw(int p_no) throws Exception {
		System.out.println("#### TransferDaoImpl : insertTransfer_Withdraw(Transfer transfer) 호출  ");
		return transferMapper.insertTransfer_Withdraw(p_no);
	}

	@Override
	public int insertTransfer_Deposit_Cancle(int p_no) throws Exception {
		System.out.println("#### TransferDaoImpl : insertTransfer_Deposit_Cancle(Transfer transfer) 호출  ");
		return transferMapper.insertTransfer_Deposit_Cancle(p_no);
	}

	@Override
	public int insertTransfer_Withdraw_Cancle(int p_no) throws Exception {
		System.out.println("#### TransferDaoImpl : insertTransfer_Withdraw_Cancle(Transfer transfer) 호출  ");
		return transferMapper.insertTransfer_Withdraw_Cancle(p_no);
	}

	@Override
	public List<Transfer> selectById(String user_id) throws Exception {
		System.out.println("#### TransferDaoImpl : selectById(String user_id) 호출  ");
		return transferMapper.selectById(user_id);
	}
	
	
}
