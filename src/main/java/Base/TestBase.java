package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	//we make driver globle bcz we can access driver throught out the project
	//we make it static bcz single copy of driver should share
	public static WebDriver driver;
	
	//this method should open the browser and enter the URL
	public void initialization() throws Exception
	{
		String browser = ReadData.readPropertyFile("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browser.equals("opera"))
		{
			WebDriverManager.operadriver().setup();
			 driver = new OperaDriver();
	    }
		else if (browser.equals("safari"))
		{
			WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      String url	= ReadData.readPropertyFile("URL");
		driver.get(url);
		//driver.get("https://www.saucedemo.com/");
	}
	
	
		 
	
	
	
	
}
