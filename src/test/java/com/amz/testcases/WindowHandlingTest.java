package com.amz.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amz.pages.All_ListPage;
import com.amz.pages.WindowHandling;

public class WindowHandlingTest extends BaseTest{

	@Test
	
	public void handleWindows() throws InterruptedException, IOException {
		setup();
		new All_ListPage(driver).All_Pages();
		WindowHandling wh = new WindowHandling(driver);
		wh.copyTextFromNextWindow();
		
	}
	
}
