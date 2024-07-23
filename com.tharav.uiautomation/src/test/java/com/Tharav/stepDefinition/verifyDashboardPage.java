package com.Tharav.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;
import com.Tharav.pageObject.signup;

import Utilities.commonMethods;

import com.Tharav.pageObject.dashboardPage;


import io.cucumber.java.en.*;

public class verifyDashboardPage {
	
	//signup sign_up = new signup();
	
	private static final Logger LOGGER = LogManager.getLogger(verifyDashboardPage.class);


	@Given("I open the tharav url")
	public void i_open_the_tharav_url() {
		
		try {
			
			LOGGER.info("Opening the Tharav URL in Verfiy Dashboard Page");
			driverManager.getDriver().get(constants.C_APP_URL);
			driverManager.getDriver().manage().window().maximize();
			driverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}

	@And("I enter the valid  username and password")
	public void i_enter_the_valid_username_and_password() {
		
		try {
			signup.getInstance().enterEmail(constants.C_EMAIL);
			signup.signupInstance.enterPass(constants.C_PASSWORD);
			LOGGER.info("Entered the username and password in Verfiy Dashboard Page");

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}
	@Given("I click on signup button")
	public void i_click_on_signup_button() {
	    try
	    {
	    	signup.getInstance().clickSignup();
			LOGGER.info("Entered the Signin button in Verfiy Dashboard Page");

	    }
	    catch(Exception e)
	    {
			LOGGER.error(e);
			Assert.fail(e.getMessage());


	    }
	}
	

	@When("verify  I am in  Dashboard page")
	public void verify_i_am_in_dashboard_page() {
		try {
			Thread.sleep(1000);
			String currenturl = driverManager.getDriver().getCurrentUrl();
			System.out.println(currenturl);
			if(currenturl.contains("dashboard"))
			{
			System.out.println("the user is in Dashboard page");
			}
			LOGGER.info("Verfiied the user in the Dashboard in Verfiy Dashboard Page");

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
		 

	}
	   

	@Then("I  should see the dashboard page details and text as {string}")
	public void i_should_see_the_dashboard_page_details_and_text_as(String exceptedMessage) {
		
		
		String actualMessage = dashboardPage.getInstance().getDashboardText();	
		
		try {
			if( dashboardPage.getInstance().isVisibleDahboardText() && (actualMessage.equalsIgnoreCase(exceptedMessage)))
			{
				System.out.println("User landed on dashboard page");
				LOGGER.info("landed on the dashboard page in Verfiy Dashboard Page");

			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	    

}
	
	

	@And("logout of the application")
	public void logout_of_the_application() {
	try {
		dashboardPage.getInstance().isdisplaytoastMessage();
		dashboardPage.getInstance().clickUserMenu();
		dashboardPage.getInstance().clickLogout();
		LOGGER.info("logout the application in Verfiy Dashboard Page");

	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());


	}
	}

}
