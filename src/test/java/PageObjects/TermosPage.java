package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class TermosPage {

	protected static By titulo = By.xpath("//h2/b[contains(text(), 'termos')]");
	protected static By declaracaoResidencia = By.xpath("//b[contains(text(),'declaração de residência')]/ancestor::span/ancestor::div[@class='alinhamentoDescricaoCheckbox']/preceding-sibling::div//span//label[@class='slds-checkbox__label']");
	protected static By condicoesGerais = By.xpath(
			"//b[contains(text(),'Condições Gerais')]/ancestor::span/ancestor::div[@class='alinhamentoDescricaoCheckbox']/preceding-sibling::div//span//label[@class='slds-checkbox__label']");
	protected static By regrasParametro = By.xpath(
			"//b[contains(text(),'Regras e Parâmetro')]/ancestor::span/ancestor::div[@class='alinhamentoDescricaoCheckbox']/preceding-sibling::div//span//label[@class='slds-checkbox__label']");
	protected static By adesao = By.xpath(
			"//span[contains(text(),'plenamente de acordo')]/ancestor::div[@class='alinhamentoDescricaoCheckbox']/preceding-sibling::div//span//label[@class='slds-checkbox__label']");

	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public void verificarPaginaTermos() throws Throwable {
		Reporter.addStepLog("Verificando página de Termos");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página de Termos verificada com sucesso.");
	}

	public void aceitarTermoDeclaracaoResidencia() throws IOException {
		Reporter.addStepLog("Aceitando termo de Declaração de Residência");
		Drivers.click(declaracaoResidencia);
		Reporter.addStepLog("Termo de Declaração de Residência aceito com sucesso.");
	}

	public void aceitarTermoCondicoesGerais() throws IOException {
		Reporter.addStepLog("Aceitando termo de Condições Gerais - Intermediação");
		Drivers.click(condicoesGerais);
		Reporter.addStepLog("Termo de Condições Gerais - Intermediação aceito com sucesso.");
	}

	public void aceitarTermoRegrasParametro() throws IOException {
		Reporter.addStepLog("Aceitando termo de Regras e Parâmetro");
		Drivers.click(regrasParametro);
		Reporter.addStepLog("Termo de Regras e Parâmetro aceito com sucesso.");
	}

	public void aceitarTermoAdesao() throws IOException {
		Reporter.addStepLog("Aceitando termo de Adesão");
		Drivers.click(adesao);
		Reporter.addStepLog("Termo de Adesão aceito com sucesso.");
	}


	public void clicaSeguir() throws IOException {
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.jsClick(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}
}
