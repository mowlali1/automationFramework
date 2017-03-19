package com.oracle.tr.test.registor;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.LoginPage;
import com.oracle.tr.pageActions.Registration;
import com.oracle.tr.testBase.TestBase;

public class RegistrationTest extends TestBase{
	public static Logger log = Logger.getLogger(RegistrationTest.class.getName());
	Registration reg;
	LoginPage login;
	int i = 0;
	
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
     reg = new Registration(driver);
     login = new LoginPage(driver);
	}
	
	@DataProvider(name = "TestRegistor")
	public Object[][] provideData() {
		Object[][] testdata = getData("Login.xlsx", "Registor");
		return testdata;
	}

	
	@Test(priority = 0, enabled = true, description = "Test Registration with valid data", dataProvider = "TestRegistor")
	public void testRegistration(String passowrd, String selectDay, String selectMonth, String selectYear,
			String customerfirstName, String customerLastName, String firstName, String lastName, String address,
			String verify, String runmode) throws InterruptedException, IOException {
		String emailAddress = "email" + System.currentTimeMillis() + "@gmail.com";
		
		if (runmode.equalsIgnoreCase("n")) {
			throw new SkipException("user has marred run mode n for this record");
		}

		if(i!=0){
			reg.clickOnLogout();
		}
		
		i++;
		BigDecimal bigdecimal = new BigDecimal(selectDay);
		BigDecimal bigdecimal1 = new BigDecimal(selectYear);

		String sDay = String.valueOf(bigdecimal.longValue());
		System.out.println(sDay);
		String year = String.valueOf(bigdecimal1.longValue());
        login.clickOnsignIn();
		String message = reg.register(emailAddress, passowrd, sDay, selectMonth, year, customerfirstName,
				customerLastName, firstName, lastName, address);
		
		
	}
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}

}
