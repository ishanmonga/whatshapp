package com.whatsHapp.media;

import java.util.ArrayList;

public interface MediaDao {

	
	ArrayList<MediaModel> getMediaLst();

	MediaModel getMedia(long id);

	String createMedia(MediaModel catdata);

	String deleteMedia(long id);

	String editMedia(MediaModel catdata);

}
