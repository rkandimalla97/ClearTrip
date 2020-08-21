package com.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pageobjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	public WebDriver driver;
	
	public LoginPage loginPage;
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	    
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	  loginPage.setEmail(email);
	  loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
	    loginPage.clickLoginButton();
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	    Assert.assertEquals(title, driver.getTitle());
	   
	}
}
