package com.briup.estore.bean;

import java.io.Serializable;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int addrId;
	private String country;
	private String province;
	private String city;
	private String street1;
	private String street2;
	
	public Address() {}

	public Address(int addrId, String country, String province, String city, String street1, String street2) {
		this.addrId = addrId;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street1 = street1;
		this.street2 = street2;
	}

	public Address(String country, String province, String city, String street1, String street2) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.street1 = street1;
		this.street2 = street2;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", street1=" + street1 + ", street2=" + street2 + "]";
	}
	
}
