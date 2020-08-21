package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		features = {".//Features/OneWayFlightBooking.feature",".//Features/ReturnFlightBooking.feature"},
		glue = "com.stepdefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty/index.html"}
						
		)

public class TestRun {

	
}
