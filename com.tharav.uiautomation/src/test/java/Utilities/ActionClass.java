package Utilities;

import org.openqa.selenium.By;

import com.Tharav.Drivermanager.driverManager;

public class ActionClass {
	
	
	public static void enterTextAction(By webelement, String text)
	{
		driverManager.getDriver().findElement(webelement).sendKeys(text);
	}

}
