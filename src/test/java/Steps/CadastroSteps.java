package Steps;

import Commons.PDFGenerator;
import PageObjects.CadastroPage;
import PageObjects.EmailTemporarioPage;
import PageObjects.SenhaPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class CadastroSteps {

	private CadastroPage CadastroPage = new CadastroPage();
	private EmailTemporarioPage EmailTemporarioPage = new EmailTemporarioPage();
	private SenhaPage SenhaPage = new SenhaPage();
	private Hooks hooks = new Hooks();
	private PDFGenerator pdfGenerator = new PDFGenerator();

	@Before
	public void before(Scenario scenario) throws Exception {
		pdfGenerator.iniciaPDF(scenario);
	}

	@After(value = "@cadastro", order = 1)
	public void finalizaPDF(Scenario scenario) throws Exception {
		pdfGenerator.fechaPDF(scenario);
	}

	@After(value = "@cadastro", order = 0)
	public void close(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			hooks.getEvidence();
			hooks.closeBrowser();
		} else {
			hooks.closeBrowser();
		}
	}

	@Dado("^que eu tenha um email para cadastro$")
	public void que_eu_tenha_um_email_para_cadastro() throws Throwable {
		EmailTemporarioPage.irParaUrlTempMail();
		EmailTemporarioPage.armazenaEmail();
		pdfGenerator.conteudoPDF(EmailTemporarioPage.cadastroDado1);
		hooks.getEvidence();
	}

	@Dado("^que eu esteja na pagina de cadastro da Pi$")
	public void que_eu_esteja_na_pagina_de_cadastro_da_Pi() throws Throwable {
		CadastroPage.irParaCadastro();
		pdfGenerator.conteudoPDF(CadastroPage.cadastroDado1);
		hooks.getEvidence();
	}

	@Quando("^eu envio nome valido com e-mail$")
	public void eu_envio_nome_valido_com_e_mail() throws Throwable {
		CadastroPage.inserirNome();
		CadastroPage.inserirEmail();
		CadastroPage.clicarBotaoEnviar();
		pdfGenerator.conteudoPDF(CadastroPage.cadastroQuando1);
		hooks.getEvidence();
	}

	@Quando("^valido a informação do e-mail recebido para cadastro$")
	public void valido_a_informação_do_e_mail_recebido_para_cadastro() throws Throwable {
		EmailTemporarioPage.irParaUrlTempMail();
		EmailTemporarioPage.aguardaEmailEConfirma();
		pdfGenerator.conteudoPDF(EmailTemporarioPage.cadastroQuando1);
		hooks.getEvidence();
	}
	
	@Dado("^insiro informações válidas de senha$")
	public void insiro_informações_válidas_de_senha() throws Throwable {
		SenhaPage.irParaAbaSenha();
		SenhaPage.enviarDadosSenha();
		SenhaPage.confirmarSenhaInserida();
		pdfGenerator.conteudoPDF(SenhaPage.senhaQuando1);
		hooks.getEvidence();
	}

}
