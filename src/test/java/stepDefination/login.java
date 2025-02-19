package stepDefination;

import org.apache.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class login {
	
	static Logger log = Logger.getLogger(login.class);
	WebDriver driver = new ChromeDriver();
	loginPage login = new loginPage(driver);;
	
	
	@Given("User is on login page")
	public void user_is_on_loginpage() {
		
		log.info("Opening the browser");
		
		driver.get("http://localhost:4207/login");
		
	}
	@When("User enters valid {string} and {string}")
	public void user_enters_valid_details(String username,String password){
		log.info("Redirect to login page");
		
		login.enterEmail(username);
		login.enterPassword(password);
		log.info("Enter valid email and password");
	}
	
	@When("User enter invalid email {string} and password {string}")
	public void user_enters_invalid_details(String username,String password) throws InterruptedException{
		log.info("Redirect to login page");
		login.enterEmail(username);
		login.enterPassword(password);
		Thread.sleep(5000);
		log.info("Enter invalid email and password");
	}
	
	@When("User does not provide email and password")
	public void user_enters_empty_details() throws InterruptedException{
		log.info("Redirect to login page");
		login.enterEmail("");
		login.enterPassword("");
		Thread.sleep(5000);
		log.info("Enter invalid email and password");
	}
	

	@And("Clicks on Login button")
	public void click() {
		login.clickLogin();
		log.info("Click on logging button");
	}

	@Then("User is navigated to Home Page")
	public void homePage() {
		login.islogoDisplaged();
		log.info("navigate to home page");
	}
	
	@Then("error message is shown that bad credentials")
	public void errorMessage() {
		login.message();
		log.info("Error message for invalid credentails");
	}
	
	@And("Clicks on Login button with empty credentials")
	public void EmptyLogin() {
		login.emptylogin();
		login.message();
	}

	@And("Close the browser")
	public void close_the_browser() {
	    driver.close();  
	    System.out.println("Browser closed successfully.");
	    log.info("close the browser");
	}
	
	
}
