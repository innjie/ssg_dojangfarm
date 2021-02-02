package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.Refund;



public interface PaymentDAO {
	Payment getPayment(int payNo);
	void insertPayment(Payment payment);

}
