package com.oracle.tr.test.HomePageTest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.TirerackHomePage;
import com.oracle.tr.testBase.TestBase;

public class TirerackVerifyTotalLinksOfHomePage extends TestBase {
	TirerackHomePage homepage;
	public static Logger log = Logger.getLogger(TirerackVerifyTotalLinksOfHomePage.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		init();
		homepage = new TirerackHomePage(driver);
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
			Reporter.log(e.fillInStackTrace().toString());
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.error("verifyTotalLinksOfHomePage", e.fillInStackTrace());
			Reporter.log(e.fillInStackTrace().toString());
			Assert.assertTrue(false);
		}
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
