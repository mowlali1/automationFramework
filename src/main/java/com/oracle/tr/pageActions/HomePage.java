package com.oracle.tr.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.oracle.tr.testBase.TestBase;

public class HomePage extends TestBase{
	
	
	public void mouseOverTires() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='pageLinks']/ul/li[1]/div/div/a"))).build().perform();
		Thread.sleep(1000);
		
	}
	public void mouseOverWheels() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='pageLinks']/ul/li[2]/div/div/a"))).build().perform();
		Thread.sleep(1000);
		
	}
	public void mouseOverPartsAndAccessories() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='pageLinks']/ul/li[3]/div/div/a"))).build().perform();
		Thread.sleep(1000);
		
	}
	public void mouseOverResearchAndAdvice() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='pageLinks']/ul/li[4]/div/div/a"))).build().perform();
		Thread.sleep(1000);
		
	}

}
