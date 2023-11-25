package com.api.automation.stepdef;

import org.junit.Assert;

import com.api.automation.helpers.ApiCommonFunctions;
import com.api.automation.helpers.JsonHelpers;
import com.ui.api.automation.model.RequestNewRecord;
import com.ui.api.automation.model.ResponseNewRecord;

import io.cucumber.java.en.And;
import io.restassured.response.Response;

public class CreateNewRecordPojoStepDef extends BaseStepDef {

	private ResponseNewRecord actualResponseDetails;
	private RequestNewRecord expectedRequestDetails;
	
	public CreateNewRecordPojoStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		super(apiCommonFunctionsObject);
		// TODO Auto-generated constructor stub
	}
	
	
	@And("Verify response Body from file {string} using NewRecord Pojo")
	public void validateResponseDataUsingPojo(String filePath) {
		
		JsonHelpers jsonHelper = new JsonHelpers();
		this.expectedRequestDetails = jsonHelper.readJsonToPojo(filePath, RequestNewRecord.class);		
		this.actualResponseDetails = BaseStepDef.response.getBody().as(ResponseNewRecord.class);
		System.out.println("Expected Request Details : " + expectedRequestDetails.toString());
		System.out.println("Actual Response Details : " + actualResponseDetails.toString());
		Assert.assertTrue("Validation is Wrong : " ,  expectedRequestDetails.compareTo(actualResponseDetails)==0);	
		
	}

}
