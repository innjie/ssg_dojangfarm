package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.PaymentDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.PaymentMapper;
import com.ssg.dojangfarm.domain.Payment;
@Repository
public class MybatisPaymentDAO implements PaymentDAO{
	@Autowired
	private PaymentMapper paymentMapper;
	
	public Payment getPayment(int payNo) {
		return paymentMapper.getPayment(payNo);
	}
	
	public void insertPayment(Payment payment) {
		paymentMapper.insertPayment(payment);
	}

	@Override
	public int getLastPayNo() {
		return paymentMapper.getLastPayNo();
	}

	@Override
	public void normalPayment(Payment payment) {
		paymentMapper.normalPayment(payment);
	}
	

}
