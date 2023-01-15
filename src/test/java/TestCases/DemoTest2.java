package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;

public class DemoTest2 extends TestBase {
	
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
    
    @Test(enabled = false)
    public void verifyProductLableOfInventryTest() throws Exception
	{
	String expRes = "PRODUCTS";
		String actRes = inventry .verifyProductLableOfInventry();
		Assert.assertEquals(expRes, actRes);
	}
    //1]
    @Test(invocationCount = 1,enabled=false)//we should run our Test Cases atLeast 3 times then ....Recheck sathi
    public void verifypeekLogoTest() 
    {
    	boolean result = inventry.verifypeekLogo();
    	Assert.assertEquals(result, true);
    }
    //2]
    @Test(enabled = true,timeOut=2000)//200threadTimeOutException Occure
    public void addProductTest() throws Exception 
    {
    	 String result = inventry.addProduct();
    	 System.out.println("Test Case Pass1");
    	 Assert.assertEquals(result, "4","test case fail zali ka");
    	 //message arg Tc fail zalyavarch disel
    	 //AssertionError: test case fail zali ka expected [4] but found [3]
    	 System.out.println("test case pass2");
    	 Reporter.log("Total products added = " +result);
    	 Assert.assertTrue(true);//purposefulyy TC fail karaychi asel tr
    	 //AssertionError: did not expect to find [true] but found [false]
    	 //HardAssertion -ek test case fail zali tari dusri Tc continue hote
    	   //&remaining statements in method is aborted
    	   //AssertionError: expected [4] but found [3]
    }
    @Test(enabled=false)
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
