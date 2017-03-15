package com.oracle.tr.test.registor;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.LoginPage;
import com.oracle.tr.pageActions.Registration;
import com.oracle.tr.testBase.TestBase;

public class RegistrationTest extends TestBase{
	
	Registration registor;
	
	String emailAddress = "email" + System.currentTimeMillis() + "@gmail.com";
	String userName = "automationTest";
	String passowrd = "password";
	String selectDay = "12";
	String selectMonth = "January";
	String selectYear = "2017";
	String firstName = "firstName";
	String lastName = "lastName";
	String address = "address";
	String customerfirstName="customerfirstName";
	String customerLastName = "customerLastName";

	@BeforeClass
	public void setUp() throws IOException{
      init();
     registor = new Registration(driver);
	}
	
	@Test
	public void testLoginToautomationpractice() throws InterruptedException{
		registor.register(emailAddress, passowrd, selectDay, selectMonth, selectYear, customerfirstName, customerLastName, firstName, lastName, address);
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}

}
