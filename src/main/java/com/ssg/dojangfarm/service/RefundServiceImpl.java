package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.RefundDAO;
import com.ssg.dojangfarm.domain.Refund;



@Service("RefundServiceImpl")
public class RefundServiceImpl implements RefundService {

	@Autowired
	private RefundDAO refundDAO;

	@Override
	public int refundSale(int saleNo) {
		return refundDAO.refundSale(saleNo);
	}

	@Override
	public Refund getRefund(int refundNo) {
		return refundDAO.getRefund(refundNo);
	}

	@Override
	public List<Refund> getRefundList(int userNo) {
		return refundDAO.getRefundList(userNo);
	}

	
}
