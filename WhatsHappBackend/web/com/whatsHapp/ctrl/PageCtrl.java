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

import com.whatsHapp.pages.PageFacade;
import com.whatsHapp.pages.PageModel;
import com.whatsHapp.pages.PageValidator;
@Validated
@RestController
@RequestMapping("/page") 
public class PageCtrl {

	@Autowired
	PageValidator pageValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(pageValidator);
	}

	@Autowired
	PageFacade pageFacade;

	public void setPageValidator(PageValidator pageValidator) {
		this.pageValidator = pageValidator;

	}

	public void setPageFacade(PageFacade pageFacade) {
		this.pageFacade = pageFacade;
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<PageModel>> getCategories() {
		ArrayList<PageModel> categories = pageFacade.getPageLst();
		return new ResponseEntity<List<PageModel>>(categories, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PageModel> getCatByID(@PathVariable("id") long id) {
		PageModel page = pageFacade.getPage(id);
		return  new ResponseEntity<PageModel>(page, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  createNewPage(@Valid @RequestBody PageModel pageData, BindingResult bindingResult) throws MethodArgumentNotValidException {
		pageData.setCreateDate(new Date());
		String status = pageFacade.createPage(pageData, bindingResult);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<PageModel>  updatePage(@Valid @RequestBody PageModel pageData, BindingResult bindingResult) {
		pageData.setLastUpdate(new Date());
		String status = pageFacade.editPage(pageData);
		return new ResponseEntity<PageModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PageModel> deletePageById(@PathVariable("id") long id) {
		String status = pageFacade.deletePage(id);
		return new ResponseEntity<PageModel>(HttpStatus.NO_CONTENT);
	}

}
