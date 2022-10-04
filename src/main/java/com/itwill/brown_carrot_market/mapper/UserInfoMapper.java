package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Invitation;
import com.itwill.brown_carrot_market.dto.UserInfo;


@Mapper
public interface UserInfoMapper {
	/*
	 * @Insert("")
	 */
	public int createUser(UserInfo user);

	/*
	 * @Insert("")
	 */
	public int createAddress(Address address);

	//@Insert("")
	public int createInvitation(Invitation invitation);

	
	
	
	//@Update("")
	public int updateUser(UserInfo user);

	//@Update("")
	public int updateAddress(Address address);
	//@Update("")
	public int updateAddressRange(Address address);
	
	//@Update("")
	public int updatePoint(UserInfo userInfo);
	
	//@Delete("")
	public int removeUser(String user_id);
	
	//@Delete("")
	public int removeAddress(Address address);

	//@Select("")
	public UserInfo findUser(String user_id);

	//@Select("")
	public List<UserInfo> findUserList();

	public String findInvitation(Invitation invitation);

	//@Select("")
	public int existedInvitation(Invitation invitation);
	
	//@Select("")
	public int existedUser(String user_id);

}