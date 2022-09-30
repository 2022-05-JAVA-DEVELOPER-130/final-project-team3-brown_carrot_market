package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.mapper.UserInfoMapper;


@Repository(value = "userDaoImpl")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired(required = true)
	private UserInfoMapper userMapper;

	public UserInfoDaoImpl() {
		System.out.println("#### UserDaoImpl() : 디폴트생성자 호출  ");
	}

	public UserInfoMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserInfoMapper userMapper) {
		System.out.println("#### UserDaoImpl() : setUserMapper() 메쏘드호출  ");
		this.userMapper = userMapper;
	}

	@Override
	public int createUser(UserInfo user) throws Exception {
		System.out.println("#### UserDaoImpl : create() 호출  ");
		System.out.println("createUser()메소드 : " + userMapper);
		return userMapper.createUser(user);
	}
	
	@Override
	public int createAddress(Address address) throws Exception {
		System.out.println("#### UserDaoImpl : createAddress() 호출  ");
		return userMapper.createAddress(address);
	}

	@Override
	public int updateUser(UserInfo user) throws Exception {
		System.out.println("#### UserDaoImpl : update() 호출  ");

		return userMapper.updateUser(user);
	}

	@Override
	public int removeUser(String user_id) throws Exception {
		System.out.println("#### UserDaoImpl : remove() 호출  ");

		return userMapper.removeUser(user_id);
	}

	@Override
	public UserInfo findUser(String user_id) throws Exception {
		System.out.println("#### UserDaoImpl : findUser() 호출  ");

		return userMapper.findUser(user_id);
	}

	@Override
	public List<UserInfo> findUserList() throws Exception {
		System.out.println("#### UserDaoImpl : findUserList 호출  ");

		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String user_id) throws Exception {

		System.out.println("#### UserDaoImpl : existedUser 호출  ");

		int count = userMapper.existedUser(user_id);
		if (count == 1) {
			return true;
		} else {
			return false;
		}

	}



}