package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class PriorityExampleTwo extends CommonMethods{

	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		boolean swagLabs = driver.findElement(By.xpath("//title[text()='Swag Labs']")).isDisplayed();
		if(swagLabs=true) {
			System.out.println("this is the right title");
		}
		else {
			System.out.println("this is the wrong title");	
		}
	}
	
	@Test()
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	
	@Test(priority =1)
	public void mainPage() throws InterruptedException {
		String actual =driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		String expected ="Products";
		if(expected.equals(actual)) {
			System.out.println("expected matches actual text");
		}
		else {
			System.out.println("expected does not matche actual text");
		}
		Thread.sleep(2000);
	}
	
	
	@AfterClass
	public void closePage() throws InterruptedException {
		driver.close();
	}
	
}