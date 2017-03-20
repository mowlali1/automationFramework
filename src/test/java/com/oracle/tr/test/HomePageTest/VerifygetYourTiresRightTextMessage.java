package com.oracle.tr.test.HomePageTest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.HomePage;
import com.oracle.tr.testBase.TestBase;

public class VerifygetYourTiresRightTextMessage extends TestBase{
	public static Logger log = Logger.getLogger(VerifygetYourTiresRightTextMessage.class.getName());
	HomePage homepage;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
		homepage = new HomePage(driver);
	}
	
	@Test
	public void testLoginToautomationpractice(){
		ArrayList<String> array = new ArrayList<String>();
		array.add("Just tell us what you drive. We’ll show you exactly what fits.");
		array.add("Then, our test results and consumer ratings and reviews will help you pinpoint the tires that are right for you and the roads you drive on every day.");
		array.add("FIND. DELIVER. INSTALL. SMARTER.®");
		log.info("expected data");
		log.info(array);
		log.info("***VerifyHomePageMessage started***");
		try {
			Object actual = homepage.getYourTiresRightText();
			Assert.assertEquals(actual, array);
			log.info("***VerifyHomePageMessage finished***");
		} catch (AssertionError e) {
			log.error("VerifyHomePageMessage", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.error("VerifyHomePageMessage", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
}
