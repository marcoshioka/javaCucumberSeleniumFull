package PageObjects;

import java.util.Locale;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Steps.Hooks;
import org.openqa.selenium.Keys;

public class CadastroPage extends Drivers {

	Hooks hooks = new Hooks();
	
	private Faker faker = new Faker(new Locale("pt-BR"));

	
	protected static By campoNome = By.xpath("//input[@class='slds-input']");
	protected static By campoEmail = By.xpath("//input[@type='email']");
	protected static By botaoEnviar = By.xpath("//button[contains(text(), 'Enviar')]");
	protected static By mensagemEnvioEmail = By.xpath("//span[contains(text(), 'entrar no seu e-mail ')]");
	
	
	public String urlCadastro = "https://uat-green.cs96.force.com/green/s/login/SelfRegister";
	
	public String nome = faker.name().firstName();
	
	public void irParaCadastro() throws Throwable {
		Reporter.addStepLog("Acessando a página de login");
		Drivers.irParaURL(urlCadastro);
		Drivers.waitForElementToBeClickable(campoNome);
		Reporter.addStepLog("Direcionamento realizado com sucesso para a página de login");
	}
	
	public void inserirNome() throws Throwable {
		Reporter.addStepLog("Inserindo nome: " + nome );
		Drivers.waitForElementToBeClickable(campoNome);
		Drivers.sendKeys(campoNome, nome);
		Reporter.addStepLog("Nome " + nome + " inserido com sucesso.");
	}

	public void inserirEmail() throws Throwable {
		Reporter.addStepLog("Inserindo e-mail: " + hooks.coletaDados());
		Drivers.waitForElementToBeClickable(campoEmail);
		Drivers.sendKeys(campoEmail, hooks.coletaDados());
		Drivers.sendKeys(campoEmail,Keys.TAB.toString());
		Reporter.addStepLog("E-mail " + hooks.coletaDados() + " inserido com sucesso.");
	}
	
	public void clicarBotaoEnviar() throws Throwable {
		Reporter.addStepLog("Clicando no botao Enviar" );
		Drivers.waitForElementToBeClickable(botaoEnviar);
		Drivers.click(botaoEnviar);
		Reporter.addStepLog("Botão Enviar acionado com sucesso.");
	}

	public void verificarMensagemEmailEnviado() throws Throwable{
		Reporter.addStepLog("Verificando mensagem de e-mail enviado");
		Drivers.waitForElementToBeVisible(mensagemEnvioEmail);
		Drivers.marcarElemento(mensagemEnvioEmail);
		Reporter.addStepLog("Mensagem de envio de e-mail verificada com sucesso");
	}
}
