package com.whatsHapp.search;

import java.util.ArrayList;

public interface SearchDao {

	
	ArrayList<SearchModel> getSearchLst();

	SearchModel getSearch(long id);

	String createSearch(SearchModel catdata);

	String deleteSearch(long id);

	String editSearch(SearchModel catdata);

}
