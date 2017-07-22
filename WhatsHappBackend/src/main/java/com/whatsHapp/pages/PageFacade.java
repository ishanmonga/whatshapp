package com.whatsHapp.pages;

import java.util.ArrayList;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("pageFacade")
public class PageFacade {
	
	@Autowired
	PageService pageService;
	
//	@Autowired
//	PageValidator pageValidator;
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(pageValidator);
//	}
//	
//	@Autowired
//	RestValidationErrorHandler restValidationErrorHandler;
	
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	
//	public void setPageValidator(PageValidator pageValidator) {
//		this.pageValidator = pageValidator;
//	}
	public ArrayList<PageModel> getPageLst() {
		// TODO Auto-generated method stub
		return pageService.getPageLst();
	}

	public PageModel getPage(long id) {
		// TODO Auto-generated method stub
		return pageService.getPage(id);
	}

	public String createPage(@ModelAttribute PageModel catdata, BindingResult result) throws MethodArgumentNotValidException {
		// TODO Auto-generated method stub
		//pageValidator.validate(catdata, result);
		    if (result.hasErrors()) {
		    	//List<FieldError> fieldErrors = result.getFieldErrors();
		    	 throw new MethodArgumentNotValidException(null, result);
		       // return restValidationErrorHandler.processFieldErrors(fieldErrors); 
		    } else {
		    	return pageService.createPage(catdata);
		    }
			
		//return pageService.createPage(catdata);
		
	}

	public String editPage(PageModel catdata) {
		// TODO Auto-generated method stub
		return pageService.editPage(catdata);
	}

	public String deletePage(long id) {
		// TODO Auto-generated method stub
		return pageService.deletePage(id);
	}

	
}
