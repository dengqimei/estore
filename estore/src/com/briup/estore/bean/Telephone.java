package com.briup.estore.bean;

import java.io.Serializable;

public class Telephone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int telId;
	private String homeTel;
	private String officeTel;
	private String mobile;
	
	public Telephone() {}

	public Telephone(int telId, String homeTel, String officeTel, String mobile) {
		this.telId = telId;
		this.homeTel = homeTel;
		this.officeTel = officeTel;
		this.mobile = mobile;
	}

	public Telephone(String homeTel, String officeTel, String mobile) {
		super();
		this.homeTel = homeTel;
		this.officeTel = officeTel;
		this.mobile = mobile;
	}

	public int getTelId() {
		return telId;
	}

	public void setTelId(int telId) {
		this.telId = telId;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Telephone [telId=" + telId + ", homeTel=" + homeTel + ", officeTel=" + officeTel + ", mobile=" + mobile
				+ "]";
	}

}
