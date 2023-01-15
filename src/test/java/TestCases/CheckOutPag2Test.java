package TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;

import Base.TestBase;
import Pages.CartLinkPage;
import Pages.CheckOutPage1;
import Pages.InventryPage;
import Pages.LoginPage;

public class CheckOutPag2Test extends TestBase {
	LoginPage login;
	InventryPage invent;
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
	   check1.verifyChekOutBtn();
	  
}
	JavascriptExecutor js =  ((JavascriptExecutor)driver);
}
