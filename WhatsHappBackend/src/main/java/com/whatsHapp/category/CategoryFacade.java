package com.whatsHapp.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("categoryFacade")
public class CategoryFacade {
	
	@Autowired
	CategoryService categoryService;
	
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	public ArrayList<CategoryModel> getCategoryLst() {
		// TODO Auto-generated method stub
		return categoryService.getCategoryLst();
	}

	public CategoryModel getCategory(long id) {
		// TODO Auto-generated method stub
		return categoryService.getCategory(id);
	}

	public String createCategory(@ModelAttribute CategoryModel catdata, BindingResult result) throws MethodArgumentNotValidException {
		    if (result.hasErrors()) {
		    	 throw new MethodArgumentNotValidException(null, result);
		    } else {
		    	return categoryService.createCategory(catdata);
		    }
	}

	public String editCategory(CategoryModel catdata) {
		// TODO Auto-generated method stub
		return categoryService.editCategory(catdata);
	}

	public String deleteCategory(long id) {
		// TODO Auto-generated method stub
		return categoryService.deleteCategory(id);
	}

	
}
