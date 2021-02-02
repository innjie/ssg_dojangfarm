package com.ssg.dojangfarm.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.dojangfarm.service.OrderService;

@Controller
public class RestfulOrderController {

	private OrderService orderSevice;

	@Autowired
	public void setFarmSvc(OrderService orderService) {
		this.orderSevice = orderService;
	}
}
