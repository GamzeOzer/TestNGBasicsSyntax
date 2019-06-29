package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class NewtoursExample extends CommonMethods {
	
	//@BeforeGroups("Regression")
	@BeforeMethod(alwaysRun =true, groups ="Regression")
	public void setUP() {
		setUpDriver("chrome", "http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}
	
	@Test(groups ="Smoke")
	public void userInformation() {
		sendText(driver.findElement(By.cssSelector("input#email")),"usertest@gmail.com");
		sendText(driver.findElement(By.cssSelector("input[name='password']")), "passtest");
		sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "passtest");
		driver.findElement(By.cssSelector("input[name='register']")).click();
	}
	
	@Test(groups ="Regression")
	public void contactInformation() {
		sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "nameTest");	
		sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastnameTest");
		sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTest");
		sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		//driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}
	
	@Test(groups ="Regression",dependsOnMethods ="contactInformation")
	public void mailingInformation() throws InterruptedException {
		sendText(driver.findElement(By.cssSelector("input[name='address1']")), "addressTest");	
		sendText(driver.findElement(By.cssSelector("input[name='city']")), "cityTest");
		sendText(driver.findElement(By.cssSelector("input[name='state']")), "stateTest");
		sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "postalTest");
		driver.findElement(By.xpath("//input[@name='register']")).click();
	}
	
	//@AfterGroups( "Regression")
	@AfterMethod(alwaysRun = true, groups ="Regression")
	public void tearDown() {
		driver.close();
	}

}