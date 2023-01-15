package TestCases;

import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;
import Utility.ReadData;
import Utility.UtilityMethods;

public class LoginPageTest extends TestBase{
	LoginPage Login;// = new LoginPage();
	//************************
	@BeforeMethod
	  public void setup() throws Exception 
    {
	  initialization();//open url
	 Login = new LoginPage();//login page object 
	
    }
	//**********************
	//1]
	@Test(enabled= true)
	public void verifyLoginLogoTest() 
	{
		boolean result = Login.veriffyLoginLogo();
		Assert.assertEquals(result, true);
		Reporter.log("verify Login Logo is present -->"+result);
	}
	//2]
	@Test(enabled = true)
	public void veriFyBotLogoTest() 
	{
		
		boolean result = Login.verifyBotLogo();
		Assert.assertEquals(result, true);
		Reporter.log("veriFy Bot Logo is present -->"+result);
	}
	//3]
	@Test(enabled = true)
	public void verifyTitleTest() throws Exception 
	{
		
		//String expTitle = "Swag Labs";
		String expTitle = ReadData.readaexcelFile(1, 0);
		String actTitle = Login.verifyTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(  "Title of Web application ="+actTitle);
		
	}
	//4]
	@Test(enabled = true)
	public void verifyCurrentUrlTest() throws Exception 
	{
		//login page chi url verify karaychi
		//String expUrl = "https://www.saucedemo.com/";
		String expUrl = ReadData.readaexcelFile(1, 1);
		String actUrl = Login.verifyCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log( "verify Current Url of saucedemo Web application ="+actUrl);
	}
	//***************************************
	//5]
	@Test(enabled = true)
	public void loginToAppTest() throws Exception 
	{
		//current url bhetli pahi after login
		//String expRes = "https://www.saucedemo.com/inventory.html";
		String expRes = ReadData.readaexcelFile(1, 2);
		//actally login kele ani actually tya pge vr gelo url bhetli
		String actRes = Login.loginToApp();
		Assert.assertEquals(actRes,expRes);
		Reporter.log("URL ofinventory page application ="+ actRes);
	}
	//*****************************************
	//6]
	
	
	@AfterMethod
	public void closeBrowser(ITestResult a) throws Exception 
	{
		if(a.FAILURE==a.getStatus())
		{
			UtilityMethods.captureScreenShot(a.getName());
		}
		driver.close();
		
	}
    

}
