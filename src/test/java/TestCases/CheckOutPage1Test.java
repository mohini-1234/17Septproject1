package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartLinkPage;
import Pages.CheckOutPage1;
import Pages.InventryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class CheckOutPage1Test extends TestBase{

	LoginPage login;
	InventryPage invent ;
	CartLinkPage cart;
	CheckOutPage1 check1;
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
		cart.verifyCheckoutBtn1();
	   check1 = new CheckOutPage1();
	   


	}
	@Test(enabled=true)
	public void verifycheckOutInfomationLableTest() 
	{
	boolean actres	= check1.verifycheckOutInfomationLable();
	Assert.assertEquals(actres, true);
	}
	
	@Test(enabled=true)
	public void verifycheckOutInfomationTest() throws Exception 
	{
	String expres ="https://www.saucedemo.com/checkout-step-two.html";
	String actres	= check1.verifycheckOutInfomation();
	Assert.assertEquals(actres, expres);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
