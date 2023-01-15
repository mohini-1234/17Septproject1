package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.thread.IFutureResult;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;
import Utility.UtilityMethods;

public class CaptureScreenshotForFail extends TestBase{
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
	@Test(enabled= false)
	public void verifyLoginLogoTest() 
	{
		boolean result = Login.veriffyLoginLogo();
		Assert.assertEquals(result, true);
	}
	//2]
	@Test(enabled = true)
	public void veriFyBotLogoTest() 
	{
		boolean result = Login.verifyBotLogo();
		Assert.assertEquals(result, true);
	}
	//3]
	@Test(enabled = true)
	public void verifyTitleTest() 
	{
		
		String expTitle = "Swag Labs";
		String actTitle = Login.verifyTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(  "Title of Web application ="+actTitle);
		
	}
	//4]
	@Test(enabled = false)
	public void verifyCurrentUrlTest() 
	{
		//login page chi url verify karaychi
		String expUrl = "https://www.saucedemo.com/";
		String actUrl = Login.verifyCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log( "Url of Web application ="+actUrl);
	}
	//***************************************
	//5]
	@Test(enabled = false)
	public void loginToAppTest() throws Exception 
	{
		//current url bhetli pahi after login
		String expRes = "https://www.saucedemo.com/inventory.html";
		//actally login kele ani actually tya pge vr gelo url bhetli
		String actRes = Login.loginToApp();
		Assert.assertEquals(actRes,expRes);
		Reporter.log("URL of application ="+ actRes);
	}
	//*****************************************
	//6]
	
	
	@AfterMethod
	public void closeBrowser(ITestResult a) throws Exception 
	{
		if(ITestResult.FAILURE== a.getStatus())
		{
			UtilityMethods.captureScreenShot(a.getName());
		}
	
			
		driver.close();
		
	}
    

}
