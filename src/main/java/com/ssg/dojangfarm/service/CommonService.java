package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;
import com.ssg.dojangfarm.domain.CommonNotice;

public interface CommonService {
	public int insertCommon(Common common);
	public int updateCommon(Common common);
	public Common getCommonSale(int saleNo);
	public List<Common> getAllCommonList();
	public List<Common> getCommonListByUserNo(int userNo);
	public List<Common> searchCommon(String title);
	
	public int insertCommonjoin(CommonJoin commonJoin);  
	public int cancelCommonjoin(int userNo);
	public int updateCommonjoin(int CJNo);
	public CommonJoin getCommonJoin(int cjNo);
	List<CommonJoin> getCJList(int saleNo);
	List<CommonJoin> getCJListByUserNo(int userNo);
}
