package Steps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import Commons.Drivers;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks extends Drivers {

	private static String pathDadosTemporarios = java.nio.file.Paths.get("").toAbsolutePath().toString()
			+ "\\files\\dadosTemporarios.txt";

	private WebDriver driver;

	// public Method method;

	// private WebDriver driver;

	/**
	 * Método para iniciar o driver
	 * 
	 * @author Marcos Ribeiro Hioka
	 * @throws IOException
	 */
	@Before(value = "@login, @cadastro", order = 0)
	public void beforeScenario() throws IOException {
		accessDefined("chrome");
		Capabilities cap = ((RemoteWebDriver) DRIVER).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		hooks.salvaNomeBrowser(browserName);

	}

	/**
	 * Método responsável por fechar o browser, no fim da execução do teste
	 * 
	 * @author Marcos Ribeiro Hioka
	 * @param driver
	 */
	public void close() {
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
	// @cucumber.api.java.After
	public void getEvidence() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy" + "_" + "h-m-s");
		Date date = new Date();
		File sourcePath = ((TakesScreenshot) Drivers.DRIVER).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir")
				+ "/target/test-report/extent-report/screenshots/" + dateFormat.format(date) + ".png");
		FileUtils.copyFile(sourcePath, destinationPath);
		Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")
				+ "/target/test-report/extent-report/screenshots/" + dateFormat.format(date) + ".png");
		/*
		 * File destinationPath = new File(System.getProperty("user.dir") + "%TEMP%" +
		 * dateFormat.format(date) + ".png"); FileUtils.copyFile(sourcePath,
		 * destinationPath);
		 * Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") + "%TEMP%" +
		 * dateFormat.format(date) + ".png");
		 */
		/*
		 * FileUtils.copyFile(sourcePath, new File("evidenceScreenshot.png"));
		 * Reporter.addScreenCaptureFromPath(System.getPro
		 */
	}

	public String coletaDadoTemporario() throws IOException {
		adicionarDadoTemporarioArquivo(driver.toString());
		BufferedReader br = new BufferedReader(new FileReader(pathDadosTemporarios));
		String browser = br.readLine();
		br.close();
		return browser;

	}

	public void adicionarDadoTemporarioArquivo(String dado) {
		try {
			String pathDadosTemporarios = Paths.get("").toAbsolutePath().toString() + "\\files\\dadosTemporarios.txt";
			File fileTemp = new File(pathDadosTemporarios);
			fileTemp.delete();
			PrintWriter printWriter = new PrintWriter(
					new BufferedWriter(new FileWriter(fileTemp.getAbsoluteFile(), true)));
			printWriter.println(dado);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.getMessage();
		}

	}

	/*
	 * public String getBrowser() throws IOException { return
	 * coletaDadoTemporario();
	 * 
	 * }
	 */

	public void salvaDados(String dadoSalvo) throws IOException {
		String temp = Paths.get("").toAbsolutePath().toString() + "\\files\\dadosTemporarios.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		bw.write(dadoSalvo);
		bw.close();

	}

	public String coletaDados() throws IOException {
		String temp = Paths.get("").toAbsolutePath().toString() + "\\files\\dadosTemporarios.txt";
		BufferedReader bw = new BufferedReader(new FileReader(temp));
		String text = bw.readLine();
		bw.close();
		return text;

	}

	public String getBrowserName() {
		Capabilities cap = ((RemoteWebDriver) DRIVER).getCapabilities();
		return cap.getBrowserName().toUpperCase();

	}

	public void salvaNomeBrowser(String dadoSalvo) throws IOException {
		String temp = Paths.get("").toAbsolutePath().toString() + "\\files\\driver.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		bw.write(dadoSalvo);
		bw.close();

	}

	public String coletaNomeBrowser() throws IOException {
		String temp = Paths.get("").toAbsolutePath().toString() + "\\files\\driver.txt";
		BufferedReader bw = new BufferedReader(new FileReader(temp));
		String text = bw.readLine();
		bw.close();
		return text;

	}

	public String coletaNomeMetodo(Method method) throws IOException {
		String temp = Paths.get("").toAbsolutePath().toString() + "\\files\\nomeMetodo.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		bw.write(method.getName());
		BufferedReader br = new BufferedReader(new FileReader(temp));
		String nome = br.readLine();
		bw.close();
		return nome;

	}

	public String name() {
		class Local {
		}
		;
		return Local.class.getEnclosingMethod().getName();
	}

	public void closeBrowser(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			hooks.getEvidence();
			hooks.close();
		} else {
			hooks.close();
		}
	}
}
