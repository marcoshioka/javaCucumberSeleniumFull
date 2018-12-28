package utils;

import java.nio.file.Paths;

/**
 * Classe de constantes.
 * @author Leonardo Costa
 *
 */
public final class Constants {
	

	/**
	 * Xpaths
	 */
	/** Xpaths Home Page**/
	public static final String XPATH_LINK_HOME = "https://uat-green.cs96.force.com/green/s/";
	public static final String XPATH_BTN_INVISTA_AGORA = "//button[contains(text(),'Invista agora')]";
	public static final String XPATH_BTN_VER_INVESTIMENTOS = "//button[contains(text(),'Ver investimentos')]";
	
	public static final String XPATH_INPUT_PESQUISA = ".//*[@id='cse-search-box']/div/div/input[4]";
	public static final String XPATH_BTN_PESQUISAR = "html/body/div[1]/div[1]/div/div/div[2]/ul/li[6]/i";
	public static final String XPATH_BTN_ENTRAR = ".//*[@id='submitButton']";
	public static final String XPATH_OUTLOOK = "//div[contains(text(),'Outlook')]";
	public static final String XPATH_LUPA_RESULTADO = ".//*[@id='cse-search-box']/divc/div/span/button";
	public static final String XPATH_PROVISORIO = "html/body/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[1]/h1";
	public static final String XPATH_BOAS_VINDAS = ".//*[@id='mobile_screen']//a";
	public static final String XPATH_NOME_COMPLETO_TELA_INICIAL = "//input[@id='input-1']";
	public static final String XPATH_NOME_COMPLETO = "//input[@placeholder='Nome completo']";
	public static final String XPATH_CONFIRMACAO_EMAIL = "//h2[contains(text(),'Bom, agora você')]";
	public static final String XPATH_EMAIL = "//input[@placeholder='Email']";
	public static final String XPATH_CRIAR_SENHA = "//input[@placeholder='Criar senha']";
	public static final String XPATH_RETORNO_TELA_CADASTRO = "//h2[contains(text(),'Cadastre-se colocando seu nome')]";
	public static final String XPATH_RETORNO_TELA_PRODUTOS = ".//*[@id='1']/span[contains(text(),'CDB-PRE-292')]";
	public static final String XPATH_BOTAO_SEGUIR = "//button[contains(text(),'Seguir')]";

	public static final String XPATH_BOTAO_IRPAGINAINICIAL = "//button[contains(text(),'Ir para página inicial')]";
	

	public static final String XPATH_LINK_COMPLETAR_DEPOIS = "//a[contains(text(), 'Cadastro Depois')]";
	public static final String XPATH_CPF = "//input[@placeholder='CPF']";
	public static final String XPATH_MSG_ERRO_CPF_CADASTRADO = "//span[contains(text(),'CPF já cadastrado')]";
	public static final String XPATH_CPF_DATA_NASCIMENTO = "//input[@placeholder='Data de nascimento']";
	public static final String XPATH_MSG_ERRO_MENOR_IDADE = "//span[contains(text(),'É necessário ser maior de idade')]";
	public static final String XPATH_SELECT_SEXO = "//select[@name='sexo']/..";
	public static final String XPATH_SELECT_ESTADO_CIVIL = "//select[@name='estadoCivil']";
	public static final String XPATH_CONFIRMACAO_CONTATOS = "//h2[contains(text(),'Por favor, confirme seus contatos')]";
	public static final String XPATH_NOME_MAE = "//input[@placeholder='Nome da mãe']";
	public static final String XPATH_NOME_PAI = "//input[@placeholder='Nome do pai']";
	public static final String XPATH_COMBO_PAIS = "//option[@value = 'País']";
	public static final String XPATH__MSG_ERRO_GENERICO = "//span[contains(@class, 'error error_msg')]";
	public static final String XPATH_MSG_ERRO_CPF_INVALIDO = "//div[contains(@class, 'error error_msg') and text() = 'Este CPF não é valido']";
	public static final String XPATH_MSG_ERRO_EMAIL = "//span[contains(@class, 'error error_msg') and text() = 'O email não é válido']";
	public static final String XPATH_MSG_ERRO_SENHA = "//span[contains(@class, 'error error_msg') and text() = 'A senha deve conter ao menos 8 caracteres contendo 1 caractere especial, letras e numeros']";
	public static final String XPATH_MSG_ERRO_CPF = "//span[contains(@class, 'error error_msg') and text() = 'Por favor digite um CPF válido']";
	public static final String XPATH_MSG_ERRO_SENHA_DIFERENTES = "//span[contains(text(),'As senhas não coincidem')]";
	public static final String XPATH_MSG_ERRO_SENHA_VAZIA = "//div[contains(text(),'É necessário inserir um valor')]";
	public static final String XPATH_MSG_ERRO_RG_DATA_INVALIDA = "//span[contains(text(),'A data informada é inválida.')]";
	public static final String XPATH_CPF_CASADO_CONJUGUE = "//input[@placeholder='CPF do conjugue']";
	public static final String XPATH_MSG_ERRO_CPF_CONJUGE_INVALIDO = "//span[contains(text(),'Por favor digite um CPF válido')]";
	public static final String XPATH_CPF_CASADO_NOME_CONJUGUE = "//input[@placeholder='Nome conjugue']";
	public static final String XPATH_CPF_CASADO_DATA_NASC_CONJUGUE = "//input[@placeholder='Data de Nascimento do Conjugue']";
	public static final String XPATH_BTN_NAO_SEI_CEP = "//a[@class='naoSeiMeuCEP']";
	public static final String XPATH_ENDERECO_NAO_SEI_CEP = "//input[@placeholder='Endereço']";
	public static final String XPATH_NUMERO_NAO_SEI_CEP = "//input[@placeholder='Número']";
	public static final String XPATH_BAIRRO_NAO_SEI_CEP = "//input[@placeholder='Bairro']";
	public static final String XPATH_LISTA_CEPS_NAO_SEI_CEP = "//p[contains(text(),'CEP: ')]";
	public static final String XPATH_BTN_ENCONTRAR_CEP = "//button[@class='slds-button slds-button_neutral slds-button slds-button_neutral findCep']";
	public static final String XPATH_CEP = "//input[@placeholder='CEP']";
	public static final String XPATH_CEP_COBRANCA = ".//*[@id='input-14']";
	public static final String XPATH_NUMERO_RUA = "//input[@placeholder='Número']";
	public static final String XPATH_NUMERO_RUA_COBRANCA = ".//*[@id='input-16']";
	public static final String XPATH_COMPLEMENTO = "//input[@placeholder='Complemento']";
	public static final String XPATH_COMPLEMENTO_COBRANCA = ".//*[@id='input-17']";
	public static final String XPATH_END_SIM = "//span[contains(text(),'Sim')]/preceding-sibling::span/..";
	public static final String XPATH_END_NAO = "//span[contains(text(),'Não')]/preceding-sibling::span";
	public static final String XPATH_BTN_CNH = "//button[@name='botaoCNH']";
	public static final String XPATH_NAO_SEI_MEU_CEP_CIDADE = "//input[@placeholder='Cidade']";
	public static final String XPATH_BTN_RG = "//button[@name='botaoRG']";
	public static final String XPATH_BTN_OUTROS = "//button[@name='botaoOutros']";
	public static final String XPATH_CNH_NUMERO_REGISTRO = "//input[@placeholder='Número do registro']";
	public static final String XPATH_CNH_CODIGO_SEGURANCA = "//input[@placeholder='Código de segurança']";
	public static final String XPATH_CNH_DT_EMISSAO = "//input[@placeholder='Data de emissão']";
	public static final String XPATH_CNH_ESTADO = "//input[@placeholder='Estado']";
	public static final String XPATH_NUMERO_RG = "//input[@placeholder='Número RG']";
	public static final String XPATH_RG_DT_EMISSAO = "//input[@placeholder='Data de emissão']";
	public static final String XPATH_TIPO_DE_DOCUMENTOS = "";
	public static final String XPATH_OUTROS_="//input[@placeholder='Data de emissão']";
	public static final String XPATH_CONTATO_EMAIL = "//input[@placeholder='Email']";
	public static final String XPATH_CONTATO_TELEFONE_RESIDENCIAL= "//input[@placeholder='Telefone']";
	public static final String XPATH_CONTATO_TELEFONE_CELULAR = "//input[@placeholder='Celular']";
	public static final String XPATH_CODIGO_SMS = "//label[contains(text(),'Código SMS')]//following-sibling::div/input";
	public static final String XPATH_CODIGO_SMS_TENTE_MAIS_TARDE = "//button[contains(text(),'Tentar mais tarde')]";
	public static final String XPATH_REENVIAR_SMS = "//span[contains(text(),'Reenviar SMS')]";
	public static final String XPATH_TENTAR_MAIS_TARDE = "//span[contains(text(),'Tentar mais tarde')]";
	public static final String XPATH_POLITICAMENTE_SIM = "//button[contains(text(),'Sim')]";
	public static final String XPATH_POLITICAMENTE_NAO = "//button[@name = 'BotaoExpNao']";
	public static final String XPATH_EMAIL_LOGIN = "//input[@id='input-2']";
	public static final String XPATH_BTN_ENVIAR_CADEMAIL = "//button[contains(text(),'Enviar')]";

