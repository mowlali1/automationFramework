package com.oracle.tr.test.basketPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.TirerackHomePage;
import com.oracle.tr.pageActions.TirerackSelectTireSizePage;
import com.oracle.tr.pageActions.TirerackShoppingCartPage;
import com.oracle.tr.pageActions.TirerackTireSearchResultsPage;
import com.oracle.tr.testBase.TestBase;

public class AddToBasket2 extends TestBase{
	TirerackHomePage homepage;
	TirerackSelectTireSizePage selectTireSize;
	TirerackTireSearchResultsPage testsearchResult;
	TirerackShoppingCartPage shoppingCartPage;
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homepage = new TirerackHomePage(driver);
		selectTireSize = new TirerackSelectTireSizePage();
		testsearchResult = new TirerackTireSearchResultsPage();
		shoppingCartPage = new TirerackShoppingCartPage();
	}
	
	@Test
	public void testBasket() throws InterruptedException{
		homepage.clickOnMakeDropDown();
		homepage.selectMake("Acura");
		homepage.selectYear("2017");
		homepage.selectModel("ILX");
		homepage.selectPin("99501");
		homepage.selectIamshoppingFor("Tires");
		homepage.clickOnViewResult();
		selectTireSize.clickOnOriginalEquipmentWheelDiameter_17();
		testsearchResult.selectQuantity("2");
		testsearchResult.clickOnAddToCart();
		testsearchResult.clickOnKeepInCart();
		shoppingCartPage.delectCartItems();
		shoppingCartPage.verifyNoItemsInBasketMessage();
	}
	
	@AfterClass
	public void afterTest(){
		driver.quit();
	}
	
}
