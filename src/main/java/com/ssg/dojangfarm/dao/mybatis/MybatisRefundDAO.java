package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.dao.RefundDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.RefundMapper;
import com.ssg.dojangfarm.domain.Refund;

public class MybatisRefundDAO implements RefundDAO  {
	@Autowired
	private RefundMapper refundMapper;

	@Override
	public int refundSale(int saleNo) {
		return refundMapper.refundSale(saleNo);
	}

	@Override
	public Refund getRefund(int refundNo) {
		return refundMapper.getRefund(refundNo);
	}

	@Override
	public List<Refund> getRefundList(int userNo) {
		return refundMapper.getRefundList(userNo);
	}
	
}
