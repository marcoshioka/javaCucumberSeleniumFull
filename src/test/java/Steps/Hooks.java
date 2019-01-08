package Steps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import Commons.Drivers;
import cucumber.api.java.Before;

public class Hooks extends Drivers {

	private static String pathDadosTemporarios = java.nio.file.Paths.get("").toAbsolutePath().toString()
			+ "\\files\\dadosTemporarios.txt";

	private WebDriver driver;

	// private WebDriver driver;

	/**
	 * Método para iniciar o driver
	 * 
	 * @author Marcos Ribeiro Hioka
	 */
	 @Before("@login, @cadastro") 
	 public void beforeScenario() {
		 accessDefined("chrome");
	 }
	

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

	/*public String getBrowser() throws IOException {
		return coletaDadoTemporario();

	}*/
	
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

}
