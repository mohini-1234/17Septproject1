package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class CheckOutPage1 extends TestBase{
@FindBy(xpath="//span[@class='title']")private WebElement checkOutInfomationLable;
@FindBy(xpath ="//input[@id='first-name']")public WebElement firstNameTextBox;
@FindBy(xpath ="//input[@id='last-name']")public WebElement lasttNameTextBox;
@FindBy(xpath ="//input[@id='postal-code']")public WebElement postalCodeTextBox;
@FindBy(xpath="//input[@id='continue']")public WebElement continueBtn;

public CheckOutPage1() {
	PageFactory.initElements(driver, this);
}


public boolean verifycheckOutInfomationLable() 
{
	return checkOutInfomationLable.isDisplayed();
}
public String verifycheckOutInfomation() throws Exception 
{
	Thread.sleep(1000);
	//firstNameTextBox.sendKeys("mohini");
	firstNameTextBox.sendKeys(ReadData.readaexcelFile(2,0));
	Thread.sleep(1000);
	//lasttNameTextBox.sendKeys("yelwe");
	lasttNameTextBox.sendKeys(ReadData.readaexcelFile(2,1));
	Thread.sleep(1000);
	//postalCodeTextBox.sendKeys("431001");
	postalCodeTextBox.sendKeys(ReadData.readaexcelFile(2, 2));
	Thread.sleep(1000);
	continueBtn.click();
	return driver.getCurrentUrl();
}
public String verifyChekOutBtn() 
{
	continueBtn.click();
	return continueBtn.getText();
}
}
