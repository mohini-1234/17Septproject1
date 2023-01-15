package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethods;

public class InventryPage extends TestBase{
	@FindBy(xpath="//span[@class='title']")private WebElement productLable;
	@FindBy(xpath="//div[@class='peek']")private WebElement peekLogo;
	@FindBy(xpath ="//img[@class='footer_robot']")private WebElement swagLogo;
	@FindBy(xpath="//li[@class='social_twitter']//a")private WebElement twitterLogo;
	@FindBy(xpath="//li[@class='social_facebook']//a")private WebElement fbLogo;
	@FindBy(xpath="//li[@class='social_linkedin']//a")private WebElement linkdinLogo;
	@FindBy(xpath="//img[@class='footer_robot']")private WebElement footerLogo;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")private WebElement backpack;
	@FindBy(id="add-to-cart-sauce-labs-bike-light")private WebElement bikeLight;
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")private WebElement boltTshirt;
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")private WebElement fleeceJacket;
	@FindBy(id="add-to-cart-sauce-labs-onesie")private WebElement onesieTshirt;
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")private WebElement allThingsTshirt;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")private WebElement prices;
	@FindBy(xpath="//div[@class='inventory_item_name']") private WebElement names;
    @FindBy(xpath ="//select[@class='product_sort_container']")private WebElement sortProductDropDown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")private WebElement productCount;
	@FindBy(className = "shopping_cart_link")public WebElement cartLink;
	
	@FindBy(id="remove-sauce-labs-backpack")private WebElement removebackpack;
	@FindBy(id="remove-sauce-labs-bike-light")private WebElement removebikeLight;
	@FindBy(id="remove-sauce-labs-bolt-t-shirt")private WebElement removeboltTshirt;
	@FindBy(id="remove-sauce-labs-fleece-jacket")private WebElement removefleeceJacket;
	@FindBy(id="remove-sauce-labs-onesie")private WebElement removeonesieTshirt;
	@FindBy(id="remove-test.allthethings()-t-shirt-(red)")private WebElement removeallThingsTshirt;
	//constructor to initialize driver with instance variable
	//constructor use to initialize the data member of class after creating an object (same class) we use "this" 
	//from (parent class) we use "super" keyword
	public InventryPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyProductLableOfInventry() throws Exception
	{
		
		return productLable.getText();
	}
	public boolean verifypeekLogo() 
	{
		//to verify logo is present
		return peekLogo.isDisplayed();
	}

	public boolean verifyTwitterLogo() 
	{
		//to verify logo is present
		return twitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo() 
	{
		//to verify logo is present
		return fbLogo.isDisplayed();
	}
	public boolean verifyLinkedInLogo() 
	{
		//to verify logo is present
		return linkdinLogo.isDisplayed();
	}
	public boolean verifyFooterLogo() 
	{
		//to verify logo is present
		return footerLogo.isDisplayed();
	}
	public boolean verifyswagLogo() 
	{
		//to verify logo is present
		return swagLogo.isDisplayed();
	}

	public String addProduct() throws Exception 
	{
		//utility method
		UtilityMethods.selectClassMethod(sortProductDropDown,"Price (low to high)");

		//Select s = new Select(sortProductDropDown);
		//  s.selectByVisibleText("Name (Z to A)");
		Thread.sleep(1000);
		backpack.click();
		Thread.sleep(1000);
		bikeLight.click();
		Thread.sleep(1000);
		boltTshirt.click();
		Thread.sleep(1000);
		fleeceJacket.click();
		Thread.sleep(1000);
		onesieTshirt.click();
		Thread.sleep(1000);
		allThingsTshirt.click();
		Thread.sleep(1000);
	    productCount.click();
		return productCount.getText();
}
	public String removeProduct() throws Exception 
	{
		addProduct();
		//removebackpack.click();
	//	removebikeLight.click();
		//removeboltTshirt.click();
		//removefleeceJacket.click();
		removeonesieTshirt.click();
		removeallThingsTshirt.click();
		return productCount.getText();
		
	}
	

public String cartLinkClick() {
	  cartLink.click();
	 
		return  driver.getCurrentUrl();
	}

}
