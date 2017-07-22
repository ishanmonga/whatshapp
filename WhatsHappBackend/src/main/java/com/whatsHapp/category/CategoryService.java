package com.whatsHapp.category;

import java.util.ArrayList;

public interface CategoryService {


	ArrayList<CategoryModel> getCategoryLst();

	CategoryModel getCategory(long id);

	String createCategory(CategoryModel catdata);

	String editCategory(CategoryModel catdata);

	String deleteCategory(long id);

}
