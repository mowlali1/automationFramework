package com.oracle.tr.test.HomePageTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.testBase.TestBase;

public class VerifyTotalLinksOfHomePage extends TestBase{

	public static Logger log = Logger.getLogger(VerifyTotalLinksOfHomePage.class.getName());

	@BeforeClass
	public void setUp() throws IOException{
      init();

      
	}
	
	@Test(enabled=true , description="Test")
	public void testVerifyTotalLinksOfHomePage(){
      try {
    	  log.info("--testLoginToautomationpractice started");
		int size = driver.findElements(By.xpath("//a")).size();
		  Assert.assertEquals(size, 199);
		  log.info("--testLoginToautomationpractice finished");
	} catch (AssertionError e) {
		log.error("testLoginToautomationpractice", e.fillInStackTrace());
        Assert.assertTrue(false);
	}

	}
	@Test(enabled=false)
	public void verifyHomePageMessage(){
		log.info("--VerifyHomePageMessage started--");
		try {
			ArrayList<String> array = new ArrayList<String>();
			array.add("Just tell us what you drive. We’ll show you exactly what fits.");
			array.add("Then, our test results and consumer ratings and reviews will help you pinpoint the tires that are right for you and the roads you drive on every day.");
			array.add("FIND. DELIVER. INSTALL. SMARTER.");
			
			ArrayList<String> obj = new ArrayList<String>();
			List<WebElement> object = driver.findElements(By.xpath("//*[@id='content-tirerack-desktop-en-homepage-main-content-start_1']/div[2]/section/div/div[2]/div/div/span/p"));
			Iterator<WebElement> itr = object.iterator();
			while(itr.hasNext()){
				obj.add(itr.next().getText());
			}
			System.out.println(array);
			System.out.println(obj);
			log.info("--VerifyHomePageMessage finished--");
		} catch (AssertionError e) {
           log.error("VerifyHomePageMessage", e.fillInStackTrace());
           Assert.assertTrue(false);
		}
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
}
