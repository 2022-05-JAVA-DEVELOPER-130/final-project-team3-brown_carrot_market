package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Notice;

@Mapper
public interface NoticeMapper {
	
	public List<Notice> selectAll();
	
	public Notice selectByNo(int notice_no);
	
	public int insertNotice(Notice notice);
	
	public int deleteNotice(int notice_no);
	
	public int updateNotice(Notice notice);
	
	public int updateNoticeCount(int notice_no);
	
	
	
	
}
