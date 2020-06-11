package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.CommonNotice;

public interface CommonNoticeMapper {
	int insertCommonNotice(CommonNotice cn);
	int updateCommonNotice(CommonNotice cn);
	int deleteCommonNotice(CommonNotice cn);
	CommonNotice viewCommonNotice(int CNNo);
	List<CommonNotice> getAllNoticeList();
	List<CommonNotice> getCNoticeListByUserNo(int userNo);
	CommonNotice getCommonNotice(String userId);
}
