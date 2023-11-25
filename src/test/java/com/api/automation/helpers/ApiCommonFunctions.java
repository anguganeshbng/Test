package com.api.automation.helpers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import com.ui.api.automation.model.RequestNewRecord;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.SpecificationMerger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ApiCommonFunctions {
	
	private RequestSpecification requestSpecification;
	private Response response;
	

	public Response getCall(Map<String, String> headers, Map<String, String> queryParamers,
			Map<String, String> pathParameters, String endPoint) {

		URI uri = null;
		try {
			uri = new URI(endPoint);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.requestSpecification = RestAssured
										.given();
		this.response = this.requestSpecification
				                  .headers(headers)
				                  .pathParams(pathParameters)
				                  .queryParams(queryParamers)
				              .when()				    
				              .get(uri);
		
		return response;
	}
	
	public Response postCall(Map<String, String> headers, Object requestPayload, ContentType contentType, Map<String, String> pathParamers) {
		
		URI uri = null;
		try {
			uri = new URI("");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.requestSpecification = RestAssured
										.given();
		this.response = this.requestSpecification
									.headers(headers)
									.contentType(contentType)
									.body(requestPayload)
									.pathParams(pathParamers)
								.when()
									.post(uri);
		return response;		
						
	}
	
	public Response putCall(Map<String, String> headers, Object requestBody, ContentType contentType, Map<String, String> pathParameters, String endPoint) {
		URI uri = null;
		try {
			uri = new URI(endPoint);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.requestSpecification = RestAssured
				.given();
		this.response = this.requestSpecification
					            .headers(headers)
					            .pathParams(pathParameters)
					            .body(requestBody)
					            .contentType(contentType)
					       .when()
					      		.put(uri);
		
		return response;
	}
	
	
	public Response deleteCall(Map<String, String> headers, Map<String, String> pathParameters, String endPoint ) {
		
		URI uri = null;
		try {
			uri = new URI(endPoint);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.requestSpecification = RestAssured
				.given();
		this.response = this.requestSpecification
								.headers(headers)
								.pathParams(pathParameters)
							.when()
								.delete(uri);
		
		return response;
		
	}
	
	public RequestSpecification getRequestSpecification() {
		return this.requestSpecification;
	}
	
	public Response getResponseObject() {
		return this.response;
	}

}
