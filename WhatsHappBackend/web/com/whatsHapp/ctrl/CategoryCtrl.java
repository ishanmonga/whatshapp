package com.whatsHapp.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whatsHapp.category.CategoryFacade;
import com.whatsHapp.category.CategoryModel;
import com.whatsHapp.category.CategoryValidator;

@Validated
@RestController
@RequestMapping("/category") 
public class CategoryCtrl {

	@Autowired
	CategoryValidator categoryValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(categoryValidator);
	}

	@Autowired
	CategoryFacade categoryFacade;

	public void setCategoryValidator(CategoryValidator categoryValidator) {
		this.categoryValidator = categoryValidator;

	}

	public void setCategoryFacade(CategoryFacade categoryFacade) {
		this.categoryFacade = categoryFacade;
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<CategoryModel>> getCategories() {
		ArrayList<CategoryModel> categories = categoryFacade.getCategoryLst();
		return new ResponseEntity<List<CategoryModel>>(categories, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoryModel> getCatByID(@PathVariable("id") long id) {
		CategoryModel category = categoryFacade.getCategory(id);
		return  new ResponseEntity<CategoryModel>(category, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  createNewCategory(@Valid @RequestBody CategoryModel categoryData, BindingResult bindingResult) throws MethodArgumentNotValidException {
		categoryData.setCreateDate(new Date());
		String status = categoryFacade.createCategory(categoryData, bindingResult);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<CategoryModel>  updateCategory(@Valid @RequestBody CategoryModel categoryData, BindingResult bindingResult) {
		categoryData.setLastUpdate(new Date());
		String status = categoryFacade.editCategory(categoryData);
		return new ResponseEntity<CategoryModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CategoryModel> deleteCategoryById(@PathVariable("id") long id) {
		String status = categoryFacade.deleteCategory(id);
		return new ResponseEntity<CategoryModel>(HttpStatus.NO_CONTENT);
	}

}
