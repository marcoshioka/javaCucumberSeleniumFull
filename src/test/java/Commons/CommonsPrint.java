package Commons;

import java.io.File;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class CommonsPrint extends Drivers {

	// Take a screenshot of the screen
	public static void takeScreenShot(int timeForWait, By elementInstanceBy) {

		File directoryElement = new File("../ScreenshotsAutomation/" + LocalDate.now().toString());
		File directoryElementsNull = new File("../ScreenshotsElementByNull/" + LocalDate.now().toString());

		try {
			TimeUnit.SECONDS.sleep(timeForWait);
			if (elementInstanceBy == null) {
				TakesScreenshot ts = (TakesScreenshot) DRIVER;
				File source = ts.getScreenshotAs(OutputType.FILE) ;
				FileUtils.copyFileToDirectory(source, directoryElementsNull);
				log.info(directoryElementsNull);
				log.info("========> SCREENSHOT NA PÁGINA REALIZADO COM SUCESSO!!!!! AVALIAR POSSÍVEL ERRO!!!!!");

			} else {

				WebElement elementToBePrinted = DRIVER.findElement(elementInstanceBy);
				((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", elementToBePrinted);
				
				TakesScreenshot ts = (TakesScreenshot) DRIVER;
				File source = ts.getScreenshotAs(OutputType.FILE) ;
				FileUtils.copyFileToDirectory(source, directoryElement);
				log.info(directoryElement);
				log.info("--------> SCREENSHOT NA PÁGINA REALIZADO COM SUCESSO!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("EXCEÇÃO AO REALIZAR UM SCREENSHOT DA PÁGINA" + e);
		}
	}

}