package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Category;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Product;

public interface NormalService {
	public int insertSale(Normal normal);
	public int updateSale(Normal normal);
	public Normal getNormalSale(int saleNo) ;
	public List<Normal> getAllNormalList();
	public List<Normal> getNormalListByUserNo(int userNo);
	public int turnSaleState(int saleNo, String saleState);
	public List<Normal> searchNormal(String title);
	public String getSaleState(int saleNo);
	public List<Product> getProductList();
	public Product getProduct(int pNo);
	public List<Category> getCategoryList();
	public List<Normal> getNormalListByCateNo(int cateNo);
}
