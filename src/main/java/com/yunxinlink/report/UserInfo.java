package com.yunxinlink.report;

/**
 * 
 * @author huanghui1
 * @version 1.0.0
 * @update 2016年5月6日 上午10:16:36
 */
public class UserInfo {
	private int id;
	
	private String name;
	
	private String address;

	public UserInfo(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
