package com.api.automation.stepdef;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.automation.helpers.ApiCommonFunctions;
import com.api.automation.helpers.JsonHelpers;
import com.ui.api.automation.enumeration.ApiEnumeration;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class ModifyUserDetailsStepDef extends BaseStepDef {

	private String requestBody;
	
	
	public ModifyUserDetailsStepDef(ApiCommonFunctions apiCommonFunctionsObject) {
		// TODO Auto-generated constructor stub
		super(apiCommonFunctionsObject);
	}

	
	@When("User hit PUT Call using {int} from {string}")
	public void userHitPutCall(int id, String filePath) {
	    // Write code here that turns the phrase above into concrete actions
		JsonHelpers jsonHelpers = new JsonHelpers();
		this.requestBody =  jsonHelpers.readJsonFileAsString(filePath);
		super.pathParam.put("resourcePath", "users");
		String endPoint = ApiEnumeration.SLASH.getEnumValue() + String.valueOf(id);
			   
	    BaseStepDef.response = super.apiCommonFunctions.putCall(headers, requestBody, ContentType.JSON, super.pathParam, endPoint);
	}
	
	@Then("Verify status code using {int}")
	public void verifyStatusCode(Integer expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
		int actualStatusCode = BaseStepDef.response.getStatusCode();
		Assert.assertTrue("Expected Status Code is : " + expectedStatusCode,   expectedStatusCode.equals(actualStatusCode));
		
	
	}


	@Then("Verify Updated Response Data")
	public void verifyResponseDataFromFile() {
	    // Write code here that turns the phrase above into concrete actions
		
		JSONObject expectedJsonObject = new JSONObject(this.requestBody);
		
		// Data Object expected Details
		JSONObject dataJsonObject = expectedJsonObject.getJSONObject("data");
		int expectedId = dataJsonObject.getInt("id");
		String expectedEmail = dataJsonObject.getString("email");
		String expectedFirstName = dataJsonObject.getString("first_name");
		String expectedLastName = dataJsonObject.getString("last_name");
		String expectedAvatar = dataJsonObject.getString("avatar");
		
		// Support Object expected Details
		JSONObject supportJsonObject =  expectedJsonObject.getJSONObject("support");
		String expectedUrl = supportJsonObject.getString("url");
		String expectedText = supportJsonObject.getString("text");
					
		String actualResponseData = BaseStepDef.response.getBody().asString();
		JSONObject actualJsonObject = new JSONObject(actualResponseData);
		
		// Data Object actual Details
		JSONObject actualDataJsonObject = actualJsonObject.getJSONObject("data");
		int actualId = actualDataJsonObject.getInt("id");
		String actualEmail = actualDataJsonObject.getString("email");
		String actualFirstName = actualDataJsonObject.getString("first_name");
		String actualLastName = actualDataJsonObject.getString("last_name");
		String actualAvatar = actualDataJsonObject.getString("avatar");
		
		// Support Object actual Details
		JSONObject actualSupportJsonObject = actualJsonObject.getJSONObject("support");
		String actualUrl = actualSupportJsonObject.getString("url");
		String actualText = actualSupportJsonObject.getString("text");
		
		
		Assert.assertEquals("Expected Id : " + expectedId, expectedId, actualId);
		Assert.assertEquals("Expected Email : " + expectedEmail, expectedEmail, actualEmail);
		Assert.assertEquals("Expected FirstName : " + expectedFirstName, expectedFirstName, actualFirstName);
		Assert.assertEquals("Expected LastName : " + expectedLastName, expectedLastName, actualLastName);
		Assert.assertEquals("Expected Avatar : " + expectedAvatar, expectedAvatar, actualAvatar);
		
		Assert.assertEquals("Expected Url : " + expectedUrl, expectedUrl, actualUrl);
		Assert.assertEquals("Expected text : " + expectedText, expectedText, actualText);
		
	  
	}





	
}
