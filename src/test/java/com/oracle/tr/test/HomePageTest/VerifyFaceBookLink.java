package com.oracle.tr.test.HomePageTest;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.testBase.TestBase;

public class VerifyFaceBookLink extends TestBase {
	public static Logger log = Logger.getLogger(VerifyNavigationMenu.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test
	public void verifyFaceBookLink() throws InterruptedException {
		try {
			log.info("****verifyFaceBookLink started****");
			driver.findElement(By.xpath(".//*[@id='footer']/div[2]/section/div/div[1]/div[1]/ul/li[1]/a")).click();
			Set<String> window = driver.getWindowHandles();
			String parentWindow = window.iterator().next();
			String childWindow = window.iterator().next();
			System.out.println(window);
			System.out.println(window.size());
			driver.switchTo().window(childWindow);
			String text = driver.getCurrentUrl();
			Thread.sleep(3000);
			driver.switchTo().window(childWindow).close();
			driver.switchTo().window(parentWindow);
			Assert.assertEquals(text, "https://www.facebook.com/tirerack");
			log.info("****verifyFaceBookLink finished****");
		}

		catch (AssertionError e) {
			log.error("VerifyHomePageMessage", e.fillInStackTrace());
			Assert.assertTrue(false);
		} catch (Exception e) {
			log.error("VerifyHomePageMessage", e.fillInStackTrace());
			Assert.assertTrue(false);
		}

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
