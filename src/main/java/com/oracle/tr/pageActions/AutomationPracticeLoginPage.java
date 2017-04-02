package com.oracle.tr.pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.tr.testBase.TestBase;

public class AutomationPracticeLoginPage extends TestBase {
	
	private final static Logger log = Logger.getLogger(AutomationPracticeLoginPage.class.getName());

	@FindBy(css=".login")
	WebElement signIn;
	
	@FindBy(id="email")
	WebElement emailAddress;
	
	@FindBy(id="passwd")
	WebElement passowrd;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	By submit = By.xpath("//*[@id='SubmitLogin']");
	
	public AutomationPracticeLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void clickOnsignIn(){
		signIn.click();
		log.info("click on:-"+signIn.toString());
	}
	
	public void enterEmailAddress(String emailAddress){
		log.info("element is:"+this.emailAddress.toString());
		log.info("enterign email address");
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password){
		this.passowrd.sendKeys(password);
	}
	
	public void clickOnSubmitButton(){
		driver.findElement(submit).click();
	}
	
	public String getInvalidLoginText(){
		String text = driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/ol/li")).getText();
		return text;
	}
	
	public void loginToApplication(String emailAddress,String password){
		clickOnsignIn();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}
}
