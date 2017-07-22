package com.whatsHapp.search;

import java.util.ArrayList;

public interface SearchService {


	ArrayList<SearchModel> getSearchLst();

	com.whatsHapp.search.SearchModel getSearch(long id);

	String createSearch(SearchModel catdata);

	String editSearch(SearchModel catdata);

	String deleteSearch(long id);

}
