package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartLinkPage;
import Pages.InventryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class CartLinkPageTest extends TestBase{
	LoginPage login;
	InventryPage invent ;
	CartLinkPage cart;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		login.loginToApp();
		invent = new InventryPage();
		invent.addProduct();
		invent.cartLinkClick();
		cart = new CartLinkPage();

	}
	@Test(enabled=true,invocationCount=1,priority=0)
	public void verifyCartPageUrlTest()
	{
		String expres = "https://www.saucedemo.com/cart.html";
		String actres = cart.verifyCartPageUrl();
		Assert.assertEquals(actres, expres);
		Reporter.log("verifyCartPageUrlTest --> "+actres);
		
	}
	@Test(enabled=true,invocationCount=1,priority=1)
	public void verifylableTest()
	{
		String expres = "YOUR CART";
	String actres	=cart.verifylable();
	Assert.assertEquals(actres, expres);
	Reporter.log("verifylableTest--> "+ actres);
	}
	
	@Test(enabled=true,invocationCount=1,priority=2)
	public void verifyCheckoutBtn() {

		boolean actres	= cart.verifyCheckoutBtn();
		assertEquals(actres, true);
		Reporter.log("verifyCheckoutBtn-->"+actres);
	}
	@Test(enabled=true,invocationCount=1,priority=3)

	public void verifycontinueShoppingBtnTest() throws Exception {
		boolean actres	= cart.verifycontinueShoppingBtn();
		Assert.assertEquals(actres, true);
		Reporter.log("verifycontinueShoppingBtnTest-->"+actres);
    }
	@Test(enabled=true,invocationCount=1,priority=4)
	public void verifyCheckoutBtnTest1() throws Exception {
		String expresult = "https://www.saucedemo.com/checkout-step-one.html";
		String actresult = cart.verifyCheckoutBtn1();
		Assert.assertEquals(actresult, expresult);
		Reporter.log("verifyCheckoutBtnTest1 --> "+actresult);
	}
	
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
	}
}
