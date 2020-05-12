package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Normal;

public interface NormalService {
	public int insertSale(int userNo, Normal normal);
	public int updateSale(Normal normal);
	public Normal getNormalSale(int saleNo) ;
	public List<Normal> getAllNormalList();
	public List<Normal> getNormalListByUserNo(int userNo);
	public int turnSaleOpen(int saleNo);
	public int turnSaleClosed(int sale) ;
	public List<Normal> searchNormal(String title);
}
