package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.DeliveryDAO;
import com.ssg.dojangfarm.domain.Delivery;

@Service("DeliveryServiceImpl")
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	@Override
	public Delivery getDelivery(int dNo) {
		return deliveryDAO.getDelivery(dNo);
	}
	@Override
	public void changeDeliveryStatus(int dNo) {
		deliveryDAO.changeDeliveryStatus(dNo);
	}
	@Override
	public void addDelivery(Delivery delivery) {
		deliveryDAO.addDelivery(delivery);
	}
	@Override
	public List<Delivery> getDeliveryListByUserNo(int userNo) {
		return deliveryDAO.getDeliveryListByUserNo(userNo);
	}
	@Override
	public void changeDeliveryFinish(int dNo) {
		deliveryDAO.changeDeliveryFinish(dNo);
		
	}

}
