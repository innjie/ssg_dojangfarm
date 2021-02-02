package com.ssg.dojangfarm.dao;

import com.ssg.dojangfarm.domain.Delivery;

public interface DeliveryDAO {
	public Delivery getDelivery(int dNo);
	public void changeDeliveryStatus(int dNo, String status);
	public void addDelivery(Delivery delivery);

}
