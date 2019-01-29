package Steps;

import Commons.PDFGenerator;
import PageObjects.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps extends LoginPage {
	private LoginPage LoginPage = new LoginPage();
	private Hooks hooks = new Hooks();
//	private PDFGenerator pdfGenerator = new PDFGenerator();
	
	
	@Before(value = "@login", order = 1)
	public void before(Scenario scenario) throws Exception {
		pdfGenerator.iniciaPDF(scenario);
	}

	@After(value = "@login", order = 1)
	public void finalizaPDF(Scenario scenario) throws Exception {
			pdfGenerator.fechaPDF(scenario);
	}

	@After(value = "@login", order = 0)
	public void close(Scenario scenario) throws Exception {
		hooks.closeBrowser(scenario);
	}

	@Dado("^que eu esteja na página de login da Pi$")
	public void que_eu_esteja_na_página_de_login_da_Pi() throws Throwable {
		String name = "Dado que eu esteja na página de login da Pi";
		LoginPage.irParaLogin();
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^eu insiro meu e-mail cadastrado$")
	public void eu_insiro_meu_e_mail_cadastrado() throws Throwable {
		String name = "Quando eu insiro meu e-mail cadastrado";
		LoginPage.inserirEmail();
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^minha senha$")
	public void minha_senha() throws Throwable {
		String name = "E minha senha";
		LoginPage.inserirSenha();
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^clico no botão de Login$")
	public void clico_no_botão_de_Login() throws Throwable {
		String name = " E clico no botão de Login";
		LoginPage.clicarBotaoLogin();
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Entao("^eu devo logar com sucesso na aplicação$")
	public void eu_devo_logar_com_sucesso_na_aplicação() throws Throwable {
		String name = "Então eu devo logar com sucesso na aplicação";
		LoginPage.confirmarLogin();
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^eu insiro um \"([^\"]*)\" não cadastrado$")
	public void eu_insiro_um_não_cadastrado(String emailTabela) throws Throwable {
		String name = "Quando eu insiro um '<email>' não cadastrado";
		LoginPage.inserirEmailNaoCadastrado(emailTabela);
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^uma \"([^\"]*)\" qualquer$")
	public void uma_qualquer(String senhaTabela) throws Throwable {
		String name = "E uma '<senha>' qualquer";
		LoginPage.inserirSenhaNaoCadastrada(senhaTabela);
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Então("^eu não devo logar$")
	public void eu_não_devo_logar() throws Throwable {
		String name = "Então eu não devo logar";
		LoginPage.tentarLogarSemSucesso();
			pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

}
