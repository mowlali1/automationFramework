package com.oracle.tr.pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.oracle.tr.testBase.TestBase;

public class SelectTireSizePage extends TestBase{
	public static Logger log = Logger.getLogger(SelectTireSizePage.class.getName());
	public void clickOnOriginalEquipmentWheelDiameter_17(){
		driver.findElement(By.xpath(".//*[@id='oe1']/button")).click();
		log.info("click on Original Equipment Wheel Diameter: 17");
}

}