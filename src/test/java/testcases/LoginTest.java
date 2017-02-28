package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {


		@Test
		public void loginAsBankManagerTest()
		
		{
			driver.findElement(By.xpath(OR.getProperty("bmlogin"))).click();
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			Assert.assertTrue(isElementPresent(OR.getProperty("addcust")));
			
		}

	}


