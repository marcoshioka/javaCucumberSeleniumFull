package PageObjects;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Steps.Hooks;
import cucumber.api.java.pt.Dado;

public class SenhaPage extends Drivers {

	Hooks hooks = new Hooks();

	private Faker faker = new Faker();

	protected static By titulo = By.xpath("//span[contains(text(), 'Senha')]");
	protected static By senha = By.id("password");
	protected static By confirmaSenha = By.id("password2");
	protected static By botaoDefinirSenha = By.id("btn_confirm");
	protected static By mensagemConfirmacao = By.xpath("//h1[contains(text(), 'Senha criada com sucesso!')]");
	protected static By botaoAcessar = By.xpath("//button[@title = 'Acessar']");
	protected static By mensagemBoasVindas = By.xpath("//h2[contains(text(), 'Olá')]");
	
	public String senhaQuando1 = "E insiro informações válidas de senha ";
	public String senhaQuando2 = "E confirmo que a senha é criada com sucesso";
	
	private String senhaRandom = faker.number().digits(6);
		
	public void irParaAbaSenha() throws Throwable {
		Drivers.switchToOtherTab(1);
	}
	
	public void enviarDadosSenha() throws Throwable {
		Reporter.addStepLog("Confirmando dados de senha");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.sendKeys(senha, senhaRandom);
		hooks.salvaDados(senhaRandom);
		String senhaSalva = hooks.coletaDados();
		Drivers.sendKeys(confirmaSenha, senhaSalva);
		Reporter.addStepLog("Senha " + senhaSalva + " inserida corretamente");
	}
	
	public void confirmarSenhaInserida() {
		Reporter.addStepLog("Confirmando senha cadastrada com sucesso");
		Drivers.click(botaoDefinirSenha);
		Drivers.waitForElementToBeVisible(mensagemConfirmacao);
		Drivers.refresh();
		Drivers.click(botaoAcessar);
		Reporter.addStepLog("Senha cadastrada com sucesso");
	}
	
	
}
