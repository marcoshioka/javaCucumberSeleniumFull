package Steps;

import com.everis.Utils;

import Commons.PDFGenerator;
import Commons.ReportUtils;
import PageObjects.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import report.ReportPDF;

public class LoginSteps extends LoginPage{
	private LoginPage LoginPage = new LoginPage();
	private Hooks hooks = new Hooks(); 
	private PDFGenerator pdfGenerator = new PDFGenerator();
	private Scenario scenario;
	private ReportPDF report;
	private boolean isPassed;
	
	@Before(value = "@login", order=0)
	public void initReport() throws Exception {
		//report = ReportUtils.criaTemplateEvidencia(report);
	}
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After(value = "@login", order = 0)
	public void close() throws Exception {
		pdfGenerator.geraPDF(scenario);
		hooks.closeBrowser();
		
	}

	@Dado("^que eu esteja na página de login da Pi$")
	public void que_eu_esteja_na_página_de_login_da_Pi() throws Throwable {
		LoginPage.irParaLogin();
		hooks.getEvidence();
		
	}

	@Quando("^eu insiro meu e-mail cadastrado$")
	public void eu_insiro_meu_e_mail_cadastrado() throws Throwable {
		LoginPage.inserirEmail();
		hooks.getEvidence();
	}

	@Quando("^minha senha$")
	public void minha_senha() throws Throwable {
		LoginPage.inserirSenha();
		hooks.getEvidence();
	}

	@Quando("^clico no botão de Login$")
	public void clico_no_botão_de_Login() throws Throwable {
		LoginPage.clicarBotaoLogin();
		hooks.getEvidence();
	}
		
	@Entao("^eu devo logar com sucesso na aplicação$")
	public void eu_devo_logar_com_sucesso_na_aplicação() throws Throwable {
		isPassed= LoginPage.confirmarLogin();	
		hooks.getEvidence();
	}
	
		
}
