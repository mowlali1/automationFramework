package com.oracle.tr.test.buyProduct;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oracle.tr.testBase.TestBase;


public class AutomationPracticeTestBuyProduct extends TestBase{
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test
	public void verifyBuyProduct(){
		driver.findElement(By.xpath(".//*[@id='header_logo']/a/img")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img"))).build().perform();
		
		driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='center_column']/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("testselenium2@gmail.com");
		driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("automation@123");
		driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
		driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button")).click();
		driver.findElement(By.xpath(".//*[@id='cgv']")).click();
		driver.findElement(By.xpath(".//*[@id='form']/p/button")).click();
		driver.findElement(By.xpath(".//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")).click();
		driver.findElement(By.xpath(".//*[@id='cart_navigation']/button")).click();
		String text = driver.findElement(By.xpath(".//*[@id='center_column']/p[1]")).getText();
		Assert.assertEquals(text, "Your order on My Store is complete.");
	}

}
