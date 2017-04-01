package com.oracle.tr.pageActions;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.oracle.tr.testBase.TestBase;

public class HomePage extends TestBase{
	public static Logger log = Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath="//*[@id='pageLinks']/ul/li[1]/div/div/a")
	WebElement tires;
	
	@FindBy(xpath="//*[@id='pageLinks']/ul/li[2]/div/div/a")
	WebElement wheels;
	
	@FindBy(xpath="//*[@id='pageLinks']/ul/li[3]/div/div/a")
	WebElement partsAndAccessories;
	
	@FindBy(xpath="//*[@id='pageLinks']/ul/li[4]/div/div/a")
	WebElement researchAndAdvice;
	
	@FindBy(xpath="//*[@id='pageLinks']/ul/li")
	List<WebElement> navigationOptions;
	
	@FindBy(xpath="//a")
	List<WebElement> homePageLinks;
	
	@FindBy(xpath="//*[@id='content-tirerack-desktop-en-homepage-main-content-start_1']/div[2]/section/div/div[2]/div/div/span/p")
	List<WebElement> getYourTiresRightText;
	
	@FindBy(xpath="//*[@id='footer']/section/nav/ul/li[1]/ul/li")
	List<WebElement> whyTireRack;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void mouseOverTires() throws InterruptedException{
		Actions action = new Actions(driver);
		log.info("performning mouse over on tires");
		action.moveToElement(tires).build().perform();
		Thread.sleep(1000);
		
	}
	public void mouseOverWheels() throws InterruptedException{
		Actions action = new Actions(driver);
		log.info("performning mouse over on wheels");
		action.moveToElement(wheels).build().perform();
		Thread.sleep(1000);
		
	}
	public void mouseOverPartsAndAccessories() throws InterruptedException{
		Actions action = new Actions(driver);
		log.info("performning mouse over on parts And Accessories");
		action.moveToElement(partsAndAccessories).build().perform();
		Thread.sleep(1000);
		
	}
	public void mouseOverResearchAndAdvice() throws InterruptedException{
		Actions action = new Actions(driver);
		log.info("performning mouse over on research And Advice");
		action.moveToElement(researchAndAdvice).build().perform();
		Thread.sleep(1000);
		
	}
	
	public int countAllNavigationMenu(){
		log.info("counting all navigation menu options");
		return navigationOptions.size();
	}
	
	public int countAllLinksOfPage(){
		log.info("counting all links in home  page");
		return homePageLinks.size();
	}
	
	public ArrayList<String> getYourTiresRightText(){
		log.info("getting Your Tires Right Text");
		ArrayList<String> obj = new ArrayList<String>();
		Iterator<WebElement> itr = getYourTiresRightText.iterator();
		while(itr.hasNext()){
			obj.add(itr.next().getText());
		}
		log.info("actul data");
		log.info(obj);
		return obj;
	}
	
	public int getAllLinksOfWhyTireRack(){
		log.info("getting all links of WHY TIRE RACK?");
		return whyTireRack.size();
	}
	

	
	public void clickOnMakeDropDown() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[1]/button")).click();
		log.info("clicked on make dropdwon");
		Thread.sleep(2000);
	}
	public void selectMake(String make) throws InterruptedException{
		List<WebElement> makeitems = driver.findElements(By.xpath(".//*[@id='shopByVehicle-search-change']/div[1]/div[1]/div/ul[1]/li"));
		Iterator<WebElement> itr = makeitems.iterator();
		while(itr.hasNext()){
			WebElement text = itr.next();
			if(text.getText().equals(make)){
				log.info("selecting make as:-"+make);
				text.click();
				Thread.sleep(2000);
				break;
			}
		}
		
	}
	public void selectYear(String yearData) throws InterruptedException{
		List<WebElement> year = driver.findElements(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[2]/div/ul/li"));
		Iterator<WebElement> itr = year.iterator();
		while(itr.hasNext()){
			WebElement y = itr.next();
			if(y.getText().equals(yearData)){
				y.click();
				log.info("year is selected:-"+yearData);
				Thread.sleep(2000);
				break;
			}
		}
		
	}
	
	public void selectModel(String model) throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[1]/div[3]/button")).click();
		List<WebElement> m = driver.findElements(By.xpath("//*[@class='greyHover']"));
		Iterator<WebElement> itr = m.iterator();
		while(itr.hasNext()){
			WebElement y = itr.next();
			if(y.getText().equalsIgnoreCase(model)){
				System.out.println(y.getText());
				y.click();
				log.info("model is selected:-"+model);
				Thread.sleep(2000);
				break;
			}	
		}
	}
	
	public void selectPin(String pin) throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='shopByVehicle-search-change']/div[4]/input")).sendKeys(pin);
		log.info("pin is selected:-"+pin);
		Thread.sleep(2000);
	}
	
	public void selectIamshoppingFor(String items) throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='shopByVehicle-search-change']/div[7]/div/div/button")).click();
		log.info("clicked on I am shopping for drop down");
		Thread.sleep(2000);
		List<WebElement> it = driver.findElements(By.xpath(".//*[@id='shopByVehicle-search-change']/div[7]/div/div/div/ul[1]/li"));
		Iterator<WebElement> itr = it.iterator();
		while(itr.hasNext()){
			WebElement ite = itr.next();
			if(ite.getText().equals(items)){
				ite.click();
				log.info("items is selected:-"+items);
				Thread.sleep(2000);
				break;
			}
		}
	}
	public void clickOnViewResult() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='shopVehicleSearchBtn']")).click();
		log.info("clicked on view result");
		Thread.sleep(2000);
	}
	
}
