package com.whatsHapp.category;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("categoryDao")
@Transactional(readOnly = false)
public class CategoryDaoImpl extends CustomHibernateDaoSupport implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override

	public CategoryModel getCategory(long id) {

		CategoryModel categoryLst = new CategoryModel();

		getHibernateTemplate().get(CategoryModel.class, id);

		return categoryLst;
	}

	@Override
	public String editCategory(CategoryModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deleteCategory(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(CategoryModel.class, id));
		return "success";
	}

	@Override
	public String createCategory(CategoryModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ArrayList<CategoryModel> getCategoryLst() {
		ArrayList<CategoryModel> categoryLst = (ArrayList<CategoryModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(CategoryModel.class));
		return categoryLst;
	}

}
