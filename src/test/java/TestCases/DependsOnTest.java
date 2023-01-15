package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class DependsOnTest extends TestBase {


	LoginPage Login;
	@BeforeMethod
	public void setup() throws Exception 
	{
		initialization();
		Login = new LoginPage();
	}

	@Test
	public void verifyTitleTest() 
	{
		String expTitle = "1Swag Labs";
		String actTitle = Login.verifyTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log(  "Title of Web application ="+actTitle);
	}
	@Test(dependsOnMethods = "verifyTitleTest")
	public void loginToAppTest() throws Exception 
	{
		String expRes = "https://www.saucedemo.com/inventory.html";
		String actRes = Login.loginToApp();
		Assert.assertEquals(actRes, expRes);
		Reporter.log("URL of web Application =" +actRes);
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();

	}


}
