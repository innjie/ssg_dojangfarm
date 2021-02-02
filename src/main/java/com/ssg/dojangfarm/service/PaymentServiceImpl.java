package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.PaymentDAO;
import com.ssg.dojangfarm.domain.Payment;

@Service("PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

	//@Autowired
	private PaymentDAO paymentDAO;

	@Override
	public Payment getPayment(int payNo) {
		return paymentDAO.getPayment(payNo);
	}

	@Override
	public void insertPayment(Payment payment) {
		paymentDAO.insertPayment(payment);
	}

	
}
