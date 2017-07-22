package com.whatsHapp.user;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("userDao")
@Transactional(readOnly = false)
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

	@SuppressWarnings("unchecked")
	@Override

	public UserModel getUser(long id) {

		UserModel user = new UserModel();

		user = getHibernateTemplate().get(UserModel.class, id);

		return user;
	}

	@Override
	public String editUser(UserModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(UserModel.class, id));
		return "success";
	}

	@Override
	public String createUser(UserModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ArrayList<UserModel> getUserLst() {
		ArrayList<UserModel> userLst = (ArrayList<UserModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(UserModel.class));
		return userLst;
	}

	@Override
	public ArrayList<UserModel> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		ArrayList<UserModel> userLst = (ArrayList<UserModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(UserModel.class).add(Restrictions.eq("userEmail", username)));
		
		return userLst;
	}

}
