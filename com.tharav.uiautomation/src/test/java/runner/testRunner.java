package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		features = "src/test/resources" ,
		glue ="com.Tharav.stepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@createuser"
		//tags = "@Tharav"
		//tags = ("@positive and @Usermanagement")
		
		
		)

public class testRunner {
}
	 