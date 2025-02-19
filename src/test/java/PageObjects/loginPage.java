package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class loginPage {
	
	WebDriver driver;
	
	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By login = By.xpath("//button[@type='submit' and text()='Login']");
	By logo = By.xpath("//a[@class='title']");
	By error = By.xpath("//div[@id='toast-container']/div");
	
	public loginPage(WebDriver driver) {
        this.driver = driver; 
    }

	
	public void enterEmail(String username) {
		driver.findElement(email).sendKeys(username);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		
	}
	
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	public void islogoDisplaged() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("http://localhost:4207/homepage"));

		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "http://localhost:4207/homepage", "Home page URL did not match!");
		System.out.println("Home page URL validated successfully: " + actualURL);
	}
	
	public void userLogin(String username,String pass) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
	}
	
	public void message() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		driver.findElement(error).isDisplayed();		
	}
	
	public void emptylogin() {
		driver.findElement(login).click();
	}
	
	
	

}
