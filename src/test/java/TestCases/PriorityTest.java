package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;

public class PriorityTest extends TestBase{
	LoginPage Login;// = new LoginPage();
	//************************
	@BeforeMethod(alwaysRun=true)
	  public void setup() throws Exception 
    {
	  initialization();//open url
	 Login = new LoginPage();//login page object 
	
    }
	//**********************
	//1]
	@Test(priority = 5)
	public void verifyLoginLogoTest() 
	{
		boolean result = Login.veriffyLoginLogo();
		Assert.assertEquals(result, true);
	}
	//2]
	@Test(priority = -8)
	public void veriFyBotLogoTest() 
	{
		boolean result = Login.verifyBotLogo();
		Assert.assertEquals(result, true);
	}
	//3]
	@Test(priority = 3)
	public void verifyTitleTest() 
	{
		
		String expTitle = "Swag Labs";
		String actTitle = Login.verifyTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(  "Title of Web application ="+actTitle);
		
	}
	//4]
	@Test(priority = -1, groups="Sanity")
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
	@Test(priority = 0)
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
	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() 
	{
		driver.close();
		
	}
    

}
