package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Refund;

public interface RefundMapper {
	int refundSale(Refund refund);
	Refund getRefund(int refundNo);
	List<Refund> getRefundList(int userNo);
	int getLastRefundNo();

}
