package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class PoliticamenteExpostoPage {
	
	protected static By titulo = By.xpath("//h2[contains(text(), 'conte')]/b[contains(text(), 'politicamente exposto')]");
	protected static By botaoNao = By.xpath("//button[contains(text(), 'Não')]");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public void verificarPaginaPoliticamenteExposto() throws Throwable {
		Reporter.addStepLog("Verificando página de politicamente exposto");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página de politicamente exposto verificada com sucesso.");
	}
	
	public void clicarBotaoNao() throws Throwable {
		Reporter.addStepLog("Clicando no botão 'Não'");
		Drivers.click(botaoNao);
		Reporter.addStepLog("Botão 'Não' acionado com sucesso.");
	}

	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}
	
}
