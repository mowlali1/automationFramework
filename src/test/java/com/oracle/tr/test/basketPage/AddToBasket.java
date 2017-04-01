package com.oracle.tr.test.basketPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.testBase.TestBase;

public class AddToBasket extends TestBase{
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test
	public void testBasket() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[1]/button")).click();
		log.info("clicked on vehicle modle drop down");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[1]/div/ul[1]/li[1]/span")).click();
		log.info("selected acura model");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[2]/button")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[2]/button")).click();
		driver.findElements(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[2]/div/ul[1]/li")).get(0).click();
		//driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[2]/div/ul[1]/li[1]/span")).click();
		log.info("2017 got selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[3]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[3]/div/ul[1]/li[1]/span")).click();
		log.info("IXL Model selected");
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[4]/input")).sendKeys("99501");
		driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[7]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[7]/div/div/div/ul[1]/li[1]/span")).click();
		log.info("Tires is selected");
		driver.findElement(By.xpath(".//*[@id='shopVehicleSearchBtn']")).click();
		log.info("clicked on View Results");
		driver.findElement(By.xpath(".//*[@id='oe1']/button")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='tireForm0']/div[3]/div[2]/div[2]/div[2]/ul/li[2]/div[1]/div/button"))));
		
		driver.findElement(By.xpath("//*[@id='tireForm0']/div[3]/div[2]/div[2]/div[2]/ul/li[2]/div[1]/div/button")).click();
		
		driver.findElements(By.xpath("//select[@id='i1_Qty0']/option")).get(2).click();
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//*[@id='tireForm0']/div[3]/div[3]/button")));
		action.build().perform();
		
		
		//driver.findElements(By.xpath("//*[contains(text(),'Add to Cart')]")).get(0).click();
		log.info("clicked on add to cart");
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Keep in Cart')]"))));
		
		driver.findElement(By.xpath("//button[contains(text(),'Keep in Cart')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
         Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(text(),'You currently have no items in your cart.')]"))));
		
		String text = driver.findElement(By.xpath("//p[contains(text(),'You currently have no items in your cart.')]")).getText();
		Assert.assertEquals(text, "You currently have no items in your cart.");
		
	}

}
