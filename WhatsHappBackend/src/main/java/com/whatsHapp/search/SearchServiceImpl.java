package com.whatsHapp.search;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao;

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public ArrayList<SearchModel> getSearchLst() {
		// TODO Auto-generated method stub
		return searchDao.getSearchLst();
	}

	@Override
	public SearchModel getSearch(long id) {
		// TODO Auto-generated method stub
		return searchDao.getSearch(id);
	}

	@Override
	public String createSearch(SearchModel catdata) {
		// TODO Auto-generated method stub
		return searchDao.createSearch(catdata);
	}

	@Override
	public String editSearch(SearchModel catdata) {
		// TODO Auto-generated method stub
		return searchDao.editSearch(catdata);
	}

	@Override
	public String deleteSearch(long id) {
		// TODO Auto-generated method stub
		return searchDao.deleteSearch(id);
	}

}
