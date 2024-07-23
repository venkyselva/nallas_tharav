package com.Tharav.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;
import com.Tharav.pageObject.CreateUserPage;
import com.Tharav.pageObject.UsermangementPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class verifyCreateUser {
	
	
	
	private static final Logger LOGGER = LogManager.getLogger(verifyCreateUser.class);
	int dynamicRowCount,dynamicColCount;

	
	@When("click on the create user button")
	public void click_on_the_create_user_button() {
		
		try
		{
		CreateUserPage.getInstance().clickusertab();
		Thread.sleep(1000);
		CreateUserPage.getInstance().clickCreateUser();
		}
		catch(Exception e)
		{
			LOGGER.error(e);
		}
		
	}

	@When("Enter the valid Firstname")
	public void enter_the_valid_firstname() {
		try {
		CreateUserPage.getInstance().enterFirstName();}
		catch(Exception e)
		{
			LOGGER.error(e);
		}
	    
	}

	@When("Enter the valid Lastname")
	public void enter_the_valid_lastname() {
		try {
		CreateUserPage.getInstance().enterLastName();}
		catch(Exception e)
		{
			LOGGER.error(e);
		}

	}

	@When("Enter the Email - id")
	public void enter_the_email_id() {
		try {
		CreateUserPage.getInstance().enterEmail();}
		catch(Exception e)
		{
			LOGGER.error(e);
		}

	}

	@When("Enter the SystemRole")
	public void enter_the_system_role() {
		try {
		CreateUserPage.getInstance().enterSystemRole();}
		catch(Exception e)
		{
			LOGGER.error(e);
		}
		

	}

	@When("Enter the Role")
	public void enter_the_role() {
		try {
		CreateUserPage.getInstance().enterPermissions();}
		catch(Exception e)
		{
			LOGGER.error(e);
		}

	}

	@When("click on the create user button to save the user")
	public void click_on_the_create_user_button_to_save_the_user() {
		try {
		CreateUserPage.getInstance().clickCreateUser();}
		catch(Exception e)
		{
			LOGGER.error(e);
		}

	}
	@Then("validate the User name is in the list")
	public void validate_the_user_name_is_in_the_list() {
		System.out.println("______________________");
		int rowcount = CreateUserPage.getInstance().getRowCount();
	    int colcount = CreateUserPage.getInstance().getColumnCount();
	    boolean flag = false;
	    
	    System.out.println("Row count and coulunm count " + rowcount +"   " + colcount);
	    String validEmail = CreateUserPage.getInstance().email;
		System.out.println("randowmstring +     " + validEmail);
	    for(int i = 2; i<=rowcount;i++)
	    {
	    	for(int j = 1;j<=colcount-1;j++ )
	    	{
	    		//String s = (driverManager.getDriver().findElement("(//table[@class='p-3 w-100'])[1]//tr[" +(i)+ "]/td[" +(j)+ "]");
	    		String exceptedstring = driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[2]//tr[" +(i)+ "]/td[" +(j)+ "]")).getText();
	    		System.out.print(exceptedstring + "   " );
	    		
	    		
	    		if(exceptedstring.trim().equalsIgnoreCase(validEmail))
	    		{
	    		     flag = true;	
	    		     Assert.assertEquals(exceptedstring,validEmail);
	    		     
	    		     LOGGER.info("The role name is present in the table in user Management steps");
	    		     dynamicRowCount = i;
	    		     dynamicColCount = j;
	    		     break;
	    		}
    		System.out.println("");
    		
        }
	}
	}
	
	@And("click on the Delete option of user")
	public void click_on_the_Delete_option_of_user() throws InterruptedException {
	driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[2]//tr[" +(dynamicRowCount)+ "]/td[" +(5)+ "]")).click();
	 CreateUserPage.getInstance().clickUserDeleteSubMenu();
	 //String Mainwindow = driverManager.getDriver().getWindowHandle();
	 //Thread.sleep(1000);
	 driverManager.getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-sm modal-dialog-centered']"));
	 WebElement deletepopup = driverManager.getDriver().findElement(By.xpath("//input[@placeholder='Delete']"));
	 deletepopup.sendKeys("DELETE");
	 WebElement buttondelete = driverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]"));
	 buttondelete.click();
	 Thread.sleep(1000);
	}
	//*****************************Negative Testing *******************************************
	@And("^Enter the invalid Firstname (.*)$")
	public void Enter_the_invalid_Firstname (String invalidFirstname) {
		
		CreateUserPage.getInstance().enterFirstnameInvalid(invalidFirstname);
		LOGGER.info("invalid rolename is entered in user Management steps");

	}
	@And("^Enter the invalid Lastname (.*)$")
	public void Enter_the_invalid_Lastname (String invalidLastname) {
		
		CreateUserPage.getInstance().enterLastnameInvalid(invalidLastname);
		LOGGER.info("invalid rolename is entered in user Management steps");

	}
	@And("^Enter the invalid Emailid (.*)$")
	public void Enter_the_invalid_Emailid (String invalidemail) {
		
		CreateUserPage.getInstance().enteremailnvalid(invalidemail);
		LOGGER.info("invalid rolename is entered in user Management steps");

	}
	 
	@And("^validate the inlinealerts with the (.*)$")
	public void validate_the_inlinealerts_with_the (String actualMessage) {
		String exceptedMessage;
	try
	{
		System.out.println("Actual Message" +actualMessage);
		exceptedMessage = CreateUserPage.getInstance().getFirstnamealert();
		System.out.println("Excepted Message" + exceptedMessage);
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
	 @Then("click on the Edit option of user")
	 public void click_on_the_Edit_option_of_user()
	 {
		 try
			{
			driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[2]//tr[" +(dynamicRowCount)+ "]/td[" +(5)+ "]")).click();

			CreateUserPage.getInstance().clickUserEditSubMenu();
			}
			catch(Exception e)
			{
				LOGGER.error(e);
			} 
	 }
	   @And ("update the Firstname and Lastname")
	   public void update_the_Firstname_and_Lastname()
	   {
		   try {
			   CreateUserPage.getInstance().enterFirstName();
			   CreateUserPage.getInstance().enterLastName();
			   
		   }
		   catch(Exception e)
			{
				LOGGER.error(e);
			} 
	   }
	   @And ("click on the update user button to save the role")
	   public void click_on_the_update_user_button_to_save_the_role()
	   {
		   try {
			   CreateUserPage.getInstance().clickUpdateUser();
			   Thread.sleep(1000);
		   }
		   catch(Exception e)
			{
				LOGGER.error(e);
			}   
	   }
	

}
