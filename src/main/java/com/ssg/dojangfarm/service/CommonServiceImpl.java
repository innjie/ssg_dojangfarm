package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.CommonDAO;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;

@Service("CommonServiceImpl")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public int insertCommon(Common common) {
		return commonDAO.insertCommon(common);
	}

	@Override
	public int updateCommon(Common common) {
		return commonDAO.updateCommon(common);
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
	public int updateCommonjoin(CommonJoin commonJoin) {
		return commonDAO.updateCommonjoin( commonJoin);
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
	public List<CommonJoin> getCommonJoinListByUserNo(int userNo) {
		return commonDAO.getCommonJoinListByUserNo(userNo);
	}
	@Override
	public List<CommonJoin> getCommonJoinListBySaleNo(int saleNo) {
		return commonDAO.getCommonJoinListBySaleNo(saleNo);
	}
	@Override
	public CommonJoin ExistCommonJoin(int userNo, int saleNo) {
		return commonDAO.ExistCommonJoin(userNo, saleNo);
	}

	

	

}
