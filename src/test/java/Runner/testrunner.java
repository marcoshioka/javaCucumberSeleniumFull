package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json",
		"junit:target/cucumber.xml", "com.cucumber.listener.ExtentCucumberFormatter:target/report.html" }, features = {
		
				/*"src/test/java/Features/cadastro.feature",*/  
				/*"src/test/java/Features/login.feature",*/
				"src/test/java//Features"}, 
		glue = { "Steps" }, tags = {})

public class testrunner {
	 @AfterClass
	    public static void setup() {
	        Reporter.loadXMLConfig(new File("extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("os", "Windows");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	    }
}