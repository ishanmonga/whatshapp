package com.whatsHapp.pages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.whatsHapp.util.model.GenericPersistentObject;

@Entity
@Table(name = "page")
@Component("pageModel")
public class PageModel extends GenericPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pageName")
	private String pageName;

	@Column(name = "pageUrl")
	private String pageUrl;

	@Column(name = "pageContent")
	private String pageContent;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}

	
}
