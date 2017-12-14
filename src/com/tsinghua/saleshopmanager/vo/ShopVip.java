package com.tsinghua.saleshopmanager.vo;

public class ShopVip {
	private String VId;
	private String VName;
	private String VPhone;
	private float ConsumeSum;
	private int ConsumeScore;
	private int ConsumeCount;
	private float ConsumeRate;
	private String VBirthday;
	private float VBalance;
	public int getConsumeCount() {
		return ConsumeCount;
	}
	public void setConsumeCount(int consumeCount) {
		ConsumeCount = consumeCount;
	}
	public float getConsumeRate() {
		return ConsumeRate;
	}
	public void setConsumeRate(float consumeRate) {
		ConsumeRate = consumeRate;
	}
	public int getConsumeScore() {
		return ConsumeScore;
	}
	public void setConsumeScore(int consumeScore) {
		ConsumeScore = consumeScore;
	}
	public float getConsumeSum() {
		return ConsumeSum;
	}
	public void setConsumeSum(float consumeSum) {
		ConsumeSum = consumeSum;
	}
	public float getVBalance() {
		return VBalance;
	}
	public void setVBalance(float balance) {
		VBalance = balance;
	}
	public String getVBirthday() {
		return VBirthday;
	}
	public void setVBirthday(String birthday) {
		VBirthday = birthday;
	}
	public String getVId() {
		return VId;
	}
	public void setVId(String id) {
		VId = id;
	}
	public String getVName() {
		return VName;
	}
	public void setVName(String name) {
		VName = name;
	}
	public String getVPhone() {
		return VPhone;
	}
	public void setVPhone(String phone) {
		VPhone = phone;
	}

}
