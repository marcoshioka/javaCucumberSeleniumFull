package report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hp.lft.report.ReportException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import exceptions.EvidenciaException;
import junit.OnError;
import junit.Save;
import utils.Constants;

/**
 * Classe implementa as opções de interação do iText para o projeto.
 * 
 * @author Leonardo Costa
 * @since 26/04/2018
 *
 */
public class ReportPDF implements Report {
	
	final static Logger logger = Logger.getLogger(ReportPDF.class);

	private String path = Paths.get("").toAbsolutePath().toString() + "//Evidences//"+Thread.currentThread().getName()+".pdf";
	private PdfWriter writer;
	private Document document;
	private TakesScreenshot screenCapture;
	private JavascriptExecutor jse;	
	private Font tituloFormatacao;
	private Font subtituloFormatacao;
	private Font dadosFormatacao;
	private boolean textReport;
	private boolean discartStandardText;
	private String browserVersion; 
	private ColumnText descText;
	private static WebDriver webDriver;
	
	/**
	 * 
	 * @param driver
	 * @param pathToSave
	 * @throws Exception
	 */
	public ReportPDF(WebDriver driver, String pathToSave) throws Exception {
		this(webDriver);
		this.path = pathToSave;	
	}
	
	@Override
	public void addStep() {
		addStep("");
	}
	
	@Override
	public void addStep(String description, boolean discartStandardText, WebElement... webElement) {
		this.discartStandardText = discartStandardText;
		addStep(description, webElement);
	}
	
	@OnError
	@Override
	public void addStep(String description, boolean discartStandardText)  {
		this.discartStandardText = discartStandardText;
		addStep(description);
	}
	
	@Override
	public void addStep(WebElement... webElement)  {
		addStep("", webElement);	
	}
	
	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void save() throws Exception {
		save (this.path);		
	}

	@Save
	@Override
	public void save (boolean isPassed) throws Exception {
		save (this.path, isPassed);
	}
	
	@Override
	public void addStep(String description, WebElement... webElement) {
		String javaScript ="";
		String initialStyle="";
		//Cria o javascript para desfazer
		for (int i = 0; i< webElement.length; i++) {
			initialStyle = initialStyle + String.format(Constants.JAVA_SCRIPT_UNDO, i ,webElement[i].getAttribute("style"));
		}
		//Cria o javascript de Highlight
		for (int i=0; i<webElement.length; i++) {
			javaScript = javaScript + String.format(Constants.JAVA_SCRIPT_HIGHLITH, i,i,i);
		}
		//Aguarda visibilidade de todos elementos
		waitVisibilityOfElement (webElement);
		//Executa o highlight em todos elementos				
		jse.executeScript(javaScript, (Object[])webElement);		
		addStep (description);
		jse.executeScript(initialStyle, (Object[])webElement);
	}
	
	@Override
	public void addFreeText(String description, String fontname, float size, int style, BaseColor color) {
		Font format;
		try {
			EvidenceManager.clearTextReport(Thread.currentThread().getName());
			format = FontFactory.getFont(fontname, size, style, color);
			document.add(new Paragraph( description, format));
		} catch (DocumentException e) {
			logger.error("Falha ao adicionar o texto formatado (FreeText) na evidência" + e.getMessage());
			throw new EvidenciaException("Falha ao adicionar o texto formatado (FreeText) na evidência.", e);
		}
	}
	
	@Override
	public void addText(String description) {
		try {
			EvidenceManager.clearTextReport(Thread.currentThread().getName());
			document.add(new Paragraph( description, dadosFormatacao));
		} catch (DocumentException e) {
			logger.error("Falha ao adicionar o texto na evidência" + e.getMessage());
			throw new EvidenciaException("Falha ao adicionar o texto na evidência" + e.getMessage());
		}

	}
	
	@Override
	public void addEmptyLine() {
		try {
			EvidenceManager.clearTextReport(Thread.currentThread().getName());
			document.add(new Paragraph( "               ", dadosFormatacao));
		} catch (DocumentException e) {
			logger.error("Falha ao adicionar linha em branco na evidência" + e.getMessage());
			throw new EvidenciaException("Falha ao adicionar linha em branco na evidência" + e.getMessage());
		}

	}
	
