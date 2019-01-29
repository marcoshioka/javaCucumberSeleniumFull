package Commons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

//import javax.ws.rs.core.Request;

import org.apache.commons.io.FileUtils;
import org.apache.wicket.util.file.Folder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.test.context.TestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import Steps.Hooks;
import cucumber.api.Scenario;
import gherkin.formatter.model.Result;

public class PDFGenerator extends Drivers {
	public Method method;
	public static ExtentReports extent;
	public static ExtentTest test;
	private TestContext context;
	private Document document;
	private static WebDriver driver;
	private JavascriptExecutor js;
	public Hooks hooks = new Hooks();
	private Result result;
	public Drivers driv = new Drivers();
	
	public void geraPDF(Scenario scenario) {
		try {

			File screenshot = ((TakesScreenshot) Drivers.DRIVER).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("screenshot.png"));
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			document.setPageSize(PageSize.A4);
			PdfWriter.getInstance(document, new FileOutputStream("evidencia.pdf"));
			document.open();

			Font f = new Font();
			f.setFamily("Courier");
			f.setStyle(Font.BOLD);
			f.setSize(30);

			Font font = new Font();
			font.setFamily("Courier");
			font.setStyle(Font.BOLD);
			font.setSize(25);

			Image logo = Image.getInstance("./font/pi.jpg");
			logo.scalePercent(10);
			document.add(logo);

			String featureName = "Feature ";
			String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
			featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
			document.add(new Paragraph(featureName, f));

			document.add(new Paragraph("Cenário: " + scenario.getName(), f));

			DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime today = LocalDateTime.now();
			String data = dia.format(today).toString();
			document.add(new Paragraph("Data: " + data, font));

			DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalDateTime agora = LocalDateTime.now();
			String horario = hora.format(agora).toString();
			document.add(new Paragraph("Horário: " + horario + " hs", font));

			if (scenario.getStatus() == "passed") {
				Font color = new Font();
				color.setFamily("Courier");
				color.setStyle(Font.BOLD);
				color.setSize(25);
				color.setColor(BaseColor.GREEN);
				document.add(new Paragraph("Status: " + scenario.getStatus(), color));
			} else {
				Font color = new Font();
				color.setFamily("Courier");
				color.setColor(BaseColor.RED);
				color.setStyle(Font.BOLD);
				color.setSize(25);
				document.add(new Paragraph("Status: " + scenario.getStatus(), color));
			}

			// document.add(new Paragraph("Step: " + Thread.currentThread().getStackTrace(),
			// f));

			Image image = Image.getInstance("screenshot.png");
			float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			image.scaleToFit(documentWidth, documentHeight);
			image.setBorder(Rectangle.BOX);
			image.setBorderColor(BaseColor.BLACK);
			image.setBorderWidth(1f);
			document.add(image);

			document.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	/*
	 * Método responsável por iniciar a criação do arquivo PDF
	 *
	 */
	public void iniciaPDF(Scenario scenario) throws Exception {
		String featureName = "Feature ";
		String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
		featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
				
		document = new Document(PageSize.A4, 50, 50, 50, 50);
		document.setPageSize(PageSize.A4);
	//	new Folder("./Evidences/" + featureName).mkdirs();
	//	PdfWriter.getInstance(document, new FileOutputStream(("/home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/" + featureName + "/") + featureName + " - " + scenario.getName() + ".pdf"));
			PdfWriter.getInstance(document, new FileOutputStream(("/home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/") + featureName + " - " + scenario.getName() + ".pdf"));
		//PdfWriter.getInstance(document, new FileOutputStream("//" + "Feature " + featureName + "//" + "evidencia.pdf"));
		//./piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ
		document.open();

		Font f = new Font();
		f.setFamily("Courier");
		f.setStyle(Font.BOLD);
		f.setSize(25);

		Font font = new Font();
		font.setFamily("Courier");
		font.setStyle(Font.BOLD);
		font.setSize(20);

		Image logo = Image.getInstance("./font/pi.jpg");
		logo.scalePercent(10);
		document.add(logo);

		document.add(new Paragraph(featureName, f));

		document.add(new Paragraph("Cenário: " + scenario.getName(), f));

		DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime today = LocalDateTime.now();
		String data = dia.format(today).toString();
		document.add(new Paragraph("Data: " + data, font));

		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		String horario = hora.format(agora).toString();
		document.add(new Paragraph("Horário: " + horario + " hs", font));

		String nameOS = "os.name";
		document.add(new Paragraph("Sistema operacional: " + System.getProperty(nameOS), font));

		document.add(new Paragraph("Browser: " + hooks.coletaNomeBrowser(), font));

		/*if (scenario.getStatus() == "passed") {
			Font color = new Font();
			color.setFamily("Courier");
			color.setStyle(Font.BOLD);
			color.setSize(20);
			color.setColor(BaseColor.GREEN);
			document.add(new Paragraph("Status: " + scenario.getStatus(), color));
		} else {
			Font color = new Font();
			color.setFamily("Courier");
			color.setColor(BaseColor.RED);
			color.setStyle(Font.BOLD);
			color.setSize(20);
			document.add(new Paragraph("Status: " + scenario.getStatus(), color));
		}*/

		document.add(Chunk.NEWLINE);

	}

	/*
	 * Método responsável pelo conteúdo de cada step do BDD no arquivo PDF.
	 *
	 */
	public void conteudoPDF(String nomeMetodo) throws IOException, DocumentException {

		document.newPage();

		Font color = new Font();
		color.setFamily("Courier");
		color.setStyle(Font.BOLD);
		color.setSize(15);
		color.setColor(BaseColor.BLUE);

		document.add(new Paragraph(nomeMetodo, color));

		File screenshot = ((TakesScreenshot) Drivers.DRIVER).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshot.png"));

		Image image = Image.getInstance("screenshot.png");
		float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
		float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
		image.setBorder(Rectangle.BOX);
		image.setBorderColor(BaseColor.BLACK);
		image.setBorderWidth(1f);
		image.scaleToFit(documentWidth, documentHeight);
		document.add(image);

	}
	
	
/*
 * Método responsável por finalizar o PDF e, no caso de falha, tira uma evidência. 
 */
	public void fechaPDF(Scenario scenario) throws DocumentException, IOException {
		if (scenario.isFailed()) {

			document.newPage();

			Font colorFailed = new Font();
			colorFailed.setFamily("Courier");
			colorFailed.setStyle(Font.BOLD);
			colorFailed.setSize(15);
			colorFailed.setColor(BaseColor.RED);

			document.add(new Paragraph("Status: " + scenario.getStatus(), colorFailed));
			document.add(new Paragraph("Evidência da falha: ", colorFailed));
			
			
			File screenshot = ((TakesScreenshot) Drivers.DRIVER).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("screenshot.png"));

			Image image = Image.getInstance("screenshot.png");
			float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			image.scaleToFit(documentWidth, documentHeight);
			image.setBorder(Rectangle.BOX);
			image.setBorderColor(BaseColor.BLACK);
			image.setBorderWidth(1f);
			document.add(image);
			document.close();
		} else {
			Font colorPassed = new Font();
			colorPassed.setFamily("Courier");
			colorPassed.setColor(BaseColor.GREEN);
			colorPassed.setStyle(Font.BOLD);
			colorPassed.setSize(20);
			document.add(new Paragraph("Status: " + scenario.getStatus(), colorPassed));
			
			document.close();
		}
	}

