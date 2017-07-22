package com.whatsHapp.pages;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("pageDao")
@Transactional(readOnly = false)
public class PageDaoImpl extends CustomHibernateDaoSupport implements PageDao {

	@SuppressWarnings("unchecked")
	@Override

	public PageModel getPage(long id) {

		PageModel pageLst = new PageModel();

		getHibernateTemplate().get(PageModel.class, id);

		return pageLst;
	}

	@Override
	public String editPage(PageModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deletePage(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(PageModel.class, id));
		return "success";
	}

	@Override
	public String createPage(PageModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ArrayList<PageModel> getPageLst() {
		ArrayList<PageModel> pageLst = (ArrayList<PageModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(PageModel.class));
		return pageLst;
	}

}
