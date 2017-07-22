package com.whatsHapp.util;

import org.springframework.stereotype.Component;

@Component("commonMethods")
public class CommonMethods {

	public boolean checkEmpty(String source) {
		return source==null || source.isEmpty();
	}
}
