package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.NormalDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.NormalMapper;
import com.ssg.dojangfarm.domain.Category;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Product;

@Repository
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
	public int turnSaleState(int saleNo, String saleState) {
		return normalMapper.turnSaleState(saleNo, saleState);
	}
	public int getUserByNormal(int saleNo) {
		return normalMapper.getUserByNormal(saleNo);
	}
	public String getSaleState(int saleNo) {
		return normalMapper.getSaleState(saleNo);
	}
	public List<Product> getProductList() {
		return normalMapper.getProductList();
	}
	public Product getProduct(int pNo) {
		return normalMapper.getProduct(pNo);
	}
	public List<Category> getCategoryList() {
		return normalMapper.getCategoryList();
	}
	public List<Normal> getNormalListByCateNo(int cateNo) {
		return normalMapper.getNormalListByCateNo(cateNo);
	}
}
