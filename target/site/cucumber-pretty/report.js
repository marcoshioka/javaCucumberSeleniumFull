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
  "duration": 181643489,
  "status": "passed"
});
formatter.before({
  "duration": 285673547,
  "status": "passed"
});
formatter.before({
  "duration": 2255901912,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Cadastro full",
  "description": "",
  "id": "cadastro;cadastro-full",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 11,
  "name": "que eu tenha um email para cadastro",
  "keyword": "Dado "
});
formatter.step({
  "line": 12,
  "name": "que eu esteja na pagina de cadastro da Pi",
  "keyword": "E "
});
formatter.step({
  "line": 13,
  "name": "eu envio nome valido com e-mail",
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "valido a informação do e-mail recebido para cadastro",
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "insiro informações válidas de senha",
  "keyword": "E "
});
formatter.match({
  "location": "CadastroSteps.que_eu_tenha_um_email_para_cadastro()"
});
formatter.result({
  "duration": 4922447600,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.que_eu_esteja_na_pagina_de_cadastro_da_Pi()"
});
formatter.result({
  "duration": 4330260250,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.eu_envio_nome_valido_com_e_mail()"
});
formatter.result({
  "duration": 1414224538,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.valido_a_informação_do_e_mail_recebido_para_cadastro()"
});
formatter.result({
  "duration": 15068150603,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_informações_válidas_de_senha()"
});
formatter.result({
  "duration": 6725655271,
  "status": "passed"
});
formatter.after({
  "duration": 6095937,
  "status": "passed"
});
formatter.after({
  "duration": 1161356283,
  "status": "passed"
});
});