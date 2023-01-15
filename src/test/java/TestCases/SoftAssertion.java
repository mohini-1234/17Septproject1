package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.InventryPage;
import Pages.LoginPage;

public class SoftAssertion extends TestBase {
	
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
    @Test(enabled = true)
    public void verifypeekLogoTest() 
    {
    	System.out.println("execution started");
    	//soft Assertion class //we need to create a object of soft assert class
    	SoftAssert soft = new SoftAssert();
    	boolean result = inventry.verifypeekLogo();
    	soft.assertEquals(result, false);//true kele tari pass//false kele tari pass
    	//method la fail kart nahi
    	System.out.println("execution ended");
    	soft.assertAll();//method execute hote pn error tc fail asel tr dakhvte
    	//this method give correct result and collect all the errores and throws the error
    	
    }
    //2]
    @Test(enabled = false)
    public void addProductTest() throws Exception 
    {
    	 String result = inventry.addProduct();
    	 Assert.assertEquals(result, "3");
    	 Reporter.log("Total products added = " +result);
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