	public static final String XPATH_CNH_ICONE_EXPLIC_COD_SEG = "//img[@class='floatRight sizeImg mt-48px']";
	public static final String XPATH_CNH_EXPLIC_IMG_DOCUMENTO = "//img[@class='sizeImgCNH']";
	public static final String XPATH_CNH_TEXTO_EXPLICATIVO = "//span[contains(text(), 'É uma sequência numérica que fica posicionada do lado direito à assinatura do emissor.')]";
	

	public static final String XPATH_LINK_NAOEVOCE= "(//*[@href='javascript:void(0);'])[3]";
	public static final String XPATH_LINK_LOGIN= "(//*[@href='javascript:void(0);'])[4]";
	public static final String XPATH_PAGINAABERTURADECHAMADO= "//*[contains(text(),'Precisamos do seu CPF para continuar')]";

	/**public static final String XPATH_BTN_ENVIAR_CADEMAIL = "//input[@class='input inputContainer sfdc_usernameinput input']";**/
	public static final String XPATH_SENHA_LOGIN = "//input[@placeholder='Senha']";
	public static final String XPATH_BTN_ACESSAR = "//span[contains(text(),'Acessar')]/..";
	public static final String XPATH_NOVA_SENHA_SF = ".//*[@id='password']";
	public static final String XPATH_CONFIRMA_NOVA_SENHA_SF = ".//*[@id='password2']";
	public static final String XPATH_BTN_PASSWORD_SF = ".//*[@id='btn_confirm']";
	public static final String XPATH_BTN_ACESSAR_CARTEIRA = ".//button[contains(text(),'Acessar')]";
	
	/** Menu da HomePage **/
	public static final String XPATH_MENU_OPCAO_CADASTRO = "//span[contains(text(),'Cadastro')]/..";
	public static final String XPATH_MENU_OPCAO_LOGOUT = "//span[contains(text(),'Logout')]/..";	
	public static final String XPATH_MENU_ICON = "//div[@style = 'background-image:url(/green/resource/1536091625000/Header_icon_Menu)']";
	public static final String XPATH_VALIDA_HOME = "//button[contains(text(),'Ver investimentos')]";
	public static final String XPATH_BOTAO_PERFIL = "//a[contains(text(),'Meu Perfil')]";
	
	/** Elementos meu Perfil **/
	public static final String XPATH_PERFIL_RISCO_1 = "//div[@class = 'risco-1 boxRisco'][1]";
	
