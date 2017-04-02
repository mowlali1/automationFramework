package com.oracle.tr.pageActions;

import org.openqa.selenium.By;

import com.oracle.tr.testBase.TestBase;

public class TirerackTires extends TestBase{
	
	public void navigateByVehicle(){
		driver.findElement(By.xpath("//*[@id='pageLinks']/ul/li[1]/div/div/div/ul/li[1]/ul[1]/li[2]/a")).click();
	}

}
