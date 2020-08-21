package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.CommonMethodsHelper;

public class FlightBookingPage {

	WebDriver driver;
	CommonMethodsHelper commonMethods;
	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethodsHelper(driver);
	}
	
	
	public String adultTitle_xpath = "//select[contains(@id,'AdultTitle')]";
	public String makePayment_xpath = "//*[@value='Make payment']";
	
	
	/********* Itinerary section elements******/
	
	@FindBy(xpath = "//*[@value='Continue booking']")
	public WebElement continueBooking_btn;
	
	/****** Email Address******/
	@FindBy(xpath = "//*[@id='username']")
	public WebElement emailAddress;
	
	@FindBy(xpath = "//*[@value='Continue'][@class='booking hotelButton']")
	public WebElement continue_btn;
	
	/********** Travellers ************/
	@FindBy(xpath = "//select[contains(@id,'AdultTitle')]")
	public WebElement adultNum;
	
	@FindBy(xpath = "//*[@id='travellerBtn']")
	public WebElement traveller_continueBtn;
	
	@FindBy(xpath = "//select[@etitle='day']")
	public WebElement dob_day;
	
	@FindBy(xpath = "//select[@etitle='month']")
	public WebElement dob_month;
	
	@FindBy(xpath = "//select[@etitle='year']")
	public WebElement dob_year;
	
	@FindBy(id = "mobileNumber")
	public WebElement mobileNumber;
	
	@FindBy(xpath = "//*[@value='Make payment']")
	public WebElement makePayment_btn;
	
	@FindBy(xpath = "//*[contains(@alt,'Cleartrip')]")
	public WebElement clearTrip_logo;
	
	//Click continue booking button in Itinerary section
	public void clickContinueBookingBtn() throws InterruptedException {
		commonMethods.clickButton(continueBooking_btn);
		Thread.sleep(3000);
	}
	
	//Email address section: Enter value in Email address field 
	public void setEmailAddress(String email) {
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}
	
	//Email Address section: Click continue button
	public void clickContinueBtn_emailAddresSectn() throws Exception {
		commonMethods.clickButton(continue_btn);
		Thread.sleep(3000);
	}
	
	//Enter values for Adult row in Traveller section
	public void setadultvalues(String adultNum, String title, String firstName, String lastName) {
		
		WebElement selectTitle = driver.findElement(By.xpath("//select[contains(@id,'AdultTitle')][@data-pax-no='"+adultNum+"']"));
		WebElement firstNameVal = driver.findElement(By.xpath("//input[contains(@id,'AdultFname')][@data-pax-no='"+adultNum+"']"));
		WebElement lastNameVal = driver.findElement(By.xpath("//input[contains(@id,'AdultLname')][@data-pax-no='"+adultNum+"']"));
		//select value from title
		commonMethods.waitForElementToAppear(driver, adultTitle_xpath+"[@data-pax-no='"+adultNum+"']");
		commonMethods.selectDropdownValue(selectTitle, title);
		firstNameVal.clear();
		firstNameVal.sendKeys(firstName);
		lastNameVal.click();
		lastNameVal.sendKeys(lastName);	
	}
	
	public void setChildValues(String childNum, String title, String firstName, String lastName) {
		WebElement selectTitle = driver.findElement(By.xpath("//select[contains(@id,'ChildTitle')][@data-pax-no='"+childNum+"']"));
		WebElement firstNameVal = driver.findElement(By.xpath("//input[contains(@id,'ChildFname')][@data-pax-no='"+childNum+"']"));
		WebElement lastNameVal = driver.findElement(By.xpath("//input[contains(@id,'ChildLname')][@data-pax-no='"+childNum+"']"));

		commonMethods.selectDropdownValue(selectTitle, title);
		firstNameVal.clear();
		firstNameVal.sendKeys(firstName);
		lastNameVal.click();
		lastNameVal.sendKeys(lastName);	
		
	}
	
	public void setDateOfBirth(String dob) {
		
		String dateOfBirth[] = dob.split("-");
		commonMethods.selectDropdownValue(dob_day, dateOfBirth[0].toString());
		commonMethods.selectDropdownValue(dob_month, dateOfBirth[1].toString());
		commonMethods.selectDropdownValue(dob_year, dateOfBirth[2].toString());
		
	}
	
	public void setMobileNumber(String mobileNum) {
		mobileNumber.clear();
		mobileNumber.sendKeys(mobileNum);
	}
	public void clickContinueBtnTraveller() throws Exception {
		traveller_continueBtn.click();
		Thread.sleep(3000);
	}
	
	public void verifyMakePaymentBtn() {
		commonMethods.waitForElementToAppear(driver, makePayment_xpath);
		if(!makePayment_btn.isDisplayed()) {
			System.out.println("Make Payment button is not displayed");
		}
	}
	public void clickClearTripLogo() throws Exception {
		clearTrip_logo.click();
		Thread.sleep(5000);
	}
	
}
