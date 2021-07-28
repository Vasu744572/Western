package com.tour.response;

import java.util.List;

import com.tour.pojo.CategoryPojo;

public class CategoryListResponse extends AbstractPojoResponse{

	List<CategoryPojo> categoryPojo;

	public List<CategoryPojo> getCategoryPojo() {
		return categoryPojo;
	}

	public void setCategoryPojo(List<CategoryPojo> categoryPojo) {
		this.categoryPojo = categoryPojo;
	} 
	
}
