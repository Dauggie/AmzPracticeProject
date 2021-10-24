package com.amz.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amz.pages.All_ListPage;

public class AllPageTest extends BaseTest {

	@Test
	
	public void runAllPageTest() throws Throwable {

		setup();

		All_ListPage all = new All_ListPage(driver);
		all.All_Pages();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		all.computer_Components();
		String WindowTitle = driver.getTitle();
		all.inputBar();
		assertEquals("Amazon.com", WindowTitle);

	}
	
	
	


}
