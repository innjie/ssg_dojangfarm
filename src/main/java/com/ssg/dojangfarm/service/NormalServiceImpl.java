package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.NormalDAO;
import com.ssg.dojangfarm.domain.Category;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Product;



@Service("NormalServiceImpl")
public class NormalServiceImpl implements NormalService {

	@Autowired
	private NormalDAO normalDAO;

	@Override
	public int insertSale( Normal normal) {
		return normalDAO.insertSale(normal);
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
	public int turnSaleState(int saleNo, String saleState) {
		return normalDAO.turnSaleState(saleNo, saleState);
	}

	@Override
	public List<Normal> searchNormal(String title) {
		return normalDAO.searchNormal(title);
	}

	@Override
	public String getSaleState(int saleNo) {
		return normalDAO.getSaleState(saleNo);
	}

	@Override
	public List<Product> getProductList() {
		return normalDAO.getProductList();
	}

	@Override
	public Product getProduct(int pNo) {
		return normalDAO.getProduct(pNo);
	}

	@Override
	public List<Category> getCategoryList() {
		return normalDAO.getCategoryList();
	}

	@Override
	public List<Normal> getNormalListByCateNo(int cateNo) {
		return normalDAO.getNormalListByCateNo(cateNo);
	}
}
