package com.whatsHapp.pages;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pageService")
public class PageServiceImpl implements PageService {

	@Autowired
	PageDao pageDao;

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	@Override
	public ArrayList<PageModel> getPageLst() {
		// TODO Auto-generated method stub
		return pageDao.getPageLst();
	}

	@Override
	public PageModel getPage(long id) {
		// TODO Auto-generated method stub
		return pageDao.getPage(id);
	}

	@Override
	public String createPage(PageModel catdata) {
		// TODO Auto-generated method stub
		return pageDao.createPage(catdata);
	}

	@Override
	public String editPage(PageModel catdata) {
		// TODO Auto-generated method stub
		return pageDao.editPage(catdata);
	}

	@Override
	public String deletePage(long id) {
		// TODO Auto-generated method stub
		return pageDao.deletePage(id);
	}

}
