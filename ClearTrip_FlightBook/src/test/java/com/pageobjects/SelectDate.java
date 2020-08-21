package com.pageobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectDate {
	
	WebDriver driver;
	
	public SelectDate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='monthBlock first']//a[@title='Prev']")
	public WebElement previous_Button;
	
	@FindBy(xpath = "//div[@class='monthBlock last']//a[@title='Next']")
	public WebElement next_Button;
	
	@FindBy(xpath = "(//span[@class='ui-datepicker-month'])[1]")
	public WebElement month_element;
	
	@FindBy(xpath = "(//span[@class='ui-datepicker-year'])[1]")
	public WebElement year_element;
	
	public void selectDateFromDatePicker(String year, String month, String day)
    {
		System.out.println(year_element.getText());

        while (!year.equals(year_element.getText()))
        {
            if (Integer.parseInt(year) < Integer.parseInt(year_element.getText()) )
            {
                previous_Button.click();
            }
            else
            {
                next_Button.click();
            }
        }

       

        while (!month.equals(getMonth(month_element.getText())))
        {
        	next_Button.click();
        }
        WebElement dateField = driver.findElement(By.xpath("//td[@data-handler='selectDay'][@data-month='"+(Integer.parseInt(month) - 1)+"'][@data-year='"+year+"']/a[text()='"+(Integer.parseInt(day))+"']"));
        dateField.click();
    }
	
	public String getMonth(String actualMonth) {
		String month ="";
		Map<String,String> monthsMap = getMonthsMap();
		for (Entry<String, String> entry : monthsMap.entrySet()) {	
			if(actualMonth.equals(entry.getKey())) {
				month = entry.getValue();	
				break;
			}
		}
		return month;	
	}

	public Map<String,String> getMonthsMap() {
		
		Map<String,String> monthsMap = new HashMap<String,String>();
		
		monthsMap.put("January", "01");
		monthsMap.put("Febraury", "02");
		monthsMap.put("March", "03");
		
		monthsMap.put("April", "04");
		monthsMap.put("May", "05");
		monthsMap.put("June", "06");
		
		monthsMap.put("July", "07");
		monthsMap.put("August", "08");
		monthsMap.put("September", "09");
		
		monthsMap.put("October", "10");
		monthsMap.put("November", "11");
		monthsMap.put("December", "12");
		return monthsMap;	
	}
}
