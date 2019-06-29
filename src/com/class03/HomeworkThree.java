package com.class03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class HomeworkThree extends CommonMethods {
//TC 3: OrangeHRM Verify Employee Details
//	Step 1: Click on PIM link and Employee List
//	Step 2: Search for employee by it id
//	Step 3: Verify Employee details are displayed 
//
//Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application

	@BeforeClass
	public void setUpAndSetHomePage() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
	}

	@Test
	public void clickPIMEmployeeList() {
		driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	}

	@Test
	public void searchEmployee() {
		List<WebElement> tableRow = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i = 1; i < tableRow.size(); i++) {
			String textRow = driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr[" + i + "]"))
					.getText();
			if (textRow.contains("0043")) {
				String nameText = driver
						.findElement(By.xpath("//table[@class='table hover']/tbody/tr[" + i + "]/td[3]")).getText();
				System.out.println(nameText);
			}
		}
	}

	@Test
	public void verifyEmployee() {
		List<WebElement> tableRow = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i = 1; i < tableRow.size(); i++) {
			String expectedText = "0043 gamze ozer";
			String textRow = driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr[" + i + "]"))
					.getText();
			if (textRow.contains("gamze")) {
				Assert.assertEquals(textRow, expectedText);
			}
		}

	}
	
	@AfterClass
	public void LogOut() {
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
	}

}
