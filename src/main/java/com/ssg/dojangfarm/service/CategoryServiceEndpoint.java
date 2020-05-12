package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Category;

@Component
@WebService(serviceName="CategoryService") 
public class CategoryServiceEndpoint {
	@Autowired
	CategoryService categoryService;		// inject CategoryServiceImpl
	
	@WebMethod
	public Category getCategory(int cateNo) {
		return categoryService.getCategory(cateNo);
	}

	@WebMethod
	public List<Category> getCategoryList(){
		return categoryService.getCategoryList();
	}
}
