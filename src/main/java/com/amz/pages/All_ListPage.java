package com.amz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;

public class All_ListPage extends BasePage {

	public All_ListPage(WebDriver driver) {

		super(driver);

	}

	public void All_Pages() {

		driver.get("https://www.amazon.com/");
	}

	@FindBy(xpath = "//span[@id='aee-xop-dismiss']/input")
	public WebElement tooltip;

	@FindBy(xpath = "//input[@data-action-type='DISMISS']")
	public WebElement location;

	public void alertBox() throws InterruptedException {

		Thread.sleep(2500);

		if (location.isDisplayed()) {
			location.click();

		} else

		if (tooltip.isEnabled()) {
			tooltip.click();
		}

	}

	@FindBy(xpath = "//*[@id='nav-hamburger-menu']")
	public WebElement all_Navbar;

	@FindBy(xpath = "//a/div[text()='Computers']")
	public WebElement computers;
	
	@FindBy(xpath = "//a[@class='hmenu-item'][contains(text(),'Computer Components')]")
	public WebElement component;

	public void computer_Components() {
		wait.until(ExpectedConditions.visibilityOf(all_Navbar)).click();
		computers.click();

		wait.until(ExpectedConditions
				.elementToBeClickable(component)).click();

	}

	public void inputBar() {

		driver.findElement(with(ByXPath.xpath("//input[@id='twotabsearchtextbox']"))
				.near(ByXPath.xpath("//select[@id='searchDropdownBox']"))).sendKeys("hello");

	}

}
