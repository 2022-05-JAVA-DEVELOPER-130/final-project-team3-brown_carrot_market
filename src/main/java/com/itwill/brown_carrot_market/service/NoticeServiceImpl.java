package com.itwill.brown_carrot_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.NoticeDao;
import com.itwill.brown_carrot_market.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	@Qualifier("noticeDaoImpl")
	private NoticeDao noticeDao;
	
	public NoticeServiceImpl() throws Exception{
		System.out.println(">>> NoticeServiceImpl : 기본 생성자 호출");
	}

	@Override
	public List<Notice> selectAll() throws Exception {
		return noticeDao.selectAll();
	}

	@Override
	public Notice selectByNo(int notice_no) throws Exception {
		return noticeDao.selectByNo(notice_no);
	}
/*
	@Override
	public int insertNotice(Notice notice) throws Exception {
		
		return 0;
	}
	*/
	
	
	
	
}
