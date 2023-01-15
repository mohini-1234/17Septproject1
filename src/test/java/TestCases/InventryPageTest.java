package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class InventryPageTest extends TestBase {
	
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
    
    @Test(enabled = true)
    public void verifyProductLableOfInventryTest() throws Exception
	{
	//String expRes = "PRODUCTS";
	String expRes = ReadData.readaexcelFile(1, 3);
		String actRes = inventry .verifyProductLableOfInventry();
		Assert.assertEquals(expRes, actRes);
		Reporter.log("verify Product Lable is present -->"+actRes);
	}
    //1]
    @Test(enabled = false)
    public void verifypeekLogoTest() 
    {
    	boolean result = inventry.verifypeekLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("verify peek Logo is present -->"+result);
    }
    @Test(enabled=false)
    public void verifyTwitterLogoTest() 
	{
		//to verify logo is present
    	boolean result = inventry.verifyTwitterLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("verify Twitter Logo is present -->"+result);
	}
    @Test(enabled=false)
	public void verifyFacebookLogoTest() 
	{
		//to verify logo is present
		boolean result = inventry.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("verify Facebook Logo is present-->"+result);
	}
    @Test(enabled=false)
	public void verifyLinkedInLogoTest() 
	{
		//to verify logo is present
		boolean result =inventry.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		Reporter.log("verify LinkedIn Logo is present-->"+result);
	}
    @Test(enabled=false)
	public void verifyFooterLogoTest() 
	{
		//to verify logo is present
	boolean result =	inventry.verifyFooterLogo();
	Assert.assertEquals(result, true);
	Reporter.log("verify Footer Logo is present-->"+result);
	}
    //2]
    @Test(enabled = true)
    public void addProductTest() throws Exception 
    {
    	// String expresult ="6";
    	 String expresult =ReadData.readaexcelFile(1, 4);
    	 String actresult = inventry.addProduct();
    	 Assert.assertEquals(actresult, expresult);
    	 Reporter.log("Total products added = " +actresult);
    }
    @Test(enabled=true)
    public void removeProductTest() throws Exception 
	{
    	//String expres = "4";
    	String expres = ReadData.readaexcelFile(1, 5);
    	String actres = inventry.removeProduct();
    	Assert.assertEquals(actres, expres);
    	Reporter.log("removeProductTest count -->"+actres);
	}
    @Test(enabled=true)
    public void cartLinkClickTest() throws Exception {
  	//  String expresult ="https://www.saucedemo.com/cart.html";
  	String expresult =ReadData.readaexcelFile(1, 6);
    	String actresult = inventry.cartLinkClick();
    	Assert.assertEquals(actresult, expresult);
    	Reporter.log("verify Url of next page-->"+actresult);
	}
    
    @AfterMethod
    public void closeBrowser()
    {
    	driver.close();
    }

	
	

}
