#language: pt
@login
Funcionalidade: Login
  Como usuário Pi
  Quero realizar login na aplicação web
  Para realizar minhas tarefas

  Cenario: Login com sucesso
    Dado que eu esteja na página de login da Pi
    Quando eu insiro meu e-mail cadastrado
    E minha senha
    E clico no botão de Login
    Então eu devo logar com sucesso na aplicação
