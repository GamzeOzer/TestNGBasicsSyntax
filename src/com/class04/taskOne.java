package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class taskOne  extends CommonMethods{
	
	@BeforeMethod(alwaysRun =true ,groups="Smoke")
	public void setUp() {
	    String url="https://www.saucedemo.com/";
	    CommonMethods.setUpDriver("chrome", url);
	    }
	
	@Test(groups ="Smoke")
	public void UserName1() {
	    
	  sendText(driver.findElement(By.id("user-name")), "standard_user");
	  sendText(driver.findElement(By.id("password")), "secret_sauce");
	  driver.findElement(By.className("btn_action")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	}
	@Test(groups ="Regression")
	public void UserName2() {
	    
	       sendText(driver.findElement(By.id("user-name")), "problem_user");
	       sendText(driver.findElement(By.id("password")), "secret_sauce");
	       driver.findElement(By.className("btn_action")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	    }
	@AfterMethod(alwaysRun = true , groups ="Smoke")
	public void tearDown() {
	    driver.close();
	}
	

}
