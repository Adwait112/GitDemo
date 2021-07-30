package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class validateTitle extends Base {

	public WebDriver driver;

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest

	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.info("Navigated to Home Page");
		driver.get("http://automationpractice.com/index.php");
		//System.out.println(prop.getProperty("url"));
		//driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
	}

	@Test
	public void basepageNavigation() throws IOException

	{


		LandingPage lpage = new LandingPage(driver);
		Assert.assertEquals(lpage.getTitle().getText(), "Automation Practice Website123");

		Log.info("Sucessfuly Validated Text message");

		//Assert.assertTrue(lpage.getMenubar().isDisplayed());


	}
	@AfterTest
	public void teardown()
	{
		driver.close();

	}


}
