package com.oracle.tr.test.module1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.oracle.tr.pageActions.AutomationPracticeLoginPage;
import com.oracle.tr.testBase.TestBase;

public class LoginToautomationPractice extends TestBase{
	AutomationPracticeLoginPage login;
	public static Logger log = Logger.getLogger(LoginToautomationPractice.class.getName());

	@BeforeClass
	public void setUp() throws IOException{
      init();
      login = new AutomationPracticeLoginPage(driver);
      
	}
	
	@Test
	public void testLoginToautomationpractice(){
		try {
			log.info("****starting testLoginToautomationpractice test****");
			login.loginToApplication("testEmail", "password");
			String text = login.getInvalidLoginText();
			Assert.assertEquals("Invalid email address.", text);
			log.info("****Finished testLoginToautomationpractice test****");
		} 
		catch(AssertionError e){
			log.error("testLoginToautomationpractice", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.error("testLoginToautomationpractice", e.fillInStackTrace());
			Assert.assertTrue(false);
		}
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}

}
