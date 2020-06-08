package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.dao.NormalDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.NormalMapper;
import com.ssg.dojangfarm.domain.Normal;

public class MybatisNormalDAO implements NormalDAO{
	@Autowired
	private NormalMapper normalMapper;
	
	public int insertSale( Normal normal) {
		return normalMapper.insertSale(normal);
	}
	public int updateSale(Normal normal) {
		return normalMapper.updateSale(normal);
	}
	public Normal getNormalSale(int saleNo) {
		return normalMapper.getNormalSale(saleNo);
	}
	public List<Normal> getAllNormalList() {
		return normalMapper.getAllNormalList();
	}
	public List<Normal> getNormalListByUserNo(int userNo) {
		return normalMapper.getNormalListByUserNo(userNo);
	}
	public List<Normal> searchNormal(String title) {
		return normalMapper.searchNormal(title);
	}
	public int turnSaleState(int saleNo) {
		return normalMapper.turnSaleState(saleNo);
	}
}
