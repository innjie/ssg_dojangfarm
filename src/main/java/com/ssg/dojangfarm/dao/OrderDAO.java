package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;
import com.ssg.dojangfarm.domain.User;

public interface OrderDAO {
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public int cancelOrder(int orderNo);
	public int insertOrder( Order order);
	List<Order> getOrderUserList(int orderNo);
	public int getLastOrderNo();
	

}
