package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;

public interface OrderService {
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public int CancelOrder(int orderNo);
	public int insertOrder(int userNo, Order order);
	public List<String> getUserList(int orderNo);
}
