package com.tsinghua.saleshopmanager.vo;

public class VipSaveMoney {
	private int vsid;
	private String vid;
	private String vtime;
	private float VMoney;
	private String UId;
	public String getUId() {
		return UId;
	}
	public void setUId(String id) {
		UId = id;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public float getVMoney() {
		return VMoney;
	}
	public void setVMoney(float money) {
		VMoney = money;
	}
	public int getVsid() {
		return vsid;
	}
	public void setVsid(int vsid) {
		this.vsid = vsid;
	}
	public String getVtime() {
		return vtime;
	}
	public void setVtime(String vtime) {
		this.vtime = vtime;
	}

}
