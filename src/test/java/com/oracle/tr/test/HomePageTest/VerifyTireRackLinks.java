package com.oracle.tr.test.HomePageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTireRackLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.tirerack.com/content/tirerack/desktop/en/homepage.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='header']/div/div[1]/div/div[2]/ul/div/li[1]/a")).click();
		int links = driver.findElements(By.xpath("//*[@id='footer']/section/nav/ul/li[1]/ul/li")).size();
		System.out.println(links);
		if(links == 6){
			System.out.println("Test is pass");
		}
		else{
			System.out.println("Test is fail");
		}

	}

}
