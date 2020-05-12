package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Category;

//@WebService(name = "CategoryService") 
public interface CategoryService{
	Category getCategory(int cateNo);
	public List<Category> getCategoryList();
}

