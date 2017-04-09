package com.oracle.tr.pageActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.selenium.ui.testBase.TestBase;

public class AutomationPracticeRegistrationPage extends TestBase{
	
	public static Logger log = Logger.getLogger(AutomationPracticeRegistrationPage.class.getName());
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement craeteAnAccount;
	
	@FindBy(xpath="//*[@id='id_gender1']")
	WebElement maleRadioButton;
	
	@FindBy(xpath="//*[@id='id_gender1']")
	List<WebElement> maleRadioButton1;

	
	
	public AutomationPracticeRegistrationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn(){
		signin.click();
		log.info("clicked on sign in and object is:-"+signin.toString());
		
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress.sendKeys(emailAddress);
		log.info("entered value for email address:-"+emailAddress+" and object is:-"+this.emailAddress.toString());
	}
	
	public void clickOnCreateAnAccount(){
		craeteAnAccount.click();

	}
	
	public void selectMaleRadioButton(){
		maleRadioButton.click();

	}
	
	public void waitForRegistraionPageLoad(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='account-creation_form']/div[1]/h3"))));
	}

	
}