	public String scenarioName() {
		return method.getName();
	}

	public final String getUserAgent(HttpServletRequest request) {
		return request.getHeader("user-agent");
	}

	public static String getDefaultBrowser() {
		try {
			// Get registry where we find the default browser
			Process process = Runtime.getRuntime().exec("REG QUERY HKEY_CLASSES_ROOT\\http\\shell\\open\\command");
			Scanner kb = new Scanner(process.getInputStream());
			while (kb.hasNextLine()) {
				// Get output from the terminal, and replace all '\' with '/' (makes regex a bit
				// more manageable)
				String registry = (kb.nextLine()).replaceAll("\\\\", "/").trim();

				// Extract the default browser
				Matcher matcher = Pattern.compile("/(?=[^/]*$)(.+?)[.]").matcher(registry);
				if (matcher.find()) {
					// Scanner is no longer needed if match is found, so close it
					kb.close();
					String defaultBrowser = matcher.group(1);

					// Capitalize first letter and return String
					defaultBrowser = defaultBrowser.substring(0, 1).toUpperCase()
							+ defaultBrowser.substring(1, defaultBrowser.length());
					return defaultBrowser;
				}
			}
			// Match wasn't found, still need to close Scanner
			kb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Have to return something if everything fails
		return "Error: Unable to get default browser";
	}
	
	public String getResult() {
		return log.getName().toString();
	     
		}

}
