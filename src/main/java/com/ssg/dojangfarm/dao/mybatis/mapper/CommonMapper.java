package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;

public interface CommonMapper {
	public int insertCommon(Common common);
	public int updateCommon(Common common);
	public Common getCommonSale(int saleNo);
	public List<Common> getAllCommonList();
	public List<Common> getCommonListByUserNo(int userNo);
	public List<Common> searchCommon(String title);
	public int insertCommonjoin(CommonJoin commonJoin);  //
	public int cancelCommonjoin(int userNo);
	public int updateCommonjoin(int CJNo);
	public CommonJoin getCommonJoin(int cjNo);
	public List<CommonJoin> getCJList(int saleNo);
	public List<CommonJoin> getCJListByUserNo(int userNo);
}