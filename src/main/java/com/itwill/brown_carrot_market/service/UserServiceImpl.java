package com.itwill.brown_carrot_market.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.UserDao;
import com.itwill.brown_carrot_market.dto.User;

/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;

	public UserServiceImpl() throws Exception {
		System.out.println("#### UserServiceImpl() : 디폴트생성자 호출  ");
	}

	/*
	 * 회원가입
	 */
	/************** 1.반환값사용 ***********************/
	@Override
	public int create(User user) throws Exception {
		/*
		 * -1:아이디중복 1:회원가입성공
		 */

		// 1.아이디중복체크
		if (userDao.existedUser(user.getUser_id())) {
			// 아이디중복
			return -1;
		} else {
			// 아이디안중복
			// 2.회원가입
			int insertRowCount = userDao.createUser(user);
			return insertRowCount;
		}
	}

	/*********************************************/

	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함 1:패쓰워드 불일치 2:로그인성공
	 */
	@Override
	public int login(String user_id, String password) throws Exception {
		int result = -1;
		// 1.아이디 존재여부
		User user = userDao.findUser(user_id);
		if (user == null) {
			// 아이디존재안함
			result = 0;
		} else {
			// 아이디존재함
			if (user.isMatchPassword(password)) {
				// 패쓰워드일치(로그인성공)
				result = 2;
			} else {
				// 패쓰워드불일치
				result = 1;
			}
		}

		return result;
	}
	/*
	 * 회원로그아웃
	 */

	/*
	 * 회원상세보기
	 */
	@Override
	public User findUser(String user_id) throws Exception {
		return userDao.findUser(user_id);
	}

	/*
	 * 회원수정
	 */
	@Override
	public int update(User user) throws Exception {
		return userDao.updateUser(user);
	}

	/*
	 * 회원탈퇴
	 */
	@Override
	public int remove(String user_id) throws Exception {
		return userDao.removeUser(user_id);
	}

	/*
	 * 전체회원리스트
	 */
	@Override
	public List<User> findUserList() throws Exception {
		return userDao.findUserList();
	}

	/*
	 * 아이디중복체크
	 */
	@Override
	public boolean isDuplicateId(String user_id) throws Exception {
		boolean isExist = userDao.existedUser(user_id);
		if (isExist) {
			return true;
		} else {
			return false;
		}
	}

}
