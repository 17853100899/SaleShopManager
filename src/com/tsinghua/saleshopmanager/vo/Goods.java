package com.tsinghua.saleshopmanager.vo;

public class Goods {
	private String gid;
	private int cid;
	private String GName;
	private String GSpec;
	private int GUId;
	private int GMinNumber;
	private float SalePrice;
	private float VipPrice;
	private int GAmount;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getGAmount() {
		return GAmount;
	}
	public void setGAmount(int amount) {
		GAmount = amount;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getGMinNumber() {
		return GMinNumber;
	}
	public void setGMinNumber(int minNumber) {
		GMinNumber = minNumber;
	}
	public String getGName() {
		return GName;
	}
	public void setGName(String name) {
		GName = name;
	}
	public String getGSpec() {
		return GSpec;
	}
	public void setGSpec(String spec) {
		GSpec = spec;
	}
	public int getGUId() {
		return GUId;
	}
	public void setGUId(int id) {
		GUId = id;
	}
	public float getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(float salePrice) {
		SalePrice = salePrice;
	}
	public float getVipPrice() {
		return VipPrice;
	}
	public void setVipPrice(float vipPrice) {
		VipPrice = vipPrice;
	}

}
