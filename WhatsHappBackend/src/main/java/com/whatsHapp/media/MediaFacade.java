package com.whatsHapp.media;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("mediaFacade")
public class MediaFacade {
	
	@Autowired
	MediaService mediaService;
	
	@Autowired
	MediaValidator mediaValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(mediaValidator);
	}
	
	
	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	
	public void setMediaValidator(MediaValidator mediaValidator) {
		this.mediaValidator = mediaValidator;
	}
	public ArrayList<MediaModel> getMediaLst() {
		// TODO Auto-generated method stub
		return mediaService.getMediaLst();
	}

	public MediaModel getMedia(long id) {
		// TODO Auto-generated method stub
		return mediaService.getMedia(id);
	}

	public String createMedia(@ModelAttribute MediaModel mediaData) {
		// TODO Auto-generated method stub
		return mediaService.createMedia(mediaData);
			
		
		
	}

	public String editMedia(MediaModel mediaData) {
		// TODO Auto-generated method stub
		return mediaService.editMedia(mediaData);
	}

	public String deleteMedia(long id) {
		// TODO Auto-generated method stub
		return mediaService.deleteMedia(id);
	}


	
}
