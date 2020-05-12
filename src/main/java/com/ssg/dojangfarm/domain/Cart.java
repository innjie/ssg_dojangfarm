package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Cart implements Serializable{
	private int cartNo;
	private User user;
	private List<Item> itemList;
	
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	
}
