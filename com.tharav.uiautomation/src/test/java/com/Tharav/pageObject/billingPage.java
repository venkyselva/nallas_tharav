package com.Tharav.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tharav.Drivermanager.driverManager;

public class billingPage {
	
	private static billingPage billInstance;
	WebDriver driver = driverManager.getDriver();
    public  WebDriverWait  wait;
	
	public billingPage()
	{
		
	}
	public static billingPage getInstance()
	{
		if (billInstance == null)
		{
			billInstance = new billingPage();
		}
	return billInstance;
	}
	
	By C_BILLING_MENU = By.xpath("//div[contains(text(),'Billing')]");
	By C_BILLING_TEXT = By.xpath("//h4[contains(text(),'Billing')]");
	By C_SUBSCRIPTION = By.xpath("//button[contains(text(),'Subscription')]");
	By C_USAGE = By.xpath("//button[contains(text(),'Usage')]");
	By C_INVOICE = By.xpath("//button[contains(text(),'Invoice')]");
	By C_COMPANYNAME = By.xpath("//div[contains(text(),'Datacat')]"); //the company name is already datacat given, not fetched from database
	By C_CONTACTSALES = By.xpath("//button[contains(text(),'Contact Sales')][1]");
	By C_YEARLYCREDIT = By.xpath("//div[contains(text(),'Yearly Credit')]");
	By C_DAILYCREDIT = By.xpath("//div[contains(text(),'Daily Credit')]");

	
	
	public void clickBillingMenu()
	{
		driver.findElement(C_BILLING_MENU).click();
	}
	 public boolean isVisibleBillingText()
     {
     
   	  return driver.findElement(C_BILLING_TEXT).isDisplayed();
        
     }
	 public void  clickSubscription()
	 {
		 driver.findElement(C_SUBSCRIPTION).click();
	 }
	 public boolean isVisibleSubscriptiontab()
	 {
		 return driver.findElement(C_SUBSCRIPTION).isDisplayed();
	 }
	 public boolean isVisibleInvoicetab()
	 {
		 return driver.findElement(C_INVOICE).isDisplayed();
	 }
	 public boolean isVisibleUsagetab()
	 {
		 return driver.findElement(C_USAGE).isDisplayed();
	 }
	 public void  clickUsage()
	 {
		 driver.findElement(C_USAGE).click();
	 }
	 public void  clickInvoice()
	 {
		 driver.findElement(C_INVOICE).click();
	 }
	 public String getBillingText()
     {
     
   	  return driver.findElement(C_BILLING_TEXT).getText();
        
     }
	 public String getCompanyNameText()
     {
     
   	  return driver.findElement(C_COMPANYNAME).getText();
        
     }
	public void clickContactSales()
	{
		driver.findElement(C_CONTACTSALES).click();
	}
	public boolean isVisibleDailyCredittext()
	{
		return driver.findElement(C_DAILYCREDIT).isDisplayed();
	}
	public boolean isVisibleYearlyCredittext()
	{
		return driver.findElement(C_YEARLYCREDIT).isDisplayed();
	}
	
	
	

}
