package com.Tharav.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Tharav.Drivermanager.driverManager;


public class signup {
	
	public static signup signupInstance;
	
	private signup()
	{
		
	}
	//Instatiate a singleton pattern
	public static signup getInstance()
	{
		if (signupInstance  == null) 
		{
			signupInstance = new signup();
			
		}
		return signupInstance;
	}
	
	//Initilize the webelemnts by using by locator
	
	By C_SIGNINTEXT = By.xpath("//h1[contains(text(),'Sign In')]");
	By EMAILLABEL = By.xpath("//h5[contains(text(),'Email')]");
	By EMAIL = By.xpath("//input[@id='signin-email']");
	By PASSWORDLABEL = By.xpath("//h5[contains(text(),'Password')]");
	By PASSWORD = By.xpath("//input[@id='signin-password']");
	By C_SIGNUPBUTTON = By.xpath("//button[@aria-label='Sign In']");
	By C_THARAVLOGO = By.xpath("//img[@class='logo ms-3']");
	By C_SIGNINALERT = By.xpath("(//div[@role='alert'])[2]");
	By C_ENTERVALIDEMAILALERT = By.xpath("//div[contains(text(),'Enter')]");
	By C_SHOWANDHIDEICON = By.xpath("//div[@class='position-absolute pe-3 end-0']/span");
	By C_REGISTERLINK = By.xpath("//a[contains(text(),'Register')]");
	
	WebDriver driver = driverManager.getDriver();
	// write actions
	
     public void enterEmail(String email)
     {
    	 try {
    		 driver.findElement(EMAIL).clear();
    		 driver.findElement(EMAIL).sendKeys(email);
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     public void enterPass(String pass)
     {
    	 try {
    		 driver.findElement(PASSWORD).clear();
    		 driver.findElement(PASSWORD).sendKeys(pass);
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
    public void getPass()
     {
    	 try {
    		
    		 System.out.println("Password " +  driver.findElement(PASSWORD).getText());
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     public void clickSignup()
     {
    	 try {
    		 driver.findElement(C_SIGNUPBUTTON).click();
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     public boolean isVisibleTharavLogo()
     {
    	 boolean isvisible=true;
    	 try {
    		  isvisible= driver.findElement(C_THARAVLOGO).isDisplayed();
    		
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return isvisible; 
     }
     public String getSigninAlert()
     {
    	 String alertMessage = null;
    	 try
    	 {
    		 alertMessage = driver.findElement(C_SIGNINALERT).getText();
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return alertMessage;
     }
     public String getInlineAlert()
     {
    	 String alertMessage = null;
    	 try
    	 {
    		 alertMessage = driver.findElement(C_ENTERVALIDEMAILALERT).getText();
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return alertMessage;
     }
     public boolean isVisibleEmailTextBox()
     {
    	 boolean isVisible= true;
    	 try
    	 {
    		 isVisible = driver.findElement(EMAIL).isDisplayed();
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return isVisible;
     }
     public boolean isVisiblePasswordTextBox()
     {
    	 boolean isVisible= true;
    	 try
    	 {
    		 isVisible = driver.findElement(PASSWORD).isDisplayed();
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return isVisible;
     }
     public void clickShowAndHideIcon()
     {
    	 //String pass=null;
    	 try
    	 {
    		 //getPass();
    		 driver.findElement(C_SHOWANDHIDEICON).click();

    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     public String getPasswordText()
     {
    	 String pass=null;
    	 try
    	 {
    		 //Thread.sleep(1000);
    		
    		// System.out.println("get Arrtibute "+ driver.findElement(PASSWORD).getAttribute("value"));
    		 pass = driver.findElement(PASSWORD).getAttribute("value");
 			System.out.println("pass" + pass);


    	 }
    	 catch(Exception e)
    	 {	
    		 e.printStackTrace();
    	 }
    	 return pass;
     }
     
 }
