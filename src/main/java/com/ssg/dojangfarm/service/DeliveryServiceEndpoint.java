package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Delivery;

@Component
@WebService(serviceName="DeliveryService")
public class DeliveryServiceEndpoint {
	//@Autowired
	DeliveryService deliveryService; // inject deliveryServiceImpl
	
	@WebMethod
	public Delivery getDelivery(int dNo) {
		return deliveryService.getDelivery(dNo);
	}
	
	@WebMethod
	public void changeDeliveryStatus(int dNo, String status) {
		deliveryService.changeDeliveryStatus(dNo, status);
	}
	
	@WebMethod
	public void addDelivery(Delivery delivery) {
		deliveryService.addDelivery(delivery);
	}
	@WebMethod
	public List<Delivery> getDeliveryListByUserNo(int userNo) {
		return deliveryService.getDeliveryListByUserNo(userNo);
	}
}
