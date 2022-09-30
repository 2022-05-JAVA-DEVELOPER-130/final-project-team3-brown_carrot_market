package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownWishList;

@Mapper
public interface TownWishListMapper {
	
	public int selectTownWishListCount(String user_id);
	
	public List<TownWishList> selectTownWishListAll(String user_id);
	
	public TownWishList selectTownWishListOne(int t_wl_no);
	
	public int insertTownWishList(TownWishList townWishList);
	
	public int deleteTownWishList(int t_wl_no);
	
	
	
	
	
	
	
	
	
	
	
	
}
