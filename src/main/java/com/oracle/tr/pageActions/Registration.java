package com.oracle.tr.pageActions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.oracle.tr.testBase.TestBase;


public class Registration extends TestBase {

	WebDriver driver;

	
	By email = By.xpath("//input[@id='email_create']");
	By userName = By.id("customer_lastname");
	By password = By.cssSelector("#passwd");

	@FindBy(id="SubmitCreate")
	WebElement registor;

	@FindBy(className = "login")
	WebElement login;

	@FindBy(xpath = "//input[@id='id_gender1'][@name='id_gender']")
	WebElement selectGender;

	@FindBy(xpath = "//*[@id='days']")
	WebElement selectDays;

	@FindBy(xpath = "//*[@id='months']")
	WebElement selectMonth;

	@FindBy(xpath = "//*[@id='years']")
	WebElement selectYear;

	@FindBy(xpath = "//*[@id='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//*[@id='address1']")
	WebElement address;

	@FindBy(xpath = "//*[@id='city']")
	WebElement city;

	@FindBy(xpath = "//*[@id='postcode']")
	WebElement postcode;

	@FindBy(xpath = "//*[@id='phone_mobile']")
	WebElement phone_mobile;

	@FindBy(xpath = "//*[@id='alias']")
	WebElement alias;

	@FindBy(xpath = "//*[@id='submitAccount']")
	WebElement submitAccount;

	@FindBy(xpath = "//*[@id='id_state']")
	WebElement state;

	@FindBy(xpath = "//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	WebElement accountCreationMessage;

	@FindBy(xpath = "//*[@id='years']/option")
	WebElement yearOption;

	@FindBy(xpath = "//*[@id='months']/option")
	WebElement monthOption;

	@FindBy(xpath = "//*[@id='days']/option")
	WebElement dayOption;
	
	@FindBy(id="customer_lastname")
	WebElement customerLastName;
	
	@FindBy(id="customer_firstname")
	WebElement customerfirstName;
	
	@FindBy(className="logout")
	WebElement logout;

	public Registration(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	public boolean clickOnLogout(){
		try {
			logout.isDisplayed();
			logout.click();
			log.info("clicked on logout link");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
           return false;
		}
		
	}

	public void setEmail(String emailAddress) {
		try {
			driver.findElement(email).sendKeys(emailAddress);
            log.info("email id "+emailAddress+" has been set");
		} catch (Exception e) {
			log.error("email id "+emailAddress+" has been set "+e.getStackTrace());
		}
	}

	public void setUserName(String user) {
		try {
			driver.findElement(userName).sendKeys(user);
			log.info("user Name"+user+" has been set");
		} catch (Exception e) {
			log.error("user Name"+user+" has been set "+e.getStackTrace());
		}

	}

	public void setPassword(String password) {
		try {
			driver.findElement(this.password).sendKeys(password);

			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public void clickOnLogin() {
		try {
			login.click();

		} catch (Exception e) {

		}
	}

	public void clickOnRegistor() {
		try {
			registor.click();
			//test.log(LogStatus.PASS,test.addScreenCapture(captureScreen("clickOnRegistor")));
		} catch (Exception e) {
			//test.addScreenCapture(captureScreen("clickOnRegistor"));
			e.printStackTrace();

		}
	}

	public void selectMailGender() {
		try {
			selectGender.click();
		} catch (Exception e) {
		}
	}

	public void selectDays(String selectDay) {
		try {
			Thread.sleep(2000);
			selectDays.click();
			Thread.sleep(2000);
			List<WebElement> days = driver.findElements(By.xpath("//*[@id='days']/option"));
			Iterator<WebElement> itr = days.iterator();
			while (itr.hasNext()) {
				WebElement c = itr.next();
				String text = c.getText().trim().toString();
				if (text.equals(selectDay)) {
					System.out.println(selectDays);
					c.click();
					break;
				}
			}
		} catch (Exception e) {
		}

	}

	public void selectMonth(String selectMonth) {
		try {
			Thread.sleep(1000);
			this.selectMonth.click();
			Thread.sleep(1000);
			List<WebElement> days = driver.findElements(By.xpath("//*[@id='months']/option"));
			Iterator<WebElement> itr = days.iterator();
			while (itr.hasNext()) {
				WebElement click = itr.next();
				String text = click.getText().trim();
				if (text.equals(selectMonth)) {
					click.click();
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void selectYear(String selectYear) {
		try {
			Thread.sleep(1000);
			this.selectYear.click();
			Thread.sleep(2000);
			List<WebElement> days = driver.findElements(By.xpath("//*[@id='years']/option"));
			Iterator<WebElement> itr = days.iterator();
			while (itr.hasNext()) {
				WebElement click = itr.next();
				String text = click.getText().trim();
				if (text.equals(selectYear)) {
					click.click();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setFirstName(String firstName) {
		try {
			this.firstName.sendKeys(firstName);

		} catch (Exception e) {

		}
	}

	public void setLastName(String lastName) {
		try {
			this.lastName.sendKeys(lastName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setAddress(String address) {
		try {
			this.address.sendKeys(address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectState() {
		try {
			new Select(state).getOptions().get(6).click();
			//expliciteWait(driver.findElement(By.xpath("")), 50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public String register(String emailAddress,String passowrd, String selectDay, String selectMonth,
			String selectYear, String customerfirstName,String customerLastName, String firstName, String lastName, String address) throws InterruptedException {
		try {
			clickOnLogin();
			setEmail(emailAddress);
			clickOnRegistor();
			selectMailGender();
			driver.findElement(By.id("passwd")).sendKeys("testName");
			this.customerfirstName.sendKeys(customerfirstName);
			this.customerLastName.sendKeys(customerLastName);
			selectDays(selectDay);
			selectMonth(selectMonth);
			selectYear(selectYear);
			setFirstName(firstName);
			setLastName(lastName);
			setAddress(address);
			city.sendKeys("CA");
			selectState();
			postcode.sendKeys("90001");
			phone_mobile.sendKeys("9999999999");
			alias.sendKeys("Test Address");
			//test.log(LogStatus.PASS,test.addScreenCapture(captureScreen("registerInputData")));
			submitAccount.click();
			String text = accountCreationMessage.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "registration was not successful";

	}
	
	public void verifyRegistorMessage(String expectedmsg,String actualMessage){
		System.out.println("expectedmsg is :-"+expectedmsg+" actualMessage is:-"+actualMessage);
		Assert.assertEquals(actualMessage,expectedmsg);
	}

}
