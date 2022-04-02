package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.baseclass.BaseClass;

import jdk.internal.org.jline.utils.Log;


public class LoginTest extends BaseClass{
	
	@Test (priority=1)
	public void loginAsBankManager()
	{
		driver.findElement(By.xpath(OR.getProperty("btnBankManagerLogin"))).click();
		log.debug("click on Bank Manager button");
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("btnAddCustomer"))));
		
	}
	
	@Test (priority=2, dependsOnMethods="loginAsBankManager")
	public void verifyOpenAccountBtn()
	{
	  String actualText = driver.findElement(By.xpath(OR.getProperty("btnOpenAccount"))).getText();
	  String expectedText = "Open Account";
	  Assert.assertEquals(actualText, expectedText,"Open Account button is not present");
	}
	
	@Test (priority=3, dependsOnMethods="loginAsBankManager")
	public void verifyCustomersBtn()
	{
		  String actualText = driver.findElement(By.xpath(OR.getProperty("btnShowCust"))).getText();
		  String expectedText = "Customers";
		  Assert.assertEquals(actualText, expectedText,"Open Account button is not present");
	}

}
