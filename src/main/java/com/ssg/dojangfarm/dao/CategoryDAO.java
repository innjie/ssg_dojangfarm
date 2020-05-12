package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Category;

public interface CategoryDAO {
	List<Category> getCategoryList();	
	Category getCategory(int cateNo);
}
