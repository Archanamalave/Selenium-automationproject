package com.Ui.listener;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Ui.tests.TestBase;
import com.Utility.BrowserUtility;
import com.Utility.ExtentReporterUtility;
import com.Utility.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListner implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "" + "Passed");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + "" + "Passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + "" + "Failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "" + "Failed");
		ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage() );
		
		Object testclass= result.getInstance();
		BrowserUtility browserUtility= ((TestBase)testclass).getInstance();
		logger.info("Capturing Screenshots for failed tests");
		String screenshotpath=browserUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotpath);
		logger.info("Attching  Screenshots to the html file");
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + "" + "Skipped");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "" + "Skipped");
	}

	public void onStart(ITestContext context) {
		logger.info("Test  Suites Started");
		ExtentReporterUtility.SetSparkerReporter("Report.html");
	}
 
	public void onFinish(ITestContext context) {
		logger.info("Test  Suites Completed");
		ExtentReporterUtility.flushReport();
	}

}
