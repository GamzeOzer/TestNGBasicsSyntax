package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;
	
//import utils.CommonMethods;
//Identify Priority of Test Cases
//https://www.saucedemo.com/
//
//TC 1: Saucedemo Username1(tag the groups - Smoke)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username standard_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//TC 2: Saucedemo Username2(tag the groups - Regression)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username problem_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//
//Note: Create BeforeMethod and AfterMethod annotations 
//to open browser and logout from the application. 
//Create a xml file and include smoke.

public class TaskGroupSauceDemo extends CommonMethods{

	@BeforeMethod(alwaysRun=true, groups= {"smoke"})
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
	}
	
	@Test(groups= {"smoke"})
	public void standartUserLogin() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		boolean isvisibleProduct=driver.findElement(By.cssSelector("div.product_label")).isDisplayed();
		Assert.assertTrue(isvisibleProduct);
	}
	
	@Test(groups= {"regression"})
	public void problemUserLogin() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "problem_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		boolean isvisibleProduct=driver.findElement(By.cssSelector("div.product_label")).isDisplayed();
		Assert.assertTrue(isvisibleProduct);
	}
	
	@AfterMethod(alwaysRun=true,groups= {"smoke"})
	public void logOut() {
		driver.findElement(By.cssSelector("div.bm-burger-button")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("a#logout_sidebar_link")));
		driver.findElement(By.cssSelector("a#logout_sidebar_link")).click();
		driver.close();
	}
	
	
}
