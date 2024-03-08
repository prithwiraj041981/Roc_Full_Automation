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
@regression
@monkey
Feature: Login in ROC Dev
Scenario Outline: This is scenerio of valid user login on DEV
   Given User is on ROCLogin page On DEV
   When User enters username as '<username_new>' and password as '<password_new>' on DEV
   Then User should be able to login sucessfully to landlord and new Homepage open ON DEV

   Examples: 
     | username_new                    |     password_new |
     | sayan011981@mailinator.com |     Mylogin@123  |
@SanityTest
Scenario Outline: for sanity This is scenerio of valid user login
   Given for sanity User is on ROCLogin page
   When for sanity User enters username as '<username_current>' and password as '<password_current>'
   Then for sanity User should be able to login sucessfully to landlord and new Homepage open

   Examples: 
     | username_current                |     password_current |
     | sayan011981@mailinator.com |     Mylogin@123      |