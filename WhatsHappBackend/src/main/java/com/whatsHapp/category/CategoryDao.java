package com.whatsHapp.category;

import java.util.ArrayList;

public interface CategoryDao {

	
	ArrayList<CategoryModel> getCategoryLst();

	CategoryModel getCategory(long id);

	String createCategory(CategoryModel catdata);

	String deleteCategory(long id);

	String editCategory(CategoryModel catdata);

}
