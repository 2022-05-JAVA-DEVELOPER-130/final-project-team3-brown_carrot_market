package com.itwill.brown_carrot_market.dto;

import java.util.Date;

public class Promise {
	private Integer c_room_no;
	private double c_app_lat;
	private double c_app_lng;
	private String c_app_date;
	private String c_app_spot;
	
	public Promise() {
		// TODO Auto-generated constructor stub
	}

	public Promise(Integer c_room_no, double c_app_lat, double c_app_lng, String c_app_date, String c_app_spot) {
		super();
		this.c_room_no = c_room_no;
		this.c_app_lat = c_app_lat;
		this.c_app_lng = c_app_lng;
		this.c_app_date = c_app_date;
		this.c_app_spot = c_app_spot;
	}

	public Integer getC_room_no() {
		return c_room_no;
	}

	public void setC_room_no(Integer c_room_no) {
		this.c_room_no = c_room_no;
	}

	public double getC_app_lat() {
		return c_app_lat;
	}

	public void setC_app_lat(double c_app_lat) {
		this.c_app_lat = c_app_lat;
	}

	public double getC_app_lng() {
		return c_app_lng;
	}

	public void setC_app_lng(double c_app_lng) {
		this.c_app_lng = c_app_lng;
	}

	public String getC_app_date() {
		return c_app_date;
	}

	public void setC_app_date(String c_app_date) {
		this.c_app_date = c_app_date;
	}

	public String getC_app_spot() {
		return c_app_spot;
	}

	public void setC_app_spot(String c_app_spot) {
		this.c_app_spot = c_app_spot;
	}

	@Override
	public String toString() {
		return "Promise [c_room_no=" + c_room_no + ", c_app_lat=" + c_app_lat + ", c_app_lng=" + c_app_lng
				+ ", c_app_date=" + c_app_date + ", c_app_spot=" + c_app_spot + "]";
	}

	
	
	
	

}
