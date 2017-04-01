package com.oracle.tr.pageActions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.oracle.tr.testBase.TestBase;

public class ShoppingCartPage extends TestBase{
	
	public void delectCartItems() throws InterruptedException{
		int i = 1;
		List<WebElement> items = driver.findElements(By.xpath("//a[contains(text(),'Cancel')]"));
		Iterator<WebElement> itr = items.iterator();
		while(itr.hasNext()){
			 itr.next().click();
	         Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
			log.info("we have deleted items:-"+i++);
		}
	}
	
	public void verifyNoItemsInBasketMessage(){
		expliciteWait(driver.findElement(By.xpath("//p[contains(text(),'You currently have no items in your cart.')]")), 60);
		String text = driver.findElement(By.xpath("//p[contains(text(),'You currently have no items in your cart.')]")).getText();
		log.info("You currently have no items in your cart verified");
		Assert.assertEquals(text, "You currently have no items in your cart.");
	}

}
