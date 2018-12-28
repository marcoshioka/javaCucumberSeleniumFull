package core;

import static com.everis.EFA.cv_driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import exceptions.BasicActionsException;
import exceptions.FinalizarExecucaoException;
import report.ReportPDF;

import utils.Constants;

/**
 * Classe encapsulando as principais interações com os elementos web.
 * 
 * Alternativa quando executeAction não funcionar.
 * @author Leonardo Costa
 * 
 */
public class BasicActions {
	
	final static Logger logger = Logger.getLogger(BasicActions.class);
	
	public BasicActions() {}
	
	/**
	 * Recupera o elemento com o xpath passado por parametro.
	 * @param xpath - xpath do elemento a ser recuperado
	 * @param report -  evidência em PDF
	 * @return WebElement - Elemento da tela recuperado
	 * @throws BasicActionsException - exceção da classe[
	 * @author Leonardo Costa
	 */
	public static WebElement getWebElement(String xpath, ReportPDF report) throws BasicActionsException {
		WebElement element;
		try {
			element = cv_driver.findElement(By.xpath(xpath));
			logger.info("O elemento do xpath: " + xpath + " foi recuperado com sucesso.");
		} catch (Exception e) {
			report.addFreeText("Não foi possível recuperar o elemento do xpath: " + xpath, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			report.addStep();
			logger.error("Não foi possível recuperar o elemento do xpath: " + xpath + " ", e);
			throw new BasicActionsException("Não foi possível recuperar o elemento do xpath: " + xpath + " ", e);
		}
		return element;
	}
	
	/**
	 * Recupera uma lista de elementos.
	 * @param xpath - xpath da lista de elementos
	 * @param report - evidencia em pdf
	 * @return
	 * @throws BasicActionsException
	 */
	public static List<WebElement> getWebElements(String xpath, ReportPDF report) throws BasicActionsException {
		List<WebElement> elementos;
		try {
			elementos = cv_driver.findElements(By.xpath(xpath));
			logger.info("Os elementos do xpath: " + xpath + " foram recuperados com sucesso.");
		} catch (Exception e) {
			report.addFreeText("Não foi possível recuperar os elementos do xpath: " + xpath, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			logger.error("Não foi possível recuperar os elementos do xpath: " + xpath + " ", e);
			throw new BasicActionsException("Não foi possível recuperar os elementos do xpath: " + xpath + " ", e);
		}
		return elementos;
	}

	
	/**
	 * Recebe o xpath de um Select via Parametro
	 * Recupera a lista de elementos, faz a iteração da lista dos Elementos 
	 * e clica no elemento por texto
	 * @param xpath - xpath da lista de elementos
	 * @throws BasicActionsException
	 * * @author Carlos Almeida
	 */
	public static void selectOptionDropdown(String xpath, String text, ReportPDF report) throws BasicActionsException {
		WebElement elementos;
		try {
			elementos = cv_driver.findElement(By.xpath(xpath));
			Select selectListOptions = new Select(elementos);
			List<WebElement> options = selectListOptions.getOptions();
			int n =  options.size();
			for(WebElement selectOption:options)  
	        {  
				if (selectOption.getText().equals(text)){
		             System.out.println(selectOption.getText());
		             selectOption.click();
		             } 
	        }
			
			logger.info("Os elementos do xpath: " + xpath + " foram recuperados com sucesso.");
		} catch (Exception e) {
			report.addFreeText("Não foi possível recuperar os elementos do xpath: " + xpath, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			logger.error("Não foi possível recuperar os elementos do xpath: " + xpath + " ", e);
			throw new BasicActionsException("Não foi possível recuperar os elementos do xpath: " + xpath + " ", e);
		}
	}
	
	

	/**
	 * Clica no elemento passado como parametro.
	 * @param elemento - webelement recuperado da tela
	 * @param report - evidencia em PDF
	 * @throws BasicActionsException - exceção da classe
	 * @author Leonardo Costa
	 */
	public static void click(WebElement elemento, ReportPDF report) throws BasicActionsException {
		try {
			report.addStep(elemento);
			elemento.click();
			logger.info("Realizado click no elemento: " + elemento.getText());
		} catch (Exception e) {
			report.addFreeText("Não foi possível clicar no elemento: " + elemento.getTagName(), FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			report.addStep();
			logger.error("Não foi possível clicar no elemento: " + elemento.getTagName() + " ", e);
			throw new BasicActionsException("Não foi possível clicar no elemento: " + elemento.getTagName() + " ", e);
		}
	}
	
	/**
	 * Envia o texto para o campo da tela passado por parametro.
	 * @param elemento - webelement representando o campo de inserção
	 * @param texto - texto a ser inserido no campo
	 * @param report - evidência em PDF
	 * @throws BasicActionsException - exceção da classe
	 */
	public static void sendKeys(WebElement elemento, String texto, ReportPDF report) throws BasicActionsException {
		try {
			elemento.sendKeys(texto);
			logger.info("Envio do texto: " + texto + " para o campo: " + elemento.getText());
		} catch (Exception e) {
			report.addFreeText("Não foi possível enviar para o elemento o texto: " + texto, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			logger.error("Não foi possível enviar para o elemento o texto: " + texto + " ", e);
			throw new BasicActionsException("Não foi possível enviar para o elemento o texto: " + texto + " ", e);
		}
	}
	
	/**
	 * Verifica se o elemento existe na tela
	 * @param xpath - xpath do elemento a ser verificado
	 * @return boolean - indicando se o elemento foi localizado ou não
	 * @author Leonardo Costa
	 */
	public static boolean exists(String xpath) {
		BasicActions.waitPageLoad(1000);
		if(cv_driver.findElements(By.xpath(xpath) ).size() != 0) {
			logger.info("O elemento existe com o xpath: " + xpath);	
			return true;
		}else {
			logger.info("O elemento NÃO existe com o xpath: " + xpath);	
			return false;
		}
	}
	
	/**
	 * Scroll down
	 */
	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) cv_driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		// jse.executeScript("scroll(0, 250);");
	}

	/**
	 * Scroll up
	 */
	public static void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) cv_driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		// jse.executeScript("scroll(0, -250);");
	}

	/**
	 * Mover para o elemento da página.
	 * @param xpath do elemento
	 * @throws BasicActionsException 
	 */
	public void moveToElement(String xpath, ReportPDF report) throws BasicActionsException {
		WebElement element = getWebElement(xpath, report);
		Actions actions = new Actions(cv_driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	/**
	 * Envia comandos com Keys.
	 * Exemplo: Keys.TAB
	 * @param elemento - elemento onde a ação será executada
	 * @param key - key com a ação a ser executada
	 * @param report - evidência em PDF
	 * @throws BasicActionsException - exceção da classe
	 */
	public static void sendKeys(WebElement elemento, Keys key, ReportPDF report) throws BasicActionsException {
		try {
			elemento.sendKeys(key);
			logger.info("Realizando envio de ação com Key no elemento: " + elemento.getText());
		} catch (Exception e) {
			report.addFreeText("Não foi possível enviar a key: " + key, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			logger.error("Não foi possível enviar a key: " + key + " ", e);
			throw new BasicActionsException("Não foi possível enviar a key: " + key + " ", e);
		}
	}
	
	/**
	 * Aguarda o elemnto estar presente na tela, por 15 segundos.
	 * @param xpath - xpath do elemento a ser verificado presença na tela.
	 * @param ReportPDF - evidencia em pdf
	 * @author Leonardo Costa
	 * @throws FinalizarExecucaoException 
	 */
	public static void waitElementPresent(String xpath, ReportPDF report) throws FinalizarExecucaoException {
		
		try {
			logger.info("Aguardando elemento carregar na tela para interação.");
			WebDriverWait wait = new WebDriverWait(cv_driver, 47);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			logger.error("Ocorreu erro ao aguardar a presença do elemento na tela.");
			report.addFreeText("Ocorreu erro ao aguardar a presença do elemento na tela.", FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			report.addStep();
			throw new FinalizarExecucaoException("Ocorreu erro ao aguardar a presença do elemento na tela.");
		}
		
	}
	
	/**
	 * Realiza a navegação para uma URL específica.
	 * @param url - url para navegação
	 * @param report - evidência em PDF
	 * @throws BasicActionsException - exceção da classe
	 */
	public static void navigateTo(String url) throws BasicActionsException {
		try {
			cv_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			cv_driver.get(url);
			waitPageLoad(1000);
		} catch (Exception e) {
			logger.error("Não foi possível navegar para a url: " + url + " ", e);
			throw new BasicActionsException("Não foi possível navegar para a url: " + url + " ", e);
		}
	}
	
	/**
	 * Método alternativo ao waitElementPresent() 
	 * @param time - tempo de espera
	 */
	public static void waitPageLoad(int time) {
		JavascriptExecutor js = (JavascriptExecutor) cv_driver;
		for (int i = 0; i < 8; i++) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {}
			if (js.executeScript("return document.readyState").toString().equals("complete"))
				break;
		}
		
	}
	
	/**
	 * Seleciona uma opção de um select
	 * @param elemento - elemento a ser selecionado no select
	 * @param report - evidência em PDF
	 * @throws BasicActionsException - exceção da classe
	 */
	public static void selectOption(WebElement elemento, ReportPDF report) throws BasicActionsException {
		try {
			elemento.click();
			logger.info("Realizando a seleção da opção no select: " + elemento.getText());
		} catch (Exception e) {
			report.addFreeText("Não foi possível selecionar a opção no componente select.", FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			logger.error("Não foi possível selecionar a opção no componente select.", e);
			throw new BasicActionsException("Não foi possível selecionar a opção no componente select.", e);
		}
	}
	
	public static void actionClick(WebElement elemento, ReportPDF report) {
		report.addStep(elemento);
		Actions ob = new Actions(cv_driver);
		ob.moveToElement(elemento);
		ob.click(elemento);
		org.openqa.selenium.interactions.Action action  = ob.build();
		action.perform();
		}
	
	/**
	 * Clica no elemento passado como parametro com Javascript.
	 * @param elemento - webelement recuperado da tela
	 * @param report - evidencia em PDF
	 * @throws BasicActionsException - exceção da classe
	 * @author Marcos Hioka
	 */
	public static void jsClick(WebElement elemento, ReportPDF report) throws BasicActionsException {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) cv_driver;
			report.addStep(elemento);
			jse.executeScript("arguments[0].click();", elemento);
			logger.info("Realizado click com JS no elemento: " + elemento.getText());
		} catch (Exception e) {
			report.addFreeText("Não foi possível clicar com JS no elemento: " + elemento.getTagName(), FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.RED);
			logger.error("Não foi possível clicar com JS no elemento: " + elemento.getTagName() + " ", e);
			throw new BasicActionsException("Não foi possível clicar com JS no elemento: " + elemento.getTagName() + " ", e);
		}
	}
	
	

	/**
	 * //21/11/2018 Adicionado por Carlos
	 */
	public static String coletarTemppMailOpcaoTres(ReportPDF report) throws Exception{
		BasicActions.waitPageLoad(1000);
		WebElement element;
		element = cv_driver.findElement(By.xpath(Constants.TEXT_VALUE_EMAIL_TEMPMAIL));
				
		return element.getTagName();
	}
	

}