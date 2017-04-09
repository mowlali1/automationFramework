package com.oracle.tr.customeListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.oracle.tr.testBase.TestBase;


public class Listner extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Test started running:" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test run is successful:" + result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/oracle/tr/screenshot/";
                File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	/*
	public void onTestFailure(ITestResult result) {
		if (!result.isSuccess()) {
			String userDirector = System.getProperty("user.dir");
			String customeLocation = "/src/main/java/com/oracle/tr/screenshot//";
			
			String failureImageFileName = userDirector + customeLocation
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + "-"
					+ result.getMethod().getMethodName() + ".png";
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(scrFile, new File(failureImageFileName));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Reporter.log("<a href=\"" + failureImageFileName + "\"><img src=\"file:///" + failureImageFileName
					+ "\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
			
			Reporter.setCurrentTestResult(null);
			Reporter.log(result.getName() + "--Test method failed\n");
		}
	}
*/
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test is skipped:" + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onFinish(ITestContext arg0) {

	}

	public void onStart(ITestContext arg0) {

	}

	
}
