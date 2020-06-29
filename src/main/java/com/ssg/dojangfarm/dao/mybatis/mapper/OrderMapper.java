package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;

public interface OrderMapper {
	Order getOrder(int orderNo);
	List<Order> getOrderList(int userNo);
	int cancelOrder(int orderNo);
	int insertOrder( Order order);
	List<Order> getOrderUserList(int orderNo);
	List<Refund> getRefundList(int userNo);
	Refund getRefund(int refundNo);
}
