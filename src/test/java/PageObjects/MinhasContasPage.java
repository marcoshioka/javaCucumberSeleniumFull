package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class MinhasContasPage {

	protected static By titulo = By.xpath("//span[contains(text(),'Minhas contas')]");
	protected static By contaCadastrada = By.xpath("//article[@class='slds-card slds-m-top_medium cardBank']");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public void verificarPaginaMinhasContas() throws Throwable {
		Reporter.addStepLog("Verificando página Minhas Contas");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página Minhas Contas verificada com sucesso.");
	}
	
	public void verificarExibicaoContaCadastrada() throws Throwable {
		Reporter.addStepLog("Verificando exibição da conta cadastrada");
		Drivers.waitForElementToBeVisible(contaCadastrada);
		Drivers.marcarElemento(contaCadastrada);
		Reporter.addStepLog("Conta Cadastrada exibida com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}
	
}
