package com.whatsHapp.pages;

import java.util.ArrayList;

public interface PageDao {

	
	ArrayList<PageModel> getPageLst();

	PageModel getPage(long id);

	String createPage(PageModel catdata);

	String deletePage(long id);

	String editPage(PageModel catdata);

}
