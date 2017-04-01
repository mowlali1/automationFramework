package com.oracle.tr.test.basketPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.HomePage;
import com.oracle.tr.testBase.TestBase;

public class AddToBasket2 extends TestBase{
	HomePage homepage;
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homepage = new HomePage(driver);

	}
	
	@Test
	public void testBasket() throws InterruptedException{
		
		homepage.clickOnMakeDropDown();
		homepage.selectMake("Acura");
		homepage.selectYear("2017");
		homepage.selectModel("ILX");
		homepage.selectPin("99501");
		homepage.selectIamshoppingFor("tire");
		homepage.clickOnViewResult();
		driver.findElement(By.xpath(".//*[@id='oe1']/button")).click();
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
	
	public void selectMake(String make){
		List<WebElement> makeitems = driver.findElements(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[1]/div/ul[1]/li"));
		Iterator<WebElement> itr = makeitems.iterator();
		while(itr.hasNext()){
			WebElement text = itr.next();
			if(text.getText().equals(make)){
				text.click();
				break;
			}
		}
		
		
	}

}
