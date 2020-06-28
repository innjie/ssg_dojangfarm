package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.DeliveryDAO;
import com.ssg.dojangfarm.domain.Delivery;

@Service("addressServiceImpl")
public class DeliveryServiceImpl {
	
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	public Delivery getDelivery(int dNo) {
		return deliveryDAO.getDelivery(dNo);
	}
	public void changeDeliveryStatus(int dNo) {
		deliveryDAO.changeDeliveryStatus(dNo);
	}
	public void addDelivery(Delivery delivery) {
		deliveryDAO.addDelivery(delivery);
	}
	public List<Delivery> getDeliveryListByUserNo(int userNo) {
		return deliveryDAO.getDeliveryListByUserNo(userNo);
	}
}
