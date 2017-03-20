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

public class VerifyTotalLinksOfHomePage extends TestBase {
	HomePage homepage;
	public static Logger log = Logger.getLogger(VerifyTotalLinksOfHomePage.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		init();
		homepage = new HomePage(driver);
	}

	@Test(enabled = true, description = "TestVerifyTotalLinksOfHomePage")
	public void verifyTotalLinksOfHomePage() {
		try {
			log.info("****verifyTotalLinksOfHomePage started****");
			int size = homepage.countAllLinksOfPage();
			log.info("total link count is:-"+size);
			Assert.assertEquals(size, 202);
			log.info("***verifyTotalLinksOfHomePage finished***");
		} catch (AssertionError e) {
			log.error("verifyTotalLinksOfHomePage", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.error("verifyTotalLinksOfHomePage", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
