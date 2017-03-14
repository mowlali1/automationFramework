package com.oracle.tr.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	public static WebDriver driver;
	public Properties OR;
	public FileInputStream file;
	public File f;
	
	public void init() throws IOException{
		loadFile();
		selectBrowser(OR.getProperty("browser"));
	}
	
	public void loadFile() throws IOException{
		OR = new Properties();
		System.out.println(System.getProperty("user.dir"));
		f = new File(System.getProperty("user.dir")+"/src/main/java/com/oracle/tr/config/OR.properties");
		file = new FileInputStream(f);
		OR.load(file);
	}
	
	
	
	/**
	 * This method initialize browser object
	 * 
	 * @param browser
	 * @return browser driver
	 */
	public WebDriver selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		    driver.navigate().to(OR.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver");
			driver = new ChromeDriver();
		    driver.navigate().to(OR.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}

}
