package com.tsinghua.saleshopmanager.vo;
import java.sql.Timestamp;

public class InStore {
	private String inStoreId;
	private String gid;
	private int gpid;
	private int inStoreAmount;
	private float purchasePrice;
	private String inStoreTime;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getGpid() {
		return gpid;
	}
	public void setGpid(int gpid) {
		this.gpid = gpid;
	}
	public int getInStoreAmount() {
		return inStoreAmount;
	}
	public void setInStoreAmount(int inStoreAmount) {
		this.inStoreAmount = inStoreAmount;
	}
	public String getInStoreId() {
		return inStoreId;
	}
	public void setInStoreId(String inStoreId) {
		this.inStoreId = inStoreId;
	}
	
	public float getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getInStoreTime() {
		return inStoreTime;
	}
	public void setInStoreTime(String inStoreTime) {
		this.inStoreTime = inStoreTime;
	}
	

}
