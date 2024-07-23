package com.Tharav.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tharav.Drivermanager.driverManager;
import com.Tharav.constants.constants;

import Utilities.commonMethods;

public class UsermangementPage {
	
	private static UsermangementPage userInstance;
	
	WebDriver driver = driverManager.getDriver();
    public  WebDriverWait  wait;

	
	private UsermangementPage()
	{
		
	}
	public static UsermangementPage getInstance()
	{		
			if (userInstance == null)
			{
				userInstance= new UsermangementPage ();
				
			}
			return userInstance;
			
	}
	//button[contains(text(),'Create Role')]
	  By USERMANAGEMENT_MENU = By.xpath("//div[contains(text(),'User Management')]");
	  By CREATEROLEBUTTON = By.xpath("//button[contains(text(),'Create Role')]");
	  By UPDATEROLEBUTTON = By.xpath("//button[contains(text(),'Update Role')]");

	  
       By ROLENAME = By.xpath("//input[@placeholder='Enter Role Name']");
	  By ROLEDESCRIPTION = By.xpath("//textarea[@placeholder='Enter the Role Description']");
	  By SYSTEMROLE = By.xpath("//div[@class=' css-19bb58m']");
	  By SYSTEMINPUT = By.xpath("(//input[starts-with(@id,'react-select')])[1]");
	  By PERMISSIONINPUT = By.xpath("(//input[starts-with(@id,'react-select')])[2]");
	  By ROLESROWCOUNT = By.xpath("(//table[@class='p-3 w-100'])[1]//tr");
	  By ROLESCOLUMNCOUNT = By.xpath("(//table[@class='p-3 w-100'])[1]//tr/th");
	  //By ENTERROLENAMEALERT = By.xpath("//div[contains(text(),'Enter Role Name')]");	
	  By ENTERROLENAMEALERT = By.xpath("//div[@class='error-inlinetext']");
	  //By SYSTEMROLEALERT = By.xpath("(//div[@role='alert'])[1]/div/div/div");// xpath is changed 
	  By SYSTEMROLEALERT = By.xpath("//div[@class='error-inlinetext']");
	  By DELETESUBMENU = By.xpath("//ul[@class='dropdown-menu mt-n3 me-3 show']/li[3]");
	  By EDITSUBMENU = By.xpath("//ul[@class='dropdown-menu mt-n3 me-3 show']/li[2]");
	  By C_TOASTMESSAGE1 = By.xpath("//div[@class='col-11']");
	  
	  By C_USERMENU = By.xpath("//div[@class='btn-group']/button");
      By  C_LOGOUTLINK= By.xpath("//ul[@class='dropdown-menu show']/li[3]");
     // (//span[@class='slider round'])[1] 
      By SELECTALLPERMISSIONS = By.xpath("(//span[@class='slider round'])[1]");

	  
	  int rowcount,colcount; 
	 

// adding web driver wait code
	  
	  
	  public void isdisplaytoastMessage1()
      {
    	    wait = new WebDriverWait(driver, 50);
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(C_TOASTMESSAGE1));
    	    System.out.println(driver.findElement(C_TOASTMESSAGE1).getText());
    	    
