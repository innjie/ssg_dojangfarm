package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.CommonNotice;

public interface CommonNoticeService {
	
	public int insertCommonNotice(CommonNotice cn);// throws dataAcception;
	public int updateCommonNotice(CommonNotice cn);// throws dataAcception;
	public int deleteCommonNotice(CommonNotice cn);// throws dataAcception;
	public CommonNotice viewCommonNotice(int CNNo);
	public List<CommonNotice> getAllNoticeList();
	public List<CommonNotice> getCNoticeListByUserNo(int userNo);
	public List<CommonNotice> searchCommonNotice(String word);
}
