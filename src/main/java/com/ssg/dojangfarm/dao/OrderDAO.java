package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.User;

public interface OrderDAO {
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public void CancelOrder(int orderNo);
	void insertOrder(Order order);
	List<User> getOrderUserList(int orderNo);

}
