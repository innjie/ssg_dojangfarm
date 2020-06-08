package com.ssg.dojangfarm.dao;


import java.util.List;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;


public interface CommonDAO {
	//Common() throws dataAcception;
	int insertSale( Common common);
	int updateSale(Common common);
	Common getCommonSale(int saleNo);
	List<Common> getAllCommonList();
	List<Common> getCommonListByUserNo(int userNo);
	List<Common> searchCommon(String title);
	int insertCommonjoin(int userNo, int saleNo);  //CommonJoin commonJoin
	int cancelCommonjoin( int CJNo);
	int updateCommonjoin(int CJNo);
	CommonJoin getCommonJoin(int cjNo);
	List<CommonJoin> getCJList(int saleNo);
	List<CommonJoin> getCJListByUserNo(int userNo);
}

