package com.whatsHapp.ctrl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.whatsHapp.media.MediaFacade;
import com.whatsHapp.media.MediaModel;
import com.whatsHapp.media.MediaValidator;
import com.whatsHapp.util.exception.CustomGenericException;

@Validated
@RestController
@RequestMapping(value = "/media")
// Max uploaded file size (here it is 20 MB)
@MultipartConfig(fileSizeThreshold = 20971520)
public class MediaCtrl {

	@Autowired
	MediaValidator mediaValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(mediaValidator);
	}

	@Autowired
	MediaFacade mediaFacade;

	public void setMediaValidator(MediaValidator mediaValidator) {
		this.mediaValidator = mediaValidator;

	}

	public void setMediaFacade(MediaFacade mediaFacade) {
		this.mediaFacade = mediaFacade;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MediaModel>> getCategories() {
		ArrayList<MediaModel> categories = mediaFacade.getMediaLst();
		return new ResponseEntity<List<MediaModel>>(categories, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MediaModel> getCatByID(@PathVariable("id") long id) {
		MediaModel media = mediaFacade.getMedia(id);
		return new ResponseEntity<MediaModel>(media, HttpStatus.OK);

	}

	// @RequestMapping( method = RequestMethod.POST)
	// public String handleFileUpload(@RequestParam("file") CommonsMultipartFile
	// file) throws Exception {
	// if (file == null || file.isEmpty()) {
	// new CustomGenericException("MediaCtrl",
	// "excetion occured while saving media in method handleFileUpload of
	// MediaCtrl");
	// } else {
	// System.out.println("Saving file: " + file.getOriginalFilename());
	// MediaModel uploadFile = new MediaModel();
	// uploadFile.setMediaName(file.getOriginalFilename());
	// uploadFile.setMediaFile(file.getBytes());
	// String result = mediaFacade.createMedia(uploadFile);
	// return result;
	// }
	// return "failure";
	// }

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MediaModel> handleFileUpload(@RequestParam("file") CommonsMultipartFile file) throws Exception {
		MediaModel mediaModel= new MediaModel();
		if (file == null || file.isEmpty()) {
			new CustomGenericException("MediaCtrl",
					"excetion occured while saving media in method handleFileUpload of MediaCtrl");
		} else {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				// String rootPath = System.getProperty("catalina.home");
				String rootPath = "/Users/i851982/Documents/workspace_project/whatsHapp/whatsHappFrontend/WebContent/images";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String filepath = dir.getAbsolutePath() + File.separator + timestamp.getTime()+file.getOriginalFilename();
				File serverFile = new File(filepath);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				//get media name from path
				
				String mediaName= getMediaNameFromPath(filepath);
				
				mediaModel.setMediaName(mediaName);
				return new ResponseEntity<MediaModel>(mediaModel, HttpStatus.OK);
				//
				// logger.info("Server File Location="
				// + serverFile.getAbsolutePath());

				// return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				// return "You failed to upload " + name + " => " +
				// e.getMessage();
			}
		}
		return new ResponseEntity<MediaModel>(mediaModel, HttpStatus.OK);
	}

	private String getMediaNameFromPath(String filepath) {
		String idStr = filepath.substring(filepath.lastIndexOf('/') + 1);
		// TODO Auto-generated method stub
		return idStr;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<MediaModel> updateMedia(@Valid @RequestBody MediaModel catdata, BindingResult bindingResult)
			throws MethodArgumentNotValidException {
		catdata.setLastUpdate(new Date());
		String status = mediaFacade.editMedia(catdata);
		return new ResponseEntity<MediaModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MediaModel> deleteMediaById(@PathVariable("id") long id) {
		String status = mediaFacade.deleteMedia(id);
		return new ResponseEntity<MediaModel>(HttpStatus.NO_CONTENT);
	}

}
