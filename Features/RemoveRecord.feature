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
@Delete @API
Feature: Remove the Record
  I want to use this template for my feature file

  @DeleteRecord
  Scenario Outline: Remove Existing Record Using Delete Call
    When User hit Delete Call using <id>
    Then Verify status Code as <statusCode>

    Examples: 
      | id | statusCode |
      |  4 |        404 |
