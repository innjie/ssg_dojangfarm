package com.ssg.dojangfarm.service;

import com.ssg.dojangfarm.domain.Delivery;

public interface DeliveryService {
	Delivery getDelivery(int dNo);
	void changeDeliveryStatus(int dNo, String status);
	void addDelivery(Delivery delivery);
}
