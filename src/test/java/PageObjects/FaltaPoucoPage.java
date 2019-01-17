package PageObjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class FaltaPoucoPage {
	
	protected static By titulo = By.xpath("//b[contains(text(), 'Falta pouco')]");
	protected static By contaCadastrada = By.xpath("//article[@class='slds-card slds-m-top_medium cardBank']");
	protected static By mensagemFaltaPouco = By.xpath("//div[@class='posicaoTexto']");
	protected static By botaoIrParaPaginaInicial = By.xpath("//button[contains(text(), 'Ir para página inicial')]");
	
	public void verificarPaginaFaltaPouco() throws Throwable {
		Reporter.addStepLog("Verificando página Falta Pouco");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página Falta Pouco verificada com sucesso.");
	}
	
	public void verificarExibicaoMensagem() throws Throwable {
		Reporter.addStepLog("Verificando exibição da Mensagem");
		String mensagem = "Estamos validando seus dados e em breve você poderá começar a investir.";
		Drivers.waitForElementToBeVisible(mensagemFaltaPouco);
		Drivers.marcarElemento(mensagemFaltaPouco);
		String mensagemApresentada = Drivers.getText(mensagemFaltaPouco);
		Assert.assertEquals(mensagem, mensagemApresentada);
		Reporter.addStepLog("Mensagem '" + mensagem + "' exibida com sucesso.");
	}
	
	public void verificarIrParaPaginaInicial() throws IOException{
		Reporter.addStepLog("Verificando presença do botão 'Ir para página inicial'");
		Drivers.waitForElementToBeClickable(botaoIrParaPaginaInicial);
		Drivers.scrollToElement(botaoIrParaPaginaInicial);
		Drivers.marcarElemento(botaoIrParaPaginaInicial);
		Reporter.addStepLog("Botão 'Ir para página inicial' verificado com sucesso.");
	}

}
