package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	//1]
	public static String readPropertyFile(String value) throws Exception 
	{
		//this method read the data from config.property file
		//config.properties file madhla credential data read karnyasthi ha code ahe
		//properties class//
		//String add= System.getProperty("user.dir")+"\\TestData\\Config.properties";
		String address= "C:\\Users\\HP\\eclipse-workspace\\Project17Sep\\TestData\\Config.properties";
		Properties p = new Properties();
	FileInputStream File =new FileInputStream(address);
	p.load(File);
	return p.getProperty(value);
	}
	
	//2]
	public static String readaexcelFile(int row, int col) throws Exception 
	{
		//excel file madhla data read karnyasthi ha code ahe
		//FileInputstream class//
		//String add = System.getProperty("user.dir")+"\\TestData\\New Microsoft Excel Worksheet.xlsx";
		String FileAddress = "C:\\Users\\HP\\eclipse-workspace\\Project17Sep\\TestData\\New Microsoft Excel Worksheet.xlsx";
       FileInputStream file = new FileInputStream(FileAddress);
      Sheet excel  = WorkbookFactory.create(file).getSheet("Sheet3");
     String value = excel.getRow(row).getCell(col).getStringCellValue();
     return value;
	}

}
;