package Steps;

import Commons.PDFGenerator;
import PageObjects.CadastroPage;
import PageObjects.CpfPage;
import PageObjects.EmailTemporarioPage;
import PageObjects.SenhaPage;
import PageObjects.DadosPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class CadastroSteps {

	private CadastroPage CadastroPage = new CadastroPage();
	private EmailTemporarioPage EmailTemporarioPage = new EmailTemporarioPage();
	private SenhaPage SenhaPage = new SenhaPage();
	private CpfPage CpfPage = new CpfPage();
	private DadosPage DadosPage = new DadosPage();
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
		pdfGenerator.conteudoPDF(SenhaPage.senhaQuando1);
		hooks.getEvidence();
	}

	@Dado("^confirmo que a senha é criada com sucesso$")
	public void confirmo_que_a_senha_é_criada_com_sucesso() throws Throwable {
		SenhaPage.confirmarSenhaInserida();
		pdfGenerator.conteudoPDF(SenhaPage.senhaQuando2);
		hooks.getEvidence();
	}

	@Dado("^insiro CPF$")
	public void insiro_CPF() throws Throwable {
		CpfPage.insereCPF();
		pdfGenerator.conteudoPDF(CpfPage.cpfQuando1);
		hooks.getEvidence();
	}

	@Dado("^as informacoes Nome Completo, Data de nascimento, Sexo, Estado civil$")
	public void as_informacoes_Nome_Completo_Data_de_nascimento_Sexo_Estado_civil() throws Throwable {
		CpfPage.insereNomeCompleto();
		CpfPage.insereDataNascimento();
		CpfPage.selecionaSexoMasculino();
		CpfPage.selecionaEstadoCivilSolteiro();
		CpfPage.clicaSeguir();
		pdfGenerator.conteudoPDF(CpfPage.cpfQuando2);
		hooks.getEvidence();
	}

	@Dado("^as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade$")
	public void as_informacoes_Nome_da_Mãe_nome_do_pai_Nacionalidade_Estado_Cidade() throws Throwable {
	    DadosPage.insereNomeMae();
	    DadosPage.insereNomePai();
	    DadosPage.selecionaNacionalidadeBrasileiroNato();
	    DadosPage.selecionaEstadoSP();
	    DadosPage.selecionaCidadeSP();
	    DadosPage.clicaSeguir();
	    pdfGenerator.conteudoPDF(DadosPage.dadosQuando1);
		hooks.getEvidence();
	}
	
}
