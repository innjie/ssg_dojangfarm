package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.CommonDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.CommonMapper;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;

@Repository 
public class MybatisCommonDAO implements CommonDAO{
	@Autowired
	private CommonMapper commonMapper;
	
	public int insertCommon(Common common) {
		return commonMapper.insertCommon(common);
	}
	public int updateCommon(Common common) {
		return commonMapper.updateCommon(common);
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
	public int updateCommonjoin(CommonJoin commonJoin) {
		return commonMapper.updateCommonjoin(commonJoin);
	}
	public CommonJoin getCommonJoin(int cjNo) {
		return commonMapper.getCommonJoin(cjNo);
	}
	public List<CommonJoin> getCJList(int saleNo) {
		return commonMapper.getCJList(saleNo);
	}
	public List<CommonJoin> getCJListByUserNo(int userNo) {
		return commonMapper.getCJListByUserNo(userNo);
	}
	@Override
	public List<CommonJoin> getCommonJoinListByUserNo(int userNo) {
		return commonMapper.getCommonJoinListByUserNo(userNo);
	}
	@Override
	public List<CommonJoin> getCommonJoinListBySaleNo(int saleNo) {
		return commonMapper.getCommonJoinListBySaleNo(saleNo);
	}
	@Override
	public CommonJoin ExistCommonJoin(int userNo, int saleNo) {
		return commonMapper.ExistCommonJoin(userNo, saleNo);
	}
}
