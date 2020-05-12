package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.CategoryDAO;
import com.ssg.dojangfarm.domain.Category;

@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;

	public Category getCategory(int cateNo) {
		return categoryDAO.getCategory(cateNo);
	}

	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
}
