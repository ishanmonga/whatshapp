package com.whatsHapp.search;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("searchDao")
@Transactional(readOnly = false)
public class SearchDaoImpl extends CustomHibernateDaoSupport implements SearchDao {

	@SuppressWarnings("unchecked")
	@Override

	public SearchModel getSearch(long id) {

		SearchModel searchLst = new SearchModel();

		getHibernateTemplate().get(SearchModel.class, id);

		return searchLst;
	}

	@Override
	public String editSearch(SearchModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deleteSearch(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(SearchModel.class, id));
		return "success";
	}

	@Override
	public String createSearch(SearchModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ArrayList<SearchModel> getSearchLst() {
		ArrayList<SearchModel> searchLst = (ArrayList<SearchModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(SearchModel.class));
		return searchLst;
	}

}
