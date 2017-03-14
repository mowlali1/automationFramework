package com.oracle.tr.test.module1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginToautomationpractice {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLoginToautomationpractice(){
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector(".login")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("userName");
		driver.findElement(By.id("passwd")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
		String test = driver.findElement(By.xpath("//*[contains(text(),'Invalid email address.')]")).getText();
		Assert.assertEquals("Invalid12 email address.", test);
	}
	
	@AfterClass
	public void closeBrowser(){
		
	}

}
