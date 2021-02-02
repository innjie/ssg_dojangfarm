package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Refund;



public interface RefundDAO {
	int refundSale(Refund refund);
	Refund getRefund(int refundNo);
	List<Refund> getRefundList(int userNo);

}
