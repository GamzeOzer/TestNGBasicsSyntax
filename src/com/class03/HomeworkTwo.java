package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class HomeworkTwo extends CommonMethods{
//	TC 2: OrangeHRM Add Employee
//	Step 1: Click on PIM link and Add Employee
//	Step 2: Provide Details and Save
//	Step 3: Verify Employee is added 
	
	@BeforeClass
	public void setUpAndSetHomePage() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
	}
	
	@Test
	public void PimAndAddEmployee() {
		driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
	}
	
	@Test
	public void provideDetails() {
		sendText(driver.findElement(By.cssSelector("input#firstName")), "gamze");
		sendText(driver.findElement(By.cssSelector("input#lastName")), "ozer");
		//sendText(driver.findElement(By.cssSelector("input#employeeId")), "246");
		driver.findElement(By.cssSelector("input#chkLogin")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement element=driver.findElement(By.cssSelector("input#user_name"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys("gamzeozer");
		sendText(driver.findElement(By.cssSelector("input#user_password")), "123456789");
		sendText(driver.findElement(By.cssSelector("input#re_password")), "123456789");
		WebElement elementSelect=driver.findElement(By.cssSelector("select#status"));
		selectValueFromDD(elementSelect, "Disabled");
		driver.findElement(By.cssSelector("input#btnSave")).click();
		
	}
	
	@Test
	public void verifyEmployee() {
		boolean isDisplayedPersonalDetails=driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();
		Assert.assertTrue(isDisplayedPersonalDetails, "Employee has not been added");
	}
	
	@AfterClass
	public void LogOut() {
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
	}
}
