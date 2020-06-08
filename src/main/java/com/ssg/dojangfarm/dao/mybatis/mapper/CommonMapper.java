package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;

public interface CommonMapper {
	public int insertSale(Common common);
	public int updateSale(Common common);
	public Common getCommonSale(int saleNo);
	public List<Common> getAllCommonList();
	public List<Common> getCommonListByUserNo(int userNo);
	public List<Common> searchCommon(String title);
	public int insertCommonjoin(int userNo, int saleNo);  //CommonJoin commonJoin
	public int cancelCommonjoin(int userNo);
	public int updateCommonjoin(int CJNo);
	public CommonJoin getCommonJoin(int cjNo);
	public List<CommonJoin> getCJList(int saleNo);
	public List<CommonJoin> getCJListByUserNo(int userNo);
}
