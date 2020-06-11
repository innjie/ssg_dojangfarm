package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.CommonNotice;


public interface CommonNoticeDAO {
	int insertCommonNotice(CommonNotice cn);// throws dataAcception;
	int updateCommonNotice(CommonNotice cn);// throws dataAcception;
	int deleteCommonNotice(CommonNotice cn);// throws dataAcception;
	CommonNotice viewCommonNotice(int CNNo);
	List<CommonNotice> getAllNoticeList();
	List<CommonNotice> getCNoticeListByUserNo(int userNo);
}
