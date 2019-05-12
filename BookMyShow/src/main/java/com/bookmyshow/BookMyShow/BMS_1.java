package com.bookmyshow.BookMyShow;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BMS_1 {

	@Parameters("email")
	@Test()
	public void emailPrint(String email){
		System.out.println(email);
	}
	
}
