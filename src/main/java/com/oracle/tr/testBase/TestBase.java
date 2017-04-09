package com.oracle.tr.testBase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.oracle.tr.excelReader.Xls_Reader;

@SuppressWarnings("unused")
public class TestBase {
	public static WebDriver driver;
	public Properties OR;
	public Properties config;
	public FileInputStream file;
	public FileOutputStream file1;
	public File f;
	public File f1;
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	public Xls_Reader Data;

	public void init() throws IOException {
		/*setData();
		System.out.println(System.getProperty("url"));
		config.setProperty("url", System.getProperty("url"));
		config.setProperty("userName", System.getProperty("userName"));
		config.setProperty("password", System.getProperty("password"));
		config.setProperty("browser", System.getProperty("browser"));
		config.store(file1, null);
		file1.close();*/
		loadFile();
		selectBrowser(OR.getProperty("browser"));
	}

	public void loadFile() throws IOException {
		OR = new Properties();
		System.out.println(System.getProperty("user.dir"));
		f = new File(System.getProperty("user.dir") + "/src/main/java/com/oracle/tr/config/OR.properties");
		file = new FileInputStream(f);
		OR.load(file);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	/**
	 * This method initialize browser object
	 * 
	 * @param browser
	 * @return browser driver
	 */
	public WebDriver selectBrowser(String browser) {
		if(System.getProperty("os.name").contains("Mac OS")){
			if (browser.equalsIgnoreCase("firefox")) {
				// Dowmload Location
				//https://github.com/mozilla/geckodriver/releases/tag/v0.15.0 
				System.setProperty("webdriver.firefox.marionette", "/driver/geckodriver");
				driver = new FirefoxDriver();
				driver.navigate().to(OR.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				return driver;
			} else if (browser.equalsIgnoreCase("chrome")) {
				//https://sites.google.com/a/chromium.org/chromedriver/downloads
				log.info("creating oject of:-" + browser);
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		        //ChromeOptions options = new ChromeOptions();
		        //options.addArguments("--test-type");
		        driver = new ChromeDriver();
				driver.navigate().to(OR.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				return driver;
			} else if (browser.equals("ie") || browser.equals("IE")) {
				log.info("creating oject of:-" + browser);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				return driver;
			}
		}
		else if(System.getProperty("os.name").contains("windwo")){
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "/driver/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.navigate().to(OR.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				return driver;
			} else if (browser.equalsIgnoreCase("chrome")) {
				https://sites.google.com/a/chromium.org/chromedriver/downloads
				log.info("creating oject of:-" + browser);
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		        //ChromeOptions options = new ChromeOptions();
		        //options.addArguments("--test-type");
		        driver = new ChromeDriver();
				driver.navigate().to(OR.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				return driver;
			} else if (browser.equals("ie") || browser.equals("IE")) {
				log.info("creating oject of:-" + browser);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				return driver;
			}
		}
		
		return null;
	}

	public void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}


	public WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return element;
	};

	public void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println(
					"Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
	}

	public Object[][] getData(String ExcelName, String testcase) {
		Data = new Xls_Reader(System.getProperty("user.dir") + "/src/main/java/com/oracle/tr/data/" + ExcelName);
		int rowNum = Data.getRowCount(testcase);
		System.out.println(rowNum);
		int colNum = Data.getColumnCount(testcase);
		Object sampleData[][] = new Object[rowNum - 1][colNum];
		for (int i = 2; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sampleData[i - 2][j] = Data.getCellData(testcase, j, i);
			}
		}
		return sampleData;
	}

	public static void updateResult(int indexSI, String testCaseName, String testCaseStatus, String scriptName)
			throws IOException {

		String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());

		String userDirector = System.getProperty("user.dir");

		String resultFile = userDirector
				+ "//src//test//java//com//companyname//projectname//report//TestHtmlReport.html";

		File file = new File(resultFile);
		System.out.println(file.exists());

