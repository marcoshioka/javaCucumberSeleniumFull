package Commons;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hp.lft.sdk.Keys;

//import actions.ConsultoriaFileReaderActions;

public class Drivers {

	protected static WebDriver DRIVER;
	protected static Logger log = Logger.getLogger(Drivers.class);
	protected static CommonsPrint commonsPrint;
	static String pathDadosTemporarios = java.nio.file.Paths.get("").toAbsolutePath().toString()
			+ "\\files\\dadosTemporarios.txt";

	protected static void accessDefined(String driver) {
		switch (driver) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			/**
			 * Método responsável por inserir a emulação mobile do Chrome Options
			 */
			/*
			 * Map<String, String> mobileEmulation = new HashMap<>();
			 * mobileEmulation.put("deviceName", "Nexus 5");
			 * options.setExperimentalOption("mobileEmulation", mobileEmulation);
			 */
			options.addArguments("--disable-notifications");
			options.addArguments("disable-infobars");
			options.addArguments("--print-to-pdf");
			options.addArguments("--start-maximized");
			//options.addArguments(
					//"--user-agent=Chrome/56.0.0.0 Mobile | E3C6CC9273EE75C2563D7CD94825033E37AB3FA3A28157AC75673ACF9FC4362A");
			DRIVER = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("disable-infobars");
			optionsFirefox.addArguments("--print-to-pdf");
			optionsFirefox.addArguments("--start-maximized");
			DRIVER = new FirefoxDriver(optionsFirefox);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./driver/MicrosoftWebDriver.exe");
			EdgeOptions optionsEdge = new EdgeOptions();
			DRIVER = new EdgeDriver(optionsEdge);
			break;
		}
	}

	public static void irParaURL(String url) throws Throwable {
		DRIVER.get(url);
	}

	protected static String getBrowserName() {
		return DRIVER.toString();

	}

	public static String coletarValue(By elemento) throws Throwable {
		By by = elemento;
		WebElement e = DRIVER.findElement(by);
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e, "color: ; border: 2px solid red;");
		jse.executeScript("arguments[0].click();", e);
		String value = e.getAttribute("value");
		return value;

	}

	public static void scrollToElement(By elemento) {
		By by = elemento;
		WebElement element = DRIVER.findElement(by);
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public static void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public static void implicitlyWait(int seconds) throws InterruptedException {
		DRIVER.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void pageDownTwice() {
		Actions action = new Actions(DRIVER);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

	public static void waitForElementToBeClickable(By elemento) {
		final WebDriverWait wait = new WebDriverWait(DRIVER, 15);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));

	}

	public static void waitForElementToBeVisible(By elemento) {
		final WebDriverWait wait = new WebDriverWait(DRIVER, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}

	protected static void acceptAlert() {
		Alert alert = DRIVER.switchTo().alert();
		alert.accept();
	}
	
	protected static void refresh() {
		DRIVER.navigate().refresh();
	}

	public static void sendKeys(By elemento, String keys) {
		DRIVER.findElement(elemento).sendKeys(keys);
		By by = elemento;
		WebElement e = DRIVER.findElement(by);
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		// jse.executeScript("arguments[0].style.border='3px solid red'", e);
		jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e, "color: ; border: 2px solid red;");
		// jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e,
		// "");

	}

	public static void click(By elemento) {
		By by = elemento;
		WebElement e = DRIVER.findElement(by);
		e.click();
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e, "color: ; border: 2px solid red;");
	}

	protected static void jsClick(By elemento) {
		By by = elemento;
		WebElement e = DRIVER.findElement(by);
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		// jse.executeScript("arguments[0].style.border='3px solid green'", e);
		jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e, "color: ; border: 2px solid red;");
		jse.executeScript("arguments[0].click();", e);
		// jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e,
		// "");
	}

	protected static void marcarElemento(By elemento) {
		By by = elemento;
		WebElement e = DRIVER.findElement(by);
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		// jse.executeScript("arguments[0].style.border='3px solid red'", e);
		jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e, "color: ; border: 2px solid red;");
		// jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", e,
		// "");
	}

	protected static void switchToOtherTab(int tabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(DRIVER.getWindowHandles());
		DRIVER.switchTo().window(tabs.get(tabIndex));
	}

	protected static void closeCurrentTab() {
		DRIVER.close();
	}

	protected static void presentText(By elementWithSomeText, String nameExpected) {
		String nameCatched = sleepAndFindElement(3, elementWithSomeText).getText();
		assertTrue("Atributo presente: " + nameCatched + ", é divergente do esperado: " + nameExpected,
				nameCatched.contains(nameExpected));
	}

	protected static void closeWindow() {
		DRIVER.quit();
		log.info("Turn off chrome browser");
	}

	protected static String getPageSource() {
		return DRIVER.getPageSource();
	}

	public String coletaDadoTemporario(WebDriver DRIVER) throws IOException {
		adicionarDadoTemporarioArquivo(DRIVER);
		BufferedReader br = new BufferedReader(new FileReader(pathDadosTemporarios));
		String browser = br.readLine();
		br.close();
		return browser;

	}

	public void adicionarDadoTemporarioArquivo(WebDriver DRIVER) {
		try {
			String pathDadosTemporarios = java.nio.file.Paths.get("").toAbsolutePath().toString()
					+ "\\files\\dadosTemporarios.txt";
			File fileTemp = new File(pathDadosTemporarios);
			fileTemp.delete();
			PrintWriter printWriter = new PrintWriter(
					new BufferedWriter(new FileWriter(fileTemp.getAbsoluteFile(), true)));
			printWriter.printf(DRIVER.toString(), this);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static String getBrowser() throws IOException {
		Capabilities cap = ((RemoteWebDriver) DRIVER).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
		return browserName;

	}

	// CommonsMethods
	// execute a JS script
	protected static void executeJsScript(int timeForWait, String scriptToBeExecuted) throws Throwable {
		if (DRIVER instanceof JavascriptExecutor) {
			TimeUnit.SECONDS.sleep(timeForWait);
			((JavascriptExecutor) DRIVER).executeScript(scriptToBeExecuted);
			log.info("--------> Script injetado e executado com sucesso!");
		} else {
			throw new IllegalStateException("O DRIVER UTILIZADO NÃO UTILIZA JAVASCRIPT!!!");
		}
	}

	// Sleep a while and find ONLY ONE element
	protected static WebElement sleepAndFindElement(int timeForWait, By checkElementVisibility) {
		int counter = 1;
		WebElement elementFinded = null;
		while (counter <= timeForWait) {
			try {
				TimeUnit.SECONDS.sleep(1);
				elementFinded = DRIVER.findElement(checkElementVisibility);
				if (elementFinded.isDisplayed() == true) {
					log.info(
							"ELEMENTO (" + checkElementVisibility.toString() + ") ENCONTRADO NA TENTATIVA: " + counter);
				} else {
					ElementNotVisibleException elementNotDisplayed = new ElementNotVisibleException(null);
					throw elementNotDisplayed;
				}
				break;
			} catch (Exception error) {
				log.info(
						"ELEMENTO (" + checkElementVisibility.toString() + ") NÃO ENCONTRADO NA TENTATIVA: " + counter);
				error.getMessage();
				counter += 1;
			}
		}
		if (counter > timeForWait) {
			log.info("========> TIMEOUT NA LOCALIZAÇÃO DO ELEMENTO (" + checkElementVisibility.toString() + ")");
			CommonsPrint.takeScreenShot(1, null);
			closeWindow();
			TimeoutException timeOut = new TimeoutException();
			throw timeOut;
		} else {
			return elementFinded;
		}
	}

	// Sleep a while and find AN ARRAY of elements
	protected static List<WebElement> sleepAndFindArrayOfElements(int timeForWait, By checkElementsVisibility) {
		int counter = 1;
		List<WebElement> elementsFinded = null;
		while (counter <= timeForWait) {
			try {
				TimeUnit.SECONDS.sleep(1);
				elementsFinded = DRIVER.findElements(checkElementsVisibility);
				log.info("ELEMENTOS (" + checkElementsVisibility.toString() + ") ENCONTRADOS NA TENTATIVA: " + counter);
				break;
			} catch (Exception error) {
				log.info("========> ELEMENTOS (" + checkElementsVisibility.toString()
						+ ") NÃO ENCONTRADOS NA TENTATIVA: " + counter);
				error.printStackTrace();
				counter += 1;
			}
		}
		if (counter > timeForWait) {
			log.error("========> TIMEOUT NA LOCALIZAÇÃO DOS ELEMENTOS (" + checkElementsVisibility.toString() + ")");
			CommonsPrint.takeScreenShot(1, null);
			closeWindow();
			TimeoutException timeOut = new TimeoutException();
			throw timeOut;
		} else {
			for (WebElement allFinded : elementsFinded) {
				log.info("ELEMENTOS " + allFinded.toString() + " COM VISIBILIDADE: " + allFinded.isDisplayed());
			}
			return elementsFinded;
		}
	}

}