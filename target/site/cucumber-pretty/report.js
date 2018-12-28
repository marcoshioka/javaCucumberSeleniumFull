$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 3,
  "name": "Login",
  "description": "Como usuário Pi\nQuero realizar login na aplicação web\nPara realizar minhas tarefas",
  "id": "login",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 2,
      "name": "@login"
    }
  ]
});
formatter.before({
  "duration": 4575602,
  "status": "passed"
});
formatter.before({
  "duration": 38886,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Login com sucesso",
  "description": "",
  "id": "login;login-com-sucesso",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 9,
  "name": "que eu esteja na página de login da Pi",
  "keyword": "Dado "
});
formatter.step({
  "line": 10,
  "name": "eu insiro meu e-mail cadastrado",
  "keyword": "Quando "
});
formatter.step({
  "line": 11,
  "name": "minha senha",
  "keyword": "E "
});
formatter.step({
  "line": 12,
  "name": "clico no botão de Login",
  "keyword": "E "
});
formatter.step({
  "line": 13,
  "name": "eu devo logar com sucesso na aplicação",
  "keyword": "Então "
});
formatter.match({
  "location": "LoginSteps.que_eu_esteja_na_página_de_login_da_Pi()"
});
formatter.result({
  "duration": 7064808594,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.eu_insiro_meu_e_mail_cadastrado()"
});
formatter.result({
  "duration": 928162198,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.minha_senha()"
});
formatter.result({
  "duration": 569975048,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clico_no_botão_de_Login()"
});
formatter.result({
  "duration": 559921363,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.eu_devo_logar_com_sucesso_na_aplicação()"
});
formatter.result({
  "duration": 4077093910,
  "status": "passed"
});
formatter.after({
  "duration": 1767296226,
  "status": "passed"
});
});