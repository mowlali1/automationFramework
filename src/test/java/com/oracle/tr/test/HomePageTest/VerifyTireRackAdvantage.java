package com.oracle.tr.test.HomePageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTireRackAdvantage {
	static String Test = "We have over 2.4 million square feet of distribution center space across the country packed with inventory from 22 major tire and 61 wheel brands ready to deliver by the next day in most cases. Our prices are competitive and our expertise is unmatched.";
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.tirerack.com/content/tirerack/desktop/en/homepage.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// click on The Tire Rack Advantage
		driver.findElement(By.xpath("//*[@id='footer']/section/nav/ul/li[1]/ul/li[2]/a")).click();
		String text = driver.findElement(By.xpath("html/body/div[4]/div[3]/div/div[2]/p")).getText();
		System.out.println(text);
		if(text.equals(Test)){
			System.out.println("Test is pass");
		}
		
		
	}
	

}