		if (!file.exists()) {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<html>" + "\n");
			bw.write("<head><title>" + "Test execution report" + "</title>" + "\n");
			bw.write("</head>" + "\n");
			bw.write("<body>");
			bw.write("<font face='Tahoma'size='2'>" + "\n");
			bw.write("<u><h1 align='center'>" + "Test execution report" + "</h1></u>" + "\n");
			bw.flush();
			bw.close();
		}
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));
		if (indexSI == 1) {
			bw1.write("<table align='center' border='0' width='70%' height='10'>");
			bw1.write("<tr><td width='70%' </td></tr>");
			bw1.write("<table align='center' border='1' width='70%' height='47'>");
			bw1.write("<tr>");
			bw1.write(
					"<td colspan='2' align='center'><b><font color='#000000' face='Tahoma' size='2'>ScriptName :&nbsp;&nbsp;&nbsp;</font><font color='#0000FF'' face='Tahoma' size='2'>"
							+ scriptName + " </font></b></td>");
			bw1.write(
					"<td colspan='1' align='left'><b><font color='#000000' face='Tahoma' size='1'>Start Time :&nbsp;</font></b><font color='#0000FF'' face='Tahoma' size='1'>"
							+ startDateTime + " </font></td>");
			bw1.write("</tr>");
			bw1.write("</tr>");
			bw1.write(
					"<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");
			bw1.write(
					"<td  bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Test case ID : Test case Description </font></b></td>");

			bw1.write(
					"<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Result </font></b></td>");
			bw1.write("</tr>");
		}
		bw1.write("<tr>" + "\n");
		bw1.write("<td bgcolor='#FFFFDC'align='Center'><font color='#000000' face='Tahoma' size='2'>" + indexSI
				+ "</font></td>" + "\n");
		bw1.write("<td  bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
				+ testCaseName + "</font></b></td>" + "\n");
		if (testCaseStatus == "Pass") {
			bw1.write(
					"<td  bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='Green' face='Tahoma' size='2'>"
							+ testCaseStatus + "</font></b></td>" + "\n");
		} else {
			bw1.write(
					"<td  bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='red' face='Tahoma' size='2'>"
							+ testCaseStatus + "</font></b></td>" + "\n");
		}
		bw1.write("</tr>" + "\n");
		bw1.write("</body>" + "\n");
		bw1.write("</html>");
		bw1.flush();
		bw1.close();

	}

	public void setTestStatus(int testID, String status) {
		try {

			int colNum = -1;
			FileInputStream f = new FileInputStream(new File("DataSheet.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(f);
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			HSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals("status")) {
					colNum = i;
				}
			}
			int rows = sheet.getPhysicalNumberOfRows();
			for (int j = 1; j < rows; j++) {
				HSSFRow grow = sheet.getRow(j);
				String cellvalue = grow.getCell(0).getStringCellValue();
				int excelID = Integer.parseInt(cellvalue);
				if (excelID == testID) {

					if (status.contains("Pass")) {
						HSSFCellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(HSSFColor.GREEN.index);
						style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

						HSSFFont blueFont = workbook.createFont();
						blueFont.setColor(HSSFColor.DARK_GREEN.index);
						HSSFCellStyle style2 = workbook.createCellStyle();
						style.setFont(blueFont);

						grow.getCell(colNum).setCellValue(status);
						grow.getCell(colNum).setCellStyle(style2);
						grow.getCell(colNum).setCellStyle(style);

					} else {
						HSSFCellStyle style1 = workbook.createCellStyle();
						style1.setFillForegroundColor(HSSFColor.RED.index);
						style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
						grow.getCell(colNum).setCellValue(status);
						grow.getCell(colNum).setCellStyle(style1);
					}
					FileOutputStream fileOut = new FileOutputStream(new File("DataSheet.xls"));
					workbook.write(fileOut);
					fileOut.close();

					break;
				}

			}

		}

		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	public void setData() throws IOException{
		config = new Properties();
		System.out.println(System.getProperty("user.dir"));
		f1 = new File(System.getProperty("user.dir") + "/src/main/java/com/oracle/tr/config/config.properties");
		file1 = new FileOutputStream(f1, false);
		//config.

	}

}
