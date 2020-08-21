package com.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.pageobjects.FlightBookingPage;
import com.pageobjects.SearchFlightsPage;
import com.pageobjects.SelectFlightPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightBookingSteps {
	
	WebDriver driver;
	public SearchFlightsPage searchFlightsPage;
	public SelectFlightPage selectFlightPage;
	public FlightBookingPage flightBookingPage;
	
	
	@Given("User launch the browser")
	public void user_launch_the_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disabled-infobars");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);

		searchFlightsPage = new SearchFlightsPage(driver);
		selectFlightPage = new SelectFlightPage(driver);
		flightBookingPage = new FlightBookingPage(driver);
	}
	
	 @Given("I am on flight booking page")
	 public void i_am_on_flight_booking_page() {
//		Assert.assertEquals(searchFlightsPage.searchFlights.getText(), "Search flights"); 
		 System.out.println("Seaarch Flights");
	 }
	 
	@Then("I am on the Flights Booking page URL {string}")
	public void i_am_on_the_flights_booking_page_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("I verify the page title as {string}")
	public void i_verify_the_page_title_as(String title) {
	   Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("I click on type trip as {string}")
	public void i_click_on_type_trip_as(String tripType_name) {
	    searchFlightsPage.clickTripType(tripType_name);
	}

	@Then("I enter the From place as {string} and To place as {string}")
	public void i_enter_the_from_place_as_and_to_place_as(String from, String to) {
	   searchFlightsPage.setFromPlace(from);
	   searchFlightsPage.setToPlace(to);
	}

	@Then("I select Departure date as two weeks from today")
	public void i_select_departure_date_as_two_weeks_from_today() {
	   searchFlightsPage.selectTwoWeeksFromToday();
	}
	
	@Then("I select Departure date as next day oftwo weeks from today")
	public void i_select_departure_date_as_next_day_oftwo_weeks_from_today() {
		searchFlightsPage.selectNextDayOfTwoWeeksFromToday();
	}

	@Then("I select the Adults as {string} and Childerns as {string}")
	public void i_select_the_adults_as_and_childerns_as(String adults, String childerns) {
	   searchFlightsPage.selectAdults(adults);
	   searchFlightsPage.selectChilderns(childerns);
	}

	@Then("I click on Search Flights button")
	public void i_click_on_search_flights_button() throws Exception {
	    searchFlightsPage.clickSearchButton();
	}
	
	@Then("I click on book button for cheapest flight")
	public void i_click_on_book_button_for_cheapest_flight() {
		selectFlightPage.clickBookButton();
		
	}
	

@Then("I click on continue booking button in Itinerary section")
public void i_click_on_continue_booking_button_in_itinerary_section() throws Exception {
   flightBookingPage.clickContinueBookingBtn();
}


@Then("I enter the email address {string} and click continue in Email Address section")
public void i_enter_the_email_address_and_click_continue_in_email_address_section(String emailAddress) throws Exception {
	flightBookingPage.setEmailAddress(emailAddress);
	   flightBookingPage.clickContinueBtn_emailAddresSectn();
	   
}

@Then("I enter the details for Adult {string} title as {string} firstname as {string} and lastName as {string} in Travellers section")
public void i_enter_the_details_for_adult_title_as_firstname_as_and_last_name_as_in_travellers_section(String adultNum, String title, String firstName, String lastName) {
    flightBookingPage.setadultvalues(adultNum, title, firstName, lastName);
}

@Then("I enter the details for Child {string} title as {string} firstname as {string} and lastName as {string} in Travellers section")
public void i_enter_the_details_for_child_title_as_firstname_as_and_last_name_as_in_travellers_section(String childNum, String title, String firstName, String lastName) {
	flightBookingPage.setChildValues(childNum, title, firstName, lastName);
}

@Then("I enter the remaining details for Date of Birth as {string} and mobile num as {string} traveller section")
public void i_enter_the_remaining_details_for_date_of_birth_as_and_mobile_num_as_traveller_section(String dob, String mobileNum) {
 flightBookingPage.setDateOfBirth(dob);
 flightBookingPage.setMobileNumber(mobileNum);
}

@Then("I click on continue button in travellers section")
public void i_click_on_continue_button_in_travellers_section() throws Exception {
    flightBookingPage.clickContinueBtnTraveller();
}

@Then("I verify makepayment exist in Payment section")
public void i_verify_makepayment_exist_in_payment_section() {
    flightBookingPage.verifyMakePaymentBtn();
}

@When("I click on clearTrip icon")
	public void i_click_on_clearTrip_icon() throws Exception {
		flightBookingPage.clickClearTripLogo();
	}

@Then("I close the browser")
public void i_close_the_browser() {
	driver.close();
}
}

