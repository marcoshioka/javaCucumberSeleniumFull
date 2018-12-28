package Steps;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//import cucumber.api.java.After;

import com.cucumber.listener.Reporter;

import Commons.Drivers;
import cucumber.api.java.Before;

public class Hooks extends Drivers{
	//private WebDriver driver;

	/**
	 * Método para iniciar o driver
	 * 
	 * @author Marcos Ribeiro Hioka
	 */
	/*@Before("@login")
	public void beforeScenario() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}*/

	/**
	 * Método responsável por fechar o browser, no fim da execução do teste
	 * 
	 * @author Marcos Ribeiro Hioka
	 * @param driver
	 */
	public void closeBrowser() {
		if (Drivers.DRIVER != null) {
			Drivers.DRIVER.quit();
		}
	}

	/**
	 * Método responsável por inserir uma evidência no relatório, para ser aplicado
	 * no fim de cada step do BDD
	 * 
	 * @author Marcos Ribeiro Hioka
	 * @param driver
	 * @throws IOException
	 */
	//@cucumber.api.java.After
	public void getEvidence() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy" + "_" + "h-m-s");
		Date date = new Date();
		File sourcePath = ((TakesScreenshot)Drivers.DRIVER).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir")
				+ "/target/test-report/extent-report/screenshots/" + dateFormat.format(date) + ".png");
		FileUtils.copyFile(sourcePath, destinationPath);
		Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")
				+ "/target/test-report/extent-report/screenshots/" + dateFormat.format(date) + ".png");
	}
	


}
