package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.CommonNotice;

public interface CommonNoticeService {
	
	public int insertCommonNotice(CommonNotice cn);// throws dataAcception;
	public void updateCommonNotice(CommonNotice cn);// throws dataAcception;
	public void deleteCommonNotice(CommonNotice cn);// throws dataAcception;
	public CommonNotice viewCommonNotice(CommonNotice cn);
	public List<CommonNotice> getAllNoticeList();
	public List<CommonNotice> getCNoticeListByUserNo(int userNo);
}
