package com.api.automation.stepdef;

import java.util.HashMap;
import java.util.Map;

import com.api.automation.helpers.ApiCommonFunctions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseStepDef {
	
	public final ApiCommonFunctions apiCommonFunctions;
	public Map<String, String> headers;
	public Map<String, String> pathParam;
	public Map<String, String> queryParam;
	public static Response response;
	
	
	public BaseStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		// TODO Auto-generated constructor stub
		this.apiCommonFunctions = apiCommonFunctionsObject;
		this.headers =  new HashMap<String, String>();
		this.pathParam = new HashMap<String, String>();
		this.queryParam = new HashMap<String, String>();		
	}
	
	

}
