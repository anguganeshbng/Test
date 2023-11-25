package com.api.automation.stepdef;

import org.junit.Assert;

import com.api.automation.helpers.ApiCommonFunctions;
import com.ui.api.automation.enumeration.ApiEnumeration;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteUserDetailsStepDef extends BaseStepDef {

	public DeleteUserDetailsStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		// TODO Auto-generated constructor stub
		super(apiCommonFunctionsObject);
	}

	@When("User hit Delete Call using {int}")
	public void userHitDeleteEndPoint(int id) {
	    // Write code here that turns the phrase above into concrete actions
		super.pathParam.put("resourcePath", "users");
		String endPoint = ApiEnumeration.SLASH.getEnumValue() + id;
		
		BaseStepDef.response = super.apiCommonFunctions.deleteCall(super.headers, super.pathParam, endPoint);
	    
	}
	
	@Then("Verify status Code as {int}")
	public void verifyStatusCode(Integer expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
		int actualStatusCode =  BaseStepDef.response.getStatusCode();
		Assert.assertTrue("Expected Status Code : " + expectedStatusCode, expectedStatusCode.equals(actualStatusCode));
	 }
	





	

}
