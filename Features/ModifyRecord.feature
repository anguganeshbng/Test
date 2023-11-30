#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Put @API
Feature: Modify Existing Record Functionality
  I want to use this template for my feature file

  @ModifyDetails
  Scenario Outline: Verify Update is working fine using PUT Call
    When User hit PUT Call using <id> from "<filePath>"
    Then Verify status code using <statusCode>
    And Verify Updated Response Data

    Examples: 
      | id | statusCode | filePath                                                |
      |  5 |        200 | src/test/resources/api/RequestPayload/updateRecord.json |

  @ModifyDetailsUsingPojo
  Scenario Outline: Verify Update is working fine using PUT Call (Through POJO)
    When User hit PUT Call using <id> from "<filePath>"
    Then Verify status code using <statusCode>
    And Verify Updated Response Data from "<filePath>" using Pojo

    Examples: 
      | id | statusCode | filePath                                                |
      |  5 |        200 | src/test/resources/api/RequestPayload/updateRecord.json |
      
      
      
      
      