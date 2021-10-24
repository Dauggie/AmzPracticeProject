package com.amz.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	DesiredCapabilities dcap = new DesiredCapabilities();
	String client;

	public void setup() {

		Random random = new Random();

		int value = random.nextInt(3);
		
		switch(value) {
		case 0:
		{
			client = "chrome";
			break;
		}
		case 1:
		{
			client = "firefox";
			break;
		}
		case 2:
		{
			client = "edge";
			break;
		}
		}

		if (client.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (client.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if (client.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

	}

	public void getSS(WebDriver driver, String name) {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\reports\\" + name + ".png");

		try {
			FileUtils.copyFile(screenshotFile, dest);
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.quit();

	}
}