	private void setImage(byte [] pictureData){
	try {
		Image image = Image.getInstance(pictureData);
		image.scaleToFit(document.getPageSize().getWidth()-(Constants.MARGIN*2), document.getPageSize().getHeight());
		document.add(image);
		document.newPage();
		} catch (BadElementException | IOException e) {
			logger.error("Falha ao adicionar a imagem na evidência" + e.getMessage());
			throw new EvidenciaException("Falha ao adicionar a imagem na evidência" + e.getMessage());
		} catch (DocumentException e) {
			logger.error("Falha ao adicionar a imagem na evidência" + e.getMessage());
			throw new EvidenciaException("Falha ao adicionar a imagem na evidência" + e.getMessage());
		}
	}
	
	@Override
	public void save(String path) throws Exception {
		try {   			
			document.close();
        	writer.close(); 
			EvidenceManager.addEvidence(Paths.get(path));
		} catch (IOException e) {
			logger.error("Falha ao salvar a evidência" + e.getMessage());
		}
		
	}
	
	@Override
	public void saveFileName(String file, String testName, boolean isPassed) throws Exception{
		try {   	
			setStatus (isPassed);
			document.close();
        	writer.close(); 
			EvidenceManager.addEvidence(Paths.get(path), file, testName);
		} catch (IOException e) {
			logger.error("Erro ao salvar o arquivo de evidência: " + e.getMessage());
			throw new EvidenciaException("Erro ao salvar o arquivo de evidência: " + e.getMessage());
		}
	}
	
	@Override
	public void disableStandardText() {
		this.textReport = false;
	}
	
	/**
	 * 
	 * @param elements
	 */
	private void waitVisibilityOfElement (WebElement...elements) {
		WebDriverWait webDriverWait = new WebDriverWait (ReportPDF.webDriver, 30);
		for (int i=0; i<elements.length; i++) {
			webDriverWait.until(ExpectedConditions.visibilityOf(elements[i]));
		}
	} 

	/**
	 * 
	 * @param startX
	 * @param endX
	 * @param startY
	 * @param endY
	 * @param contentByte
	 * @return
	 */
	private ColumnText addTextArea (int startX, int endX, int startY, int endY, PdfContentByte contentByte) {
		ColumnText ct = new ColumnText (contentByte);
		ct.setSimpleColumn(startX, endX, startY, endY);
		return ct;
	}
	
	/**
	 * 
	 * @param startX
	 * @param endX
	 * @param startY
	 * @param endY
	 * @return
	 */
	private ColumnText addTextArea (int startX, int endX, int startY, int endY) {
		return addTextArea (startX, endX, startY, endY, this.writer.getDirectContent());
	}
	
