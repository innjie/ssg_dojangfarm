package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.Payment;

public interface PaymentMapper {
	public Payment getPayment(int payNo);
	public void insertPayment(Payment payment);
	public int getLastPayNo();
	public void normalPayment(Payment payment);
	public void insertPaymentKakao(Payment payment);
}
