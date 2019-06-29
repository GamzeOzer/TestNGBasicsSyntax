package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskOneOrange extends CommonMethods{
	//TC 1: OrangeHRM Title Validation
	//
	//TC 2: OrangeHRM Successful Login 
	//https://opensource-demo.orangehrmlive.com/
	//Please make sure to use the following:
	// annotations:
    //		@BeforeMethod
    //		@AfterMethod
    //		@Test
	//
	//What would you do if you do not want to execute any specific test case?
	//What would you do if you want to execute any specific test case first?


	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=0)
	public void verifyTitle() {
		boolean titleIsDisplayed=driver.findElement(By.xpath("//title[text()='OrangeHRM']")).isDisplayed();
		if(titleIsDisplayed==true) {
			System.out.println("page title is rigth");
		}else {
			System.out.println("page title is wrong");
		}
	}
	
	@Test(priority=1)
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}

