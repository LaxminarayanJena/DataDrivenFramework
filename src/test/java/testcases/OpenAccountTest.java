package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;
import base.BaseTest;

public class OpenAccountTest extends BaseTest{

	@Test(dataProvider= "getData")
	public void OpenAccount(String customer, String currency)
	{
		driver.findElement(By.xpath(OR.getProperty("openAccBtn"))).click();
		new Select(driver.findElement(By.xpath(OR.getProperty("customerid")))).selectByVisibleText(customer);
		new Select(driver.findElement(By.xpath(OR.getProperty("currencyid")))).selectByVisibleText(currency);
		driver.findElement(By.xpath(OR.getProperty("process"))).click();
	}
	
	
	@DataProvider
	public static Object[][] getData()
	{
		
return TestUtil.getData("OpenAccountTest");
		 
	}
}
