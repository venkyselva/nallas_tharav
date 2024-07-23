package com.Tharav.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tharav.Drivermanager.driverManager;

public class dashboardPage {
	
	private static dashboardPage dashInstance;
	WebDriver driver = driverManager.getDriver();
    public  WebDriverWait  wait;

	
	private dashboardPage()
	{
		
	}
	public static dashboardPage getInstance()
	{		
			if (dashInstance == null)
			{
				dashInstance = new dashboardPage();
				
			}
			return dashInstance;
			
		}
	
	  By DASHBOARD_TEXT = By.xpath("//h4[contains(text(),'Dashboard')]");
	  By C_TOASTMESSAGE = By.xpath("//div[@class='col-11']");
	  By C_USERMENU = By.xpath("//div[@class='btn-group']/button");
      By  C_LOGOUTLINK= By.xpath("//ul[@class='dropdown-menu show']/li[3]");
      
      
      public boolean isVisibleDahboardText()
      {
      
    	  return driver.findElement(DASHBOARD_TEXT).isDisplayed();
         
      }
      public String getDashboardText()
      {
      
    	  return driver.findElement(DASHBOARD_TEXT).getText();
         
      }
      public void isdisplaytoastMessage()
      {
    	    wait = new WebDriverWait(driver, 50);
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(C_TOASTMESSAGE));
    	    System.out.println(driver.findElement(C_TOASTMESSAGE).getText());
    	    
    	    System.out.println(driver.findElement(C_TOASTMESSAGE).isDisplayed());
	
      } 
      public void clickUserMenu()
      {
  	    wait.until(ExpectedConditions.invisibilityOfElementLocated(C_TOASTMESSAGE));
  	    driver.findElement(C_USERMENU).click();
      }
      public void clickLogout() throws InterruptedException
      {
    	  Thread.sleep(1000);
    	  driver.findElement(C_LOGOUTLINK).click();
      }
      
      
      
}	
	
