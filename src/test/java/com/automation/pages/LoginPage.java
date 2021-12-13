package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.sun.tools.javac.util.List;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "email")
	WebElement username;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password;

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginbt;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginBtn;
	
	//@FindBys({@FindBy(name = "xyx"), @FindBy(name = "yxg")}) List<WebElement> findByexp;
	//@FindAll({@FindBy(name = "xyx"), @FindBy(name = "yxg")}) List<WebElement> findallexp;

	public void login(String user, String pwd) throws InterruptedException {
		loginbt.click();
		username.sendKeys(user);
		Thread.sleep(3000);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
