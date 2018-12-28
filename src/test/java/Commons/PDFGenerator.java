package Commons;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.test.context.TestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class PDFGenerator extends Drivers {
	public Method method;
	public static ExtentReports extent;
	public static ExtentTest test;
	private TestContext context;

	
	@After
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
			
			String featureName = "Feature ";
		    String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
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

			Image image = Image.getInstance("screenshot.png");
			float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			image.scaleToFit(documentWidth, documentHeight);
			document.add(image);
			document.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public String scenarioName() {
		return context.getTestInstance().toString();
	}
}
