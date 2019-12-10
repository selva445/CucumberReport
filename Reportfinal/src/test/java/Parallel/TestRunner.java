package Parallel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;



//@RunWith(Cucumber.class)

@CucumberOptions(
		features={"src/test/java/Feature/"} ,glue = {"Parallel"},
		plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:path/report.html", "json:target/cucumber-reports/Cucumber.json"}
		
    	
)
	
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	
	
	
}

