package Steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import PageObjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginSteps {

	private WebDriver driver = new ChromeDriver();
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	private JavascriptExecutor jse = (JavascriptExecutor) driver;
	private Hooks hooks = new Hooks(); 
	private LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

	
	@After(value = "@login", order = 0)
	public void close() {
		
		hooks.closeBrowser(driver);
		
	}

	@Dado("^que eu esteja na página de login da Pi$")
	public void que_eu_esteja_na_página_de_login_da_Pi() throws Throwable {
		Reporter.addStepLog("Acessando a página de login");
		driver.manage().window().maximize();
		driver.navigate().to("https://uat-green.cs96.force.com/green/s/login/");
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.textoLogin));
		Reporter.addStepLog("Direcionamento realizado com sucesso para a página de login");
		hooks.getEvidence(driver);
	}

	@Quando("^eu insiro meu e-mail cadastrado$")
	public void eu_insiro_meu_e_mail_cadastrado() throws Throwable {
		Reporter.addStepLog("Inserindo e-mail cadastrado");
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.campoEmail));
		LoginPage.campoEmail.sendKeys(LoginPage.emailBase);
		jse.executeScript("arguments[0].style.border='3px solid red'",LoginPage.campoEmail);
		Reporter.addStepLog("E-mail " +LoginPage.emailBase + " inserido com sucesso.");
		hooks.getEvidence(driver);
	}

	@Quando("^minha senha$")
	public void minha_senha() throws Throwable {
		Reporter.addStepLog("Inserindo senha cadastrada");
		jse.executeScript("scroll(0, 250);");
		LoginPage.campoSenha.sendKeys(LoginPage.senhaBase);
		jse.executeScript("arguments[0].style.border='3px solid blue'",LoginPage.campoSenha);
		Reporter.addStepLog("Senha "+ LoginPage.senhaBase + " inserida com sucesso.");
		hooks.getEvidence(driver);
	}

	@Quando("^clico no botão de Login$")
	public void clico_no_botão_de_Login() throws Throwable {
		Reporter.addStepLog("Clicando no botaão de login");
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.botaoLogin));
		jse.executeScript("arguments[0].style.border='3px solid green'",LoginPage.botaoLogin);
		jse.executeScript("arguments[0].click();", LoginPage.botaoLogin);
		Reporter.addStepLog("Botão clicado com sucesso");
		hooks.getEvidence(driver);
	}
		
	@Entao("^eu devo logar com sucesso na aplicação$")
	public void eu_devo_logar_com_sucesso_na_aplicação() throws Throwable {
		Reporter.addStepLog("Confirmando login realizado");
		wait.until(ExpectedConditions.visibilityOf(LoginPage.mensagemBoasVindas));
		jse.executeScript("arguments[0].style.border='3px solid red'",LoginPage.mensagemBoasVindas);
		Reporter.addStepLog("Login realizado com sucesso");
		hooks.getEvidence(driver);
	}
}
