package com.whatsHapp.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.whatsHapp.util.model.GenericPersistentObject;

@Entity
@Table(name = "category")
@Component("categoryModel")
public class CategoryModel extends GenericPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "categoryName")
	private String categoryName;

	@Column(name = "categoryDesc")
	private String categoryDesc;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

}
