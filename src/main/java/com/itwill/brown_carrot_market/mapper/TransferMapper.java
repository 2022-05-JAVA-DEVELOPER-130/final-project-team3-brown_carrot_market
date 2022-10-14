package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.itwill.brown_carrot_market.dto.Transfer;

@Mapper
public interface TransferMapper {
	  
	@SelectKey(keyProperty = "transfer_no" , resultType = int.class , before = true ,statement = "select TRANSFER_TRANSFER_NO_SEQ.nextval from dual")
	@Insert("insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval, 0, (-1*(select p_price from product where p_no = #{product.p_no})), sysdate-5, (select user_id from orders where p_no =#{product.p_no}), (select orders_no from orders where p_no = #{product.p_no}), #{product.p_no},(select user_point from userinfo where user_id=(select user_id from orders where p_no = #{product.p_no}))-(select p_price from product where p_no = #{product.p_no}))")
	int insertTransfer_Deposit(int p_no);
	
	@Insert("insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval, (select p_price from product where p_no = #{p_no}), 0, sysdate, (select user_id from product where p_no = #{p_no}), (select orders_no from orders where p_no = #{p_no}),#{p_no},0)")
	int insertTransfer_Withdraw(int p_no);
	
	@Insert("insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval, 0, (select p_price from product where p_no = #{p_no}), sysdate, (select user_id from orders where p_no = #{p_no}), (select orders_no from orders where p_no = #{p_no}),#{p_no},0)")
	int insertTransfer_Deposit_Cancle(int p_no);
	
	@Insert("insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval, (select p_price from product where p_no = #{p_no}), 0, sysdate, (select user_id from product where p_no = #{p_no}), (select orders_no from orders where p_no = #{p_no}),#{p_no},0)")
	int insertTransfer_Withdraw_Cancle(int p_no);
	
	
	@ResultMap(value = {"transferResultMap"})
	@Select("select s.user_id, s.transfer_no, s.transfer_deposit, s.transfer_withdraw, s.transfer_date, s.t_balance from (select t.user_id, t.transfer_no, t.transfer_deposit, t.transfer_withdraw, t.transfer_date, t.t_balance from transfer t left outer join orders o on t.p_no = o.p_no)s join userinfo u on s.user_id=u.user_id where s.user_id=#{user_id} order by s.transfer_date desc")
	List<Transfer> selectById(String user_id);
	
	@ResultMap(value = { "transferResultMap" })
	@Select("select p.user_id, p.p_no, p.p_price, p.p_title from transfer t join product p on t.p_no = p.p_no where t.user_id=#{user_id}")
	List<Transfer> selectByP_Id(String user_id);
}
