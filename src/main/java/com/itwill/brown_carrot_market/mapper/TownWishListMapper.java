package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownWishList;

@Mapper
public interface TownWishListMapper {
	
	public int insertTownWishList(TownWishList townWishList);
	
	public int deleteTownWishList(int t_wl_no);
	
	public TownWishList selectTownWishListOne(int t_wl_no);
	
	
	
	
	
	
	
	
	
}
