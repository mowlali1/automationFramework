package com.oracle.tr.test.module1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.LoginPage;
import com.oracle.tr.test.registor.RegistrationTest;
import com.oracle.tr.testBase.TestBase;

public class LoginToautomationPractice extends TestBase{
	LoginPage login;
	public static Logger log = Logger.getLogger(LoginToautomationPractice.class.getName());

	@BeforeClass
	public void setUp() throws IOException{
      init();
      login = new LoginPage(driver);
      
	}
	
	@Test
	public void testLoginToautomationpractice(){
		log.info("----starting testLoginToautomationpractice test-----");
		login.loginToApplication("testEmail", "password");
		String text = login.getInvalidLoginText();
		Assert.assertEquals("Invalid email address.", text);
		log.info("----Finished testLoginToautomationpractice test-----");
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}

}
