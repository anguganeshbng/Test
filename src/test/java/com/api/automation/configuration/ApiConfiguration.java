package com.api.automation.configuration;

import com.api.automation.helpers.ApiCommonFunctions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ApiConfiguration {
	
	public static ThreadLocal<ExtentTest> threadLocalExtentTest = new ThreadLocal<ExtentTest>();
	
	private final ApiCommonFunctions apiCommonFunctions;
	
	public ApiConfiguration(ApiCommonFunctions apiCommonFunctions) {
		// TODO Auto-generated constructor stub
		this.apiCommonFunctions = apiCommonFunctions;
	}

	@Before
	public void setUp() {

		RestAssured.baseURI = "https://reqres.in/api/";
		RestAssured.basePath = "{resourcePath}";

	}

	@After
	public void tearDown(Scenario scenario) {
	
		
		// ExtentTest extentTest = ;
		threadLocalExtentTest.set(ExtentCucumberAdapter.getCurrentStep().getExtent().createTest(scenario.getName()));
		RequestSpecification requestSpecification = this.apiCommonFunctions.getRequestSpecification();
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		
		String uri = queryableRequestSpecification.getURI();
		threadLocalExtentTest.get().info("End Point is : " + uri);
		
		
		
		String requestBody = "{}";
		if(queryableRequestSpecification.getBody() != null) {
			 requestBody = queryableRequestSpecification.getBody().toString();			 
		}
			 		
		Response response = this.apiCommonFunctions.getResponseObject();
		Markup responseBodyMarkUp = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
		Markup requestBodyMarkup = MarkupHelper.createCodeBlock(requestBody, CodeLanguage.JSON);
		threadLocalExtentTest.get().info("Actual Status Code : " + response.getStatusCode());
				
		if(scenario.getStatus().equals(Status.PASSED)) {
			threadLocalExtentTest.get().log(com.aventstack.extentreports.Status.PASS, requestBodyMarkup);
			threadLocalExtentTest.get().log(com.aventstack.extentreports.Status.PASS, responseBodyMarkUp);
			Markup markUpLabel = MarkupHelper.createLabel(scenario.getName() + " is Passed", ExtentColor.GREEN);
			threadLocalExtentTest.get().pass(markUpLabel);
		}
		
		if(scenario.getStatus().equals(Status.FAILED)) {
			threadLocalExtentTest.get().log(com.aventstack.extentreports.Status.FAIL, requestBodyMarkup);
			threadLocalExtentTest.get().log(com.aventstack.extentreports.Status.FAIL, responseBodyMarkUp);
			Markup markUpLabel = MarkupHelper.createLabel(scenario.getName() + " is Failed", ExtentColor.RED);
			threadLocalExtentTest.get().fail(markUpLabel);
		}
		
		
		if(!scenario.getStatus().equals(Status.PASSED) && !scenario.getStatus().equals(Status.FAILED) ) {
			threadLocalExtentTest.get().log(com.aventstack.extentreports.Status.SKIP, requestBodyMarkup);
			threadLocalExtentTest.get().log(com.aventstack.extentreports.Status.SKIP, responseBodyMarkUp);
			Markup markUpLabel = MarkupHelper.createLabel(scenario.getName() + " is NOT Passed and Failed", ExtentColor.GREY);
			threadLocalExtentTest.get().skip(markUpLabel);
		}
		
		
		
		
	}

}
