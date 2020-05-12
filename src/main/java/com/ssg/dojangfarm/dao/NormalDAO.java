package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Normal;



public interface NormalDAO {
	//Normal() throws DataAccessException;
	int insertSale(int userNo, Normal normal);
	int updateSale(Normal normal);
	Normal getNormalSale(int saleNo) ;
	List<Normal> getAllNormalList();
	List<Normal> getNormalListByUserNo(int userNo);
	int turnSaleOpen(int saleNo);
	int turnSaleClosed(int sale) ;
	List<Normal> searchNormal(String title);// throws DataAccessException;
}
