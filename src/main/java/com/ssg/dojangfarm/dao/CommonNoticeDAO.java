package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.CommonNotice;


public interface CommonNoticeDAO {
	int insertCommonNotice(CommonNotice cn);// throws dataAcception;
	void updateCommonNotice(CommonNotice cn);// throws dataAcception;
	void deleteCommonNotice(CommonNotice cn);// throws dataAcception;
	CommonNotice viewCommonNotice(CommonNotice cn);
	List<CommonNotice> getAllNoticeList();
	List<CommonNotice> getCNoticeListByUserNo(int userNo);
}
