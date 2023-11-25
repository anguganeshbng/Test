package com.api.automation.helpers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonHelpers {

	private ObjectMapper objectMapper;
	
	public JsonHelpers() {
		// TODO Auto-generated constructor stub
		this.objectMapper = new ObjectMapper();
	}
	
	public String readJsonFileAsString(String filePath) {
		byte[] byteArray = null;
		File file = new File(filePath);		
		Path path = Paths.get(filePath);
		try {
			byteArray = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jsonString = new String(byteArray);	
		return jsonString;
	}
	
	public <T> T readJsonToPojo(String filePath, Class<T> classType) {
		T pojoDetails = null;
		try {
		  pojoDetails =	objectMapper.readValue(new File(filePath), classType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pojoDetails;		
	}
	
}
