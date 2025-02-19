package stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.loginPage;
import PageObjects.signupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signup {
	
	static Logger log = Logger.getLogger(login.class);
	WebDriver driver = new ChromeDriver();
	signupPage signup = new signupPage(driver);;
	
	
	@Given("the user is on the registration page")
	public void user_is_on_signuppage() {
		
		log.info("Opening the browser");
		
		driver.get("http://localhost:4207/login");
		
		signup.getSignuppage();
	}
	
	@When("the user enters an invalid firstname {string} and lastname {string}")
	public void user_enters_invaild_name(String firstname,String lastname){
		log.info("Redirect to signup page");
		signup.setFirstname(firstname);
		signup.setLastname(lastname);
		log.info("Enter valid firstname and lastname");
	}
	
	@When("the user enters a valid firstname {string} and lastname {string}")
	public void user_enters_vaild_name(String firstname,String lastname) throws InterruptedException{
		log.info("Redirect to signup page");
		signup.setFirstname(firstname);
		signup.setLastname(lastname);
		Thread.sleep(5000);
		log.info("Enter Invalid email and password");
	}
	
	@Then("an error message should be displayed indicating the username is invalid")
	public void errormessage() {
		signup.errorMessage();
		log.info("Error message for invalid firstname and lastname");
	}
	
	@When("^user selects \"([^\"]*)\" as the date of birth$")
	public void DateOfBirth(String dob) {
		signup.setDOB(dob);
	}
	
	@When("the user enters a password {string}")
	public void user_enters_vaild_password(String password) {
		signup.setPassword(password);
		log.info("Enter valid password");
	}
	
	@When("the user enters invalid password {string}")
	public void user_enters_invaild_password(String password) {
		signup.setPassword(password);
		signup.setEmail(" ");
		log.info("Enter invalid password");
	}
	
	@Then("an error message should be displayed")
	public void passworderror() {
		signup.invalidpassword();
	}
	
	@When("the user enters an email in the correct format {string}")
	public void user_enters_vaild_email(String email) {
		signup.setEmail(email);
		log.info("Enter valid email");
	}
	
	@When("the user signup with all valid credentials")
	public void sigup() {
		signup.setFirstname("Sanjay");
		signup.setLastname("Wani");
		signup.setDOB("10-10-1998");
		signup.setPassword("Shreya@123");
		signup.setEmail("sanjay@gmail.com");
	}
	
	@And("click on signup button")
	public void click_signup() {
		signup.clickButton();
	}
	
	@Then("Login page should be displayed")
	public void verify_signup() {
		signup.verifySignuup();
	}
	
	@And("Close the browser after signup")
	public void close_the_browser() {
	    driver.close();  
	    System.out.println("Browser closed successfully.");
	    log.info("close the browser");
	}
	
	
	
	
//	@When("the user enters an email in an incorrect format {string}")
//	public void user_enters_invaild_email(String email) throws InterruptedException {
//		signup.setEmail(email);
//		signup.clickButton();
//		Thread.sleep(2000);
//		log.info("Enter invalid email");
//	}
//	
//	@Then("an error message should be displayed should be email")
//	public void emailerror() {
//		signup.invalidemail();
//	}
//	
	
	
	

}
