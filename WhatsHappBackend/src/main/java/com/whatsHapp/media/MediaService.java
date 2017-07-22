package com.whatsHapp.media;

import java.util.ArrayList;

public interface MediaService {


	ArrayList<MediaModel> getMediaLst();

	MediaModel getMedia(long id);

	String createMedia(MediaModel catdata);

	String editMedia(MediaModel catdata);

	String deleteMedia(long id);

}
