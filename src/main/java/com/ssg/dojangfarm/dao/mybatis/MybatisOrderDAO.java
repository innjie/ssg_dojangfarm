package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.dao.OrderDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.OrderMapper;
import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;

public class MybatisOrderDAO implements OrderDAO{
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Order getOrder(int orderNo) {
		return orderMapper.getOrder(orderNo);
	}

	@Override
	public List<Order> getOrderList(int userNo) {
		return orderMapper.getOrderList(userNo);
	}

	@Override
	public int cancelOrder(int orderNo) {
		return orderMapper.cancelOrder(orderNo);
	}

	@Override
	public int insertOrder(int userNo, Order order) {
		return orderMapper.insertOrder(userNo, order);
	}

	@Override
	public List<Order> getOrderUserList(int orderNo) {
		return orderMapper.getOrderUserList(orderNo);
	}

	
}
