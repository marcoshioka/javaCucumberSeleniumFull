package PageObjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;

public class FaltaPoucoPage {
	
	protected static By titulo = By.xpath("//strong[contains(text(), 'Falta pouco')]");
	protected static By contaCadastrada = By.xpath("//article[@class='slds-card slds-m-top_medium cardBank']");
	protected static By mensagemFaltaPouco = By.xpath("//div[contains(text(), 'Por favor, nos envie uma cópia do documento utilizado no cadastro (RG, CNH, RNE) ou outros para: ')]");
	protected static By botaoIrParaCatalogo = By.xpath("//button[contains(text(), 'conhecer o catálogo')]");

	public String urlFaltaPouco = "https://uat-invistacompi.cs17.force.com/s/cadastroprincipal?returnFoto=false";

	public void pularFotoSeguindoParaPaginaFaltaPouco() throws Throwable {
		Reporter.addStepLog("Pulando etapa de upload da foto");
		Drivers.irParaURL(urlFaltaPouco);
		Reporter.addStepLog("Etapa de envio de foto deixada para mais tarde.");
	}


	public void verificarPaginaFaltaPouco() throws Throwable {
		Reporter.addStepLog("Verificando página Falta Pouco");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página Falta Pouco verificada com sucesso.");
	}
	
	public void verificarExibicaoMensagem() throws Throwable {
		Reporter.addStepLog("Verificando exibição da Mensagem");
		String mensagem = "Por favor, nos envie uma cópia do documento utilizado no cadastro (RG, CNH, RNE) ou outros para: ";
		Drivers.waitForElementToBeVisible(mensagemFaltaPouco);
		Drivers.marcarElemento(mensagemFaltaPouco);
		//String mensagemApresentada = Drivers.getText(mensagemFaltaPouco);
		//Assert.assertEquals(mensagem, mensagemApresentada);
		Reporter.addStepLog("Mensagem de falta pouco exibida com sucesso.");
	}
	
	public void verificarConhecerCatalogo() throws IOException{
		Reporter.addStepLog("Verificando presença do botão 'conhecer o catálogo'");
		Drivers.waitForElementToBeClickable(botaoIrParaCatalogo);
		Drivers.scrollToElement(botaoIrParaCatalogo);
		Drivers.marcarElemento(botaoIrParaCatalogo);
		Reporter.addStepLog("Botão 'conhecer o catálogo' verificado com sucesso.");
	}

}
