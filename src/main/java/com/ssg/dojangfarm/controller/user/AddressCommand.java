package com.ssg.dojangfarm.controller.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.ssg.dojangfarm.domain.User;

public class AddressCommand {
	@NotEmpty
	private String address;	//address
	@Pattern(regexp="\\d{5}")
	private int zip;		//zip code
	@NotEmpty
	private String detail;		//detail addr
	private String aName;
	
	
	public AddressCommand() {
		super();
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
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
	
	
}
