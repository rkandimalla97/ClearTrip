package com.Utilities;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethodsHelper {

	WebDriver driver;
	public CommonMethodsHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectDropdownValue(WebElement element, String fieldValue) {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
		Select listElement = new Select(element);
		listElement.selectByVisibleText(fieldValue);
	}
	
	public void selectRadioButton(String xpathValue, String fieldValue) {
		
		WebElement element = driver.findElement(By.xpath(xpathValue+"[@value='"+fieldValue+"']"));
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
		element.click();
	}
	
	public void clickButton(WebElement element) {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
		element.click();
	}
	public void selectValueFromSearchResults(String xpath, String value) {
		List<WebElement> listElements = driver.findElements(By.xpath(xpath));
		 for(WebElement result: listElements){
             if(result.getText().contains(value)){           
                 result.click();
                 break;
             }
         }
		 
	}
	
	public String getTwoWeeksDateFromToday() {
		LocalDate localDate = LocalDate.now(); //It will the current system date and format like 'YYYY-MM-DD
		LocalDate twoWeeksLater = localDate.plusWeeks( 2 );
		// local date value storing into string variable
		String twoWeeksDate = twoWeeksLater.toString();
		return twoWeeksDate;
	}
	
	public void waitForElementToAppear(WebDriver driver,String loc) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc)));
        
        //By.xpath("\"" + loc + "\"")
        
        
    }
	
	public void waitFortextToBePresentInElement(WebDriver driver,WebElement element,String text) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        //By.xpath("\"" + loc + "\"")
        
        
    }

	
	public void waitFor(int milliSeconds){
		try	{
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
