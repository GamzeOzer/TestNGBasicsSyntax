package com.class03;

//import org.testng.annotations.AfterGroups;
//import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsExample {

	
	@Test(groups ="Smoke")
	public void one() {
		System.out.println("testOne");
	}

	@Test(groups ="Regression")
	public void Two() {
		System.out.println("testTwo");
	}

	@Test(groups ="Smoke")
	public void Three() {
		System.out.println("testThree");
	}

	@Test(groups ="Regression")
	public void Four() {
		System.out.println("testFour");
	}
	
	

}