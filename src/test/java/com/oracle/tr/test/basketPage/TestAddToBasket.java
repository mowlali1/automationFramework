package com.oracle.tr.test.basketPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.pageActions.TirerackShoppingCartPage;
import com.oracle.tr.testBase.TestBase;

public class TestAddToBasket extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testBasket() throws InterruptedException {
		TirerackShoppingCartPage obj = new TirerackShoppingCartPage();
		obj.addItemsToCart("Acura","2017");
	}
}
