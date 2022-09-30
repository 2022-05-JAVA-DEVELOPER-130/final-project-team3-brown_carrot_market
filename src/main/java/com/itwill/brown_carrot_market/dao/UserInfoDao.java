package com.itwill.brown_carrot_market.dao;

import java.util.List;

public interface UserInfoDao {

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	int createUser(UserInfo user) throws Exception;

	/*
	 * 기존의 사용자정보를 수정
	 */
	int updateUser(UserInfo user) throws Exception;

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	int removeUser(String userId) throws Exception;

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	UserInfo findUser(String userId) throws Exception;

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	List<UserInfo> findUserList() throws Exception;

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	boolean existedUser(String userId) throws Exception;

}