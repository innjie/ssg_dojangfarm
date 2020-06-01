package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Normal;

public interface NormalMapper {
	int insertSale(int userNo, Normal normal);
	int updateSale(Normal normal);
	Normal getNormalSale(int saleNo) ;
	List<Normal> getAllNormalList();
	List<Normal> getNormalListByUserNo(int userNo);
	List<Normal> searchNormal(String title);
	int turnSaleState(int saleNo);
}
