package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.RefundDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.RefundMapper;
import com.ssg.dojangfarm.domain.Refund;

@Repository
public class MybatisRefundDAO implements RefundDAO  {
	@Autowired
	private RefundMapper refundMapper;

	@Override
	public int refundSale(Refund refund) {
		return refundMapper.refundSale(refund);
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
