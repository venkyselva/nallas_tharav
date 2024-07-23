package com.Tharav.Drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.Tharav.constants.constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverManager {
	
	
	public static WebDriver driver = null;
	
	public static void lauchBrowser()
	{
		

		try
		{
			//System.out.println(" broswer selected " + browseroption);
			switch(constants.C_BROWSER)
			{
			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				//LOGGER.info("Launching " +   constants.C_BROWSER );

				System.out.println("Chrome Browser OPEN");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("chrome.switches", "--disable-extensions");
				options.addArguments("--remote-allow-origins=*");
					try {
						driver = new ChromeDriver(options);
						} catch (Exception e) {
						e.printStackTrace();
						}
			break;
			case "firefox":
				
				System.out.println("Firefox browser  OPEN");
				WebDriverManager.firefoxdriver().setup();
				//LOGGER.info("Launching " + constants.C_BROWSER );

				FirefoxOptions optionsfox = new FirefoxOptions();
				try {
					driver = new FirefoxDriver(optionsfox);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				
				EdgeOptions optionsedge = new EdgeOptions();
				//LOGGER.info("Launching " + constants.C_BROWSER);
				driver = new EdgeDriver(optionsedge);
				break;
			default:
				WebDriverManager.chromedriver().setup();
				System.out.println("Chrome Browser OPEN default");
				ChromeOptions options1 = new ChromeOptions();
				//LOGGER.info("Launching " + constants.C_BROWSER);
				options1.addArguments("chrome.switches", "--disable-extensions");
				options1.addArguments("--remote-allow-origins=*");
					try {
						driver = new ChromeDriver(options1);
						} catch (Exception e) {
						e.printStackTrace();}
				break;		
				
			}				
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	

}
