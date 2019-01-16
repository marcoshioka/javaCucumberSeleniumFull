package PageObjects;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class LoginPage extends Drivers {

	protected static By textoLogin = By.id("idContText");
	protected static By campoEmail = By.xpath("//input[@type='email']");
	protected static By campoSenha = By.xpath("//input[@type='tel']");
	protected static By botaoLogin = By.xpath("//span[contains(text(),'Log in' )]");
	protected static By mensagemBoasVindas = By.xpath("//span[contains(text(),'Oi' )]");
	protected static By mensagemLoginSemSucesso = By.xpath("//div[contains(text(), 'Falha na sua tentativa de login. Verifique se o nome de usuário e a senha estão corretos.')]");

	public String urlLogin = "https://uat-green.cs96.force.com/green/s/login/";

	public String emailBase = "yieedqeu@sharklasers.com";

	public String senhaBase = "112018";

	public String dado1 = "Dado que eu esteja na página de login da Pi";
	public String quando1 = "Quando eu insiro meu e-mail cadastrado";
	public String e1 = "E minha senha";
	public String e2 = "E clico no botão de Login";
	public String entao1 = "Então eu devo logar com sucesso na aplicação";
	public String loginQuando2 = "Quando eu insiro um '<email>' não cadastrado";
	public String loginQuando3 = "E uma '<senha>' qualquer";
	public String loginEntao2 = "Então eu não devo logar";
	
	public void irParaLogin() throws Throwable {
		Reporter.addStepLog("Acessando a página de login");
		Drivers.irParaURL(urlLogin);
		Drivers.waitForElementToBeClickable(textoLogin);
		Reporter.addStepLog("Direcionamento realizado com sucesso para a página de login");
	}

	public void inserirEmail() throws Throwable {
		Reporter.addStepLog("Inserindo e-mail cadastrado");
		Drivers.waitForElementToBeClickable(campoEmail);
		Drivers.sendKeys(campoEmail, emailBase);
		Reporter.addStepLog("E-mail " + emailBase + " inserido com sucesso.");
	}

	public void inserirSenha() throws Throwable {
		Reporter.addStepLog("Inserindo senha cadastrada");
		Drivers.sendKeys(campoSenha, senhaBase);
		Reporter.addStepLog("Senha " + senhaBase + " inserida com sucesso.");
	}

	public void clicarBotaoLogin() throws Throwable {
		Reporter.addStepLog("Clicando no botão de login");
		Drivers.waitForElementToBeClickable(botaoLogin);
		Drivers.jsClick(botaoLogin);
		Reporter.addStepLog("Botão clicado com sucesso");
	}

	public void confirmarLogin() {
		Reporter.addStepLog("Confirmando login realizado");
		Drivers.waitForElementToBeVisible(mensagemBoasVindas);
		Drivers.marcarElemento(mensagemBoasVindas);
		Reporter.addStepLog("Login realizado com sucesso");
	}

	public void inserirEmailNaoCadastrado(String email) throws Throwable {
		Reporter.addStepLog("Inserindo e-mail não cadastrado");
		Drivers.waitForElementToBeClickable(campoEmail);
		Drivers.sendKeys(campoEmail, email);
		Reporter.addStepLog("E-mail " + email + " inserido com sucesso.");
	}
	
	public void inserirSenhaNaoCadastrada(String senha) throws Throwable {
		Reporter.addStepLog("Inserindo senha não cadastrada");
		Drivers.sendKeys(campoSenha, senha);
		Reporter.addStepLog("Senha " + senha + " inserida com sucesso.");
	}
	
	public void tentarLogarSemSucesso() throws Throwable {
		Reporter.addStepLog("Validando mensagem de login sem sucesso");
		Drivers.waitForElementToBeVisible(mensagemLoginSemSucesso);
		Drivers.marcarElemento(mensagemLoginSemSucesso);
		Reporter.addStepLog("Mensagem de login inválido exibida corretamente.");
	}
	
	
}
