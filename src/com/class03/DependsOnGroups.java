package com.class03;

import org.testng.annotations.Test;

public class DependsOnGroups {
	
	@Test(groups ="Smoke1")
	public void one() {
		System.out.println("one test ");
	}
	
	@Test(groups ="Smoke2",dependsOnGroups ="Smoke1")
	public void two() {
		System.out.println("two test ");
	}
	
	@Test(groups ="Smoke3",dependsOnGroups ="Smoke2")
	public void three() {
		System.out.println("three test ");
	}

}
