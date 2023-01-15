package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;

public class FailedTestCase extends TestBase {
	
	LoginPage login;
	InventryPage inventry;
	
    @BeforeMethod
    public void setup() throws Exception
    {
    	initialization();
    	 login =new LoginPage();
    	 login.loginToApp();
    	 inventry = new InventryPage();
    	 
    }
    
    @Test(enabled = true,groups= "sanity")
    public void verifyProductLableOfInventryTest() throws Exception
	{
	String expRes = "PRODUCTS";
	//"1PRODUCTS";purposefully i failed then again i corrrect it 
	//I want execute only fail Tc
	//total Tc 4 fail 3 i have to work on those three Tc
	//refresh my project//testoutput//
		String actRes = inventry .verifyProductLableOfInventry();
		Assert.assertEquals(expRes, actRes);
	}
    //1]
    @Test(enabled = true,groups="sanity")
    public void verifypeekLogoTest() 
    {
    	boolean result = inventry.verifypeekLogo();
    	Assert.assertEquals(result, true);
    }
    //2]
    @Test(enabled = true)
    public void addProductTest() throws Exception 
    {
    	 String result = inventry.addProduct();
    	 Assert.assertEquals(result, "3");
    	 Reporter.log("Total products added = " +result);
    }
    @Test(enabled=true)
    public void cartLinkClickTest() {
  	  String expresult ="https://www.saucedemo.com/cart.html";
    	String actresult = inventry.cartLinkClick();
    	Assert.assertEquals(actresult, expresult);
	}
    
    @AfterMethod
    public void closeBrowser()
    {
    	driver.close();
    }

	
	

}
