package com.itwill.brown_carrot_market.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.TransferDao;
import com.itwill.brown_carrot_market.dto.Transfer;

@Service
public class TransferServiceImpl implements TransferService {
	@Autowired
	@Qualifier("transferDaoImpl")
	private TransferDao transferDao;
	
	public void transfer_transaction(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		String insertSqlA = "insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval, 0, (-1*(select p_price from product where p_no = ?)), sysdate-5, (select user_id from orders where p_no =?), (select orders_no from orders where p_no = ?), ?,(select user_point from userinfo where user_id=(select user_id from orders where p_no = ?))-(select p_price from product where p_no = ?))";
		String insertSqlB = "insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval, (select p_price from product where p_no = ?), 0, sysdate-5, (select user_id from product where p_no =?), (select orders_no from orders where p_no = ?), ?, (select user_point from userinfo where user_id=(select user_id from product where p_no = ?))+(select p_price from product where p_no = ?))";
		String updateSqlA = "update userinfo set user_point =user_point-(select p_price from product where p_no = ?) where user_id= (select user_id from orders where p_no =?)";
		String updateSqlB = "update userinfo set user_point =user_point+(select p_price from product where p_no = ?) where user_id= (select user_id from product where p_no = ?)";
		String selectSqlA = "select u.user_point from userinfo u join orders o on u.user_id = o.user_id where o.p_no=?";
		String selectSqlB = "select u.user_point from userinfo u join product p on u.user_id = p.user_id where p.p_no = ?";
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@182.237.126.19:1521:XE", "F2205JDEVELOPER#TEAM3", "F2205JDEVELOPER#TEAM3"
											  );
			/*
			 * 1. con.setAutoCommit(false);
			 */
			con.setAutoCommit(false);
			/*
			 * transaction start(dml statement)
			 */
			pstmt = con.prepareStatement(insertSqlA);
			pstmt.setInt(1, p_no);
			pstmt.setInt(2, p_no);
			pstmt.setInt(3, p_no);
			pstmt.setInt(4, p_no);
			pstmt.setInt(5, p_no);
			pstmt.setInt(6, p_no);
			int rowCount = pstmt.executeUpdate();
			System.out.println("1.구매자 insert");
			pstmt.close();
			
			pstmt = con.prepareStatement(insertSqlB);
			pstmt.setInt(1, p_no);
			pstmt.setInt(2, p_no);
			pstmt.setInt(3, p_no);
			pstmt.setInt(4, p_no);
			pstmt.setInt(5, p_no);
			pstmt.setInt(6, p_no);
			rowCount = pstmt.executeUpdate();
			System.out.println("2.판매자 insert");
			pstmt.close();
			
			pstmt = con.prepareStatement(updateSqlA);
			pstmt.setInt(1, p_no);
			pstmt.setInt(2, p_no);
			rowCount = pstmt.executeUpdate();
			System.out.println("3.구매자 포인트 잔액 감소 : " + rowCount);
			pstmt.close();
			
			pstmt = con.prepareStatement(updateSqlB);
			pstmt.setInt(1, p_no);
			pstmt.setInt(2, p_no);
			rowCount = pstmt.executeUpdate();
			System.out.println("4.판매자 포인트 잔액 증가 : " + rowCount);
			pstmt.close();
			
			pstmt = con.prepareStatement(selectSqlA);
			pstmt.setInt(1, p_no);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int t_balance = rs.getInt(1);
				if (t_balance < 0) {
					/*
					 * transaction end [rollback]
					 */
					con.rollback();
					System.out.println("4-1.구매자 포인트 잔액 " + t_balance + " 음수--> Rollback!");
					pstmt.close();
				} else {
					/*
					 * transaction end [commit]
					 */
					con.commit();
					System.out.println("4-1.구매자 포인트 잔액 " + t_balance + " 양수--> Commit!");
					pstmt.close();
				}

			} else {
				throw new Exception("unknown error!!");
			}
			pstmt = con.prepareStatement(selectSqlB);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int t_balance = rs.getInt(1);
				if (t_balance < 0) {
					/*
					 * transaction end [rollback]
					 */
					con.rollback();
					System.out.println("4-2.판매자 포인트 잔액 " + t_balance + " 음수 --> Rollback!");
					con.close();
				} else {
					/*
					 * transaction end [commit]
					 */
					con.commit();
					System.out.println("4-2.판매자 포인트 잔액 " + t_balance + " 양수 --> Commit!");
					con.close();
				}

			} else {
				throw new Exception("unknown error!!");
			}
		} catch (Exception e) {
			System.out.println(e);
			try {
				/*
				 * transaction end [rollback]
				 */
				con.rollback();
				System.out.println("Rollback(Exception)!");
				con.close();
			} catch (SQLException e1) {

				e1.printStackTrace();
				con.close();
			}

		}

	}

	public int insertTransfer_Deposit(int p_no) throws Exception {
		return transferDao.insertTransfer_Deposit(p_no);
	}

	public int insertTransfer_Withdraw(int p_no) throws Exception {
		return transferDao.insertTransfer_Withdraw(p_no);
	}

	public int insertTransfer_Withdraw_Cancle(int p_no) throws Exception {
		return transferDao.insertTransfer_Withdraw_Cancle(p_no);
	}

	public int insertTransfer_Deposit_Cancle(int p_no) throws Exception {
		return transferDao.insertTransfer_Deposit_Cancle(p_no);
	}

	public List<Transfer> selectById(String user_id) throws Exception {
		return transferDao.selectById(user_id);
	}

	public List<Transfer> selectByP_No(int p_no) throws Exception {
		return transferDao.selectByP_No(p_no);
	}

}

/*
 * @Service public class TransferServiceImpl implements TransferService{
 * 
 * @Autowired
 * 
 * @Qualifier("transferDaoImpl") private TransferDao transferDao;
 * 
 * public TransferServiceImpl() {
 * System.out.println("#### TransferServiceImpl() : 디폴트생성자 호출  "); }
 * 
 * @Override public int insertTransfer_Deposit(int p_no) throws Exception {
 * return transferDao.insertTransfer_Deposit(p_no); }
 * 
 * @Override public int insertTransfer_Withdraw(int p_no) throws Exception {
 * return transferDao.insertTransfer_Withdraw(p_no); }
 * 
 * @Override public int insertTransfer_Withdraw_Cancle(int p_no) throws
 * Exception { return transferDao.insertTransfer_Withdraw_Cancle(p_no); }
 * 
 * @Override public int insertTransfer_Deposit_Cancle(int p_no) throws Exception
 * { return transferDao.insertTransfer_Deposit_Cancle(p_no); }
 * 
 * @Override public List<Transfer> selectById(String user_id) throws Exception {
 * return transferDao.selectById(user_id); }
 * 
 * 
 * }
 */