#language: pt
@cadastro

Funcionalidade: Cadastro
  Como provável cliente
  Quero realizar cadastro
  Para operar na Pi

  Cenario: Cadastro full
    Dado que eu tenha um email para cadastro
    E que eu esteja na pagina de cadastro da Pi
    Quando eu envio nome valido com e-mail
    E verifico a mensagem para entrar no link enviado por e-mail
    E valido a informação do e-mail recebido para cadastro
    E insiro informações válidas de senha
    E confirmo que a senha é criada com sucesso
    E insiro CPF
    E as informacoes Nome Completo, Data de nascimento, Sexo, Estado civil
    E as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade
    E as informacoes de endereço
    E insiro as informações de CNH
    E insiro as informações de contato
    E sigo sem código pela tela de envio de SMS
    E informo que não sou politicamente exposto
    E informo minha profissão
    E informo minha renda, sem patrimônio
    E informo Não em todos os itens de Declarações e Autorizações
    E aceite todos os termos
    E informo meus dados bancários
    E confirmo minha conta bancária cadastrada
    Então devo ver a mensagem de Falta Pouco
