package com.ssg.dojangfarm.dao;


import java.util.List;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;


public interface CommonDAO {
	int insertCommon(Common common);
	int updateCommon(Common common);
	Common getCommonSale(int saleNo);
	List<Common> getAllCommonList();
	List<Common> getCommonListByUserNo(int userNo);
	List<Common> searchCommon(String title);
	int insertCommonjoin(CommonJoin commonJoin);  
	int cancelCommonjoin( int CJNo);
	int updateCommonjoin(CommonJoin commonJoin);
	CommonJoin getCommonJoin(int cjNo);
	List<CommonJoin> getCJList(int saleNo);
	List<CommonJoin> getCJListByUserNo(int userNo);
	List<CommonJoin> getCommonJoinListByUserNo(int userNo);
	List<CommonJoin> getCommonJoinListBySaleNo(int saleNo);
	CommonJoin ExistCommonJoin(int userNo, int saleNo);
	void addCommonImage(int saleNo, String string);
	int getLastCommonSaleNo();
	int getLastCJNo();
}

