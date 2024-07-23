package com.Tharav.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;

import Utilities.ActionClass;
import Utilities.commonMethods;

public class CreateUserPage {
	
	private static CreateUserPage userInstance;
	WebDriver driver = driverManager.getDriver();
    public  WebDriverWait  wait;
    public static String email;
    

	
	private CreateUserPage()
	{
		
	}
	public static CreateUserPage getInstance()
	{		
			if (userInstance == null)
			{
				userInstance= new CreateUserPage  ();
				
			}
			return userInstance;
			
	}
	
	

	By USERFIRSTNAME = By.xpath("//input[@placeholder='Enter First Name']");
	By USERLASTNAME= By.xpath("//input[@placeholder='Enter Last Name']");
	By USEREMAIL = By.xpath("//input[@placeholder='Enter User Email-Id']");
	By SYSTEMROLE = By.xpath("(//input[starts-with(@id,'react-select')])[1]");
	By ROLE = By.xpath("(//input[starts-with(@id,'react-select')])[2]");
	By CREATEUSER = By.xpath("	");
    By UPDATEUSERBUTTON = By.xpath("//button[contains(text(),'Update User')]");

	By USERTAB = By.xpath("//button[contains(text(),'Users')]");
	By USERSCREENALERT = By.xpath("//div[@class='error-inlinetext']");
	
    By USERROWCOUNT = By.xpath("(//table[@class='p-3 w-100'])[2]//tr");
	By USERCOLUMNCOUNT = By.xpath("(//table[@class='p-3 w-100'])[2]//tr/th");
	
	By DELETEUSERSUBMENU = By.xpath("//ul[@class='dropdown-menu mt-n3 me-3 show']/li[3]");
	 By EDITUSERSUBMENU = By.xpath("//ul[@class='dropdown-menu mt-n3 me-3 show']/li[2]");
	
	int userrowcount,usercolcount; 
	 
	
	public void clickusertab()
	{
		  driver.findElement(USERTAB).click();

	}
	
	public void clickCreateUser()
	  {
		  driver.findElement(CREATEUSER).click();
	  }
	
	public void enterFirstName()
	{
		 driver.findElement(USERFIRSTNAME).clear();
		  constants.ROLENAMERANDOM = commonMethods.randomString(7);
		  driver.findElement(USERFIRSTNAME).sendKeys(constants.ROLENAMERANDOM);
		 		
	}
	public void enterLastName()
	{
		 driver.findElement(USERLASTNAME).clear();
		  constants.ROLENAMERANDOM = commonMethods.randomString(7);
		  driver.findElement(USERLASTNAME).sendKeys(constants.ROLENAMERANDOM);
		 		
	}
	public void enterEmail()
	{
		driver.findElement(USEREMAIL).clear();
		  constants.ROLENAMERANDOM = commonMethods.randomString(7);
		  email = constants.ROLENAMERANDOM+"@nallas.com";
		  System.out.println(email);
		  driver.findElement(USEREMAIL).sendKeys(email);
	}
	 public void enterSystemRole()
	  {
		  driver.findElement(SYSTEMROLE).sendKeys("Product admin" + Keys.ENTER);
	  }
	  public void enterPermissions()
	  {
		  driver.findElement(ROLE).sendKeys("u" + Keys.ENTER);

	  }
	  
	  public void enterFirstnameInvalid(String firstname)
	  {
		  driver.findElement(USERFIRSTNAME).clear();
		  
		  if(firstname.equalsIgnoreCase("max"))
				  {
			  		constants.ROLENAMERANDOM = commonMethods.randomString(31);
			  		 driver.findElement(USERFIRSTNAME).sendKeys(constants.ROLENAMERANDOM);
				  }
		  else if(firstname.equalsIgnoreCase("min"))
		  {
			  constants.ROLENAMERANDOM = commonMethods.randomString(1);
		  		 driver.findElement(USERFIRSTNAME).sendKeys(constants.ROLENAMERANDOM);
		  }
		  else
		  {
			  driver.findElement(USERFIRSTNAME).sendKeys("");
		  }
		  
	  }
	  
	  public void enterLastnameInvalid(String lastname)
	  {
		  driver.findElement(USERFIRSTNAME).clear();
		  
		  if(lastname.equalsIgnoreCase("max"))
				  {
			  		constants.ROLENAMERANDOM = commonMethods.randomString(31);
			  		 driver.findElement(USERLASTNAME).sendKeys(constants.ROLENAMERANDOM);
				  }
		  else if(lastname.equalsIgnoreCase("min"))
		  {
			  constants.ROLENAMERANDOM = commonMethods.randomString(1);
		  		 driver.findElement(USERLASTNAME).sendKeys(constants.ROLENAMERANDOM);
		  }
		  
		  
	  }
	  public void enteremailnvalid(String Invalidemail)
	  {
		  driver.findElement(USEREMAIL).clear();
		  driver.findElement(USEREMAIL).sendKeys(Invalidemail);
		  
	  }
	  public String getFirstnamealert()
	  {
		  return driver.findElement(USERSCREENALERT).getText();
	  }
	  public int getRowCount()
	  {
		  userrowcount = driver.findElements(USERROWCOUNT).size();
		  return userrowcount;
		  
	  }
	  public int getColumnCount()
	  {
		  int usercolcount = driver.findElements(USERCOLUMNCOUNT).size();
		  return usercolcount;
	  }
	  public void clickUserDeleteSubMenu()
	  {
		  driver.findElement(DELETEUSERSUBMENU).click();
	  }
	  public void clickUserEditSubMenu()
	  {
		  driver.findElement(EDITUSERSUBMENU).click();
	  }
	  public void clickUpdateUser()
	  {
		  driver.findElement(UPDATEUSERBUTTON).click();
	  }

	
	

}
