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
  "duration": 217326893,
  "status": "passed"
});
formatter.before({
  "duration": 432812097,
  "status": "passed"
});
formatter.before({
  "duration": 2337526552,
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
formatter.step({
  "line": 16,
  "name": "confirmo que a senha é criada com sucesso",
  "keyword": "E "
});
formatter.step({
  "line": 17,
  "name": "insiro CPF",
  "keyword": "E "
});
formatter.step({
  "line": 18,
  "name": "as informacoes Nome Completo, Data de nascimento, Sexo, Estado civil",
  "keyword": "E "
});
formatter.step({
  "line": 19,
  "name": "as informacoes Nome da Mãe, nome do pai, Nacionalidade, Estado, Cidade",
  "keyword": "E "
});
formatter.match({
  "location": "CadastroSteps.que_eu_tenha_um_email_para_cadastro()"
});
formatter.result({
  "duration": 6114597899,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.que_eu_esteja_na_pagina_de_cadastro_da_Pi()"
});
formatter.result({
  "duration": 4580098631,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.eu_envio_nome_valido_com_e_mail()"
});
formatter.result({
  "duration": 1492986728,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.valido_a_informação_do_e_mail_recebido_para_cadastro()"
});
formatter.result({
  "duration": 17665551932,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_informações_válidas_de_senha()"
});
formatter.result({
  "duration": 2884857696,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.confirmo_que_a_senha_é_criada_com_sucesso()"
});
formatter.result({
  "duration": 6415034125,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_CPF()"
});
formatter.result({
  "duration": 3757697424,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_Nome_Completo_Data_de_nascimento_Sexo_Estado_civil()"
});
formatter.result({
  "duration": 1548832580,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_Nome_da_Mãe_nome_do_pai_Nacionalidade_Estado_Cidade()"
});
formatter.result({
  "duration": 5655051063,
  "status": "passed"
});
formatter.after({
  "duration": 8096951,
  "status": "passed"
});
formatter.after({
  "duration": 1188235225,
  "status": "passed"
});
});