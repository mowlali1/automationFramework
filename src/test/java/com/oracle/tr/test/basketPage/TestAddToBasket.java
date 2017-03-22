package com.oracle.tr.test.basketPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.testBase.TestBase;


public class TestAddToBasket extends TestBase{
	//http://bhanupratapcorejavaprogramming.blogspot.in/
		public static Logger log = Logger.getLogger(TestAddToBasket.class.getName());

		@BeforeClass
		public void setUp() throws IOException{
	      init();
		}
		
		@Test
		public void testLoginToautomationpractice() throws InterruptedException{
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[1]/button")).click();
			// select audi
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[1]/div/ul[1]/li[1]/span")).click();
			Thread.sleep(1000);
			// click on select year
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[2]/button")).click();
			// select 2017
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[2]/button")).click();
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[2]/div/ul[1]/li[1]/span")).click();
			// click on select model
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[3]/button")).click();
			// select IXL
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[3]/button")).click();
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[3]/div/ul[1]/li[1]/span")).click();
			// enter zip code
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[4]/input")).sendKeys("99501");
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[7]/div/div/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[7]/div/div/div/ul[1]/li[1]/span")).click();
			// click on view results
			driver.findElement(By.xpath(".//*[@id='shopVehicleSearchBtn']")).click();
			// click on Original Equipment Wheel Diameter: 17
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(text(),'Original Equipment Wheel Diameter: 17')]/parent::*/child::div/a/sbold")).click();
			// click on quantity drop down
			driver.findElement(By.xpath(".//*[@id='tireForm0']/div[3]/div[2]/div[2]/div[2]/ul/li[2]/div[1]/div/button")).click();
			// select one quantity
			driver.findElement(By.xpath("//*[contains(text(),'1')]")).click();
			//click on add to cart
			driver.findElement(By.xpath(".//*[@id='tireForm0']/div[3]/div[3]/button")).click();
			// click on keep in cart
			driver.findElement(By.xpath("html/body/div[8]/div/div[1]/div/form/div[8]/button")).click();
			
			String text = driver.findElement(By.xpath("//*[contains(text(),'Acura')]")).getText();
			if(text.contains("Acura")){
				Assert.assertTrue("Add to cart test is pass",true);
			}
			else{
				Assert.assertTrue("Add to cart test is pass",false);	
			}
			

		}
		
		@AfterClass
		public void closeBrowser(){
			//driver.quit();
		}
}
