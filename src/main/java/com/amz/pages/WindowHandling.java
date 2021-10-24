package com.amz.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;

public class WindowHandling extends BasePage {

	public WindowHandling(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void copyTextFromNextWindow() throws InterruptedException, IOException {

		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> IDs = handles.iterator();
		String parentWindowID = IDs.next();
		String childWindowID = IDs.next();
		driver.switchTo().window(childWindowID);
		driver.get("https://fontawesome.com/");
		String text = wait
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(ByXPath.xpath("//div[contains(@class,'b f6 f7-l')]"))))
				.getText();
		System.out.println(text);
		driver.close();
		driver.switchTo().window(parentWindowID);
		WebElement inputbox = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(ByXPath.xpath("//input[@id='twotabsearchtextbox']"))));
		inputbox.sendKeys(text);
		File SS = inputbox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SS, new File("partialSS.png"));
		int height = inputbox.getRect().getDimension().getHeight();
		int width = inputbox.getRect().getDimension().getWidth();
		System.out.println("dimentions are " + height + " & " + width);
		driver.findElement(ByXPath.xpath("//input[@id='nav-search-submit-button']")).submit();
		Thread.sleep(2000);
		String ExpectedText = driver.getTitle();

		assertEquals("Amazon.com : Font Awesome", ExpectedText);

	}

}
