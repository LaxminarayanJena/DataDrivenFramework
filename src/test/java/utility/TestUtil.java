package utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestUtil extends BaseTest{
	
	
public static String mailscreenshotpath;
public static String screenshotname;
	public static Object[][] getData(String sheetName)
	{
		
		int rows= excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		Object [][] data= new Object[rows-1][cols];
	
		for(int rowNum =2 ; rowNum<=rows; rowNum++)
		{
			for(int colNum = 0; colNum< cols; colNum++)	
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
		 
	}
	
	public static void captureScreenshot() throws IOException
	{
		Calendar cal = new GregorianCalendar();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.HOUR_OF_DAY);
		int date=cal.get(Calendar.DATE);
		int min=cal.get(Calendar.MINUTE);
		int sec=cal.get(Calendar.SECOND);
		
		screenshotname= year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg"; 
		mailscreenshotpath = System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg"; 
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scr, new File("C:\\poltu\\java\\poltu1\\src\\test\\resources\\screenshot\\error.jpg"));
		FileUtils.copyFile(scr, new File(mailscreenshotpath));
	}

}
