package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.NormalDAO;
import com.ssg.dojangfarm.domain.Normal;



@Service("NormalServiceImpl")
public class NormalServiceImpl implements NormalService {

	@Autowired
	private NormalDAO normalDAO;

	@Override
	public int insertSale(int userNo, Normal normal) {
		return normalDAO.insertSale(userNo, normal);
	}

	@Override
	public int updateSale(Normal normal) {
		return normalDAO.updateSale(normal);
	}

	@Override
	public Normal getNormalSale(int saleNo) {
		return normalDAO.getNormalSale(saleNo);
	}

	@Override
	public List<Normal> getAllNormalList() {
		return normalDAO.getAllNormalList();
	}

	@Override
	public List<Normal> getNormalListByUserNo(int userNo) {
		return normalDAO.getNormalListByUserNo(userNo);
	}

	@Override
	public int turnSaleState(int saleNo) {
		return normalDAO.turnSaleState(saleNo);
	}

	@Override
	public List<Normal> searchNormal(String title) {
		return normalDAO.searchNormal(title);
	}

	
}
