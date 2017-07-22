package com.whatsHapp.userProfile;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("userProfileDao")
@Transactional(readOnly = false)
public class UserProfileImpl extends CustomHibernateDaoSupport implements UserProfileDao {

	@SuppressWarnings("unchecked")
	@Override

	public UserProfileModel getUserProfile(long id) {

		UserProfileModel userProfileLst = new UserProfileModel();

		getHibernateTemplate().get(UserProfileModel.class, id);

		return userProfileLst;
	}

	@Override
	public String editUserProfile(UserProfileModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deleteUserProfile(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(UserProfileModel.class, id));
		return "success";
	}

	@Override
	public String createUserProfile(UserProfileModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ArrayList<UserProfileModel> getUserProfileLst() {
		ArrayList<UserProfileModel> userProfileLst = (ArrayList<UserProfileModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(UserProfileModel.class));
		return userProfileLst;
	}

}
