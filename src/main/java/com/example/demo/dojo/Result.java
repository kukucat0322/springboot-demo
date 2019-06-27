package com.example.demo.dojo;

public class Result {
	private int retCode;
	private String msg;
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Result(int retCode, String msg) {
		super();
		this.retCode = retCode;
		this.msg = msg;
	}
	
}
