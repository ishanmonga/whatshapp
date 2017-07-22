package com.whatsHapp.media;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	@Autowired
	MediaDao mediaDao;

	public void setMediaDao(MediaDao mediaDao) {
		this.mediaDao = mediaDao;
	}

	@Override
	public ArrayList<MediaModel> getMediaLst() {
		// TODO Auto-generated method stub
		return mediaDao.getMediaLst();
	}

	@Override
	public MediaModel getMedia(long id) {
		// TODO Auto-generated method stub
		return mediaDao.getMedia(id);
	}

	@Override
	public String createMedia(MediaModel catdata) {
		// TODO Auto-generated method stub
		return mediaDao.createMedia(catdata);
	}

	@Override
	public String editMedia(MediaModel catdata) {
		// TODO Auto-generated method stub
		return mediaDao.editMedia(catdata);
	}

	@Override
	public String deleteMedia(long id) {
		// TODO Auto-generated method stub
		return mediaDao.deleteMedia(id);
	}

}
