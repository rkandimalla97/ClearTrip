package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.CommonMethodsHelper;

public class SelectFlightPage {

	WebDriver driver;
	CommonMethodsHelper commonMethodsHelper;
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='current sortAsc']")
	public WebElement priceLow_element;
	
	@FindBy(xpath = "//a[@class='current sortDes']")
	public WebElement priceHigh_element;
	
	@FindBy(xpath = "//a[@data-sort='price']")
	public WebElement price_element;
	
	@FindBy()
	public WebElement book_Button;
	
	public void setPriceAccessindOrder() {
		if(!priceLow_element.isDisplayed()) {
			price_element.click();
		}
	}
	
	public String getCheapestFlight() {
		setPriceAccessindOrder();
		String cheapPriceFligt_xpath ="";
		
		// store all webelements in List 
		List<WebElement> list_elements = driver.findElements(By.xpath("//th[@id='BaggageBundlingTemplate']/span"));
		
		// extract the prices from the price elements and store in a List
		List<String> flightPrices = new ArrayList<String>();
		for (WebElement actprices : list_elements)
		{
			flightPrices.add(actprices.getAttribute("data-pr"));
		}
		cheapPriceFligt_xpath = "(//th[@id='BaggageBundlingTemplate']/span[@data-pr='"+flightPrices.get(0)+"']/ancestor::tbody/tr/td/button[@class='booking'])[1]";
				
		return cheapPriceFligt_xpath;
		
	}
	
	public void clickBookButton() {
		String cheapFlight = getCheapestFlight();
		commonMethodsHelper.waitForElementToAppear(driver, cheapFlight);
		if(driver.findElements(By.xpath(cheapFlight)).size()==1) {
			WebElement bookElement = driver.findElement(By.xpath(cheapFlight));
			bookElement.click();
		}else {
			System.out.println("Element not able to click");
		}
		
	}
	
}
