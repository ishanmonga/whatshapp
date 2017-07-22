package com.whatsHapp.pages;

import java.util.ArrayList;

public interface PageService {


	ArrayList<PageModel> getPageLst();

	PageModel getPage(long id);

	String createPage(PageModel catdata);

	String editPage(PageModel catdata);

	String deletePage(long id);

}
