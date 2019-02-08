package seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import org.junit.Assert;
 
public class try1  {
  public static void main(String[] args) {
 
    // Create an instance of the driver
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\DzulFakhri\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
 
    // Navigate to a web page
    driver.get("http://ec2-13-250-30-58.ap-southeast-1.compute.amazonaws.com:3001/");
 
    // Perform actions on HTML elements, entering text and submitting the form
    WebElement usernameElement     = driver.findElement(By.name("login"));
    WebElement passwordElement     = driver.findElement(By.name("password"));
    WebElement formElement        = driver.findElement(By.name("click"));
 
    usernameElement.sendKeys("dzulfaq");
    passwordElement.sendKeys("dzulfaq");
 
    formElement.submit();        // submit by form element
    
 // Run a test
    System.out.println("Browser Opened");
	String title = driver.getTitle();
	System.out.println("Title: " + title);
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement messageElement = wait.until(
           ExpectedConditions.presenceOfElementLocated(By.name("test"))
            );
	
	String message = messageElement.getText();
	String successMsg = "Login Succeeded";
	Assert.assertEquals (message, successMsg);
	
	if(successMsg == "Login Succeeded") {
		System.out.println("Login Passed");
	}
	else {
		System.out.println("Login Failed");
	}
	
	// Conclude a test
	//driver.quit();
 
  }
}