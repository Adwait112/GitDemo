package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	By email = By.xpath("//input[@id='email']");
	By RetrivePassword = By.xpath("//span[normalize-space()='Retrieve Password']");

	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement getemail()

	{
		return driver.findElement(email);
	}
	
	public WebElement RetrivePassword()

	{
		return driver.findElement(RetrivePassword);
	}
	
}
