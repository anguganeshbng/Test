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
@Post @API
Feature: Post Call Scenarios
  I want to use this template for my feature file

  @PostNewRecord
  Scenario Outline: Verify to Create New Record Using Post Call
    When User hit post end point using record from "<filePath>"
    Then Verify status code <statusCode>
    And Validate Response Data

    Examples: 
      | filePath                                                    | statusCode |
      | src/test/resources/api/RequestPayload/newRecordDetails.json |        201 |

      
      
  @PostNewRecordPojo
  Scenario Outline: Verify to Create New Record Using Post Call
    When User hit post end point using record from "<filePath>"
    Then Verify status code <statusCode>
    And Verify response Body from file "<filePath>" using NewRecord Pojo

    Examples: 
      | filePath                                                    | statusCode |
      | src/test/resources/api/RequestPayload/newRecordDetails.json |        201 |
      