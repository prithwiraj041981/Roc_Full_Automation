#Author: your123.email@your.domain.com
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
@SmokeTest
Feature: Login in ROC
Scenario Outline: This is scenerio of valid user login
   Given User is on ROCLogin page
   When User enters username as '<username>' and password as '<password>'
   Then User should be able to login sucessfully to landlord and new Homepage open

   Examples: 
     | username                        |     password    |
     | sayan011981@mailinator.com |     Mylogin@123 |