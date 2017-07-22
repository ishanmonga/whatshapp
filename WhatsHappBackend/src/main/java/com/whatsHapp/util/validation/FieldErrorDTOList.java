package com.whatsHapp.util.validation;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
 
@Component("fieldErrorDTOList")
public class FieldErrorDTOList implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FieldErrorDTO> fieldErrors;
    
    public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}