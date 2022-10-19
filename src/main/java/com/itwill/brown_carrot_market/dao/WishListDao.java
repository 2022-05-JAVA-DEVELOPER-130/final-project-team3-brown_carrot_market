package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.WishList;

public interface WishListDao {
	
	List<WishList> selectWishListAll(String user_id);
	
	WishList selectWishListOne(int wishlist_no);
	
	int selectWishListCount(String user_id);
	
	int insertWishList(WishList wishList);
	
	int deleteWishList(int wishlist_no);
}
