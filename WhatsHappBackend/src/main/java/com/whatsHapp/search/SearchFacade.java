package com.whatsHapp.search;

import java.util.ArrayList;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("searchFacade")
public class SearchFacade {
	
	@Autowired
	SearchService searchService;
	
//	@Autowired
//	SearchValidator searchValidator;
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(searchValidator);
//	}
//	
//	@Autowired
//	RestValidationErrorHandler restValidationErrorHandler;
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	
//	public void setSearchValidator(SearchValidator searchValidator) {
//		this.searchValidator = searchValidator;
//	}
	public ArrayList<SearchModel> getSearchLst() {
		// TODO Auto-generated method stub
		return searchService.getSearchLst();
	}

	public SearchModel getSearch(long id) {
		// TODO Auto-generated method stub
		return searchService.getSearch(id);
	}

	public String createSearch(@ModelAttribute SearchModel catdata, BindingResult result) throws MethodArgumentNotValidException {
		// TODO Auto-generated method stub
		//searchValidator.validate(catdata, result);
		    if (result.hasErrors()) {
		    	//List<FieldError> fieldErrors = result.getFieldErrors();
		    	 throw new MethodArgumentNotValidException(null, result);
		       // return restValidationErrorHandler.processFieldErrors(fieldErrors); 
		    } else {
		    	return searchService.createSearch(catdata);
		    }
			
		//return searchService.createSearch(catdata);
		
	}

	public String editSearch(SearchModel catdata) {
		// TODO Auto-generated method stub
		return searchService.editSearch(catdata);
	}

	public String deleteSearch(long id) {
		// TODO Auto-generated method stub
		return searchService.deleteSearch(id);
	}

	
}
