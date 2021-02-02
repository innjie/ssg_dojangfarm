package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Payment;

@Component
@WebService(serviceName="PaymentService")
public class PaymentServiceEndpoint {
	//@Autowired
	PaymentService paymentService; // inject PaymentServiceImpl

	@WebMethod
	public Payment getPayment(int payNo) {
		return paymentService.getPayment(payNo);
	}

	@WebMethod
	public void insertPayment(Payment payment) {
		paymentService.insertPayment(payment);
	}

}
