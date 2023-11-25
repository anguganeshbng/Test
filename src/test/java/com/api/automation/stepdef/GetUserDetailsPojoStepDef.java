package com.api.automation.stepdef;

import com.api.automation.helpers.ApiCommonFunctions;
import com.api.automation.helpers.JsonHelpers;
import com.ui.api.automation.model.UserDetails;

import io.cucumber.java.en.And;

public class GetUserDetailsPojoStepDef extends BaseStepDef {

	private UserDetails expectedUserDetails;
	private UserDetails actualUserDetails;
	
	public GetUserDetailsPojoStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		super(apiCommonFunctionsObject);
		// TODO Auto-generated constructor stub
	}

	@And("Verify response Body from file {string} using Pojo")
	public void verifyResponseBodyUsingPojo(String filePath) {
	
		 JsonHelpers jsonHelper = new JsonHelpers();
		 expectedUserDetails = jsonHelper.readJsonToPojo(filePath, UserDetails.class);		 
		 actualUserDetails = BaseStepDef.response.getBody().as(UserDetails.class);
		 
		 System.out.println(expectedUserDetails.compareTo(actualUserDetails));
	}
	
}
