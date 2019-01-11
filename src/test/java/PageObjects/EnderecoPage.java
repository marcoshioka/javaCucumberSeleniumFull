package PageObjects;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Commons.Sorting;
import Steps.Hooks;

public class EnderecoPage {

	Hooks hooks = new Hooks();

	Sorting sorting = new Sorting();

	Faker faker = new Faker(new Locale("pt-BR"));

	public String enderecoQuando1 = "E as informacoes de endereço";

	protected static By titulo = By.xpath("//h2[contains(text(), 'mora')]");
	protected static By campoCep = By.xpath("//input[@placeholder= 'CEP']");
	protected static By campoNumero = By.xpath("//input[@placeholder= 'Número']");
	protected static By checkBoxSim = By.xpath("//span[contains(text(), 'Sim')]//ancestor::label[@class='slds-checkbox__label']");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public void insereCep() throws IOException {
		Reporter.addStepLog("Inserindo CEP");
		Drivers.waitForElementToBeVisible(titulo);
		sorting.sort();
		RandomAccessFile random = new RandomAccessFile("./files/cepsSorteados.txt", "r");
		String cep = random.readLine();
		random.close();
		Drivers.sendKeys(campoCep, cep);
		Reporter.addStepLog("CEP " + cep + " inserido com sucesso.");
	}

	public void insereNumero() throws IOException {
		Reporter.addStepLog("Inserindo número do endereço");
		Drivers.waitForElementToBeVisible(campoNumero);
		String numero = faker.number().digits(3);
		Drivers.sendKeys(campoNumero, numero);
		Reporter.addStepLog("Número " + numero + " inserido com sucesso.");
	}
	
	public void confirmaEnderecoDeCorrespondencia() throws IOException {
		Reporter.addStepLog("Confirmando endereço de correspondência");
		Drivers.waitForElementToBeVisible(checkBoxSim);
		Drivers.click(checkBoxSim);
		Reporter.addStepLog("Endereço de correspondência confirmado com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.scrollToElement(botaoSeguir);
		Drivers.sendKeys(botaoSeguir, Keys.PAGE_DOWN.toString());
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}

	
}
