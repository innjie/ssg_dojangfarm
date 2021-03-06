package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;

@Component
@WebService(serviceName="CommonService")
public class CommonServiceEndpoint {
	@Autowired
	CommonService commonService;

	
	@WebMethod
	public int insertCommon( Common common) {
		return commonService.insertCommon(common);
	}

	@WebMethod
	public int updateCommon(Common common) {
		return commonService.updateCommon(common);
	}

	@WebMethod
	public Common getCommonSale(int saleNo) {
		return commonService.getCommonSale(saleNo);
	}

	@WebMethod
	public List<Common> getAllCommonList() {
		return commonService.getAllCommonList();
	}

	@WebMethod
	public List<Common> getCommonListByUserNo(int userNo) {
		return commonService.getCommonListByUserNo(userNo);
	}

	@WebMethod
	public List<Common> searchCommon(String title) {
		return commonService.searchCommon(title);
	}

	@WebMethod
	public int insertCommonjoin(CommonJoin commonJoin) {
		return commonService.insertCommonjoin(commonJoin);
	}

	@WebMethod
	public int cancelCommonjoin( int CJNo) {
		return commonService.cancelCommonjoin( CJNo);
	}

	@WebMethod
	public int updateCommonjoin(CommonJoin commonJoin) {
		return commonService.updateCommonjoin(commonJoin);
	}
	@WebMethod
	public List<CommonJoin> getCommonJoinListByUserNo(int userNo) {
		return commonService.getCommonJoinListByUserNo(userNo);
	}
	@WebMethod
	public List<CommonJoin> getCommonJoinListBySaleNo(int saleNo) {
		return commonService.getCommonJoinListBySaleNo(saleNo);
	}
	@WebMethod
	public CommonJoin ExistCommonJoin(int userNo, int saleNo) {
		return commonService.ExistCommonJoin(userNo, saleNo);
	}
}
