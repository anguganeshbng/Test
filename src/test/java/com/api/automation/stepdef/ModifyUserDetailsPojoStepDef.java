package com.api.automation.stepdef;

import com.api.automation.helpers.ApiCommonFunctions;
import com.api.automation.helpers.JsonHelpers;
import com.ui.api.automation.model.UserDetails;

import io.cucumber.java.en.And;

public class ModifyUserDetailsPojoStepDef extends BaseStepDef {

	private UserDetails expectedUserDetails;
	private UserDetails actualUserDetails;
	
	
	public ModifyUserDetailsPojoStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		super(apiCommonFunctionsObject);
		// TODO Auto-generated constructor stub
	}

	
	@And("Verify Updated Response Data from {string} using Pojo")
	public void verifyUpdatedResponseDataUsingPojo(String filePath) {
		
		JsonHelpers jsonHelper = new JsonHelpers();
		expectedUserDetails = jsonHelper.readJsonToPojo(filePath, UserDetails.class);
		System.out.println("Expected User Details : " + expectedUserDetails);
		
		
		UserDetails actualUserDetails = BaseStepDef.response.getBody().as(UserDetails.class);
		System.out.println("Actual User Details : " + actualUserDetails);
		
		
	}
	
}
