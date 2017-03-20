package com.oracle.tr.test.HomePageTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.HomePage;
import com.oracle.tr.pageActions.LoginPage;

import com.oracle.tr.testBase.TestBase;

public class VerifyNavigationMenu extends TestBase {
	LoginPage login;
	public static Logger log = Logger.getLogger(VerifyNavigationMenu.class.getName());
	HomePage homepage;

	@BeforeClass
	public void setUp() throws IOException {
		init();
		homepage = new HomePage(driver);
	}

	@Test
	public void verifyNavigationMenuOptionsCount() {
		log.info("***verifyNavigationMenuOptionsCount started***");
		try {
			int count = homepage.countAllNavigationMenu();
			driver.get(OR.getProperty("url"));
			Assert.assertEquals(6, count);
			log.info("***verifyNavigationMenuOptionsCount finished***");
		} catch (AssertionError e) {
			log.error("verifyNavigationMenuOptionsCount", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.error("verifyNavigationMenuOptionsCount", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
