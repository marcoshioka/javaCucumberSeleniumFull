package PageObjects;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Commons.GeraCpfCnpj;
import Commons.GeradorDeData;
import Steps.Hooks;

public class DadosPage extends Drivers{
	
	Hooks hooks = new Hooks();

	Faker faker = new Faker(new Locale("pt-BR"));
	
	GeradorDeData dataNascimento = new GeradorDeData();
	
		
	protected static By titulo = By.xpath("//b[contains(text(),'dados')]");
	protected static By campoNomeMae = By.xpath("//input[@placeholder='Nome da mãe']");
	protected static By campoNomePai = By.xpath("//input[@placeholder='Nome do pai (opcional)']");
	protected static By campoNacionalidade = By.xpath("//select[@name='select']");
	protected static By brasileiroNato = By.xpath("//select[@name='select']//option[contains(text(), 'Brasileiro Nato')]");
	protected static By estado = By.xpath("//option[contains(text(), 'Estado')]/ancestor::select[@class='slds-select']");
	protected static By estadoSP = By.xpath("//select[@class='slds-select']/option[contains(text(), 'SP')]");
	protected static By cidade = By.xpath("//option[contains(text(), 'Cidade')]/ancestor::select[@class='slds-select']");
	protected static By cidadeSaoPaulo = By.xpath("//select[@class='slds-select']/option[contains(text(), 'São Paulo')]");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public String dadosQuando1 = "E as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade";
	
	
	public void insereNomeMae () throws IOException{
		Reporter.addStepLog("Inserindo Nome da mãe");
		Drivers.waitForElementToBeVisible(titulo);
		String nomeMae = faker.name().fullName();
		Drivers.sendKeys(campoNomeMae, nomeMae);
		Reporter.addStepLog("Nome " + nomeMae + " inserido com sucesso.");
	}
	
	public void insereNomePai () throws IOException{
		Reporter.addStepLog("Inserindo Nome do Pai");
		Drivers.waitForElementToBeVisible(campoNomePai);
		String nomePai = faker.name().fullName();
		Drivers.sendKeys(campoNomePai, nomePai);
		Reporter.addStepLog("Nome " + nomePai + " inserido com sucesso.");
	}
	
		
	public void selecionaNacionalidadeBrasileiroNato() throws IOException{
		Reporter.addStepLog("Selecionando Nacionalidade Brasileiro Nato");
		Drivers.waitForElementToBeVisible(campoNacionalidade);
		Drivers.click(brasileiroNato);
		Drivers.marcarElemento(campoNacionalidade);
		Reporter.addStepLog("Nacionalidade Brasileiro Nato selecionado com sucesso.");
	}
	
	public void selecionaEstadoSP() throws IOException{
		Reporter.addStepLog("Selecionando Estado SP");
		Drivers.waitForElementToBeVisible(estado);
		Drivers.click(estadoSP);
		Drivers.marcarElemento(estado);
		Reporter.addStepLog("Estado de São Paulo selecionado com sucesso.");
	}
	
	public void selecionaCidadeSP() throws IOException{
		Reporter.addStepLog("Selecionando cidade de São Paulo");
		Drivers.waitForElementToBeVisible(cidade);
		Drivers.click(cidadeSaoPaulo);
		Drivers.marcarElemento(cidade);
		Reporter.addStepLog("Cidade de São Paulo selecionada com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}

}
