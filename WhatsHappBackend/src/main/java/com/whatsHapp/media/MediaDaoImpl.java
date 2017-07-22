package com.whatsHapp.media;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("mediaDao")
@Transactional(readOnly = false)
public class MediaDaoImpl extends CustomHibernateDaoSupport implements MediaDao {

	@SuppressWarnings("unchecked")
	@Override

	public MediaModel getMedia(long id) {

		MediaModel mediaLst = new MediaModel();

		getHibernateTemplate().get(MediaModel.class, id);

		return mediaLst;
	}

	@Override
	public String editMedia(MediaModel mediaData) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(mediaData);
		return "success";
	}

	@Override
	public String deleteMedia(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(MediaModel.class, id));
		return "success";
	}

	@Override
	public String createMedia(MediaModel mediaData) {
		// TODO Auto-generated method stub
		String mediaId=String.valueOf(getHibernateTemplate().save(mediaData)) ;
		// super.saveOrUpdate(userLogin);
		return mediaId;
	}

	@Override
	public ArrayList<MediaModel> getMediaLst() {
		ArrayList<MediaModel> mediaLst = (ArrayList<MediaModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(MediaModel.class));
		return mediaLst;
	}

}
