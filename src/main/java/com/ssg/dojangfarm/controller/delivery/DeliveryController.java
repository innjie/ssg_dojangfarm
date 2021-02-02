package com.ssg.dojangfarm.controller.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.service.FarmFacade;
@Controller
public class DeliveryController {
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	public String addDelivery(Delivery deli) {
		
		return null;
	}
	public String changeDeliveryStatus(int dNo, String status) {
		return null;
	}
	public String getDelivery(int dNo) {
		return null;
	}
	public String getDeliveryListByUserNo() {
		return null;
	}
	public String getDeliveryListBySaleNo() {
		return null;
	}
}
