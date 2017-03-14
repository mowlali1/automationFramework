package com.oracle.tr.test.module1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginWithValidData {
	
	//http://automationpractice.com/index.php
	
	WebDriver driver;
	String email = "test"+System.currentTimeMillis()+"@gmail.com";
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLoginWithValidData() throws InterruptedException{
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println(email);
		driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
		driver.findElement(By.xpath("//*[@id='id_gender2']")).click();
		driver.findElement(By.xpath(".//*[@id='customer_firstname']")).sendKeys("firstName");
		driver.findElement(By.xpath(".//*[@id='customer_lastname']")).sendKeys("lastName");
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("password");
		driver.findElements(By.xpath(".//*[@id='days']/option")).get(5).click();
		driver.findElements(By.xpath("//*[@id='months']/option")).get(5).click();
		driver.findElements(By.xpath(".//*[@id='years']/option")).get(9).click();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("firstName");
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("lastName");
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("address1");
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//*[@id='id_state']")).click();
		driver.findElement(By.xpath("//*[@id='id_state']/option[3]")).click();
		driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("99501");
		driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("testAddress");
		driver.findElement(By.xpath("//*[@id='submitAccount']")).click();

		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]"))));
		
		String actualText = driver.findElement(By.xpath("//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")).getText();
		
		Assert.assertEquals(actualText, "Welcome12 to your account. Here you can manage all of your personal information and orders.");
		
	}
	
	@AfterClass
	public void endTest(){
		
	}
	
	

}
