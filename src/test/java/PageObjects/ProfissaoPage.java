package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;
import org.openqa.selenium.Keys;

public class ProfissaoPage extends Drivers{
	protected static By titulo = By.xpath("//span[contains(text(), 'profissão')]");
	protected static By campoAreaAtuacao = By.xpath("//span[contains(text(), 'Área de atuação')]/ancestor::label/following-sibling::input");
	protected static By opcaoAnalistaDeSistemas = By.xpath("//button[contains(text(), 'Analista de Sistemas')]");
	protected static By campoInstituicaoDeTrabalho = By.xpath("//input[@placeholder='Instituição onde trabalha']");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public void verificarPaginaProfissao() throws Throwable {
		Reporter.addStepLog("Verificando página de profissão");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página de profissão verificada com sucesso");
	}
	
	public void selecionarProfissaoAnalistaDeSistemas() throws Throwable {
		Reporter.addStepLog("Selecionando profissão 'Analista de Sistemas'");
		Drivers.sendKeys(campoAreaAtuacao, "Analista de Sistemas");
		Drivers.DRIVER.findElement(campoAreaAtuacao).sendKeys(Keys.CONTROL);
		Drivers.waitForElementToBeVisible(opcaoAnalistaDeSistemas);
		Drivers.jsClick(opcaoAnalistaDeSistemas);
		Reporter.addStepLog("Profissão 'Analista de Sistemas' selecionada com sucesso.");
	}
	
	public void informarInstituicaoOndeTrabalha() throws Throwable {
		Reporter.addStepLog("Informando instituição onde trabalha");
		Drivers.sendKeys(campoInstituicaoDeTrabalho, "Pi");
		Reporter.addStepLog("Instituição 'Pi' informada com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}
	
}
