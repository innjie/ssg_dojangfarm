package com.ssg.dojangfarm.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class PaymentController  {

	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	public void insertPayment(int payNo) {

	}
	public void getPayment(int payNo) {

	}
	public void getPaymentListByUserNo(int userNo) {
		
	}
}
