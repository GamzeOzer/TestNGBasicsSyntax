package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class taskTwo extends CommonMethods {
	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browser, String url) {
		setUpDriver(browser, url);
	}

	@Parameters({ "userName", "password" })
	@Test(groups = "Smoke")
	public void UsernameOne(String userName, String password) {
		sendText(driver.findElement(By.cssSelector("input#user-name")), userName);
		sendText(driver.findElement(By.cssSelector("input#password")), password);
		driver.findElement(By.cssSelector("input.btn_action")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='product_label']")).getText(), "Products");
	}

	@Parameters({ "userName2", "password2" })
	@Test(groups = "Regression")
	public void UsernameTwo(String userName, String password) {
		sendText(driver.findElement(By.cssSelector("input#user-name")), userName);
		sendText(driver.findElement(By.cssSelector("input#password")), password);
		driver.findElement(By.cssSelector("input.btn_action")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='product_label']")).getText(), "Products");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}