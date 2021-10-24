package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsMain {

	public static ExtentReports extent = new ExtentReports();

	public static ExtentReports getReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\reports\\index.html");
		reporter.config().setReportName("Amazon test Results");
		reporter.config().setDocumentTitle("Test Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "KaranP.");
		return extent;

	}

}
