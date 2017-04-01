package com.oracle.tr.pageActions;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oracle.tr.testBase.TestBase;

public class TireSearchResultsPage extends TestBase{
	
	public static Logger log = Logger.getLogger(TireSearchResultsPage.class.getName());
	
	public void selectQuantity(String quantity) throws InterruptedException{
		expliciteWait(driver.findElement(By.xpath("//*[@id='tireForm0']/div[3]/div[2]/div[2]/div[2]/ul/li[2]/div[1]/div/button")), 60);
        driver.findElement(By.xpath("//*[@id='tireForm0']/div[3]/div[2]/div[2]/div[2]/ul/li[2]/div[1]/div/button")).click();
    	driver.findElements(By.xpath("//select[@id='i1_Qty0']/option")).get(2).click();
        log.info("clicked on quantity drop down");
		List<WebElement> qun = driver.findElements(By.xpath("//select[@id='i1_Qty0']/option"));
		System.out.println("qun.size()---"+qun.size());
		/*
		Iterator<WebElement> itr = qun.iterator();
		while(itr.hasNext()){
			WebElement select = itr.next();
			if(select.equals(quantity)){
				System.out.println(select.getText());
				select.click();
				log.info("quantity has been selected");
				Thread.sleep(2000);
				break;
			
			}
		}
		*/
	}
	
	public void clickOnAddToCart() throws InterruptedException{
		Thread.sleep(2000);
		Actions action = new Actions(driver).click(driver.findElement(By.xpath("//*[@id='tireForm0']/div[3]/div[3]/button")));
		action.build().perform();
		log.info("clicked on add to cart");
		Thread.sleep(1000);
	}
	
	public void clickOnKeepInCart() throws InterruptedException{
		expliciteWait(driver.findElement(By.xpath("//button[contains(text(),'Keep in Cart')]")), 60);
		driver.findElement(By.xpath("//button[contains(text(),'Keep in Cart')]")).click();
		Thread.sleep(3000);
		log.info("clicked on keep in cart");
	}

}
