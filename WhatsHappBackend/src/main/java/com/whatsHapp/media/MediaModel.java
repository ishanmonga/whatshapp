package com.whatsHapp.media;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.whatsHapp.util.model.GenericPersistentObject;

@Entity
@Table(name = "media")
@Component("mediaModel")
public class MediaModel extends GenericPersistentObject{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "mediaName", nullable = false)
	private String mediaName;

	@Lob
	@Column(name = "mediaFile", nullable = false, columnDefinition = "mediumblob")
	private byte[] mediaFile;


	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public byte[] getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(byte[] mediaFile) {
		this.mediaFile = mediaFile;
	}

}