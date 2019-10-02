package com.irctc.model;

public class Passanger {
	private String name;
	private int age;
	private String adharNo;
	private String mobileNo;
	private String source;
	private String destination;
	private String journeyDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	@Override
	public String toString() {
		return "Passanger [name=" + name + ", age=" + age + ", adharNo="
				+ adharNo + ", mobileNo=" + mobileNo + ", source=" + source
				+ ", destination=" + destination + ", journeyDate="
				+ journeyDate + "]";
	}
	
	
	
}
