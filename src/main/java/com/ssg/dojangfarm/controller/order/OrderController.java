package com.ssg.dojangfarm.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.dojangfarm.service.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//cancelOrder
	//insertOrder
	
	//view Order
	//ViewOrderList
	//viewOrderUserList
	
}
