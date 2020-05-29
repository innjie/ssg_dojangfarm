package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;

public interface OrderService {
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public int CancelOrder(int orderNo);
	public int insertOrder(int userNo, Order order);
	public List<Order> getUserList(int orderNo);
	public List<Refund> getRefundList(int userNo);
	public Refund getRefund(int refundNo);
}
