package com.whatsHapp.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public ArrayList<CategoryModel> getCategoryLst() {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryLst();
	}

	@Override
	public CategoryModel getCategory(long id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(id);
	}

	@Override
	public String createCategory(CategoryModel catdata) {
		// TODO Auto-generated method stub
		return categoryDao.createCategory(catdata);
	}

	@Override
	public String editCategory(CategoryModel catdata) {
		// TODO Auto-generated method stub
		return categoryDao.editCategory(catdata);
	}

	@Override
	public String deleteCategory(long id) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategory(id);
	}

}
