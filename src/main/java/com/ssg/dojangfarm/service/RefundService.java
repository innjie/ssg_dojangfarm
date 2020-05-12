package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Refund;


public interface RefundService {
	public int refundSale(int saleNo);
	public Refund getRefund(int refundNo);
	public List<Refund> getRefundList(int userNo);
}
