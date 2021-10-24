package com.amz.roughWork;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SomeCheckCode {

	@FindBy(xpath = "//input[@data-action-type='DISMISS']")
	public  WebElement dismiss;

	@Test
	public void checking() {

		WebDriver driver;
		WebDriverWait wait;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		WebElement alertbox = wait.until(
//				ExpectedConditions.visibilityOf(driver.findElement(ByXPath.xpath("//div[@role='alertdialog']"))));
//		// driver.findElement(ByXPath.xpath("//input[@data-action-type='DISMISS']")).click();
//		dismiss.click();

	}

}
