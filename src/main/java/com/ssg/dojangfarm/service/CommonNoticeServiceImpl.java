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
	public int updateCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.updateCommonNotice(cn);
	}

	@Override
	public int deleteCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.deleteCommonNotice(cn);
	}

	@Override
	public CommonNotice viewCommonNotice(int CNNo) {
		return commonNoticeDAO.viewCommonNotice(CNNo);
	}

	@Override
	public List<CommonNotice> getAllNoticeList() {
		return commonNoticeDAO.getAllNoticeList();
	}

	@Override
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return commonNoticeDAO.getCNoticeListByUserNo(userNo);
	}

	@Override
	public List<CommonNotice> searchCommonNotice(String word) {
		return commonNoticeDAO.searchCommonNotice(word);
	}

	
	

}
