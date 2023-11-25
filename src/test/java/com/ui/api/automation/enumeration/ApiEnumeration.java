package com.ui.api.automation.enumeration;

public enum ApiEnumeration {

	SLASH("/");
	
	private final String enumValue;
	
	
	private ApiEnumeration(String inputEnumValue) {
		this.enumValue = inputEnumValue;
	}
	
	public String getEnumValue() {
		return this.enumValue;
	}
	
	
}


