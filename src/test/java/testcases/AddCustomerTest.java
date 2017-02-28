package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;
import base.BaseTest;

public class AddCustomerTest extends BaseTest {
	
	
	@Test(dataProvider= "getData")
	public void addCustomer(String firstname, String lastname, String postcode)
	{
		driver.findElement(By.xpath(OR.getProperty("addcust"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postcode);
		driver.findElement(By.xpath(OR.getProperty("addCustomer"))).click();
		
		 Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		 Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		 alert.accept();
	}
	
	
	@DataProvider
	public static Object[][] getData()
	{
		
		return TestUtil.getData("AddCustomerTest");
		 
	}
	}