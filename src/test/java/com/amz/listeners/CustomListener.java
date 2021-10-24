package com.amz.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import static com.utils.LogGenerator.log;
import static com.utils.ExtentReportsMain.extent;
import static com.utils.ExtentReportsMain.getReports;

import com.amz.testcases.AllPageTest;
import com.amz.testcases.BaseTest;
import java.lang.reflect.Method;


public class CustomListener implements ITestListener {
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		 test = getReports().createTest("Test Name : "+result.getName());
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		log.info("Test success : "+result.getStatus());
		test.log(Status.PASS, "Test Successful");
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver;
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String testname = result.getMethod().getMethodName();
		try {
		driver =	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		new BaseTest().getSS(driver,testname);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\reports\\"+testname+".png", "Error Screenshot");
		test.log(Status.FAIL, "Test failed : "+testname);
		test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		String testname = result.getMethod().getMethodName();
		log.info("Test skip : "+testname);
		test.log(Status.SKIP, "Test Successful : "+testname);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		log.info(" List of methods executed: "+Method.class.getMethods().toString());
		extent.flush();
	}

	

}
