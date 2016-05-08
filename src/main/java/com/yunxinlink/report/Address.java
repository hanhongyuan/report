package com.yunxinlink.report;

/**
 * 
 * @author huanghui1
 * @version 1.0.0
 * @update 2016年5月7日 下午6:20:36
 */
public class Address {
	private int id;
	
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