	/**
	 * Define o status da evidência em caso de:
	 * - sucesso
	 * - erro
	 * @param isPassed boolean flag
	 */
	private void setStatus (boolean isPassed) {
		if (isPassed) {			
			Font f = new Font ();
			f.setColor(BaseColor.GREEN);
			this.descText.addText(new Phrase ("Status: Passed", f));
		}
		else {
			Font f = new Font ();
			f.setColor(BaseColor.RED);
			this.descText.addText(new Phrase ("Status: Failed", f));
		}
		try {
			this.descText.go();
		}
		catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param path
	 * @param isPassed
	 * @throws ReportException
	 */
	public void save (String path, boolean isPassed) throws Exception  {
		try {   			
			setStatus (isPassed);
			document.close();
        	writer.close();        	
			EvidenceManager.addEvidence(Paths.get(path));
		} catch (IOException e) {
			throw new EvidenciaException("Falha ao salvar o arquivo de evidência: " + e.getMessage());
		}
	}
	
	/**
	 * Construtor
	 * @param webDriver2 Driver EFA3
	 * @throws ReportException 
	 * @throws Exception
	 */
	public ReportPDF (WebDriver webDriver2) throws Exception  {
		ReportPDF.webDriver = webDriver2;
		this.browserVersion = ((RemoteWebDriver) webDriver).getCapabilities().getBrowserName().toLowerCase() + " " + 
								((RemoteWebDriver) webDriver).getCapabilities().getVersion().toString();
		this.screenCapture = (TakesScreenshot)webDriver;
		this.jse = ((JavascriptExecutor)webDriver);
		this.document = new Document();		
		try {		
		   Files.createDirectories(Paths.get(this.path).getParent());
		   this.writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		 } 
		catch (FileNotFoundException e) {
		   logger.error("Arquivo da evidência não localizado: " + e.getMessage());
		  } 
		catch (DocumentException e) {
		   logger.error("Mensagem de erro: " + e.getMessage());
		  } 
		catch (IOException e) {
			throw new Exception ("Falha ao criar diretório de evidência. " + e.getMessage());
		}		
		this.document.open();
		
		PdfTemplate status = this.writer.getDirectContent().createTemplate(200, 200);
		this.descText = addTextArea (40, 30, 350, 150, status);
		try {
			this.descText.go();
		} catch (DocumentException e) {
			logger.error("Erro ao criar o construtor da evidencia: " + e.getMessage());
		}
		this.writer.getDirectContent().addTemplate(status, 0, 30);
		this.document.setMargins(Constants.MARGIN, Constants.MARGIN, Constants.MARGIN, Constants.MARGIN);
      	this.tituloFormatacao = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
      	this.subtituloFormatacao = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.GRAY);
    	this.dadosFormatacao = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL);
    	this.textReport = true;
		this.discartStandardText = false;
	}
	
	@Override
	public void setCover(String testName, String objective) {
		
		Paragraph titulo = new Paragraph(testName, tituloFormatacao);  
		
		try {
			Image imglogo = Image.getInstance(Paths.get("").toAbsolutePath().toString() + "//resource//logoEveris.png");
			imglogo.setAbsolutePosition(310, 700);
			imglogo.setScaleToFitHeight(true);
			document.add(imglogo); 	
			
			Image imgcap = Image.getInstance(Paths.get("").toAbsolutePath().toString() + "//resource//GREENblzack.png");
			imglogo.scaleToFit(400, 50);
			imglogo.setScaleToFitHeight(true);
			document.add(imgcap);
			
			//Adiciona o título
			ColumnText title = addTextArea(45, 410, 560, 550);
			title.addText(titulo);			
			title.setLeading(23);
			title.go();
			
			//Adiciona o objetivo
			ColumnText obj = addTextArea(45, 340, 560, 260);
			titulo = new Paragraph(120, objective, subtituloFormatacao);
			obj.addText(new Paragraph(titulo));
			obj.go();
			
			//Insese dados da execução
			//ColumnText desc = addTextArea(40, 30, 350, 150);
	        String info = "Nome: Automação \nData: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())+
	        		"\nBrowser: " + browserVersion + "\r\nUsuário logado:" + System.getProperty("user.name"); 
	        
	        Paragraph p = new Paragraph(70, info); //original
	        this.descText.addText(p);
	        this.descText.go();
	        document.newPage();
		} catch (BadElementException | IOException e) {
			logger.error("Erro ao setar a capa da evidência: " + e.getMessage());
		} catch (DocumentException e) {
			logger.error("Erro ao setar a capa da evidência: " + e.getMessage());
		}
	}
	
	@Override
	public void addStep(String description) {
		try {
			if (document.isOpen()) {
				if (this.textReport) {
					if (this.discartStandardText) {
						EvidenceManager.clearTextReport(Thread.currentThread().getName());
						document.add(new Paragraph(description, dadosFormatacao));
					} else {
						StringBuilder report = new StringBuilder();
						for (String t : EvidenceManager.getTextReport(Thread.currentThread().getName())) {
							report.append(t);
						}
						report.append("\n" + description);
						document.add(new Paragraph(report.toString(), dadosFormatacao));
					}
				} else {
					document.add(new Paragraph(description, dadosFormatacao));
				}

				waitPageLoad();

				byte[] pictureData = screenCapture.getScreenshotAs(OutputType.BYTES);
				setImage(pictureData);
			}
		} catch (DocumentException e) {
			logger.error("Erro: " + e.getMessage());
			throw new EvidenciaException("Falha ao adicionar o passo da evidência.", e);
		} finally {
			this.discartStandardText = false;
		}
	}

	private void waitPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		for (int i = 0; i < (30 * 100); i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			if (js.executeScript("return document.readyState").toString().equals("complete"))
				break;
		}
	}

}
