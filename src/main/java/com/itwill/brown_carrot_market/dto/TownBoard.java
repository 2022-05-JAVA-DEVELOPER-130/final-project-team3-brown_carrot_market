package com.itwill.brown_carrot_market.dto;

import java.util.List;

public class TownBoard {
	/*
T_NO	NUMBER(10,0)
T_TITLE	VARCHAR2(300 BYTE)
T_CONTENT	VARCHAR2(1000 BYTE)
T_DATE	DATE
T_COUNT	NUMBER(10,0)
T_CTGR_NO	NUMBER(10,0)
T_ADDRESS_NAME	VARCHAR2(100 BYTE)
T_ADDRESS_LAT	NUMBER(20,10)
T_ADDRESS_LNG	NUMBER(20,10)
USER_ID	VARCHAR2(30 BYTE)
	 */
	public int t_no;
	public String t_title;
	public String t_content;
	public String t_date;
	public int t_count;
	public TownCategory townCategory;
	public String t_address_name;
	public int t_address_lat;
	public int t_address_lng;
	public UserInfo userInfo;
	
	public List<TownImage> townImageList;
	
	
	public TownBoard() {
		// TODO Auto-generated constructor stub
	}

	public TownBoard(int t_no, String t_title, String t_content, String t_date, int t_count, TownCategory townCategory,
			String t_address_name, int t_address_lat, int t_address_lng, UserInfo userInfo) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_date = t_date;
		this.t_count = t_count;
		this.townCategory = townCategory;
		this.t_address_name = t_address_name;
		this.t_address_lat = t_address_lat;
		this.t_address_lng = t_address_lng;
		this.userInfo = userInfo;
	}

	public int getT_no() {
		return t_no;
	}

	public void setT_no(int t_no) {
		this.t_no = t_no;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

	public String getT_date() {
		return t_date;
	}

	public void setT_date(String t_date) {
		this.t_date = t_date;
	}

	public int getT_count() {
		return t_count;
	}

	public void setT_count(int t_count) {
		this.t_count = t_count;
	}

	public TownCategory getTownCategory() {
		return townCategory;
	}

	public void setTownCategory(TownCategory townCategory) {
		this.townCategory = townCategory;
	}

	public String getT_address_name() {
		return t_address_name;
	}

	public void setT_address_name(String t_address_name) {
		this.t_address_name = t_address_name;
	}

	public int getT_address_lat() {
		return t_address_lat;
	}

	public void setT_address_lat(int t_address_lat) {
		this.t_address_lat = t_address_lat;
	}

	public int getT_address_lng() {
		return t_address_lng;
	}

	public void setT_address_lng(int t_address_lng) {
		this.t_address_lng = t_address_lng;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "TownBoard [t_no=" + t_no + ", t_title=" + t_title + ", t_content=" + t_content + ", t_date=" + t_date
				+ ", t_count=" + t_count + ", townCategory=" + townCategory + ", t_address_name=" + t_address_name
				+ ", t_address_lat=" + t_address_lat + ", t_address_lng=" + t_address_lng + ", userInfo=" + userInfo
				+ "]";
	}
	
	
	
	
	
	
	
	
}
