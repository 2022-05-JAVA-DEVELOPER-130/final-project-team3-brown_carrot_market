package com.itwill.brown_carrot_market.dao;

import com.itwill.brown_carrot_market.dto.Promise;

public interface PromiseDao {
	public Promise promiseSelect(int c_room_no);
	
	public int promiseInsert(Promise promise);
	
	public int promiseDelete(int c_room_no);
	
	public int promiseUpdate(Promise promise);
	
	public int promiseExist(int c_room_no);


	

}
