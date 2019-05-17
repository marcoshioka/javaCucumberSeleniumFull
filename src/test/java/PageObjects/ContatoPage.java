package PageObjects;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;


import Commons.Drivers;
import Steps.Hooks;

public class ContatoPage {

	Hooks hooks = new Hooks();

	private Faker faker = new Faker(new Locale("pt-BR"));

	protected static By titulo = By.xpath("//span[contains(text(), 'seu celular')]");
	protected static By campoEmail = By.xpath("//input[@placeholder='Email']");
	protected static By campoCelular = By.xpath("//input[@placeholder='Celular']");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");

	public String numeroCelular = faker.number().digits(11);

	public void verificarPaginaContatos() throws Throwable {
		Reporter.addStepLog("Verificando a página de contatos");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		//Drivers.waitForElementToBeVisible(campoEmail);
		//Drivers.marcarElemento(campoEmail);
		Reporter.addStepLog("Página verificada com sucesso.");
	}

	public void inserirNumeroTelefoneCelular() throws Throwable {
		Reporter.addStepLog("Inserindo o número do telefone celular");
		Drivers.sendKeys(campoCelular, numeroCelular);
		Drivers.sendKeys(campoCelular, Keys.TAB.toString());
		Reporter.addStepLog("Número " + numeroCelular + " inserido com sucesso.");
	}

	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}
	
}
