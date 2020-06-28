package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Category;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Product;



public interface NormalDAO {
	int insertSale(Normal normal);
	int updateSale(Normal normal);
	Normal getNormalSale(int saleNo) ;
	List<Normal> getAllNormalList();
	List<Normal> getNormalListByUserNo(int userNo);
	List<Normal> searchNormal(String title);
	int turnSaleState(int saleNo, String saleState);
	int getUserByNormal(int saleNo);
	String getSaleState(int saleNo);
	List<Product> getProductList();
	Product getProduct(int pNo);
	List<Category> getCategoryList();
	List<Normal> getNormalListByCateNo(int cateNo);
	int getLastSaleNo();
	void addNormalImage(int saleNo, String string);
}
