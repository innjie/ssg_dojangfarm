package com.ssg.dojangfarm.dao;


import java.util.List;

import com.ssg.dojangfarm.domain.Common;


public interface CommonDAO {
	//Common() throws dataAcception;
	int insertSale(Common common);
	int updateSale(Common common);
	Common getCommonSale(int saleNo);
	List<Common> getAllCommonList();
	List<Common> getCommonListByUserNo(int userNo);
	List<Common> searchCommon(String title);
	int insertCommonjoin(int userNo, int saleNo);  //CommonJoin commonJoin
	int cancelCommonjoin(int userNo, int CJNo);
	int updateCommonjoin(int userNo, int CJNo);

}

