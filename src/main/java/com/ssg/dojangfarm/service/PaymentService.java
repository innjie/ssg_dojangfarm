package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Payment;


public interface PaymentService {
	public Payment getPayment(int payNo);
	public void insertPayment(Payment payment);
}
