package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	By singin = By.xpath("//a[contains(text(),'Sign in')]");
	By title = By.xpath("//h1[normalize-space()='Automation Practice Website']");
	By menubar = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public LoginPage getLogin()

	{
	driver.findElement(singin).click();
	LoginPage login = new LoginPage(driver);
	return login;
	}



	public WebElement getTitle() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(title);
	}

	public WebElement getMenubar() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(menubar);
	}

}
