package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.CommonDAO;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;
import com.ssg.dojangfarm.domain.CommonNotice;

@Service("CommonServiceImpl")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public int insertSale(Common common) {
		return commonDAO.insertSale(common);
	}

	@Override
	public int updateSale(Common common) {
		return commonDAO.updateSale(common);
	}

	@Override
	public Common getCommonSale(int saleNo) {
		return commonDAO.getCommonSale(saleNo);
	}

	@Override
	public List<Common> getAllCommonList() {
		return commonDAO.getAllCommonList();
	}

	@Override
	public List<Common> getCommonListByUserNo(int userNo) {
		return commonDAO.getCommonListByUserNo(userNo);
	}

	@Override
	public List<Common> searchCommon(String title) {
		return commonDAO.searchCommon(title);
	}

	@Override
	public int insertCommonjoin(CommonJoin commonJoin) {
		return commonDAO.insertCommonjoin(commonJoin);
	}

	@Override
	public int cancelCommonjoin(int CJNo) {
		return commonDAO.cancelCommonjoin( CJNo);
	}

	@Override
	public int updateCommonjoin( int CJNo) {
		return commonDAO.updateCommonjoin( CJNo);
	}
	@Override
	public CommonJoin getCommonJoin(int CJNo) {
		return commonDAO.getCommonJoin(CJNo);
	}

	@Override
	public List<CommonJoin> getCJList(int saleNo) {
		return commonDAO.getCJList(saleNo);
	}

	@Override
	public List<CommonJoin> getCJListByUserNo(int userNo) {
		return commonDAO.getCJListByUserNo(userNo);
	}
}
