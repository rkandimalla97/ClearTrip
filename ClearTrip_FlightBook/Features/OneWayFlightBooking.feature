
Feature: Onwards Flight Booking

	@onwardFlight
  Scenario: Book a flight two weeks from today
    Given User launch the browser
    Then I am on the Flights Booking page URL "https://www.cleartrip.com/flights"
    Then I verify the page title as "Flight bookings, Cheap flights, Lowest Air tickets @Cleartrip"
    And I click on type trip as "OneWay"
    And I enter the From place as "Bangalore, IN" and To place as "Delhi, IN"
    Then I select Departure date as two weeks from today
    And I select the Adults as "1" and Childerns as "1"
    And I click on Search Flights button
    Then I click on book button for cheapest flight
  	Then I verify the page title as "Cleartrip | Book your flight securely in simple steps"
  	Then I click on continue booking button in Itinerary section
  	Then I enter the email address "ravi111teja@gmail.com" and click continue in Email Address section
  	Then I enter the details for Adult "1" title as "Mr" firstname as "Henry" and lastName as "White" in Travellers section
  	Then I enter the details for Child "1" title as "Miss" firstname as "Stella" and lastName as "White" in Travellers section
		Then I enter the remaining details for Date of Birth as "1-Mar-2012" and mobile num as "9876598765" traveller section
		Then I click on continue button in travellers section
  	Then I verify makepayment exist in Payment section
  	When I click on clearTrip icon
  	Then I verify the page title as "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities."
  	Then I close the browser
  	
  	  
 

  