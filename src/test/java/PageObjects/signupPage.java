package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class signupPage {
	
	WebDriver driver;
	
	By signup = By.xpath("//h2[text()='SIGNUP']");
	By Firstname = By.xpath("//input[@formcontrolname='firstName']");
	By Lastname = By.xpath("//input[@formcontrolname='lastName']");
	By DOB = By.xpath("//input[@formcontrolname='dob']");
	By Password = By.xpath("//input[@formcontrolname='password']");
	By Email = By.xpath("//input[@formcontrolname='email']");
	By button = By.xpath("//button[@type='submit' and contains(text(), 'Signup')]");
	

	
	
	
	
	public signupPage(WebDriver driver) {
        this.driver = driver; 
    }
	
	public void getSignuppage() {
		driver.findElement(signup).click();
	}
	

	public void setFirstname(String firstname) {
		driver.findElement(Firstname).sendKeys(firstname);
	}

	public void setLastname(String lastname) {
		driver.findElement(Lastname).sendKeys(lastname);
		

	}
	
	public void setDOB(String dob) {
		driver.findElement(DOB).sendKeys(dob);
	}

	public void setPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	
	public void setEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}
	
	public void clickButton() {
		driver.findElement(button).click();
	}
	
	public void verifySignuup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("http://localhost:4207/login"));

		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "http://localhost:4207/login", "Home page URL did not match!");
		System.out.println("Home page URL validated successfully: " + actualURL);
		
		
	}
	public void errorMessage() {
		WebElement signupElement = driver.findElement(By.xpath("//div[@class='text-danger']/span"));
		String actualText = signupElement.getText();
		String expectedText = "First Name Should start with Capital and AtLeast contain 3 characters";
		Assert.assertEquals(actualText, expectedText, "Text does not match!");
	}
	
	public void invalidpassword() {
		WebElement signupElement = driver.findElement(By.xpath("//div[@class='text-danger']/span"));
		String actualText = signupElement.getText();
		String expectedText = "Password requires lowercase, uppercase, number, and special character";
		Assert.assertEquals(actualText, expectedText, "Text does not match!");
	}
	
	public void invalidemail() {
		WebElement signupElement = driver.findElement(By.xpath("//div[@class='text-danger']/span"));
		String actualText = signupElement.getText();
		String expectedText = "Should be an Email";
		Assert.assertEquals(actualText, expectedText, "Text does not match!");
	}
	
	
	

}
