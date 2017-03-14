package com.oracle.tr.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.tr.testBase.TestBase;

public class LoginPage extends TestBase {
    WebDriver driver;
    
	@FindBy(css = ".login")
	WebElement signIn;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement submitButton;

	public LoginPage(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnSignIn() {
		signIn.click();
	}
	
	public void clickOnSubmitButton(){
		submitButton.click();
	}

}
