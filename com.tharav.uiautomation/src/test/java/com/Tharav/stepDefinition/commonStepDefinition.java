package com.Tharav.stepDefinition;

//import com.aventstack.extentreports.gherkin.model.Scenario;
import Utilities.commonMethods;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Tharav.Drivermanager.driverManager;

public class commonStepDefinition {
	
	
	private  static String scenarioName = null;

	private static final Logger LOGGER = LogManager.getLogger(commonMethods.class);
	
	public static String getScenarioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario)
	
	{
		LOGGER.info("Execution started");
		try
		{
			//get the scenario name of each and every scenario
			scenarioName = scenario.getName();
			commonMethods cu = new commonMethods();
			LOGGER.info("Instantiaing  the common methods of Common Methods class  @before Scenaio");


			cu.loadProperties();
			LOGGER.info("Loading the properties file");

			LOGGER.info("Checking the driver is NULL or NOT?");

			if (driverManager.getDriver() == null) {
				LOGGER.info("Driver is NUll, Launching  the browser");
				driverManager.lauchBrowser();
			
				//cu.initWebElements();
			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			//commonutils.getInstance().takeScreenShot();
			e.printStackTrace();
			
		}
	}
	@AfterStep
	public void attachScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		System.out.println("scenario failed from the common step definition");
		byte[] screenshotTaken = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotTaken,"image/png", "errorscreen");
		System.out.println("scenario failed");

		}
	}

}
