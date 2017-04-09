package com.oracle.tr.test.module1;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.selenium.ui.pageActions.HomePage;
import com.test.selenium.ui.pageActions.ProductDetails;
import com.test.selenium.ui.testBase.TestBase;

public class TC001_VerifyAddToBasket extends TestBase{
	HomePage homePage;
	ProductDetails productDetails;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void verifyAddToBasket() throws InterruptedException{
		homePage = new HomePage(driver);
		productDetails = new ProductDetails();
		
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
