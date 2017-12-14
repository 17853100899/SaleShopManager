package com.tsinghua.saleshopmanager.vo;

public class Sell {
	private String SId;
	private String VId;
	private String STime;
	private float SCountPrice;
	private int SCount;
	private String UId;
	public int getSCount() {
		return SCount;
	}
	public void setSCount(int count) {
		SCount = count;
	}
	public float getSCountPrice() {
		return SCountPrice;
	}
	public void setSCountPrice(float countPrice) {
		SCountPrice = countPrice;
	}
	public String getSId() {
		return SId;
	}
	public void setSId(String id) {
		SId = id;
	}
	public String getSTime() {
		return STime;
	}
	public void setSTime(String time) {
		STime = time;
	}
	public String getUId() {
		return UId;
	}
	public void setUId(String id) {
		UId = id;
	}
	public String getVId() {
		return VId;
	}
	public void setVId(String id) {
		VId = id;
	}
	

}
