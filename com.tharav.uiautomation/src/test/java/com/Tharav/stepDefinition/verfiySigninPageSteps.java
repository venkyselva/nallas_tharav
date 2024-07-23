package com.Tharav.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;
import com.Tharav.pageObject.dashboardPage;
import com.Tharav.pageObject.signup;

import io.cucumber.java.en.*;

public class verfiySigninPageSteps {
	
	
	private static final Logger LOGGER = LogManager.getLogger(verfiySigninPageSteps.class);
	
	//*********************Background which is common for all the scenario********************************************
    //Opens the Tharav URL
	@Given("user open  the URL")
	public void user_open_the_url() {

		try {
			
			LOGGER.info("Opening the Tharav URL in verfiy signin page");
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
    // Validate the visisblity of Tharav logo,Email textbox,Passoword textbox
	@Given("Validate the page is Tharav URL")
	public void validate_the_page_is_tharav_url() {
	try {
		if (signup.getInstance().isVisibleTharavLogo() && signup.getInstance().isVisibleEmailTextBox() && signup.getInstance().isVisiblePasswordTextBox())
		{
			LOGGER.info("Tharav logo, Email Text Box and Password Box is displayed in verify signin page");
		}
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}
	//**********************************************************************************************************
	//****************************Verify the user Sign in with valid credentials*****************************

	@When("^Enter the valid (.*) and (.*) credentials$")
	public void enter_the_valid_naliniadmin_nallas_com_and_tharav_credentials(String username,String password) {
	try
	{
		signup.getInstance().enterEmail(username);
		signup.getInstance().enterPass(password);
		LOGGER.info("Enter the Username and Password is displayed in verify signin page");

	
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	    
	}

	@When("click on the signin button")
	public void click_on_the_signin_button() {
		 try
		    {
		    	signup.getInstance().clickSignup();
				LOGGER.info("Entered the Signin button in verify signin page");

		    }
		    catch(Exception e)
		    {
				LOGGER.error(e);
				Assert.fail(e.getMessage());


		    }
	}

	@When("Verfiy i can see the dashboard page")
	public void verfiy_i_can_see_the_dashboard_page() {
		try {
			Thread.sleep(1000);
			String currenturl = driverManager.getDriver().getCurrentUrl();
			System.out.println(currenturl);
			if(currenturl.contains("dashboard"))
			{
			System.out.println("the user is in Dashboard page in verify signin page");
			}
			LOGGER.info("Verfiied the user in the Dashboard  in verify signin page");

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}

	@Then("Logout the Tharav application")
	public void logout_the_tharav_application() {
		try {
			dashboardPage.getInstance().isdisplaytoastMessage();
			dashboardPage.getInstance().clickUserMenu();
			dashboardPage.getInstance().clickLogout();
			LOGGER.info("logout the application in verify signin page" );

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}
    //*****************************************************************************************************************
	//*********************************Verfiy the user signin with invalid login credentials***************************

	@Then("^validate the login error (.*)$")
	public void validate_the_login_error(String actualMessage) {
		String exceptedMessage;
	try
	{
		Thread.sleep(1000);
		exceptedMessage = signup.getInstance().getSigninAlert();
		System.out.println(exceptedMessage);
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage.trim(),exceptedMessage.trim());

		if((actualMessage.trim()).equalsIgnoreCase(exceptedMessage.trim()))
		{
			LOGGER.info(exceptedMessage + "is Displayed in verify signin page");
			System.out.println(exceptedMessage + "is Displayed");
		}
		
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
		
	}

	@When("^Enter the Invalid (.*) and (.*) credentials$")
	public void enter_the_Invalid_nalinim_nallas_com_and_tharav_credentials(String username,String password) {
		try
		{
			signup.getInstance().enterEmail(username);
			signup.getInstance().enterPass(password);
			LOGGER.info("Invalid Username and password entered in in verify signin page");
		
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}
	//*******************Verify the user signin with invalid Email  login credentials of inline alert********************
	@And("^Validate the error inline alert (.*)$")
	public void validate_the_error_inline_alert(String actualMessage) {
		String exceptedMessage;
	try
	{
		//Thread.sleep(1000);
		exceptedMessage = signup.getInstance().getInlineAlert();
		System.out.println(exceptedMessage);
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage.trim(),exceptedMessage.trim());

		if((actualMessage.trim()).equalsIgnoreCase(exceptedMessage.trim()))
		{
			LOGGER.info(exceptedMessage + "is Displayed in verify signin page");
			System.out.println(exceptedMessage + "is Displayed");
		}
		
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	//***********************************Verify the Show and hide password functionality*******************************	
	}
	@And ("click on the show and Hide Icon")
	public void click_on_the_show_and_Hide_Icon() {
	try
	{
		//signup.getInstance().getPass(null);
		signup.getInstance().clickShowAndHideIcon();
		LOGGER.info("click on the  verify signin page");

	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}
	@Then ("^validate the user can show the text in password text (.*)$")
	public void validate_the_user_can_show_the_text_in_password_text(String actualpassword)
	{
		try {
			
			String exceptedpassword = signup.getInstance().getPasswordText();
			System.out.println(exceptedpassword);

			System.out.println(actualpassword);
			Assert.assertEquals(actualpassword.trim(),signup.getInstance().getPasswordText().trim());
			LOGGER.info("The excepted password and actual password matches  verify signin page");
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}
	//**********************************************************************************************************************
	
	



}
