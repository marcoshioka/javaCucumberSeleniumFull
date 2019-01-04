$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/Features/cadastro.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 4,
  "name": "Cadastro",
  "description": "Como provável cliente\nQuero realizar cadastro\nPara operar na Pi",
  "id": "cadastro",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 2,
      "name": "@cadastro"
    }
  ]
});
formatter.before({
  "duration": 195653830,
  "status": "passed"
});
formatter.before({
  "duration": 221281395,
  "status": "passed"
});
formatter.before({
  "duration": 2083612152,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Cadastro full",
  "description": "",
  "id": "cadastro;cadastro-full",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 10,
  "name": "que eu esteja na pagina de cadastro da Pi",
  "keyword": "Dado "
});
formatter.step({
  "line": 11,
  "name": "eu envio nome valido com e-mail",
  "keyword": "Quando "
});
formatter.match({
  "location": "CadastroSteps.que_eu_esteja_na_pagina_de_cadastro_da_Pi()"
});
formatter.result({
  "duration": 4680392382,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.eu_envio_nome_valido_com_e_mail()"
});
formatter.result({
  "duration": 1512076567,
  "status": "passed"
});
formatter.after({
  "duration": 6432410,
  "status": "passed"
});
formatter.after({
  "duration": 1403390976,
  "status": "passed"
});
formatter.uri("src/test/java/Features/login.feature");
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
  "duration": 16213347,
  "status": "passed"
});
formatter.before({
  "duration": 47698132,
  "status": "passed"
});
formatter.before({
  "duration": 1316074382,
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
  "duration": 4752152373,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.eu_insiro_meu_e_mail_cadastrado()"
});
formatter.result({
  "duration": 1360596275,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.minha_senha()"
});
formatter.result({
  "duration": 1005144848,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clico_no_botão_de_Login()"
});
formatter.result({
  "duration": 3216823535,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.eu_devo_logar_com_sucesso_na_aplicação()"
});
formatter.result({
  "duration": 1912982073,
  "status": "passed"
});
formatter.after({
  "duration": 3117370,
  "status": "passed"
});
formatter.after({
  "duration": 1463560207,
  "status": "passed"
});
});