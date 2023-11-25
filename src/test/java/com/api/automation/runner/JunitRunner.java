package com.api.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
			
		features = "./Features",
		glue = { "com.api.automation.stepdef",
				  "com.api.automation.configuration" 
			   }, 
		tags = "@API",
		monochrome = true,
		plugin = {
				
				"html:target/CucumberReport/HTML_Report/cucumber.html",
				"json:target/CucumberReport/Json_Report/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		publish = true,
		dryRun = false
		
		
		)

public class JunitRunner {

}
