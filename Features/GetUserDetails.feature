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
@Get @API
Feature: Verify User Details
  I want to use this template for my feature file

  @GetUserDetails
  Scenario Outline: Get User Details using Id
    When User hit userDetails endpoing using id as <id>
    Then Verify status code as <responseCode>
    And Verify response Body from file "<filePath>"

    Examples: 
      | id | responseCode | filePath                                                |
      |  5 |          200 | src/test/resources/api/ValidatePayload/userDetails.json |

  @GetUserDetailsUsingPojo
  Scenario Outline: Get User Details using Id
    When User hit userDetails endpoing using id as <id>
    Then Verify status code as <responseCode>
    And Verify response Body from file "<filePath>" using Pojo

    Examples: 
      | id | responseCode | filePath                                                |
      |  5 |          200 | src/test/resources/api/ValidatePayload/userDetails.json |
