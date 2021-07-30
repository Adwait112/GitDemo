package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest

	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		//System.out.println(prop.getProperty("url"));
		//driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider="getData")
	public void basepageNavigation(String Username,String Password,String text) throws IOException

	{
		//driver = initializeDriver();
		//driver.get("http://automationpractice.com/index.php");
		//System.out.println(prop.getProperty("url"));
		//driver.get(prop.getProperty("url"))

		LandingPage lp = new LandingPage(driver);
		LoginPage login=lp.getLogin();//driver.findelement(By.xpath())

		login.getemail().sendKeys("Username");//driver.findelement(By.xpath())
		login.getpassword().sendKeys("Password");
		//System.out.println("text");
		Log.info(text);
		login.getSingin().click();
		ForgotPassword fp = login.ForgotPassword();
		fp.getemail().sendKeys("abc");
		fp.RetrivePassword().click();
	}

	@DataProvider
	public Object[][]getData(){

		Object[][] data = new Object[2][3];
		//0th row
		data[0][0]="nonristricteduser@qa.com";
		data[0][1]="123456";
		data[0][2]="Restricteduser";

		//1st row
		data[1][0]="nonristricteduser@qa.com";
		data[1][1]="123456";
		data[1][2]="Restricteduser";
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();

	}

}
