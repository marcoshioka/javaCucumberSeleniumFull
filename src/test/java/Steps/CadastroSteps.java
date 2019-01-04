package Steps;

import Commons.PDFGenerator;
import PageObjects.CadastroPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class CadastroSteps {

	private CadastroPage CadastroPage = new CadastroPage();
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
		hooks.getEvidence();
		hooks.closeBrowser();
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
	   pdfGenerator.conteudoPDF(CadastroPage.cadastroQuando1);
	   hooks.getEvidence();
	}

	@Quando("^valido a informação do e-mail recebido para cadastro$")
	public void valido_a_informação_do_e_mail_recebido_para_cadastro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}
