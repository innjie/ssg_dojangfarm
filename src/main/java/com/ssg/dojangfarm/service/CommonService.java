package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonNotice;

public interface CommonService {
	public int insertSale(Common common);
	public int updateSale(Common common);
	public Common getCommonSale(int saleNo);
	public List<Common> getAllCommonList();
	public List<Common> getCommonListByUserNo(int userNo);
	public List<Common> searchCommon(String title);
	public int insertCommonjoin(int userNo, int saleNo);  //CommonJoin commonJoin
	public int cancelCommonjoin(int userNo, int CJNo);
	public int updateCommonjoin(int userNo, int CJNo);
}
