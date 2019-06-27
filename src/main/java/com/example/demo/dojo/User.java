package com.example.demo.dojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	
	private String name;
	
	@JsonIgnore
	private String phone;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date createTime;
	
	@JsonProperty(value="dizhi")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User(String name,String phone, Date createTime, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.createTime = createTime;
		this.address = address;
	}
	
	
}
