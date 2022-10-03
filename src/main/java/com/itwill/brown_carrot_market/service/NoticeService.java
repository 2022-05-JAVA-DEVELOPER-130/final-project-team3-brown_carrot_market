package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Notice;

public interface NoticeService {
	//공지사항 전체조회
	List<Notice> selectAll() throws Exception;
	
	//공지사항 글 한개 찾기
	Notice selectByNo(int notice_no) throws Exception;
	
	//공지사항 글 등록
	//int insertNotice(Notice notice) throws Exception;
	
	
	
}
