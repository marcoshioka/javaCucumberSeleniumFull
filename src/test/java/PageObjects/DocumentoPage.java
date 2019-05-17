package PageObjects;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Commons.GeradorDeData;
import Commons.Sorting;
import Steps.Hooks;

public class DocumentoPage {

	Hooks hooks = new Hooks();

	Sorting sorting = new Sorting();

	Faker faker = new Faker(new Locale("pt-BR"));

	public String documentoQuando1 = "E insira as informações de CNH";

	protected static By titulo = By.xpath("//span[contains(text(), 'documento')]");
	protected static By botaoCnh = By.xpath("//button[contains(text(), 'CNH')] ");
	protected static By campoNumeroRegistro = By.xpath("//input[@placeholder = 'Número do registro'] ");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	protected static By campoOrgaoEmissor = By.xpath("//option[contains(text(), 'Órgão emissor')]/ancestor::select[@class='slds-select']");
	protected static By orgaoEmissorDetran = By.xpath("//select[@class='slds-select']/option[contains(text(), 'DETRAN')]");
	protected static By campoDataEmissaoCNH = By.xpath("//input[@placeholder='Data de emissão']");
	protected static By estadoEmitenteCNH = By.xpath("//option[contains(text(), 'Estado emitente')]/ancestor::select[@class='slds-select']");
	protected static By estadoEmitenteCnhSP = By.xpath("//select[@class='slds-select']/option[contains(text(), 'SP')]");
	
	public void selecionaOpcaoCNH() throws IOException {
		Reporter.addStepLog("Selecionando opção CNH");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.waitForElementToBeClickable(botaoCnh);
		Drivers.click(botaoCnh);
		Reporter.addStepLog("Opção CNH selecionada com sucesso.");
	}

	public void insereNumeroDoRegistroCNH() throws IOException {
		Reporter.addStepLog("Inserindo número do registro da CNH");
		Drivers.waitForElementToBeClickable(campoNumeroRegistro);
		String numeroRegistro = faker.number().digits(11);
		Drivers.sendKeys(campoNumeroRegistro, numeroRegistro);
		Reporter.addStepLog("Número " + numeroRegistro + " inserido com sucesso.");
	}

	public void selecionaOrgaoEmissorDetran() throws IOException {
		Reporter.addStepLog("Selecionando Órgão Emissor Detran");
		Drivers.waitForElementToBeVisible(campoOrgaoEmissor);
		Drivers.jsClick(campoOrgaoEmissor);
		Drivers.click(orgaoEmissorDetran);
		Drivers.marcarElemento(campoOrgaoEmissor);
		Reporter.addStepLog("Órgão Emissor Detran selecionado com sucesso.");
	}
	
	public void insereDataEmissaoCNH () throws IOException {
		Reporter.addStepLog("inserindoDataEmissaoCNH");
		Drivers.waitForElementToBeClickable(campoDataEmissaoCNH);
		String data = GeradorDeData.randomDOB();
		Drivers.sendKeys(campoDataEmissaoCNH, data);
		Reporter.addStepLog("Data " + data + " inserida com sucesso.");
	}
	
	public void selecionaEstadoEmitenteSP() throws IOException{
		Reporter.addStepLog("Selecionando Estado SP");
		Drivers.waitForElementToBeVisible(estadoEmitenteCNH);
		Drivers.click(estadoEmitenteCnhSP);
		Drivers.marcarElemento(estadoEmitenteCNH);
		Reporter.addStepLog("Estado de São Paulo selecionado com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.sendKeys(botaoSeguir, Keys.PAGE_DOWN.toString());
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}

}
