package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.CommonNoticeDAO;
import com.ssg.dojangfarm.domain.CommonNotice;

@Service("CommonNoticeServiceImpl")
public class CommonNoticeServiceImpl implements CommonNoticeService {

	@Autowired
	private CommonNoticeDAO commonNoticeDAO;

	@Override
	public int insertCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.insertCommonNotice(cn);
	}

	@Override
	public void updateCommonNotice(CommonNotice cn) {
		commonNoticeDAO.updateCommonNotice(cn);
	}

	@Override
	public void deleteCommonNotice(CommonNotice cn) {
		commonNoticeDAO.deleteCommonNotice(cn);
	}

	@Override
	public CommonNotice viewCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.viewCommonNotice(cn);
	}

	@Override
	public List<CommonNotice> getAllNoticeList() {
		return commonNoticeDAO.getAllNoticeList();
	}

	@Override
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return commonNoticeDAO.getCNoticeListByUserNo(userNo);
	}

	

}
