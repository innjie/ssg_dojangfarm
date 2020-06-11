package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.CommonDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.CommonMapper;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;

@Repository 
public class MybateisCommonDAO implements CommonDAO{
	@Autowired
	private CommonMapper commonMapper;
	
	public int insertSale(Common common) {
		return commonMapper.insertSale(common);
	}
	public int updateSale(Common common) {
		return commonMapper.updateSale(common);
	}
	public Common getCommonSale(int saleNo) {
		return commonMapper.getCommonSale(saleNo);
	}
	public List<Common> getAllCommonList() {
		return commonMapper.getAllCommonList();
	}
	public List<Common> getCommonListByUserNo(int userNo) {
		return commonMapper.getCommonListByUserNo(userNo);
	}
	public List<Common> searchCommon(String title) {
		return commonMapper.searchCommon(title);
	}
	public int insertCommonjoin(CommonJoin commonJoin) {
		return commonMapper.insertCommonjoin(commonJoin);
	}
	public int cancelCommonjoin(int userNo) {
		return commonMapper.cancelCommonjoin(userNo);
	}
	public int updateCommonjoin(int CJNo) {
		return commonMapper.updateCommonjoin(CJNo);
	}
	public CommonJoin getCommonJoin(int cjNo) {
		return commonMapper.getCommonJoin(cjNo);
	}
	@Override
	public List<CommonJoin> getCJList(int saleNo) {
		return commonMapper.getCJList(saleNo);
	}
	@Override
	public List<CommonJoin> getCJListByUserNo(int userNo) {
		return commonMapper.getCJListByUserNo(userNo);
	}
}
