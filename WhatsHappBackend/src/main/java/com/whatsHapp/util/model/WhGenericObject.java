package com.whatsHapp.util.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
 
@MappedSuperclass
public abstract class WhGenericObject extends GenericPersistentObject
{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "code", updatable = false, nullable = false)
    private String code = null;
 
    protected void copy(final WhGenericObject source)
    {
        this.code = source.code;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
 
    
    
}