package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {

	//object Repository
	@FindBy(xpath="//div[@class='login_logo']")private WebElement loginLogo;
	@FindBy(xpath="//div[@class='bot_column']")private WebElement botLogo;
	@FindBy(xpath="//input[@id='user-name']")private WebElement usernameTextBox;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordTextBox;
	@FindBy(xpath="//input[@id='login-button']")
	public WebElement loginButton;

	//**************************
	//constructor to initialize the elements of page
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	//**********************
	//1]
	public boolean veriffyLoginLogo() 
	{
		return loginLogo.isDisplayed();
	}
	//2]
	public boolean verifyBotLogo() 
	{
		return botLogo.isDisplayed();
	}
	//3]
	public String verifyTitle() 
	{
		return driver.getTitle();
	}
	//4]
	public String verifyCurrentUrl() 
	{
		return driver.getCurrentUrl();
	}
	//5]
	public String loginToApp() throws Exception 
	{
		//usernameTextBox.sendKeys("standard_user");
		//Thread.sleep(3000);
		usernameTextBox.sendKeys(ReadData.readPropertyFile("username"));
		//usernameTextBox.sendKeys(ReadData.readaexcelFile(0, 0));

		//passwordTextBox.sendKeys("secret_sauce");
		//Thread.sleep(3000);
		passwordTextBox.sendKeys(ReadData.readPropertyFile("password"));
		//passwordTextBox.sendKeys(ReadData.readaexcelFile(0, 1));

		//Thread.sleep(3000);
		loginButton.click();
		//after login verify current url( https://www.saucedemo.com/inventory.html)
		return driver.getCurrentUrl();
	}


}
