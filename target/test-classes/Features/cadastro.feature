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
    E valido a informação do e-mail recebido para cadastro
    E insiro informações válidas de senha 
    #E clico no botão de Login
    #Então eu devo logar com sucesso na aplicação
