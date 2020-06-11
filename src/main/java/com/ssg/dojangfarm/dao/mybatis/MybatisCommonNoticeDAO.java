package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.CommonNoticeDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.CommonNoticeMapper;
import com.ssg.dojangfarm.domain.CommonNotice;

@Repository
public class MybatisCommonNoticeDAO implements CommonNoticeDAO {
	@Autowired
	private CommonNoticeMapper cnMapper;
	
	public int insertCommonNotice(CommonNotice cn) {
		return cnMapper.insertCommonNotice(cn);
	}
	public int updateCommonNotice(CommonNotice cn) {
		return cnMapper.updateCommonNotice(cn);
	}
	public int deleteCommonNotice(CommonNotice cn) {
		return cnMapper.deleteCommonNotice(cn);
	}
	public CommonNotice viewCommonNotice(int CNNo) {
		return cnMapper.viewCommonNotice(CNNo);
	}
	public List<CommonNotice> getAllNoticeList() {
		return cnMapper.getAllNoticeList();
	}
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return cnMapper.getCNoticeListByUserNo(userNo);
	}
	public CommonNotice getCommonNotice(String userId) {
		return cnMapper.getCommonNotice(userId);
	}
}
