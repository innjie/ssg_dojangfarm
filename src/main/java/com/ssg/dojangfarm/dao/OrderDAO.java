package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.User;

public interface OrderDAO {
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public int CancelOrder(int orderNo);
	public int insertOrder(int userNo, Order order);
	List<String> getOrderUserList(int orderNo);
	

}
