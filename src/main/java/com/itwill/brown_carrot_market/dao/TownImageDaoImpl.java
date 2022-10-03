package com.itwill.brown_carrot_market.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.TownImage;
import com.itwill.brown_carrot_market.mapper.TownImageMapper;

@Repository(value = "townImageDaoImpl")
public class TownImageDaoImpl implements TownImageDao{
	@Autowired(required = true)
	private TownImageMapper townImageMapper;
	
	public TownImageDaoImpl() {
		System.out.println(">>> TownImageDaoImpl()호출");
	}
	public TownImageMapper getTownImageMapper() {
		return townImageMapper;
	}
	public void setTownImageMapper(TownImageMapper townImageMapper) {
		System.out.println(">>> townImageDaoImpl:setTownImageMapper()호출");
		this.townImageMapper = townImageMapper;
	}
	@Override
	public int deleteTownBoardImgAll(int t_no) {
		System.out.println(">>> townImageDaoImpl:deleteTownBoardImgAll()호출");
		return townImageMapper.deleteTownBoardImgAll(t_no);
	}
	@Override
	public int deleteTownBoardImgOne(int t_img_no) {
		System.out.println(">>> townImageDaoImpl:deleteTownBoardImgOne()호출");
		return townImageMapper.deleteTownBoardImgOne(t_img_no);
	}
	/*
	@Override
	public TownImage insertTownBoardImg(TownImage townImage) {
		System.out.println(">>> townImageDaoImpl:insertTownBoardImg()호출");
		return townImageMapper.insertTownBoardImg(townImage);
	}
	*/
	
	
	
	
	
	
}
