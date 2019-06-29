package com.class03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class HomeworkOne extends CommonMethods{
//	Identify Priority of Test Cases

//	TC 1: OrangeHRM Verify Successful Login
//	Step 1: Open browser and navigate to OrangeHRM
//	Step 2: Enter valid UID and valid PWD and click login button
//	Step 3: Verify user successfully logged in
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
	}
	
	@Test
	public void verifyLoggedIn() {
		boolean isDisplayed=driver.findElement(By.xpath("//a[text()='Welcome Admin']")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Welcome Admin is not displayed");
	}
	
	@AfterClass
	public void LogOut() {
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
	}
	

//TC 3: OrangeHRM Verify Employee Details
//	Step 1: Click on PIM link and Employee List
//	Step 2: Search for employee by it id
//	Step 3: Verify Employee details are displayed 
//
//Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application
}