	/** Menu Logado e Não logado **/
	public static final String XPATH_EMAIL_CADASTRADO = "//input[@class='input inputContainer sfdc_usernameinput input']";  
	public static final String XPATH_SENHA_CADASTRADA = "//input[@type='password']";
	public static final String XPATH_BOTAO_LOGIN = "//span[contains(text(),'Log in' )]";
	public static final String XPATH_MENU_OPCAO_LOGIN = "//a[contains(text(),'Login')]";
	public static final String XPATH_MENU_OPCAO_MINHA_CONTA_PI = "//a[contains(text(),'Minha conta Pi')]";
	public static final String XPATH_MENU_OPCAO_MINHA_CARTEIRA = "//a[contains(text(),'Minha carteira')]";	
	public static final String XPATH_BOTAO_VAMOSLA_CARTEIRA = "//button[contains(text(),'Vamos lá')]";
	public static final String XPATH_MENU_OPCAO_HISTORICO_DE_TRANSACOES = "//a[contains(text(),'Histórico de transações')]";
	public static final String XPATH_MENU_OPCAO_SAIR = "//li/a[contains(text(),'Sair')]";
	public static final String XPATH_MENU_OPCAO_ABRA_SUA_CONTA = "//button[@class='btn-abrirConta']";
	public static final String XPATH_MENSAGEM_BOAS_VINDAS = "//span[contains(text(),'Oi')]";
	public static final String XPATH_BOTAO_MENU = "//div[@class='estiloIconMenu visualizacao']";
	public static final String XPATH_BOTAO_CONFIRMACAO_COOKIES = "//button[@title='Entendi']";
	public static final String XPATH_TITULO_TELA_ABRA_SUA_CONTA = "//span[@class='tituloChamado']";
	public static final String XPATH_TITULO_TELA_LOGIN = "//h1[@id='idContText']";
	public static final String XPATH_TITULO_TELA_MINHA_CONTA_PI = "//span[contains(text(),'Minha Conta Pi')]";
	public static final String XPATH_TITULO_TELA_MINHA_CARTEIRA = "//span[contains(text(),'Saldo Pi')]";
	public static final String XPATH_TITULO_TELA_HISTORICO_DE_TRANSACOES = "//span[contains(text(),'Histórico de transações')]";
	public static final String XPATH_TITULO_MODAL_OPCAO_SAIR = "//span[contains(text(),'Deseja realmente sair?')]";
	public static final String XPATH_MENU_OPCAO_MEUS_DADOS_BANCARIOS = "//a[contains(text(),'Meus dados bancários')]";
	
	
	/** Xpaths da HomePage */
	//FIXME absolute xpath temp.
	public static final String XPATH_MENU_DIREITO_SUPERIOR = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]/div[1]/button[1]/lightning-primitive-icon[1]/*";
	
	public static final String XPATH_MENU_INDICADOS = "//span[contains(text(),'indicados')]/../following-sibling::div//button//lightning-primitive-icon";
	public static final String XPATH_MENU_OBJETIVOS = "//span[contains(text(),'objetivo')]/../following-sibling::div//button//lightning-primitive-icon";
	public static final String XPATH_MENU_PRODUTOS = "//span[contains(text(),'Produtos')]/../following-sibling::div//button//lightning-primitive-icon";
	public static final String XPATH_MENU_SIMULE_O_MEU_INVESTIMENTO = "//span[contains(text(),'Simule')]/../following-sibling::div//button//lightning-primitive-icon";
	public static final String XPATH_BOTAO_INVISTA_AGORA = "//button[contains(text(),'Invista agora')]";
	
	/** xpath botao voltar de objetivos e produtos usado na HomePage tests */
	public static final String XPATH_VOLTAR_USADO_HOMEPAGE = ".//*[contains(@class, 'voltar')]/button";
	
	/**Social Login Google Plus**/
	public static final String XPATH_BTN_CADASTRO_GOOGLE = "//img[@title = 'Google_Social_Login']" ;
	public static final String XPATH_EMAIL_GOOGLE = "//*[@id='identifierId']";
	public static final String XPATH_BTN_NEXT_EMAIL = "//*[@id='identifierNext']/content/span";
	public static final String XPATH_SENHA_GOOGLE = "//input[@name='password']";
	public static final String XPATH_BTN_NEXT_SENHA = "//*[@id='passwordNext']/content/span";
	
	/**Social Login Facebook**/
	public static final String XPATH_BTN_CADASTRO_FACEBOOK = "//img[@title = 'Facebook_Social_Login']";
	public static final String XPATH_EMAIL_FACEBOOK = "//*[@id='email']";
	public static final String XPATH_SENHA_FACEBOOK = "//*[@id='pass']";
	public static final String XPATH_BTN_LOGIN_FACEBOOK = "//*[@id='loginbutton']";
	public static final String XPATH_BTN_CONFIRMA_LOGIN = "//*[@name='__CONFIRM__']";
	public static final String XPATH_BTN_CANCELA_LOGIN = "//*[@name='__CANCEL__']";
	public static final String XPATH_CONFIRMA_CANCELALAMENTO_TEMP = "//*[@id='header']";//TODO Tela de confirmação será alterada

	public static final String XPATH_LINK_SignUpforFacebookFACEBOOK = "//*[contains(text(),'Criar nova conta')]";

	
	
	/**Criar uma Conta no Facebook-- By Carlos 13112018**/ 
	public static final String XPATH_INPUT_FIRSTNAME_FACEBOOK="//input[@name='firstname']";
	public static final String XPATH_INPUT_LASTNAME_FACEBOOK="//input[@name='lastname']";
	public static final String XPATH_INPUT_EMAIL_FACEBOOK="//input[@name='reg_email__']";
	public static final String XPATH_INPUT2_EMAIL_FACEBOOK="//input[@name='reg_email_confirmation__']";
	
	public static final String XPATH_INPUT_PASSWORD_FACEBOOK="//input[@name='reg_passwd__']";
	public static final String XPATH_SELECT_MONTH_FACEBOOK="//select[@name='birthday_month']";
	public static final String XPATH_SELECT_DAY_FACEBOOK="//select[@name='birthday_day']";
	public static final String XPATH_SELECT_YEAR_FACEBOOK="//select[@name='birthday_year']";
	public static final String XPATH_RADIO_MALE_FACEBOOK="//*[contains(text(),'Masculino')]";
	public static final String XPATH_RADIO_FEMALE_FACEBOOK="//*[contains(text(),'Feminino')]";
	public static final String XPATH_BTN_SINGUP_FACEBOOK="//button[@name='websubmit']";
		

		
	public static final String XPATH_CADASTRO_POR_EMAIL = "//a[contains(text(),'Não sou cliente')]";
	public static final String XPATH_NOME = "//input[@placeholder='Nome']";
	public static final String XPATH_SOBRENOME = "//input[@placeholder='Sobrenome']";
	public static final String XPATH_CONFIRMAR_SENHA = "//input[@placeholder='Confirmar senha']";
	
	/** Tela trabalhando atualmente **/
	public static final String XPATH_TRABALHANDO_SIM = "//button[contains(text(),'Sim')]";
	public static final String XPATH_TRABALHANDO_NAO = "//button[contains(text(),'Não')]";

	public static final String XPATH_CHECK_TRABALHANDO_NAO = "//label[@class='slds-checkbox__label']";

	public static final String XPATH_AREA_ATUACAO = "//span[contains(text(),'Área de atuação')]/../following-sibling::input";
	public static final String XPATH_INSTITUICAO = "//input[@placeholder = 'Instituição onde trabalha']";
	
	/** Tela patrimônio **/
	
	public static final String XPATH_PATRIMONIO_MINHA_RENDA_MENSAL = "//label[contains(text(),'Minha renda mensal')]//following-sibling::div/input";
	public static final String XPATH_PATRIMONIO_QUAL_VALOR = "//label[contains(text(),'patrimônio ?')]/following-sibling::div//input";
	public static final String XPATH_PATRIMONIO_IMOVEIS = "//span[contains(text(), 'Imóveis')]";
	public static final String XPATH_PATRIMONIO_AUTOMOVEIS = "//input[@name='automoveis']";
	public static final String XPATH_PATRIMONIO_INVESTIMENTOS = "//span[contains(text(), 'Investimentos')]";
	public static final String XPATH_PATRIMONIO_OUTROS = "//span[contains(text(), 'Outros')]";
	
	/** FATCA **/
	public static final String XPATH_FATCA_TEXTO = "//h2[contains(text(),'Precisamos colher algumas')]";
	public static final String XPATH_BTN_SEGUIR_FATCA = "//button[contains(text(),'Seguir')]";
	/**public static final String XPATH_CHECK_RES_FISC = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[7]/div[2]/div[1]/lightning-input[1]/div[1]/span[1]/input[1]";**/
	public static final String XPATH_CHECK_OUTRA_PESSOA_MOVIMENTA_NAO = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[2]/lightning-input[1]/div[1]/span[1]/label[1]/span[2]";
	public static final String XPATH_CHECK_MOVIMENTADA_PROCURADOR_NAO = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[4]/div[2]/div[2]/lightning-input[1]/div[1]/span[1]/label[1]/span[2]";
	public static final String XPATH_CHECK_VINCULO_PI_NAO = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[5]/div[2]/div[2]/lightning-input[1]/div[1]/span[1]/label[1]/span[2]";
	public static final String XPATH_CHECK_RES_FISC = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[7]/div[2]/div[1]/lightning-input[1]/div[1]/span[1]/label[1]/span[2]";
	public static final String XPATH_CHECK_US_PERSON_NAO = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[6]/div[2]/div[2]/lightning-input[1]/div[1]/span[1]/label[1]/span[2]";
	public static final String XPATH_CHECK_RES_FISC_NAO = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[7]/div[2]/div[2]/lightning-input[1]/div[1]/span[1]/label[1]/span[2]";
	public static final String XPATH_RES_FISC_NIF = "//input[@placeholder='NIF (apenas números)']";
	public static final String XPATH_RES_FISC_NAO_POSSUI_NIF = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[7]/div[5]/div[1]/div[1]/lightning-input[1]/div[1]/span[1]/label[1]";
	public static final String XPATH_JUSTIFICATIVA_SEM_NIF = "//input[@placeholder = 'Justificativa']";
	public static final String XPATH_TERMOS_SERVICOS = "//b[contains(text(),'Termos de Serviço')]";
	public static final String XPATH_CHECK_TERMOS_SERVICOS = "//label[@class='slds-checkbox__label']";
	
	
	/** Tela dados bancários **/
	//public static final String XPATH_DADOSBANCARIOS_NOME_BANCO = "//span[contains(text(),'Banco')]/../following-sibling::input";

	
	/** Tela dados bancários **/
	public static final String XPATH_DADOSBANCARIOS_NOME_BANCO = "//input[@class='slds-input limitfield cadastroprincipal_dados_bancarios banco input']";
	public static final String XPATH_DADOSBANCARIOS_DROPDOWN_BANCO="//img[@class='cssArrowSelect cssPositionArrowSelect rotate180']";
	
																  
	public static final String XPATH_DADOSBANCARIOS_SELECT_NOME_BANCO = "//*[@class='slds-form-element__control used']";
	

	public static final String XPATH_DADOSBANCARIOS_AGENCIA = "//input[@placeholder='Agência']";
	public static final String XPATH_DADOSBANCARIOS_CONTA_DIGITO = "//input[@placeholder='Conta e digito']";
	public static final String XPATH_DADOSBANCARIOS_NOME_TITULAR = "//input[@placeholder='Nome do titular']";
	public static final String XPATH_DADOSBANCARIOS_CPF_TITULAR= "//input[@placeholder='CPF do Titular']";
	public static final String XPATH_DADOSBANCARIOS_NOME_2_TITULAR = "//input[@placeholder='Nome do 2 titular']";
	public static final String XPATH_DADOSBANCARIOS_CPF_2_TITULAR = "//input[@placeholder='CPF do 2 Titular']";
	public static final String XPATH_DADOSBANCARIOS_CONTA_CONJUNTA_NAO = "//span[contains(text(),'Não')]//preceding-sibling::span";
	public static final String XPATH_DADOSBANCARIOS_CONTA_CONJUNTA_SIM = "//span[contains(text(),'Sim')]//preceding-sibling::span";
	public static final String XPATH_ADICIONAR_OUTRA_CONTA = "//span[contains(text(),'Adicionar outra conta?')]";
	public static final String XPATH_MSG_CONTA_DUPLICADA = "//span[contains(@class, 'toastMessage forceActionsText') and text() = 'Essa conta já está cadastrada.'] ";

	public static final String XPATH_DADOSBANCARIOS_TIPO_CONTA = "//img[@class='cssArrowSelect cssPositionArrowSelect posArrowDown']";

	//public static final String XPATH_DADOSBANCARIOS_TIPO_CONTA = "//*[@class='listFiltro']";
	public static final String XPATH_DADOSBANCARIOS_INPUT_TIPO_CONTA = "//input[@class='slds-input input']";
	public static final String XPATH_DADOSBANCARIOS_ICONDROPDOWNCONTA_TIPOCONTA = "//img[@class='cssArrowSelect cssPositionArrowSelect posArrowDown']";

	
	/**
	 * Textos aleatórios
	 */
	public static final String TXT_VURL = "vUrl";
	public static final String TXT_VEMAIL = "vEmail";
	public static final String TXT_VNOME = "vNome";
	public static final String TXT_VSENHA = "vSenha";
	public static final String TXT_XPATH = "xpath";
	public static final String TXT_BUSCA = "/busca";
	public static final String TXT_PALAVRA_BUSCA = "vPalavra";
	public static final String TXT_BUSCA_RETORNO = "Busca";
	public static final String TXT_ERRO_CADASTRO = "Erro ao realizar o cadastro.";
	public static final String TXT_ERRO_VALIDAR_TELEFONE = "Erro ao validar telefone.";
	public static final String TXT_CONFIRMACAO_CONTA = "Parabéns, sua conta GREEN foi criada!";
	public static final String TXT_CONFIRMACAO_CONTA_EVIDENCIA = "Cadastro realizado com sucesso.";
	public static final String TXT_URL_NAVEGACAO_MENU_PRODUTOS = "produtos";
	public static final String TXT_URL_CADASTRO_PROXIMA_PAGINA = "cadastroprincipal";
	public static final String TXT_TELEFONE_INVALIDO = "Telefone invalido, verificado com sucesso.";
	public static final String TXT_NUMERO_RUA_INVALIDO = "Sem o número da rua, validado com sucesso sem permitir seguir.";
	public static final String TXT_EMAIL_INVALIDO = "Email Inválido";
	
	/** Xpaths - espera - navegação - confirmação */
	public static final String XPATH_CONFIRMACAO_CONTA = "//b[contains(text(),'Parabéns, sua conta GREEN foi criada!')]";
	public static final String XPATH_ESPERA_CADASTRO_INICIAL = "//span[contains(text(),'Sem problemas.')]";
	public static final String XPATH_ESPERA_CPF = "//h2[contains(text(),'Olá')]";
	public static final String XPATH_ESPERA_CEP = "//h2[contains(text(),'Que bom te conhecer')]";
	public static final String XPATH_ESPERA_DOCUMENTOS = "//h2[contains(text(),'nós precisamos')]";
	public static final String XPATH_ESPERA_CONTATOS_CONFIRMACAO = "//h2[contains(text(),'Por favor, confirme seus contatos')]";
	public static final String XPATH_ESPERA_SMS = "//h2[contains(text(),'Mandamos um')]";
	public static final String XPATH_ESPERA_POLITICAMENTE = "//h2[contains(text(),'Agora nos conte')]";
	public static final String XPATH_ESPERA_TRABALHANDO = "//h2[contains(text(),'qual sua profissão')]";	
	public static final String XPATH_ESPERA_PATRIMONIO = "//h2[contains(text(),'Ótimo ! Agora nos conte um pouco sobre a ')]";
	public static final String XPATH_ESPERA_DADOS_BANCARIOS = "//h2[contains(text(),'vamos precisar dos')]";
	public static final String XPATH_ESPERA_ADD_OUTROS_BANCOS = "//h2[contains(text(),'já adicionamos seu banco principal')]";
	
	/** xpaths webmail */
	public static final String XPATH_WEBMAIL_EMAIL = ".//*[@id='userNameInput']";
	public static final String XPATH_WEBMAIL_SENHA = ".//*[@id='passwordInput']";
