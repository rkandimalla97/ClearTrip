package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.CommonMethodsHelper;

public class SearchFlightsPage {

	public WebDriver driver;
	public CommonMethodsHelper commonMethods;
	public SelectDate selectDate;
	
	public SearchFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		commonMethods = new CommonMethodsHelper(driver);
		selectDate = new SelectDate(driver);
	}
	
	
	public String tripType_radioxpath = "//input[@type='radio'][@name='trip_type']";
	public String fromSearchResults_xpath = "//ul[@id='ui-id-1']/li/a";
	public String toSearchResults_xpath =  "//ul[@id='ui-id-2']/li/a";
	
	@FindBy(xpath = "//h1[text()='Search flights']")
	public WebElement searchFlights;
	
	@FindBy(id = "FromTag")
	public WebElement from_element;
	
	@FindBy(id = "ToTag")
	public WebElement to_element;
	
	@FindBy(id = "DepartDate")
	public WebElement departOn;
	
	@FindBy(id = "ReturnDate")
	public WebElement returnOn;
	
	@FindBy(xpath = "//select[@id='Adults']")
	public WebElement select_adults;
	
	@FindBy(xpath = "//select[@id='Childrens']")
	public WebElement select_childrens;
	
	@FindBy(xpath = "//select[@id='Infants']")
	public WebElement select_infants;
	
	@FindBy(id = "MoreOptionsLink")
	public WebElement moreOptionsLink;
	
	@FindBy(id = "SearchBtn")
	public WebElement searchButton;
	
	// clicks on Trip type radio button based given trip_name
	public void clickTripType(String tripType_name) {
		commonMethods.selectRadioButton(tripType_radioxpath, tripType_name);
	}
	

	public void setFromPlace(String fromPlace) {
		from_element.clear();
		from_element.sendKeys(fromPlace);
		commonMethods.selectValueFromSearchResults(fromSearchResults_xpath, fromPlace);
	}
	
	public void setToPlace(String toPlace) {
		to_element.clear();
		to_element.sendKeys(toPlace);
		commonMethods.selectValueFromSearchResults(toSearchResults_xpath, toPlace);
	}
	
	
	public void selectTwoWeeksFromToday() {
		departOn.click();
		String actualdate[] = commonMethods.getTwoWeeksDateFromToday().split("-");
		
		String year = actualdate[0];
		String month = actualdate[1];
		String day = actualdate[2];
		
		selectDate.selectDateFromDatePicker(year, month, day);	

		
	}
	
	public void selectNextDayOfTwoWeeksFromToday() {
		departOn.click();
		String actualdate[] = commonMethods.getTwoWeeksDateFromToday().split("-");
		
		String year = actualdate[0];
		String month = actualdate[1];
		String day = String.valueOf(Integer.parseInt(actualdate[2])+1);
		
		selectDate.selectDateFromDatePicker(year, month, day);	

		
	}
	
	public void selectAdults(String adultValue) {
		commonMethods.selectDropdownValue(select_adults, adultValue);
	}
	
	public void selectChilderns(String childernsValue) {
		commonMethods.selectDropdownValue(select_childrens, childernsValue);
	}
	
	public void clickSearchButton() throws Exception {
		searchButton.click();
		Thread.sleep(6000);
	}

	
	
	
	
	
	
	
}
