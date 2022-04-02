package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.baseclass.BaseClass;

public class AddCustomer extends BaseClass{
	
	@Test
	public void addCustomer()
	{
	//	driver.findElement(By.xpath(OR.getProperty("btnBankManagerLogin"))).click();
		driver.findElement(By.xpath(OR.getProperty("btnAddCustomer"))).click();
		
		  
		  driver.findElement(By.xpath(OR.getProperty("txtFirstname"))).sendKeys(
		  "firstname");
		  driver.findElement(By.xpath(OR.getProperty("txtLastname"))).sendKeys(
		  "secondname");
		  driver.findElement(By.xpath(OR.getProperty("txtPostcode"))).sendKeys(
		  "RA203345");
		  driver.findElement(By.xpath(OR.getProperty("btnAddCustomerSubmit"))).click();
		  
		  Alert alert  = driver.switchTo().alert();
		  
		  String txtAlertMessage = alert.getText();
		  String ExpectedAlertMsg = "Customer added successfully";
		  
		 Assert.assertTrue(txtAlertMessage.contains(ExpectedAlertMsg));
		 
		 alert.dismiss();
		 
		
	}

}
