package PageObjects;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import org.openqa.selenium.Keys;

public class DadosBancariosPage {

	Faker faker = new Faker(new Locale("pt-BR"));

	protected static By titulo = By.xpath("//b[contains(text(),'dados bancários')]/ancestor::h2");
	protected static By botaoSeguir = By.xpath("//button[contains(text(),'Seguir')]");
	protected static By selecionaBanco = By
			.xpath("//span[contains(text(),'Banco')]/ancestor::label/following-sibling::input");
	protected static By bancoSantander = By.xpath("//button[contains(text(), '033 - Banco Santander S. A.')]");
	protected static By tipoConta = By
			.xpath("//span[contains(text(),'Tipo de Conta')]/ancestor::label/following-sibling::input");
	protected static By campoTipoConta = By.xpath("//option[@value='Conta Poupança' and 'Conta Corrente']/ancestor::select[@class='slds-select']");
	protected static By contaCorrente = By.xpath("//option[contains(text(), 'Conta Corrente')]/ancestor::select");
	protected static By contaPoupança = By.xpath("//option[@value='Conta Poupança']");
	protected static By campoAgencia = By.xpath("//input[@placeholder='Agência']");
	protected static By campoConta = By.xpath("//input[@placeholder='Conta e digito']");

	public void verificarPaginaDadosBancarios() throws Throwable {
		Reporter.addStepLog("Verificando página de Declarações e Autorizações");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página de Declarações e Autorizações verificada com sucesso.");
	}

	public void selecionarBancoSantander() throws IOException {
		Reporter.addStepLog("Selecionando Banco Santander");
		Drivers.sendKeys(selecionaBanco, "Santander");
		Drivers.jsClick(bancoSantander);
		Drivers.marcarElemento(selecionaBanco);
		Drivers.sendKeys(selecionaBanco, Keys.TAB.toString());
		Reporter.addStepLog("Banco Santander selecionado com sucesso.");
	}

	public void selecionarContaPoupança() throws IOException {
		Reporter.addStepLog("Selecionando Conta Poupança");
		//Drivers.click(tipoConta);
		//Drivers.jsClick(campoTipoConta);
		//Drivers.sendKeys(campoTipoConta, Keys.ENTER.toString());
		//Drivers.sendKeys(contaPoupança, Keys.ENTER.toString());
		//Drivers.jsClick(contaPoupança);
		//Drivers.jsClick(contaCorrente);
		//Drivers.marcarElemento(tipoConta);
		Drivers.selectDropDown(campoTipoConta, "Conta Poupança");
		Drivers.marcarElemento(campoTipoConta);
		Reporter.addStepLog("Conta Poupança selecionada com sucesso.");
	}

	public void selecionarContaCorrente() throws IOException {
		Reporter.addStepLog("Selecionando Conta Corrente");
		//Drivers.click(tipoConta);
		//Drivers.jsClick(campoTipoConta);
		//Drivers.jsClick(contaCorrente);
		//Drivers.marcarElemento(tipoConta);
		Drivers.selectDropDown(campoTipoConta, "Conta Corrente");
		Drivers.marcarElemento(campoTipoConta);
		Reporter.addStepLog("Conta Corrente selecionada com sucesso.");
	}

	public void inserirAgencia() throws IOException {
		Reporter.addStepLog("Inserindo número da agência");
		String numeroAgencia = faker.number().digits(4);
		Drivers.sendKeys(campoAgencia, numeroAgencia);
		Reporter.addStepLog("Agência número " + numeroAgencia + " inserida com sucesso.");
	}

	public void inserirNumeroConta() throws IOException {
		Reporter.addStepLog("Inserindo número da conta");
		String numeroConta = faker.number().digits(9);
		Drivers.sendKeys(campoConta, numeroConta);
		Drivers.sendKeys(campoConta, Keys.TAB.toString());
		Reporter.addStepLog("Conta número " + numeroConta + " inserida com sucesso.");
	}

	public void clicaSeguir() throws IOException {
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.jsClick(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}

}
