package com.api.automation.stepdef;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.automation.helpers.ApiCommonFunctions;
import com.api.automation.helpers.JsonHelpers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ui.api.automation.enumeration.ApiEnumeration;
import com.ui.api.automation.model.UserDetails;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetUserDetailsStepDef extends BaseStepDef {

	
	
	public GetUserDetailsStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		super(apiCommonFunctionsObject);
		// TODO Auto-generated constructor stub
	}

	@When("User hit userDetails endpoing using id as {int}")
	public void hitUserDetailsEndPoint(int id) {
	   		
		super.pathParam.put("resourcePath", "users");		
		String endPoint = ApiEnumeration.SLASH.getEnumValue() + id;
		
		BaseStepDef.response = super.apiCommonFunctions.getCall(headers, super.queryParam, super.pathParam, endPoint);
		
		System.out.println(response.getBody().asString());
		
	}
	
	@Then("Verify status code as {int}")
	public void verify_status_code_as(int ResponseCode) {
		Assert.assertEquals(BaseStepDef.response.getStatusCode(), ResponseCode);
	}
	
	@Then("Verify response Body from file {string}")
	public void verify_response_body_from_file(String filePath) {
		
		JsonHelpers jsonHelper = new JsonHelpers();
		String expectedJsonString =  jsonHelper.readJsonFileAsString(filePath);		
		
			
		JSONObject expectJsonObject = new JSONObject(expectedJsonString);
		
		// Get Data Attribute Details from expectedJson
		JSONObject expectedDataJsonObject =  expectJsonObject.getJSONObject("data");
		int expectedId =   expectedDataJsonObject.getInt("id");
		String expectedEmail = expectedDataJsonObject.getString("email");
		String expectedFirstName = expectedDataJsonObject.getString("first_name");
		String expectedLastName = expectedDataJsonObject.getString("last_name");
		String expectedAvatar = expectedDataJsonObject.getString("avatar");
		System.out.println("Expected Id : " + expectedId);
		System.out.println("Expected Email : " + expectedEmail);
		System.out.println("Expected FirstName : " + expectedFirstName);
		System.out.println("Expected LastName : " + expectedLastName);
		System.out.println("Expected Avatar : " + expectedAvatar);
		
		// Get support Attribute Details from expectedJson
		JSONObject supportJsonObject = expectJsonObject.getJSONObject("support");
		String expectedUrl = supportJsonObject.getString("url");
		String expectedText = supportJsonObject.getString("text");
		System.out.println("Expeted URL : " + expectedUrl);
		System.out.println("expected Text : " + expectedText);
		
				
		String actualJsonString = BaseStepDef.response.getBody().asString();
		JSONObject actualJsonObject = new JSONObject(actualJsonString);
		
		// Get Data Attribute Details from actualJson
		JSONObject actualDataJsonObject = actualJsonObject.getJSONObject("data");
		int actualId =   actualDataJsonObject.getInt("id");
		String actualEmail = actualDataJsonObject.getString("email");
		String actualFirstName = actualDataJsonObject.getString("first_name");
		String actualLastName = actualDataJsonObject.getString("last_name");
		String actualAvatar = actualDataJsonObject.getString("avatar");		
		System.out.println("Actual Id : " + actualId);
		System.out.println("Actual Email : " + actualEmail);
		System.out.println("Actual FirstName : " + actualFirstName);
		System.out.println("Actual LastName : " + actualLastName);
		System.out.println("Actual Avatar : " + actualAvatar);
		
		// Get support Attribute Details from actualJson
		JSONObject actualSupportJsonObject = actualJsonObject.getJSONObject("support");
		String actualUrl = actualSupportJsonObject.getString("url");
		String actualText = actualSupportJsonObject.getString("text");
		System.out.println("Actual URL : " + actualUrl);
		System.out.println("Actual Text : " + actualText);
		
		// Compare Actuals With Expected
		Assert.assertEquals("Id is Mismatched", expectedId, actualId);
		Assert.assertEquals("Email is Mismatched", expectedEmail, actualEmail);
		Assert.assertEquals("FirstName is Mismatched", expectedFirstName, actualFirstName);
		Assert.assertEquals("LastName is Mismatched", expectedLastName, actualLastName);
		Assert.assertEquals("Avatar is Mismatched", expectedAvatar, actualAvatar);
		Assert.assertEquals("URL is Mismatched", expectedUrl, actualUrl);
		Assert.assertEquals("Text is Mismatched", expectedText, actualText);
		
		
	    
	}
	



}
