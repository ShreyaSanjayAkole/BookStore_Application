Feature: Login page Automation
	
	Background:
		Given User is on login page 
	
	Scenario: Check login is successful with valid creds 
		When User enters valid "shreya@gmail.com" and "Shreya@123" 
		And Clicks on Login button 
		Then User is navigated to Home Page 
		And Close the browser
		
	Scenario: login with invalid credential
		When User enter invalid email "abc@gmail.com" and password "123"
		And Clicks on Login button 
		Then error message is shown that bad credentials 
		And Close the browser
		
		Scenario: Email and password field is empty
		When User does not provide email and password
		And Clicks on Login button with empty credentials
		Then error message is shown that bad credentials 
		And Close the browser
		
		
