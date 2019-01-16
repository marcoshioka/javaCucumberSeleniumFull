package Steps;

import Commons.PDFGenerator;
import PageObjects.CadastroPage;
import PageObjects.CodigoSmsPage;
import PageObjects.ContatoPage;
import PageObjects.CpfPage;
import PageObjects.DadosPage;
import PageObjects.DeclaracaoAutorizacaoPage;
import PageObjects.DocumentoPage;
import PageObjects.EmailTemporarioPage;
import PageObjects.EnderecoPage;
import PageObjects.PoliticamenteExpostoPage;
import PageObjects.ProfissaoPage;
import PageObjects.RendaPatrimonioPage;
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
	private CpfPage CpfPage = new CpfPage();
	private DadosPage DadosPage = new DadosPage();
	private EnderecoPage EnderecoPage = new EnderecoPage();
	private DocumentoPage DocumentoPage = new DocumentoPage();
	private ContatoPage ContatoPage = new ContatoPage();
	private CodigoSmsPage CodigoSmsPage = new CodigoSmsPage();
	private PoliticamenteExpostoPage PoliticamenteExpostoPage = new PoliticamenteExpostoPage();
	private ProfissaoPage ProfissaoPage = new ProfissaoPage();
	private RendaPatrimonioPage RendaPatrimonioPage = new RendaPatrimonioPage();
	private DeclaracaoAutorizacaoPage DeclaracaoAutorizacaoPage = new DeclaracaoAutorizacaoPage();
	private Hooks hooks = new Hooks();
	private PDFGenerator pdfGenerator = new PDFGenerator();

	@Before(value = "@cadastro", order = 1)
	public void before(Scenario scenario) throws Exception {
		pdfGenerator.iniciaPDF(scenario);
	}

	@After(value = "@cadastro", order = 1)
	public void finalizaPDF(Scenario scenario) throws Exception {
		pdfGenerator.fechaPDF(scenario);
	}

	@After(value = "@cadastro", order = 0)
	public void close(Scenario scenario) throws Exception {
		hooks.closeBrowser(scenario);
	}

	@Dado("^que eu tenha um email para cadastro$")
	public void que_eu_tenha_um_email_para_cadastro() throws Throwable {
		String name = "Dado que eu tenha um email para cadastro";
		EmailTemporarioPage.irParaUrlTempMail();
		EmailTemporarioPage.armazenaEmail();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^que eu esteja na pagina de cadastro da Pi$")
	public void que_eu_esteja_na_pagina_de_cadastro_da_Pi() throws Throwable {
		String name = "E que eu esteja na pagina de cadastro da Pi";
		CadastroPage.irParaCadastro();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^eu envio nome valido com e-mail$")
	public void eu_envio_nome_valido_com_e_mail() throws Throwable {
		String name = "Quando eu envio nome valido com e-mail";
		CadastroPage.inserirNome();
		CadastroPage.inserirEmail();
		CadastroPage.clicarBotaoEnviar();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Quando("^valido a informação do e-mail recebido para cadastro$")
	public void valido_a_informação_do_e_mail_recebido_para_cadastro() throws Throwable {
		String name = "E valido a informação do e-mail recebido para cadastro";
		EmailTemporarioPage.irParaUrlTempMail();
		EmailTemporarioPage.aguardaEmailEConfirma();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^insiro informações válidas de senha$")
	public void insiro_informações_válidas_de_senha() throws Throwable {
		String name = "E insiro informações válidas de senha";
		SenhaPage.irParaAbaSenha();
		SenhaPage.enviarDadosSenha();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^confirmo que a senha é criada com sucesso$")
	public void confirmo_que_a_senha_é_criada_com_sucesso() throws Throwable {
		String name = "E confirmo que a senha é criada com sucesso";
		SenhaPage.confirmarSenhaInserida();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^insiro CPF$")
	public void insiro_CPF() throws Throwable {
		String name = "E insiro CPF";
		CpfPage.insereCPF();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^as informacoes Nome Completo, Data de nascimento, Sexo, Estado civil$")
	public void as_informacoes_Nome_Completo_Data_de_nascimento_Sexo_Estado_civil() throws Throwable {
		String name = "E as informacoes Nome Completo, Data de nascimento, Sexo, Estado civil";
		CpfPage.insereNomeCompleto();
		CpfPage.insereDataNascimento();
		CpfPage.selecionaSexoMasculino();
		CpfPage.selecionaEstadoCivilSolteiro();
		CpfPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade$")
	public void as_informacoes_Nome_da_Mãe_nome_do_pai_Nacionalidade_Estado_Cidade() throws Throwable {
		String name = "E as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade";
		DadosPage.insereNomeMae();
		DadosPage.insereNomePai();
		DadosPage.selecionaNacionalidadeBrasileiroNato();
		DadosPage.selecionaEstadoSP();
		DadosPage.selecionaCidadeSP();
		DadosPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^as informacoes de endereço$")
	public void as_informacoes_de_endereço() throws Throwable {
		String name = "E as informacoes de endereço";
		EnderecoPage.insereCep();
		EnderecoPage.insereNumero();
		EnderecoPage.confirmaEnderecoDeCorrespondencia();
		EnderecoPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^insiro as informações de CNH$")
	public void insiro_as_informações_de_CNH() throws Throwable {
		String name = "E insiro as informações de CNH";
		DocumentoPage.selecionaOpcaoCNH();
		DocumentoPage.insereNumeroDoRegistroCNH();
		DocumentoPage.selecionaOrgaoEmissorDetran();
		DocumentoPage.insereDataEmissaoCNH();
		DocumentoPage.selecionaEstadoEmitenteSP();
		DocumentoPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^insiro as informações de contato$")
	public void insiro_as_informações_de_contato() throws Throwable {
		String name = "E insiro as informações de contato";
		ContatoPage.verificarPaginaContatos();
		ContatoPage.inserirNumeroTelefoneCelular();
		ContatoPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^seleciono Tentar mais tarde para envio do SMS$")
	public void seleciono_Tentar_mais_tarde_para_envio_do_SMS() throws Throwable {
		String name = "E seleciono Tentar mais tarde para envio do SMS";
		CodigoSmsPage.verificarPaginaSms();
		CodigoSmsPage.clicarTentarMaisTarde();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^informo que não sou politicamente exposto$")
	public void informo_que_não_sou_politicamente_exposto() throws Throwable {
		String name = "E informo que não sou politicamente exposto";
		PoliticamenteExpostoPage.verificarPaginaPoliticamenteExposto();
		PoliticamenteExpostoPage.clicarBotaoNao();
		PoliticamenteExpostoPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}
	
	@Dado("^informo minha profissão$")
	public void informo_minha_profissão() throws Throwable {
		String name = "E informo minha profissão";
		ProfissaoPage.verificarPaginaProfissao();
		ProfissaoPage.selecionarProfissaoAnalistaDeSistemas();
		ProfissaoPage.informarInstituicaoOndeTrabalha();
		ProfissaoPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}

	@Dado("^informo minha renda, sem patrimônio$")
	public void informo_minha_renda_sem_patrimônio() throws Throwable {
		String name = "E informo minha renda, sem patrimônio";
		RendaPatrimonioPage.verificarPaginaRendaPatrimonio();
		RendaPatrimonioPage.insereRendaMensal();
		RendaPatrimonioPage.selecionaNaoPossuoPatrimonio();
		RendaPatrimonioPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}
	
	@Dado("^informo Não em todos os itens de Declarações e Autorizações$")
	public void informo_Não_em_todos_os_itens_de_Declarações_e_Autorizações() throws Throwable {
		String name = "E informo Não em todos os itens de Declarações e Autorizações";
		DeclaracaoAutorizacaoPage.verificarPaginaDeclaracoesAutorizacoes();
		DeclaracaoAutorizacaoPage.clicaSeguir();
		pdfGenerator.conteudoPDF(name);
		hooks.getEvidence();
	}
}
