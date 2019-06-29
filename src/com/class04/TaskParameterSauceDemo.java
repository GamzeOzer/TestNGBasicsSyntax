package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;
	
//Identify Priority of Test Cases
//
//https://www.saucedemo.com/
//
//TC 1: Saucedemo Username1(parameters - username and password)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username standard_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//TC 2: Saucedemo Username2(parameters - username and password)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username problem_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//
//Note: Create BeforeMethod and AfterMethod annotations to 
//open browser and logout from the application.
//Create a xml file with parameters username and password .

public class TaskParameterSauceDemo extends CommonMethods{

	@Parameters({"browser","url"})
	@BeforeMethod(alwaysRun=true, groups= {"smoke"})
	public void setUp(String browser,String url) {
		setUpDriver(browser, url);
	}
	
	@Parameters({"standartUserName","password"})
	@Test(groups= {"smoke"})
	public void standartUserLogin(String username,String password) {
		sendText(driver.findElement(By.cssSelector("input#user-name")), username);
		sendText(driver.findElement(By.cssSelector("input#password")), password);
		driver.findElement(By.cssSelector("input.btn_action")).click();
		boolean isvisibleProduct=driver.findElement(By.cssSelector("div.product_label")).isDisplayed();
		Assert.assertTrue(isvisibleProduct);
	}
	@Parameters({"problemUserName","password"})
	@Test(groups= {"regression"})
	public void problemUserLogin(String username,String password) {
		sendText(driver.findElement(By.cssSelector("input#user-name")), username);
		sendText(driver.findElement(By.cssSelector("input#password")), password);
		driver.findElement(By.cssSelector("input.btn_action")).click();
		boolean isvisibleProduct=driver.findElement(By.cssSelector("div.product_label")).isDisplayed();
		Assert.assertTrue(isvisibleProduct);
	}
	
	@AfterMethod(alwaysRun=true,groups= {"smoke"})
	public void logOut() {
//		driver.findElement(By.cssSelector("div.bm-burger-button")).click();
//		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("a#logout_sidebar_link")));
//		driver.findElement(By.cssSelector("a#logout_sidebar_link")).click();
		driver.close();
	}
	
	
}
