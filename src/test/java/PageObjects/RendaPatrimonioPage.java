package PageObjects;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Commons.Sorting;
import Steps.Hooks;

public class RendaPatrimonioPage {
	Hooks hooks = new Hooks();

	Sorting sorting = new Sorting();

	Faker faker = new Faker(new Locale("pt-BR"));

	protected static By titulo = By.xpath("//b[contains(text(), 'sua renda e seu patrimônio')]");
	protected static By campoRendaMensal = By.xpath("//label[contains(text(), 'Minha renda mensal')]/ancestor::lightning-input/div/input[@type='text']");
	protected static By naoPossuoPatrimonio = By.xpath("//span[contains(text(), 'Não possuo patrimônio')]");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");
	
	public void verificarPaginaRendaPatrimonio() throws Throwable {
		Reporter.addStepLog("Verificando página de Renda e Patrimônio");
		Drivers.waitForElementToBeVisible(titulo);
		Drivers.marcarElemento(titulo);
		Reporter.addStepLog("Página de Renda e Patrimônio verificada com sucesso.");
	}
	
	public void insereRendaMensal() throws IOException {
		Reporter.addStepLog("Inserindo número do endereço");
		Drivers.waitForElementToBeVisible(campoRendaMensal);
		String renda = faker.number().digits(6);
		Double d = Double.parseDouble(renda);
		Drivers.sendKeys(campoRendaMensal, renda);
		Reporter.addStepLog("Renda mensal R$ " + d/100 + " inserida com sucesso.");
	}
	
	public void selecionaNaoPossuoPatrimonio() throws IOException {
		Reporter.addStepLog("Selecionando 'Não possuo patrimônio'");
		Drivers.click(naoPossuoPatrimonio);
		Reporter.addStepLog("'Não possuo patrimonio' selecionado com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}
	
}
