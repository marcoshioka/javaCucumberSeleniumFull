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
  "duration": 1908185530,
  "status": "passed"
});
formatter.before({
  "duration": 594100651,
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
  "name": "as informacoes Nome da Mãe, Nome do pai, Nacionalidade, Estado, Cidade",
  "keyword": "E "
});
formatter.match({
  "location": "CadastroSteps.que_eu_tenha_um_email_para_cadastro()"
});
formatter.result({
  "duration": 7113989825,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.que_eu_esteja_na_pagina_de_cadastro_da_Pi()"
});
formatter.result({
  "duration": 4215488561,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.eu_envio_nome_valido_com_e_mail()"
});
formatter.result({
  "duration": 1727403379,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.valido_a_informação_do_e_mail_recebido_para_cadastro()"
});
formatter.result({
  "duration": 16991007583,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_informações_válidas_de_senha()"
});
formatter.result({
  "duration": 2829322301,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.confirmo_que_a_senha_é_criada_com_sucesso()"
});
formatter.result({
  "duration": 4593463350,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_CPF()"
});
formatter.result({
  "duration": 2957339757,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_Nome_Completo_Data_de_nascimento_Sexo_Estado_civil()"
});
formatter.result({
  "duration": 1594691504,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_Nome_da_Mãe_nome_do_pai_Nacionalidade_Estado_Cidade()"
});
formatter.result({
  "duration": 3600924086,
  "status": "passed"
});
formatter.after({
  "duration": 6347620,
  "status": "passed"
});
formatter.after({
  "duration": 1152437404,
  "status": "passed"
});
});