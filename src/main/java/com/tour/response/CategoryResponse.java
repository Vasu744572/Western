package com.tour.response;

import com.tour.pojo.CategoryPojo;

public class CategoryResponse extends AbstractPojoResponse {

	CategoryPojo categoryPojo;

	public CategoryPojo getCategoryPojo() {
		return categoryPojo;
	}

	public void setCategoryPojo(CategoryPojo categoryPojo) {
		this.categoryPojo = categoryPojo;
	}
}
