package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.WishList;

public interface WishListDao {
	
	List<WishList> selectWishListAll(String user_id)throws Exception;
	
	WishList selectWishListOne(int wishlist_no)throws Exception;
	
	int selectWishListCount(String user_id)throws Exception;
	
	int insertWishList(WishList wishList)throws Exception;
	
	int deleteWishList(int wishlist_no)throws Exception;
}
