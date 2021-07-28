package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.Category;
import com.tour.pojo.CategoryPojo;
import com.tour.response.CategoryListResponse;
import com.tour.response.CategoryResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.CategoryService;
import com.tour.util.ObjectMapperUtils;

@Component
public class CategoryFacade {

	@Autowired
	private CategoryService categoryService;
	
	public  CategoryListResponse listAllCategories() {
		CategoryListResponse categoryListResponse = new CategoryListResponse();
		List<Category> categoriesEntity = categoryService.listAllPlace();
		List<CategoryPojo> categoryPojo = ObjectMapperUtils.mapAll(categoriesEntity, CategoryPojo.class);
		categoryListResponse.setCategoryPojo(categoryPojo);
		return categoryListResponse;
	}

	public CategoryResponse getCategory(long id) {
		CategoryResponse categoryResponse = new CategoryResponse();
		Category categoriesEntity = categoryService.getCategoryById(id);
		CategoryPojo categoryPojo = ObjectMapperUtils.map(categoriesEntity, CategoryPojo.class);
		categoryResponse.setCategoryPojo(categoryPojo);
		return categoryResponse;
		
	}
	
	public CategoryResponse saveCategory(CategoryPojo category)
	{
		Category categoriesEntity = ObjectMapperUtils.map(category, Category.class);
		Category categoryServiceEntity = categoryService.saveCategory(categoriesEntity);
		CategoryPojo categoryPojo = ObjectMapperUtils.map(categoryServiceEntity, CategoryPojo.class);
		return createDeleteUpdateResponse(categoryPojo,"Created successfully");
	}
	
	
	public  CategoryResponse updateCategory(CategoryPojo category) {
		
		Category categoriesEntity = ObjectMapperUtils.map(category, Category.class);
		Category categoryserviceEntity = categoryService.UpdateCategory(categoriesEntity);
		CategoryPojo categoryPojo = ObjectMapperUtils.map(categoryserviceEntity, CategoryPojo.class);
		return createDeleteUpdateResponse(categoryPojo,"Updated successfully");
	} 
	
	public CategoryResponse deleteCategory(long id) {
		categoryService.deleteCategory(id);
		return createDeleteUpdateResponse(null,"Deleted successfully");
	}
	
	private CategoryResponse createDeleteUpdateResponse(CategoryPojo categoryPojo, String message) {
		CategoryResponse categoryResponse = new CategoryResponse();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		categoryResponse.setCategoryPojo(categoryPojo);
		categoryResponse.setSuccessMessaages(successMessaages);
		return categoryResponse;
	}
}
