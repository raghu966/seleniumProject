package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.pages.LoginPage;
import com.automation.utilities.RetryAnalyzer;
import com.automation.utilities.TestBase;

public class LoginTests extends TestBase{
	
	@Test()
	public void loginApp() throws InterruptedException {
		logger=report.createTest("loginApp");

		LoginPage loginpg = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Initialising the page objects");
		loginpg.login(excel.getStringdata("Login", 0, 0), excel.getStringdata("Login", 0, 1));
		logger.pass("Login passed");

	}

}
