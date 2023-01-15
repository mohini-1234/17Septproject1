package Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class UtilityMethods extends TestBase{
	
	public static void selectClassMethod(WebElement dropDownElement,String visibleValue) 
	{
		//to handle dropdown with select tagname
		Select s = new Select(dropDownElement);
		s.selectByVisibleText(visibleValue);
		List<WebElement> allElements = s.getOptions();

		 System.out.println(allElements.size());

		 for( WebElement element : allElements)
		 {
		 System.out.println(element.getText());
		 }
	
	}
	public static Date getDate1() 
	{
		Date date1 = new Date(0);
		return date1;
	}
	
	public static void captureScreenShot(String name) throws Exception 
	{
        Date date1=getDate1();
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\Project17Sep\\TestData\\Screenshot/"+name+date1+".jpeg");
		 FileHandler.copy(source, dest);//method name ni Screenshot yeil
	}
	
	
	
	
	
	
	
//	public static List<double> sortingInteger(List<WebElement> price)
//	{
//		List<WebElement> listOfAllPrices = prices;
//		List<Double> ListOfdoubleTypePrices = new ArrayList<Double>();
//		for(WebElement ele :listOfAllPrices) 
//		{
//			//to convert Webelements into double type values and remove $ sign
//			ListOfdoubleTypePrices.add(Double.valueOf(ele.getText().replace("$","")));
//		}
//		return ListOfdoubleTypePrices;
//	}
	//to sorting all product price into ascending order
	

	

}
