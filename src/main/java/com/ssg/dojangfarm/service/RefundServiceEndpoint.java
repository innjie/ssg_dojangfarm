package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Refund;

@Component
@WebService(serviceName="RefundService")
public class RefundServiceEndpoint {
	@Autowired
	RefundService refundService; // inject RefundServiceImpl

	@WebMethod
	public int refundSale(Refund refund) {
		return refundService.refundSale(refund);
	}

	@WebMethod
	public Refund getRefund(int refundNo) {
		return refundService.getRefund(refundNo);
	}

	@WebMethod
	public List<Refund> getRefundList(int userNo) {
		return refundService.getRefundList(userNo);
	}

}
