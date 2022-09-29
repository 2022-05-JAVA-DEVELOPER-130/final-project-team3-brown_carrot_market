package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.User;
import com.itwill.brown_carrot_market.mapper.UserMapper;


@Repository(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired(required = true)
	private UserMapper userMapper;

	public UserDaoImpl() {
		System.out.println("#### UserDaoImplMyBatisMapperInterface() : 디폴트생성자 호출  ");
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		System.out.println("#### UserDaoImplMyBatisMapperInterface() : setUserMapper() 메쏘드호출  ");
		this.userMapper = userMapper;
	}

	@Override
	public int createUser(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : create() 호출  ");
		System.out.println("createUser()메소드 : " + userMapper);
		return userMapper.createUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : update() 호출  ");

		return userMapper.updateUser(user);
	}

	@Override
	public int removeUser(String user_id) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : remove() 호출  ");

		return userMapper.removeUser(user_id);
	}

	@Override
	public User findUser(String user_id) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUser() 호출  ");

		return userMapper.findUser(user_id);
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUserList 호출  ");

		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String user_id) throws Exception {

		System.out.println("#### UserDaoImplMyBatisMapperInterface : existedUser 호출  ");

		int count = userMapper.existedUser(user_id);
		if (count == 1) {
			return true;
		} else {
			return false;
		}

	}

}