package com.bookmyshow.BookMyShow;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Launch extends Report {
    
	

	
	@Test (priority=1)
	public static void launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\Bookmyshow\\BookMyShow\\Drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(p.getProperty("URL"));//"https://in.bookmyshow.com"
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			String Title=driver.getTitle();
			Assert.assertEquals(Title, "Movie Tickets, Plays, Sports, Events & Cinemas nearby - BookMyShow");
			
			// continuation
			SignIN s=new SignIN(driver);
			s.typePlace();
			s.hitOnSignIn();
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}

}
