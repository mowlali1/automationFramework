package com.oracle.tr.test.HomePageTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.HomePage;
import com.oracle.tr.testBase.TestBase;

public class VerifyWhyTireRackLinks extends TestBase{
	
	public static Logger log = Logger.getLogger(VerifyWhyTireRackLinks.class.getName());
	HomePage homepage;
	
	@BeforeClass
	public void setUp() throws IOException{
      init();
      homepage = new HomePage(driver);
      
	}
	
	@Test
	public void verifyLinksOfWhyTireRack(){
     try {
    	 log.info("****verifyLinksOfWhyTireRack started***");
		int actualLink = homepage.getAllLinksOfWhyTireRack();
		 Assert.assertEquals(6, actualLink);
		 log.info("****verifyLinksOfWhyTireRack finished***");
	} catch (AssertionError e) {
		log.error("verifyLinksOfWhyTireRack", e.fillInStackTrace());
		Assert.assertTrue(false);
	}
     catch (Exception e) {
 		log.error("verifyLinksOfWhyTireRack", e.fillInStackTrace());
 		Assert.assertTrue(false);
 	}
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
}
