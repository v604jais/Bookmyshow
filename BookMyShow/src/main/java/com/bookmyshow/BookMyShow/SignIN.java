package com.bookmyshow.BookMyShow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SignIN extends Launch{

	
	
	WebDriver driver;
	
	By placeName=By.xpath("//input[@id='inp_RegionSearch_top']");
    By signIn=By.xpath("//a[@id='preSignIn']");
 
	public  SignIN(WebDriver driver)
	{
	 this.driver=driver;
	}
	
	@Test(priority=2)
	public void typePlace()
	{
	 WebElement CitySearchBox=driver.findElement(placeName);
	 CitySearchBox.sendKeys(p.getProperty("City"));
	 CitySearchBox.sendKeys(Keys.ENTER);
	 
	}
	@Test(priority=3)
	public void hitOnSignIn()
	{
	driver.findElement(signIn).click();
	}
	
//	public void typeUserName()
//	{
//	driver.findElement(placeName).sendKeys(p.getProperty("City"));
//	}
	
	
	
}
