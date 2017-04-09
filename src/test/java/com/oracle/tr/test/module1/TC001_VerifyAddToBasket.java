package com.oracle.tr.test.module1;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.AutomationPracticeHomePage;
import com.oracle.tr.pageActions.AutomationPracticeProductDetails;
import com.oracle.tr.testBase.TestBase;


public class TC001_VerifyAddToBasket extends TestBase{
	AutomationPracticeHomePage homePage;
	AutomationPracticeProductDetails productDetails;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void verifyAddToBasket() throws InterruptedException{
		homePage = new AutomationPracticeHomePage(driver);
		productDetails = new AutomationPracticeProductDetails();
		
		try {
			homePage.mouseOver(homePage.women);
			homePage.clickOnProduct("T-shirts");
			productDetails.selectProduct("Faded Short Sleeve T-shirts");
			productDetails.clickOnProceedTocheckout();
		} 
		
		catch (AssertionError e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void endTest(){
		//driver.close();
	}
}
