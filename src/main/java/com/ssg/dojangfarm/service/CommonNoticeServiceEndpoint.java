package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.CommonNotice;


@Component
@WebService(serviceName="CommonNoticeService")
public class CommonNoticeServiceEndpoint {
	@Autowired
	CommonNoticeService commonNoticeService; // inject CommonNoticeService

	@WebMethod
	public int insertCommonNotice(CommonNotice cn) {
		return commonNoticeService.insertCommonNotice(cn);
	}

	@WebMethod
	public int updateCommonNotice(CommonNotice cn) {
		return commonNoticeService.updateCommonNotice(cn);
	}

	@WebMethod
	public int deleteCommonNotice(CommonNotice cn) {
		return commonNoticeService.deleteCommonNotice(cn);
	}

	@WebMethod
	public CommonNotice viewCommonNotice(int CNNo) {
		return commonNoticeService.viewCommonNotice(CNNo);
	}

	@WebMethod
	public List<CommonNotice> getAllNoticeList() {
		return commonNoticeService.getAllNoticeList();
	}

	@WebMethod
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return commonNoticeService.getCNoticeListByUserNo(userNo);
	}
	@WebMethod
	public List<CommonNotice> searchCommonNotice(String word) {
		return commonNoticeService.searchCommonNotice(word);
	}

}
