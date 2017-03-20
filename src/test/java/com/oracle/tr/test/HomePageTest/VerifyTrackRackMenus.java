package com.oracle.tr.test.HomePageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTrackRackMenus {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.tirerack.com/content/tirerack/desktop/en/homepage.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int menus = driver.findElements(By.xpath("//*[@id='pageLinks']/ul/li")).size();
		if(menus == 6){
			System.out.println("Test is pass");
		}
		else{
			System.out.println("Test is fail");
		}
		

	}

}