    	    System.out.println(driver.findElement(C_TOASTMESSAGE1).isDisplayed());
	
      } 
     // public void clickUserMenu1()
      //{
  	 //   wait.until(ExpectedConditions.invisibilityOfElementLocated(C_TOASTMESSAGE));
  	 //   driver.findElement(C_USERMENU).click();
     // }
	  
	  

	  public void clickUsermangementMenu()
	  {
		  driver.findElement(USERMANAGEMENT_MENU).click();
	  }
	  public void clickCreateRole()
	  {
		  isdisplaytoastMessage1();
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(C_TOASTMESSAGE1));
		  driver.findElement(CREATEROLEBUTTON).click();
	  }
	  public void clickCreateRole1()
	  {
		  //isdisplaytoastMessage1();
		  //wait.until(ExpectedConditions.invisibilityOfElementLocated(C_TOASTMESSAGE1));
		  driver.findElement(CREATEROLEBUTTON).click();
	  }
	  public void clickUpdateRole()
	  {
		  driver.findElement(UPDATEROLEBUTTON).click();
	  }
	  public void enterRolename()
	  {
		  driver.findElement(ROLENAME).clear();
		  constants.ROLENAMERANDOM = commonMethods.randomString(7);
		  driver.findElement(ROLENAME).sendKeys(constants.ROLENAMERANDOM);
		 

		  	
		//  Actions act= new Actions(driver);
		   // act.moveByOffset(100, 100).click().build().perform();

	  }
	  public void enterRolenameInvalid(String rolename)
	  {
		  driver.findElement(ROLENAME).clear();
		  
		  if(rolename.equalsIgnoreCase("max"))
				  {
			  		constants.ROLENAMERANDOM = commonMethods.randomString(51);
			  		 driver.findElement(ROLENAME).sendKeys(constants.ROLENAMERANDOM);
				  }
		  else if(rolename.equalsIgnoreCase("min"))
		  {
			  constants.ROLENAMERANDOM = commonMethods.randomString(1);
		  		 driver.findElement(ROLENAME).sendKeys(constants.ROLENAMERANDOM);
		  }
		  else
		  {
			  driver.findElement(ROLENAME).sendKeys(rolename);
		  }
		  
	  }
	  public void enterRoleDescInvalid(String roledesc)
	  {
		  driver.findElement(ROLEDESCRIPTION).clear();
		  System.out.println("****************" + roledesc + "******************");
		  if(roledesc.equalsIgnoreCase("max"))
				  {
			  		constants.ROLENAMERANDOM = commonMethods.randomString(260);
			  		 driver.findElement(ROLEDESCRIPTION).sendKeys(constants.ROLENAMERANDOM);
				  }
		  else if(roledesc.equalsIgnoreCase("empty"))
		  {
			 // constants.ROLENAMERANDOM = commonMethods.randomString("");
		  		 driver.findElement(ROLEDESCRIPTION).sendKeys("");
		  }
		  else
		  {
			  driver.findElement(ROLEDESCRIPTION).sendKeys("This is test description");
		  }
		  
	  }
	  public void enterRoleDesc()
	  {
		  driver.findElement(ROLEDESCRIPTION).sendKeys("THIS IS TEST FROM UI");

	  }
	  public void updateRoleDesc()
	  {
		  driver.findElement(ROLEDESCRIPTION).clear();
		  driver.findElement(ROLEDESCRIPTION).sendKeys("THIS IS UPDATED ROLE DESCRIPTION");

	  }
	  public void enterSystemRole()
	  {
		  driver.findElement(SYSTEMINPUT).sendKeys("Product admin" + Keys.ENTER);
	  }
	  public void enterSystemRoleAccountAdmin(String systemRole)
	  {
		  driver.findElement(SYSTEMINPUT).sendKeys(systemRole + Keys.ENTER);
	  }
	  public void enterPermissions()
	  {
		  driver.findElement(PERMISSIONINPUT).sendKeys("View User" + Keys.ENTER);

	  }
	  public void enterAllPermissions()
	  {
		  driver.findElement(SELECTALLPERMISSIONS).click();
	  }
	  public int getRowCount()
	  {
		  rowcount = driver.findElements(ROLESROWCOUNT).size();
		  return rowcount;
		  
	  }
	  public int getColumnCount()
	  {
		  int colcount = driver.findElements(ROLESCOLUMNCOUNT).size();
		  return colcount;
	  }
	  
	  public void getrowvalues()
	  {
	  for(int i = 2; i<=rowcount;i++)
	    {
	    	for(int j = 1;j<=colcount-1;j++ )
	    	{
	    		String s = driverManager.getDriver().findElement(By.xpath("(//table[@class='p-3 w-100'])[1]//tr[" +(i)+ "]/td[" +(j)+ "]")).getText();
	    	}
	    }
	  }	
	  public String getrolenamealert()
	  {
		  return driver.findElement(ENTERROLENAMEALERT).getText();
	  }
	  
	  public String getSystemRoleAlert()
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driverManager.getDriver() , 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SYSTEMROLEALERT));
		  return driver.findElement(SYSTEMROLEALERT).getText();
	  }
	  public void clickDeleteSubMenu()
	  {
		  driver.findElement(DELETESUBMENU).click();
	  }
	  public void clickEditSubMenu()
	  {
		  driver.findElement(EDITSUBMENU).click();
	  }
	  public void clickUserMenu_users() throws InterruptedException
      {
  	    //wait.until(ExpectedConditions.invisibilityOfElementLocated(C_TOASTMESSAGE1));
		  Thread.sleep(1000);
  	    driver.findElement(C_USERMENU).click();
      }
      public void clickLogout_users() throws InterruptedException
      {
    	  WebDriverWait wait = new WebDriverWait(driverManager.getDriver() , 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(C_LOGOUTLINK));
    	  driver.findElement(C_LOGOUTLINK).click();
      }
	  

}
