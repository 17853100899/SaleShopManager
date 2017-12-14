package com.tsinghua.saleshopmanager.vo;

public class SellDetail {
	private int SellDetailId;
	private String SId; 
	private  String GId;
	private int SQuantity;
	private float SSalePrice;
	public String getGId() {
		return GId;
	}
	public void setGId(String id) {
		GId = id;
	}
	public int getSellDetailId() {
		return SellDetailId;
	}
	public void setSellDetailId(int sellDetailId) {
		SellDetailId = sellDetailId;
	}
	public String getSId() {
		return SId;
	}
	public void setSId(String id) {
		SId = id;
	}
	public int getSQuantity() {
		return SQuantity;
	}
	public void setSQuantity(int quantity) {
		SQuantity = quantity;
	}
	public float getSSalePrice() {
		return SSalePrice;
	}
	public void setSSalePrice(float salePrice) {
		SSalePrice = salePrice;
	}
}
