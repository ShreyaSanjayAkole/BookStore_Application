Feature: User Registration  

	Background: 
		Given the user is on the registration page

  Scenario: Validate Firstname and Lastname input (Positive)  
    When the user enters a valid firstname "John" and lastname "Doe" 
    And Close the browser after signup  

  Scenario: Validate username input (Negative)   
    When the user enters an invalid firstname "john" and lastname "do"  
    Then an error message should be displayed indicating the username is invalid 
    And Close the browser after signup

  Scenario: Validate Date Of Birth input (Positive)  
    When user selects "15-08-1995" as the date of birth
 		And Close the browser after signup
    
   Scenario: Validate password input (Positive)   
    When the user enters a password "Shreya@123"  
		And Close the browser after signup

  Scenario: Validate password input (Negative)  
 
    When the user enters invalid password "pass"
    Then an error message should be displayed 
    And Close the browser after signup
    
  Scenario: Validate email input (Positive)  
    When the user enters an email in the correct format "john.doe@example.com"  
    And Close the browser after signup
    
  Scenario: signup with all valid credentials
  	When the user signup with all valid credentials
  	And click on signup button
  	Then Login page should be displayed
  	And Close the browser after signup
  	
  	

 

   
