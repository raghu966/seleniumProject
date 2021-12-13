package com.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigdataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void getExcelData() {
		excel = new ExcelDataProvider();
		config = new ConfigdataProvider();
		//Describes where we need to store the extent reports
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/ExtentCRM" + Helper.getDate() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setUp() {
		System.out.println(config.getBrowser() + "************");
		driver = Browserfactory.startApplication(driver, config.getBrowser(), config.getUrl());
	}

	@AfterClass
	public void tearDown() {
		Browserfactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			String screenShotPath = Helper.captureScreenShot(driver);
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String screenShotPath = Helper.captureScreenShot(driver);
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());

		}
		report.flush();
	}

}
