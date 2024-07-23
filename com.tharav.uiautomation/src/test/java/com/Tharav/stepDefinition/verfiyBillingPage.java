package com.Tharav.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;
import com.Tharav.pageObject.billingPage;
import com.Tharav.pageObject.dashboardPage;
import com.Tharav.pageObject.signup;

import Utilities.commonMethods;
import io.cucumber.java.en.*;

public class verfiyBillingPage {
	
	private static final Logger LOGGER = LogManager.getLogger(verfiyBillingPage.class);

	@Given("I open the tharav url in browser")
	public void i_open_the_tharav_url_in_browser() {
	try {
			
			driverManager.getDriver().get(constants.C_APP_URL);
			driverManager.getDriver().manage().window().maximize();
			driverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			LOGGER.info("Open the Tharav URL in Verfiy bililng page");

			
			
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());

		}
	}
	

	@And("I  enter the valid  <username> and <password> credentials")
	public void i_enter_the_valid_username_and_password_credentials() {
		try {
			signup.getInstance().enterEmail(constants.C_EMAIL);
			signup.signupInstance.enterPass(constants.C_PASSWORD);
			LOGGER.info("Entered the Username and Password in verfiy billing page");

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}
	@When("I click on signup")
	public void i_click_on_signup_button() {
	    try
	    {
	    	signup.getInstance().clickSignup();
			LOGGER.info("signin button clicked in Verify billing page");

	    }
	    catch(Exception e)
	    {
			LOGGER.error(e);
			Assert.fail(e.getMessage());


	    }
	}

	@When("verify  I am landed in dashboard  page")
	public void verify_i_am_landed_in_dashboard_page() {
		try {
			Thread.sleep(1000);
			String currenturl = driverManager.getDriver().getCurrentUrl();
			System.out.println(currenturl);
			if(currenturl.contains("dashboard"))
			{
			System.out.println("the user is in Dashboard page of Verify billing page");
			LOGGER.info("userlanded in dashboard page");

			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}
	
	@Then("I  click on Billing link")
	public void i_click_on_billing_link() {
		try
		{
				billingPage.getInstance().clickBillingMenu();
				LOGGER.info("Clicked the billing link of verify billing page");

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());

		}
		
	}

	@And("verfiy  I am in billing page")
	public void verfiy_i_am_in_billing_page() {
		try {
			Thread.sleep(1000);
			String currenturl = driverManager.getDriver().getCurrentUrl();
			System.out.println(currenturl);
			if(currenturl.contains("billing"))
			{
			System.out.println("the user is in billing Page of verify billing page");
			LOGGER.info("user is on  Billing page");

			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}

	@Then("I should see the billing page and text as {string}")
	public void i_should_see_the_billing_page_and_text_as(String exceptedMessage) {
     String actualMessage = billingPage.getInstance().getBillingText();	
		
		try {
			if( billingPage.getInstance().isVisibleBillingText() && (actualMessage.equalsIgnoreCase(exceptedMessage)))
			{
				System.out.println("User navigated to Billing Page page");
				LOGGER.info("landed on the Billing  page of verfiy billing page");

			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}
	
	@Given("verfiy i am in subscription tab")
	public void when_i_click_on_subscription_tab() {
	try {	
		if(billingPage.getInstance().isVisibleSubscriptiontab())
		{
			LOGGER.info("Subscription tab is visible in verfiy billing page");
		}
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());

		
	}
	   
	}

	@When("Verify  I can see company name as {string}")
	public void verify_I_can_see_company_name_as(String exceptedcompanyname) {
	try {	
		if(billingPage.getInstance().getCompanyNameText().equalsIgnoreCase(exceptedcompanyname))
		{
			LOGGER.info("I can see  company name : " + exceptedcompanyname);
		}
	}
	
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());

		
	}
	
	}

	@Then("I can click  on the contact sales to upgrade")
	public void i_should_click_on_the_contact_sales_to_upgrade() {

	try
	{
		billingPage.getInstance().clickContactSales();
		LOGGER.info("clicked the contact sales of verify billing page");
	}
	
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());

	}
	}

	@Given("when i click on usage tab")
	public void when_i_click_on_usage_tab() {
    try {
    	
    	billingPage.getInstance().clickUsage();
    	LOGGER.info("Clicked on the Usage tab of verify billing page");
        	
    	}
    catch(Exception e)
    {
    	LOGGER.error(e);
		Assert.fail(e.getMessage());

    }
        
	}

	@When("I Verify see  {string} and {string}")
	public void i_verify_see_and(String exceptedmsg1, String exceptedmsg2) {
	try
	{
		if(billingPage.getInstance().isVisibleDailyCredittext() && billingPage.getInstance().isVisibleYearlyCredittext())
		{
			LOGGER.info("Both the yearly and Daily credit text are visible in verify billing page");
		}
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());

	}

	}

	/*@Then("I select {string} and {string} from drop down")
	public void i_select_and_from_drop_down(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	



}
