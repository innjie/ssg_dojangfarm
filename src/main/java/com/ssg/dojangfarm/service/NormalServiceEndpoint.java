package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Normal;


@Component
@WebService(serviceName="NormalService")
public class NormalServiceEndpoint {
	@Autowired
	NormalService normalService; // inject NormalServiceImpl

	@WebMethod
	public int insertSale(int userNo, Normal normal) {
		return normalService.insertSale(userNo, normal);
	}

	@WebMethod
	public int updateSale(Normal normal) {
		return normalService.updateSale(normal);
	}

	@WebMethod
	public Normal getNormalSale(int saleNo) {
		return normalService.getNormalSale(saleNo);
	}

	@WebMethod
	public List<Normal> getAllNormalList() {
		return normalService.getAllNormalList();
	}

	@WebMethod
	public List<Normal> getNormalListByUserNo(int userNo) {
		return normalService.getNormalListByUserNo(userNo);
	}

	@WebMethod
	public int turnSaleOpen(int saleNo) {
		return normalService.turnSaleOpen(saleNo);
	}

	@WebMethod
	public int turnSaleClosed(int sale) {
		return normalService.turnSaleClosed(sale);
	}

	@WebMethod
	public List<Normal> searchNormal(String title) {
		return normalService.searchNormal(title);
	}


}