package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	public WebElement email;
	
	@FindBy(id = "Password")
	public WebElement password_element;
	
	@FindBy(xpath = "//input[@value='Log in']")
	public WebElement loginButton;
	
	@FindBy(linkText = "Logout")
	public WebElement logoutButton;
	
	
	public void setEmail(String emailName) {
		email.clear();
		email.sendKeys(emailName);
	}
	
	public void setPassword(String password) {
		password_element.clear();
		password_element.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
	
}
