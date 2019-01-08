package PageObjects;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import Commons.Drivers;
import Steps.Hooks;

public class EmailTemporarioPage extends Drivers {

	Hooks hooks = new Hooks();

	protected static By emailTemporario = By.id("mail");
	protected static By emailRecebido = By.xpath("//a[contains(text(), 'Pi investimentos')]");
	protected static By botaoConfirmeSeuEmail = By.xpath("//a[contains(text(), 'Confirme seu e-mail')]");

	public String urlTempMail = "https://temp-mail.org/pt/";

	public String cadastroDado1 = "Dado que eu tenha um email para cadastro";
	public String cadastroQuando1 = "E valido a informação do e-mail recebido para cadastro";
	
	
	public void irParaUrlTempMail() throws Throwable {
		Reporter.addStepLog("Acessando a página do TempMail");
		Drivers.irParaURL(urlTempMail);
		Drivers.waitForElementToBeClickable(emailTemporario);
		Reporter.addStepLog("Direcionamento realizado com sucesso para a página do TempMail");
	}

	public void armazenaEmail() throws Throwable {
		Reporter.addStepLog("Colhendo informações de e-mail temporário");
		Drivers.coletarValue(emailTemporario);
		hooks.salvaDados(Drivers.coletarValue(emailTemporario));
		Reporter.addStepLog("Coletado e-mail temporário: " + Drivers.coletarValue(emailTemporario));
	}
	
	public void aguardaEmailEConfirma() throws Throwable {
		Reporter.addStepLog("Aguardando recebimento de e-mail temporário");
		Drivers.waitForElementToBeClickable(emailRecebido);
		Drivers.click(emailRecebido);
		Drivers.waitForElementToBeClickable(botaoConfirmeSeuEmail);
		Drivers.scrollToElement(botaoConfirmeSeuEmail);
		Drivers.scrollUp();
		Drivers.implicitlyWait(2);
		Drivers.jsClick(botaoConfirmeSeuEmail);
		Reporter.addStepLog("Email confirmado com sucesso");
	}

}
