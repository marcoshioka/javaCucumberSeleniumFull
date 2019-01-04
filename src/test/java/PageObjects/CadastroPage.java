package PageObjects;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;

public class CadastroPage extends Drivers {
	
	private Faker faker = new Faker();

	
	protected static By campoNome = By.xpath("//input[@class='slds-input']");
	protected static By campoEmail = By.xpath("//input[@class='slds-input input']");
	
	public String urlCadastro = "https://uat-green.cs96.force.com/green/s/login/SelfRegister";
	public String email = "nusus@for4mail.com";
	public String nome = faker.name().fullName();
	
	public String cadastroDado1 = "Dado que eu esteja na pagina de cadastro da Pi";
	public String cadastroQuando1 = "Quando eu envio dados validos de e-mail com senha";
	public String cadastroE1 = "E valido a informação do e-mail recebido para cadastro";
	
	
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
		Reporter.addStepLog("Inserindo e-mail: " + email);
		Drivers.waitForElementToBeClickable(campoEmail);
		Drivers.sendKeys(campoEmail, email);
		Reporter.addStepLog("E-mail " + email + " inserido com sucesso.");
	}
	
	
}
