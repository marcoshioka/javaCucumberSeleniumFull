package Steps;

import Commons.PDFGenerator;
import PageObjects.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroSteps {

    private CadastroPage CadastroPage = new CadastroPage();
    private DadosUnificadosPage DadosUnificadosPage = new DadosUnificadosPage();
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
    private TermosPage TermosPage = new TermosPage();
    private DadosBancariosPage DadosBancariosPage = new DadosBancariosPage();
    private MinhasContasPage MinhasContasPage = new MinhasContasPage();
    private AvisoFotoPage AvisoFotoPage = new AvisoFotoPage();
    private FotoPage FotoPage = new FotoPage();
    private FaltaPoucoPage FaltaPoucoPage = new FaltaPoucoPage();
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

    @Quando("^eu envio dados unificados de cadastro$")
    public void eu_envio_dados_unificados_de_cadastro() throws Throwable {
        String name = "Quando eu envio dados unificados de_cadastro";
        DadosUnificadosPage.inserirNome();
        DadosUnificadosPage.inserirEmail();
        DadosUnificadosPage.confirmarEmail();
        DadosUnificadosPage.enviarDadosSenha();
        DadosUnificadosPage.clicaSeguir();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();

    }


    @Quando("^eu envio nome valido com e-mail$")
    public void eu_envio_nome_valido_com_e_mail() throws Throwable {
        String name = "Quando eu envio nome valido com e-mail";
        CadastroPage.inserirNome();
        CadastroPage.inserirEmail();
        CadastroPage.clicarBotaoEnviar();
        //CadastroPage.verificarMensagemEmailEnviado();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();
    }

    @E("^verifico a mensagem para entrar no link enviado por e-mail$")
    public void verifico_a_mensagem_para_entrar_no_link_enviado_por_e_mail() throws Throwable {
        String name = "E verifico a mensagem para entrar no link enviado por e-mail";
        CadastroPage.verificarMensagemEmailEnviado();
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
        //CpfPage.irParaTelaCPF();
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

    @Dado("^as informacoes Nome da Mãe, Nacionalidade, Estado, Cidade$")
    public void as_informacoes_Nome_da_Mãe_Nacionalidade_Estado_Cidade() throws Throwable {
        String name = "E as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade";
        DadosPage.insereNomeMae();
        //DadosPage.insereNomePai();
        DadosPage.selecionaNacionalidadeBrasileiroNato();
        DadosPage.selecionaEstadoSP();
        DadosPage.selecionaCidadeSP();
        //DadosPage.selecionaEstadoSP();
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

    @Quando("^sigo sem código pela tela de envio de SMS$")
    public void sigo_sem_código_pela_tela_de_envio_de_SMS() throws Throwable {
        String name = "E sigo sem código pela tela de envio de SMS";
        CodigoSmsPage.verificarPaginaSms();
        CodigoSmsPage.clicaSeguir();
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

    @Dado("^aceite todos os termos$")
    public void aceite_todos_os_termos() throws Throwable {
        String name = "E aceite todos os termos";
        TermosPage.verificarPaginaTermos();
        TermosPage.aceitarTermoDeclaracaoResidencia();
        TermosPage.aceitarTermoCondicoesGerais();
        TermosPage.aceitarTermoRegrasParametro();
        TermosPage.aceitarTermoAdesao();
        TermosPage.clicaSeguir();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();
    }

    @Dado("^informo meus dados bancários$")
    public void informo_meus_dados_bancários() throws Throwable {
        String name = "E informo meus dados bancários";
        DadosBancariosPage.verificarPaginaDadosBancarios();
        DadosBancariosPage.selecionarBancoSantander();
        DadosBancariosPage.selecionarContaPoupança();
        DadosBancariosPage.selecionarContaCorrente();
        DadosBancariosPage.inserirAgencia();
        DadosBancariosPage.inserirNumeroConta();
        DadosBancariosPage.clicaSeguir();
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


    @Dado("^confirmo minha conta bancária cadastrada$")
    public void confirmo_minha_conta_bancária_cadastrada() throws Throwable {
        String name = "E confirmo minha conta bancária cadastrada";
        MinhasContasPage.verificarPaginaMinhasContas();
        MinhasContasPage.verificarExibicaoContaCadastrada();
        MinhasContasPage.clicaSeguir();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();
    }

    @Dado("^sigo adiante na tela do aviso de foto$")
    public void sigo_adiante_na_tela_do_aviso_de_foto() throws Throwable {
        String name = "E sigo adiante na tela do aviso de foto";
        AvisoFotoPage.verificarPaginaAvisoFoto();
        AvisoFotoPage.clicarVamosLa();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();

    }

    @Dado("^escolho seguir sem enviar a imagem$")
    public void escolho_seguir_sem_enviar_a_imagem() throws Throwable {
        String name = "E escolho seguir sem enviar a imagem";
        FotoPage.verificarPaginaFoto();
        FotoPage.clicarPular();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();
    }

    @Então("^devo ver a mensagem de Falta Pouco$")
    public void devo_ver_a_mensagem_de_Falta_Pouco() throws Throwable {
        String name = "Então devo ver a mensagem de Falta Pouco";
        FaltaPoucoPage.verificarPaginaFaltaPouco();
        FaltaPoucoPage.verificarExibicaoMensagem();
        FaltaPoucoPage.verificarConhecerCatalogo();
        pdfGenerator.conteudoPDF(name);
        hooks.getEvidence();
    }
}
