package com.class02;

import org.testng.annotations.Test;



public class EnableAndDisable {
	
	
	@Test(enabled = false)
	public void first() {
		System.out.println("first test annotation");
	}
	
	@Test (enabled =true,priority=1)
	public void second() {
		System.out.println("second test annotation");
	}
	
	@Test(enabled =false)
	public void third() {
		System.out.println("third test annotation");
	}
	
	@Test (enabled =true, priority= 2)
	public void forth() {
		System.out.println("forth test annotation");
	}


}