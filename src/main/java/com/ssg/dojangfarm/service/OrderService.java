package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;

public interface OrderService {
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public int cancelOrder(int orderNo);
	public int insertOrder( Order order);
	public List<Order> getOrderUserList(int orderNo);

}
