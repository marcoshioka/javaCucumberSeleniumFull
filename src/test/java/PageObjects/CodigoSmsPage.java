package PageObjects;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class CodigoSmsPage {

	
	protected static By titulo = By.xpath("//h2[contains(text(), 'Mandamos um')]/b[contains(text(), 'SMS')]");
	protected static By tentarMaisTarde = By.xpath("//button[contains(text(), 'Tentar mais tarde')]");

	
	public void verificarPaginaSms() throws Throwable {
		Reporter.addStepLog("Verificando página SMS");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página do código SMS verificada com sucesso");
	}
	
	public void clicarTentarMaisTarde() throws Throwable {
		Reporter.addStepLog("Clicando em 'Tentar mais tarde'");
		Drivers.click(tentarMaisTarde);
		Reporter.addStepLog("'Tentar mais tarde' acionado com sucesso");
	}
	

}
