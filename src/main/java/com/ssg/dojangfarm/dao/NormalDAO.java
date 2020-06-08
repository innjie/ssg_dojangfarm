package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Normal;



public interface NormalDAO {
	int insertSale(Normal normal);
	int updateSale(Normal normal);
	Normal getNormalSale(int saleNo) ;
	List<Normal> getAllNormalList();
	List<Normal> getNormalListByUserNo(int userNo);
	List<Normal> searchNormal(String title);
	int turnSaleState(int saleNo);
}