//	public static final String XPATH_WEBMAIL_LINHA_EMAIL_CONFIRMACAO = "//span[contains(text(),'Bem vindo a Comunidade Green')]";

	public static final String XPATH_WEBMAIL_LINK_LINHA_EMAIL_CONFIRMACAO = "//tbody//tr//td//span//span";
	public static final String XPATH_WEBMAIL_BTN_SIM = "//input[@value='Sim']";
	public static final String XPATH_WEBMAIL_OPCAO_OUTROS = "//span[contains(text(),'Outros')]";

	/** Caminho onde são geradas as evidências de cada teste **/
	public static final String PATH_EVIDENCE = Paths.get("").toAbsolutePath().toString() + "\\Evidences\\";
	
	public static final String JAVA_SCRIPT_HIGHLITH =  "arguments[%d].style.border='3px solid red';arguments[%d].focus();arguments[%d].scrollIntoView(true);"; 
	public static final String JAVA_SCRIPT_UNDO = "arguments[%d].setAttribute('style', '%2$s');";
	
	/** Objetivos*/
	public static final String XPATH_OBJETIVOS_ATUAL = "//span[contains(@class, 'objetivoAtualEstilo uiOutputText') and text() = 'Monte seu objetivo']";
	public static final String XPATH_OBJETIVOS_MSG_TELA_PRINCIPAL = "//b[contains(text(),'qual você escolhe?')]";
	public static final String XPATH_OBJETIVOS_VIAJAR_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Viajar')]";
	public static final String XPATH_OBJETIVOS_COMPRAR_CARRO_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Comprar um carro')]";
	public static final String XPATH_OBJETIVOS_ESTUDAR_FORA_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Estudar fora')]";
	public static final String XPATH_OBJETIVOS_COMPRAR_IMOVEL_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Comprar um imóvel')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Cofrinho')]";
	public static final String XPATH_OBJETIVOS_APOSENTADORIA_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Aposentadoria')]";
	public static final String XPATH_OBJETIVOS_MONTE_OBJETIVO_ATUAL = "//div[@class='slds-form-element nomePage']//div[@class='slds-grid']//div//span[contains(text(),'Monte seu objetivo')]";
	
	/** Objetivos cofrinho*/
	public static final String XPATH_OBJETIVOS_MSG_PRIMEIRA_TELA_COFRINHO = "//h2[contains(text(),'Sobrou um dinheirinho no mês e não sabe o que fazer')]";
	public static final String XPATH_OBJETIVOS_VALOR_INVESTIR_COFRINHO = "//input[@id='input-3']";
	public static final String XPATH_OBJETIVOS_BTN_ESTOU_SEM_NADA = "//button[contains(text(),'Estou sem nada')]";
	public static final String XPATH_OBJETIVOS_MSG_TELA_DICAS = "//p[contains(text(),'Tudo bem, sem problemas! Separamos algumas dicas')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_DICA_UM = "//div[contains(text(),'#1')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_DICA_DOIS = "//div[contains(text(),'#2')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_DICA_TRES = "//div[contains(text(),'#3')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_DICA_QUATRO = "//div[contains(text(),'#4')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_DICA_CINCO = "//div[contains(text(),'#5')]";
	public static final String XPATH_OBJETIVOS_COFRINHO_DICA_SEIS = "//div[contains(text(),'#6')]";
	
	/** Objetivos Monte seu objetivo*/
	public static final String XPATH_OBJETIVOS_DATA_OBJETIVO_MONTE_OBJETIVO = "//input[@id='input-3']";
	public static final String XPATH_OBJETIVOS_VALOR_OBJETIVO_MONTE_OBJETIVO = "//input[@id='input-4']";
	public static final String XPATH_OBJETIVOS_VALOR_INVESTIR_MONTE_OBJETIVO = "//input[@id='input-5']";
			
	/** Elementos Preenchimento*/
	public static final String XPATH_OBJETIVOS_BTN_ESCOLHER = "//button[contains(text(),'Escolher objetivo')]";
	public static final String XPATH_OBJETIVOS_BTN_OBJETIVO_ANTERIOR = "//span[@class='arrowTxt']/button[@class='slds-button arrow slds-p-right_large slds-button_icon-bare']";
	public static final String XPATH_OBJETIVOS_BTN_OBJETIVO_PROXIMO = "//button[contains(text(), 'Escolher objetivo')]/../../../preceding-sibling::div/div/span/button[2]/lightning-primitive-icon";
	public static final String XPATH_OBJETIVOS_DATA_OBJETIVO = "//input[@id='input-1']";
	public static final String XPATH_OBJETIVOS_VALOR_OBJETIVO = "//input[@id='input-2']";
	public static final String XPATH_OBJETIVOS_VALOR_INVESTIR = "//input[@id='input-3']";
	public static final String XPATH_OBJETIVOS_NOME_OBJETIVO = "//*[@id='input-2']";
	
	/** Mensagens erro objetivos */
	public static final String XPATH_OBJETIVOS_MSG_DT_INVALIDA = "//span[contains(@class, 'error error_msg') and text() = 'A data inserida deve ser maior que hoje.']";
	public static final String XPATH_OBJETIVOS_MSG_VLR_MAIOR_OBJ = "//span[contains(@class, 'error error_msg') and text() = 'O seu investimento inicial esta maior do que o valor total do seu Objetivo']";
	public static final String XPATH_OBJETIVOS_MSG_VLR_INVALIDO = "//span[contains(text(),'valor')]";
	
	/** Tela confirmação do objetivo*/
	public static final String XPATH_OBJETIVOS_VALOR_OBJETIVO_CONFIRMACAO = "//input[@id='input-4']";
	public static final String XPATH_OBJETIVOS_VALOR_INVESTIR_CONFIRMACAO = "//input[@id='input-5']";
	public static final String XPATH_OBJETIVOS_VALOR_INVESTIR_MENSAL_CONFIRMACAO = "//input[@id='input-6']";
	public static final String XPATH_OBJETIVOS_BTN_RISCO_ANTERIOR = "//span[contains(text(),'Nossa sugestão para você')]/following-sibling::div//button[@class='slds-button arrow slds-button_icon-bare']";
	public static final String XPATH_OBJETIVOS_BTN_RISCO_PROXIMO = "//span[contains(text(),'Nossa sugestão para você')]/following-sibling::div//button[@class='slds-button arrow arrowProx slds-button_icon-bare']";
	public static final String XPATH_OBJETIVOS_BTN_CRIAR_OBJETIVO = "//button[contains(text(),'Criar objetivo')]";
	public static final String XPATH_OBJETIVOS_BTN_GRAFICO_EVOLUCAO = "//button[contains(text(),'Ver gráfico de evolução')]";
	public static final String XPATH_OBJETIVOS_BTN_GRAFICO_DETALHAR_ALOCACAO = "//button[contains(text(),'Detalhar alocação')]";
	
	/** Nível de risco*/
	public static final String XPATH_OBJETIVOS_BTN_VER_OBJETIVO = "//button[contains(text(),'Ver meu objetivo ')]";
	
	/** produtos */
	public static final String XPATH_PRODUTOS_BTN_FILTRO_TODOS = "//button[contains (text(), 'Todos')]";
	public static final String XPATH_PRODUTOS_BTN_FILTRO_RF = "//button[contains (text(), 'Renda Fixa')]";
	public static final String XPATH_PRODUTOS_BTN_FILTRO_FUNDOS = "//button[contains (text(), 'Fundos')]";
	public static final String XPATH_PRODUTOS_BUSCAR = ".//*[@id='input-1']";
	public static final String XPATH_PRODUTOS_ORDENAR = "//label[contains(text(),'Buscar')]/../../following-sibling::div/button[1]";
	public static final String XPATH_PRODUTOS_FILTRAR = "//label[contains(text(),'Buscar')]/../../following-sibling::div/button[2]";
	public static final String XPATH_PRODUTOS_EXIBICAO = "//label[contains(text(),'Buscar')]/../../following-sibling::div/button[3]";
	public static final String XPATH_BTN_ESCOLHER_PRD = "//button[contains(text(),'Escolher investimento')]";
	public static final String XPATH_BTN_CONTINUAR = "//button[contains(text(),'Continuar')]";
	public static final String XPATH_VALOR_INVESTIR_PRODUTO = "//label[contains(text(),'para este investimento')]/../div/input";
		
	/** Mensagens de erro */
	public static final String XPATH_TELEFONE_INVALIDO = "//span[contains(text(),'Número de telefone inválido')]";
	public static final String XPATH_TELEFONE_RES_INVALIDO = "//span[contains(text(),'Por favor, preencher o telefone corretamente')]";
	public static final String XPATH_EMAIL_INVALIDO = "//span[@class='error error_msg']";
	
	/** Valores */
	public static final float MARGIN = 40;
	
	/** Objetivos */
	public static final int ESTUDAR_FORA = 2;
	public static final int COMPRAR_IMOVEL = 3;
	public static final int COFRINHO = 4;
	public static final int APOSENTADORIA = 5;
	public static final int MONTE_OBJETIVO = 2;
	
	/** bloqueio url everis e relacionados */
	public static final String XPATH_BLOQUEIO_EVERIS_URL = ".//*[contains(text(),'bloqueado devido as')]";
	
	/** OPCAO UM EMAIL TEMPORARIO */ 
	public static final String URL_OPCAO_UM_EMAIL_TEMPORARIO = "https://temp-mail.org/";
	public static final String XPATH_OPCAO_UM_MAIL = "//*[@id='mail']";
	public static final String XPATH_PRIMEIRA_OPCAO_LINHA = "//a[contains(text(),'Sandbox: Bem vindo à')]";
	public static final String XPATH_PRIMEIRA_OPCAO_LINK_LINHA = "//span[contains(text(),'Bem vindo a Comunidade')]//a";
	
	/** OPCAO DOIS EMAIL TEMPORARIO */ 
	public static final String XPATH_ALTERNATIVO_URL = "https://www.sharklasers.com/pt";
	public static final String XPATH_ALTERNATIVO_EMAIL_DOIS = "https://www.sharklasers.com/pt/inbox";
	public static final String XPATH_ALTERNATIVO_EMAIL_LINHA = ".//td[contains(text(),'falta pouco.')]//preceding-sibling::td[contains(text(),'.com')]";
	public static final String XPATH_ALTERNATIVO_COLETAR_EMAIL = ".//*[@id='alias-box']/label";
	public static final String XPATH_ALTERNATIVO_EMAIL_LINK_FINAL = "//a[contains(text(),'Confirme seu e-mail')]";

	/** CATALOGO DE PRODUTOS INVISTA AGORA */
	public static final String XPATH_OPCAO_TODOS = "//button[@title='Todos']";
	public static final String XPATH_OPCAO_RENDA_FIXA = "//button[@title='Renda Fixa']";
	public static final String XPATH_OPCAO_FUNDOS_DE_INVESTIMENTOS = "//button[@title='Fundos de Investimentos (em breve)']";
	public static final String XPATH_OPCAO_TESOURO_DIRETO = "//button[@title='Tesouro direto (em breve)']";
	public static final String XPATH_SELECIONAR_FILTRO = "//div[@class='slds-col']/p[contains (text(), 'Filtro')]";
	public static final String XPATH_SELECIONAR_ORDENACAO = "//div[@class='slds-col']/p[contains (text(), 'Ordenação')]";
	public static final String XPATH_SELECIONAR_LISTA = "//div[@class='slds-col']/p[contains (text(), 'Lista')]";
	public static final String XPATH_FECHAR_FILTRO = "//div[@class='divGeralDesk slideFiltro-true cProdutos_Filtro']//button[@class = 'slds-button btn-close slds-button_icon-bare']";
	public static final String XPATH_FECHAR_ORDENACAO = "//div[@class='conteudo']//div[@class='txt-align-right']//button[@class = 'slds-button btn-close slds-button_icon-bare']";
	public static final String XPATH_HTML = "/html";
	public static final String XPATH_REGUA_SELECOES = "//div[@class='fundoCinzaIcons']";
	public static final String XPATH_TITULO_FILTRO = "//span[@class='textoFiltro']";
	public static final String XPATH_TITULO_ORDENACAO = "//div//span[@class='ordenarTitle']";
	
	/** CARRINHO */
	public static final String XPATH_BOTAO_CARRINHO = "//div//span[@class='produtos']//div[@class='header_icon']";
	public static final String XPATH_TITULO_CARRINHO = "//b[contains(text(), 'Carrinho de investimentos')]";
	public static final String XPATH_BOTAO_EXCLUIR_ITEM_CARRINHO = "//button[@title='Delete']//span[contains(text(),'Delete')]";
	public static final String XPATH_BOTAO_EXCLUIR_PRIMEIRO_ITEM_CARRINHO = "//div[@class='cards slds-grid list-view slds-align_absolute-center posRelative dp-inline-flex margin-r-2 mb-40'][1]//button[@title='Delete']";
	public static final String XPATH_BOTAO_SIM_EXCLUIR = "//button[contains(text(),'Sim, excluir')]";
	public static final String XPATH_BOTAO_PROCURAR_INVESTIMENTOS = "//button[contains(text(),'Procurar investimentos')]";
	public static final String XPATH_TITULO_CARRINHO_VAZIO = "//span[contains(text(), 'Carrinho de investimentos')]";
	public static final String XPATH_BOTAO_ESCOLHER_OUTROS_INVESTIMENTOS = "//div[@class='slds-text-heading_small tituloEscolherDesk slds-align_absolute-center']/b[contains(text(),'Escolher outros investimentos')]";
	public static final String XPATH_VALOR_TOTAL_INVESTIMENTOS = "//span[@class='slds-input textoValorInvest uiOutputText']";
	public static final String XPATH_VALOR_DO_INVESTIMENTO ="//input[@class='slds-input'][@id='input-4']";
	
	
	/** PRODUTOS */
	public static final String XPATH_PRIMEIRO_PRODUTO = "//div[@class='card slds-col'][1]";
	public static final String XPATH_VALOR_INICIAL_PRIMEIRO_PRODUTO = "//div[@class='card slds-col'][1]//div[@class= 'card_goodto h list-view-desk']//span[@class='card_span_subtitulo']";
	public static final String XPATH_SEGUNDO_PRODUTO = "//div[@class='card slds-col'][2]";
	public static final String XPATH_VALOR_INICIAL_SEGUNDO_PRODUTO = "//div[@class='card slds-col'][2]//div[@class= 'card_goodto h list-view-desk']//span[@class='card_span_subtitulo']";
	public static final String XPATH_TERCEIRO_PRODUTO = "//div[@class='card slds-col'][3]";
	public static final String XPATH_VALOR_INICIAL_TERCEIRO_PRODUTO = "//div[@class='card slds-col'][3]//div[@class= 'card_goodto h list-view-desk']//span[@class='card_span_subtitulo']";
	public static final String XPATH_VALOR_MINIMO = "//div[@class='slds-col slds-size_4-of-12']//span[@class='card_span_subtitulo']";
	public static final String XPATH_BOTAO_ESCOLHER_INVESTIMENTO = "//button[contains(text(),'Escolher investimento')]";
	public static final String XPATH_VALOR_MINIMO_PRODUTO = "//input[@type='tel']";
	
	
	/** MINHA CARTEIRA */
	public static final String XPATH_CARTEIRA_OPCAO_SALDO_PI = "//img[@class='sizeImgSaldoPI']";
	public static final String XPATH_CARTEIRA_OPCAO_MEUS_INVESTIMENTOS = "//img[@class='sizeImgMeusInvestimentos']";
	
	
	/** SALDO PI */
	public static final String XPATH_TITULO_SALDO_PI = "//p[contains(text(),'Saldo Pi disponível:')]";
	public static final String XPATH_SALDO_PI_DISPONIVEL = "//span[contains(@class,'uiOutputCurrency')]";
	public static final String XPATH_AGUARDANDO_TRANSFERENCIA = "//p[contains(text(),'Aguardando transferência')]";
	
	
	/** MEUS INVESTIMENTOS */
	public static final String XPATH_TITULO_MEUS_INVESTIMENTOS = "//button[@title='Meus Investimentos']";
	
	
	/** INVISTA AGORA */
	public static final String XPATH_TITULO_INVISTA_AGORA = "//span[contains(text(), 'Invista agora!')]";
	
	
	/** XPATH'S DE INTERAÇÃO COM O BACK END DE SALES FORCE **/
	public static final String XPATH_LINK_SF = "https://green--uat.cs96.my.salesforce.com/";
	public static final String XPATH_USUARIO_SF = "//*[@id='username']";
	public static final String XPATH_SENHA_SF = "//*[@id='password']";
	public static final String XPATH_BTN_LOGIN_SF = "//*[@id='Login']";
	public static final String XPATH_BTN_PERFIL_SF = "//span[contains(text(),'Exibir perfil')]";
	public static final String XPATH_ALTERNAR_CLASSIC = "//a[contains (text(), 'Salesforce Classic')]";
	public static final String XPATH_USUARIO_LOGIN_SF = "raphael.carmo@green.com";
	public static final String XPATH_SENHA_LOGIN_SF = "Teste@02";
	public static final String XPATH_SF_LIGHTNING = "//a[contains(text(),'Alternar para Lightning Experience')]";
	/**public static final String XPATH_LOCALIZA_CADASTRO = "//*[@placeholder = 'Pesquise no Salesforce']";**/
	public static final String XPATH_LOCALIZA_CADASTRO = "//input[@placeholder = 'Pesquisar...']";
	public static final String XPATH_BTN_PESQUISAR_SF = "//input[@value = 'Pesquisar']";
	public static final String XPATH_BTN_EDITAR_SF = "//input[@name = 'edit'][1]";
	public static final String XPATH_ABA_DETALHES = "//li[contains(@class,'tabs__item uiTabItem')]//a[contains(@title,'Detalhes')]";

	/** XPATH TELA DE DETALHES BACK END SALESFORCE **/
	public static final String XPATH_CPF_DETALHES_SF = "//input[@data-interactive-lib-uid = '24']";
	
	/** XPATH SUITABILITY **/
	public static final String LINK_SUITABILITY = "https://uat-green.cs96.force.com/green/s/suitability";
	public static final String XPATH_BTN_DESCROBRIR_RISCO = "//button[contains(text(),'Descobrir meu perfil de risco')]";
	public static final String XPATH_PERGUNTAUM_SUITABILITY = "//h2[contains(text(),'Tá, quando você pensa em dinheiro, o que vem primeiro na sua cabeça?')]";
	public static final String XPATH_PERGUNTAQUATRO_SUITABILITY = "//h2[contains(text(),'algum desses produtos nos últimos anos?')]";
	public static final String XPATH_PERGUNTACINCO_SUITABILITY = "//h2[contains(text(),'Nos conte quais os tipos de investimento que você conhece.')]";
	public static final String XPATH_MSG_RISCO_MAIOR = "//span[contains(text(),'fora do meu perfil')]";
	public static final String XPATH_BTN_CONFIRMAR_ASSIM_MESMO = "//button[contains(text(),'Continuar assim mesmo')]";
	public static final String XPATH_MSG_VALIDACAO_TERMO = "//strong[contains(text(),'não é compatível com o seu perfil')]";
	public static final String XPATH_BTN_VOLTAR_PERGUNTAUM = "//span[@class = 'voltar btn-voltar header-']//button[@class = 'slds-button slds-button_icon-bare']";
	public static final String XPATH_BTN_VOLTAR_PERGUNTACINCO = "//span[@class = 'voltar btn-voltar header-show']//button[@class = 'slds-button slds-button_icon-bare']";
	
	/** XPATH SBS **/
	public static final String XPATH_USUARIO_SBS = "//input[@id='LoginUsuario']";
	public static final String XPATH_SENHA_SBS = "//input[@id='Senha']";
	public static final String XPATH_BOTAO_ENTRAR_SBS = "//span[contains(text(),'Entrar')]";
	public static final String XPATH_TITULO_SBS = "//h1[contains(text(),'Senior Banking Solution')]";
	public static final String XPATH_BOTAO_MENU_SBS = "//a[@href='#MenuPrincipalPanel']";
	public static final String XPATH_MENU_PROCESSAMENTO_SBS = "//span[@data-bind='text: description'][contains(text(),'Processamento')]";
	public static final String XPATH_MENU_STATUS_RENDA_FIXA_SBS = "//span[@data-bind='text: description'][contains(text(),'Status Renda Fixa')]";
	public static final String XPATH_TITULO_STATUS_RENDA_FIXA_SBS = "//div[@class='window_title_text'][contains(text(),'Status Renda Fixa')]";
	public static final String XPATH_ITEM_RENDA_FIXA_STATUS_FINALIZADO_SBS = "//table[@class='txt']//td[contains (text(), 'ABERTO')]";
	public static final String XPATH_STATUS_RENDA_FIXA_IFRAME_SBS = "//iframe[contains(@class,'window_frame ui-widget-content no-draggable no-resizable')]";
	public static final String XPATH_BOTAO_ATUALIZAR_CACHE_SBS = "//table//input[@type='image']";
	public static final String XPATH_MENU_ABERTURA_RENDA_FIXA_SBS = "//span[@data-bind='text: description'][contains(text(),'Abertura Renda Fixa')]";
	public static final String XPATH_TITULO_ABERTURA_RENDA_FIXA_SBS = "//div[@class='window_title_text'][contains(text(),'Abertura Renda Fixa')]";


	//Novos Locators adicionados por Carlos Almeida 21/11/2018
	/** Criar email temporario TempMail **/
	public static final String XPATH_SELECT_DOMAIN_TEMPMAIL="//select[@name='domain']";
	public static final String XPATH_INPUT_EMAIL_TEMPMAIL="//input[@name='mail']";
	public static final String XPATH_LINK_ALTERAR_TEMPMAIL="//a[@href='https://temp-mail.org/pt/option/change/']";
	public static final String XPATH_BUTTON_SALVAR_TEMPMAIL="//button[@id='postbut']";
	public static final String TEXT_DOMAIN_TEMPMAIL="@daabox.com";
	public static final String TEXT_VALUE_EMAIL_TEMPMAIL="(//input[@id='mail'])[1]";
	public static final String XPATH_LINK_SITE_TEMPMAIL="https://temp-mail.org/pt/option/change/";
		
	
	//Novos Locators adicionados por Carlos Almeida 26/11/2018
	public static final String XPATH_OI_TEXTHOME_CONTACRIADATEXTOVALIDAR="//*[contains(text(),'Oi,')]";
	public static final String XPATH_TERMOS_CHECKBOX="//label[@class='slds-checkbox__label']";
	
	//Pagina ainda falta POuco
	public static final String XPATH_AINDAFALTAPOUCO_TEXTOPAGINA="//*[contains(text(),'Falta pouco!')]";
	
	//Pagina:
	//Precisamos colher algumas informações sobre declarações e autorizações.
	public static final String XPATH_CHECK_TEXTRESIDENCIAEMOUTROPAIS="//*[contains(text(),'Possui residência fiscal em outro país?')]";
	
	//Pagina: Não É Voce - Abertura de Chamado
	//28/11/2018
	public static final String XPATH_CONFIRMAREMAIL_INPUT_TELACHAMADO="//input[@placeholder='Confirme seu e-mail']";
	public static final String XPATH_TELEFONE_INPUT_TELACHAMADO="//input[@placeholder='Celular']";
	public static final String XPATH_OBSERVACAO_INPUT_TELACHAMADO="//input[@placeholder='Observação']";
	public static final String XPATH_BTN_ENVIAR="//*[contains(text(),'Enviar')]";
	public static final String XPATH_PAGINA_CHAMADO_CONTENT="//*[contains(text(),'Precisamos do seu CPF')])]";
		
	//Pagina: Outros - Cadastro
	//03/12/2018
	public static final String XPATH_BOTAO_OUTROS= "//button[contains(text(), 'Outros')]";
	public static final String XPATH_NUMERO_REGISTRO_OUTROS= "//input[@placeholder='Número do registro']";
	public static final String XPATH_DATA_EMISSAO_OUTROS = "//input[@placeholder='Data de emissão']";
	public static final String XPATH_CAMPO_DOCUMENTO_OUTROS = "//span[contains(text(), 'Tipo de documento')]";
	public static final String XPATH_PREENCHIMENTO_DOCUMENTO_OUTROS = "//input[@type='text'][@class='pdLeft39px input']";

	//Pagina: SalesForce Classic
	//05/12/2018 - Atulaizado: 11/12/18
	public static final String XPATH_CAMPO_PESQUISAR_SF_CLASSIC = "//input[@id='phSearchInput']";	
	public static final String XPATH_PRIMEIRO_EMAIL_PESQUISADO_SF_CLASSIC = "//th//a[@data-seclke='Account'][1]";
	public static final String XPATH_TELA_CONTA_SF_CLASSIC = "//li[@id= 'Account_Tab']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_TIPO_DE_DOCUMENTO_SF_CLASSIC = "//div[@id= '00N1g000000PgfG_ileinner']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_ORGAO_EMISSOR_SF_CLASSIC = "//div[@id= '00N1g000000Pgf6_ileinner']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_DATA_EMISSAO_SF_CLASSIC = "//div[@id= '00N1g000000Pgeg_ileinner']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_NUMERO_DOCUMENTO_SF_CLASSIC = "//div[@id= '00N1g000000Pgf3_ileinner']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_ESTADO_EMISSOR_SF_CLASSIC = "//div[@id= '00N1g000000Pgep_ileinner']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_TIPO_DOCUMENTO_OUTROS_SF_CLASSIC = "//div[@id= '00N1g000000ifQY_ileinner']";
	public static final String XPATH_DOCUMENTOS_PESSOAIS_CODIGO_DE_SEGURANCA_SF_CLASSIC = "//div[@id= '00N1g000000Pito_ileinner']";
	public static final String XPATH_BOTAO_PESQUISAR_SF_CLASSIC = "//input[@id='phSearchButton']";

	//Pagina: SalesForce
    //05/12/2018
    public static final String XPATH_CAMPO_PESQUISAR_SF = "//input[@title= 'Pesquisar Contas e outros']";     
    public static final String XPATH_PRIMEIRO_EMAIL_PESQUISADO = "//div[@class='slds-grid slds-grid--vertical slds-m-bottom_small']//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']";
    public static final String XPATH_TELA_CONTA_SF = "//li[@class='slds-breadcrumb__item']//span[contains(text(), 'Conta pessoal')]";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_TIPO_DE_DOCUMENTO_SF = "//span[contains(text(), 'Tipo de Documento')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_ORGAO_EMISSOR_SF = "//span[contains(text(), 'Órgão Emissor')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_DATA_EMISSAO_SF = "//span[contains(text(), 'Data de Emissão')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_NUMERO_DOCUMENTO_SF = "//span[contains(text(), 'Número do Documento')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_ESTADO_EMISSOR_SF = "//span[contains(text(), 'Estado Emissor')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_TIPO_DOCUMENTO_OUTROS_SF = "//span[contains(text(), 'Tipo documento outros')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    public static final String XPATH_DOCUMENTOS_PESSOAIS_CODIGO_DE_SEGURANCA_SF = "//span[contains(text(), 'Código de Segurança')]//parent::div[@class='test-id__field-label-container slds-form-element__label']//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span[@class='test-id__field-value slds-form-element__static slds-grow ']";
    //06/12/18
    public static final String URL_LIGHTING_SF = "https://green--uat.lightning.force.com/lightning";
    public static final String USUARIO_SF = "marcos.hioka@everis.com";
    public static final String SENHA_USUARIO_SF = "teste#123";
    
}

