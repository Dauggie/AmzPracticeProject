package com.amz.testcases;

import java.io.IOException;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITFileupload extends BaseTest{
	
	@Test
	public void test() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://imageresizer.com/");
		driver.findElement(ByXPath.xpath("//span[contains(text(),'Select Image')]")).click();
		Thread.sleep(2000);
		
		Runtime.getRuntime().exec("C:\\Users\\DauG\\Desktop\\fileupload.exe");
		Thread.sleep(2000);
		driver.quit();
	}

}
