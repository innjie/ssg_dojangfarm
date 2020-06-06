package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Order;

@Component
@WebService(serviceName="OrderService")
public class OrderServiceEndpoint {
	@Autowired
	OrderService orderService; // inject orderSeviceImpl


	public Order getOrder(int orderNo) {
		return orderService.getOrder(orderNo);
	}
	
	public List<Order> getOrderList(int userNo) {
		return orderService.getOrderList(userNo);
	}
	
	public void CancelOrder(int orderNo) {
		orderService.cancelOrder(orderNo);
	}
}


