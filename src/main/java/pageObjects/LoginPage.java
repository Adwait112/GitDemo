package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By email = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='passwd']");
	By Singin = By.xpath("//span[normalize-space()='Sign in']");
	By ForgotPassword = By.xpath("//a[contains(text(),'Forgot your password?')]");


	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public ForgotPassword ForgotPassword()
	{
		driver.findElement(ForgotPassword).click();
		return new ForgotPassword(driver);
		
	}

	public WebElement getemail()

	{
		return driver.findElement(email);
	}

	public WebElement getpassword()

	{
		return driver.findElement(password);
	}


	public WebElement getSingin() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(Singin);
	}


}
