package com.Tharav.stepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;
import com.Tharav.pageObject.UsermangementPage;
import com.Tharav.pageObject.dashboardPage;
import com.Tharav.pageObject.signup;

import io.cucumber.java.en.*;

public class verifyUserManagementSteps {
	
	private static final Logger LOGGER = LogManager.getLogger(verifyUserManagementSteps.class);
	int dynamicRowCount,dynamicColCount;
	
	//********************Background steps************************************************************
	@Given("user open  the URL for UserManagement")
	public void user_open_the_url_for_UserManagement() {

		try {
			
			LOGGER.info("Opening the Tharav URL in from User management steps");
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
	@Given("Validate the page is Tharav URL for UserManagement")
	public void validate_the_page_is_tharav_url_for_UserManagement() {
	try {
		if (signup.getInstance().isVisibleTharavLogo() && signup.getInstance().isVisibleEmailTextBox() && signup.getInstance().isVisiblePasswordTextBox())
		{
			LOGGER.info("Tharav logo, Email Text Box and Password Box is displayed from User management steps");
		}
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}

	
	
	@Given("Login in the application with valid credentials")
	public void login_in_the_application_with_valid_credentials() {
		try {
			signup.getInstance().enterEmail(constants.C_EMAIL);
			signup.signupInstance.enterPass(constants.C_PASSWORD);
			LOGGER.info("Entered the username and password in verfiy user management steps");
			signup.getInstance().clickSignup();
			LOGGER.info("Click on signin button in verfiy user management steps");
			LOGGER.info("Login in the application with valid credentials");


		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	}

	@And("click on the UserMangement menu")
	public void click_on_the_user_mangement_menu() {
		
		UsermangementPage .getInstance().clickUsermangementMenu();
		LOGGER.info("Clicked  User Management Menu in verfiy user management steps");
		LOGGER.info("click on the UserMangement menu");


	}

	@Then("Validate  I can see the usermanagement page")
	public void validate_i_can_see_the_usermanagement_page() throws InterruptedException {
		LOGGER.info("verfiy that i can see in user management steps");
		LOGGER.info("Validate  I can see the usermanagement page");
		Thread.sleep(1000);

	}

	@When("click on the create role button")
	public void click_on_the_create_role_button() throws InterruptedException {
		
		System.out.println("**************************");
		Thread.sleep(2000);
		UsermangementPage .getInstance().clickCreateRole();
		LOGGER.info("Click on Create role button in user Management steps");
		LOGGER.info("click on the create role button");

	    
	}

	@And("Enter the valid Rolename")
	public void enter_the_valid_Rolename() {
		
		UsermangementPage .getInstance().enterRolename();

		LOGGER.info("Rolename is entered in user Management steps");


	}
	@And("Enter the valid Role Description")
	public void enter_the_valid_Role_Description() {
		

		UsermangementPage .getInstance().enterRoleDesc();

		LOGGER.info("Role description is entered in user Management steps");


	}

	@And("Select the system role")
	public void select_the_system_role() {
		try
		{
			UsermangementPage.getInstance().enterSystemRole();
			LOGGER.info("System Role is entered in user Management steps");

	    }
		 	
		 catch(Exception e)
	     {
	        LOGGER.error(e);

	    }
	}
	@And("^Select the system role of all roles (.*)$")
	public void select_the_system_role_all_roles(String Systemrole) {
		try
		{
			UsermangementPage.getInstance().enterSystemRoleAccountAdmin(Systemrole);
			LOGGER.info("System Role is entered in user Management steps");

	    }
		 	
		 catch(Exception e)
	     {
	        LOGGER.error(e);

	    }
	}

	@And("select the permissions")
	public void select_the_permissions() {
		try
		{
			UsermangementPage.getInstance().enterPermissions();
			LOGGER.info("permission is selected in user Management steps");

	    }
		 	
		 catch(Exception e)
	     {
	        LOGGER.error(e);

	    }

	}
	@And("select all the permissions")
	public void select_all_the_permissions() {
		try
		{
			UsermangementPage.getInstance().enterAllPermissions();;
			LOGGER.info("permission is selected in user Management steps");

	    }
		 	
		 catch(Exception e)
	     {
	        LOGGER.error(e);

	    }

	}

	@And("click on the create role button to save the role")
	public void click_on_the_create_role_button_to_save_the_role() {
	try {
		
		UsermangementPage .getInstance().clickCreateRole1();
		LOGGER.info("Click on Create role button in user Management steps");
	}
	catch(Exception e)
	{
		LOGGER.error(e);
	}
		

	}

	@Then("validate the role name is in the list")
	public void validate_the_role_name_is_in_the_list() {
		System.out.println("______________________");
		int rowcount = UsermangementPage.getInstance().getRowCount();
	    int colcount = UsermangementPage.getInstance().getColumnCount();
	    boolean flag = false;
	    
	    System.out.println("Row count and coulunm count " + rowcount +"   " + colcount);
	    
	    for(int i = 2; i<=rowcount;i++)
	    {
	    	for(int j = 1;j<=colcount-1;j++ )
	    	{
	    		//String s = (driverManager.getDriver().findElement("(//table[@class='p-3 w-100'])[1]//tr[" +(i)+ "]/td[" +(j)+ "]");
	    		String exceptedstring = driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[1]//tr[" +(i)+ "]/td[" +(j)+ "]")).getText();
	    		System.out.print(exceptedstring + "   " );
	    		if(exceptedstring.trim().equalsIgnoreCase(constants.ROLENAMERANDOM))
	    		{
	    		     flag = true;	
	    		     Assert.assertEquals(exceptedstring, constants.ROLENAMERANDOM);
	    		     LOGGER.info("The role name is present in the table in user Management steps");
	    		     dynamicRowCount = i;
	    		     dynamicColCount = j;
	    		     break;
	    		}
    		System.out.println("clicking teh menu");
    		
        }
	}
}
	
	//*********************************Negative Scenario *********************************************************

	@Then("^Enter the invalid rolename (.*)$")
	public void Enter_the_invalid_rolename (String invalidrolename) {
		
		UsermangementPage.getInstance().enterRolenameInvalid(invalidrolename);
		LOGGER.info("invalid rolename is entered in user Management steps");

	}
	 @And ("^Enter the Invalid Role Description (.*)$")
	 public void Enter_the_Invalid_Role_Description(String invalidroleDesc)
	 {
		 System.out.println("&&&&&&&&&&&&&&&&&& "+ invalidroleDesc + "&&&&&&&&&&&&&&&&&&&" );
		 UsermangementPage.getInstance().enterRoleDescInvalid(invalidroleDesc);
		LOGGER.info("invalid rolename is entered in user Management steps");
	 }
	@And("^validate the  inlinealert with the (.*)$")
	public void validate_the_inlinealert_with_the(String actualMessage) {
		String exceptedMessage;
	try
	{
		System.out.println(actualMessage);
		exceptedMessage = UsermangementPage.getInstance().getrolenamealert();
		System.out.println(exceptedMessage);
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage.trim(),exceptedMessage.trim());
		//LOGGER.info("invalid rolename is entered in user Management steps");


		if((actualMessage.trim()).equalsIgnoreCase(exceptedMessage.trim()))
		{
			LOGGER.info(exceptedMessage + "is Displayed in user Management steps");
			System.out.println(exceptedMessage + "is Displayed");
		}
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}
	
	
	@And("^validate the  inlinealert of systemrole with the (.*)$")
	public void validate_the_inlinealert_of_systemrole_with_the(String actualMessage) {
		String exceptedMessage;
	try
	{
		System.out.println(" Actual message" + actualMessage);
		
		Thread.sleep(1000);
		exceptedMessage = UsermangementPage.getInstance().getSystemRoleAlert();
		System.out.println("Excepted message" + exceptedMessage);
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage.trim(),exceptedMessage.trim());
		//LOGGER.info("invalid rolename is entered in user Management steps");


		if((actualMessage.trim()).equalsIgnoreCase(exceptedMessage.trim()))
		{
			LOGGER.info(exceptedMessage + "is Displayed in user Management steps");
			System.out.println(exceptedMessage + "is Displayed");
		}
	}
	catch(Exception e)
	{
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}
	
	@Then("click on the Delete option")
	public void click_on_the_Delete_option() throws InterruptedException {
	driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[1]//tr[" +(dynamicRowCount)+ "]/td[" +(5)+ "]")).click();
	 UsermangementPage.getInstance().clickDeleteSubMenu();
	 String Mainwindow = driverManager.getDriver().getWindowHandle();
	 //Thread.sleep(1000);
	 driverManager.getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-sm modal-dialog-centered']"));
	 WebElement deletepopup = driverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Delete')]//following:: input"));
	 deletepopup.sendKeys(constants.RANDOMSTRING);
	 WebElement buttondelete = driverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]"));
	 buttondelete.click();
		Thread.sleep(1000);

	// WebDriverWait wait = new WebDriverWait(driverManager.getDriver() , 70);
	//	wait.until(ExpectedConditions.alertIsPresent());
//	Alert alert = driverManager.getDriver().switchTo().alert();
	
	
	
	 
	 // windows handle
	 
	 
	 /*Set <String> s1 = driverManager.getDriver().getWindowHandles();
	 System.out.println(Mainwindow);
	 Iterator <String> i1 = s1.iterator();
	 
	 while (i1.hasNext())
	 {
		 String ChildWindow = i1.next();
		 System.out.println(ChildWindow);

		 if(!Mainwindow.equalsIgnoreCase(ChildWindow))
		 {
			 driverManager.getDriver().switchTo().window(ChildWindow);
			 System.out.println(ChildWindow);

			 WebElement deletepopup1 = driverManager.getDriver().findElement(By.xpath("//input[@placeholder='Delete']"));
			 deletepopup1.sendKeys("DELETE");
			 WebElement buttondelete1 = driverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]"));
			 buttondelete1.click();
		 }
	 }*/
	 
	 
	 
//	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	//WebElement popup = driverManager.getDriver().findElement(By.xpath("//input[@placeholder='Delete']"));
	//alert.sendKeys("DELETE");
	// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

	//WebElement popup1 = driverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]"));
	// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

    // alert.accept();
    // popup1.click();
	}
	
	 @And ("click on the update option")
	 public void click_on_the_update_option()
	 {
		 driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[1]//tr[" +(dynamicRowCount)+ "]/td[" +(5)+ "]")).click();
		 UsermangementPage.getInstance().clickEditSubMenu();
	 }
	 @And("update the Role description and role name")
	 public void update_the_Role_description_and_role_name()
	 {
		 UsermangementPage.getInstance().enterRolename();
		 UsermangementPage.getInstance().updateRoleDesc();
 
	 }
	 @And("click on the update role button to save the role")
		public void click_on_the_update_role_button_to_save_the_role() {
		try {
			
			UsermangementPage .getInstance().clickUpdateRole();
			LOGGER.info("Click on update role button in user Management steps");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			LOGGER.error(e);
		}
	 }
	 
	 @And("logout of the Tharav application")
		public void logout_of_the_Tharav_application() {
		try {
			
			
			UsermangementPage.getInstance().clickUserMenu_users();
			UsermangementPage.getInstance().clickLogout_users();
		
			LOGGER.info("logout the application in - Users Management");

		}
		catch(Exception e)
		{
			LOGGER.error(e);
			Assert.fail(e.getMessage());


		}
	 }
	
	
	
}
	

	

