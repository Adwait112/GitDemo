package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	//public Properties prop;


	public WebDriver initializeDriver() throws IOException
	{

		Properties prop = new Properties();
		//prop = new Properties();
		FileInputStream Fis = new FileInputStream("D:\\FrameWork\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(Fis);
		//mvn test -Dbrowser=chrome
		String browserName = System.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome") )

		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			//exicute chromedriver


		}
		
		/*if(browserName.contains("chrome"))

		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}*/

		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "‪D:\\geckodriver.exe");
			driver = new FirefoxDriver();
			//exicute firefox
		}

		else if(browserName.equals("IE"))
		{

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}


