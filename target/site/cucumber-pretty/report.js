$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cadastro.feature");
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
  "duration": 1960602951,
  "status": "passed"
});
formatter.before({
  "duration": 697254748,
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
formatter.step({
  "line": 20,
  "name": "as informacoes de endereço",
  "keyword": "E "
});
formatter.step({
  "line": 21,
  "name": "insira as informações de CNH",
  "keyword": "E "
});
formatter.match({
  "location": "CadastroSteps.que_eu_tenha_um_email_para_cadastro()"
});
formatter.result({
  "duration": 5647910951,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.que_eu_esteja_na_pagina_de_cadastro_da_Pi()"
});
formatter.result({
  "duration": 4006435114,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.eu_envio_nome_valido_com_e_mail()"
});
formatter.result({
  "duration": 1305021171,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.valido_a_informação_do_e_mail_recebido_para_cadastro()"
});
formatter.result({
  "duration": 16926190888,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_informações_válidas_de_senha()"
});
formatter.result({
  "duration": 2656960617,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.confirmo_que_a_senha_é_criada_com_sucesso()"
});
formatter.result({
  "duration": 5051120137,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insiro_CPF()"
});
formatter.result({
  "duration": 2493943485,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_Nome_Completo_Data_de_nascimento_Sexo_Estado_civil()"
});
formatter.result({
  "duration": 1598855560,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_Nome_da_Mãe_nome_do_pai_Nacionalidade_Estado_Cidade()"
});
formatter.result({
  "duration": 3272043034,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.as_informacoes_de_endereço()"
});
formatter.result({
  "duration": 2200440710,
  "status": "passed"
});
formatter.match({
  "location": "CadastroSteps.insira_as_informações_de_CNH()"
});
formatter.result({
  "duration": 3998896606,
  "status": "passed"
});
formatter.after({
  "duration": 7781546,
  "status": "passed"
});
formatter.after({
  "duration": 1131104582,
  "status": "passed"
});
formatter.uri("login.feature");
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
  "duration": 1394213528,
  "status": "passed"
});
formatter.before({
  "duration": 5588260,
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
  "duration": 4659935946,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.eu_insiro_meu_e_mail_cadastrado()"
});
formatter.result({
  "duration": 15342619737,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element to be clickable: By.xpath: //input[@class\u003d\u0027input inputContainerEmail sfdc_usernameinput input\u0027] (tried for 15 second(s) with 500 MILLISECONDS interval)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:82)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:231)\r\n\tat Commons.Drivers.waitForElementToBeClickable(Drivers.java:155)\r\n\tat PageObjects.LoginPage.inserirEmail(LoginPage.java:39)\r\n\tat Steps.LoginSteps.eu_insiro_meu_e_mail_cadastrado(LoginSteps.java:42)\r\n\tat ✽.Quando eu insiro meu e-mail cadastrado(login.feature:10)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.xpath: //input[@class\u003d\u0027input inputContainerEmail sfdc_usernameinput input\u0027]\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.7.1\u0027, revision: \u00278a0099a\u0027, time: \u00272017-11-06T21:01:39.354Z\u0027\nSystem info: host: \u0027SAO-D1CY9R2\u0027, ip: \u002710.0.75.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711\u0027\nDriver info: driver.version: unknown\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.lambda$findElement$0(ExpectedConditions.java:882)\r\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:408)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:881)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:643)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:640)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:208)\r\n\tat Commons.Drivers.waitForElementToBeClickable(Drivers.java:155)\r\n\tat PageObjects.LoginPage.inserirEmail(LoginPage.java:39)\r\n\tat Steps.LoginSteps.eu_insiro_meu_e_mail_cadastrado(LoginSteps.java:42)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:541)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:763)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:463)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:209)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginSteps.minha_senha()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.clico_no_botão_de_Login()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.eu_devo_logar_com_sucesso_na_aplicação()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 455756228,
  "status": "passed"
});
formatter.after({
  "duration": 1621340924,
  "status": "passed"
});
});