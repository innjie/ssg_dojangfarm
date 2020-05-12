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
	public void updateCommonNotice(CommonNotice cn) {
		commonNoticeService.updateCommonNotice(cn);
	}

	@WebMethod
	public void deleteCommonNotice(CommonNotice cn) {
		commonNoticeService.deleteCommonNotice(cn);
	}

	@WebMethod
	public CommonNotice viewCommonNotice(CommonNotice cn) {
		return commonNoticeService.viewCommonNotice(cn);
	}

	@WebMethod
	public List<CommonNotice> getAllNoticeList() {
		return commonNoticeService.getAllNoticeList();
	}

	@WebMethod
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return commonNoticeService.getCNoticeListByUserNo(userNo);
	}

}
