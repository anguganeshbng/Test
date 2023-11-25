package com.api.automation.stepdef;

import java.util.Arrays;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.automation.helpers.ApiCommonFunctions;
import com.api.automation.helpers.JsonHelpers;
import com.ui.api.automation.model.RequestNewRecord;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class CreateNewRecordStepDef extends BaseStepDef {

	private String requestPayload;
	
	public CreateNewRecordStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		// TODO Auto-generated constructor stub
		super(apiCommonFunctionsObject);		
	}
	
	
	@When("User hit post end point using record from {string}")
	public void hitPostEndPoint(String filePath) {
		
		super.pathParam.put("resourcePath", "users");
		
		JsonHelpers jsonHelpers = new JsonHelpers();
		this.requestPayload = jsonHelpers.readJsonFileAsString(filePath);	
	    BaseStepDef.response =	super.apiCommonFunctions.postCall(headers, this.requestPayload, ContentType.JSON, pathParam);
	    System.out.println("Post call status Code : " + BaseStepDef.response.getStatusCode());
	}
	
	@Then("Verify status code {int}")
	public void verifyStatusCode(Integer statusCode) {
		int actualStatusCode = BaseStepDef.response.getStatusCode();
		Assert.assertTrue("Status Code is NOT " + statusCode, statusCode.equals(actualStatusCode));
	}
	
	@Then("Validate Response Data")
	public void verifyResponseData() {
		
		JSONObject expectedResponseJsonObject = new JSONObject(this.requestPayload);
		String expectedNameValue = expectedResponseJsonObject.getString("name");
		String expectedJobValue = expectedResponseJsonObject.getString("job");
		System.out.println("Expected Name : " + expectedNameValue);
		System.out.println("Expected Job : " + expectedJobValue);
		
		
		String responseBody = BaseStepDef.response.getBody().asString();
		JSONObject actualResponseJsonObject = new JSONObject(responseBody);
		String actualNameValue = actualResponseJsonObject.getString("name");
		String actualJobValue = actualResponseJsonObject.getString("job");
		System.out.println("Actual Name : " + actualNameValue);
		System.out.println("Actual Job : " + actualJobValue);
		
		Assert.assertEquals("Name is Wrong : ", expectedNameValue, actualNameValue);
		Assert.assertEquals("Job is Wrong : ", expectedJobValue, actualJobValue);
		
		
		
		
		
	}
	




}
