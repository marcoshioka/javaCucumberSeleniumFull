package Steps;

import Commons.PDFGenerator;
import PageObjects.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginSteps extends LoginPage {
	private LoginPage LoginPage = new LoginPage();
	private Hooks hooks = new Hooks();
	private PDFGenerator pdfGenerator = new PDFGenerator();
	
	@Before
	public void before(Scenario scenario) throws Exception {
		pdfGenerator.iniciaPDF(scenario);
	}

	@After(value = "@login", order = 1)
	public void finalizaPDF(Scenario scenario) throws Exception {
		pdfGenerator.fechaPDF(scenario);
	}

	@After(value = "@login", order = 0)
	public void close(Scenario scenario) throws Exception {
		hooks.getEvidence();
		hooks.closeBrowser();
	}

	@Dado("^que eu esteja na página de login da Pi$")
	public void que_eu_esteja_na_página_de_login_da_Pi() throws Throwable {
		LoginPage.irParaLogin();
		pdfGenerator.conteudoPDF(LoginPage.dado1);
		hooks.getEvidence();
	}

	@Quando("^eu insiro meu e-mail cadastrado$")
	public void eu_insiro_meu_e_mail_cadastrado() throws Throwable {
		LoginPage.inserirEmail();
		pdfGenerator.conteudoPDF(LoginPage.quando1);
		hooks.getEvidence();
	}

	@Quando("^minha senha$")
	public void minha_senha() throws Throwable {
		LoginPage.inserirSenha();
		pdfGenerator.conteudoPDF(LoginPage.e1);
		hooks.getEvidence();
	}

	@Quando("^clico no botão de Login$")
	public void clico_no_botão_de_Login() throws Throwable {
		LoginPage.clicarBotaoLogin();
		pdfGenerator.conteudoPDF(LoginPage.e2);
		hooks.getEvidence();
	}

	@Entao("^eu devo logar com sucesso na aplicação$")
	public void eu_devo_logar_com_sucesso_na_aplicação() throws Throwable {
		LoginPage.confirmarLogin();
		pdfGenerator.conteudoPDF(LoginPage.entao1);
		hooks.getEvidence();
	}

}
