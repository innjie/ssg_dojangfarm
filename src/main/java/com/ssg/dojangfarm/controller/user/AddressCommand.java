package com.ssg.dojangfarm.controller.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.ssg.dojangfarm.domain.User;

public class AddressCommand {
	@NotEmpty
	private String addr;	//address
	@NotEmpty @Pattern(regexp="\\d{5}")
	private String zip;		//zip code
	@NotEmpty
	private String detail;		//detail addr
	private String aName;
	private boolean newAddress;
	
	public AddressCommand(String addr, String zip, String detail, String aName) {
		super();
		this.addr = addr;
		this.zip = zip;
		this.detail = detail;
		this.aName = aName;
		this.newAddress = false;
	}
	
	public AddressCommand() {
		super();
		this.newAddress = true;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public boolean isNewAddress() {
		return newAddress;
	}
	
}
