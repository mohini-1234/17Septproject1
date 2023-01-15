package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartLinkPage extends TestBase{
	@FindBy(id = "checkout")private WebElement checkoutbtn;
	@FindBy(id="continue-shopping")private WebElement continueShoppingBtn;
	@FindBy(xpath ="//span[@class='title']")private WebElement cartlable;
	//span[@class='title']


	public CartLinkPage() 
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageUrl()
	{
		return driver.getCurrentUrl();
	}
//1]
	public String verifylable()
	{
		return cartlable.getText();
	}
	public boolean verifyCheckoutBtn() {
	
		return checkoutbtn.isDisplayed();
		}
	
	public String verifyCheckoutBtn1() throws Exception
	{
		checkoutbtn.click();
		//Thread.sleep(5000);
		return driver.getCurrentUrl();
		
	}
		
		
	public boolean verifycontinueShoppingBtn() throws Exception {
		//Thread.sleep(5000);
		return continueShoppingBtn.isDisplayed();
	}
	
	
	
	
	
//2]

}
