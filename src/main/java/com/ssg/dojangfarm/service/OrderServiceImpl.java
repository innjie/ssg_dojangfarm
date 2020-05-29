package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.OrderDAO;
import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	public Order getOrder(int orderNo) {
		return orderDAO.getOrder(orderNo);
	}
	
	public List<Order> getOrderList(int userNo) {
		return orderDAO.getOrderList(userNo);
	}
	
	public int CancelOrder(int orderNo) {
		return orderDAO.CancelOrder(orderNo);
	}

	@Override
	public int insertOrder(int userNo, Order order) {
		return orderDAO.insertOrder(userNo, order);
	}

	@Override
	public List<Order> getUserList(int orderNo) {
		return orderDAO.getOrderUserList(orderNo);
	}

	@Override
	public List<Refund> getRefundList(int userNo) {
		return orderDAO.getRefundList(userNo);
	}

	@Override
	public Refund getRefund(int refundNo) {
		return orderDAO.getRefund(refundNo);
	}
}
